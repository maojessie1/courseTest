package course;

import Util.ProUtil;
import Util.ProsUtil;
import cases.BaseCase;
import handle.LoginHandle;
import org.openqa.grid.common.SeleniumProtocol;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.SeleniumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 评价：
 * 1个课程跑15-22个人的评价，每个人评价一次。评价不重复。
 */


public class courseEvaluate extends BaseCase {

    public static int count = 0;
    public static final String COURES = "course";
    public static final String HOME_URL = "https://www.zlpx.cn/#/home";

    private static int commentIndex = 413 + 197 + 154;
    private static int userCount = 1;
    public WebDriver driver;
    LoginHandle loginHandle;

    @BeforeClass
    public void BeforeClass() {
        System.out.println("hhh1");
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver = setBrowser("chrome");
        driver.get(HOME_URL);
        driver.manage().window().maximize();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginHandle = new LoginHandle(driver);
    }

    List<WebElement> elements;

    @Test
    public void testStart() {
        try {

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            ProsUtil evaluateStr = new ProsUtil("E:/courseClick/src/main/resources/evaluate.properties");
            int evaSize = evaluateStr.size();
            System.out.println("评价总数：" + evaSize);

            ProUtil userNameList = new ProUtil("E:\\courseClick\\src\\main\\resources\\userName.properties");
            int userSize = userNameList.size();
            System.out.println("用户数:" + userSize);


            Set commentSet = new HashSet(58 * 22);
            //获取课程列表
            ProUtil courseList = new ProUtil("E:\\courseClick\\src\\main\\resources\\evaluateId.properties");
            System.out.println("课程数：" + courseList.size());
            Random random = new Random();

            //课程
            for (int i = 39; i <= courseList.size(); i++) {
                String courseUrl = courseList.getP(COURES + i);
                System.out.println("要评价的课程名称：" + courseUrl);
                driver.get(HOME_URL);

                //找人15-22
                int userRan = random.nextInt(7) + 15;
                System.out.println("课程" + i + "，随机到的用户循环次数为：" + userRan);
                for (int j = 1; j <= userRan; j++) {

                    //随机找人，如果已经用过，更换!
                    int rpoint = random.nextInt(userSize - 200) + 100;
                    while (commentSet.contains(rpoint)) {
                        System.out.println(rpoint + ",已经用过评价，重新找人");
                        rpoint = random.nextInt(userSize);

                    }
                    commentSet.add(rpoint);
                    System.out.println("课程" + i + "，选择人编号:" + rpoint + "进行评论");

                    try {
                        //登录
                        String userName = userNameList.getP("user" + rpoint);
                        System.out.println("第" + rpoint + "个用户: " + userName);

                        driver.findElement(By.xpath("//*[@id=\"header-box\"]/div[1]/div[2]/div/div/span[1]")).click();

                        try {
                            loginHandle.username(userName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        loginHandle.password();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        WebElement isInLoginPageElement = null;
                        try {
                            isInLoginPageElement = driver.findElement(By.xpath("//*[@id=\"header-box\"]/div[1]/div[2]/div/div/span[1]"));
                        } catch (Throwable e) {
                            System.out.println("执行正常........");
                        }
//                    还在登录页面，表示未登录成功，使用下一个账号继续登录
                        if (isInLoginPageElement != null) {
                            System.out.println(userName + ",未登录成功，继续下一个用户");
                            driver.navigate().refresh();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            continue;
                        }
                        System.out.println(userName + ",登录成功");
                        //进入课程
                        driver.get(courseUrl);
                        //评价

                        driver.findElement(By.xpath("//*[@id=\"tab-second\"]")).click();

                        driver.findElement(By.xpath("//*[@id=\"pane-second\"]/div/div[1]/div[2]/button")).click();

                        int nowCommentIndex = commentIndex++;
                        String evaStr = evaluateStr.getP("eva" + nowCommentIndex % evaSize);
                        System.out.println("要评价的内容是" + evaStr);
                        WebElement click = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[5]/div")).findElement(By.xpath("//*[@id=\"app\"]/div/div/div[5]/div/div[2]/div/div[4]"));
                        click.click();
                        try {
                            String js = "var sum=document.getElementById('text_ct'); sum.value='" + evaStr + "';";
                            ((JavascriptExecutor) driver).executeScript(js);
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        try {
                            driver.findElement(By.linkText("确定")).click();
                        } catch (Exception e) {
                            driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[5]/div/div[3]/div/button[2]")).click();
                        }


                        count += 1;
                        System.out.println("当前成功条数：" + count);


                    } catch (Exception e) {
                        System.out.println("-----------------课程" + i + "，选择人:" + rpoint + "评论失败了哦！");
                    }
                    //退出

                    driver.get("https://www.zlpx.cn/#/homeCourses");

                    Actions actions = new Actions(driver);
                    WebElement element = driver.findElement(By.className("login-user"));
                    actions.moveToElement(element).perform();

                    driver.findElement(By.className("el-dropdown-menu__item")).click();
                }
            }
        }finally {
            driver.quit();
        }
    }

    @AfterMethod
    public void end() {
        System.out.println("end");
    }
}
package cases;

import Util.ProUtil;
import handle.LoginHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * 学习固定4个视频课程，每个课程全部循环完成。课程完成100%
 */
public class Test1byAllClick extends BaseCase {

    public WebDriver driver;
    LoginHandle loginHandle;

    DesiredCapabilities sCaps = new DesiredCapabilities();

    @BeforeClass
    public void BeforeClass() {
        System.out.println("hhh1");
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver = setBrowser("chrome");
        driver.get("https://www.zlpx.cn/#/home");
        driver.manage().window().maximize();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginHandle = new LoginHandle(driver);
    }

    List<WebElement> elements;

    public static int random() {
        int random = (int) (Math.random() * 60 * 6000);
        System.out.println("random:" + random);
        return random;
    }

    public static void getThreadTime() {
        try {
            Thread.sleep(random());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //    @Test
    public void testStart(int start, int end) {
//        public void testStart() {
        ProUtil proUtil = new ProUtil("E:\\courseClickUpdate\\courseClick\\src\\main\\resources\\userName.properties");
        int size = proUtil.size();
        String username;
        System.out.println("用户数:" + size);


        for (int i = start; i <= end; i++) {
            username = proUtil.getP("user" + i);
            System.out.println("第" + i + "个用户: " + username);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                driver.findElement(By.linkText("登录")).click();
            } catch (Exception e) {
                try {
                    driver.findElement(By.xpath("//*[@id=\"header-box\"]/div[1]/div[2]/div/div/span[1]")).click();
                    //loginHandle.loginButton();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
//            loginHandle.loginButton();
            loginHandle.username(username);
            loginHandle.password();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ProUtil courseList = new ProUtil("E:\\courseClickUpdate\\courseClick\\src\\main\\resources\\course3.properties");

            int courseSize = courseList.size();
            System.out.println("课程数量是size：" + courseSize);
            for (int c = 1; c <= courseSize; c++) {
                WebElement lastOpenTap = null;
                String courseName = courseList.getP("coures" + c);
                System.out.println("课程名称是：" + courseName);
                driver.get(courseName);
                driver.navigate().refresh();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elements = driver.findElements(By.className("el-tree-node__content"));
                int directorySize = elements.size();
                System.out.println("目录size:" + directorySize);

                for (int j = 0; j < directorySize; j++) {
                    WebElement element = elements.get(j);
                    String attribute = null;
                    try {
                        attribute = element.getCssValue("padding-left");
                    } catch (Exception e) {
                        System.out.println("没找到padding");
                        continue;
                    }
                    System.out.println(elements.get(j).getText() + "----attribute:" + attribute);
                    String px = attribute.replaceAll("px", "");
                    System.out.println("取到的attribute是：" + px);
                    elements = driver.findElements(By.className("el-tree-node__content"));

                    if (px.equals("0")) {
                        elements = driver.findElements(By.className("el-tree-node__content"));
                        if (lastOpenTap != null) {
                            lastOpenTap.click();
                        }
                        lastOpenTap = elements.get(j);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        String text = elements.get(j).getText();
                        System.out.println("目录名称:" + text);
                        if (j != 0) {
                            System.out.println("目录名称:" + text + ",click!");
                            elements.get(j).click();
                            elements = driver.findElements(By.className("el-tree-node__content"));
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        String text = elements.get(j).getText();
                        System.out.println("目录名称:" + text);
                        elements.get(j).click();
                        try {
//                            视频太长，等待视频加载中......
                            System.out.println("视频加载中...........");
                            Thread.sleep(30000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        driver.findElement(By.xpath("//*[@id=\"box\"]/div[1]/div[3]/div[2]")).click();
//                        这个时间等待随机取配置文件
//                        getThreadTime();

                        Random random = new Random();
                        long randNumber = random.nextInt(100000) + 2940000;
                        System.out.println("等待时间："+randNumber);
                        try {
                            Thread.sleep(randNumber);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                elements = driver.findElements(By.className("el-tree-node__content"));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            /**
             * 退出登录操作
             */
            driver.get("https://www.zlpx.cn/#/homeCourses");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(By.className("login-user"));
            actions.moveToElement(element).perform();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.className("el-dropdown-menu__item")).click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        testStart(10101, 10150);
    }

    //2222222222222222222222222222222222222===================
    @Test
    public void test2() {
        testStart(10151,10180);
    }

    //3333333333333333333333=========================
    @Test
    public void test3() {
        testStart(10182,10200);
    }
}


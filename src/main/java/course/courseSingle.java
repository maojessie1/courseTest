package course;

import Util.ProUtil;
import cases.BaseCase;
import handle.LoginHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/**
 * 一个人学习5门课，每门课学习1个目录，每个目录学习时间8s...........
 */
public class courseSingle extends BaseCase {

    public WebDriver driver;
    LoginHandle loginHandle;

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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginHandle = new LoginHandle(driver);
    }

    @Test
    public void test1() {
        testStart(20001, 22000);
    }

    @Test
    public void test2() {
        testStart(22001, 23000);
    }

    @Test
    public void test3() {
        testStart(23001, 24000);
    }

    public void testStart(int start, int end) {
        ProUtil proUtil = new ProUtil("E:\\courseClick\\src\\main\\resources\\userName.properties");
        int size = proUtil.size();
        String username;
        System.out.println("用户数:" + size);


        for (int i = start; i <= end; i++) {
            username = proUtil.getP("user" + i);
            System.out.println("第" + i + "个用户: " + username);
            loginHandle.loginButton();
            loginHandle.username(username);
            loginHandle.password();
//            loginHandle.enter();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ProUtil proUtil1 = new ProUtil("E:\\courseClick\\src\\main\\resources\\courseAll.properties");
            for (int c = 1; c < 5; c++) {
                int x = 1 + (int) (Math.random() * 60);
                System.out.println("随机数是：" + x);
                String courseName = proUtil1.getP("coures" + x);
                System.out.println("随机课程名称是：" + courseName);
                driver.get(courseName);
                driver.navigate().refresh();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    loginHandle.getmoKuaiOne1Click();
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    loginHandle.vedio1();
                } catch (Exception e) {
                    try {
                        driver.findElement(By.xpath("//*[@id=\"box\"]/div[1]/div[3]/div[2]")).click();
                    } catch (Exception ex) {
                        System.out.println("跳过...");
                        continue;
                    }
                }
                System.out.println("等待8s............");
                Random random = new Random();
                int timeRan = random.nextInt(50000) + 12000;
                System.out.println("随机时间："+ timeRan);
                try {
                    Thread.sleep(timeRan);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

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
            System.out.println("当前用户退出成功！！！");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
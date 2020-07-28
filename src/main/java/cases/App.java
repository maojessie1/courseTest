package cases;

import Util.ProUtil;
import handle.LoginHandle;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * 学习一门课，每门课学习一个目录，等待5s....
 */
public class App extends BaseCase {
    public WebDriver driver;
    LoginHandle loginHandle;
    public static String home_url = "https://www.zlpx.cn/#/home";
    public static String home_course = "https://www.zlpx.cn/#/homeCourses";

    @BeforeClass
    public void BeforeClass() {
        System.out.println("hhh1");
    }

    @BeforeMethod
    public void BeforeMethod() {
        driver = setBrowser("chrome");
        driver.get(home_url);
        driver.manage().window().maximize();
        loginHandle = new LoginHandle(driver);
    }

    @Test
    public void getUser() {
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            ProUtil proUtil = new ProUtil("E:\\courseClick\\src\\main\\resources\\userList.properties");
            int size = proUtil.size();
            String username;
            System.out.println(size);
            for (int i = 1; i <= size; i++) {
                driver.get(home_url);
                username = proUtil.getP("user" + i);
                System.out.println("userName: " + username);
                loginHandle.loginButton();
                loginHandle.username(username);
                loginHandle.password();

                ProUtil proUtil1 = new ProUtil("E:\\courseClick\\src\\main\\resources\\courseId.properties");
                for (int j = 2; j < proUtil1.size(); j++) {
                    if (j == 2) {
                        String courseUrl = proUtil1.getP("coures" + j);
                        System.out.println("courseUrl: " + courseUrl);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        driver.get(courseUrl);
                        driver.navigate().refresh();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loginHandle.getmoKuaiOne1Click();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loginHandle.vedio1();

                    } else {
                        String courseUrl = proUtil1.getP("coures" + j);
                        System.out.println("courseUrl: " + courseUrl);
                        driver.get(courseUrl);
                        driver.navigate().refresh();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loginHandle.getmoKuaiOne1Click();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loginHandle.vedio1();
                    }
                }
                driver.get(home_course);
                driver.navigate().refresh();
                Actions actions = new Actions(driver);
                WebElement loginUse = loginHandle.getloginUse();
                actions.moveToElement(loginUse).perform();
                loginHandle.getlogOut();
            }

        } finally {
            driver.quit();
        }
    }

    @AfterMethod
    public void end() {
        //退出
        System.out.println("end");
    }
}

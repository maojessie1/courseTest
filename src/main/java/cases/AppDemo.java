package cases;

import Util.ProUtil;
import handle.LoginHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class AppDemo extends BaseCase {
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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginHandle = new LoginHandle(driver);
    }

    public void test1() {
        System.out.println("hhh");
        loginHandle.loginButton();
        loginHandle.username("s0202");
        loginHandle.password();
//        loginHandle.enter();
    }

    @Test
    public void getUser() {
        ProUtil proUtil = new ProUtil("C:\\Users\\Lenovo\\IdeaProjects\\courseClick\\src\\main\\resources\\userList.properties");
        int size = proUtil.size();
        String username;
        System.out.println(size);
        for (int i = 1; i <= size; i++) {
            driver.get("https://www.zlpx.cn/#/home");
            username = proUtil.getP("user" + i);
            System.out.println("userName: " + username);
            loginHandle.loginButton();
            loginHandle.username(username);
            loginHandle.password();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ProUtil proUtil1 = new ProUtil("C:\\Users\\Lenovo\\IdeaProjects\\courseClick\\src\\main\\resources\\courseId.properties");
            for (int j = 2; j < proUtil1.size(); j++) {
                if (j == 2) {
                    String courseUrl = proUtil1.getP("coures" + j);
                    System.out.println("courseUrl: " + courseUrl);
                    driver.get(courseUrl);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //*[@id="box"]/div[1]/div[2]/div[2]/div/div[4]/div[1]
//                    driver.findElement(By.xpath("//*[@id=\"box\"]/div[1]/div[2]/div[2]/div/div[4]/div[1]"))


                    loginHandle.getmoKuaiOne1Click();
                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    loginHandle.vedio1();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    loginHandle.moKuaiOne2Click();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    loginHandle.vedio1();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    loginHandle.getmoKuaiSenElementClick();//目录2
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    loginHandle.getmoKuaiSen1ElementClick();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    loginHandle.vedio1();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    String courseUrl = proUtil1.getP("coures" + j);
                    System.out.println("courseUrl: " + courseUrl);
                    driver.get(courseUrl);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    loginHandle.getmoKuaiOne1Click();
                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    loginHandle.vedio1();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    loginHandle.moKuaiOne2Click();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    loginHandle.vedio1();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /*loginHandle.getmoKuaiSenElementClick();//目录2
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/
                    loginHandle.getmoKuaiSen1ElementClick();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    loginHandle.vedio1();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            driver.get("https://www.zlpx.cn/#/homeCourses");
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(By.className("login-user"));
            actions.moveToElement(element).perform();
            try {
                Thread.sleep(3000);
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

    @AfterMethod
    public void end() {
        //退出

        System.out.println("end");
    }
}

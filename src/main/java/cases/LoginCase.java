package cases;

import Util.ProUtil;
import handle.LoginHandle;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class LoginCase extends BaseCase {

    public WebDriver driver;
    LoginHandle loginHandle;

    public void sleep20000() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep2000() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void init() {
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


    public void getUserName() {
        init();
        ProUtil proUtil = new ProUtil("C:\\Users\\Lenovo\\IdeaProjects\\courseClick\\src\\main\\resources\\userList.properties");
        int size = proUtil.size();
        String username;
        System.out.println(size);
        for (int i = 1; i < size; i++) {
            username = proUtil.getP("user" + i);
            loginHandle.loginButton();
            loginHandle.username(username);
            loginHandle.password();
//            loginHandle.enter();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void test3() {
        getUserName();
        driver.get("https://www.zlpx.cn/#/homeCourses");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loginHandle.getlearnClassAllClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击立即学习
        loginHandle.getnowLearnClick();
        sleep20000();

        loginHandle.getmoKuaiOne1Click();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginHandle.vedio1();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      /*  loginHandle.moKuaiOne2Click();
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
        loginHandle.getmoKuaiSenElementClick();//目录2*/
        sleep2000();
    }



    @AfterClass
    public void after() {

        System.out.println("end.........................");
    }
}

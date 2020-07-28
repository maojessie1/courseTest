package cases;

import Util.ProUtil;
import handle.LoginHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginCase1 extends BaseCase {

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

    @BeforeClass
    public void init() {
        driver = setBrowser("chrome");
        driver.get("https://www.zlpx.cn/#/home");
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginHandle = new LoginHandle(driver);
    }

    @Test
    public void getUserName() {
        String username = null;
        ProUtil proUtil = new ProUtil("C:\\Users\\Lenovo\\IdeaProjects\\courseClick\\src\\main\\resources\\userList.properties");
        int size = proUtil.size();
        System.out.println(size);
        for (int i = 1; i < size; i++) {
            username = proUtil.getP("user" + i);

            loginHandle.loginButton();
            loginHandle.username(username);
            loginHandle.password();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.get("https://www.zlpx.cn/#/homeCourses");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

     /*   ProUtil proUtil = new ProUtil("C:\\Users\\Lenovo\\IdeaProjects\\courseClick\\src\\main\\resources\\courseId.properties");
        int size = proUtil.size();
        System.out.println(size);
//        String username;
        for (int i = 1; i < size; i++) {
            String urlCourse = proUtil.getP("coures" + i);
//            String urlCourse = proUtil.getP("coures1");
//            username = urlCourse.split("=")[0];
            driver.get(urlCourse);
//        driver.get("https://www.zlpx.cn/#/switch/courseware?id=46");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
            //第一个目录
        /*loginHandle.getmoKuaiOneClick();
        sleep2000();*/

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

            /**
             * 目录2
             */

            loginHandle.getmoKuaiSenElementClick();//目录2
            sleep2000();
        /*loginHandle.getmoKuaiSen1ElementClick();//目录2-1
        sleep20000();
        loginHandle.vedio1();
        sleep2000();
        loginHandle.getmoKuaiSen2ElementClick();//目录2-2
        sleep20000();
        loginHandle.vedio1();
        sleep2000();
        loginHandle.getmoKuaiThreeElementClick();//目录3
        sleep2000();
        loginHandle.getmoKuaiThree1ElementClick();//目录3-1
        sleep20000();
        loginHandle.vedio1();
        sleep2000();
        loginHandle.getmoKuaiThree2ElementClick();//目录3-2
        sleep20000();
        loginHandle.vedio1();
        sleep2000();*/

        }
    }

    @AfterClass
    public void after() {

        System.out.println("end.........................");
    }
}

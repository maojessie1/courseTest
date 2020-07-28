package cases;

import Util.ProUtil;
import handle.LoginHandle;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 extends BaseCase {
    //*[@id="box"]/div[1]/div[2]/div[2]/div[1]
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginHandle = new LoginHandle(driver);
    }

    List<WebElement> elements;

    public static int random() {
        int random = (int) (Math.random() * 60 * 5000);
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


    @Test
    public void test1() {
        ProUtil proUtil = new ProUtil("E:\\courseClick\\src\\main\\resources\\userName.properties");
//        ProUtil proUtil = new ProUtil("E:\\courseClickUpdate\\courseClick\\src\\main\\resources\\userList.properties");
        int size = proUtil.size();
        String username;
        System.out.println("用户数:" + size);


        for (int i = 150; i <= 189; i++) {
            username = proUtil.getP("user" + i);
            System.out.println("第" + i + "个用户: " + username);
            loginHandle.loginButton();
            loginHandle.username(username);
            loginHandle.password();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            WebElement isInLoginPageElement = null;
            try {
                isInLoginPageElement = driver.findElement(By.xpath("//*[@id=\"header-box\"]/div[1]/div[2]/div/div/span[1]"));
            } catch (Throwable e) {
                System.out.println("执行正常........");
            }
//还在登录页面，表示未登录成功，使用下一个账号继续登录
            if ( isInLoginPageElement != null ){
                System.out.println(  username + ",未登录成功，继续下一个用户");
                driver.navigate().refresh();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            System.out.println(  username + ",登录成功");

            ProUtil proUtil1 = new ProUtil("E:\\courseClick\\src\\main\\resources\\courseId.properties");
//            ProUtil proUtil1 = new ProUtil("E:\\courseClickUpdate\\courseClick\\src\\main\\resources\\courseId.properties");
//            for (int c = 1; c < proUtil1.size(); c++) {
            for (int c = 1; c < 6; c++) {
                WebElement lastOpenTap = null;
                int x = 1 + (int) (Math.random() * 43);
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

                elements = driver.findElements(By.className("el-tree-node__content"));


                /* List<WebElement> elements = driver.findElements(By.className("span-ellipsis"));*/
                System.out.println("目录数：" + elements.size());
                for (int j = 0; j < elements.size() - 3; j++) {
                    WebElement element = elements.get(j);
                    String attribute = element.getCssValue("padding-left");
                    System.out.println(elements.get(j).getText() + "----attribute:" + attribute);
                    String px = attribute.replaceAll("px", "");
                    System.out.println("取到的attribute是：" + px);
                    elements = driver.findElements(By.className("el-tree-node__content"));

                    /*String value = substring.split("p")[0];
                    System.out.println(value);*/
                    if (px.equals("0")) {
                        elements = driver.findElements(By.className("el-tree-node__content"));
                        if (lastOpenTap != null) {
                            lastOpenTap.click();
                        }
                        lastOpenTap = elements.get(j);
                        try {
                            Thread.sleep(2000);
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
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String text = elements.get(j).getText();
                        System.out.println("目录名称:" + text);
                        elements.get(j).click();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        WebElement show_main = driver.findElement(By.className("show_main"));
                        System.out.println("show_main" + show_main);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        show_main.click();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        getThreadTime();
                        try {
                            Thread.sleep(8000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("等待8s.............");
                    }
                }

                elements = driver.findElements(By.className("el-tree-node__content"));
                try {
                    Thread.sleep(3000);
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
        }
    }
}


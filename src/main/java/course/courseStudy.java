package course;

import Util.ProUtil;
import cases.BaseCase;
import handle.LoginHandle;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * 一个人学习5门课，每门课学习全部目录，每个目录学习时间8s...........
 */
public class courseStudy extends BaseCase {
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

    @Test
    public void test1() {
        ProUtil proUtil = new ProUtil("E:\\courseClick\\src\\main\\resources\\userName.properties");
        int size = proUtil.size();
        String username;
        System.out.println("用户数:" + size);


        for (int i = 150; i <= 189; i++) {
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
            for (int c = 1; c < 4; c++) {
                WebElement lastOpenTap = null;
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

                elements = driver.findElements(By.className("el-tree-node__content"));


                /* List<WebElement> elements = driver.findElements(By.className("span-ellipsis"));*/
                System.out.println("目录数：" + elements.size());
                for (int j = 0; j < elements.size() - 3; j++) {
                    WebElement element = elements.get(j);
                    String attribute = null;
                    try {
                        attribute = element.getCssValue("padding-left");
                    } catch (Exception e) {
                        System.out.println("错误的padding");
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
                        WebElement show_main = null;
                        show_main = driver.findElement(By.className("show_main"));

                        try {
                            Thread.sleep(15000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("视频加载.....15s");
                        try {
                            show_main.click();
                            System.out.println("show_main" + show_main);
                        } catch (Exception e) {
                            System.out.println("视频加载时间过长...点击下一个");
                            continue;
                        }
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


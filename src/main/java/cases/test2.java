package cases;

import Util.ProUtil;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
/*
练习~~~
 */

public class test2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys().sendKeys().contextClick().keyDown("a").build();
        actions.perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").build();
        actions.perform();
        WebElement element = driver.findElement(By.cssSelector("#id>frame"));
        driver.switchTo().frame(element);
        WebElement p = element.findElement(By.tagName("p"));
        p.findElement(By.xpath("")).click();
        driver.switchTo().frame("myframe");
        WebElement p1 = driver.findElement(By.tagName("p"));
        Dimension size = p1.getSize();
        Assert.assertEquals(size, "1");
        Assert.assertEquals(p1.getText(), "hello");
        String title = driver.getTitle();
        Assert.assertEquals(title, "aaa");
//        显示等待
//        WebElement until = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("")));
//        System.out.println(until.getText());
//        隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(19, TimeUnit.SECONDS);

        Alert until1 = new WebDriverWait(driver, 29).until(ExpectedConditions.alertIsPresent());
        until1.sendKeys("dd");
        until1.accept();


        Alert alert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("2");
        alert.dismiss();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("proxy", proxy);
        WebDriver driver2 = new ChromeDriver();
        driver2.get("");

        WebDriver driver1 = new ChromeDriver();
        driver1.navigate().to("");
        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.switchTo().activeElement().getAttribute("title");
        driver.switchTo().activeElement().getAttribute("1");

        boolean h1 = driver.findElement(By.tagName("h1")).isDisplayed();
        Assert.assertEquals(h1, "hello");

        if (!driver.getTitle().equals("ddd")) {
            throw new IllegalStateException("this is not page" + driver.getCurrentUrl());
        }


//        页面对象模式

        FirefoxOptions a1 = null;
        a1.addPreference("s", 0);
        driver = new RemoteWebDriver(a1);
        ChromeOptions co = new ChromeOptions();


        Color.fromString("");
        Color color = Color.fromString(driver.findElement(By.xpath("")).getCssValue(""));

    }

    public void test1() {
        WebDriver driver = null;
        //显示等待1
        WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        //显示等待2
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                return element.getText().toLowerCase().startsWith("navigeate");
            }
        });
        //隐式等待
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}
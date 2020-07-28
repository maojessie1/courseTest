package cases;

import Util.ProUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseCase {
    public WebDriver driver;

    public WebDriver setBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            /**
             * 公司的chrome
             */
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }


}

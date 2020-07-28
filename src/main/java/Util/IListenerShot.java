package Util;

import cases.LoginCase;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IListenerShot extends TestListenerAdapter {



    @Override
    public void onTestSuccess(ITestResult tr) {
        LoginCase instance = (LoginCase) tr.getInstance();
        WebDriver driver = instance.driver;
        getScreen(driver);
        super.onTestSuccess(tr);
        System.out.println("用例正确");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        LoginCase instance = (LoginCase) tr.getInstance();
        WebDriver driver = instance.driver;
        getScreen(driver);
        super.onTestFailure(tr);
        System.out.println("用例错误");
    }

    public void getScreen(WebDriver driver) {

        String ProjectProperty = System.getProperty("user.dir");
        System.out.println(ProjectProperty);
        String name = this.getClass().getName();
        System.out.println(name);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_SSS");
        String format = sdf.format(new Date());
        System.out.println(format);
        String url = name + "_" + format + ".png";
        File screenshotAs = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotAs, new File(ProjectProperty + "\\" + url));
            System.out.println(ProjectProperty + "\\" + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
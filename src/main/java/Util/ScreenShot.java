package Util;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {

    WebDriver driver;

    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    public void getScreen() {

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

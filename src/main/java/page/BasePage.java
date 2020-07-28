package page;

import Util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePage {
    WebDriver driver;
    BasePage(WebDriver driver){
        this.driver = driver;
    }

    public By getElement(String key){
        ProUtil proUtil = new ProUtil("E:\\courseClick\\src\\main\\resources\\element.properties");
        String elementKey = proUtil.getP(key);
        String local = elementKey.split(">")[0];
        String value = elementKey.split(">")[1];
        if (local.equals("id")){
            return By.id(value);
        }else if (local.equals("className")){
            return By.className(value);
        }else if (local.equals("name")){
            return By.name(value);
        }else if (local.equals("xpath")){
            return By.xpath(value);
        }else if (local.equals("linkText")){
            return By.linkText(value);
        }else {
            return By.partialLinkText(value);
        }

    }

    public WebElement getFindElement(String key){
        return driver.findElement(getElement(key));
    }

    public void moveElement(String moveTo){
        Actions actions = new Actions(driver);
        actions.moveToElement(getFindElement(moveTo)).perform();
    }

}

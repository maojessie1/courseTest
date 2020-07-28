package page;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginElement() {
        return getFindElement("loginButton");
    }

    public WebElement getUsernameElement() {
        return getFindElement("userElement");
    }

    public WebElement getPasswordElement() {
        return getFindElement("passwordElement");
    }

    public WebElement getEnterElement() {
        return getFindElement("enterElement");
    }


    public WebElement getmoKuaiOneElement() {
        return getFindElement("moKuaiOne");
    }

    public WebElement getmoKuaiOne1Element() {
        WebElement moKuaiOne1 = new WebDriverWait(driver, 15).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver input) {
                return getFindElement("moKuaiOne1");
            }
        });
        return moKuaiOne1;
    }

    public WebElement getVideoElement() {
        WebElement video1 = new WebDriverWait(driver, 10).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver input) {
                return getFindElement("video1");
            }
        });
        return video1;
    }


    public WebElement getmoKuaiOne2Element() {
        return getFindElement("moKuaiOne2");
    }

    public WebElement getmoKuaiSenElement() {
        return getFindElement("moKuaiSen");
    }

    public WebElement getmoKuaiSen1Element() {
        return getFindElement("moKuaiSen1");
    }

    public WebElement getmoKuaiSen2Element() {
        return getFindElement("moKuaiSen2");
    }

    public WebElement getmoKuaiThreeElement() {
        return getFindElement("moKuaiThree");
    }

    public WebElement getmoKuaiThree1Element() {
        return getFindElement("moKuaiThree1");
    }

    public WebElement getmoKuaiThree2Element() {
        return getFindElement("moKuaiThree2");
    }

    public WebElement getClassElement() {
        return getFindElement("learn");
    }

    public WebElement getnowLearnElement() {
        return getFindElement("nowLearn");
    }

    public WebElement getheadElement() {
        return getFindElement("head");
    }

    public WebElement getOutElement() {
        return getFindElement("out");
    }

    public WebElement getlogOutElement() {
        WebElement logOut = new WebDriverWait(driver, 15).until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver input) {
                return getFindElement("logOut");
            }
        });
        return logOut;
    }

    public WebElement getloginUserElement() {
        WebElement login_user = new WebDriverWait(driver, 29).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver input) {
                return getFindElement("login_user");
            }
        });
        return login_user;
    }

    public void moveElement(){
        moveElement(getlogOutElement)
    }
}

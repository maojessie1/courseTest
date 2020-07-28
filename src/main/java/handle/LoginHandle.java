package handle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LoginPage;

public class LoginHandle {
    LoginPage loginPage;
    WebDriver driver;

    public static int random() {
        int random = (int) (Math.random() * 60 * 10000);
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


    public LoginHandle(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void loginButton() {
        loginPage.getLoginElement().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void username(String username) {


        loginPage.getUsernameElement().sendKeys(username);
    }

    public void password() {
        loginPage.getPasswordElement().sendKeys("123456" + Keys.ENTER);
    }

    /**
     * 省略
     */
 /*   public void enter() {
        loginPage.getEnterElement().click();
    }*/
    public void getmoKuaiOneClick() {
        loginPage.getmoKuaiOneElement().click();
    }

    public void getmoKuaiOne1Click() {
        WebElement element = loginPage.getmoKuaiOne1Element();
        element.click();
    }

    public void vedio1() {

        WebElement videoElement = loginPage.getVideoElement();
        videoElement.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        getThreadTime();

    }
/*
    public void click(){
        WebElement pdf_wrap = driver.findElement(By.className("pdf_wrap"));
        driver.findElement(By.className(""));

    }*/

    public void moKuaiOne2Click() {
        loginPage.getmoKuaiOne2Element().click();
    }

    public void getmoKuaiSenElementClick() {
        loginPage.getmoKuaiSenElement().click();
    }

    public void getmoKuaiSen1ElementClick() {
        loginPage.getmoKuaiSen1Element().click();
    }

    public void getmoKuaiSen2ElementClick() {
        loginPage.getmoKuaiSen2Element().click();
    }

    public void getmoKuaiThreeElementClick() {
        loginPage.getmoKuaiThreeElement().click();
    }

    public void getmoKuaiThree1ElementClick() {
        loginPage.getmoKuaiThree1Element().click();
    }

    public void getmoKuaiThree2ElementClick() {
        loginPage.getmoKuaiThree2Element().click();
    }

    public void getlearnClassAllClick() {
        loginPage.getClassElement().click();
    }

    public void getnowLearnClick() {
        loginPage.getnowLearnElement().click();
    }

    public void getheadClick() {
        loginPage.getheadElement().click();
    }

    public void moveOut() {
        loginPage.moveElement("out");
    }

    public void getOutClick() {
        loginPage.getOutElement().click();
    }

    public WebElement getloginUse() {
        WebElement element = loginPage.getloginUserElement();
        return element;
    }

    public void getlogOut() {
        WebElement element = loginPage.getlogOutElement();
        element.click();
    }

    public void test(){
    }

}

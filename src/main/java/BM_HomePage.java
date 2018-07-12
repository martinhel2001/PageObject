//import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;


public class BM_HomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy (className = "login")
    WebElement btnLogin;

    @FindBy (xpath = "/html/body/div[1]/nav/div[2]/div[2]/ul/li[1]/a")
    WebElement menuCotizaciones;

    @FindBy (className = "account")
    WebElement btnAccount;


    public BM_HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver,20);}




    public void Ingresar(){
        btnLogin.click();
    }

    public boolean verifyCotizaciones() throws InterruptedException {

        //Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(btnAccount));
        if (menuCotizaciones.isDisplayed()) return true; else return false;
    }

}

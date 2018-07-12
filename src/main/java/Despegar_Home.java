import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;

public class Despegar_Home {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "/html/body/div[9]/div/div[1]/div/div[1]/div/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/input")
    WebElement inputOrigen;

    @FindBy(xpath = "/html/body/div[9]/div/div[1]/div/div[1]/div/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/input")
    WebElement inputDestino;

    @FindBy(className = "input-tag sbox-checkin-date")
    WebElement btnFechaChekin;

    @FindBy(className = "fechaCheckout")
    WebElement btnFechaCheckout;

    @FindBy(xpath = "/html/body/div[5]/div/div[4]/div[1]/div[4]/span[18]")
    WebElement fechaCheckin;

    @FindBy(xpath = "/html/body/div[5]/div/div[4]/div[1]/div[4]/span[26]")
    WebElement fechaCheckout;

    @FindBy(className = "btn-text")
    WebElement btnBuscar;

    @FindBy(className = "eva-3-results-list shop-results -banner-aside")
    WebElement grillaResultados;

    @FindBy(className = "as-login-close")
    WebElement botonCerrarPopup;



    public Despegar_Home(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver,20);
        }

    public boolean BuscarDefault(String origen, String destino) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(botonCerrarPopup));
        botonCerrarPopup.click();
        Thread.sleep(800);
        wait.until(ExpectedConditions.elementToBeClickable(inputOrigen));
        inputOrigen.sendKeys(origen);
        inputDestino.sendKeys(destino);
        btnFechaChekin.click();
        fechaCheckin.click();
        btnFechaCheckout.click();
        fechaCheckout.click();
        btnBuscar.click();
        wait.until(ExpectedConditions.elementToBeClickable(grillaResultados));
        if (grillaResultados.isDisplayed()) {
            return true;
        } else return false;
    }


}

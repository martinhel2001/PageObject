import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Despegar_Home_Test extends BaseTest {

    //static WebDriver driver;

    @BeforeClass
    public void abrirApp() throws MalformedURLException {
        driver.get(APPLICATION_URL);
    }

    /*
    public void setup(){
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("http://www.despegar.com.ar");
         }
*/
    @Test
    public void TestBuscarReserva() throws InterruptedException {
        Despegar_Home objDespegarHome = new Despegar_Home(driver);

        boolean trajoResultados = objDespegarHome.BuscarDefault("Buenos Aires, Argentina", "Mar del Plata, Buenos Aires, Argentina");
        Assert.assertTrue(trajoResultados);
    }


}

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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
    ExtentHtmlReporter htmlReporter;
    ExtentReports report;
    ExtentTest logger;



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
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/ExtentReport.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
        logger = report.createTest("CheckURLStatus");
        logger.log(Status.INFO, "Starting Browser instance...");

        Despegar_Home objDespegarHome = new Despegar_Home(driver);

        logger.log(Status.INFO, "Ejecuto la Busqueda Default");

        boolean trajoResultados = objDespegarHome.BuscarDefault("Buenos Aires, Argentina", "Mar del Plata, Buenos Aires, Argentina");
        Assert.assertTrue(trajoResultados);

        logger.log(Status.PASS, "Busqueda exitosa!");
        logger.log(Status.FAIL, "algo no anduvo :(");

        report.flush();
    }


}

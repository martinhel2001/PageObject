import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseTest {

    public static WebDriver driver;

    protected static String BROWSER;
    protected static int IMPLICIT_TIMEOUT;
    protected static int FLUENT_TIMEOUT;
    protected static String APPLICATION_URL;

    protected static Logger LOGGER= Logger.getLogger(BaseTest.class.getName());

    @BeforeClass
    public static void setUpTestProperties() {
        Properties prop = new Properties();

        LOGGER.setLevel(Level.INFO);

        try {

            InputStream resourceStream = new FileInputStream("src/main/resources/config.properties");
            prop.load(resourceStream);

            BROWSER = prop.getProperty("browser");
            IMPLICIT_TIMEOUT = Integer.parseInt(prop.getProperty("implicit.wait.timeout"));
            FLUENT_TIMEOUT = Integer.parseInt(prop.getProperty("fluent.wait.timeout"));

            String ambiente = prop.getProperty("test.environment");

            //Ejemplo de cómo levantar configuraciones de test según el ambiente en que se corran las pruebas.
            switch (ambiente){
                case "QA":
                    APPLICATION_URL = "http://qa.despegar.com.ar";
                    //Agregar otras configuraciones (usuario, contraseña, etc.)
                    break;
                case "PROD":
                    //Agregar otras configuraciones si el ambiente fuera PROD
                    APPLICATION_URL = "http://www.despegar.com.ar";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Test Environment");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }



    }


    @BeforeClass (dependsOnMethods = "setUpTestProperties")
    public static void setUpLocalDriver() throws Exception {

        if (BROWSER.equals("Firefox")) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
            LOGGER.info("TEST SETUP OK");

        } else if (BROWSER.equals("Chrome")) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
            LOGGER.info("TEST SETUP OK");
        }
        else { throw new Exception("BROWSER UNKNOWN"); }

    }

    @AfterClass
    public static void tearDownDriver() {
        driver.close();
        driver.quit();
    }





}

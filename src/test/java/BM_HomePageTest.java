import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BM_HomePageTest {




        WebDriver driver;
        @BeforeTest
        public void setup () {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.bullmarketbrokers.com/");
        }

        @Test(priority = 0)
        public void TestBMHome () throws InterruptedException {
            BM_HomePage obj_BM_HomePage = new BM_HomePage(driver);
            Assert.assertTrue(obj_BM_HomePage.verifyCotizaciones());
            obj_BM_HomePage.Ingresar();
            System.out.println("hola2");
        }


    }

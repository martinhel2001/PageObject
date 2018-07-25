import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ExtentReportTesting {

    WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports report;
    ExtentTest logger;

    @Test
    public void f() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/ExtentReport.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);

        logger = report.createTest("CheckURLStatus");

        logger.log(Status.INFO, "Starting Browser instance...");

        driver = new FirefoxDriver();

        logger.log(Status.INFO,"Opening Google now...");
        driver.get("http://www.google.com");

        logger.log(Status.PASS, "Google opens succesfully") ;

        report.flush();
    }


}

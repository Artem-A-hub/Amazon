package init;

/*import io.github.bonigarcia.wdm.WebDriverManager;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Random;

public class WebDriverInit {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeTest
    public void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();

        //Логика, которая будет брать разных юзер агентов при запуске теста (чтобы обойти капчу)
        String[] userAgents = {
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36 OPR/65.0.3467.48",
                "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko",
        };

        int randomIndex = new Random().nextInt(userAgents.length);
        chromeOptions.addArguments("--user-agent=" + userAgents[randomIndex]);

        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void after() {
        driver.quit();
    }

}
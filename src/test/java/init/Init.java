package init;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Random;

public class Init {

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

        Configuration.browserCapabilities = chromeOptions;
        Configuration.timeout = 5000;
    }

    @AfterTest
    public void after() {
        Selenide.closeWebDriver();
    }
}
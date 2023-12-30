package Amazon;

import com.codeborne.selenide.SelenideElement;
import init.Init;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AmazonPageObject extends Init {

    private SelenideElement signInButton = $x("//div[@class='nav-line-1-container']");
    private SelenideElement emailInput = $("#ap_email");
    private SelenideElement continueButton = $("#continue");
    private SelenideElement passwordInput = $("#ap_password");
    private SelenideElement signInSubmitButton = $("#signInSubmit");
    private SelenideElement passwordError = $(".a-box-inner.a-padding-extra-large");

    public void openAmazon() {
        open("https://www.amazon.com/");
        maximizeWindow();
    }

    public void clickSignIn() {
        signInButton.shouldBe(visible).click();
    }

    public void enterEmail(String email) {
        emailInput.shouldBe(visible).clear();
        emailInput.shouldBe(visible).sendKeys(email);
    }

    public void clickContinue() {
        continueButton.shouldBe(visible).click();
    }

    public void enterPassword(String password) {
        passwordInput.shouldBe(visible).clear();
        passwordInput.shouldBe(visible).sendKeys(password);
    }

    public void clickSignInSubmit() {
        signInSubmitButton.shouldBe(visible).click();
    }

    public void waitForPasswordError() {
        passwordError.shouldBe(visible);
    }

    private void maximizeWindow() {
        // разворачивает окно браузера на весь экран
        getWebDriver().manage().window().maximize();
    }
}
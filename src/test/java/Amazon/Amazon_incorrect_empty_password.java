package Amazon;

import init.WebDriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon_incorrect_empty_password extends WebDriverInit {
    @BeforeTest
    public void setup() {
        initDriver();
    }

    @Test
    public void AmazonAuthorization() {
        // Шаг 1: Открыть https://www.amazon.com/
        driver.manage().window().maximize(); // разворачивает окно браузера на весь экран
        driver.get("https://www.amazon.com/");
        // Шаг 2: Кликнуть на кнопку "Sign In"»
        WebElement signInButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='nav-line-1-container']")));
        signInButton.click();
        // Шаг 3: Ввести емейл»
        By emailInputLocator = By.xpath("//input[@id='ap_email']");
        WebElement emailInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
        emailInput.clear();
        emailInput.sendKeys("wajixex362@wenkuu.com");
        // Шаг 4: Нажать на кнопку "Continue"»
        WebElement clickContinue = webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='continue']")));
        clickContinue.click();
        // Шаг 5: Нажать на кнопку "Sign In"»
        WebElement clickSignIn = webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='signInSubmit']")));
        clickSignIn.click();
        //Шаг 6: Проверить, что вывелся тултип об ошибке
        By passwordErrorLocator = By.xpath("//div[@id='auth-password-missing-alert']");
        WebElement passwordError = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(passwordErrorLocator));
    }
}
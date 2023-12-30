package Amazon;

import init.WebDriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Amazon_correct_authorization extends WebDriverInit {

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
        // Шаг 4: Ввести верный пароль
        By passwordInputLocator = By.xpath("//input[@id='ap_password']");
        WebElement passwordInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputLocator));
        passwordInput.clear();
        passwordInput.sendKeys("qwerty");
        // Шаг 4: Нажать на кнопку "Sign In"»
        WebElement clickSignIn = webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='signInSubmit']")));
        clickSignIn.click();
    }
}
package Amazon;

import init.Init;
import org.testng.annotations.Test;

public class Amazon_incorrect_empty_password extends Init {


    @Test
    public void AmazonAuthorization() {
        AmazonPageObject amazonPage = new AmazonPageObject();

        // Шаг 1: Открыть https://www.amazon.com/
        amazonPage.openAmazon();
        // Шаг 2: Кликнуть на кнопку "Sign In"
        amazonPage.clickSignIn();
        // Шаг 3: Ввести емейл
        amazonPage.enterEmail("wajixex362@wenkuu.com");
        // Шаг 4: Нажать на кнопку "Continue"
        amazonPage.clickContinue();
        // Шаг 5: Нажать на кнопку "Sign In"
        amazonPage.clickSignInSubmit();
        // Шаг 6: Проверить, что вывелся тултип об ошибке, что пароль неверный
        amazonPage.waitForPasswordError();
    }
}
package homework32;

import io.qameta.allure.Step;

public class SomeClassForAllureStep {
    @Step("этот метод делает что-то с именем {name}")
    public void someMethod(String name) {
        System.out.println("do something with name " + name);
    }

    @Step("этот метод открывает страницу {url}")
    public void open(String url) {
        System.out.println("open url " + url);
    }
}
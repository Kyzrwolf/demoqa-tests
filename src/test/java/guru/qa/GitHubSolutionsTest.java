package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class GitHubSolutionsTest {
/*
    На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
     Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
*/
    @BeforeAll
    static void configuration() {
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void gitHubSolutionsTest() {
        open("https://github.com/");
        $$("button").findBy(text(" Solutions ")).hover();
        $(byText("Enterprise")).click();
        webdriver().shouldHave(url("https://github.com/enterprise"));
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" +
                "developer platform."));
    }
}

package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {

/*
 - Откройте страницу Selenide в Github
 - Перейдите в раздел Wiki проекта
 - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
 - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
 */

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://github.com";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void jUnitCodeSearchTest() throws InterruptedException {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $$(".markdown-body").filterBy(text("selenide/selenide/wiki/SoftAssertions")).shouldHave(size(0));
        $(byText("Soft assertions")).click();
        /*$$("ul li").get(94).$("a").click()*/; // можете объяснить почему данный способ не работает?

        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}\n"));
        Thread.sleep(5000);
    }
}

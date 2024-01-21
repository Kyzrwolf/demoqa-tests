package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void dragAndDropTest() {
        open("drag_and_drop");
       SelenideElement elementA = $("#column-a");
       SelenideElement elementB = $("#column-b");
        Selenide.actions()
                        .dragAndDrop(elementA,elementB).perform();
        $("#column-a header").shouldHave(textCaseSensitive("B"));
        $("#column-b header").shouldHave(textCaseSensitive("A"));
    }
}

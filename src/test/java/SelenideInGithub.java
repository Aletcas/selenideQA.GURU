import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideInGithub {

    @DisplayName("Открыть страницу SoftAssertions, проверить, что внутри есть пример кода для JUnit5")
    @Test
    void checkForCode() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-rightbar").$(".js-wiki-more-pages-link").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }

    @Test
    @DisplayName("Поменять местами прямоугольники и проверить, что они поменялись местами")
    void checkingTheMovementOfRectangles() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $$("header").first().shouldHave(text("B"));
    }

    // не работает, тест падает, так как действие не происходит
    @Test
    @DisplayName("Поменять местами прямоугольники с помощью мыши и проверить, что они поменялись местами")
    void checkMovingRectanglesWithMouse() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement element = $("#column-b");
        actions().dragAndDropBy(element, -50, 0).perform();
        $$("header").first().shouldHave(text("B"));
    }
}

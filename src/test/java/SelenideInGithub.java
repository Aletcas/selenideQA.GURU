import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideInGithub {

    @Test
    @DisplayName("В списке страниц (Pages) есть страница SoftAssertions")
    void availabilityCheckSoftAssertions() {
        open("https://github.com/selenide/selenide");
        $("a#wiki-tab").click();
        $$(".markdown-body")
                .shouldHave(CollectionCondition.texts("Soft assertions"));
    }

    @Test
    @DisplayName("Проверка, что внутри есть пример кода для JUnit5")
    void checkIfCodeExampleExists() {
        open("https://github.com/selenide/selenide/wiki/SoftAssertions");
        $(".markdown-body")
                .shouldHave(text("How to soft assert using Selenide"));
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

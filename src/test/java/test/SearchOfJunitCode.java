package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchOfJunitCode {
    @Test
    void searchOfJunitCode() {
        Configuration.holdBrowserOpen=true;

        // Открыть страницу гитхаб
        open("https://github.com");
        // Ввести selenide в поиск
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // Перейти на страницу selenide / selenide
        $$("ul.repo-list li").first().$("a").click();
        // Перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        // Раскрыть список Pages
        $(".js-wiki-more-pages-link").click();
        // Проверить что в списке pages есть страница SoftAssertions
        $("#wiki-pages-box").shouldHave(Condition.text("SoftAssertions"));
        // Перейти на страницу SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        // Проверить что на странице есть примеры кода для Junit
        $("#wiki-body").shouldHave(Condition.text("3. Using JUnit5 extend test class:"));
    }
}

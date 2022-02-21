package com.miro.autotests.tests;

import com.miro.autotests.helpers.DriverUtils;
import com.miro.autotests.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @BeforeEach
    void beforeEach() {
        step("Open url 'https://miro.com'", () ->
                open("https://miro.com/"));
    }

    @Test
    @Description("Check the main page title")
    @Feature("Main page")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Page title should have text 'The Visual Collaboration Platform for Every Team | Miro'", () -> {
            String expectedTitle = "The Visual Collaboration Platform for Every Team | Miro";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Description("Check change language")
    @Feature("Main page")
    @DisplayName("Change language button check")
    @ParameterizedTest
    @ValueSource(strings = {"Deutsch",
            "Español",
            "English",
            "Français",
            "Italiano",
            "Português",
            "日本語"})
    void changeLanguageTest(String language) throws InterruptedException {
        mainPage.changeLanguageAndCheckIt(language);
    }

    @Test
    @Description("Check console logs not contains SEVERE")
    @Feature("Main page")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Description("Check benefits slider")
    @Feature("Main page")
    @DisplayName("Change language button check")
    @ParameterizedTest
    @ValueSource(strings = {"Ideation & Brainstorming",
            "Meetings & Workshops",
            "Research & Design",
            "Agile Workflows",
            "Strategy & Planning",
            "Mapping & Diagramming"})
    void shouldBeLogoClickableTest(String benefit) {
        mainPage.selectBenefitAndCheckActivityClass(benefit);
    }
}
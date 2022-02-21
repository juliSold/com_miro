package com.miro.autotests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement languageSwitcherButton = $("nav button[data-testid='SwitcherButton']"),
            languageSwitcherMenu = $("nav div[data-track-place='Language Switcher']");

    ElementsCollection languageSwitcherMenuElements = $$("nav div[data-track-place='Language Switcher'] li"),
            benefitElements = $$(".com-sec-slider-1__navigation-item.js--nav-item");

    @Step("Change language and check")
    public MainPage changeLanguageAndCheckIt(String language) throws InterruptedException {
        languageSwitcherButton.click();
        languageSwitcherMenu.shouldBe(visible);
        languageSwitcherMenuElements.findBy(text(language)).click();

        Thread.sleep(2000);

        languageSwitcherButton.shouldHave(text(languagesProvider().get(language)));

        return this;
    }

    @Step("Select a benefit and check its activity")
    public MainPage selectBenefitAndCheckActivityClass(String benefit) {
        benefitElements.findBy(text(benefit)).scrollIntoView("{block: \"center\"}").shouldBe(visible).click();

        benefitElements.findBy(text(benefit)).shouldHave(cssClass("active"));

        return this;
    }

    private Map<String, String> languagesProvider() {
        Map<String, String> languages = new HashMap<>();
        languages.put("Deutsch", "DE");
        languages.put("Español", "ES");
        languages.put("Français", "FR");
        languages.put("English", "EN");
        languages.put("Italiano", "IT");
        languages.put("日本語", "JA");
        languages.put("Português", "PT");

        return languages;
    }
}

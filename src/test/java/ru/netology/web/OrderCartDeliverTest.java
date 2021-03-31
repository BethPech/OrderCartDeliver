package ru.netology.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class OrderCartDeliverTest {

    @BeforeAll
            static void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
            static void tearDownAll(){
        SelenideLogger.removeListener("allure");
    }

    Date date = new Date();
    String str = String.format("%tc", date);

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").val(str);
        $("[name='name']").setValue("Иванов-Петров Павел");
        $("[name='phone']").setValue("+98765432145");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).shouldBe(visible, Duration.ofSeconds(11));
    }

    @Test
    void shouldFailTestBecauseOfLowCaseLetters() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").val(str);
        $("[name='name']").setValue("ванов-етров авел");
        $("[name='phone']").setValue("+98765432145");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).shouldBe(visible, Duration.ofSeconds(11));
    }
}
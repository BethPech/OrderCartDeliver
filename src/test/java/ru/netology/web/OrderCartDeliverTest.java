package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class OrderCartDeliverTest {
    Date date = new Date();
    String str = String.format("%tc", date);

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("Иванов-Петров Павел");
        $("[name='phone']").setValue("+98765432145");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }
    @Test
    void shouldFailTestBecauseOfLowCaseLetters() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("ванов-етров авел");
        $("[name='phone']").setValue("+98765432145");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }
    @Test
    void shouldNotSubmitRequestBecauseOfWrongCity() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Городец");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("Иванов-Петров Павел");
        $("[name='phone']").setValue("+98765432145");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }



    @Test
    void shouldNotSubmitRequestBecauseOfEmptyCity() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("Иванов-Петров Павел");
        $("[name='phone']").setValue("+98765432145");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }
    @Test
    void shouldFailBecauseOfEnglish() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("Иванов-Петров Pavel");
        $("[name='phone']").setValue("+98765432145");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }
    @Test
    void shouldFailBecauseOfWrongName() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("7896574596");
        $("[name='phone']").setValue("+98765432145");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }
    @Test
    void shouldFailBecauseOfWrongNumberWithoutPlus() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("Иванов-Петров Павел");
        $("[name='phone']").setValue("98765432145");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }
    @Test
    void shouldFailBecauseOfALotOfNumbers() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("Иванов-Петров Павел");
        $("[name='phone']").setValue("+987654321459");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }
    @Test
    void shouldFailBecauseOfALittleOfNumbers() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("Иванов-Петров Павел");
        $("[name='phone']").setValue("+98765432");
        $("[class = 'checkbox__box']").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }
    @Test
    void shouldFailBecauseOfCheckboxAbsence() {
        open("http://localhost:9999");
        $$("input__control");
        $("[placeholder='Город']").setValue("Москва");
        $("[placeholder='Дата встречи']").setValue(str);
        $("[name='name']").setValue("Иванов-Петров Павел");
        $("[name='phone']").setValue("+98765432145");
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(exist);
        $(byText("Успешно!")).waitUntil(visible, 11000);
    }
}

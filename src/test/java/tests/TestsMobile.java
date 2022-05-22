package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class TestsMobile extends TestBase {

    @Test
    @DisplayName("Проверка экранов онбоардинга")
    void firsPagesTest() {
        step("Отображение заголовка первого экрана", () -> {
                $(AppiumBy.id("android:id/title")).shouldHave(text("Welcome to GnuCash"));
        });
        step("Отображение второго экрана", () -> {
                $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
        $(AppiumBy.id("android:id/title")).shouldHave(text("Default Currency"));
        $(AppiumBy.id("android:id/list")).shouldBe(visible);
        });
        step("Отображение заголовка третьего экрана", () -> {
                $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
        $(AppiumBy.id("android:id/title")).shouldHave(text("Account Setup"));
        });
        step("Отображение четвертого экрана", () -> {
                $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
        $(AppiumBy.id("android:id/title")).shouldHave(text("Feedback Options"));
        $(AppiumBy.className("android.widget.CheckedTextView")).click();
        });
        step("Отображение пятого экрана", () -> {
                $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
        $(AppiumBy.id("android:id/title")).shouldHave(text("Review"));
        });
    }

    @Test
    @DisplayName("Проверка поиска на главной странице")
    void searchTest() {
        step("Переход к главной странице", () -> {
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.className("android.widget.CheckedTextView")).click();
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.id("android:id/button1")).click();
        });
        step("Поиск существующего счета", () -> {
            $(AppiumBy.id("org.gnucash.android:id/menu_search")).click();
            $(AppiumBy.id("org.gnucash.android:id/search_src_text")).setValue("Lia");
            $(AppiumBy.id("org.gnucash.android:id/primary_text")).shouldHave(text("Liabilities"));
        });
        step("Поиск не существующего счета", () -> {
            $(AppiumBy.id("org.gnucash.android:id/search_src_text")).setValue("LiaQQ");
            $(AppiumBy.id("org.gnucash.android:id/empty_view")).shouldHave(text("No accounts to display"));
        });
    }

    @Test
    @DisplayName("Проверка операции создания счёта")
    void createAccountTest() {
        step("Переход к главной странице", () -> {
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.className("android.widget.CheckedTextView")).click();
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.id("org.gnucash.android:id/btn_save")).click();
            $(AppiumBy.id("android:id/button1")).click();
        });
        step("Переход к экрану создания счёта", () -> {
            $(AppiumBy.id("org.gnucash.android:id/fab_create_account")).click();
            $(AppiumBy.className("android.widget.TextView")).shouldHave(text("Create Account"));
        });
        step("Создание счёта", () -> {
            $(AppiumBy.id("org.gnucash.android:id/input_account_name")).setValue("AA12");
            $(AppiumBy.id("org.gnucash.android:id/menu_save")).click();
        });
        step("Отображение созданного счёта на главном экране", () -> {
            $(AppiumBy.id("org.gnucash.android:id/menu_search")).click();
            $(AppiumBy.id("org.gnucash.android:id/search_src_text")).setValue("AA1");
            $(AppiumBy.id("org.gnucash.android:id/primary_text")).shouldHave(text("AA12"));
        });
    }
}

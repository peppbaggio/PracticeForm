import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class PracticeFormTests {

    @BeforeAll
    static void configSetup() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

//    @AfterAll
//    static void holdBrowserOpen() {
//        sleep(600_000);
//    }

    @Test
    void practiceFormTests() {
        open("/automation-practice-form");
        $("#firstName").scrollIntoView(true).setValue("Max");
        $("#lastName").scrollIntoView(true).setValue("Frix");
        $("#userEmail").scrollIntoView(true).setValue("frix@frix.ii");
        $("#userNumber").scrollIntoView(true).setValue("1234567890");

        // Поле Gender
        $("[for=gender-radio-1]").scrollIntoView(true).click();

        // Календарь
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--012").click();

        // поле Subjects
        $("#subjectsInput").setValue("Maths").pressEnter();

        // Hobby
        $("[for=hobbies-checkbox-2]").click();

        // Загрузка
        $("#uploadPicture").uploadFromClasspath("img/weather.jpg");

        // Адрес
        $("#currentAddress").scrollIntoView(true).setValue("State Town Street");

        // Штат
        $(byText("Select State")).scrollIntoView(true).click();
        $(byText("Haryana")).scrollIntoView(true).click();
        $(byText("Select City")).scrollIntoView(true).click();
        $(byText("Panipat")).scrollIntoView(true).click();

        $("#submit").scrollIntoView(true).click();


        $(".table-responsive").shouldHave(text("Max Frix"));
        $(".table-responsive").shouldHave(text("frix@frix.ii"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").scrollIntoView(true).shouldHave(text("1234567890"));
        $(".table-responsive").scrollIntoView(true).shouldHave(text("12 December,1998"));
        $(".table-responsive").scrollIntoView(true).shouldHave(text("Maths"));
        $(".table-responsive").scrollIntoView(true).shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("weather.jpg"));
        $(".table-responsive").scrollIntoView(true).shouldHave(text("State Town Street"));
        $(".table-responsive").scrollIntoView(true).shouldHave(text("Haryana")).shouldHave(text("Panipat"));
    }
}

package practiceform;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    // Поля сделаны package-private, чтобы использовать их в качестве
    // параметров в негативном методе
    SelenideElement firstName = $("#firstName");
    SelenideElement lastName = $("#lastName");
    SelenideElement userEmail = $("#userEmail");
    SelenideElement userNumber = $("#userNumber");
    SelenideElement userGender = $("[for=gender-radio-1]");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbies = $("[for=hobbies-checkbox-2]");
    SelenideElement userAddress = $("#currentAddress");
    SelenideElement submitButton = $("#submit");
    SelenideElement resultTable = $(".table-responsive");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstName.scrollIntoView(true).setValue(name);
        return this;
    }

    public RegistrationPage setSurname(String surname) {
        lastName.scrollIntoView(true).setValue(surname);
        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userEmail.scrollIntoView(true).setValue(email);
        return this;
    }

    public RegistrationPage setUserNumber(String number) {
        userNumber.scrollIntoView(true).setValue(number);
        return this;
    }

    public RegistrationPage setUserGender() {
        userGender.scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage setCalendarDate(String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--012").click();
        return this;
    }

    public RegistrationPage clearCalendarDate(String emptySpace) {
        $("#dateOfBirthInput").setValue(emptySpace);

        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies() {
        hobbies.click();
        return this;
    }

    public RegistrationPage uploadPicture(String path) {
        $("#uploadPicture").uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        userAddress.scrollIntoView(true).setValue(address);
        return this;
    }

    public RegistrationPage selectStateAndCity(String state, String city) {
        $(byText("Select State")).scrollIntoView(true).click();
        $(byText(state)).scrollIntoView(true).click();
        $(byText("Select City")).scrollIntoView(true).click();
        $(byText(city)).scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage checkPageOpen(String titleText) {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(titleText));
        return this;
    }

    public RegistrationPage checkPageNotOpen() {
        $(".modal-dialog").shouldNot(appear);

        return this;
    }

    public RegistrationPage submitClick() {
        submitButton.scrollIntoView(true).click();

        return this;
    }


    public RegistrationPage checkResults(String key, String value) {
        resultTable.$(byText(key)).sibling(0).shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkNegativeResults(String key) {
        resultTable.$(byText(key)).sibling(0).shouldBe(empty);

        return this;
    }

    public RegistrationPage checkEmptyRequiredField(SelenideElement field, String cssKey, String cssValue) {
        field.shouldHave(cssValue(cssKey, cssValue));

        return this;
    }


}






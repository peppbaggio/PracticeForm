package fourth;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SelenideGitHubTests {

@BeforeAll
static void configSetup() {
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://github.com";
}

@Test
    void checkSelenidePage() {

    open("/selenide/selenide");
    $("#wiki-tab").click();
    $(byText("Soft assertions")).click();

    $$("h4").findBy(text("3. Using JUnit5 extend test class:")).shouldBe(visible);
}



}

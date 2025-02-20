package selenide.forth;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
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
    void checkSelenidePageTest() {

    open("/selenide/selenide");
    $("#wiki-tab").click();
    $(byText("Soft assertions")).shouldBe(visible).click();

    $$("div h4").findBy(text("3. Using JUnit5 extend test class:")).shouldBe(visible);

    $$("pre").findBy(text("@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}")).scrollIntoView(true) .shouldBe(visible);

        }

}

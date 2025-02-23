package selenide.fifth;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;


public class GitHubEnterprize {


    @BeforeAll
    static void setConfig() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void enterprizePageLoadTest() {
        open("/");
        $$(".HeaderMenu-link").findBy(text(" Solutions ")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text(" Enterprises ")).click();
        $$("#hero-section-brand-heading").findBy(text("The AI-powered")).shouldBe(visible, Duration.ofSeconds(6));

    }

}

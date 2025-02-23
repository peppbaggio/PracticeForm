import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Form1 {

    @BeforeAll
    static void setConfig() {
        Configuration.baseUrl = "https://gregorianika.ru";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkForm() {
        open("/gostyu");
       $("div .sclogin-passwd").shouldBe(visible);
       $("div").$(".sclogin-passwd#sclogin-passwd151").shouldBe(visible);


    }


}

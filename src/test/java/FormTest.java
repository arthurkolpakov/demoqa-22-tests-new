import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Artur");
        $("#lastName").setValue("Kolpakov");
        $("#userEmail").setValue("kolpakovartur91@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9003308519");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("April")).click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--002").click();
        $("#subjectsInput").setValue("QA").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("101.jpg");
        $("#currentAddress").setValue("Cheboksary");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $(".modal-dialog").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(
                text("Artur Kolpakov"),
                text("kolpakovartur91@gmail.com"),
                text("Male"),
                text("9003308519"),
                text("02 Apr 1991"),
                text("QA"),
                text("101.jpg"),
                text("Cheboksary"),
                text("NCR Delhi")
        );




    }

    }
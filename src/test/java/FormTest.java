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
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Artur");
        $("#lastName").setValue("Kolpakov");
        $("#userEmail").setValue("kolpakovartur91@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber-label").setValue("9003308519");
        $("#dateOfBirth-label").setValue("02 Apr 1991");
        $("react-datepicker__month-select").selectOption("April");
        $("react-datepicker__year-select").selectOption("1991");
        $("react-datepicker__day react-datepicker__day--002 react-datepicker__day--selected").click();
        $("#subjects-label").setValue("QA");
        $("label[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("101.jpg");
        $("#currentAddress-label").setValue("Cheboksary");
        $("react-select-3-input]").setValue("NCR").click();
        $("#submit").click();
















    }

    }
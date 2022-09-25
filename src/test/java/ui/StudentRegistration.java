package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQaPage;

import java.time.LocalDate;
import java.util.Map;

public class StudentRegistration extends BaseUiTest {

    @Test(description = "Проверка регистрации студента")
    public void checkRegistrationStudent() {
        int yesterday = LocalDate.now().minusDays(1).getDayOfMonth();
        Map<String, String> data = Map.of("Student Name", "Denis Bobylev",
                                          "Address", "г. Саратов, ул. Шелковичная 'ЖК Царицынский' д.4 к.2",
                                          "State and City", "Haryana Panipat",
                                          "Picture", "image.png",
                                          "Student Email", "denis.bobylev64@yandex.ru",
                                          "Date of Birth", "",
                                          "Gender", "Male",
                                          "Mobile", "9878089788",
                                          "Subjects", "English",
                                         "Hobbies", "Sports, Reading, Music");

        Map<String, String> dataFromUser = openDemoQaPage()
                .fillFirstNameAndLastName(data.get("Student Name").split(" ")[0], data.get("Student Name").split(" ")[1])
                .fillEmail(data.get("Student Email"))
                .selectGender(data.get("Gender"))
                .fillMobilePhone(data.get("Mobile"))
                .fillDateOfBirth(yesterday)
                .fillSubjectsContainerInput(data.get("Subjects"))
                .selectAllHobbies()
                .fillCurrentAddressInput(data.get("Address"))
                .selectStateAndCity(data.get("State and City").split(" ")[0], data.get("State and City").split(" ")[1])
                .uploadPicture(data.get("Picture"))
                .clickSubmitButton()
                .getLabelsAndValues();

        dataFromUser.forEach((k, v) -> {
            if (k.equals("Date of Birth"))
                v.contains(String.valueOf(yesterday));
            else
                Assert.assertEquals(v, data.get(k));
        });

    }

    @Test(description = "Проверка регистрации с пустыми данными")
    public void checkFailedRegistrationStudent() {

        DemoQaPage registerPage = openDemoQaPage()
                .clickSubmitButtonForFailed();

        Assert.assertNotNull(registerPage.getUrlErrorImaage("First Name"));
        Assert.assertNotNull(registerPage.getUrlErrorImaage("Last Name"));
        Assert.assertNotNull(registerPage.getUrlErrorImaage("Mobile Number"));

        registerPage.getHobbies()
                .stream()
                .forEach(hobbie -> {
                    Assert.assertFalse(hobbie.isSelected());
                });
    }
}


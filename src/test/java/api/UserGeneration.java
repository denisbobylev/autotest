package api;

import core.Configuration;
import model.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class UserGeneration extends BaseApiTest {


    @Test(description = "Проверка правильного гендера у всех генерируемых юзеров")
    public void checkGenderRandomUserGenerator() {

        String path = Configuration.GENERATOR_URI_PATH;
        Map<String, String> params = Map.of("results", "5", "gender", "male");

        given()
                .spec(getRequestSpecificationForUserGeneration())
                .when()
                .queryParams(params)
                .get(path)
                .then()
                .statusCode(200)
                .body("results.gender", notNullValue())
                .extract()
                .as(UserModel.class)
                .results
                .stream()
                .forEach(result -> {
                    Assert.assertEquals(result.gender, "male");
                });

    }

    @Test(description = "Проверка при передаче в параметр results не числового значения, генерируется только один юзер")
    public void checkGenderRandomUserGenerator1() {

        String path = Configuration.GENERATOR_URI_PATH;
        Map<String, String> params = Map.of("results", "error", "gender", "male");

        String count = given()
                .spec(getRequestSpecificationForUserGeneration())
                .when()
                .queryParams(params)
                .get(path)
                .then()
                .statusCode(200)
                .body("info.results", notNullValue())
                .extract()
                .as(UserModel.class)
                .info
                .results;

        Assert.assertEquals(count, "1");
    }
}

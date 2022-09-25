package api;

import core.Configuration;
import model.ShortedLinkModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CleanUp extends BaseApiTest {

    @Test(description = "URL без знаков: &,?,# и пробелов")
    public void checkShortedLinkPassWithoutSignsAndSpaces() {

        String path = Configuration.CLEAN_URI_PATH;

        String res = given()
                .spec(getRequestSpecificationToShortedLink())
                .formParam("url", Configuration.CLEAN_TEST_DATA_WITHOUT_SINGS_AND_SPACES)
                .when()
                .post(path)
                .then().log().all().assertThat().statusCode(200)
                .extract()
                .as(ShortedLinkModel.class)
                .resultUrl;

        Assert.assertEquals(res, "https://cleanuri.com/jRj7EO");

        }

    @Test(description = "URL со знаками : &,?,#")
    public void checkShortedLinkPassWithSigns() {

        String path = Configuration.CLEAN_URI_PATH;

        String res = given()
                .spec(getRequestSpecificationToShortedLink())
                .formParam("url", Configuration.CLEAN_TEST_DATA_WITH_SINGS)
                .when()
                .post(path)
                .then().log().all().assertThat().statusCode(200)
                .extract()
                .as(ShortedLinkModel.class)
                .resultUrl;

        Assert.assertEquals(res, "https://cleanuri.com/zm3jWJ");

    }

    @Test(description = "Ошибка при длинном URL")
    public void checkShortedLinkFailWithTooLongURL() {

        String path = Configuration.CLEAN_URI_PATH;

        String res = given()
                .spec(getRequestSpecificationToShortedLink())
                .formParam("url", Configuration.CLEAN_TEST_DATA_TOO_LONG)
                .when()
                .post(path)
                .then().log().all().assertThat().statusCode(400)
                .extract()
                .as(ShortedLinkModel.class)
                .error;

        Assert.assertEquals(res, "API Error: URL Too Long even for shortener services...");
    }
}

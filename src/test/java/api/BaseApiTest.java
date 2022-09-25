package api;

import core.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BaseApiTest {

    protected RequestSpecification getRequestSpecificationToShortedLink() {
        return new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri(Configuration.CLEAN_URI_HOST)
                .setContentType(ContentType.URLENC)
                .build();
    }

    protected RequestSpecification getRequestSpecificationForUserGeneration() {
        return new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri(Configuration.GENERATOR_URI_HOST)
                .setContentType(ContentType.JSON)
                .build();
    }

}

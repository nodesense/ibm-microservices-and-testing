package authentication;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

import data.reqres.SignupJWT;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.naming.Context;
import java.util.HashSet;
import java.util.Set;


public class JWTTests {
    private static RequestSpecBuilder    requestSpecBuilder;
    private static ResponseSpecBuilder   responseSpecBuilder;
    private static ResponseSpecification responseSpecification;
    private static RequestSpecification  requestSpecification;


    @BeforeClass
    public void setupSpecBuilder () {
        requestSpecBuilder = new RequestSpecBuilder ().addFilter (new RequestLoggingFilter ())
                .addFilter (new ResponseLoggingFilter ());
        responseSpecBuilder = new ResponseSpecBuilder ().expectStatusCode (200);

        responseSpecification = responseSpecBuilder.build ();
        requestSpecification = requestSpecBuilder.build ();

    }
    @Test
    @Description("singup ")
    @Severity(SeverityLevel.NORMAL)
    void singupUser() {

        Set<String> role = new HashSet<String>();
        role.add ("user");

        SignupJWT userData = new SignupJWT("example10",
                                        "example10",
                "example10@example.com",
                role
                );

        String response = given()
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .log()
                .all()
                .post("http://localhost:8080/api/auth/signup")
                .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .response ()
                .asString ();

        System.out.println(response);

    }

}

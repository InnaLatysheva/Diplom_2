package steps;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import constants.ApiEndPoints;

import static io.restassured.RestAssured.given;

public class BaseSteps {

    //Общие настройки запроса для всех API-степов
    public static RequestSpecification requestSpecification() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(ApiEndPoints.BASE_URL);
    }
}
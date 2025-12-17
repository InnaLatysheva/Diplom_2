package steps;

import io.qameta.allure.Step;

import io.restassured.response.ValidatableResponse;
import constants.ApiEndPoints;
import models.OrderCreateRequest;
import models.UserLoginRequest;

import static steps.BaseSteps.requestSpecification;


public class OrderSteps {

    @Step("Создание нового заказа без авторизации")
    public ValidatableResponse orderCreate(OrderCreateRequest orderCreateRequest) {
        return requestSpecification()
                .body(orderCreateRequest)
                .post(ApiEndPoints.ORDER_CREATE_POST)
                .then();
    }

    @Step("Создание нового заказа после авторизации")
    public ValidatableResponse orderCreateAfterLogin(UserLoginRequest userLoginRequest, OrderCreateRequest orderCreateRequest) {
        UserSteps userSteps = new UserSteps();
        String accessToken = userSteps.getAccessToken(userLoginRequest);

        return requestSpecification()
                .header("Authorization", accessToken)
                .body(orderCreateRequest)
                .post(ApiEndPoints.ORDER_CREATE_POST)
                .then();
    }
}
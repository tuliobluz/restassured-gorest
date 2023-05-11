import helpers.EmailGenerator;
import models.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.GoRestService;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.contains;

public class UpdateUsersTests {

    private static final int USER_ID = 1533013;
    private static final int INVALID_USER_ID = 1111111;
    private static final String USER_EMAIL = "laurabrown86@gmail.com";

    @Test
    @DisplayName("Update user successfully")
    void testUpdateUser() {
        UserModel userModel = new UserModel("Gino Paloma", "male", EmailGenerator.generateEmail(), "active");

        GoRestService.updateUser(USER_ID, userModel)
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .body("name", equalTo(userModel.getName()));
    }

    @Test
    @DisplayName("Update user with duplicated Email failure")
    void testUpdateDuplicatedEmailUser() {
        UserModel userModel = new UserModel("Gino Paloma", "male", USER_EMAIL, "active");

        GoRestService.updateUser(USER_ID, userModel)
                .then()
                .assertThat()
                .statusCode(SC_UNPROCESSABLE_ENTITY)
                .body("field", contains("email"))
                .body("message", contains("has already been taken"));
    }

    @Test
    @DisplayName("Update invalid user failure")
    void testUpdateInvalidUser() {
        UserModel userModel = new UserModel("Gino Paloma", "male", USER_EMAIL, "active");

        GoRestService.updateUser(INVALID_USER_ID, userModel)
                .then()
                .assertThat()
                .statusCode(SC_NOT_FOUND)
                .body("message", equalTo("Resource not found"));
    }

    @Test
    @DisplayName("NOT Update user ID")
    void testUpdateIdUser() {
        UserModel userModel = new UserModel("Gino Paloma", "male", EmailGenerator.generateEmail(), "active");
        userModel.setId(11111111);

        GoRestService.updateUser(USER_ID, userModel)
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .body("id", equalTo(USER_ID));
    }
}

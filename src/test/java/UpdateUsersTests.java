import helpers.EmailGenerator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import models.UserModel;
import services.GoRestService;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.contains;

public class UpdateUsersTests {
    private final int USER_ID = 1533013;
    private final int INVALID_USER_ID = 1111111;
    private final String USER_EMAIL = "laurabrown86@gmail.com";
    @Test
    public void testUpdateUser(){
        UserModel userModel = new UserModel("Gino Paloma", "male",  EmailGenerator.generateEmail(), "active");
        GoRestService.updateUser(USER_ID, userModel)
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .body("name", equalTo(userModel.getName()));
    }

    @Test
    public void testUpdateDuplicatedEmailUser(){
        UserModel userModel = new UserModel("Gino Paloma", "male",  USER_EMAIL, "active");
        GoRestService.updateUser(USER_ID, userModel)
                .then()
                .assertThat()
                .statusCode(SC_UNPROCESSABLE_ENTITY)
                .body("field", contains("email"))
                .body("message", contains("has already been taken"));
    }

    @Test
    public void testUpdateInvalidUser(){
        UserModel userModel = new UserModel("Gino Paloma", "male",  USER_EMAIL, "active");
        GoRestService.updateUser(INVALID_USER_ID, userModel)
                .then()
                .assertThat()
                .statusCode(SC_NOT_FOUND)
                .body("message", Matchers.equalTo("Resource not found"));
    }
}

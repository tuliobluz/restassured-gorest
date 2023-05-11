import helpers.EmailGenerator;
import models.UserModel;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import services.GoRestService;


import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTests {
    private final String USER_EMAIL = "laurabrown86@gmail.com";
    private final String INVALID_TOKEN = "111111";
    @Test
    public void testCreateUser() {
        UserModel userModel = new UserModel("Gino Paloma", "male", EmailGenerator.generateEmail(), "active");

        GoRestService.createUser(userModel)
                .then()
                .assertThat()
                .statusCode(SC_CREATED)
                .body("id", notNullValue())
                .body("name", equalTo(userModel.getName()))
                .body("gender", equalTo(userModel.getGender()))
                .body("email", equalTo(userModel.getEmail()));
    }

    @Test
    public void testDuplicatedEmailUser() {
        UserModel userModel = new UserModel("Gino Paloma", "male", USER_EMAIL, "active");

        GoRestService.createUser(userModel)
                .then()
                .assertThat()
                .statusCode(SC_UNPROCESSABLE_ENTITY)
                .body("field", contains("email"))
                .body("message", contains("has already been taken"));
    }

    @Test
    public void testUnauthorizedUser() {
        UserModel userModel = new UserModel("Gino Paloma", "male", USER_EMAIL, "active");

        GoRestService.createUnauthorizedUser(userModel, INVALID_TOKEN)
                .then()
                .assertThat()
                .statusCode(SC_UNAUTHORIZED)
                .body("message", Matchers.equalTo("Invalid token"));
    }
}
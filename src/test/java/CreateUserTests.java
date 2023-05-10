import helpers.EmailGenerator;
import models.UserModel;
import org.junit.jupiter.api.Test;
import services.GoRestService;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateUserTests {

    @Test
    public void Users_CreateUsers_Success(){

        UserModel userModel = new UserModel("Gino Paloma", "male",  EmailGenerator.generateEmail(), "active");
        GoRestService.createUser(userModel)
                .then()
                .statusCode(SC_CREATED)
                .body("id", notNullValue())
                .body("name", equalTo(userModel.getName()));
    }
}

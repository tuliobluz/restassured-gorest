import helpers.EmailGenerator;
import models.CreateUserModel;
import org.junit.jupiter.api.Test;
import services.GoRestService;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class UpdateUsersTests {

    @Test
    public void Users_CreateUsers_Success(){

        CreateUserModel createUserModel = new CreateUserModel("Gino Paloma", "male",  EmailGenerator.generateEmail(), "active");
        GoRestService.createUser(createUserModel)
                .then()
                .statusCode(SC_CREATED)
                .body("id", notNullValue())
                .body("name", equalTo(createUserModel.getName()));
    }
}

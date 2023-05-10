import helpers.EmailGenerator;
import org.junit.jupiter.api.Test;
import models.UserModel;
import services.GoRestService;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class UpdateUsersTests {

    @Test
    public void Users_UpdateUsers_Success(){
        UserModel userModel = new UserModel("Gino Paloma", "male",  EmailGenerator.generateEmail(), "active");
        GoRestService.updateUser(1533013, userModel)
                .then()
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .body("name", equalTo(userModel.getName()));
    }
}

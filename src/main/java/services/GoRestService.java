package services;

import io.restassured.response.Response;
import models.UserModel;

public class GoRestService extends BaseService {
    public static Response createUser(final UserModel userModel){

        return defaultRequestSpecification()
                .body(userModel)
                .when()
                .post("users/" );
    }

    public static Response updateUser(int updateUserModel, final UserModel userModel){

        return defaultRequestSpecification()
                .body(userModel)
                .when()
                .patch("users/" + updateUserModel);
    }
}

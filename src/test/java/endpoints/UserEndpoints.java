package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;
import routes.Routes;

import static io.restassured.RestAssured.given;

public class UserEndpoints {


    public static Response createUser( User payload ){

        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(payload).
                when().
                post(Routes.user_post_url);

        return response;
    }


    public static Response readUser( String username ){

        Response response = given().
                pathParam("username", username).
                when().
                get(Routes.user_get_url);

        return response;
    }


    public static Response updateUser( String username, User payload ){

        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                pathParam("username", username).
                body(payload).
                when().
                put(Routes.user_update_url);

        return response;
    }


    public static Response deleteUser( String username ){

        Response response = given().
                pathParam("username", username).
                when().
                delete(Routes.user_delete_url);

        return response;
    }



}

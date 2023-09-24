package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Store;
import routes.Routes;

import static io.restassured.RestAssured.given;

public class StoreEndpoints {

    public static Response createOrder(Store payload ){

        Response response = given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(payload).
                when().
                post(Routes.store_post_url);

        return response;
    }


    public static Response readOrder( int id ){

        Response response = given().
                pathParam("orderId", id).
                when().
                get(Routes.store_get_url);

        return response;
    }

    public static Response deleteOrder( int id ){

        Response response = given().
                pathParam("orderOd", id).
                when().
                delete(Routes.store_delete_url);

        return response;
    }


}

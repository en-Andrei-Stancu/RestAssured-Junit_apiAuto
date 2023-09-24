package test;

import com.github.javafaker.Faker;
import endpoints.StoreEndpoints;
import endpoints.UserEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.Store;
import payload.User;

import java.util.concurrent.TimeUnit;

public class StoreTests {
    Faker faker;
    Store storePayload;

    @BeforeClass
    public void setup(){
        faker = new Faker();
        storePayload = new Store();


        storePayload.setId(faker.idNumber().hashCode());
        storePayload.setPetId(faker.number().numberBetween(0, 20));
        storePayload.setQuantity(faker.number().numberBetween(100,900));
        storePayload.setShipDate(faker.date().future(1, TimeUnit.DAYS).toString());

    }

    @Test(priority = 1)
    public void testPostStore(){

        Response response = StoreEndpoints.createOrder(storePayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2)
    public void testGetUser(){

        Response response = StoreEndpoints.readOrder(this.storePayload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

}

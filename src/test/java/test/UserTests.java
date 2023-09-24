package test;

import com.github.javafaker.Faker;
import endpoints.UserEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.User;

public class UserTests {

    Faker faker;
    User userPayload;

    @BeforeClass
    public void setup(){
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

    }

    @Test(priority = 1)
    public void testPostUser(){

        Response response = UserEndpoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }


    @Test(priority = 2)
    public void testGetUser(){

        Response response = UserEndpoints.readUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 3)
    public void testUpdateUser(){

        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response response = UserEndpoints.updateUser( this.userPayload.getUsername() , userPayload );
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);

        //verify updated user data
        Response responseAfterUpdate = UserEndpoints.readUser(this.userPayload.getUsername());

        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test(priority = 4)
    public void testDeleteUser(){

        Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

}

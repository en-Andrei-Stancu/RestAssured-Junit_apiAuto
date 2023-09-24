package test;

import com.github.javafaker.Faker;
import endpoints.PetEndpoints;
import endpoints.UserEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.Pet;
import payload.User;

public class PetTest {

    Faker faker;
    Pet petPayload;

    @BeforeClass
    public void setup(){
        faker = new Faker();
        petPayload = new Pet();

        petPayload.setId(faker.idNumber().hashCode());
        petPayload.setName(faker.name().name());

    }

    @Test(priority = 1)
    public void testPostPet(){

        Response response = PetEndpoints.createPet(petPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }


    @Test(priority = 2)
    public void testGetPet(){

        Response response = PetEndpoints.readPet(this.petPayload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }



    @Test(priority = 3)
    public void testUpdateUser(){

        petPayload.setName(faker.name().name());

        Response response =  PetEndpoints.updatePet(this.petPayload);
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);

        //verify updated pet data
        Response responseAfterUpdate = PetEndpoints.readPet(this.petPayload.getId());

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUser(){

        Response response = PetEndpoints.deletePet(this.petPayload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }





}

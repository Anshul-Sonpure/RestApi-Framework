package testScripts;

import core.BaseTest;
import core.RestClient;
import domain.*;

import org.testng.annotations.Test;

public class PostTests extends BaseTest {

    CreatePayload request = CreatePayload.builder()
            .userId(1)
            .title("Jungle Book")
            .body("This is Jungle Book")
            .build();


    @Test
    public void createPost()
    {
        response = RestClient.post(ApiEndpoints.POST, request,null);

        response.then().statusCode(201);
    }
}

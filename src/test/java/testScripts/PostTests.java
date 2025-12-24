package testScripts;

import core.BaseTest;
import core.RestClient;
import domain.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class PostTests extends BaseTest {
    private static final Logger log = LogManager.getLogger(PostTests.class);
    CreatePayload request = CreatePayload.builder()
            .userId(1)
            .title("Jungle Book")
            .body("This is Jungle Book")
            .build();


    @Test
    public void createPost()
    {   log.info("Executing test logic");
        response = RestClient.post(ApiEndpoints.POST, request,null);

        response.then().statusCode(201);
    }
}

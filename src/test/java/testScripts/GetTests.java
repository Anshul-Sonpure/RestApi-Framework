package testScripts;

import core.BaseTest;
import domain.ApiEndpoints;
import core.RestClient;
import domain.RequestOptions;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.Matchers.*;

public class GetTests extends BaseTest {

    private static final Logger log = LogManager.getLogger(GetTests.class);

    @Test
    public void getPosts()
    {
        log.info("Executing test logic");
         response = RestClient.get(ApiEndpoints.GET_POSTS);

        response.then()
                .statusCode(200)
                .body("$", not(empty()));
    }

    @Test
    public void getPostById()
    {
        response = RestClient.get(
                ApiEndpoints.GET_POSTS_ID,
                RequestOptions.builder()
                        .pathParams(Map.of("id", 1))
                        .build()
        );
        response.then().statusCode(200);
    }


    @Test
    public void getPostByComments()
    {
        response = RestClient.get(
                ApiEndpoints.GET_POSTS_ID,
                RequestOptions.builder()
                        .pathParams(Map.of("id", 2))
                        .build()
        );
        response.then().statusCode(200);
    }

    @Test
    public void getComments()
    {
        response = RestClient.get(
                ApiEndpoints.GET_POSTS_ID,
                RequestOptions.builder()
                        .pathParams(Map.of("id", 3))
                        .build()
        );
        response.then().statusCode(200);
    }
}

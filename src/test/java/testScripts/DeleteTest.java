package testScripts;

import core.BaseTest;
import domain.ApiEndpoints;
import core.RestClient;
import domain.RequestOptions;
import org.testng.annotations.Test;

import java.util.Map;

public class DeleteTest extends BaseTest {

    @Test
    public void deletePostById()
    {
        response = RestClient.delete(ApiEndpoints.DELETE_POSTS, RequestOptions.builder()
                .pathParams(Map.of("id", 2))
                .build()
        );
        response.then().statusCode(200);
    }
}

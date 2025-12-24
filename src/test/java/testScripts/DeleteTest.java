package testScripts;

import core.BaseTest;
import domain.ApiEndpoints;
import core.RestClient;
import domain.RequestOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;

public class DeleteTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(DeleteTest.class);

    @Test
    public void deletePostById()
    {
        log.info("Executing test logic");
        response = RestClient.delete(ApiEndpoints.DELETE_POSTS, RequestOptions.builder()
                .pathParams(Map.of("id", 2))
                .build()
        );
        response.then().statusCode(200);
    }
}

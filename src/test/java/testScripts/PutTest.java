package testScripts;

import core.BaseTest;
import domain.ApiEndpoints;
import domain.CreatePayload;
import core.RestClient;
import domain.RequestOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;

public class PutTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(PutTest.class);
    CreatePayload putRequest = CreatePayload.builder()
            .userId(1)
            .title("Transformers and New MoonLanding")
            .build();

    @Test
    public void putRequest()
    {   log.info("Executing test logic");
        response = RestClient.patch(ApiEndpoints.PATCH_POSTS,putRequest, RequestOptions.builder()
                .pathParams(Map.of("id", 2))
                .build()
        );
        response.then().assertThat().statusCode(200);
    }
}

package testScripts;

import core.BaseTest;
import domain.ApiEndpoints;
import domain.CreatePayload;
import core.RestClient;
import domain.RequestOptions;
import org.testng.annotations.Test;

import java.util.Map;

public class PutTest extends BaseTest {

    CreatePayload putRequest = CreatePayload.builder()
            .userId(1)
            .title("Transformers and New MoonLanding")
            .build();

    @Test
    public void putRequest()
    {
        response = RestClient.patch(ApiEndpoints.PATCH_POSTS,putRequest, RequestOptions.builder()
                .pathParams(Map.of("id", 2))
                .build()
        );
        response.then().assertThat().statusCode(200);
    }
}

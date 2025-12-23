package testScripts;

import core.BaseTest;
import domain.ApiEndpoints;
import domain.CreatePayload;
import core.RestClient;
import domain.RequestOptions;
import org.testng.annotations.Test;

import java.util.Map;

public class PatchTest extends BaseTest {

    CreatePayload patchRequest = CreatePayload.builder()
            .userId(1)
            .title("Harry Potter and Wizards of Blackpearl")
            .body("This is new edition of Harry Potter")
            .build();

    @Test
    public void patchRequest()
    {
        response = RestClient.patch(ApiEndpoints.PATCH_POSTS,patchRequest,
                RequestOptions.builder()
                        .pathParams(Map.of("id", 2))
                .build());
        response.then().statusCode(200);
    }
}

package core;

import domain.RequestOptions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class RestClient {
    private RestClient() {
    }

    private static RequestSpecification buildRequestSpecification(RequestOptions options) {

        RequestSpecification spec = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        if (options == null) {
            return spec;
        }

        if (options.getToken() != null && !options.getToken().isBlank()) {
            spec.header("Authorization", "Bearer " + options.getToken());
        }

        if (options.getPathParams() != null && !options.getPathParams().isEmpty()) {
            spec.pathParams(options.getPathParams());
        }

        if (options.getQueryParams() != null && !options.getQueryParams().isEmpty()) {
            spec.queryParams(options.getQueryParams());
        }

        if (options.getHeaders() != null && !options.getHeaders().isEmpty()) {
            spec.headers(options.getHeaders());
        }

        return spec;
    }


    public static Response get(String endpoint) {
        return get(endpoint, null);
    }

    public static Response get(String endpoint, RequestOptions options) {
        return buildRequestSpecification(options)
                .when()
                .get(endpoint);
    }

    public static Response post(String endpoint, Object payload, RequestOptions options) {
        return buildRequestSpecification(options)
                .body(payload)
                .when()
                .post(endpoint);
    }

    public static Response put(String endpoint, Object payload, RequestOptions options) {
        return buildRequestSpecification(options)
                .body(payload)
                .when()
                .put(endpoint);
    }
    public static Response patch(String endpoint, Object payload, RequestOptions options) {
        return buildRequestSpecification(options)
                .body(payload)
                .when()
                .patch(endpoint);
    }
    public static Response delete(String endpoint, RequestOptions options) {
        return buildRequestSpecification(options)
                .when()
                .delete(endpoint);
    }



}

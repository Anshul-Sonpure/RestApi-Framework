package domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class RequestOptions {


        private String token;
        private Map<String, Object> pathParams;
        private Map<String, Object> queryParams;
        private Map<String, String> headers;
}


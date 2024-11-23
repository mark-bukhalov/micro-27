package org.example.competenceservice.config.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());
        switch (status) {
            case NOT_FOUND:
                return new ResponseStatusException(status, "Resource not found in " + methodKey);
            case BAD_REQUEST:
                return new ResponseStatusException(status, "Invalid request in " + methodKey);
            case INTERNAL_SERVER_ERROR:
                return new ResponseStatusException(status, "Server error in " + methodKey);
            default:
                return new ResponseStatusException(status, "Error in " + methodKey);
        }
    }
}
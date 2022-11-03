package com.productuserapi.productUser.Exception;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Value
@Builder
public class ErrorResponse {

    UUID id;

    Instant timestamp;

    int status;

    String error;

    ErrorCode code;

    String message;

    @Singular
    List<SubError> subErrors;

}

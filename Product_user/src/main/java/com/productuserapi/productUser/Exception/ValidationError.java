package com.productuserapi.productUser.Exception;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ValidationError implements SubError {

    ValidationErrorType type;

    ValidationErrorCode code;

    String field;

    String message;

}

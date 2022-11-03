package com.productuserapi.productUser.Exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.UUID;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DefaultExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ErrorResponse.ErrorResponseBuilder builder = ErrorResponse.builder()
            .id(UUID.randomUUID())
            .timestamp(Instant.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
            .code(ErrorCode.VALIDATION_ERROR)
            .message(ex.getMessage());
        ex.getBindingResult().getGlobalErrors()
            .stream()
            .map(this::toValidationError)
            .forEach(builder::subError);
        ex.getBindingResult().getFieldErrors()
            .stream()
            .map(this::toValidationError)
            .forEach(builder::subError);
        return ResponseEntity.badRequest().body(builder.build());
    }

    private ValidationError toValidationError(ObjectError objectError) {
        return ValidationError.builder()
            .type(ValidationErrorType.GLOBAL)
            .code(ValidationErrorCode.convertFieldErrorCode(objectError.getCode()))
            .message(objectError.getDefaultMessage())
            .build();
    }

    @ExceptionHandler(ServerException.class)
    protected ResponseEntity<Object> handleServerException(ServerException ex){
        ErrorResponse response = ErrorResponse.builder()
            .id(UUID.randomUUID())
            .timestamp(Instant.now())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
            .code(ex.getErrorCode())
            .message(ex.getMessage())
            .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}

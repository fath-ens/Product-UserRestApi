package com.productuserapi.productUser.Exception;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public enum ValidationErrorCode {

    INVALID_FIELD("INVALID"),
    MUST_BE_NULL("Null"),
    MUST_NOT_BE_NULL("NotNull"),
    MUST_BE_TRUE("AssertTrue"),
    MUST_BE_FALSE("AssertFalse"),
    MIN_VALUE_EXCEEDED("Min"),
    MAX_VALUE_EXCEEDED("Max"),
    DECIMAL_MIN_VALUE_EXCEEDED("DecimalMin"),
    DECIMAL_MAX_VALUE_EXCEEDED("DecimalMax"),
    MUST_BE_NEGATIVE("Negative"),
    MUST_BE_NEGATIVE_OR_ZERO("NegativeOrZero"),
    MUST_BE_POSITIVE("Positive"),
    MUST_BE_POSITIVE_OR_ZERO("PositiveOrZero"),
    INVALID_SIZE("Size"),
    INVALID_DIGITS("Digits"),
    MUST_BE_IN_THE_PAST("Past"),
    MUST_BE_IN_THE_PAST_OR_PRESENT("PastOrPresent"),
    MUST_BE_IN_THE_FUTURE("Future"),
    MUST_BE_IN_THE_FUTURE_OR_PRESENT("FutureOrPresent"),
    MUST_MATCH_THE_REGEX("Pattern"),
    MUST_NOT_BE_EMPTY("NotEmpty"),
    MUST_NOT_BE_BLANK("NotBlank"),
    INVALID_EMAIL("Email");

    private final String fieldErrorCode;

    ValidationErrorCode(String fieldErrorCode) {
        this.fieldErrorCode = fieldErrorCode;
    }

    public static ValidationErrorCode convertFieldErrorCode(String text) {
        return Arrays.stream(ValidationErrorCode.values())
            .filter(item -> item.fieldErrorCode.equalsIgnoreCase(text))
            .findFirst()
            .orElseGet(() -> {
                log.warn("Unknown field error code {}.", text);
                return INVALID_FIELD;
            });
    }

}

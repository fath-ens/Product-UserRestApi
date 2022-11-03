package com.productuserapi.productUser.Exception;

public enum ErrorCode {

    INVALID_VALUE,
    // Server-side
    INTERNAL_SERVER_ERROR,
    // Resource
    RESOURCE_NOT_FOUND,
    RESOURCE_DELETED,
    RESOURCE_ALREADY_EXISTS,
    // Request validation
    INVALID_REQUEST_FORMAT,
    VALIDATION_ERROR,
    // Feign
    FEIGN_SERVER_ERROR,
    FEIGN_CLIENT_ERROR,
    // JPA
    DATA_INTEGRITY_VIOLATION,
    // File
    MAX_UPLOAD_SIZE_EXCEEDED,
    // Security
    AUTHENTICATION_FAILED,
    INVALID_BEARER_TOKEN,
    INVALID_JWT,
    ACCESS_DENIED,
    INVALID_REQUEST,
    INVALID_CLIENT,
    INVALID_GRANT,
    UNAUTHORIZED_CLIENT,
    UNSUPPORTED_GRANT_TYPE,
    INVALID_SCOPE,
    INSUFFICIENT_SCOPE,
    INVALID_TOKEN,
    REDIRECT_URI_MISMATCH,
    UNSUPPORTED_RESPONSE_TYPE,
    // UAA
    USER_NOT_FOUND,
    USER_HAS_NO_PASSWORD,
    WRONG_PASSWORD,
    USER_NOT_PENDING,
    EMAIL_NOT_VERIFIED,
    EMAIL_ALREADY_VERIFIED,
    RECRUITER_OR_EMPLOYER_SHOULD_BE_ENTERED,
    CURRENT_USER_ROLE_UNAUTHORIZED,
    // Job
    JOB_NOT_ACTIVE,
    JOB_CLOSED,
    JOB_NOT_PUBLISHED,
    EMPLOYER_NOT_FILLED_PROFILE,
    // Candidate
    APPLICATION_ALREADY_REVIEWED,
    APPLICATION_NOT_HIRED,
    RECRUITER_NOT_FILLED_PROFILE,
    RATING_NOT_ENOUGH,
    PLACEMENT_NOT_ENOUGH,
    CANDIDATE_ALREADY_SUBMITTED,
    // Recruiter
    EARNING_NOT_PAYABLE,
    EARNING_NOT_CANCELLABLE,
    BALANCE_NOT_ENOUGH,
    REVIEW_REJECTED,
    // Subscription
    FREE_PACKAGE_ALREADY_EXISTS,
    FREE_PACKAGE_NOT_FOUND_FOR_EMPLOYER,
    // Subscription
    FREE_PACKAGE_UPGRADE_NEEDS_PAYMENT,
    DOWNGRADE_NOT_POSSIBLE,
    PACKAGE_DOES_NOT_CONTAIN_FUNCTIONALITY,
    SUBSCRIPTION_NOT_ACTIVE,
    SUBSCRIPTION_NOT_FOUND,
    PACKAGE_LIMIT_EXCEEDED,
    PACKAGE_NOT_INITIALIZE,
    FREE_PACKAGE_UPGRADE_NEEDS_CHARGEABLE_PACKAGE_ID
}
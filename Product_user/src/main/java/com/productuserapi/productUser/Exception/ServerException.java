package com.productuserapi.productUser.Exception;

import lombok.Getter;

@Getter
public class ServerException extends RuntimeException{

    private static final long serialVersionUID = -6788576138740880480L;

    private final ErrorCode errorCode;

    public ServerException(String message, Object... args){
        super(String.format(message,args));
        this.errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
    }

    public ServerException(ErrorCode errorCode,String message, Object... args){
        super(String.format(message,args));
        this.errorCode = errorCode;
    }

}

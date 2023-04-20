package com.yedeveloper.chat.modules.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

public class ApiUtil {

    private ApiUtil () {throw new AssertionError();}

    private static final String PROCESS_MESSAGE = "처리되었습니다.";

    public static <T> ApiResult<T> success ( T response ) {
        return new ApiResult<>( true, response, PROCESS_MESSAGE, HttpStatus.OK );
    }

    public static <T> ApiResult<T> fail ( String message, HttpStatus status ) {
        return new ApiResult<>( false, null, message, status );
    }

    public static <T> ApiResult<T> fail ( String message, int status ) {
        return new ApiResult<>( false, null, message, status );
    }

    @Data
    public static class ApiResult<T> {

        private final boolean success;
        private final T response;
        private final String message;
        private final int status;

        private ApiResult ( boolean success, T response, String message, HttpStatus status ) {
            this.success = success;
            this.response = response;
            this.message = message;
            this.status = status.value();
        }

        private ApiResult ( boolean success, T response, String message, int status ) {
            this.success = success;
            this.response = response;
            this.message = message;
            this.status = status;
        }

    }

}

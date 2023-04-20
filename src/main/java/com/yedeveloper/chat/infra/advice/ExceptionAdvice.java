package com.yedeveloper.chat.infra.advice;

import static com.yedeveloper.chat.modules.utils.ApiUtil.fail;

import com.yedeveloper.chat.infra.advice.exceptions.BadRequestException;
import com.yedeveloper.chat.modules.utils.ApiUtil.ApiResult;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    private ResponseEntity<ApiResult<?>> newResponse ( Throwable throwable, HttpStatus status ) {
        return newResponse( throwable.getMessage(), status );
    }

    private ResponseEntity<ApiResult<?>> newResponse ( String message, HttpStatus status ) {
        HttpHeaders headers = new HttpHeaders();
        headers.add( "Content-Type", "application/json" );
        return new ResponseEntity<>( fail( message, status ), headers, status );
    }

    @ExceptionHandler( Exception.class )
    protected ResponseEntity<ApiResult<?>> defaultException ( Exception e ) {
        log.error( "defaultException : {} ", e.getMessage() );
        e.printStackTrace();
        return newResponse( e, HttpStatus.UNPROCESSABLE_ENTITY );
    }

    @ExceptionHandler(
        { IllegalArgumentException.class, IllegalStateException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class,
            BadRequestException.class, HttpRequestMethodNotSupportedException.class } )
    public ResponseEntity<?> handleBadRequestException ( Exception e ) {
        log.error( "Bad request exception occurred: {}", e.getMessage(), e );
        if ( e instanceof MethodArgumentNotValidException methodargumentnotvalidexception ) {
            return newResponse( methodargumentnotvalidexception.getBindingResult().getAllErrors().get( 0 ).getDefaultMessage(),
                                HttpStatus.BAD_REQUEST );
        }
        return newResponse( e, HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler( MethodArgumentTypeMismatchException.class )
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException ( MethodArgumentTypeMismatchException e ) {
        return newResponse( e, HttpStatus.BAD_REQUEST );
    }

}

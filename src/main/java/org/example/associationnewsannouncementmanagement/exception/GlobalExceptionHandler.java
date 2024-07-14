package org.example.associationnewsannouncementmanagement.exception;

import org.example.associationnewsannouncementmanagement.dto.ErrorDto;
import org.example.associationnewsannouncementmanagement.model.ErrorMessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        logger.error("UserNotFoundException: ", ex);
        ErrorDto errorDto = new ErrorDto(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ErrorMessageType.USER_NOT_FOUND.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<Object> handleLoginFailedException(LoginFailedException ex, WebRequest request) {
        logger.error("LoginFailedException: ", ex);
        ErrorDto errorDto = new ErrorDto(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                ErrorMessageType.LOGIN_FAILED.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex, WebRequest request) {
        logger.error("EmailAlreadyExistsException: ", ex);
        ErrorDto errorDto = new ErrorDto(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ErrorMessageType.EMAIL_ALREADY_EXISTS.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Object> handleInvalidEmailException(InvalidEmailException ex, WebRequest request) {
        logger.error("InvalidEmailException: ", ex);
        ErrorDto errorDto = new ErrorDto(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ErrorMessageType.INVALID_EMAIL.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }




    // Diger tum exceptionlar burada yakalanacak.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        logger.error("Exception: ", ex);
        ErrorDto errorDto = new ErrorDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ErrorMessageType.GENERIC_ERROR.getMessage(),
                new Date()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

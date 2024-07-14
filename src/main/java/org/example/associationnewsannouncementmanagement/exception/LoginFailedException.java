package org.example.associationnewsannouncementmanagement.exception;

import org.example.associationnewsannouncementmanagement.model.ErrorMessageType;
import org.springframework.http.HttpStatus;

public class LoginFailedException extends AbstractException{

    public LoginFailedException(ErrorMessageType errorMessageType) {
        super(errorMessageType.getMessage());
    }

    public LoginFailedException(String message) {
        super(message);
    }

    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
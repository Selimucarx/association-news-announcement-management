package org.example.associationnewsannouncementmanagement.exception;

import org.example.associationnewsannouncementmanagement.model.ErrorMessageType;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AbstractException{

    public UserNotFoundException(ErrorMessageType errorMessageType) {
        super(errorMessageType.getMessage());
    }

    public UserNotFoundException(String message) {
        super(message);
    }



    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
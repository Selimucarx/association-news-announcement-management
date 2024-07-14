package org.example.associationnewsannouncementmanagement.exception;

import org.example.associationnewsannouncementmanagement.model.ErrorMessageType;
import org.springframework.http.HttpStatus;

public class InvalidEmailException extends AbstractException{

    public InvalidEmailException(ErrorMessageType errorMessageType) {
        super(errorMessageType.getMessage());
    }

    public InvalidEmailException(String message) {
        super(message);
    }


    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
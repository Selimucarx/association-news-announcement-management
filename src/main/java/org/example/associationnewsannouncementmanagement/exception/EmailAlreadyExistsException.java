package org.example.associationnewsannouncementmanagement.exception;

import org.example.associationnewsannouncementmanagement.model.ErrorMessageType;
import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends AbstractException{

    public EmailAlreadyExistsException(ErrorMessageType errorMessageType) {
        super(errorMessageType.getMessage());
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }
}
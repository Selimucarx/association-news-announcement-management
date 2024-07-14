package org.example.associationnewsannouncementmanagement.model;

public enum ErrorMessageType {

    GENERIC_ERROR("Sistem kaynali bir sorun."),
    USER_NOT_FOUND("User bulunamadi."),

    INVALID_REQUEST("Girdiğiniz bilgileri kontrol edin."),
    INVALID_EMAIL("Lutfen dogru bir email adresi giriniz"),
    LOGIN_FAILED("Email veya sifre yanlis"),
    EMAIL_ALREADY_EXISTS("Email zaten kayıtlı.");


    private final String message;
    ErrorMessageType(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }


}

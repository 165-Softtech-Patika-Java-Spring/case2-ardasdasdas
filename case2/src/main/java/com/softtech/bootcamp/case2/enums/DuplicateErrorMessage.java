package com.softtech.bootcamp.case2.enums;

public enum DuplicateErrorMessage {

    COUNTRY_CODE_DUPLICATE_ERROR_MESSAGE("Country Code is already exists!"),
    PLATE_NO_DUPLICATE_ERROR_MESSAGE("Plate No is already exists!"),
    ;

    private String message;

    DuplicateErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return message;
    }
}

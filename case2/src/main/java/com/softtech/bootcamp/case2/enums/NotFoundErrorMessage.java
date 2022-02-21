package com.softtech.bootcamp.case2.enums;

public enum NotFoundErrorMessage {

    COUNTRY_NOT_FOUND_ERROR_MESSAGE("Country is not found!"),
    CITY_NOT_FOUND_ERROR_MESSAGE("City is not found!"),
    DISTRICT_NOT_FOUND_ERROR_MESSAGE("District is not found!"),
    NEIGHBORHOOD_NOT_FOUND_ERROR_MESSAGE("Neighborhood is not found!"),
    STREET_NOT_FOUND_ERROR_MESSAGE("Street is not found!"),
    ADDRESS_NOT_FOUND_ERROR_MESSAGE("Address is not found!"),
    ;

    private String message;

    NotFoundErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return message;
    }
}

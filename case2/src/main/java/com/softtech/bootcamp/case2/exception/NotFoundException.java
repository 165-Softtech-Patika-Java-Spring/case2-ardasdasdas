package com.softtech.bootcamp.case2.exception;

import com.softtech.bootcamp.case2.enums.NotFoundErrorMessage;

public class NotFoundException extends Case2Exception {

    public NotFoundException() {
        super();
    }

    public NotFoundException(NotFoundErrorMessage notFoundErrorMessage) {
        super(notFoundErrorMessage.getMessage());
    }
}

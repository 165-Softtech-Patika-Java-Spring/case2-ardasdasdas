package com.softtech.bootcamp.case2.exception;

import com.softtech.bootcamp.case2.enums.DuplicateErrorMessage;

public class DuplicateException extends Case2Exception {
    public DuplicateException() {
        super();
    }

    public DuplicateException(DuplicateErrorMessage duplicateErrorMessage) {
        super(duplicateErrorMessage.getMessage());
    }

}

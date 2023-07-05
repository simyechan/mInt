package com.example.mInt2.domain.user.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class NotValidUserException  extends SousoException {

    public static final SousoException EXCEPTION =
            new NotValidUserException();

    private NotValidUserException() {
        super(GlobalErrorCode.NOT_VALID_USER);
    }
}

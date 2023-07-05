package com.example.mInt2.domain.user.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class AlreadyEmailExistsException extends SousoException {

    public static final SousoException EXCEPTION =
            new AlreadyEmailExistsException();

    private AlreadyEmailExistsException() {
        super(GlobalErrorCode.ALREADY_EMAIL_EXISTS);
    }
}

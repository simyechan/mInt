package com.example.mInt2.domain.auth.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class PasswordMisMatchException extends SousoException {

    public static final SousoException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(GlobalErrorCode.PASSWORD_MISMATCH);
    }
}

package com.example.mInt2.domain.user.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class InvalidCodeException extends SousoException {

    public static final SousoException EXCEPTION =
            new InvalidCodeException();

    private InvalidCodeException() {
        super(GlobalErrorCode.INVALID_CODE);
    }
}

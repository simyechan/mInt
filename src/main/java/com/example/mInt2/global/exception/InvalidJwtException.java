package com.example.mInt2.global.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class InvalidJwtException extends SousoException {

    public static final SousoException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(GlobalErrorCode.INVALID_JWT);
    }
}

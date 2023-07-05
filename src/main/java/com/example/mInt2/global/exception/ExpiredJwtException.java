package com.example.mInt2.global.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class ExpiredJwtException extends SousoException {

    public static final ExpiredJwtException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(GlobalErrorCode.EXPIRED_JWT);
    }
}

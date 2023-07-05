package com.example.mInt2.domain.auth.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class RefreshTokenNotFoundException extends SousoException {

    public static final SousoException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() {
        super(GlobalErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}

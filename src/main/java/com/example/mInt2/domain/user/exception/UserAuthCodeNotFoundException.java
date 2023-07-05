package com.example.mInt2.domain.user.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class UserAuthCodeNotFoundException extends SousoException {

    public static final SousoException EXCEPTION =
            new UserAuthCodeNotFoundException();

    private UserAuthCodeNotFoundException() {
        super(GlobalErrorCode.USER_AUTH_CODE_NOT_FOUND);
    }
}

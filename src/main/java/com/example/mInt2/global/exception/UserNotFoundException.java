package com.example.mInt2.global.exception;


import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class UserNotFoundException extends SousoException {

    public static final SousoException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(GlobalErrorCode.USER_NOT_FOUND);
    }
}
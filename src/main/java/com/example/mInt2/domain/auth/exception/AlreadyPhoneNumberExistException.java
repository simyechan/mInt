package com.example.mInt2.domain.auth.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class AlreadyPhoneNumberExistException extends SousoException {

    public static final SousoException EXCEPTION =
            new AlreadyPhoneNumberExistException();

    private AlreadyPhoneNumberExistException() {
        super(GlobalErrorCode.ALREADY_PHONE_NUMBER_EXIST);
    }
}

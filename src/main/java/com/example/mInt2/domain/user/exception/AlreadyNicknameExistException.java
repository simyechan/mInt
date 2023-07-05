package com.example.mInt2.domain.user.exception;

import com.example.mInt2.global.error.exception.GlobalErrorCode;
import com.example.mInt2.global.error.exception.SousoException;

public class AlreadyNicknameExistException extends SousoException {

    public static final SousoException EXCEPTION =
            new AlreadyNicknameExistException();

    private AlreadyNicknameExistException() {
        super(GlobalErrorCode.ALREADY_NICKNAME_EXIST);
    }
}

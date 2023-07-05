package com.example.mInt2.global.error.exception;

import com.example.mInt2.global.error.ErrorCode;
import com.example.mInt2.global.error.handler.DiaryException;

public class DiaryNotFoundException extends DiaryException {

    public static final DiaryException EXCEPTION = new DiaryNotFoundException();

    private DiaryNotFoundException() {
        super(ErrorCode.MEMOIR_NOT_FOUND);
    }
}

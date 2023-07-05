package com.example.mInt2.domain.diary.exception;

import com.example.mInt2.global.error.ErrorCode;
import com.example.mInt2.global.error.handler.DiaryException;

public class DiaryNotUpdateException extends DiaryException {

    public static final DiaryException EXCEPTION = new DiaryNotUpdateException();

    private DiaryNotUpdateException() {
        super(ErrorCode.MEMOIR_NOT_UPDATE);
    }
}

package com.example.mInt2.domain.diary.exception;

import com.example.mInt2.global.error.ErrorCode;
import com.example.mInt2.global.error.handler.DiaryException;

public class DiaryNotDeleteException extends DiaryException {

    public static final DiaryException EXCEPTION = new DiaryNotDeleteException();

    private DiaryNotDeleteException() {
        super(ErrorCode.MEMOIR_NOT_DELETE);
    }
}

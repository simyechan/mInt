package com.example.mInt2.global.error.handler;

import com.example.mInt2.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DiaryException extends RuntimeException {

    private final ErrorCode errorCode;
}

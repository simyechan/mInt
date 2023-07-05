package com.example.mInt2.domain.diary.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class DiaryResponse {
    private String title;
    private String subtitle;
}

package com.example.mInt2.domain.diary.facade;

import com.example.mInt2.domain.diary.domain.Diary;
import com.example.mInt2.domain.diary.domain.repository.DiaryRepository;
import com.example.mInt2.global.error.exception.DiaryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DiaryFacade {

    private final DiaryRepository diaryRepository;

    public Diary getDiaryId(Long diaryId) {
        return diaryRepository.findById(diaryId)
                .orElseThrow(() -> DiaryNotFoundException.EXCEPTION);
    }
}

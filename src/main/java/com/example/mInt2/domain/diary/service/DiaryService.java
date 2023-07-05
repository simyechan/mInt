package com.example.mInt2.domain.diary.service;

import com.example.mInt2.domain.diary.domain.Diary;
import com.example.mInt2.domain.diary.exception.DiaryNotDeleteException;
import com.example.mInt2.domain.diary.exception.DiaryNotUpdateException;
import com.example.mInt2.domain.diary.facade.DiaryFacade;
import com.example.mInt2.domain.diary.domain.repository.DiaryRepository;
import com.example.mInt2.domain.diary.presentation.dto.request.DiaryRequest;
import com.example.mInt2.domain.user.domain.User;
import com.example.mInt2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserFacade userFacade;
    private final DiaryFacade diaryFacade;

    public void diaryWrite(DiaryRequest request) {
        User user = userFacade.getCurrentUser();

        diaryRepository.save(Diary.builder()
                        .title(request.getTitle())
                        .subtitle(request.getSubtitle())
                .build());
    }

    @Transactional
    public void diaryDelete(Long diaryId) {
        Diary diary = diaryFacade.getDiaryId(diaryId);
        User user = userFacade.getCurrentUser();

        if(!user.equals(diary.getUser())) {
            throw DiaryNotDeleteException.EXCEPTION;
        }

        diaryRepository.delete(diary);
    }

    @Transactional
    public void diaryUpdate(Long diaryId, DiaryRequest request) {
        User user = userFacade.getCurrentUser();
        Diary diary = diaryFacade.getDiaryId(diaryId);

        if(!user.equals(diary.getUser())) {
            throw DiaryNotUpdateException.EXCEPTION;
        }

        diary.updateDiary(
                request.getTitle(),
                request.getSubtitle()
        );
    }
}

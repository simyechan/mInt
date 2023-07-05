package com.example.mInt2.domain.diary.presentation;

import com.example.mInt2.domain.diary.presentation.dto.request.DiaryRequest;
import com.example.mInt2.domain.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService diaryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/write")
    public void diaryWrite(@RequestBody @Valid DiaryRequest request) {
        diaryService.diaryWrite(request);
    }

    @DeleteMapping
    public void diaryDelete(@RequestParam("diaryId") Long diaryId) {
        diaryService.diaryDelete(diaryId);
    }

    @PatchMapping("/update")
    public void diaryUpdate(@RequestParam("diaryId") Long diaryId,
                             @RequestBody @Valid DiaryRequest request) {
        diaryService.diaryUpdate(diaryId, request);
    }
}

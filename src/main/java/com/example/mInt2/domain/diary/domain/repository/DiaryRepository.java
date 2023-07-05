package com.example.mInt2.domain.diary.domain.repository;

import com.example.mInt2.domain.diary.domain.Diary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiaryRepository extends CrudRepository<Diary, Long> {

    List<Diary> findByTitleContaining(String keyword);
}

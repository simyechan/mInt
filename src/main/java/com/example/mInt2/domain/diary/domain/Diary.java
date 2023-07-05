package com.example.mInt2.domain.diary.domain;

import com.example.mInt2.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "userId")
    private User user;

    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String subtitle;

    @Builder
    public Diary(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public void updateDiary(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }
}

package com.example.mInt2.domain.user.domain;

import com.example.mInt2.global.enums.UserRole;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 45)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 60)
    private String password;

    @NotNull
    @Size(max = 11)
    @Column(unique = true)
    private String phoneNumber;

    @NotNull
    @Size(max = 30)
    private String nickname;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private UserRole role;

    @Builder
    public User(String email, String password, String nickname, UserRole role) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


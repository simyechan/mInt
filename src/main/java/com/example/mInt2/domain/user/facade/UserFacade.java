package com.example.mInt2.domain.user.facade;

import com.example.mInt2.domain.auth.exception.AlreadyPhoneNumberExistException;
import com.example.mInt2.domain.user.domain.User;
import com.example.mInt2.domain.user.domain.repository.UserRepository;
import com.example.mInt2.domain.user.exception.AlreadyEmailExistsException;
import com.example.mInt2.domain.user.exception.AlreadyNicknameExistException;
import com.example.mInt2.domain.user.exception.AlreadyUserExistException;
import com.example.mInt2.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkUserExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw AlreadyUserExistException.EXCEPTION;
        }
    }

    public void checkNicknameExists(String nickname) {
        if (userRepository.findByNickname(nickname).isPresent()) {
            throw AlreadyNicknameExistException.EXCEPTION;
        }
    }

    public void checkUserPhoneNumber(String phoneNumber) {
        if (userRepository.findByPhoneNumber(phoneNumber).isPresent()) {
            throw AlreadyPhoneNumberExistException.EXCEPTION;
        }
    }

    public void checkEmailExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw AlreadyEmailExistsException.EXCEPTION;
        }
    }
}

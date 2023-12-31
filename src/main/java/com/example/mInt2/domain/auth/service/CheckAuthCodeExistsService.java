package com.example.mInt2.domain.auth.service;

import com.example.mInt2.domain.auth.presentation.dto.request.CheckAuthCodeRequest;
import com.example.mInt2.domain.user.domain.UserAuthCode;
import com.example.mInt2.domain.user.domain.repository.UserAuthCodeRepository;
import com.example.mInt2.domain.user.exception.InvalidCodeException;
import com.example.mInt2.domain.user.exception.UserAuthCodeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CheckAuthCodeExistsService {

    private final UserAuthCodeRepository userAuthCodeRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public void execute(CheckAuthCodeRequest request) {
        UserAuthCode authCode = userAuthCodeRepository.findById(request.getPhoneNumber())
                .orElseThrow(() -> UserAuthCodeNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getAuthCode(), authCode.getCode())) {
            throw InvalidCodeException.EXCEPTION;
        }
    }
}

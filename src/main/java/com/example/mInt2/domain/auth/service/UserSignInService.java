package com.example.mInt2.domain.auth.service;

import com.example.mInt2.domain.auth.exception.PasswordMisMatchException;
import com.example.mInt2.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.mInt2.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.mInt2.domain.user.domain.User;
import com.example.mInt2.domain.user.domain.repository.UserRepository;
import com.example.mInt2.global.exception.UserNotFoundException;
import com.example.mInt2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;



@RequiredArgsConstructor
@Service
public class UserSignInService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserTokenResponse execute(UserSignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail());

        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .refreshToken(refreshToken)
                .build();
    }
}

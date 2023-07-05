package com.example.mInt2.domain.auth.service;

import com.example.mInt2.domain.auth.domain.RefreshToken;
import com.example.mInt2.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.mInt2.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.mInt2.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.mInt2.global.property.jwt.JwtProperties;
import com.example.mInt2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserTokenRefreshService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public UserTokenRefreshResponse execute(String refreshToken) {
        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(redisRefreshToken.getEmail());
        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        String accessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.getEmail());
        return UserTokenRefreshResponse.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .build();
    }
}

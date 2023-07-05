package com.example.mInt2.domain.user.service;

import com.example.mInt2.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.mInt2.domain.user.domain.User;
import com.example.mInt2.domain.user.domain.repository.UserRepository;
import com.example.mInt2.domain.user.facade.UserFacade;
import com.example.mInt2.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.mInt2.global.enums.UserRole;
import com.example.mInt2.global.property.jwt.JwtProperties;
import com.example.mInt2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public UserTokenResponse execute(UserSignUpRequest request) {
        userFacade.checkUserExists(request.getEmail());

        User user = userRepository.save(User.builder()
                .nickname(request.getNickname())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.USER)
                .build());

        String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail());

        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(ZonedDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .build();
    }

}
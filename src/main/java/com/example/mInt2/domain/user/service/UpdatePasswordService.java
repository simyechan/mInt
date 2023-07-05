package com.example.mInt2.domain.user.service;

import com.example.mInt2.domain.auth.exception.PasswordMisMatchException;
import com.example.mInt2.domain.user.domain.User;
import com.example.mInt2.domain.user.facade.UserFacade;
import com.example.mInt2.domain.user.presentation.dto.request.UpdatePasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdatePasswordService {


    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UpdatePasswordRequest request) {
        User user = userFacade.getCurrentUser();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        user.setPassword(passwordEncoder.encode(request.getNewpassword()));
    }
}

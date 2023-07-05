package com.example.mInt2.domain.auth.service;

import com.example.mInt2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckNicknameExistService {

    private final UserFacade userFacade;

    public void execute(String nickname) {
        userFacade.checkNicknameExists(nickname);
    }
}

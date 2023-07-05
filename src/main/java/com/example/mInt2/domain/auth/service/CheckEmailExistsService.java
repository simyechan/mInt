package com.example.mInt2.domain.auth.service;

import com.example.mInt2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckEmailExistsService {
        private final UserFacade userFacade;

        public void execute(String email) {
            userFacade.checkEmailExists(email);
        }
}

package com.example.mInt2.domain.user.presentation;

import com.example.mInt2.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.mInt2.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.mInt2.domain.user.service.UserLogoutService;
import com.example.mInt2.domain.user.service.UserSignUpService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserSignUpService userSignUpService;
    private final UserLogoutService userLogoutService;

    @ApiOperation(value = "회원가입")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserTokenResponse userSignUp(@RequestBody @Valid UserSignUpRequest request) {
        return userSignUpService.execute(request);
    }

    @ApiOperation(value = "로그아웃")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        userLogoutService.execute();
    }
}

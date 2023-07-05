package com.example.mInt2.domain.auth.presentation;

import com.example.mInt2.domain.auth.presentation.dto.request.CheckAuthCodeRequest;
import com.example.mInt2.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.mInt2.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.mInt2.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.mInt2.domain.auth.service.CheckAuthCodeExistsService;
import com.example.mInt2.domain.auth.service.CheckEmailExistsService;
import com.example.mInt2.domain.auth.service.CheckNicknameExistService;
import com.example.mInt2.domain.auth.service.UserSignInService;
import com.example.mInt2.domain.auth.service.UserTokenRefreshService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class AuthController {

    private final UserSignInService userSignInService;
    private final CheckNicknameExistService checkNicknameExistService;
    private final CheckAuthCodeExistsService checkAuthCodeExistsService;
    private final CheckEmailExistsService checkEmailExistsService;
    private final UserTokenRefreshService userTokenRefreshService;

    @ApiOperation(value = "로그인")
    @PostMapping("/token")
    public UserTokenResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }

    @ApiOperation(value = "토큰 재발급")
    @PatchMapping("/token")
    public UserTokenRefreshResponse userTokenRefresh(@RequestHeader("Refresh-Token") String refreshToken) {
        return userTokenRefreshService.execute(refreshToken);
    }

    @ApiOperation(value = "닉네임 중복 체크")
    @RequestMapping(value = "/nickname", method = RequestMethod.HEAD)
    public void checkNicknameExist(@NotBlank @RequestParam(name = "nickname") String nickname) {
        checkNicknameExistService.execute(nickname);
    }

    @ApiOperation(value = "이메일 중복 체크")
    @RequestMapping(value = "/email", method = RequestMethod.HEAD)
    public void checkEmailExist(@NotBlank @RequestParam(name = "email") String email) {
        checkEmailExistsService.execute(email);
    }

    @ApiOperation(value = "인증번호 체크")
    @RequestMapping(value = "/verification-codes", method = RequestMethod.HEAD)
    public void checkAuthCodeExists(@Valid CheckAuthCodeRequest request) {
        checkAuthCodeExistsService.execute(request);
    }
}

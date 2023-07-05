package com.example.mInt2.domain.auth.presentation.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserSignInRequest {

    @ApiModelProperty(value = "email", example = "soso@gmail.com")
    @NotBlank(message = "email는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @ApiModelProperty(value = "password", example = "souso1234")
    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Length(min = 1, max = 30, message = "password는 30글자 이하여야 합니다.")
    private String password;
}

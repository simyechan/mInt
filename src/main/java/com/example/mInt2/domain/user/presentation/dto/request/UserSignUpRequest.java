package com.example.mInt2.domain.user.presentation.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @ApiModelProperty(value = "email", example = "soso@gmail.com")
    @NotBlank(message = "email은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Email(message = "이메일 형식에 올바르지 않습니다.")
    private String email;

    @ApiModelProperty(value = "password", example = "souso1234")
    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Length(min = 1, max = 30, message = "password는 30글자 이하여야 합니다.")
    private String password;

    @ApiModelProperty(value = "nickname", example = "소소")
    @NotBlank(message = "nickname은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Length(min = 1, max = 20, message = "nickname은 20글자 이하여야 합니다.")
    private String nickname;

    @ApiModelProperty(value = "phoneNumber", example = "01011112222")
    @NotBlank(message = "phone_number는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 1, max = 15, message = "ID는 15글자여야 합니다.")
    private String phoneNumber;

}


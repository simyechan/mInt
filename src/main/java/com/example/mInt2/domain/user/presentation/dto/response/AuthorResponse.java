package com.example.mInt2.domain.user.presentation.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthorResponse {

    @ApiModelProperty(value = "유저 식별 ID", example = "1")
    private final Long userId;

    @ApiModelProperty(value = "닉네임", example = "소소")
    private final String nickname;
}

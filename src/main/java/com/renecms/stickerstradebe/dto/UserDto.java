package com.renecms.stickerstradebe.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserDto {
    private Integer id;

    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;
}
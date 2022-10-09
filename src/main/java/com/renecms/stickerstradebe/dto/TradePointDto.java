package com.renecms.stickerstradebe.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class TradePointDto {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String address;
}
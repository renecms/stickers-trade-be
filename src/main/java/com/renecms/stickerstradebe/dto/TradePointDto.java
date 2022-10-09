package com.renecms.stickerstradebe.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TradePointDto {
    private Integer id;
    private String name;
    private String address;
}
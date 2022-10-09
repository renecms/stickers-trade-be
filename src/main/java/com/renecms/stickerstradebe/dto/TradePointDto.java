package com.renecms.stickerstradebe.dto;

import com.renecms.stickerstradebe.entity.TradePoint;
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

    public TradePoint toEntity() {
        return TradePoint.builder()
                .id(id)
                .address(address)
                .name(name)
                .build();
    }
}
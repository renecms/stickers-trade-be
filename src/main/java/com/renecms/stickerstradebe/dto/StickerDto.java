package com.renecms.stickerstradebe.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class StickerDto {
    private Integer id;

    @NotNull
    private String name;
    @NotNull
    private Integer number;
    private String imageUrl;
    @NotNull
    private String country;
}

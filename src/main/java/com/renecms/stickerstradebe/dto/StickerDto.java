package com.renecms.stickerstradebe.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StickerDto {
    private String name;
    private Integer number;
    private String imageUrl;
    private String country;
}

package com.renecms.stickerstradebe.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StickerDto {
    private Integer id;
    private String name;
    private Integer number;
    private String imageUrl;
    private String country;
}

package com.renecms.stickerstradebe.dto;

import com.renecms.stickerstradebe.entity.Sticker;
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

    public Sticker toEntity() {
        return Sticker.builder()
                .name(name)
                .country(country)
                .number(number)
                .imageUrl(imageUrl)
                .id(id)
                .build();
    }
}

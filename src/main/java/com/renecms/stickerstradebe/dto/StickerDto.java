package com.renecms.stickerstradebe.dto;

import com.renecms.stickerstradebe.entity.Sticker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

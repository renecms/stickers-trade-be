package com.renecms.stickerstradebe.entity;

import com.renecms.stickerstradebe.dto.StickerDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sticker", schema = "stickers", catalog = "postgres")
public class Sticker {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Integer number;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "country")
    private String country;

    public StickerDto toDto() {
        return StickerDto.builder()
                .id(id)
                .name(name)
                .number(number)
                .imageUrl(imageUrl)
                .country(country)
                .build();
    }
}

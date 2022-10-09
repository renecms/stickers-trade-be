package com.renecms.stickerstradebe.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "sticker", schema = "stickers", catalog = "postgres")
public class StickerEntity {
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
}

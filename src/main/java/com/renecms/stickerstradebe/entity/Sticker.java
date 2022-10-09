package com.renecms.stickerstradebe.entity;

import com.renecms.stickerstradebe.dto.StickerDto;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sticker sticker = (Sticker) o;
        return id != null && Objects.equals(id, sticker.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

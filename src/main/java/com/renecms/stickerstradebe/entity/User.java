package com.renecms.stickerstradebe.entity;

import com.renecms.stickerstradebe.dto.UserDto;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"user\"", schema = "stickers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "creation_date")
    private LocalTime creationDate;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_sticker_wishlist", schema = "stickers",
            joinColumns = @JoinColumn(table = "user", name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(table = "sticker", name = "sticker_id", referencedColumnName = "id"))
    private Set<Sticker> userStickerWishList;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_sticker_owned", schema = "stickers",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sticker_id", referencedColumnName = "id"))
    private Set<Sticker> userStickerOwnedList;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_trade_point", schema = "stickers",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trade_point_id", referencedColumnName = "id"))
    private Set<TradePoint> userTradePointList;

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .userStickerWishList(userStickerWishList
                        .stream()
                        .map(Sticker::toDto)
                        .collect(Collectors.toSet()))
                .userStickerOwnedList(userStickerOwnedList
                        .stream()
                        .map(Sticker::toDto)
                        .collect(Collectors.toSet()))
                .userTradePointList(userTradePointList
                        .stream()
                        .map(TradePoint::toDto)
                        .collect(Collectors.toSet()))
                .build();
    }

    public UserDto toSimplifiedDto() {
        return UserDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
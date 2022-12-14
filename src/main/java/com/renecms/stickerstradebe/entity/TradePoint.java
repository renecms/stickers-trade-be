package com.renecms.stickerstradebe.entity;

import com.renecms.stickerstradebe.dto.TradePointDto;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trade_point", schema = "stickers")
public class TradePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "creation_date")
    private LocalTime creationDate;

    @ManyToMany(mappedBy = "userTradePointList")
    private Set<User> tradePointUserList;

    public TradePointDto toDto() {
        return TradePointDto.builder()
                .id(id)
                .name(name)
                .address(address)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TradePoint that = (TradePoint) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
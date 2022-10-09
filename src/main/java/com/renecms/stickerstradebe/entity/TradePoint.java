package com.renecms.stickerstradebe.entity;

import com.renecms.stickerstradebe.dto.TradePointDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
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

    public TradePointDto toDto() {
        return TradePointDto.builder()
                .id(id)
                .name(name)
                .address(address)
                .build();
    }
}
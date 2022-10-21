package com.renecms.stickerstradebe.dto;

import com.renecms.stickerstradebe.entity.Trade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTradeDto {
    private String ownerId;
    private List<Trade> trades;
}

package com.renecms.stickerstradebe.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TradeDto {
    private Integer StickerId;
    private Map<Integer, List<Integer>> usersByTradePoint;
}

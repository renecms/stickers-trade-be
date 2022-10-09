package com.renecms.stickerstradebe.controller;

import com.renecms.stickerstradebe.dto.TradePointDto;
import com.renecms.stickerstradebe.dto.UserDto;
import com.renecms.stickerstradebe.service.TradePointService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class TradePointController {
    public TradePointService service;

    @GetMapping("/trade_point/{id}")
    public TradePointDto get(@PathVariable Integer id) {
        return service.getTradePoints(id);
    }

    @GetMapping("/trade_point")
    public List<TradePointDto> getAll() {
        return service.getAllTradePoints();
    }

    @PostMapping("/trade_point")
    public TradePointDto save(@Valid @RequestBody TradePointDto tradePointDto) {
        return service.createTradePoint(tradePointDto);
    }

    @PostMapping("/trade_point/{id}")
    public TradePointDto update(@PathVariable Integer id, @Valid @RequestBody TradePointDto tradePointDto) {
        tradePointDto.setId(id);
        return service.updateTradePoint(tradePointDto);
    }

    @GetMapping("/trade_point/{id}/user")
    public List<UserDto> getAllUsers(@PathVariable Integer id) {
        return service.getUsersInTradePoint(id);
    }
}

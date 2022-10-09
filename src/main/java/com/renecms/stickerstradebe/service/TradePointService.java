package com.renecms.stickerstradebe.service;

import com.google.common.collect.ImmutableList;
import com.renecms.stickerstradebe.dto.TradePointDto;
import com.renecms.stickerstradebe.dto.UserDto;
import com.renecms.stickerstradebe.entity.TradePoint;
import com.renecms.stickerstradebe.entity.User;
import com.renecms.stickerstradebe.repository.TradePointRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TradePointService {
    public TradePointRepository tradePointRepository;

    public TradePointDto getTradePoints(Integer id) {
        return tradePointRepository.findById(id)
                .map(TradePoint::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public TradePointDto updateTradePoint(TradePointDto tradePointDto) {
        TradePoint tradePointToBeUpdated;
        Optional<TradePoint> tradePoint = tradePointRepository.findById(tradePointDto.getId());
        if (tradePoint.isPresent()) {
            tradePointToBeUpdated = tradePoint.get();
            tradePointToBeUpdated.setAddress(tradePointDto.getAddress());
            tradePointToBeUpdated.setName(tradePointDto.getName());

            return tradePointRepository.save(tradePointToBeUpdated).toDto();
        } else {
            throw new EntityNotFoundException();
        }
    }

    public TradePointDto createTradePoint(TradePointDto tradePointDto) {
        TradePoint tradePoint = TradePoint.builder()
                .name(tradePointDto.getName())
                .address(tradePointDto.getAddress())
                .build();
        return tradePointRepository.save(tradePoint).toDto();
    }

    public List<TradePointDto> getAllTradePoints() {
        return tradePointRepository.findAll().stream().map(TradePoint::toDto).collect(Collectors.toList());
    }

    public List<UserDto> getUsersInTradePoint(Integer id) {
        return tradePointRepository.findById(id)
                .map(tradePoint -> tradePoint.getTradePointUserList()
                        .stream()
                        .map(User::toSimplifiedDto)
                        .collect(Collectors.toList()))
                .orElse(ImmutableList.of());
    }
}

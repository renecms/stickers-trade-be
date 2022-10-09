package com.renecms.stickerstradebe.service;

import com.renecms.stickerstradebe.dto.StickerDto;
import com.renecms.stickerstradebe.entity.StickerEntity;
import com.renecms.stickerstradebe.repository.StickerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StickerService {
    public StickerRepository stickerRepository;

    public List<StickerDto> getAllStickers() {
        return stickerRepository.findAll().stream().map(StickerEntity::toDto).collect(Collectors.toList());
    }

    ;
}

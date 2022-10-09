package com.renecms.stickerstradebe.service;

import com.renecms.stickerstradebe.entity.StickerEntity;
import com.renecms.stickerstradebe.repository.StickerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StickerService {
    public StickerRepository stickerRepository;

    public List<StickerEntity> getAllStickers() {
      return stickerRepository.findAll();
    };
}

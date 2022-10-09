package com.renecms.stickerstradebe.service;

import com.renecms.stickerstradebe.dto.StickerDto;
import com.renecms.stickerstradebe.entity.Sticker;
import com.renecms.stickerstradebe.repository.StickerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StickerService {
    public StickerRepository stickerRepository;

    public StickerDto getStickers(Integer id) {
        return stickerRepository.findById(id)
                .map(Sticker::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public StickerDto updateSticker(StickerDto stickerDto) {
        Sticker stickerToBeUpdated;
        Optional<Sticker> sticker = stickerRepository.findById(stickerDto.getId());

        if (sticker.isPresent()) {
            stickerToBeUpdated = sticker.get();
            stickerToBeUpdated.setCountry(stickerDto.getCountry());
            stickerToBeUpdated.setName(stickerDto.getName());
            stickerToBeUpdated.setNumber(stickerDto.getNumber());
            stickerToBeUpdated.setImageUrl(stickerDto.getImageUrl());

            return stickerRepository.save(stickerToBeUpdated).toDto();
        } else {
            throw new EntityNotFoundException();
        }
    }

    public StickerDto createSticker(StickerDto stickerDto) {
        Sticker sticker = Sticker.builder()
                .name(stickerDto.getName())
                .number(stickerDto.getNumber())
                .country(stickerDto.getCountry())
                .imageUrl(stickerDto.getImageUrl())
                .build();
        return stickerRepository.save(sticker).toDto();
    }

    public List<StickerDto> getAllStickers() {
        return stickerRepository.findAll().stream().map(Sticker::toDto).collect(Collectors.toList());
    }

    ;
}

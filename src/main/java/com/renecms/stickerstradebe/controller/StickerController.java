package com.renecms.stickerstradebe.controller;

import com.renecms.stickerstradebe.dto.StickerDto;
import com.renecms.stickerstradebe.service.StickerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class StickerController {
    public StickerService service;

    @GetMapping("/sticker/{id}")
    public StickerDto get(@PathVariable Integer id) {
        return service.getStickers(id);
    }

    @GetMapping("/sticker")
    public List<StickerDto> getAll() {
        return service.getAllStickers();
    }

    @PostMapping("/sticker")
    public StickerDto save(@Valid @RequestBody StickerDto stickerDto) {
        return service.createSticker(stickerDto);
    }

    @PostMapping("/sticker/{id}")
    public StickerDto update(@PathVariable Integer id, @Valid @RequestBody StickerDto stickerDto) {
        stickerDto.setId(id);
        return service.updateSticker(stickerDto);
    }
}

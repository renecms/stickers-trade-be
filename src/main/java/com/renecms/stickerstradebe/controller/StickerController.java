package com.renecms.stickerstradebe.controller;

import com.renecms.stickerstradebe.dto.StickerDto;
import com.renecms.stickerstradebe.service.StickerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StickerController {
    public StickerService service;

    @GetMapping("/sticker")
    public List<StickerDto> getAll() {
        return service.getAllStickers();
    }
}

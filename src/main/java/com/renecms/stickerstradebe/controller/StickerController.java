package com.renecms.stickerstradebe.controller;

import com.renecms.stickerstradebe.entity.StickerEntity;
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
    public List<StickerEntity> getAll(){
        return service.getAllStickers();
    }
}

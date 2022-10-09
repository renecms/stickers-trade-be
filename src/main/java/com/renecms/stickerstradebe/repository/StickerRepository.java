package com.renecms.stickerstradebe.repository;

import com.renecms.stickerstradebe.entity.Sticker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickerRepository extends CrudRepository<Sticker, Integer> {
    List<Sticker> findAll();
}

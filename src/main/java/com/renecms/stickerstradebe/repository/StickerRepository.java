package com.renecms.stickerstradebe.repository;

import com.renecms.stickerstradebe.entity.StickerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickerRepository extends CrudRepository<StickerEntity, Integer> {
    List<StickerEntity> findAll();
}

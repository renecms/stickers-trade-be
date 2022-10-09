package com.renecms.stickerstradebe.repository;

import com.renecms.stickerstradebe.entity.TradePoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradePointRepository extends CrudRepository<TradePoint, Integer> {
    List<TradePoint> findAll();
}

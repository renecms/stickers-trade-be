package com.renecms.stickerstradebe.repository;

import com.renecms.stickerstradebe.entity.Trade;
import com.renecms.stickerstradebe.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    @Query(nativeQuery = true, value = """
            select usw.sticker_id as StickerID,
                   s.name         as StickerName,
                   s.number       as StickerNumber,
                   s.image_url    as StickerUrl,
                   s.country      as StickerCountry,
                   uso.user_id    as OwnerId,
                   usow.name      as OwnerName
            from stickers.user_sticker_wishlist usw
                     inner join stickers."user" user_wishlist
                                on user_wishlist.id = usw.user_id
                     inner join stickers.user_sticker_owned uso on usw.sticker_id = uso.sticker_id
                     inner join stickers."user" usow on uso.user_id = usow.id
                     inner join stickers.user_trade_point utp on uso.user_id = utp.user_id
                     inner join stickers.sticker s on s.id = uso.sticker_id
            where usw.user_id = :userId
              AND uso.user_id != :userId
              AND utp.trade_point_id = :tradePointId
            group by StickerID, OwnerId, OwnerName, StickerName, StickerNumber, StickerUrl, StickerCountry """)
    List<Trade> getAllTradesByUserIdAndTradePointId(
            @Param("userId") Integer userId, @Param("tradePointId") Integer tradePointId);
}

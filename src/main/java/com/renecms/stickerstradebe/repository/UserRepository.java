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

    @Query(nativeQuery = true,
            value = """
                    select usw.sticker_id     as StickerID,
                     string_agg(CAST(uso.user_id as varchar), ',') as OwnerIds,
                           utp.trade_point_id as TradePointId
                    from stickers.user_sticker_wishlist usw
                             inner join stickers."user" user_wishlist
                                        on user_wishlist.id = usw.user_id
                             inner join stickers.user_sticker_owned uso on usw.sticker_id = uso.sticker_id
                             inner join stickers.user_trade_point utp on uso.user_id = utp.user_id
                    where usw.user_id = :userId\s
                      AND uso.user_id != :userId\s
                      AND utp.trade_point_id in (select p.trade_point_id
                                                 from stickers."user"
                                                          inner join stickers.user_trade_point p                                        on "user".id = p.user_id
                                                 where p.user_id = :userId)
                    group by StickerID, TradePointId""")
    List<Trade> getAllTradesByUserId(
            @Param("userId") Integer userId);
}

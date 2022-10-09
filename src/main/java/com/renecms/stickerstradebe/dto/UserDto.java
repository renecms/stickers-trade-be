package com.renecms.stickerstradebe.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class UserDto {
    private Integer id;

    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    private Set<StickerDto> userStickerWishList;

    private Set<StickerDto> userStickerOwnedList;

    private Set<TradePointDto> userTradePointList;
}
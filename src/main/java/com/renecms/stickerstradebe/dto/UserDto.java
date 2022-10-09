package com.renecms.stickerstradebe.dto;

import com.renecms.stickerstradebe.entity.Sticker;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class UserDto {
    private Integer id;

    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    private List<Sticker> userStickerWishlist;

    private List<Sticker> userStickerOwned;
}
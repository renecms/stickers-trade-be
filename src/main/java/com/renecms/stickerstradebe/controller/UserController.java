package com.renecms.stickerstradebe.controller;

import com.renecms.stickerstradebe.dto.UserDto;
import com.renecms.stickerstradebe.dto.UserTradeDto;
import com.renecms.stickerstradebe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@RestController
@AllArgsConstructor
public class UserController {
    public UserService service;

    @GetMapping("/user/{id}")
    public UserDto get(@PathVariable Integer id) {
        return service.getUsers(id);
    }

    @GetMapping("/user")
    public List<UserDto> getAll() {
        return service.getAllUsers();
    }

    @PostMapping("/user")
    public UserDto save(@Valid @RequestBody UserDto userDto) {
        return service.createUser(userDto);
    }

    @PutMapping("/user/{id}")
    public UserDto update(@PathVariable Integer id, @Valid @RequestBody UserDto userDto) {
        userDto.setId(id);
        return service.updateUser(userDto);
    }

    @PostMapping("/user/{userId}/trade_point/{tradePointId}")
    public void linkUserToTradePoint(@PathVariable Integer tradePointId, @PathVariable Integer userId) {
        service.addTradePointToUser(userId, tradePointId);
    }

    @DeleteMapping("/user/{userId}/trade_point/{tradePointId}")
    public void removeLinkUserToTradePoint(@PathVariable Integer tradePointId, @PathVariable Integer userId) {
        service.removeTradePointToUser(userId, tradePointId);
    }

    @PostMapping("/user/{userId}/owned_sticker/{stickerId}")
    public void addStickerToUserOwnedList(@PathVariable Integer stickerId, @PathVariable Integer userId) {
        service.addStickerToUserOwnedList(userId, stickerId);
    }

    @DeleteMapping("/user/{userId}/owned_sticker/{stickerId}")
    public void removeStickerFromUserOwnedList(@PathVariable Integer stickerId, @PathVariable Integer userId) {
        service.removeStickerFromUserOwnedList(userId, stickerId);
    }

    @PostMapping("/user/{userId}/sticker_wishlist/{stickerId}")
    public void addStickerToUserWishList(@PathVariable Integer stickerId, @PathVariable Integer userId) {
        service.addStickerToUserWishlist(userId, stickerId);
    }

    @DeleteMapping("/user/{userId}/sticker_wishlist/{stickerId}")
    public void removeStickerFromUserWishList(@PathVariable Integer stickerId, @PathVariable Integer userId) {
        service.removeStickerFromUserWishlist(userId, stickerId);
    }

    @GetMapping("/user/{userId}/trades/{tradePoint}")
    public List<UserTradeDto> getUserTrades(@PathVariable Integer userId, @PathVariable Integer tradePoint) {
        return service.getAllUsersTrades(userId, tradePoint)
                .stream()
                .collect(groupingBy(trade -> trade.getOwnerId()))
                .entrySet()
                .stream()
                .map(entry -> UserTradeDto
                        .builder()
                        .ownerId(entry.getKey())
                        .trades(entry.getValue())
                        .build())
                .sorted((first, second) -> Integer.compare(second.getTrades().size(), first.getTrades().size()))
                .collect(Collectors.toList());
    }
}

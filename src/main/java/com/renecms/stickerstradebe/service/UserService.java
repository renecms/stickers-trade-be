package com.renecms.stickerstradebe.service;

import com.google.common.collect.ImmutableSet;
import com.renecms.stickerstradebe.dto.UserDto;
import com.renecms.stickerstradebe.entity.Sticker;
import com.renecms.stickerstradebe.entity.TradePoint;
import com.renecms.stickerstradebe.entity.User;
import com.renecms.stickerstradebe.repository.StickerRepository;
import com.renecms.stickerstradebe.repository.TradePointRepository;
import com.renecms.stickerstradebe.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    public UserRepository userRepository;

    public StickerRepository stickerRepository;

    public TradePointRepository tradePointRepository;

    public UserDto getUsers(Integer id) {
        return userRepository.findById(id)
                .map(User::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public UserDto updateUser(UserDto userDto) {
        User userToBeUpdated;
        Optional<User> user = userRepository.findById(userDto.getId());
        if (user.isPresent()) {
            userToBeUpdated = user.get();
            userToBeUpdated.setEmail(userDto.getEmail());
            userToBeUpdated.setName(userDto.getName());

            return userRepository.save(userToBeUpdated).toDto();
        } else {
            throw new EntityNotFoundException();
        }
    }

    public UserDto createUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .userStickerOwnedList(ImmutableSet.of())
                .userStickerWishList(ImmutableSet.of())
                .userTradePointList(ImmutableSet.of())
                .build();
        return userRepository.save(user).toDto();
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(User::toDto).collect(Collectors.toList());
    }

    public boolean addTradePointToUser(Integer userId, Integer tradePointId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<TradePoint> tradePoint = tradePointRepository.findById(tradePointId);

        if (user.isPresent() && tradePoint.isPresent()) {
            user.get().addTradePoint(tradePoint.get());
            userRepository.save(user.get());
            return true;
        }
        return false;
    }

    public boolean removeTradePointToUser(Integer userId, Integer tradePointId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<TradePoint> tradePoint = tradePointRepository.findById(tradePointId);

        if (user.isPresent() && tradePoint.isPresent()) {
            user.get().removeTradePoint(tradePoint.get());
            userRepository.save(user.get());
            return true;
        }
        return false;
    }

    public boolean addStickerToUserWishlist(Integer userId, Integer stickerId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Sticker> sticker = stickerRepository.findById(stickerId);

        if (user.isPresent() && sticker.isPresent()) {
            user.get().addWantedSticker(sticker.get());
            userRepository.save(user.get());
            return true;
        }
        return false;
    }

    public boolean removeStickerFromUserWishlist(Integer userId, Integer stickerId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Sticker> sticker = stickerRepository.findById(stickerId);

        if (user.isPresent() && sticker.isPresent()) {
            user.get().removeWantedSticker(sticker.get());
            userRepository.save(user.get());
            return true;
        }
        return false;
    }

    public boolean addStickerToUserOwnedList(Integer userId, Integer stickerId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Sticker> sticker = stickerRepository.findById(stickerId);

        if (user.isPresent() && sticker.isPresent()) {
            user.get().addOwnedSticker(sticker.get());
            userRepository.save(user.get());
            return true;
        }
        return false;
    }

    public boolean removeStickerFromUserOwnedList(Integer userId, Integer stickerId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Sticker> sticker = stickerRepository.findById(stickerId);

        if (user.isPresent() && sticker.isPresent()) {
            user.get().removeOwnedSticker(sticker.get());
            userRepository.save(user.get());
            return true;
        }
        return false;
    }
}

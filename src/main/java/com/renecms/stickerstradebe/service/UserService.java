package com.renecms.stickerstradebe.service;

import com.google.common.collect.ImmutableSet;
import com.renecms.stickerstradebe.dto.StickerDto;
import com.renecms.stickerstradebe.dto.TradePointDto;
import com.renecms.stickerstradebe.dto.UserDto;
import com.renecms.stickerstradebe.entity.Sticker;
import com.renecms.stickerstradebe.entity.TradePoint;
import com.renecms.stickerstradebe.entity.User;
import com.renecms.stickerstradebe.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    public UserRepository userRepository;

    public UserDto getUsers(Integer id) {
        return userRepository.findById(id)
                .map(User::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    private static Set<TradePoint> convertTradePointDtoListToEntityList(UserDto userDto) {
        return userDto
                .getUserTradePointList()
                .stream()
                .map(TradePointDto::toEntity)
                .collect(Collectors.toSet());
    }

    private static Set<Sticker> convertStickerDtoListToEntityList(Set<StickerDto> stickerDtoList) {
        return stickerDtoList
                .stream()
                .map(StickerDto::toEntity)
                .collect(Collectors.toSet());
    }

    public UserDto updateUser(UserDto userDto) {
        User userToBeUpdated;
        Optional<User> user = userRepository.findById(userDto.getId());
        if (user.isPresent()) {
            userToBeUpdated = user.get();
            userToBeUpdated.setEmail(userDto.getEmail());
            userToBeUpdated.setName(userDto.getName());
            userToBeUpdated.setUserStickerWishList(userDto.getUserStickerOwnedList() != null ?
                    convertStickerDtoListToEntityList(userDto.getUserStickerOwnedList()) : ImmutableSet.of());
            userToBeUpdated.setUserStickerOwnedList(userDto.getUserStickerWishList() != null ?
                    convertStickerDtoListToEntityList(userDto.getUserStickerWishList()) : ImmutableSet.of());
            userToBeUpdated.setUserTradePointList(userDto.getUserTradePointList() != null ?
                    convertTradePointDtoListToEntityList(userDto) : ImmutableSet.of());

            return userRepository.save(userToBeUpdated).toDto();
        } else {
            throw new EntityNotFoundException();
        }
    }

    public UserDto createUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .userStickerOwnedList(userDto.getUserStickerOwnedList() != null ?
                        convertStickerDtoListToEntityList(userDto
                                .getUserStickerOwnedList()) : ImmutableSet.of())
                .userStickerWishList(userDto.getUserStickerWishList() != null ?
                        convertStickerDtoListToEntityList(userDto
                                .getUserStickerWishList()) : ImmutableSet.of())
                .userTradePointList(userDto.getUserTradePointList() != null ?
                        convertTradePointDtoListToEntityList(userDto) : ImmutableSet.of())
                .build();
        return userRepository.save(user).toDto();
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(User::toDto).collect(Collectors.toList());
    }
}

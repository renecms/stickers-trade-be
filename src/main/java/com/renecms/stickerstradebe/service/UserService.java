package com.renecms.stickerstradebe.service;

import com.renecms.stickerstradebe.dto.UserDto;
import com.renecms.stickerstradebe.entity.User;
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
                .build();
        return userRepository.save(user).toDto();
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(User::toDto).collect(Collectors.toList());
    }
}

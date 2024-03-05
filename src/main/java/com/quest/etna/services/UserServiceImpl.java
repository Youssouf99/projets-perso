package com.quest.etna.services;

import com.quest.etna.dtos.UserDto;
import com.quest.etna.exceptions.UserAlreadyExistsException;
import com.quest.etna.models.User;
import com.quest.etna.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import static com.quest.etna.mappers.UserMapper.toUser;
import static com.quest.etna.mappers.UserMapper.toUserDto;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto){
        boolean existingUser = userRepository.existsUserByUsername(userDto.getUsername());
        if (existingUser) {
                throw new UserAlreadyExistsException("User already exists with username: " + userDto.getUsername());
        }
        User user = toUser(userDto);
        User createdUser = userRepository.save(user);
        return toUserDto(createdUser);
    }

}

package com.quest.etna.mappers;
import com.quest.etna.dtos.UserDto;
import com.quest.etna.models.User;
import org.springframework.beans.BeanUtils;

public class UserMapper {
    public static User toUser(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}

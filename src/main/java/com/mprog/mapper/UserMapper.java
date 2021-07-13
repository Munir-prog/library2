package com.mprog.mapper;

import com.mprog.dto.UserDto;
import com.mprog.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<User, UserDto>{

    private static final UserMapper INSTANCE = new UserMapper();

    @Override
    public UserDto mapFrom(User obj) {
        return UserDto.builder()
                .id(obj.getId())
                .name(obj.getName())
                .birthday(obj.getBirthday())
                .email(obj.getEmail())
                .image(obj.getImage())
                .role(obj.getRole())
                .gender(obj.getGender())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}

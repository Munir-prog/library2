package com.mprog.mapper;

import com.mprog.dto.CreateUserDto;
import com.mprog.entity.Gender;
import com.mprog.entity.Role;
import com.mprog.entity.User;
import com.mprog.util.LocalDateFormatter;

import java.time.LocalDate;

public class CreateUserMapper implements Mapper<CreateUserDto, User>{

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto obj) {
        return User.builder()
                .name(obj.getName())
                .birthday(LocalDateFormatter.format(obj.getBirthday()))
                .email(obj.getEmail())
                .password(obj.getPassword())
                .role(Role.valueOf(obj.getRole()))
                .gender(Gender.valueOf(obj.getGender()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}

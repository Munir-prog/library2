package com.mprog.dto;


import com.mprog.entity.Gender;
import com.mprog.entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    String image;
    Role role;
    Gender gender;

}

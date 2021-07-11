package com.mprog.entity;


import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    String password;
    Role role;
    Gender gender;

}

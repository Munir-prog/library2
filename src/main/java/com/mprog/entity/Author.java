package com.mprog.entity;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Author {
    private long id;
    private String firstName;
    private String lastName;
    private int yearOfBirth;
}
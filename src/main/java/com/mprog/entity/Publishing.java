package com.mprog.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Publishing {
    private Integer id;
    private String publishingName;
    private String phoneNumber;
    private String city;
    private String country;
}

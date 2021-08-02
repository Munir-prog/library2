package com.mprog.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Builder
@Setter
public class Publishing {
    private Integer id;
    private String publishingName;
    private String phoneNumber;
    private String website;
    private String city;
    private String country;
}

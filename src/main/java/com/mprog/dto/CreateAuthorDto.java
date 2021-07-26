package com.mprog.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateAuthorDto {
    String firstName;
    String lastName;
    String yearOfBirth;
}

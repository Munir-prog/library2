package com.mprog.dto;
import lombok.*;

@Value
@Builder
public class AuthorDto {
    Long id;
    String fullName;
}


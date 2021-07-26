package com.mprog.mapper;

import com.mprog.dto.CreateAuthorDto;
import com.mprog.entity.Author;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateAuthorMapper implements Mapper<CreateAuthorDto, Author>{

    private static final CreateAuthorMapper INSTANCE = new CreateAuthorMapper();


    @Override
    public Author mapFrom(CreateAuthorDto obj) {
        return Author.builder()
                .firstName(obj.getFirstName())
                .lastName(obj.getLastName())
                .yearOfBirth(Integer.parseInt(obj.getYearOfBirth()))
                .build();
    }


    public static CreateAuthorMapper getInstance() {
        return INSTANCE;
    }
}

package com.mprog.service;

import com.mprog.dao.AuthorDao;
import com.mprog.dto.AuthorDto;
import com.mprog.dto.CreateAuthorDto;
import com.mprog.entity.Author;
import com.mprog.exception.ValidationException;
import com.mprog.mapper.CreateAuthorMapper;
import com.mprog.validator.CreateAuthorValidator;
import com.mprog.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorService {

    private static final AuthorService INSTANCE = new AuthorService();

    private final AuthorDao authorDao = AuthorDao.getInstance();
    private final CreateAuthorMapper createAuthorMapper = CreateAuthorMapper.getInstance();
    private final CreateAuthorValidator createAuthorValidator = CreateAuthorValidator.getInstance();

    public /*no know*/void delete(CreateAuthorDto authorDto){
        var firstName = authorDto.getFirstName();
        var lastName = authorDto.getLastName();
        authorDao.deleteByNameAndSurname(firstName, lastName);
    }

    public Author save(CreateAuthorDto authorDto){
        var validationResult = createAuthorValidator.isValid(authorDto);
        if (!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }
        var author = createAuthorMapper.mapFrom(authorDto);
        return authorDao.save(author);
    }


    public List<AuthorDto> findAll() {
        return authorDao.findAll()
                .stream()
                .map(author -> AuthorDto.builder()
                        .id(author.getId())
                        .fullName(
                                """
                                        %s - %s
                                        """.formatted(author.getFirstName(), author.getLastName())
                        )
                        .build())
                        .collect(toList());
    }

    public static AuthorService getInstance() {
        return INSTANCE;
    }
}

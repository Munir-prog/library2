package com.mprog.service;

import com.mprog.dao.AuthorDao;
import com.mprog.dto.AuthorDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorService {

    private static final AuthorService INSTANCE = new AuthorService();

    private static final AuthorDao authorDao = AuthorDao.getInstance();

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

package com.mprog.dao;

import com.mprog.entity.Author;
import com.mprog.util.ConnectionManager;
import lombok.Getter;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AuthorDao implements Dao<Long, Author> {

    private static final AuthorDao INSTANCE = new AuthorDao();
    private static final String FIND_ID_BY_NAME = """
            SELECT id
            FROM authors
            WHERE first_name = ?
            AND last_name = ?
            """;

    private AuthorDao() {
    }

    private static final String FIND_ALL = """
            SELECT id, first_name, last_name, year_of_birth
            FROM authors
            """;

    @SneakyThrows
    public Long findAuthorIdByNameAndLastName(String authorFirstName, String authorLastName) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ID_BY_NAME)) {
            preparedStatement.setObject(1, authorFirstName);
            preparedStatement.setObject(2, authorLastName);

            var resultSet = preparedStatement.executeQuery();
            Long authorId = null;

            if (resultSet.next()){
                authorId = resultSet.getObject("id", Long.class);
            }

            return authorId;
        }
    }

    @SneakyThrows
    @Override
    public List<Author> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL)) {

            List<Author> authors = new ArrayList<>();
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                authors.add(buildAuthor(resultSet));
            }
            return authors;
        }
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Author entity) {

    }

    @Override
    public Author save(Author entity) {
        return null;
    }

    @SneakyThrows
    private Author buildAuthor(ResultSet resultSet) {
        return new Author(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("first_name", String.class),
                resultSet.getObject("last_name", String.class),
                resultSet.getObject("year_of_birth", Integer.class)
        );
    }

    public static AuthorDao getInstance() {
        return INSTANCE;
    }
}

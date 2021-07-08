package com.mprog.dao;

import com.mprog.entity.Author;
import com.mprog.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDao implements Dao<Long, Author> {

    private static final String FIND_ALL = """
            SELECT id, first_name, last_name, year_of_birth
            FROM authors
            """;

    @SneakyThrows
    @Override
    public List<Author> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL)) {

            List<Author> authors = new ArrayList<>();
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
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
}

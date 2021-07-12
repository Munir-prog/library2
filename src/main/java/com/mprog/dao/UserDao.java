package com.mprog.dao;

import com.mprog.entity.User;
import com.mprog.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User>{
    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
            INSERT INTO users (name, birthday, email, image, password, role, gender) 
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

    @SneakyThrows
    @Override
    public User save(User entity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setObjects(entity, preparedStatement);

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;
        }
    }

    private void setObjects(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setObject(1, entity.getName());
        preparedStatement.setObject(2, entity.getBirthday());
        preparedStatement.setObject(3, entity.getEmail());
        preparedStatement.setObject(4, entity.getImage());
        preparedStatement.setObject(5, entity.getPassword());
        preparedStatement.setObject(6, entity.getRole().name());
        preparedStatement.setObject(7, entity.getGender().name());
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }


    public static UserDao getInstance() {
        return INSTANCE;
    }
}

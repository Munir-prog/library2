package com.mprog.dao;

import com.mprog.entity.Gender;
import com.mprog.entity.Role;
import com.mprog.entity.User;
import com.mprog.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User> {
    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
            INSERT INTO users (name, birthday, email, image, password, role, gender) 
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;
    private static final String FIND_BY_EMAIL_AND_PASSWORD = """
            SELECT id, name, birthday, email, image, password, role, gender
            FROM users
            WHERE email = ?
            AND password = ?
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

    @SneakyThrows
    public Optional<User> findByLoginAndPassword(String email, String password) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setObject(1, email);
            preparedStatement.setObject(2, password);

            var resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildUserEntity(resultSet);
            }
            return Optional.ofNullable(user);
        }
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

    private User buildUserEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                .email(resultSet.getObject("email", String.class))
                .image(resultSet.getObject("image", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Role.valueOf(resultSet.getObject("role", String.class)))
                .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
                .build();
    }
}

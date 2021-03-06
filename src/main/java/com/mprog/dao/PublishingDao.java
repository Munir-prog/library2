package com.mprog.dao;

import com.mprog.entity.Publishing;
import com.mprog.exception.PSQLExceptionWrapper;
import com.mprog.util.ConnectionManager;
import jakarta.servlet.annotation.WebServlet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublishingDao implements Dao<Integer, Publishing> {

    private static final PublishingDao INSTANCE = new PublishingDao();

    private static final String FIND_ALL = """
            SELECT id, publishing_name, phone_number, city, country
            FROM publishing
            """;
    private static final String FIND_ALL_NAME = """
            SELECT publishing_name
            FROM publishing
            """;
    private static final String FIND_PUBLISHING_BY_NAME = """
            SELECT id, publishing_name, phone_number, website, city, country
            FROM publishing
            WHERE publishing_name = ?
            """;
    private static final String FIND_ID_BY_NAME = """
            SELECT id
            FROM publishing
            WHERE publishing_name = ?
            """;
    private static final String SAVE_PUBLISHING_SQL = """
            INSERT INTO publishing (publishing_name, phone_number, website, city, country) 
            VALUES (?, ?, ?, ?, ?)
            """;
    private static final String DELETE_BY_NAME_SQL = """
            DELETE FROM publishing
            WHERE publishing_name = ?
            """;


    @SneakyThrows
    @Override
    public Publishing save(Publishing entity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_PUBLISHING_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getPublishingName());
            preparedStatement.setObject(2, entity.getPhoneNumber());
            preparedStatement.setObject(3, entity.getWebsite());
            preparedStatement.setObject(4, entity.getCity());
            preparedStatement.setObject(5, entity.getCountry());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getObject("id", Integer.class));
            }

            return entity;
        }
    }

    @SneakyThrows
    public Integer findPublishingIdByName(String name) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ID_BY_NAME)) {

            preparedStatement.setObject(1, name);
            Integer publishingId = null;

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                publishingId = resultSet.getInt("id");
            }

            return publishingId;
        }
    }

    @SneakyThrows
    public Publishing findPublishingByName(String name) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_PUBLISHING_BY_NAME)) {

            preparedStatement.setObject(1, name);
            Publishing publishing = null;
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                publishing = buildPublishing(resultSet);
            }

            return publishing;
        }
    }

    @SneakyThrows
    public List<String> findAllName() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_NAME)) {

            List<String> publishingList = new ArrayList<>();
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                publishingList.add(resultSet.getObject("publishing_name", String.class));
            }

            return publishingList;
        }
    }

    @SneakyThrows
    @Override
    public List<Publishing> findAll() {
//        try (var connection = ConnectionManager.get();
//             var preparedStatement = connection.prepareStatement(FIND_ALL)) {
//
//            List<Publishing> publishingList = new ArrayList<>();
//            var resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                publishingList.add(buildPublishing(resultSet));
//            }
//
//            return publishingList;
//        }
        return null;
    }

    @SneakyThrows
    private Publishing buildPublishing(ResultSet resultSet) {
        return new Publishing(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("publishing_name", String.class),
                resultSet.getObject("phone_number", String.class),
                resultSet.getObject("website", String.class),
                resultSet.getObject("city", String.class),
                resultSet.getObject("country", String.class)
        );
    }

    @Override
    public Optional<Publishing> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @SneakyThrows
    public boolean deleteByName(String name) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(DELETE_BY_NAME_SQL)) {
            preparedStatement.setObject(1, name);
            preparedStatement.executeUpdate();
        }catch (PSQLException e){
            var message = e.getMessage();
            throw new PSQLExceptionWrapper(message);
        }
        return false;
    }

    @Override
    public void update(Publishing entity) {

    }


    public static PublishingDao getInstance() {
        return INSTANCE;
    }
}

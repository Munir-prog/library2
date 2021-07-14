package com.mprog.dao;

import com.mprog.entity.Book;
import com.mprog.util.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDao implements Dao<Long, Book> {
    private static final BookDao INSTANCE = new BookDao();
    private static final String FIND_ALL_BY_AUTHOR_ID = """
            SELECT book_name, page_count, chapter_count, year_of_release, publishing_id
            FROM books b
                     JOIN books_authors ba on b.id = ba.book_id
                     JOIN authors a on a.id = ba.author_id
            WHERE a.id = ?
            """;
    private static final String FIND_ALL_SQL = """
            SELECT  b.id, a.first_name, a.last_name, book_name, page_count, chapter_count, year_of_release, publishing_id
            FROM books b
                     JOIN books_authors ba on b.id = ba.book_id
                     JOIN authors a on a.id = ba.author_id
            """;
    private static final String FIND_ALL_NAME = """
            SELECT b.book_name
            FROM books b
            """;
    private static final String FIND_ALL_NAME_BY_ID = """
            SELECT book_name
            FROM books b
                     JOIN books_authors ba on b.id = ba.book_id
                     JOIN authors a on a.id = ba.author_id
            WHERE a.id = ?
            """;
    private static final String FIND_BOOK_BY_NAME = """
            SELECT  b.id, a.first_name, a.last_name, book_name, page_count, chapter_count, book_image, book_part, year_of_release, publishing_id
            FROM books b
                     JOIN books_authors ba on b.id = ba.book_id
                     JOIN authors a on a.id = ba.author_id
            WHERE b.book_name = ?
            """;


    @SneakyThrows
    public Map<Book, String> findBookByName(String name) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BOOK_BY_NAME)) {
            preparedStatement.setObject(1, name);

            var resultSet = preparedStatement.executeQuery();
            Map<Book, String> bookNames = new HashMap<>();

            while (resultSet.next()) {
                bookNames.put(bookBuilder(resultSet), buildFullName(resultSet));
            }

            return bookNames;
        }
    }

    @SneakyThrows
    public List<String> findAllNameOfBooks() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_NAME)) {

            var resultSet = preparedStatement.executeQuery();
            List<String> bookNames = new ArrayList<>();

            while (resultSet.next()) {
                bookNames.add(resultSet.getObject("book_name", String.class));
            }

            return bookNames;
        }
    }

    @SneakyThrows
    public List<String> findAllNameOfBooksById(Long bookId) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_NAME_BY_ID)) {

            preparedStatement.setObject(1, bookId);

            var resultSet = preparedStatement.executeQuery();
            List<String> bookNames = new ArrayList<>();

            while (resultSet.next()) {
                bookNames.add(resultSet.getObject("book_name", String.class));
            }

            return bookNames;
        }
    }

    @SneakyThrows
    public List<Book> findAllByAuthorId(Long authorId) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_BY_AUTHOR_ID)) {
            preparedStatement.setObject(1, authorId);
            var resultSet = preparedStatement.executeQuery();

            List<Book> bookList = new ArrayList<>();
            while (resultSet.next()) {
                bookList.add(bookBuilder(resultSet));
            }

            return bookList;
        }
    }

    @SneakyThrows
    public Map<Book, String> findAllWithAuthorName() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            Map<Book, String> bookMap = new HashMap<>();

            while (resultSet.next()) {
                bookMap.put(bookBuilder(resultSet), buildFullName(resultSet));
            }
            return bookMap;
        }
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public Book save(Book entity) {
        return null;
    }

    public static BookDao getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    private String buildFullName(ResultSet resultSet) {
        var first_name = resultSet.getObject("first_name", String.class);
        var last_name = resultSet.getObject("last_name", String.class);
        return first_name + " " + last_name;
    }

    @SneakyThrows
    private Book bookBuilder(ResultSet resultSet) {
        return new Book(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("book_name", String.class),
                resultSet.getObject("page_count", Integer.class),
                resultSet.getObject("chapter_count", Integer.class),
                resultSet.getObject("book_image", String.class),
                resultSet.getObject("book_part", String.class),
                resultSet.getObject("year_of_release", Integer.class),
                resultSet.getObject("publishing_id", Integer.class)
        );
    }
}

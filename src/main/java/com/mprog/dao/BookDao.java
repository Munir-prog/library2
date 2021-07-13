package com.mprog.dao;

import com.mprog.entity.Book;
import com.mprog.util.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDao implements Dao<Long, Book> {
    private static final BookDao INSTANCE = new BookDao();
    private static final String FIND_ALL_BY_AUTHOR_ID = """
            SELECT b.id, book_name, page_count, chapter_count, year_of_release, publishing_id
            FROM books b
                     JOIN books_authors ba on b.id = ba.book_id
                     JOIN authors a on a.id = ba.author_id
            WHERE a.id = ?
            """;
    private static final String FIND_ALL_SQL = """
            SELECT  b.id, book_name, page_count, chapter_count, year_of_release, publishing_id
            FROM books b
                     JOIN books_authors ba on b.id = ba.book_id
                     JOIN authors a on a.id = ba.author_id
            """;


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
    @Override
    public List<Book> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Book> bookList = new ArrayList<>();

            while (resultSet.next()){
                bookList.add(bookBuilder(resultSet));
            }
            return bookList;
        }
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
    private Book bookBuilder(ResultSet resultSet) {
        return new Book(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("book_name", String.class),
                resultSet.getObject("page_count", Integer.class),
                resultSet.getObject("chapter_count", Integer.class),
                resultSet.getObject("year_of_release", Integer.class),
                resultSet.getObject("publishing_id", Integer.class)
        );
    }
}

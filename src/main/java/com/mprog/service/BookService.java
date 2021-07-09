package com.mprog.service;

import com.mprog.dao.BookDao;
import com.mprog.dto.BookDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookService {
    private static final BookService INSTANCE = new BookService();
    private final BookDao bookDao = BookDao.getInstance();

    public List<BookDto> findAllByAuthorId(Long id) {
        return bookDao.findAllByAuthorId(id)
                .stream()
                .map(book -> BookDto.builder()
                        .id(book.getId())
                        .bookName(book.getBookName())
                        .bookDescription(
                                """
                                        <br>
                                        Pages:           %s<br>
                                        Chapters:        %s<br>
                                        Year of release: %s<br>
                                        """.formatted(book.getPageCount(), book.getChapterCount(), book.getYearOfRelease()))
                        .publishingId(book.getPublishingId())
                        .build())
                .collect(toList());
    }

    public static BookService getInstance() {
        return INSTANCE;
    }
}

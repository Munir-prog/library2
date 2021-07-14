package com.mprog.service;

import com.mprog.dao.BookDao;
import com.mprog.dto.BookDto;
import com.mprog.entity.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookService {
    private static final BookService INSTANCE = new BookService();
    private final BookDao bookDao = BookDao.getInstance();

    public List<BookDto> findBookByName(String name){
        return bookDao.findBookByName(name)
                .entrySet()
                .stream()
                .map(entry -> buildBookDtoWithAuthorName(entry.getKey(), entry.getValue()))
                .collect(toList());
    }

    public List<String> findAllNameOfBooks() {
        return bookDao.findAllNameOfBooks();
    }

    public List<String> findAllNameOfBooksByAuthorId(Long bookId) {
        return bookDao.findAllNameOfBooksById(bookId);
    }


    private static BookDto buildBookDtoWithAuthorName(Book book, String fullName) {
        return BookDto.builder()
                .id(book.getId())
                .bookName(book.getBookName())
                .pageCount(book.getPageCount())
                .chapterCount(book.getChapterCount())
                .bookImage(book.getBookImage())
                .bookPart(book.getBookPart())
                .yearOfRelease(book.getYearOfRelease())
                .authorFullName(fullName)
                .publishingId(book.getPublishingId())
                .build();
    }


    public static BookService getInstance() {
        return INSTANCE;
    }
}

//    private static BookDto buildBookDto(Book book) {
//        return BookDto.builder()
//                .id(book.getId())
//                .bookName(book.getBookName())
//                .bookDescription(
//                        """
//                                <br>
//                                Pages:           %s<br>
//                                Chapters:        %s<br>
//                                Year of release: %s<br>
//                                """.formatted(book.getPageCount(), book.getChapterCount(), book.getYearOfRelease()))
//                .publishingId(book.getPublishingId())
//                .build();
//    }
//    public List<BookDto> findAllByAuthorId(Long id) {
//        return bookDao.findAllByAuthorId(id)
//                .stream()
//                .map(BookService::buildBookDto)
//                .collect(toList());
//    }
    //
//    public List<BookDto> findAllWithAuthorName() {
//        return bookDao.findAllWithAuthorName().entrySet()
//                .stream()
//                .map(entry -> buildBookDtoWithAuthorName(entry.getKey(), entry.getValue()))
//                .collect(toList());
//    }


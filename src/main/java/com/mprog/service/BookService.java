package com.mprog.service;

import com.mprog.dao.AuthorDao;
import com.mprog.dao.BookDao;
import com.mprog.dto.BookDto;
import com.mprog.dto.CreateBookDto;
import com.mprog.entity.Book;
import com.mprog.exception.ValidationException;
import com.mprog.mapper.CreateBookMapper;
import com.mprog.validator.CreateBookValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookService {
    private static final BookService INSTANCE = new BookService();
    private final BookDao bookDao = BookDao.getInstance();
    private final CreateBookMapper createBookMapper = CreateBookMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();
    private final AuthorDao authorDao = AuthorDao.getInstance();
    private final CreateBookValidator createBookValidator = CreateBookValidator.getInstance();

    public void deleteBook(CreateBookDto createBookDto) {
        bookDao.delete(createBookDto);
    }

    @SneakyThrows
    public long saveBook(CreateBookDto createBookDto) {

        var validationResult = createBookValidator.isValid(createBookDto);
        if (!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }
        var authorFirstName = createBookDto.getAuthorFirstName();
        var authorLastName = createBookDto.getAuthorLastName();

        var id = authorDao.findAuthorIdByNameAndLastName(authorFirstName, authorLastName);
        var book = createBookMapper.mapFrom(createBookDto);
        imageService.upload(book.getBookImage(), createBookDto.getBookImage().getInputStream());
        imageService.upload(book.getBookPart(), createBookDto.getBookPart().getInputStream());

        //opened Transaction
        var save = bookDao.saveWithAuthorId(book, id);

        return save.getId();

    }


    public Optional<BookDto> findBookByName(String name) {
        return bookDao.findBookByName(name)
                .entrySet()
                .stream()
                .map(entry -> buildBookDtoWithAuthorName(entry.getKey(), entry.getValue()))
                .findFirst();

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
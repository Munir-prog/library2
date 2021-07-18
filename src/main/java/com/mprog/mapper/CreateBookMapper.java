package com.mprog.mapper;

import com.mprog.dto.CreateBookDto;
import com.mprog.entity.Book;
import com.mprog.service.PublishingService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateBookMapper implements Mapper<CreateBookDto, Book>{

    private static final CreateBookMapper INSTANCE = new CreateBookMapper();
    private static final String IMAGE_FOLDER = "users/";
    private static final String BOOK_PARTS_FOLDER = "users/bookPart/";
    private final PublishingService publishingService = PublishingService.getInstance();

    @Override
    public Book mapFrom(CreateBookDto obj) {
        return Book.builder()
                .bookName(obj.getBookName())
                .pageCount(Integer.parseInt(obj.getPageCount()))
                .chapterCount(Integer.parseInt(obj.getChapterCount()))
                .bookImage(IMAGE_FOLDER + obj.getBookImage().getSubmittedFileName())
                .bookPart(BOOK_PARTS_FOLDER + obj.getBookPart().getSubmittedFileName())
                .yearOfRelease(Integer.parseInt(obj.getYearOfRelease()))
                .publishingId(publishingService.findIdByName(obj.getPublishingName()))
                .build();
    }

    public static CreateBookMapper getInstance() {
        return INSTANCE;
    }
}

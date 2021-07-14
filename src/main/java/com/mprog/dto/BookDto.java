package com.mprog.dto;

import lombok.*;


@Value
@Builder
public class BookDto {
    long id;
    String bookName;
    Integer pageCount;
    Integer chapterCount;
    String bookImage;
    String bookPart;
    Integer yearOfRelease;
    String authorFullName;
    int publishingId;
}

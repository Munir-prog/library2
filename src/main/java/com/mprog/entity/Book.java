package com.mprog.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Book {
    private long id;
    private String bookName;
    private int pageCount;
    private int chapterCount;
    private String bookImage;
    private String bookPart;
    private int yearOfRelease;
    private int publishingId;
}

package com.mprog.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {
    private long id;
    private String bookName;
    private int pageCount;
    private int chapterCount;
    private int yearOfRelease;
    private int publishingId;
}

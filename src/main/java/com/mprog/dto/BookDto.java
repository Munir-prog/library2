package com.mprog.dto;

import lombok.*;


@Value
@Builder
public class BookDto {
    long id;
    String bookName;
    String bookDescription;
    int publishingId;
}

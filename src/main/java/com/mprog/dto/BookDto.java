package com.mprog.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class BookDto {
    private final long id;
    private final String bookName;
    private final String bookDescription;
    private final int publishingId;
}

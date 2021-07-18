package com.mprog.dto;

import jakarta.servlet.http.Part;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateBookDto {
    String bookName;
    String pageCount;
    String chapterCount;
    Part bookImage;
    Part bookPart;
    String yearOfRelease;
    String authorFirstName;
    String authorLastName;
    String publishingName;
}

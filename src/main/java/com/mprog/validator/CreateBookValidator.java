package com.mprog.validator;

import com.mprog.dto.CreateBookDto;
import com.mprog.dto.CreateUserDto;
import com.mprog.entity.Gender;
import com.mprog.util.LocalDateFormatter;

import java.time.LocalDate;

public class CreateBookValidator implements Validator<CreateBookDto> {

    private static final CreateBookValidator INSTANCE = new CreateBookValidator();

    @Override
    public ValidationResult isValid(CreateBookDto object) {
        var validationResult = new ValidationResult();
        if (object.getBookName().equals("")){
            validationResult.add(Error.of("name.null", "Please write your name."));
        }
        if (Integer.parseInt(object.getPageCount()) < 5){
            validationResult.add(Error.of("invalid.page", "Count page is invalid"));
        }
        if (Integer.parseInt(object.getChapterCount()) < 1){
            validationResult.add(Error.of("invalid.chapter", "Chapter count is invalid"));
        }
        if (Integer.parseInt(object.getYearOfRelease()) > LocalDate.now().getYear()) {
            validationResult.add(Error.of("year.invalid", "Please input correct year"));
        }

        return validationResult;
    }

    public static CreateBookValidator getInstance() {
        return INSTANCE;
    }

}

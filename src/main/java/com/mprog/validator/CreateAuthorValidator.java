package com.mprog.validator;

import com.mprog.dto.CreateAuthorDto;
import com.mprog.dto.CreateBookDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateAuthorValidator implements Validator<CreateAuthorDto> {

    private static final CreateAuthorValidator INSTANCE = new CreateAuthorValidator();

    @Override
    public ValidationResult isValid(CreateAuthorDto object) {
        var validationResult = new ValidationResult();
        if (Integer.parseInt(object.getYearOfBirth()) > LocalDate.now().getYear()){
            validationResult.add(Error.of("year.invalid", "Please input correct year"));
        }

        return validationResult;
    }

    public static CreateAuthorValidator getInstance() {
        return INSTANCE;
    }

}

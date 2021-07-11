package com.mprog.validator;

import com.mprog.dto.CreateUserDto;
import com.mprog.entity.Gender;
import com.mprog.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (object.getName().equals("")){
            validationResult.add(Error.of("name.null", "Please write your name."));
        }
        if (!LocalDateFormatter.isValid(object.getBirthday())){
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (object.getEmail().equals("") || !object.getEmail().matches("\\w+@\\w+\\.\\w+")) {
            validationResult.add(Error.of("email.null", "Please input correct email"));
        }
        if(object.getPassword().equals("")){
            validationResult.add(Error.of("password.null", "Please input password"));
        }
        if (Gender.find(object.getGender()).isEmpty()){
            validationResult.add(Error.of("gender.null", "Please select gender"));
        }

        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }

}

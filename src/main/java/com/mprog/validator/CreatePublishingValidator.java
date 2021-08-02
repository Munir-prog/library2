package com.mprog.validator;

import com.mprog.entity.Publishing;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatePublishingValidator implements Validator<Publishing>{

    public static final CreatePublishingValidator INSTANCE = new CreatePublishingValidator();

    @Override
    public ValidationResult isValid(Publishing object) {
        var validationResult = new ValidationResult();
        if (object.getPublishingName().equals("")){
            validationResult.add(Error.of("publishingName.null", "The name of publishing can't be empty!"));
        }
        if (object.getPhoneNumber().equals("")){
            validationResult.add(Error.of("phoneNumber.null", "The phone of publishing can't be empty!"));
        }
        if (object.getWebsite().equals("")){
            validationResult.add(Error.of("website.null", "The website of publishing can't be empty!"));
        }
        if (object.getCity().equals("")){
            validationResult.add(Error.of("city.null", "The city of publishing can't be empty!"));
        }
        if (object.getCountry().equals("")){
            validationResult.add(Error.of("country.null", "The country of publishing can't be empty!"));
        }
        if (!object.getPhoneNumber().matches("^\\+7[0-9]{10}$")){
            validationResult.add(Error.of("invalid.number", "The phone number is invalid"));
        }

        return validationResult;
    }

    public static CreatePublishingValidator getINSTANCE() {
        return INSTANCE;
    }
}

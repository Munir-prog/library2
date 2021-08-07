package com.mprog.service;

import com.mprog.dao.PublishingDao;
import com.mprog.dto.PublishingDto;
import com.mprog.entity.Publishing;
import com.mprog.exception.ValidationException;
import com.mprog.validator.CreatePublishingValidator;
import com.mprog.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublishingService {
    private static final PublishingService INSTANCE = new PublishingService();
    private final PublishingDao publishingDao = PublishingDao.getInstance();
    private final CreatePublishingValidator createPublishingValidator = CreatePublishingValidator.getINSTANCE();


    public List<String> findAllName() {
        return publishingDao.findAllName();
    }

    public Integer findIdByName(String name) {
        return publishingDao.findPublishingIdByName(name);
    }

//    public String findPublishingName(Long id) {
//
//    }


    public PublishingDto findPublishingByName(String name) {
        var publishing = publishingDao.findPublishingByName(name);
        return PublishingDto.builder()
                .id(publishing.getId())
                .publishingName(publishing.getPublishingName())
                .phoneNumber(publishing.getPhoneNumber())
                .website(publishing.getWebsite())
                .location(publishing.getCountry() + ", " + publishing.getCity())
                .build();
    }


    public static PublishingService getInstance() {
        return INSTANCE;
    }

    public void save(Publishing country) {
        //validation
        var valid = createPublishingValidator.isValid(country);
        if (!valid.isValid()){
            throw new ValidationException(valid.getErrors());
        }
        publishingDao.save(country);
    }

    public void deletePublishing(String publishingName) {
        publishingDao.deleteByName(publishingName);
    }
}

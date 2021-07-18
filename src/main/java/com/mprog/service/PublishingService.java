package com.mprog.service;

import com.mprog.dao.PublishingDao;
import com.mprog.dto.PublishingDto;
import com.mprog.entity.Publishing;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublishingService {
    private static final PublishingService INSTANCE = new PublishingService();
    private final PublishingDao publishingDao = PublishingDao.getInstance();


    public List<String> findAllName() {
        return publishingDao.findAllName();
    }

    public Integer findIdByName(String name){
        return publishingDao.findPublishingIdByName(name);
    }

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
}

package com.mprog.service;

import com.mprog.dao.PublishingDao;
import com.mprog.dto.PublishingDto;
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


//    public List<PublishingDto> findAll() {
//        return publishingDao.findAll()
//                .stream()
//                .map(publishing -> PublishingDto.builder()
//                        .id(publishing.getId())
//                        .publishingName(publishing.getPublishingName())
//                        .phoneNumber(publishing.getPhoneNumber())
//                        .location(publishing.getCountry() + ", " + publishing.getCity())
//                        .build()
//                )
//                .collect(toList());
//    }


    public static PublishingService getInstance() {
        return INSTANCE;
    }
}

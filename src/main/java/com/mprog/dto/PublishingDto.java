package com.mprog.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PublishingDto {
    Integer id;
    String publishingName;
    String phoneNumber;
    String location;
}

package com.mprog.service;

import com.mprog.dao.UserDao;
import com.mprog.dto.CreateUserDto;
import com.mprog.entity.User;
import com.mprog.exception.ValidationException;
import com.mprog.mapper.CreateUserMapper;
import com.mprog.validator.CreateUserValidator;
import com.mprog.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final ImageService imageService = ImageService.getInstance();


    @SneakyThrows
    public Integer create(CreateUserDto createUserDto){
        var validationResult = createUserValidator.isValid(createUserDto);
        if (!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(createUserDto);
        imageService.upload(userEntity.getImage(), createUserDto.getImage().getInputStream());
        var save = userDao.save(userEntity);
        return save.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}

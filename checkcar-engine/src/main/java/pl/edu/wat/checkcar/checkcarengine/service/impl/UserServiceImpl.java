package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.UserDto;
import pl.edu.wat.checkcar.checkcarengine.provider.UserProvider;
import pl.edu.wat.checkcar.checkcarengine.service.UserService;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserProvider provider;

    @Override
    public UserDto createUser(UserDto userDto) {
        return provider.createUser(userDto);
    }

    @Override
    public UserDto getUser(Long userId) {
        return provider.getUser(userId);
    }

    @Override
    public void updateUser(Long userId, UserDto userDto) {
        provider.updateUser(userId,userDto);
    }

    @Override
    public void deleteUser(Long userId) {
        provider.deleteUser(userId);
    }
}

package pl.edu.wat.checkcar.checkcarengine.service;

import pl.edu.wat.checkcar.checkcardomain.dto.UserDto;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface UserService {


    UserDto createUser(UserDto userDto);

    UserDto getUser(Long userId);

    void updateUser(Long userId,UserDto userDto);

    void deleteUser(Long userId);
}

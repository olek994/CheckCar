package pl.edu.wat.checkcar.checkcarengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.UserDto;
import pl.edu.wat.checkcar.checkcardomain.rest.UserRest;
import pl.edu.wat.checkcar.checkcarengine.service.UserService;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RestController
public class UserRestController implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @Override
    public UserDto getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @Override
    public void updateUser(@PathVariable("userId") Long userId,@RequestBody UserDto userDto) {
        userService.updateUser(userId,userDto);
    }

    @Override
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}

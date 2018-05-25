package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.UserDto;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface UserRest {

    @RequestMapping(value = "/user/",method = RequestMethod.POST)
    UserDto createUser(@RequestBody UserDto userDto);

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    UserDto getUser(@PathVariable("userId") Long userId);

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.PUT)
    void updateUser(@PathVariable("userId") Long userId,@RequestBody UserDto userDto);

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("userId") Long userId);
}

package pl.edu.wat.checkcar.checkcarsso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Aleksander Małkowicz, Date: 28.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RestController
public class UserController {
    @GetMapping("/user/me")
    public Principal user(Principal principal){
        return principal;
    }
}

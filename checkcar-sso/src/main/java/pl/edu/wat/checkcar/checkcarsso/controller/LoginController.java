package pl.edu.wat.checkcar.checkcarsso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcarsso.repository.PersonRepositorySso;

/**
 * Created by Aleksander Małkowicz, Date: 19.11.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    PersonRepositorySso personRepositorySso;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String getSignInPage() {
        return "signIn";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getSignUpPage() {
        return "signUp";
    }

}

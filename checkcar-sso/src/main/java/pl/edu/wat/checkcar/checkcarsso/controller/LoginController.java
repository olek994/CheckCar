package pl.edu.wat.checkcar.checkcarsso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.wat.checkcar.checkcardomain.entity.Person;
import pl.edu.wat.checkcar.checkcarsso.data.PersonSignUp;
import pl.edu.wat.checkcar.checkcarsso.repository.PersonRepositorySso;

import java.io.IOException;

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

    @RequestMapping(value = "/signUp/process", method = RequestMethod.POST)
    @ResponseBody
    public Boolean signUp(@RequestBody PersonSignUp personSignUp) throws IOException {
        if(personSignUp == null) {
            return null;
        }

        if(personSignUp.getPassword() == null || personSignUp.getPassword_r() == null) {
            return null;
        }

        if(personSignUp.getEmail() == null || personSignUp.getEmail().isEmpty()) {
            return null;
        }

        if(personSignUp.getUsername() == null || personSignUp.getUsername().isEmpty()) {
            return null;
        }

        if(!personSignUp.getPassword().equals(personSignUp.getPassword_r())) {
            return null;
        }

        String password = passwordEncoder.encode(personSignUp.getPassword());

        Person person = new Person();
        person.setEmail(personSignUp.getEmail());
        person.setUserName(personSignUp.getUsername());
        person.setPassword(password);
        person.setUserName(personSignUp.getUsername());
        person.setName(personSignUp.getName());

        Person created = personRepositorySso.save(person);

        return true;
    }

}

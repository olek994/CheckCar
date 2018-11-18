package pl.edu.wat.checkcar.checkcarengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import pl.edu.wat.checkcar.checkcardomain.rest.PersonRest;
import pl.edu.wat.checkcar.checkcardomain.rest.PersonRest;
import pl.edu.wat.checkcar.checkcarengine.service.PersonService;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RestController
public class PersonRestController implements PersonRest {

    @Autowired
    PersonService personService;

    @Override
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @Override
    public PersonDto getPerson(@PathVariable("personId") Long personId) {
        return personService.getPerson(personId);
    }

    @Override
    public void updatePerson(@PathVariable("personId") Long personId,@RequestBody PersonDto PersonDto) {
        personService.updatePerson(personId,PersonDto);
    }

    @Override
    public void deletePerson(@PathVariable("personId") Long personId) {
        personService.deletePerson(personId);
    }
}

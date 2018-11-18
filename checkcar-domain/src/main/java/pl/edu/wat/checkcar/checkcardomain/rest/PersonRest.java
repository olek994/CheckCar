package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface PersonRest {

    @RequestMapping(value = "/person/",method = RequestMethod.POST)
    PersonDto createPerson(@RequestBody PersonDto personDto);

    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET)
    PersonDto getPerson(@PathVariable("personId") Long personId);

    @RequestMapping(value = "/person/{personId}",method = RequestMethod.PUT)
    void updatePerson(@PathVariable("personId") Long personId,@RequestBody PersonDto personDto);

    @RequestMapping(value = "/person/{personId}",method = RequestMethod.DELETE)
    void deletePerson(@PathVariable("personId") Long personId);

    @RequestMapping(value = "/person/userName/{userName}", method = RequestMethod.GET)
    PersonDto getPersonByUserName(@PathVariable("userName") String userName);
}

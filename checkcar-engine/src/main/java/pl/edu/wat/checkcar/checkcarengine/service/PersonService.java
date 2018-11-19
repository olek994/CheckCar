package pl.edu.wat.checkcar.checkcarengine.service;

import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface PersonService {


    PersonDto createPerson(PersonDto personDto);

    PersonDto getPerson(Long personId);

    PersonDto getPersonByUserName(String userName);


    void updatePerson(Long personId,PersonDto personDto);

    void deletePerson(Long personId);
}

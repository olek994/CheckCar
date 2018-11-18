package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import pl.edu.wat.checkcar.checkcarengine.provider.PersonProvider;
import pl.edu.wat.checkcar.checkcarengine.service.PersonService;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonProvider provider;


    @Override
    public PersonDto createPerson(PersonDto personDto) {
        return provider.createPerson(personDto);
    }

    @Override
    public PersonDto getPerson(Long personId) {
        return provider.getPerson(personId);
    }

    @Override
    public void updatePerson(Long personId, PersonDto personDto) {
        provider.updatePerson(personId,personDto);
    }

    @Override
    public void deletePerson(Long personId) {
        provider.deletePerson(personId);
    }
}

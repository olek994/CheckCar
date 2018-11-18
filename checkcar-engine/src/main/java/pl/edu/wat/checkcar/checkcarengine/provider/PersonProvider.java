package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import pl.edu.wat.checkcar.checkcardomain.entity.Person;
import pl.edu.wat.checkcar.checkcarengine.repository.PersonRepository;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class PersonProvider extends BaseCrudProvider<Person, PersonDto> {

    @Autowired
    PersonRepository repo;

    public PersonDto createPerson(PersonDto personDto){
        return convert(repo.save(convertToEntity(personDto,null)));
    }

    public PersonDto getPerson(Long personId){
        return convert(repo.findOne(personId));
    }

    public void updatePerson(Long personId,PersonDto personDto){
        repo.save(convertToEntity(personDto,repo.findOne(personId)));
    }

    public void deletePerson(Long personId){
        repo.delete(personId);
    }

    @Override
    protected Person convertToEntity(PersonDto dto, Person entity) {
        if (entity == null) {
            entity = new Person();
        }
        if(dto.getName() != null){
            entity.setName(dto.getName());
        }
        if(dto.getSurname() != null){
            entity.setSurname(dto.getSurname());
        }
        if(dto.getBirthday() != null){
            entity.setBirthday(dto.getBirthday());
        }
        if(dto.getUserName() != null){
            entity.setUserName(dto.getUserName());
        }
        if(dto.getEmail() != null){
            entity.setEmail(dto.getEmail());
        }
        if(dto.getPassword() != null){
            entity.setPassword(dto.getPassword());
        }

        return entity;
    }
}

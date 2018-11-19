package pl.edu.wat.checkcar.checkcarengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.checkcar.checkcardomain.entity.Person;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RepositoryRestResource(collectionResourceRel = "person",path = "person")
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByUserName(String userName);
}

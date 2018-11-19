package pl.edu.wat.checkcar.checkcarengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.checkcar.checkcardomain.entity.Car;
import pl.edu.wat.checkcar.checkcardomain.entity.Person;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RepositoryRestResource(collectionResourceRel = "car",path = "car")
public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findAllByOwnerId(Person ownerId);
}

package pl.edu.wat.checkcar.checkcarsso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.checkcar.checkcardomain.entity.Person;

/**
 * Created by Aleksander on 18.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Repository
public interface PersonRepositorySso extends JpaRepository<Person,Long> {
    Person findByUserName(String userName);
}

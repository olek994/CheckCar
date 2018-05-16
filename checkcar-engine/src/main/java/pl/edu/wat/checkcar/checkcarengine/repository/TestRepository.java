package pl.edu.wat.checkcar.checkcarengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.checkcar.checkcardomain.entity.TestEntity;
/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RepositoryRestResource(collectionResourceRel = "test",path = "test")
public interface TestRepository extends JpaRepository<TestEntity,Long> {


}

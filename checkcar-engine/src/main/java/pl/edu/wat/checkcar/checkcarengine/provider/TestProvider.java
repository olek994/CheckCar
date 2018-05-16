package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.TestDto;
import pl.edu.wat.checkcar.checkcardomain.entity.TestEntity;
import pl.edu.wat.checkcar.checkcarengine.repository.TestRepository;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class TestProvider extends BaseCrudProvider<TestEntity, TestDto> {

    @Autowired
    TestRepository repo;

    public TestDto createTest(TestDto dto){
        return convert(repo.save(convertToEntity(dto, null)));
    }

    public TestDto getById(Long id){
        return convert(repo.getById(id));
    }

    @Override
    protected TestEntity convertToEntity(TestDto dto, TestEntity entity) {
        if (entity == null) {
            entity = new TestEntity();
        }
        if (dto.getTestString() != null) {
            entity.setTestString(dto.getTestString());
        }

        return entity;
    }
}

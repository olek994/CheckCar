package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.TestDto;
import pl.edu.wat.checkcar.checkcardomain.entity.TestEntity;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class TestProvider extends BaseCrudProvider<TestEntity, TestDto> {

    public String getTestValue(){
        return "Hello World";
    }

    @Override
    protected TestEntity convertToEntity(TestDto dto, TestEntity entity) {
        if (entity == null) {
            entity = new TestEntity();
        }

        return entity;
    }
}

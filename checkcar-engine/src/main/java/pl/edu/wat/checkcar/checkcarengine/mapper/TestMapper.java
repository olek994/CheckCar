package pl.edu.wat.checkcar.checkcarengine.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.Mapper.MapperConfig;
import pl.edu.wat.checkcar.checkcardomain.dto.TestDto;
import pl.edu.wat.checkcar.checkcardomain.entity.TestEntity;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class TestMapper implements MapperConfig {
    @Override
    public void configure(MapperFactory factory) {
        factory.classMap(TestEntity.class, TestDto.class).byDefault().register();
    }
}

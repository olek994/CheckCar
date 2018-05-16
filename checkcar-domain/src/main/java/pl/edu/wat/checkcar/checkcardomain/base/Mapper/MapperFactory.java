package pl.edu.wat.checkcar.checkcardomain.base.Mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Configuration
public class MapperFactory {

    @Bean
    public MapperFacade createMapper(final MapperConfig[] cfgs){
        return new ConfigurableMapper() {

            @Override
            protected void configure(ma.glasnost.orika.MapperFactory factory) {
                for(MapperConfig mapperConfig: cfgs){
                    mapperConfig.configure(factory);
                }
            }
        };
    }
}

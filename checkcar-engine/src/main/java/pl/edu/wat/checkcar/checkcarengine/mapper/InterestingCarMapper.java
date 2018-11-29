package pl.edu.wat.checkcar.checkcarengine.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.Mapper.MapperConfig;
import pl.edu.wat.checkcar.checkcardomain.dto.InterestingCarDto;
import pl.edu.wat.checkcar.checkcardomain.entity.InterestingCar;

/**
 * Created by Aleksander on 29.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Component
public class InterestingCarMapper implements MapperConfig {
    @Override
    public void configure(MapperFactory factory) {
        factory.classMap(InterestingCar.class, InterestingCarDto.class)
                .byDefault()
                .register();
    }
}

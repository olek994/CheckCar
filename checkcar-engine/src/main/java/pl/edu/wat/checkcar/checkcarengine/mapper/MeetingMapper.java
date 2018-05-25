package pl.edu.wat.checkcar.checkcarengine.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.Mapper.MapperConfig;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;
import pl.edu.wat.checkcar.checkcardomain.entity.Meeting;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class MeetingMapper implements MapperConfig {
    @Override
    public void configure(MapperFactory factory) {
        factory.classMap(Meeting.class, MeetingDto.class)
                .field("carId.id","carId")
                .field("ownerId.id","ownerId")
                .field("interestedId.id","interestedId")
                .byDefault().register();
    }
}

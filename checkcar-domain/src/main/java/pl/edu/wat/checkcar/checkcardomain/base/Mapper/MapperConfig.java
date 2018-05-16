package pl.edu.wat.checkcar.checkcardomain.base.Mapper;
import ma.glasnost.orika.MapperFactory;
/**
 * Created by Aleksander Małkowicz, Date: 16.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface MapperConfig {

    void configure(MapperFactory factory);
}

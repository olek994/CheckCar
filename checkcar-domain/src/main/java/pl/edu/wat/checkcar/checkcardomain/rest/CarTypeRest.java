package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;
import pl.edu.wat.checkcar.checkcardomain.entity.CarType;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface CarTypeRest {

    @RequestMapping(value = "/cartype/",method = RequestMethod.POST)
    CarTypeDto createCarType(@RequestBody CarTypeDto carTypeDto);

    @RequestMapping(value = "/cartype/{cartypeId}",method = RequestMethod.GET)
    CarTypeDto getCarType(@PathVariable("cartypeId") Long cartypeId);

    @RequestMapping(value = "/cartype/{cartypeId}",method = RequestMethod.PUT)
    void updateCarType(@PathVariable("cartypeId") Long cartypeId,@RequestBody CarTypeDto carTypeDto);

    @RequestMapping(value = "/cartype/{cartypeId}",method = RequestMethod.DELETE)
    void deleteCarType(@PathVariable("cartypeId") Long cartypeId);
}

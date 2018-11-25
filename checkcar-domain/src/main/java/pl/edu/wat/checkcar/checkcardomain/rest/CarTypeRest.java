package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;
import pl.edu.wat.checkcar.checkcardomain.entity.CarType;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface CarTypeRest {

    @RequestMapping(value = "/carType/",method = RequestMethod.POST)
    CarTypeDto createCarType(@RequestBody CarTypeDto carTypeDto);

    @RequestMapping(value = "/carType/{carTypeId}",method = RequestMethod.GET)
    CarTypeDto getCarType(@PathVariable("carTypeId") Long cartypeId);

    @RequestMapping(value = "/carType/{carTypeId}",method = RequestMethod.PUT)
    void updateCarType(@PathVariable("carTypeId") Long cartypeId,@RequestBody CarTypeDto carTypeDto);

    @RequestMapping(value = "/carType/{carTypeId}",method = RequestMethod.DELETE)
    void deleteCarType(@PathVariable("carTypeId") Long cartypeId);

    @RequestMapping(value = "/carType/all/{carModelId}",method = RequestMethod.GET)
    List<CarTypeDto> getAllTypesByModelId(@PathVariable("carModelId") Long carModelId);
}

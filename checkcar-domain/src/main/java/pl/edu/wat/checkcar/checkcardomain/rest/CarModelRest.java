package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.CarModelDto;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;

import java.util.List;

/**
 * Created by Aleksander on 25.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
public interface CarModelRest {

    @RequestMapping(value = "/carModel/", method = RequestMethod.POST)
    CarModelDto createCarModel(@RequestBody CarModelDto carTypeDto);

    @RequestMapping(value = "/carModel/{carModelId}",method = RequestMethod.GET)
    CarModelDto getCarModel(@PathVariable("carModelId") Long carModelId);

    @RequestMapping(value = "/carModel/{carModelId}",method = RequestMethod.PUT)
    void updateCarModel(@PathVariable("carModelId") Long carModelId,@RequestBody CarModelDto carModelDto);

    @RequestMapping(value = "/carModel/{carModelId}",method = RequestMethod.DELETE)
    void deleteCarModel(@PathVariable("carModelId") Long carModelId);

    @RequestMapping(value = "/carModel/all",method = RequestMethod.GET)
    List<CarModelDto> getAllCarModels();
}

package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface CarRest {

    @RequestMapping(value = "/car/",method = RequestMethod.POST)
    CarDto createCar(@RequestBody CarDto carDto);

    @RequestMapping(value = "car/{carId}",method = RequestMethod.GET)
    CarDto getCar(@PathVariable("carId") Long carId);

    @RequestMapping(value = "/car/owner/{ownerId}",method = RequestMethod.GET)
    List<CarDto> getCarOfOwner(@PathVariable("ownerId") Long ownerId);

    @RequestMapping(value = "/car/{carId}",method = RequestMethod.PUT)
    void updateCar(@PathVariable("carId") Long carId, @RequestBody CarDto carDto);

    @RequestMapping(value = "/car/{carId}",method = RequestMethod.DELETE)
    void deleteCar(@PathVariable("carId") Long carId);

}

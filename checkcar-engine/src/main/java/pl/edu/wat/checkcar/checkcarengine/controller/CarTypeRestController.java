package pl.edu.wat.checkcar.checkcarengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;
import pl.edu.wat.checkcar.checkcardomain.rest.CarTypeRest;
import pl.edu.wat.checkcar.checkcarengine.service.CarTypeService;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RestController
public class CarTypeRestController implements CarTypeRest {

    @Autowired
    CarTypeService carTypeService;

    @Override
    public CarTypeDto createCarType(@RequestBody CarTypeDto carTypeDto) {
        return carTypeService.createCarType(carTypeDto);
    }

    @Override
    public CarTypeDto getCarType(@PathVariable("carTypeId") Long cartypeId) {
        return carTypeService.getCarType(cartypeId);
    }

    @Override
    public void updateCarType(@PathVariable("carTypeId") Long cartypeId,@RequestBody CarTypeDto carTypeDto) {
        carTypeService.updateCarType(cartypeId,carTypeDto);
    }

    @Override
    public void deleteCarType(@PathVariable("carTypeId") Long cartypeId) {
        carTypeService.deleteCarType(cartypeId);
    }

    @Override
    public List<CarTypeDto> getAllTypesByModelId(@PathVariable("carModelId") Long carModelId) {

        return carTypeService.getAllTypesByModelId(carModelId);
    }
}

package pl.edu.wat.checkcar.checkcarengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.rest.CarRest;
import pl.edu.wat.checkcar.checkcarengine.service.CarService;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RestController
public class CarRestController implements CarRest {

    @Autowired
    CarService carService;

    @Override
    public CarDto createCar(@RequestBody CarDto carDto) {
        return  carService.createCar(carDto);
    }

    @Override
    public CarDto getCar(@PathVariable("carId") Long carId) {
        return carService.getCar(carId);
    }

    @Override
    public List<CarDto> getCarOfOwner(@PathVariable("ownerId")Long ownerId) {
        return carService.getCarOfOwner(ownerId);
    }

    @Override
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @Override
    public void updateCar(@PathVariable("carId")Long carId,@RequestBody CarDto carDto) {
        carService.updateCar(carId,carDto);
    }

    @Override
    public void deleteCar(@PathVariable("carId")Long carId) {
        carService.deleteCar(carId);
    }

    @Override
    public List<CarDto> getCarsByModelIdAndTypeId(@PathVariable("modelId") Long modelId, @PathVariable("typeId") Long typeId) {
        return carService.getCarsByModelIdAndTypeId(modelId,typeId);
    }
}

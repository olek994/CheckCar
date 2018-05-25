package pl.edu.wat.checkcar.checkcarengine.service;

import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface CarService {

    CarDto createCar(CarDto carDto);

    CarDto getCar(Long carId);

    List<CarDto> getCarOfOwner(Long ownerId);

    void updateCar(Long carId,  CarDto carDto);

    void deleteCar(Long carId);

}

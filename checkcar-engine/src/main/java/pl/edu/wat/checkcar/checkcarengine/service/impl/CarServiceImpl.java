package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcarengine.provider.CarProvider;
import pl.edu.wat.checkcar.checkcarengine.service.CarService;

import java.util.Date;
import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Service
@Slf4j
public class CarServiceImpl implements CarService {

    @Autowired
    CarProvider carProvider;

    @Override
    public CarDto createCar(CarDto carDto) {
        carDto.setCreatedDate(new Date());
        return carProvider.createCar(carDto);
    }

    @Override
    public CarDto getCar(Long carId) {
        return carProvider.getCar(carId);
    }

    @Override
    public List<CarDto> getCarOfOwner(Long ownerId) {
        return carProvider.getCarOfOwner(ownerId);
    }

    @Override
    public List<CarDto> getAllCars() {
        return carProvider.getAllCars();
    }

    @Override
    public void updateCar(Long carId, CarDto carDto) {
        carProvider.updateCar(carId,carDto);
    }

    @Override
    public void deleteCar(Long carId) {
        carProvider.deleteCar(carId);
    }

    @Override
    public List<CarDto> getCarsByModelIdAndTypeId(Long modelId, Long typeId) {
        return carProvider.getCarsByModelIdAndTypeId(modelId,typeId);
    }
}

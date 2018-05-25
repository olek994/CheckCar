package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;
import pl.edu.wat.checkcar.checkcarengine.provider.CarTypeProvider;
import pl.edu.wat.checkcar.checkcarengine.service.CarTypeService;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Service
@Slf4j
public class CarTypeServiceImpl implements CarTypeService {

    @Autowired
    CarTypeProvider carTypeProvider;

    @Override
    public CarTypeDto createCarType(CarTypeDto carTypeDto) {
        return carTypeProvider.createCarType(carTypeDto);
    }

    @Override
    public CarTypeDto getCarType(Long cartypeId) {
        return carTypeProvider.getCarType(cartypeId);
    }

    @Override
    public void updateCarType(Long cartypeId, CarTypeDto carTypeDto) {
        carTypeProvider.updateCarType(cartypeId,carTypeDto);
    }

    @Override
    public void deleteCarType(Long cartypeId) {
        carTypeProvider.deleteCarType(cartypeId);
    }
}

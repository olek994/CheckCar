package pl.edu.wat.checkcar.checkcarengine.service;

import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface CarTypeService {

    CarTypeDto createCarType(CarTypeDto carTypeDto);

    CarTypeDto getCarType(Long cartypeId);

    void updateCarType(Long cartypeId,CarTypeDto carTypeDto);

    void deleteCarType(Long cartypeId);

    List<CarTypeDto> getAllTypesByModelId(Long carModelId);
}

package pl.edu.wat.checkcar.checkcarengine.service;

import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.CarModelDto;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;

import java.util.List;

/**
 * Created by Aleksander on 25.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
public interface CarModelService {

    CarModelDto createCarModel(CarModelDto carModelDto);

    CarModelDto getCarModel(Long carModelId);

    void updateCarModel(Long carModelId,CarModelDto carModelDto);

    void deleteCarModel(Long carModelId);

    List<CarModelDto> getAllCarModels();
}

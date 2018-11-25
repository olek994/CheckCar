package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.CarModelDto;
import pl.edu.wat.checkcar.checkcarengine.provider.CarModelProvider;
import pl.edu.wat.checkcar.checkcarengine.service.CarModelService;

import java.util.List;

/**
 * Created by Aleksander on 25.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Service
@Slf4j
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    CarModelProvider provider;

    @Override
    public CarModelDto createCarModel(CarModelDto carModelDto)
    {
        return provider.createCarModel(carModelDto);
    }

    @Override
    public CarModelDto getCarModel(Long carModelId)
    {
        return provider.getCarModel(carModelId);
    }

    @Override
    public void updateCarModel(Long carModelId, CarModelDto carModelDto) {
        provider.updateCarModel(carModelId,carModelDto);
    }

    @Override
    public void deleteCarModel(Long carModelId) {
        provider.deleteCarModel(carModelId);
    }

    @Override
    public List<CarModelDto> getAllCarModels() {
        return provider.getAllCarModels();
    }
}

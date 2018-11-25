package pl.edu.wat.checkcar.checkcarengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.CarModelDto;
import pl.edu.wat.checkcar.checkcardomain.rest.CarModelRest;
import pl.edu.wat.checkcar.checkcarengine.service.CarModelService;

import java.util.List;

/**
 * Created by Aleksander on 25.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@RestController
public class CarModelRestController implements CarModelRest {

    @Autowired
    CarModelService service;

    @Override
    public CarModelDto createCarModel(@RequestBody CarModelDto carModelDto)
    {
        return service.createCarModel(carModelDto);
    }

    @Override
    public CarModelDto getCarModel(@PathVariable("carModelId") Long carModelId)
    {
        return service.getCarModel(carModelId);
    }

    @Override
    public void updateCarModel(@PathVariable("carModelId") Long carModelId,@RequestBody CarModelDto carModelDto) {
        service.updateCarModel(carModelId,carModelDto);
    }

    @Override
    public void deleteCarModel(@PathVariable("carModelId") Long carModelId) {
        service.deleteCarModel(carModelId);
    }

    @Override
    public List<CarModelDto> getAllCarModels() {
        return service.getAllCarModels();
    }
}

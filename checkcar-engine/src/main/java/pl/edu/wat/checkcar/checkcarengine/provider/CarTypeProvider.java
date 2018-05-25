package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;
import pl.edu.wat.checkcar.checkcardomain.entity.CarType;
import pl.edu.wat.checkcar.checkcarengine.repository.CarTypeRepository;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class CarTypeProvider extends BaseCrudProvider<CarType,CarTypeDto> {

    @Autowired
    CarTypeRepository repo;

    public CarTypeDto createCarType(CarTypeDto carTypeDto){
        return convert(repo.save(convertToEntity(carTypeDto,null)));
    }

    public CarTypeDto getCarType(Long cartypeId){
        return convert(repo.findOne(cartypeId));
    }

    public void updateCarType(Long cartypeId,CarTypeDto carTypeDto){
        repo.save(convertToEntity(carTypeDto,repo.findOne(cartypeId)));
    }

    public void deleteCarType(Long cartypeId){
        repo.delete(cartypeId);
    }

    @Override
    protected CarType convertToEntity(CarTypeDto dto, CarType entity) {
        if (entity == null) {
            entity = new CarType();
        }
        if(dto.getType() != null){
            entity.setType(dto.getType());
        }
        return entity;
    }
}

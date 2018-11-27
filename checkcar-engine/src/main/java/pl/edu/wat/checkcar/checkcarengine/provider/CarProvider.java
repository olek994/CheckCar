package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.entity.Car;
import pl.edu.wat.checkcar.checkcarengine.repository.CarRepository;
import pl.edu.wat.checkcar.checkcarengine.repository.CarTypeRepository;
import pl.edu.wat.checkcar.checkcarengine.repository.PersonRepository;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class CarProvider extends BaseCrudProvider<Car,CarDto> {

    @Autowired
    CarRepository repo;

    @Autowired
    CarTypeRepository carTypeRepository;

    @Autowired
    PersonRepository userRepository;

    @Autowired
    PersonRepository personRepository;

    public CarDto createCar(CarDto carDto){
        return convert(repo.save(convertToEntity(carDto,null)));
    }

    public CarDto getCar(Long carId){
        return convert(repo.findOne(carId));
    }

    public List<CarDto> getCarOfOwner(Long ownerId){
        return convert(repo.findAllByOwnerId(personRepository.findOne(ownerId)));
    }

    public void updateCar(Long carId, CarDto carDto){
        repo.save(convertToEntity(carDto,repo.findOne(carId)));
    }

    public void deleteCar(Long carId){
        repo.delete(carId);
    }


    @Override
    protected Car convertToEntity(CarDto dto, Car entity) {
        if (entity == null) {
            entity = new Car();
        }
        if(dto.getCarTypeId() != null){
            entity.setCarTypeId(dto.getCarTypeId());
        }

        if(dto.getCourse() != null){
            entity.setCourse(dto.getCourse());
        }

        if (dto.getOwnerId() != null) {
            entity.setOwnerId(userRepository.findOne(dto.getOwnerId()));
        }

        if (dto.getYearOfProduction() != null) {
            entity.setYearOfProduction(dto.getYearOfProduction());
        }

        if(dto.getCarModelId() != null){
            entity.setCarModelId(dto.getCarModelId());
        }

        if(dto.getCarImage() != null){
            entity.setCarImage(dto.getCarImage());
        }

        return entity;
    }
}

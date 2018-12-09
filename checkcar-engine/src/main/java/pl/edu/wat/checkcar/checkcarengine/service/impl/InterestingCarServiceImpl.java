package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.CarWithModelAndType;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.dto.CarModelDto;
import pl.edu.wat.checkcar.checkcardomain.dto.CarTypeDto;
import pl.edu.wat.checkcar.checkcardomain.dto.InterestingCarDto;
import pl.edu.wat.checkcar.checkcarengine.provider.CarModelProvider;
import pl.edu.wat.checkcar.checkcarengine.provider.CarProvider;
import pl.edu.wat.checkcar.checkcarengine.provider.CarTypeProvider;
import pl.edu.wat.checkcar.checkcarengine.provider.InterestingCarProvider;
import pl.edu.wat.checkcar.checkcarengine.service.InterestingCarService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksander on 29.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Service
@Slf4j
public class InterestingCarServiceImpl implements InterestingCarService {

    @Autowired
    InterestingCarProvider interestingCarProvider;

    @Autowired
    CarProvider carProvider;

    @Autowired
    CarModelProvider carModelProvider;

    @Autowired
    CarTypeProvider carTypeProvider;

    @Override
    public InterestingCarDto createInterestingCar(InterestingCarDto interestingCarDto) {
        return interestingCarProvider.createInterestingCar(interestingCarDto);
    }

    @Override
    public InterestingCarDto getInterestingCar(Long interestingCarId) {
        return interestingCarProvider.getInterestingCar(interestingCarId);
    }

    @Override
    public List<InterestingCarDto> getInterestingCarOfInteresdId(Long interestedId) {
        return interestingCarProvider.getInterestingCarOfInteresdId(interestedId);
    }

    @Override
    public void updateInterestingCar(Long interestingCarId, InterestingCarDto interestingCarDto) {
            interestingCarProvider.updateInterestingCar(interestingCarId,interestingCarDto);
    }

    @Override
    public void deleteInterestingCar(Long interestingCarId) {
            interestingCarProvider.deleteInterestingCar(interestingCarId);
    }

    @Override
    public InterestingCarDto getInterestingCarByInteredIdAndCarId(Long interesdId, Long carId) {
        return interestingCarProvider.getInterestingCarByInteresedIdAndCarId(interesdId,carId);
    }

    @Override
    public List<CarWithModelAndType> getInterestingCarsWithModelAndType(Long interestedId) {
        List<InterestingCarDto> interestingCarDtos = getInterestingCarOfInteresdId(interestedId);
        List<CarWithModelAndType> cars = new ArrayList<>();

        for(InterestingCarDto interestingCarDto: interestingCarDtos){
            CarWithModelAndType carWithModel = new CarWithModelAndType();

            CarDto car = carProvider.getCar(interestingCarDto.getCarId());
            if(car == null){
                continue;
            }
            carWithModel.setCarImage(new String(car.getCarImage()));
            carWithModel.setCostForRide(car.getCostForRide());
            carWithModel.setCourse(car.getCourse());
            carWithModel.setEngine(car.getEngine());
            carWithModel.setFuel(car.getFuel());
            carWithModel.setGearBox(car.getGearBox().name());
            carWithModel.setHorsePower(car.getHorsePower());
            carWithModel.setId(car.getId());
            carWithModel.setProductionYear(car.getYearOfProduction());

            CarModelDto carModel = carModelProvider.getCarModel(car.getCarModelId());
            if(carModel == null){
                continue;
            }
            carWithModel.setModel(carModel.getModel());

            CarTypeDto carTypeDto = carTypeProvider.getCarType(car.getCarTypeId());

            if (carTypeDto == null) {
                continue;
            }

            carWithModel.setType(carTypeDto.getType());
            carWithModel.setOwnerId(car.getOwnerId());
            cars.add(carWithModel);

        }
        return cars;
    }
}

package pl.edu.wat.checkcar.checkcarengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.dto.InterestingCarDto;
import pl.edu.wat.checkcar.checkcardomain.rest.InterestingCarRest;
import pl.edu.wat.checkcar.checkcarengine.service.InterestingCarService;

import java.util.List;

/**
 * Created by Aleksander on 29.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */

@RestController
public class InterestingCarRestController implements InterestingCarRest {

    @Autowired
    InterestingCarService interestingCarService;

    @Override
    public InterestingCarDto createInterestingCar(@RequestBody InterestingCarDto interestingCarDto) {
        return interestingCarService.createInterestingCar(interestingCarDto);
    }

    @Override
    public InterestingCarDto getInterestingCar(@PathVariable("interestingCarId") Long interestingCarId) {
        return interestingCarService.getInterestingCar(interestingCarId);
    }

    @Override
    public List<InterestingCarDto> getInterestingCarOfInterestedId(@PathVariable("interestedId") Long interestedId) {
        return interestingCarService.getInterestingCarOfInteresdId(interestedId);
    }

    @Override
    public void updateInterestingCar(@PathVariable("interestingCarId") Long interestingCarId, @RequestBody InterestingCarDto interestingCarDto) {
        interestingCarService.updateInterestingCar(interestingCarId,interestingCarDto);
    }

    @Override
    public void deleteInterestingCar(@PathVariable("interestingCarId") Long interestingCarId) {
        interestingCarService.deleteInterestingCar(interestingCarId);
    }

    @Override
    public InterestingCarDto getInterestingCarByInteresdIdAndCarId(@PathVariable("interesdId") Long interesdId, @PathVariable("carId") Long carId) {
        return interestingCarService.getInterestingCarByInteredIdAndCarId(interesdId,carId);
    }
}

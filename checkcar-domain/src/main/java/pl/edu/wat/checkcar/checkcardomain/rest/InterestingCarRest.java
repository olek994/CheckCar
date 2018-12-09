package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.CarWithModelAndType;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.dto.InterestingCarDto;

import java.util.List;

/**
 * Created by Aleksander on 29.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
public interface InterestingCarRest  {

    @RequestMapping(value = "/interesting/car/", method = RequestMethod.POST)
    InterestingCarDto createInterestingCar(@RequestBody InterestingCarDto interestingCarDto);

    @RequestMapping(value = "/interesting/car/{interestingCarId}",method = RequestMethod.GET)
    InterestingCarDto getInterestingCar(@PathVariable("interestingCarId") Long interestingCarId);

    @RequestMapping(value = "/interesting/car/interested/{interestedId}",method = RequestMethod.GET)
    List<InterestingCarDto> getInterestingCarOfInterestedId(@PathVariable("interestedId") Long interestedId);

    @RequestMapping(value = "/interesting/car/{interestingCarId}",method = RequestMethod.PUT)
    void updateInterestingCar(@PathVariable("interestingCarId") Long interestingCarId, @RequestBody InterestingCarDto interestingCarDto);

    @RequestMapping(value = "/interesting/car/{interestingCarId}",method = RequestMethod.DELETE)
    void deleteInterestingCar(@PathVariable("interestingCarId") Long interestingCarId);

    @RequestMapping(value = "/interesting/car/{interesdId}/{carId}",method = RequestMethod.GET)
    InterestingCarDto getInterestingCarByInteresdIdAndCarId(@PathVariable("interesdId") Long interesdId, @PathVariable("carId") Long carId);

    @RequestMapping(value = "/interesting/car/withModel/{interestedId}", method = RequestMethod.GET)
    List<CarWithModelAndType> getInterestingCarsWithModelAndType(@PathVariable("interestedId") Long interestedId);

}


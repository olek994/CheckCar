package pl.edu.wat.checkcar.checkcarengine.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.dto.InterestingCarDto;

import java.util.List;

/**
 * Created by Aleksander on 29.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
public interface InterestingCarService {

    InterestingCarDto createInterestingCar(InterestingCarDto interestingCarDto);

    InterestingCarDto getInterestingCar(Long interestingCarId);

    List<InterestingCarDto> getInterestingCarOfInteresdId(Long interestedId);

    void updateInterestingCar(Long interestingCarId, InterestingCarDto interestingCarDto);

    void deleteInterestingCar(Long interestingCarId);

    InterestingCarDto getInterestingCarByInteredIdAndCarId(Long interesdId, Long carId);
}

package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.dto.InterestingCarDto;
import pl.edu.wat.checkcar.checkcarengine.provider.InterestingCarProvider;
import pl.edu.wat.checkcar.checkcarengine.service.InterestingCarService;

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
}

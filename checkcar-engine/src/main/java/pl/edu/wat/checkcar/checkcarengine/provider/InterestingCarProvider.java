package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.CarDto;
import pl.edu.wat.checkcar.checkcardomain.dto.InterestingCarDto;
import pl.edu.wat.checkcar.checkcardomain.entity.InterestingCar;
import pl.edu.wat.checkcar.checkcarengine.repository.InterestingCarRepository;
import pl.edu.wat.checkcar.checkcarengine.repository.PersonRepository;

import java.util.List;

/**
 * Created by Aleksander on 29.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Component
public class InterestingCarProvider extends BaseCrudProvider<InterestingCar, InterestingCarDto> {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    InterestingCarRepository repository;

    public InterestingCarDto createInterestingCar(InterestingCarDto interestingCarDto) {
        return convert(repository.save(convertToEntity(interestingCarDto,null)));
    }

    public InterestingCarDto getInterestingCar(Long interestingCarId) {
        return convert(repository.findOne(interestingCarId));
    }

    public List<InterestingCarDto> getInterestingCarOfInteresdId(Long interestedId) {
        return convert(repository.findAllByInterestedId(interestedId));
    }

    public void updateInterestingCar(Long interestingCarId, InterestingCarDto interestingCarDto) {
        repository.save(convertToEntity(interestingCarDto,repository.findOne(interestingCarId)));
    }

    public void deleteInterestingCar(Long interestingCarId) {
            repository.delete(interestingCarId);
    }

    public InterestingCarDto getInterestingCarByInteresedIdAndCarId(Long interesdId, Long carId){
        return convert(repository.findByInterestedIdAndCarId(interesdId,carId));
    }


    @Override
    protected InterestingCar convertToEntity(InterestingCarDto dto, InterestingCar entity) {
        if (entity == null) {
            entity = new InterestingCar();
        }

        if (dto.getCarId() != null) {
            entity.setCarId(dto.getCarId());
        }

        if (dto.getInterestedId() != null) {
            entity.setInterestedId(dto.getInterestedId());
        }

        return entity;
    }
}

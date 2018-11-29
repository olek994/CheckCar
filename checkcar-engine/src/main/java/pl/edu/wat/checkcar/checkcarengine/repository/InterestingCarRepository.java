package pl.edu.wat.checkcar.checkcarengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.checkcar.checkcardomain.entity.InterestingCar;

import java.util.List;

/**
 * Created by Aleksander on 29.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@RepositoryRestResource(collectionResourceRel = "interestingCar", path = "interestingCar")
public interface InterestingCarRepository extends JpaRepository<InterestingCar,Long> {
    List<InterestingCar> findAllByInterestedId(Long interestedId);
    InterestingCar findByInterestedIdAndCarId(Long interestedId, Long carId);
}

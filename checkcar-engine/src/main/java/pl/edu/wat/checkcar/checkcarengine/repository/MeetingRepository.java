package pl.edu.wat.checkcar.checkcarengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.wat.checkcar.checkcardomain.entity.Meeting;
import pl.edu.wat.checkcar.checkcardomain.entity.Person;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RepositoryRestResource(path = "meeting", collectionResourceRel = "meeting")
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    Meeting findByOwnerIdAndInterestedId(Long owner, Long interested);
    List<Meeting> findAllByInterestedId(Long interestedId);
    List<Meeting> findAllByOwnerId(Long ownerId);
}

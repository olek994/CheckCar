package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;
import pl.edu.wat.checkcar.checkcardomain.entity.Meeting;
import pl.edu.wat.checkcar.checkcarengine.repository.CarRepository;
import pl.edu.wat.checkcar.checkcarengine.repository.MeetingRepository;
import pl.edu.wat.checkcar.checkcarengine.repository.PersonRepository;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class MeetingProvider extends BaseCrudProvider<Meeting,MeetingDto> {

    @Autowired
    MeetingRepository repo;

    @Autowired
    CarRepository carRepository;

    @Autowired
    PersonRepository userRepository;

    public MeetingDto createMeeting(MeetingDto meetingDto){
        return convert(repo.save(convertToEntity(meetingDto,null)));
    }

    public MeetingDto getMeeting(Long meetingId){
        return convert(repo.findOne(meetingId));
    }

    public void updateMeeting(Long meetingId,MeetingDto meetingDto){
        repo.save(convertToEntity(meetingDto,repo.findOne(meetingId)));
    }

    public void deleteMeeting(Long meetingId){
        repo.delete(meetingId);
    }

    @Override
    protected Meeting convertToEntity(MeetingDto dto, Meeting entity) {
        if (entity == null) {
            entity = new Meeting();
        }

        if (dto.getCarId() != null) {
            entity.setCarId(carRepository.findOne(dto.getCarId()));
        }

        if (dto.getCost() != null) {
            entity.setCost(dto.getCost());
        }

        if (dto.getInterestedId() != null) {
            entity.setInterestedId(userRepository.findOne(dto.getInterestedId()));
        }

        if (dto.getMeetingDate() != null) {
            entity.setMeetingDate(dto.getMeetingDate());
        }

        if (dto.getOwnerId() != null) {
            entity.setOwnerId(userRepository.findOne(dto.getOwnerId()));
        }

        return null;
    }
}

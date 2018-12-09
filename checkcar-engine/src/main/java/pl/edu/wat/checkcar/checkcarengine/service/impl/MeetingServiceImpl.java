package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;
import pl.edu.wat.checkcar.checkcardomain.entity.Meeting;
import pl.edu.wat.checkcar.checkcarengine.provider.MeetingProvider;
import pl.edu.wat.checkcar.checkcarengine.service.MeetingService;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Service
@Slf4j
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingProvider meetingProvider;

    @Override
    public MeetingDto createMeeting(MeetingDto meetingDto) {
        MeetingDto createdMeeting = getMeetingByOwnerIdAndInterestedId(meetingDto.getOwnerId(),meetingDto.getInterestedId());

        if(createdMeeting == null){
            return meetingProvider.createMeeting(meetingDto);
        }else{
            return createdMeeting;
        }
    }

    @Override
    public MeetingDto getMeeting(Long meetingId) {
        return meetingProvider.getMeeting(meetingId);
    }

    @Override
    public void updateMeeting(Long meetingId, MeetingDto meetingDto) {
        meetingProvider.updateMeeting(meetingId,meetingDto);
    }

    @Override
    public void deleteMeeting(Long meetingId) {
        meetingProvider.deleteMeeting(meetingId);
    }

    @Override
    public List<MeetingDto> getAllMeeting(Long personId) {
        return meetingProvider.getAllMeetings(personId);
    }

    @Override
    public MeetingDto getMeetingByOwnerIdAndInterestedId(Long ownerId, Long interestedId) {
        return meetingProvider.getMeetingByOwnerAndInterested(ownerId,interestedId);
    }
}

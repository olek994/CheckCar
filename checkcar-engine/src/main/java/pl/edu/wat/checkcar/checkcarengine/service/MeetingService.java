package pl.edu.wat.checkcar.checkcarengine.service;

import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface MeetingService {

    MeetingDto createMeeting(MeetingDto meetingDto);

    MeetingDto getMeeting(Long meetingId);

    void updateMeeting(Long meetingId, @RequestBody MeetingDto meetingDto);

    void deleteMeeting(Long meetingId);

    List<MeetingDto> getAllMeeting(Long personId);

    MeetingDto getMeetingByOwnerIdAndInterestedId(Long ownerId, Long interestedId);
}

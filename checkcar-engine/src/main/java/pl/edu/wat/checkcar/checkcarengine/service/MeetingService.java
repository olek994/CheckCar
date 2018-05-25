package pl.edu.wat.checkcar.checkcarengine.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface MeetingService {

    MeetingDto createMeeting(MeetingDto meetingDto);

    MeetingDto getMeeting(Long meetingId);

    void updateMeeting(Long meetingId,@RequestBody MeetingDto meetingDto);

    void deleteMeeting(Long meetingId);
}

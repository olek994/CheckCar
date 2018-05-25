package pl.edu.wat.checkcar.checkcarengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;
import pl.edu.wat.checkcar.checkcardomain.rest.MeetingRest;
import pl.edu.wat.checkcar.checkcarengine.service.MeetingService;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RestController
public class MeetingRestController implements MeetingRest {

    @Autowired
    MeetingService meetingService;

    @Override
    public MeetingDto createMeeting(@RequestBody MeetingDto meetingDto) {
        return meetingService.createMeeting(meetingDto);
    }

    @Override
    public MeetingDto getMeeting(@PathVariable("meetingId") Long meetingId) {
        return meetingService.getMeeting(meetingId);
    }

    @Override
    public void updateMeeting(@PathVariable("meetingId") Long meetingId,@RequestBody MeetingDto meetingDto) {
            meetingService.updateMeeting(meetingId,meetingDto);
    }

    @Override
    public void deleteMeeting(@PathVariable("meetingId") Long meetingId) {
        meetingService.deleteMeeting(meetingId);
    }
}

package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;

import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public interface MeetingRest {

    @RequestMapping(value = "/meeting/",method = RequestMethod.POST)
    MeetingDto createMeeting(@RequestBody MeetingDto meetingDto);

    @RequestMapping(value = "/meeting/{meetingId}",method = RequestMethod.GET)
    MeetingDto getMeeting(@PathVariable("meetingId") Long meetingId);

    @RequestMapping(value = "/meeting/{meetingId}",method = RequestMethod.PUT)
    void updateMeeting(@PathVariable("meetingId") Long meetingId,@RequestBody MeetingDto meetingDto);

    @RequestMapping(value = "/meeting/{meetingId}",method = RequestMethod.DELETE)
    void deleteMeeting(@PathVariable("meetingId") Long meetingId);

    @RequestMapping(value = "/meeting/all/{personId}",method = RequestMethod.GET)
    List<MeetingDto> getAllMeetingsWithPersonId(@PathVariable("personId") Long personId);

    @RequestMapping(value = "/meeting/carOwner/{carOwnerId}/interested/{interestedId}",method = RequestMethod.GET)
    MeetingDto getMeetingByOnwerAndInterested(@PathVariable("carOwnerId") Long carOwnerId, @PathVariable("interestedId") Long interestedId);
}

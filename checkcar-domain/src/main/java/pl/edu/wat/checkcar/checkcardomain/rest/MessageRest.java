package pl.edu.wat.checkcar.checkcardomain.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;

import java.util.List;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
public interface MessageRest {

    @RequestMapping(value = "/message/", method = RequestMethod.POST)
    MessageDto createMessage(@RequestBody MessageDto messageDto);

    @RequestMapping(value = "/message/{messageId}", method = RequestMethod.GET)
    MessageDto getMessage(@PathVariable("messageId") Long messageId);

    @RequestMapping(value = "/message/{messageId}", method = RequestMethod.PUT)
    void updateMessage(@PathVariable("messageId") Long messageId, @RequestBody MessageDto messageDto);

    @RequestMapping(value = "/message/{messageId}", method = RequestMethod.DELETE)
    void deleteMessage(@PathVariable("messageId") Long messageId);

    @RequestMapping(value = "/message/meeting/{meetingId}", method = RequestMethod.GET)
    List<MessageDto> getMessagesByMeetingId(@PathVariable("meetingId") Long meetingId);
}

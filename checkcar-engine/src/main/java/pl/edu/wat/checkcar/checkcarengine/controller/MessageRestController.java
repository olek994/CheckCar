package pl.edu.wat.checkcar.checkcarengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;
import pl.edu.wat.checkcar.checkcardomain.rest.MessageRest;
import pl.edu.wat.checkcar.checkcarengine.service.MessageService;

import java.util.List;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@RestController
public class MessageRestController implements MessageRest {

    @Autowired
    MessageService messageService;

    @Override
    public MessageDto createMessage(@RequestBody MessageDto messageDto) {
        return messageService.createMessage(messageDto);
    }

    @Override
    public MessageDto getMessage(@PathVariable("messageId") Long messageId) {
        return messageService.getMessage(messageId);
    }

    @Override
    public void updateMessage(@PathVariable("messageId") Long messageId, @RequestBody MessageDto messageDto) {
        messageService.updateMessage(messageId,messageDto);
    }

    @Override
    public void deleteMessage(@PathVariable("messageId") Long messageId) {
        messageService.deleteMessage(messageId);
    }

    @Override
    public List<MessageDto> getMessagesByMeetingId(@PathVariable("meetingId") Long meetingId) {
        return messageService.getMessagesByMeetingId(meetingId);
    }
}

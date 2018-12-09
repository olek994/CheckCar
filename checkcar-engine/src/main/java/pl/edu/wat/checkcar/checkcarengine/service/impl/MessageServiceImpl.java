package pl.edu.wat.checkcar.checkcarengine.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;
import pl.edu.wat.checkcar.checkcarengine.provider.MessageProvider;
import pl.edu.wat.checkcar.checkcarengine.service.MessageService;

import java.util.List;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageProvider messageProvider;

    @Override
    public MessageDto createMessage(MessageDto messageDto) {
        return messageProvider.createMessage(messageDto);
    }

    @Override
    public MessageDto getMessage(Long messageId) {
        return messageProvider.getMessage(messageId);
    }

    @Override
    public void updateMessage(Long messageId, MessageDto messageDto) {
        messageProvider.updateMessage(messageId,messageDto);
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageProvider.deleteMessage(messageId);
    }

    @Override
    public List<MessageDto> getMessagesByMeetingId(Long meetingId) {
        return messageProvider.getMessagesByMeetingId(meetingId);
    }
}

package pl.edu.wat.checkcar.checkcarengine.service;

import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;

import java.util.List;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
public interface MessageService {

    MessageDto createMessage(MessageDto messageDto);

    MessageDto getMessage(Long messageId);

    void updateMessage(Long messageId, MessageDto messageDto);

    void deleteMessage(Long messageId);

    List<MessageDto> getMessagesByMeetingId(Long meetingId);
}

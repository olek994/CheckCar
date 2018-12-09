package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;
import pl.edu.wat.checkcar.checkcardomain.entity.Message;
import pl.edu.wat.checkcar.checkcarengine.repository.MessageRepository;

import java.util.List;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@Component
public class MessageProvider extends BaseCrudProvider<Message, MessageDto> {

    @Autowired
    MessageRepository repository;


    public MessageDto createMessage(MessageDto messageDto) {
        return convert(repository.save(convertToEntity(messageDto,null)));
    }

    public MessageDto getMessage(Long messageId) {
        return convert(repository.findOne(messageId));
    }

    public void updateMessage(Long messageId, MessageDto messageDto) {
        repository.save(convertToEntity(messageDto,repository.findOne(messageId)));
    }

    public void deleteMessage(Long messageId) {
        repository.delete(messageId);
    }

    public List<MessageDto> getMessagesByMeetingId(Long meetingId) {
        return convert(repository.findByMeetingId(meetingId));
    }

    protected Message convertToEntity(MessageDto dto, Message entity) {
        if(entity == null){
            entity = new Message();
        }

        if(dto.getAuthorId() != null){
            entity.setAuthorId(dto.getAuthorId());
        }
        if(dto.getMeetingId() != null){
            entity.setMeetingId(dto.getMeetingId());
        }
        if(dto.getContent() != null){
            entity.setContent(dto.getContent());
        }

        return entity;
    }
}

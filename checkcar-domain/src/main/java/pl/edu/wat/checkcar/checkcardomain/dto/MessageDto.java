package pl.edu.wat.checkcar.checkcardomain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.checkcar.checkcardomain.base.BaseDto;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto extends BaseDto<Long> {
    private Long meetingId;
    private Long authorId;
    private String content;

    public MessageDto(Long id, Long meetingId, Long authorId, String content) {
        super(id);
        this.meetingId = meetingId;
        this.authorId = authorId;
        this.content = content;
    }
}

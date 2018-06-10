package pl.edu.wat.checkcar.checkcardomain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.checkcar.checkcardomain.base.BaseDto;

import java.util.Date;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingDto extends BaseDto<Long> {
    private Long carId;
    private Long ownerId;
    private Long interestedId;
    private Date meetingDate;
    private Double cost;

    @Builder
    public MeetingDto(Long id, Long carId, Long ownerId, Long interestedId, Date meetingDate, Double cost) {
        super(id);
        this.carId = carId;
        this.ownerId = ownerId;
        this.interestedId = interestedId;
        this.meetingDate = meetingDate;
        this.cost = cost;
    }


}
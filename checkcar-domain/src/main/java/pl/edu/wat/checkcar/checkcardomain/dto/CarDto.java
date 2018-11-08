package pl.edu.wat.checkcar.checkcardomain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.checkcar.checkcardomain.base.BaseDto;
import pl.edu.wat.checkcar.checkcardomain.entity.CarType;

import java.util.Date;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto extends BaseDto<Long> {

    private Long carTypeId;
    private Date yearOfProduction;
    private Long course;
    private Long ownerId;

    @Builder
    public CarDto(Long id, Long carTypeId, Date yearOfProduction, Long course, Long ownerId) {
        super(id);
        this.carTypeId = carTypeId;
        this.yearOfProduction = yearOfProduction;
        this.course = course;
        this.ownerId = ownerId;
    }
}
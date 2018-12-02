package pl.edu.wat.checkcar.checkcardomain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.checkcar.checkcardomain.GearBoxEnum;
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
    private Long yearOfProduction;
    private Long course;
    private Long ownerId;
    private Long carModelId;
    private byte[] carImage;
    private String engine;
    private String horsePower;
    private GearBoxEnum gearBox;
    private String fuel;
    private Long costForRide;

    @Builder
    public CarDto(Long id, Long carTypeId, Long yearOfProduction, Long course, Long ownerId, Long carModelId, byte[] carImage, String engine, String horsePower, GearBoxEnum gearBox, String fuel, Long costForRide) {
        super(id);
        this.carTypeId = carTypeId;
        this.yearOfProduction = yearOfProduction;
        this.course = course;
        this.ownerId = ownerId;
        this.carModelId = carModelId;
        this.carImage = carImage;
        this.engine = engine;
        this.horsePower = horsePower;
        this.gearBox = gearBox;
        this.fuel = fuel;
        this.costForRide = costForRide;
    }
}
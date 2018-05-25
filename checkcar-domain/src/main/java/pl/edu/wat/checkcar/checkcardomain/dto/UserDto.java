package pl.edu.wat.checkcar.checkcardomain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.checkcar.checkcardomain.base.BaseDto;
import pl.edu.wat.checkcar.checkcardomain.entity.Car;

import java.util.Date;
import java.util.List;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends PersonDto {
    private String email;
    private String password;
    private List<Car> carList;

    @Builder
    public UserDto(String name, String surname, Date birthday, String email, String password, List<Car> carList) {
        super(name, surname, birthday);
        this.email = email;
        this.password = password;
        this.carList = carList;
    }
}
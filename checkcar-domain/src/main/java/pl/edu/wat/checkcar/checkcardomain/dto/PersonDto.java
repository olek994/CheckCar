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
public class PersonDto extends BaseDto<Long> {
    private String name;
    private String surname;
    private Date birthday;
    private String userName;
    private String password;
    private String email;

    public PersonDto(Long id, String name, String surname, Date birthday, String userName, String password, String email) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
package pl.edu.wat.checkcar.checkcarsso.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Aleksander Małkowicz, Date: 19.11.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSignUp {
    private String email;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String password_r;
    private Date birthday;
}

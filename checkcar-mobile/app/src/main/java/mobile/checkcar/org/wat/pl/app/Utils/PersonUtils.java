package mobile.checkcar.org.wat.pl.app.Utils;

import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class PersonUtils {

    private static PersonDto loggedPerson;


    public static PersonDto getLoggedPerson() {
        return loggedPerson;
    }

    public static  void setLoggedPerson(PersonDto person) {
        loggedPerson = person;
    }
}

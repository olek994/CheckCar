package mobile.checkcar.org.wat.pl.app.service;

import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Aleksander on 03.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public interface PersonService {

    @GET(value = "person/{personId}")
    Call<PersonDto> getPerson(@Path("personId") Long personId);

    @GET(value = "person/userName/{userName}")
    Call<PersonDto> getPerson(@Path("userName") String personUserName);
}

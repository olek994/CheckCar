package mobile.checkcar.org.wat.pl.app.service;

import java.util.List;

import pl.edu.wat.checkcar.checkcardomain.CarWithModelAndType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public interface InterestingCarsService {

    @GET(value = "interesting/car/withModel/{interestedId}")
    Call<List<CarWithModelAndType>> getInterestingCars(@Path("interestedId") Long interestedId);
}

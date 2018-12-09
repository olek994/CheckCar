package mobile.checkcar.org.wat.pl.app.asyncTaskLoader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.util.List;

import mobile.checkcar.org.wat.pl.app.Utils.PersonUtils;
import mobile.checkcar.org.wat.pl.app.Utils.RetrofitUtils;
import mobile.checkcar.org.wat.pl.app.service.InterestingCarsService;
import pl.edu.wat.checkcar.checkcardomain.CarWithModelAndType;
import retrofit2.Response;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class InterestingCarsAsyncTaskLoader extends AsyncTaskLoader<List<CarWithModelAndType>> {

    public InterestingCarsAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public List<CarWithModelAndType> loadInBackground() {
        InterestingCarsService interestingCarsService = RetrofitUtils.retrofit.create(InterestingCarsService.class);
        try {
            Response response = interestingCarsService.getInterestingCars(PersonUtils.getLoggedPerson().getId()).execute();

            if (response.body() != null) {
                return (List<CarWithModelAndType>) response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

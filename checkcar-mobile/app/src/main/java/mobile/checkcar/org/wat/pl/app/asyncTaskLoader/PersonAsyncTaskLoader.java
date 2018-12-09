package mobile.checkcar.org.wat.pl.app.asyncTaskLoader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;

import mobile.checkcar.org.wat.pl.app.Utils.RetrofitUtils;
import mobile.checkcar.org.wat.pl.app.service.PersonService;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Aleksander on 03.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class PersonAsyncTaskLoader extends AsyncTaskLoader<PersonDto> {
    public PersonAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public PersonDto loadInBackground() {
        PersonService service = RetrofitUtils.retrofit.create(PersonService.class);
        Call<PersonDto> call = service.getPerson(3L);
        try {
            Response<PersonDto> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

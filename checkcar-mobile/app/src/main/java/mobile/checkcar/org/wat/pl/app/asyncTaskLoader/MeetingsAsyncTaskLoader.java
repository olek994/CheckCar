package mobile.checkcar.org.wat.pl.app.asyncTaskLoader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.util.List;

import mobile.checkcar.org.wat.pl.app.Utils.PersonUtils;
import mobile.checkcar.org.wat.pl.app.Utils.RetrofitUtils;
import mobile.checkcar.org.wat.pl.app.service.MeetingService;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;
import retrofit2.Response;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class MeetingsAsyncTaskLoader extends AsyncTaskLoader<List<MeetingDto>> {

    public MeetingsAsyncTaskLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<MeetingDto> loadInBackground() {
        MeetingService meetingService = RetrofitUtils.retrofit.create(MeetingService.class);
        try {
            Response response = meetingService.getAllMeetings(PersonUtils.getLoggedPerson().getId()).execute();
            if(response.body() != null){
                return (List<MeetingDto>) response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

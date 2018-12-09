package mobile.checkcar.org.wat.pl.app.service;

import java.util.List;

import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public interface MeetingService {

    @POST("meeting/")
    Call<MeetingDto> createOrGetMeeting(@Body MeetingDto meetingDto);

    @GET("/meeting/all/{personId}")
    Call<List<MeetingDto>> getAllMeetings(@Path("personId") Long personId);
}

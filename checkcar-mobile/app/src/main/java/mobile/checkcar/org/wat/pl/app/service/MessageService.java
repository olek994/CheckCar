package mobile.checkcar.org.wat.pl.app.service;

import java.util.List;

import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public interface MessageService {

    @POST(value = "message/")
    Call<MessageDto> createMessage(@Body MessageDto messageDto);

    @GET(value = "message/meeting/{meetingId}")
    Call<List<MessageDto>> getMessagesOfMeeting(@Path("meetingId") Long meetingId);
}

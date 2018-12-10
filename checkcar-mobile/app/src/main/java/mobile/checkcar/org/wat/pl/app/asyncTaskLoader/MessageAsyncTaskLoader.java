package mobile.checkcar.org.wat.pl.app.asyncTaskLoader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import mobile.checkcar.org.wat.pl.app.Utils.RetrofitUtils;
import mobile.checkcar.org.wat.pl.app.service.MessageService;
import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;
import pl.edu.wat.checkcar.checkcardomain.rest.MessageRest;
import retrofit2.Response;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class MessageAsyncTaskLoader extends AsyncTaskLoader<List<MessageDto>> {

    private Long meetingId;

    public MessageAsyncTaskLoader(Context context,Long meetingId) {
        super(context);
        this.meetingId = meetingId;
    }

    @Override
    public List<MessageDto> loadInBackground() {
        MessageService messageService = RetrofitUtils.retrofit.create(MessageService.class);
        try {
            Response response = messageService.getMessagesOfMeeting(meetingId).execute();
            if(response.body() != null){
                return (List<MessageDto>) response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package mobile.checkcar.org.wat.pl.app.viewHolder;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.Utils.RetrofitUtils;
import mobile.checkcar.org.wat.pl.app.service.PersonService;
import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class MessagesViewHolder extends RecyclerView.ViewHolder {

    private View itemView;
    public MessagesViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public void bindData(MessageDto messageDto){
        if(messageDto == null){
            return;
        }
        TextView message = itemView.findViewById(R.id.message_content);
        TextView authorName = itemView.findViewById(R.id.author_name);

        if(authorName != null){
            new AsyncTask<Long, Void, PersonDto>() {
                @Override
                protected PersonDto doInBackground(Long... longs) {
                    Long id = longs[0];
                    PersonService service = RetrofitUtils.retrofit.create(PersonService.class);
                    try {
                        Response response = service.getPerson(id).execute();
                        if(response.body() != null){
                            return (PersonDto)response.body();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(PersonDto personDto) {
                    super.onPostExecute(personDto);
                    if(personDto != null){
                        authorName.setText(String.format("%s %s",personDto.getName(),personDto.getSurname()));
                    }
                }
            }.execute(messageDto.getAuthorId());
        }

        message.setText(messageDto.getContent());
    }
}

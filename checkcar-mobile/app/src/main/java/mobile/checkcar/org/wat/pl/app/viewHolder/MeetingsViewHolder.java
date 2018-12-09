package mobile.checkcar.org.wat.pl.app.viewHolder;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.Utils.FragmentUtils;
import mobile.checkcar.org.wat.pl.app.Utils.PersonUtils;
import mobile.checkcar.org.wat.pl.app.Utils.RetrofitUtils;
import mobile.checkcar.org.wat.pl.app.activity.MainActivity;
import mobile.checkcar.org.wat.pl.app.fragment.ChatFragment;
import mobile.checkcar.org.wat.pl.app.service.PersonService;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;
import retrofit2.Response;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class MeetingsViewHolder extends RecyclerView.ViewHolder {

    private View itemView;
    private Context context;
    private Long ownerId;
    private PersonDto personDto;
    public MeetingsViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        this.itemView = itemView;
    }

    public void bindData(MeetingDto meetingDto){

        if(meetingDto == null){
            return;
        }

        TextView carOwnerName = itemView.findViewById(R.id.car_owner_name);
        TextView interestedName = itemView.findViewById(R.id.interested_name);
        Button goTochatButton = itemView.findViewById(R.id.go_to_chat);

        if(PersonUtils.getLoggedPerson().getId().equals(meetingDto.getOwnerId())){
            carOwnerName.setText(String.format("%s %s",PersonUtils.getLoggedPerson().getName(),PersonUtils.getLoggedPerson().getSurname()));
            personDto = getCredentrials(meetingDto.getInterestedId());
            interestedName.setText(String.format("%s %s",personDto.getName(),personDto.getSurname()));
            ownerId = PersonUtils.getLoggedPerson().getId();
        }else if(PersonUtils.getLoggedPerson().getId().equals(meetingDto.getInterestedId())){
            interestedName.setText(String.format("%s %s",PersonUtils.getLoggedPerson().getName(),PersonUtils.getLoggedPerson().getSurname()));
            personDto = getCredentrials(meetingDto.getOwnerId());
            carOwnerName.setText(String.format("%s %s",personDto.getName(),personDto.getSurname()));
            ownerId = personDto.getId();

        }

        goTochatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("ownerId",ownerId);
                bundle.putLong("personId",personDto.getId());
                FragmentUtils.changeMainContentFragment((MainActivity)context, ChatFragment.class,true, bundle);
            }
        });


    }

    private PersonDto getCredentrials(Long personId){
        try {
            return new AsyncTask<Long, Void, PersonDto>(){

                 @Override
                 protected PersonDto doInBackground(Long... longs) {
                     Long id = longs[0];
                     PersonService service = RetrofitUtils.retrofit.create(PersonService.class);
                     try {
                         Response response = service.getPerson(id).execute();
                         if(response.body() != null){
                             return (PersonDto) response.body();
                         }
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                     return null;
                 }

                 @Override
                 protected void onPostExecute(PersonDto personDto) {
                     super.onPostExecute(personDto);
                     if(personDto == null){
                         return;
                     }
                 }
             }.execute(personId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}

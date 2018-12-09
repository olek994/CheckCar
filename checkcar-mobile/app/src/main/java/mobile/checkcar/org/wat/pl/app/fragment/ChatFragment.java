package mobile.checkcar.org.wat.pl.app.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.checkcar.org.wat.pl.app.Base.BaseFragment;
import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.Utils.PersonUtils;
import mobile.checkcar.org.wat.pl.app.Utils.RetrofitUtils;
import mobile.checkcar.org.wat.pl.app.adapter.MessagesAdapter;
import mobile.checkcar.org.wat.pl.app.asyncTaskLoader.MessageAsyncTaskLoader;
import mobile.checkcar.org.wat.pl.app.service.MeetingService;
import mobile.checkcar.org.wat.pl.app.service.MessageService;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;
import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;
import retrofit2.Response;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class ChatFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<List<MessageDto>> {

    @BindView(R.id.message_edit_text)
    EditText messageEditText;

    @BindView(R.id.messages_recycler_view)
    RecyclerView messagesRecyclerView;

    private Long ownerId;
    private Long personId;
    private Long meetingId;
    private MessagesAdapter messagesAdapter;
    @Override
    public int getTitleStringId() {
        return R.string.chat_title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_chat, null);
        ButterKnife.bind(this,itemView);

        messagesRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        messagesRecyclerView.setLayoutManager(layoutManager);

        messagesAdapter = new MessagesAdapter();
        messagesRecyclerView.setAdapter(messagesAdapter);


        return itemView;
    }


    @OnClick(value = R.id.send_message_button)
    public void onSendMessageClick(){
        String message = messageEditText.getText().toString();
        if(message.equals("")){
            Toast.makeText(getContext(), "Wprowadz wiadomość", Toast.LENGTH_SHORT).show();
            return;
        }
        MessageDto messageDto = new MessageDto();
        messageDto.setAuthorId(PersonUtils.getLoggedPerson().getId());
        messageDto.setMeetingId(meetingId);
        messageDto.setContent(message);

        new AsyncTask<MessageDto, Void, MessageDto>(){

            @Override
            protected MessageDto doInBackground(MessageDto... messageDtos) {
                MessageDto messageToSend = messageDtos[0];
                MessageService messageService = RetrofitUtils.retrofit.create(MessageService.class);
                try {
                    Response response = messageService.createMessage(messageToSend).execute();
                    if(response.body() != null){
                        return (MessageDto) response.body();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(MessageDto messageDto) {
                super.onPostExecute(messageDto);
                messagesAdapter.add(messageDto);
                messageEditText.setText("");
            }
        }.execute(messageDto);

    }

    @Override
    public void onStart() {
        super.onStart();
        ownerId = getArguments().getLong("ownerId",0);
        personId = getArguments().getLong("personId",0);

        MeetingDto newMeetingDto = new MeetingDto();
        newMeetingDto.setOwnerId(ownerId);

        if(!ownerId.equals(PersonUtils.getLoggedPerson().getId())){
            newMeetingDto.setInterestedId(PersonUtils.getLoggedPerson().getId());
        }else{
            newMeetingDto.setInterestedId(personId);
        }


        new AsyncTask<MeetingDto,Void,MeetingDto>(){

            @Override
            protected MeetingDto doInBackground(MeetingDto... meetingDtos) {
                MeetingDto meet = meetingDtos[0];
                MeetingService meetingService = RetrofitUtils.retrofit.create(MeetingService.class);

                try {
                    Response response = meetingService.createOrGetMeeting(meet).execute();
                    if(response.body() != null){
                        return (MeetingDto)response.body();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(MeetingDto meetingDto) {
                super.onPostExecute(meetingDto);
                meetingId = meetingDto.getId();
                loadMessages();
                setRepeatingAsyncTask();
            }
        }.execute(newMeetingDto);

    }

    @Override
    public Loader<List<MessageDto>> onCreateLoader(int id, Bundle args) {
        return new MessageAsyncTaskLoader(getContext(),meetingId);
    }

    @Override
    public void onLoadFinished(Loader<List<MessageDto>> loader, List<MessageDto> data) {
        if(data == null){
            return;
        }
        messagesAdapter.add(data);
    }

    @Override
    public void onLoaderReset(Loader<List<MessageDto>> loader) {
        loadMessages();
    }

    private void loadMessages(){
        getLoaderManager().initLoader(0,null,this).forceLoad();
    }

    private void setRepeatingAsyncTask() {

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadMessages();
                    }
                });
            }
        };

        timer.schedule(task, 5000, 5000);  // interval of one minute

    }
}

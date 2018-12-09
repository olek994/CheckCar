package mobile.checkcar.org.wat.pl.app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.Utils.PersonUtils;
import mobile.checkcar.org.wat.pl.app.viewHolder.MessagesViewHolder;
import pl.edu.wat.checkcar.checkcardomain.dto.MessageDto;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class MessagesAdapter extends RecyclerView.Adapter<MessagesViewHolder> {
    private List<MessageDto> messages = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        MessageDto messageDto = messages.get(position);

        if(messageDto.getAuthorId().equals(PersonUtils.getLoggedPerson().getId())){
            return 1;
        }else{
            return 2;
        }
    }

    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView;
        if(viewType == 1){
            itemView = inflater.inflate(R.layout.my_message_row,null);
        }else{
            itemView = inflater.inflate(R.layout.other_message_row,null);
        }
        return new MessagesViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        MessageDto messageDto = messages.get(position);
        holder.bindData(messageDto);
    }

    public void add(MessageDto messageDto){
        messages.add(messageDto);
        notifyDataSetChanged();
    }

    public void add(List<MessageDto> messageList){
        messages.clear();
        messages.addAll(messageList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}

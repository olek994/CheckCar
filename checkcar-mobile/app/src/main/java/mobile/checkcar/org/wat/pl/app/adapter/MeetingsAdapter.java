package mobile.checkcar.org.wat.pl.app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.viewHolder.MeetingsViewHolder;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class MeetingsAdapter extends RecyclerView.Adapter<MeetingsViewHolder> {
    private List<MeetingDto> meetings = new ArrayList<>();

    @NonNull
    @Override
    public MeetingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.meeting_row,null);
        return new MeetingsViewHolder(itemView,parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingsViewHolder holder, int position) {
        MeetingDto meetingDto = meetings.get(position);
        holder.bindData(meetingDto);
    }

    public void add(MeetingDto meetingDto){
        meetings.add(meetingDto);
        notifyDataSetChanged();
    }

    public void add(List<MeetingDto> meetingList){
        meetings.clear();
        meetings.addAll(meetingList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }
}

package mobile.checkcar.org.wat.pl.app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.checkcar.org.wat.pl.app.Base.BaseFragment;
import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.adapter.MeetingsAdapter;
import mobile.checkcar.org.wat.pl.app.asyncTaskLoader.MeetingsAsyncTaskLoader;
import pl.edu.wat.checkcar.checkcardomain.dto.MeetingDto;

/**
 * Created by Aleksander on 03.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class DashboardFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<List<MeetingDto>> {

    @BindView(R.id.meetings_recycler_view)
    RecyclerView meetingsRecyclerView;

    private MeetingsAdapter meetingsAdapter;
    @Override
    public int getTitleStringId() {
        return R.string.dashboard_title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_dashboard, null);
        ButterKnife.bind(this,itemView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        meetingsRecyclerView.setLayoutManager(layoutManager);

        meetingsAdapter =  new MeetingsAdapter();
        meetingsRecyclerView.setAdapter(meetingsAdapter);

        return itemView;
    }

    @Override
    public void onStart() {
        super.onStart();
        loadMeetings();
    }

    @NonNull
    @Override
    public Loader<List<MeetingDto>> onCreateLoader(int id, @Nullable Bundle args) {
        return new MeetingsAsyncTaskLoader(getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<MeetingDto>> loader, List<MeetingDto> data) {
        if(data == null){
            return;
        }
        meetingsAdapter.add(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<MeetingDto>> loader) {
        loadMeetings();
    }
    private void loadMeetings(){
        getLoaderManager().initLoader(0,null,this).forceLoad();
    }
}

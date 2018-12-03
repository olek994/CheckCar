package mobile.checkcar.org.wat.pl.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import mobile.checkcar.org.wat.pl.app.Base.BaseFragment;
import mobile.checkcar.org.wat.pl.app.asyncTaskLoader.PersonAsyncTaskLoader;
import pl.edu.wat.checkcar.checkcardomain.dto.PersonDto;

/**
 * Created by Aleksander on 03.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class DashboardFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<PersonDto> {
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
        return inflater.inflate(R.layout.fragment_dashboard, null);
    }

    @Override
    public void onStart() {
        super.onStart();
        getLoaderManager().initLoader(0,null,this).forceLoad();
    }

    @NonNull
    @Override
    public Loader<PersonDto> onCreateLoader(int id, @Nullable Bundle args) {
        return new PersonAsyncTaskLoader(getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<PersonDto> loader, PersonDto data) {
        if(data != null){
            Toast.makeText(getContext(), data.getName()+" "+data.getSurname(), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "NIE POBRALEM PERSON", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<PersonDto> loader) {
        getLoaderManager().initLoader(0,null,this).forceLoad();
    }
}

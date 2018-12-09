package mobile.checkcar.org.wat.pl.app.fragment;

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
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.checkcar.org.wat.pl.app.Base.BaseFragment;
import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.adapter.InterestingCarsAdapter;
import mobile.checkcar.org.wat.pl.app.asyncTaskLoader.InterestingCarsAsyncTaskLoader;
import pl.edu.wat.checkcar.checkcardomain.CarWithModelAndType;
import pl.edu.wat.checkcar.checkcardomain.dto.InterestingCarDto;


public class InterestingCarsFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<List<CarWithModelAndType>> {

    @BindView(R.id.interesting_cars_recycler_view)
    RecyclerView recyclerView;

    private InterestingCarsAdapter interestingCarsAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interesting_cars, null);

        ButterKnife.bind(this,view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        interestingCarsAdapter = new InterestingCarsAdapter();
        recyclerView.setAdapter(interestingCarsAdapter);

        return view;
    }

    @Override
    public int getTitleStringId() {
        return R.string.interesting_cars;
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().setTitle(R.string.interesting_cars);

        loadInterestingCars();
    }

    @Override
    public Loader<List<CarWithModelAndType>> onCreateLoader(int id, Bundle args) {
        return new InterestingCarsAsyncTaskLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<List<CarWithModelAndType>> loader, List<CarWithModelAndType> data) {
        if(data == null){
            return;
        }
        interestingCarsAdapter.addCars(data);

    }

    @Override
    public void onLoaderReset(Loader<List<CarWithModelAndType>> loader) {
        loadInterestingCars();
    }

    private void loadInterestingCars(){
        getLoaderManager().initLoader(0,null,this).forceLoad();
    }
}

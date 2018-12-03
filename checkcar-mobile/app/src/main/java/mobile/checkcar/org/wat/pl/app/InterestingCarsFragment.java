package mobile.checkcar.org.wat.pl.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobile.checkcar.org.wat.pl.app.Base.BaseFragment;


public class InterestingCarsFragment extends BaseFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_interesting_cars, null);
    }

    @Override
    public int getTitleStringId() {
        return R.string.interesting_cars;
    }
}

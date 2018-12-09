package mobile.checkcar.org.wat.pl.app.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.viewHolder.InterestingCarsViewHolder;
import pl.edu.wat.checkcar.checkcardomain.CarWithModelAndType;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class InterestingCarsAdapter extends RecyclerView.Adapter<InterestingCarsViewHolder> {
    private List<CarWithModelAndType> interestingCars = new ArrayList<>();

    @NonNull
    @Override
    public InterestingCarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.interesting_car_row,null);
        InterestingCarsViewHolder viewHolder = new InterestingCarsViewHolder(itemView,parent.getContext());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InterestingCarsViewHolder holder, int position) {
        CarWithModelAndType carWithModelAndType = interestingCars.get(position);
        holder.bindData(carWithModelAndType);
    }


    public void addCar(CarWithModelAndType car){
        interestingCars.add(car);
        notifyDataSetChanged();
    }

    public void addCars(List<CarWithModelAndType> cars){
        interestingCars.clear();
        interestingCars.addAll(cars);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return interestingCars.size();
    }
}

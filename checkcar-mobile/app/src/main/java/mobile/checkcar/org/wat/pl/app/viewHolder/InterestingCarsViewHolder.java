package mobile.checkcar.org.wat.pl.app.viewHolder;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.checkcar.org.wat.pl.app.R;
import mobile.checkcar.org.wat.pl.app.Utils.FragmentUtils;
import mobile.checkcar.org.wat.pl.app.Utils.ImageUtils;
import mobile.checkcar.org.wat.pl.app.activity.MainActivity;
import mobile.checkcar.org.wat.pl.app.fragment.ChatFragment;
import pl.edu.wat.checkcar.checkcardomain.CarWithModelAndType;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class InterestingCarsViewHolder extends RecyclerView.ViewHolder {


    private View itemView;
    private Context context;
    private Long ownerId;
    public InterestingCarsViewHolder(View itemView, Context context) {
        super(itemView);
        this.itemView = itemView;
        this.context = context;
    }

    public void bindData(CarWithModelAndType carWithModelAndType){
        if(carWithModelAndType == null){
            return;
        }
        ImageView carImage = itemView.findViewById(R.id.car_image);
        TextView carModel =  itemView.findViewById(R.id.car_model);
        TextView carType =   itemView.findViewById(R.id.car_type);
        TextView carCourse = itemView.findViewById(R.id.car_course);
        TextView carEngine = itemView.findViewById(R.id.car_engine);
        TextView carFuel = itemView.findViewById(R.id.car_fuel);
        TextView carHorsePower = itemView.findViewById(R.id.car_horse_power);
        TextView carYear = itemView.findViewById(R.id.car_year);
        TextView carCost = itemView.findViewById(R.id.car_cost_for_ride);
        Button chatButton = itemView.findViewById(R.id.go_to_chat_button);

        carCost.setText(String.format("%d %s",carWithModelAndType.getCostForRide(),"zł"));
        carYear.setText(String.format("%d %s",carWithModelAndType.getProductionYear(),"r."));
        carHorsePower.setText(carWithModelAndType.getHorsePower());
        carFuel.setText(carWithModelAndType.getFuel());
        carEngine.setText(carWithModelAndType.getEngine());
        carModel.setText(carWithModelAndType.getModel());
        carType.setText(carWithModelAndType.getType());
        carCourse.setText(String.format("%s %s",carWithModelAndType.getCourse().toString(),"km"));
        carImage.setImageBitmap(ImageUtils.stringToBitmap(carWithModelAndType.getCarImage()));
        ownerId = carWithModelAndType.getOwnerId();
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("ownerId",ownerId);
                FragmentUtils.changeMainContentFragment((MainActivity)context, ChatFragment.class,true, bundle);
            }
        });


    }
}

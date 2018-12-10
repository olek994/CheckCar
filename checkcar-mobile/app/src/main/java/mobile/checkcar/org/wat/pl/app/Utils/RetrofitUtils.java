package mobile.checkcar.org.wat.pl.app.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aleksander on 03.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class RetrofitUtils {

    public static Retrofit retrofit;

    public static void initRetrofir(){
        retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.8.102:8060/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }


}

package mobile.checkcar.org.wat.pl.app.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

/**
 * Created by Aleksander on 09.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class ImageUtils {

    public static Bitmap stringToBitmap(String imageString){
        try{
            String image = imageString.split(",")[1];
            byte[] stringByte= Base64.decode(image,Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(stringByte,0,stringByte.length);
            return bitmap;
        }catch (Exception ex){
            Log.e("ERROR",ex.getLocalizedMessage());
        }
        return null;
    }
}

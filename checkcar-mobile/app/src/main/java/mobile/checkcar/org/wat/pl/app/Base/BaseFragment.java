package mobile.checkcar.org.wat.pl.app.Base;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

/**
 * Created by Aleksander on 03.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */

public abstract class BaseFragment  extends Fragment {
    @StringRes
    public abstract int getTitleStringId();
}

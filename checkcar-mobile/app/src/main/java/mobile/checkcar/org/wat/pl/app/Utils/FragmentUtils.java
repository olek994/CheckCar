package mobile.checkcar.org.wat.pl.app.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import mobile.checkcar.org.wat.pl.app.Base.BaseFragment;
import mobile.checkcar.org.wat.pl.app.R;

/**
 * Created by Aleksander on 03.12.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class FragmentUtils {

    public static Class<? extends BaseFragment> replaceFragment(FragmentActivity fragmentActivity, Class<? extends BaseFragment> fragmentClazz){
        if(fragmentClazz != null){
            try {
                FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                BaseFragment fragment = fragmentClazz.newInstance();
                fragmentTransaction.replace(R.id.main_fragment_content,fragment);
                fragmentTransaction.commit();

                fragmentActivity.setTitle(fragment.getTitleStringId());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fragmentClazz;
    }
}

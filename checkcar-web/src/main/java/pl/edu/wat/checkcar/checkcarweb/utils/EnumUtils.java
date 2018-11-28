package pl.edu.wat.checkcar.checkcarweb.utils;

import pl.edu.wat.checkcar.checkcardomain.GearBoxEnum;

/**
 * Created by Aleksander Małkowicz, Date: 28.11.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
public class EnumUtils {

    public static String getGearBoxEnumString(GearBoxEnum gearBoxEnum){
        if(gearBoxEnum.equals(GearBoxEnum.AUTOMATIC)){
            return "Automatyczna";
        }else if(gearBoxEnum.equals(GearBoxEnum.MANUAL)){
            return "Manualna";
        }
        return "brak";
    }
}

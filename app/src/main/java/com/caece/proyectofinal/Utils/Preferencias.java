package com.caece.proyectofinal.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by lea on 6/09/13.
 */
public class Preferencias {

    public static Boolean DatosHabilitadas(Context context){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        String pepe = sharedPrefs.getString("internet_list", "");
        if(pepe.equals("")){
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putString("internet_list", "0");
            editor.commit();
        }

        if(sharedPrefs.getString("internet_list", "").equals("0"))
            return true;
        else return false;

    }

    public static Boolean yaLocalize(Context context){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPrefs.getBoolean("yaLocalize", true);

    }

    public static void cancelarLocalizacion(Context context){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPrefs.edit().putBoolean("yaLocalize", true).commit();

    }

    public static Boolean primeraCorrida(Context context){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        Boolean primeraCorrida = sharedPrefs.getBoolean("primeraCorrida", true);

        if (primeraCorrida){

            sharedPrefs.edit().putBoolean("primeraCorrida", false).commit();
            sharedPrefs.edit().putLong("timePrimeraCorrida", Calendar.getInstance().getTimeInMillis()).commit();

        }


        return primeraCorrida;

    }

    public static Boolean superaLimiteMemoriaInterna(Context context, int romLevel){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        String valor = sharedPrefs.getString("memint_list", "");

        if(Integer.parseInt(valor) < romLevel)
            return true;
        else return false;

    }

    public static Boolean superaLimiteMemoriaExterna(Context context, int sdLevel){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        String valor = sharedPrefs.getString("memext_list", "");

        if(Integer.parseInt(valor) < sdLevel)
            return true;
        else return false;

    }

    public static long getTimePrimeraCorrida(Context context){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPrefs.getLong("timePrimeraCorrida", 0);

    }

}

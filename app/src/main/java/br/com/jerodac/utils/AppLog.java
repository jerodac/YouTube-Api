package br.com.jerodac.utils;

import android.util.Log;

import br.com.jerodac.BuildConfig;

/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public class AppLog {

    //Ativa logs
    static final boolean isDebug = BuildConfig.DEBUG;
    public final static String TAG = "APP_LOG";

    public static void e(String tag, String message) {
        if (isDebug) {
            Log.e(tag, message);
        }
    }

    public static void e(String tag, String message, Exception e) {
        if (isDebug) {
            Log.e(tag, message, e);
        }
    }

    public static void i(String tag, String message) {
        if (isDebug) {
            Log.i(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (isDebug) {
            Log.v(tag, message);
        }
    }

    public static boolean isDebug() {
        return isDebug;
    }
}

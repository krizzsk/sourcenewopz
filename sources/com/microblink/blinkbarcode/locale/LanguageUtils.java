package com.microblink.blinkbarcode.locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.didi.sdk.apm.SystemUtils;
import com.microblink.blinkbarcode.util.Log;
import java.util.Locale;

/* compiled from: line */
public class LanguageUtils {
    private static String IlIllIlIIl;
    private static String llIIlIlIIl;

    public static void setLanguageAndCountry(String str, String str2, Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, "Microblink.prefs", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        llIIlIlIIl = str;
        IlIllIlIIl = str2;
        if (str == null) {
            String string = sharedPreferences.getString("PREFS_LANGUAGE", (String) null);
            llIIlIlIIl = string;
            if (string == null) {
                String language = Locale.getDefault().getLanguage();
                llIIlIlIIl = language;
                edit.putString("PREFS_LANGUAGE", language);
            }
        } else {
            edit.putString("PREFS_LANGUAGE", str);
        }
        String str3 = IlIllIlIIl;
        if (str3 == null) {
            String string2 = sharedPreferences.getString("PREFS_COUNTRY", (String) null);
            IlIllIlIIl = string2;
            if (string2 == null) {
                String country = Locale.getDefault().getCountry();
                IlIllIlIIl = country;
                edit.putString("PREFS_COUNTRY", country);
            }
        } else {
            edit.putString("PREFS_COUNTRY", str3);
        }
        edit.commit();
        setLanguageConfiguration(context.getResources());
    }

    public static void setLanguageConfiguration(Resources resources) {
        Class<LanguageUtils> cls = LanguageUtils.class;
        Configuration configuration = resources.getConfiguration();
        String str = llIIlIlIIl;
        if (str != null && !str.equals("")) {
            String str2 = IlIllIlIIl;
            if (str2 == null || str2.equals("")) {
                Log.m40231i(cls, "Setting language to '{}'", llIIlIlIIl);
                if (Build.VERSION.SDK_INT >= 24) {
                    configuration.setLocale(new Locale(llIIlIlIIl));
                } else {
                    configuration.locale = new Locale(llIIlIlIIl);
                }
            } else {
                Log.m40231i(cls, "Setting language to '{}', country to '{}'", llIIlIlIIl, IlIllIlIIl);
                if (Build.VERSION.SDK_INT >= 24) {
                    configuration.setLocale(new Locale(llIIlIlIIl, IlIllIlIIl));
                } else {
                    configuration.locale = new Locale(llIIlIlIIl, IlIllIlIIl);
                }
            }
        }
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
    }
}

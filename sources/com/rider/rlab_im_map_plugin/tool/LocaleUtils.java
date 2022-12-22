package com.rider.rlab_im_map_plugin.tool;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import java.util.Locale;

public final class LocaleUtils {
    public static Locale getAppLocale(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = context.getResources().getConfiguration().locale;
        }
        return locale == null ? new Locale("en-US") : locale;
    }

    public static Locale getSysLocale() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        } else {
            locale = Resources.getSystem().getConfiguration().locale;
        }
        return locale == null ? new Locale("en-US") : locale;
    }

    public static Context attachBaseContext(Context context, Locale locale) {
        if (locale == null) {
            locale = getAppLocale(ImMapConfig.getInstance().getContext());
        }
        return setLocale(context, locale);
    }

    public static Context setLocale(Context context, Locale locale) {
        Resources resources;
        if (context.getApplicationContext() == null) {
            resources = context.getResources();
        } else {
            resources = context.getApplicationContext().getResources();
        }
        Configuration configuration = resources.getConfiguration();
        Locale.setDefault(locale);
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale);
            LocaleList localeList = new LocaleList(new Locale[]{locale});
            configuration.setLocales(localeList);
            LocaleList.setDefault(localeList);
            return context.createConfigurationContext(configuration);
        } else if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        } else {
            context.getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
            return context;
        }
    }
}

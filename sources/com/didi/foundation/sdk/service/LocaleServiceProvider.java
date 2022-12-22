package com.didi.foundation.sdk.service;

import android.content.Context;
import android.content.Intent;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Locale;

@ServiceProviderInterface
public interface LocaleServiceProvider {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CordinateType {
    }

    public interface OnLocaleChangedListener {
        void onLocaleChanged(Locale locale, Locale locale2);
    }

    void addOnLocaleChangedListener(OnLocaleChangedListener onLocaleChangedListener);

    Context attachBaseContext(Context context);

    Locale getCurrentLang();

    String getCurrentLangTag();

    Locale getCurrentLocale();

    String getCurrentLocaleTag();

    List<OnLocaleChangedListener> getOnLocaleChangedListeners();

    List<Locale> getSupportLocaleList();

    void init(Context context);

    void refreshLocale(Context context);

    void removeOnLocaleChangedListener(OnLocaleChangedListener onLocaleChangedListener);

    Locale switchLocale(Intent intent, String str);

    Locale switchLocale(Intent intent, Locale locale);
}

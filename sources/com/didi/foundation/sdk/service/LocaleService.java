package com.didi.foundation.sdk.service;

import android.content.Context;
import android.content.Intent;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.List;
import java.util.Locale;

public final class LocaleService implements LocaleServiceProvider {

    /* renamed from: a */
    private final LocaleServiceProvider f21305a;

    private LocaleService() {
        this.f21305a = (LocaleServiceProvider) ServiceLoader.load(LocaleServiceProvider.class).get();
    }

    public static final LocaleService getInstance() {
        return Singleton.INSTANCE;
    }

    public final void init(Context context) {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            localeServiceProvider.init(context);
        }
    }

    public final Context attachBaseContext(Context context) {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            return localeServiceProvider.attachBaseContext(context);
        }
        return null;
    }

    public final Locale getCurrentLocale() {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            return localeServiceProvider.getCurrentLocale();
        }
        return null;
    }

    public final String getCurrentLocaleTag() {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            return localeServiceProvider.getCurrentLocaleTag();
        }
        return null;
    }

    public final Locale getCurrentLang() {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            return localeServiceProvider.getCurrentLang();
        }
        return null;
    }

    public final String getCurrentLangTag() {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            return localeServiceProvider.getCurrentLangTag();
        }
        return null;
    }

    public final List<Locale> getSupportLocaleList() {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            return localeServiceProvider.getSupportLocaleList();
        }
        return null;
    }

    public final Locale switchLocale(Intent intent, Locale locale) {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            return localeServiceProvider.switchLocale(intent, locale);
        }
        return null;
    }

    public final Locale switchLocale(Intent intent, String str) {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            return localeServiceProvider.switchLocale(intent, str);
        }
        return null;
    }

    public final void addOnLocaleChangedListener(LocaleServiceProvider.OnLocaleChangedListener onLocaleChangedListener) {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            localeServiceProvider.addOnLocaleChangedListener(onLocaleChangedListener);
        }
    }

    public final void removeOnLocaleChangedListener(LocaleServiceProvider.OnLocaleChangedListener onLocaleChangedListener) {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            localeServiceProvider.removeOnLocaleChangedListener(onLocaleChangedListener);
        }
    }

    public final List<LocaleServiceProvider.OnLocaleChangedListener> getOnLocaleChangedListeners() {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            return localeServiceProvider.getOnLocaleChangedListeners();
        }
        return null;
    }

    public final void refreshLocale(Context context) {
        LocaleServiceProvider localeServiceProvider = this.f21305a;
        if (localeServiceProvider != null) {
            localeServiceProvider.refreshLocale(context);
        }
    }

    private static final class Singleton {
        static final LocaleService INSTANCE = new LocaleService();

        private Singleton() {
        }
    }
}

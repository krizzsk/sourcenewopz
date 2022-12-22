package com.didi.foundation.sdk.service;

import android.content.Context;
import com.didi.foundation.sdk.mlocale.DateStyle;
import com.didi.foundation.sdk.mlocale.DistanceStyle;
import com.didi.foundation.sdk.mlocale.TimeStyle;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

public final class LocalizationService implements LocalizationServiceProvider {

    /* renamed from: a */
    private final LocalizationServiceProvider f21318a;

    private LocalizationService() {
        this.f21318a = (LocalizationServiceProvider) ServiceLoader.load(LocalizationServiceProvider.class).get();
    }

    public static final LocalizationService getInstance() {
        return Singleton.INSTANCE;
    }

    public final void init(Context context, String str, String str2, String str3) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            localizationServiceProvider.init(context, str, str2, str3);
        }
    }

    public final void updateInit(Context context, String str, String str2, String str3) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            localizationServiceProvider.updateInit(context, str, str2, str3);
        }
    }

    public final String formatCurrency(int i, Boolean bool) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.formatCurrency(i, bool);
        }
        return null;
    }

    public final String formatCurrency(int i, String str, String str2, Boolean bool) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.formatCurrency(i, str, str2, bool);
        }
        return null;
    }

    public final String formatCurrency(String str, String str2, int i, Boolean bool) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.formatCurrency(str, str2, i, bool);
        }
        return null;
    }

    public final String formatCurrencyNoDeal(int i, Boolean bool) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.formatCurrencyNoDeal(i, bool);
        }
        return null;
    }

    public final String formatDateTime(long j, DateStyle dateStyle, TimeStyle timeStyle, boolean z) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.formatDateTime(j, dateStyle, timeStyle, z);
        }
        return null;
    }

    public final String formatCountdownTime(int i, boolean z) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.formatCountdownTime(i, z);
        }
        return null;
    }

    public final Calendar getDateTimeCalendar(long j) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.getDateTimeCalendar(j);
        }
        return null;
    }

    public final String getShortWeekDayByIndex(String str, int i) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.getShortWeekDayByIndex(str, i);
        }
        return null;
    }

    public final String getShortWeekDayByCalendarIndex(String str, int i) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.getShortWeekDayByCalendarIndex(str, i);
        }
        return null;
    }

    public final String formatDistance(double d, DistanceStyle distanceStyle, int i, boolean z) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.formatDistance(d, distanceStyle, i, z);
        }
        return null;
    }

    public final List splitDistance(double d, DistanceStyle distanceStyle, int i) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.splitDistance(d, distanceStyle, i);
        }
        return null;
    }

    public final String formatNumber(Number number, int i, int i2) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.formatNumber(number, i, i2);
        }
        return null;
    }

    public final Number parseNumber(String str) throws ParseException {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.parseNumber(str);
        }
        return null;
    }

    public final Number parseNumberSafety(String str, Number number) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.parseNumberSafety(str, number);
        }
        return null;
    }

    public final int getNumberPrecision(int i) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.getNumberPrecision(i);
        }
        return 0;
    }

    public final List splitCurrency(Number number) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.splitCurrency(number);
        }
        return null;
    }

    public final List splitCurrency(String str, String str2) {
        LocalizationServiceProvider localizationServiceProvider = this.f21318a;
        if (localizationServiceProvider != null) {
            return localizationServiceProvider.splitCurrency(str, str2);
        }
        return null;
    }

    private static final class Singleton {
        static final LocalizationService INSTANCE = new LocalizationService();

        private Singleton() {
        }
    }
}

package com.didi.foundation.sdk.service;

import android.content.Context;
import com.didi.foundation.sdk.mlocale.DateStyle;
import com.didi.foundation.sdk.mlocale.DistanceStyle;
import com.didi.foundation.sdk.mlocale.TimeStyle;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

@ServiceProviderInterface
public interface LocalizationServiceProvider {
    String formatCountdownTime(int i, boolean z);

    String formatCurrency(int i, Boolean bool);

    String formatCurrency(int i, String str, String str2, Boolean bool);

    String formatCurrency(String str, String str2, int i, Boolean bool);

    String formatCurrencyNoDeal(int i, Boolean bool);

    String formatDateTime(long j, DateStyle dateStyle, TimeStyle timeStyle, boolean z);

    String formatDistance(double d, DistanceStyle distanceStyle, int i, boolean z);

    String formatNumber(Number number, int i, int i2);

    Calendar getDateTimeCalendar(long j);

    int getNumberPrecision(int i);

    String getShortWeekDayByCalendarIndex(String str, int i);

    String getShortWeekDayByIndex(String str, int i);

    void init(Context context, String str, String str2, String str3);

    Number parseNumber(String str) throws ParseException;

    Number parseNumberSafety(String str, Number number);

    List splitCurrency(Number number);

    List splitCurrency(String str, String str2);

    List splitDistance(double d, DistanceStyle distanceStyle, int i);

    void updateInit(Context context, String str, String str2, String str3);
}

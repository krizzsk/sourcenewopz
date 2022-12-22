package com.didi.soda.customer.foundation.alarm;

import android.app.PendingIntent;
import android.content.Context;
import androidx.work.PeriodicWorkRequest;

public class AlarmCustomAdapter extends AlarmAdapter {
    public static final int HOUR = 3600000;
    public static final int MINUTE = 60000;
    public static final int SECOND = 1000;

    public void setRct(Context context, long j, PendingIntent pendingIntent) {
        if (j < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            super.set(context, j, pendingIntent);
        } else {
            super.setRct(context, j, pendingIntent);
        }
    }

    public void setRepeatingRct(Context context, long j, long j2, PendingIntent pendingIntent) {
        if (j < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            super.setRepeating(context, j, j2, pendingIntent);
        } else {
            super.setRepeatingRct(context, j, j2, pendingIntent);
        }
    }
}

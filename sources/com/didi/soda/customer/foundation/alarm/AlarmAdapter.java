package com.didi.soda.customer.foundation.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;

public class AlarmAdapter {
    public void cancel(Context context, PendingIntent pendingIntent) {
        AlarmManager alarmManager;
        if (context != null && pendingIntent != null && (alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)) != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void set(Context context, long j, PendingIntent pendingIntent) {
        AlarmManager alarmManager;
        if (context != null && pendingIntent != null && (alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)) != null) {
            alarmManager.cancel(pendingIntent);
            alarmManager.set(3, SystemClock.elapsedRealtime() + j, pendingIntent);
        }
    }

    public void setRct(Context context, long j, PendingIntent pendingIntent) {
        AlarmManager alarmManager;
        if (context != null && pendingIntent != null && (alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)) != null) {
            alarmManager.cancel(pendingIntent);
            alarmManager.set(2, SystemClock.elapsedRealtime() + j, pendingIntent);
        }
    }

    public void setRepeating(Context context, long j, long j2, PendingIntent pendingIntent) {
        AlarmManager alarmManager;
        if (context != null && pendingIntent != null && (alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)) != null) {
            alarmManager.cancel(pendingIntent);
            alarmManager.setRepeating(3, SystemClock.elapsedRealtime() + j, j2, pendingIntent);
        }
    }

    public void setRepeatingRct(Context context, long j, long j2, PendingIntent pendingIntent) {
        AlarmManager alarmManager;
        if (context != null && pendingIntent != null && (alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)) != null) {
            alarmManager.cancel(pendingIntent);
            alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + j, j2, pendingIntent);
        }
    }
}

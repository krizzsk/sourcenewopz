package com.didi.beatles.p099im.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.didi.beatles.p099im.omega.IMTraceError;

/* renamed from: com.didi.beatles.im.utils.IMPollingUtils */
public class IMPollingUtils {
    public static void startPollingService(Context context, int i, Class<?> cls, String str) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(context, cls);
        intent.setAction(str);
        PendingIntent service = PendingIntent.getService(context, 0, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : View.NAVIGATION_BAR_TRANSIENT);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (alarmManager != null) {
            try {
                alarmManager.setRepeating(3, elapsedRealtime, (long) (i * 1000), service);
            } catch (Exception e) {
                IMTraceError.trackError("im-sdk#startPollingService", e);
            }
        } else {
            IMLog.m6632e("manager is null! when IMPollingUtils startPollingService !", new Object[0]);
        }
    }

    public static void stopPollingService(Context context, Class<?> cls, String str) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(context, cls);
            intent.setAction(str);
            int i = View.NAVIGATION_BAR_TRANSIENT;
            if (Build.VERSION.SDK_INT >= 23) {
                i = 201326592;
            }
            PendingIntent service = PendingIntent.getService(context, 0, intent, i);
            if (alarmManager != null) {
                alarmManager.cancel(service);
            } else {
                IMLog.m6632e("manager is null! when IMPollingUtils stopPollingService !", new Object[0]);
            }
        } catch (Exception e) {
            IMLog.m6633e(e);
            IMTraceError.trackError("im_stop_polling_service", e);
        }
    }
}

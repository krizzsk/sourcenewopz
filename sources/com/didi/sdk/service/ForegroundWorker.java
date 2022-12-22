package com.didi.sdk.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.didi.sdk.nation.NationTypeUtil;
import com.taxis99.R;

public class ForegroundWorker extends Worker {
    public ForegroundWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        ((NotificationManager) getApplicationContext().getSystemService("notification")).notify(0, m26346a(R.drawable.ic_notification, getApplicationContext().getResources().getString(R.string.global_app_running_notification_title), (String) null));
        return ListenableWorker.Result.success();
    }

    /* renamed from: a */
    private Notification m26346a(int i, String str, String str2) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        if (notificationManager == null) {
            return null;
        }
        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(ForegroundService.NOTIFICATION_CHANNEL_GROUP_ID, ForegroundService.NOTIFICATION_CHANNEL_GROUP_NAME));
        NotificationChannel notificationChannel = new NotificationChannel("1", ForegroundService.NOTIFICATION_CHANNEL_NAME, 2);
        notificationChannel.setGroup(ForegroundService.NOTIFICATION_CHANNEL_GROUP_ID);
        notificationChannel.setShowBadge(false);
        notificationManager.createNotificationChannel(notificationChannel);
        Notification.Builder builder = new Notification.Builder(getApplicationContext(), "1");
        if (!TextUtils.isEmpty(str)) {
            builder.setContentTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setContentText(str2);
        }
        if (i != 0) {
            builder.setSmallIcon(i);
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://"));
        builder.setWhen(System.currentTimeMillis());
        builder.setContentIntent(PendingIntent.getActivity(getApplicationContext(), ForegroundService.NOTIFICATION_ID, intent, 201326592));
        return builder.build();
    }

    public void onStopped() {
        super.onStopped();
    }
}

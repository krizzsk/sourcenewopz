package com.didi.sdk.service;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;
import java.util.concurrent.atomic.AtomicBoolean;
import utils.ContextUtil;

public class ForegroundLauncher {

    /* renamed from: a */
    private static final String f37162a = "ForegroundLauncher";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Logger f37163b = LoggerFactory.getLogger(f37162a);

    /* renamed from: c */
    private static AtomicBoolean f37164c = new AtomicBoolean(false);

    public static void startForeground(Context context, int i, String str, String str2, int i2) {
        startForeground(context, i, str, str2, i2, (Bundle) null);
    }

    public static void startForeground(Context context, int i, String str, String str2, int i2, Bundle bundle) {
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 26 && !f37164c.getAndSet(true)) {
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 31) {
                WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(ForegroundWorker.class).setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)).build());
            }
            Logger logger = f37163b;
            logger.info("startForeground icon=" + i + " title=" + str + " content=" + str2 + " role=" + i2, new Object[0]);
            final Context context2 = context;
            final int i3 = i;
            final String str3 = str;
            final String str4 = str2;
            final int i4 = i2;
            final Bundle bundle2 = bundle;
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    Intent intent = new Intent(context2, ForegroundService.class);
                    intent.putExtra(ForegroundService.ARG_NOTIFICATION_ICON, i3);
                    intent.putExtra(ForegroundService.ARG_NOTIFICATION_TITLE, str3);
                    intent.putExtra(ForegroundService.ARG_NOTIFICATION_CONTENT, str4);
                    intent.putExtra("role", i4);
                    Bundle bundle = bundle2;
                    if (bundle != null) {
                        intent.putExtras(bundle);
                    }
                    try {
                        context2.startService(intent);
                    } catch (Exception e) {
                        ForegroundLauncher.f37163b.error(ForegroundLauncher.f37162a, "startForeground error", e);
                    }
                }
            });
        }
    }

    public static void startForeground(Context context, int i, String str, String str2) {
        startForeground(context, i, str, str2, 0);
    }

    public static void startForeground(Context context) {
        startForeground(context, R.drawable.ic_notification, context.getResources().getString(R.string.global_app_running_notification_title), (String) null);
    }

    public static void startForeground(Context context, String str, String str2) {
        startForeground(context, R.drawable.ic_notification, str, str2);
    }

    public static void stopForeground(final Context context) {
        if (context != null && f37164c.get()) {
            f37164c.set(false);
            f37163b.info("stopForeground", new Object[0]);
            if (context.getApplicationInfo().targetSdkVersion >= 31) {
                ((NotificationManager) ContextUtil.getApplicationContext().getSystemService("notification")).cancelAll();
            }
            if (context.getApplicationInfo().targetSdkVersion >= 26) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                    public void run() {
                        try {
                            context.stopService(new Intent(context, ForegroundService.class));
                        } catch (Exception e) {
                            ForegroundLauncher.f37163b.error(ForegroundLauncher.f37162a, "stopService error", e);
                        }
                    }
                });
            }
        }
    }
}

package com.didi.sdk.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.soda.customer.p165h5.CustomerWebActivity;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.lang.ref.WeakReference;

public class ForegroundService extends Service {
    public static final String ARG_NOTIFICATION_CONTENT = "notification_content";
    public static final String ARG_NOTIFICATION_ICON = "notification_icon";
    public static final String ARG_NOTIFICATION_TITLE = "notification_title";
    public static final String ARG_ROLE = "role";
    public static final String NOTIFICATION_CHANNEL_GROUP_ID = "svc";
    public static final String NOTIFICATION_CHANNEL_GROUP_NAME = "Service";
    public static final String NOTIFICATION_CHANNEL_ID = "1";
    public static final String NOTIFICATION_CHANNEL_NAME = "Foreground Service";
    public static final int NOTIFICATION_ID = 20181017;
    public static final String TAG = "ForegroundService";

    /* renamed from: a */
    private static final int f37165a = 5000;

    /* renamed from: b */
    private LoopHandler f37166b;

    /* renamed from: c */
    private int f37167c;
    public Logger mLogger = LoggerFactory.getLogger(TAG);

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(final Intent intent, int i, int i2) {
        Logger logger = this.mLogger;
        logger.info("onStartCommand intent=" + intent + " SDK_INT=" + Build.VERSION.SDK_INT, new Object[0]);
        if (intent == null || Build.VERSION.SDK_INT < 26) {
            stopSelf();
            return 2;
        }
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                try {
                    String stringExtra = intent.getStringExtra(ForegroundService.ARG_NOTIFICATION_TITLE);
                    String stringExtra2 = intent.getStringExtra(ForegroundService.ARG_NOTIFICATION_CONTENT);
                    Notification a = ForegroundService.this.m26339a(intent.getIntExtra(ForegroundService.ARG_NOTIFICATION_ICON, 0), stringExtra, stringExtra2);
                    if (a != null) {
                        ForegroundService.this.startForeground(ForegroundService.NOTIFICATION_ID, a);
                    }
                } catch (Exception e) {
                    SystemUtils.log(6, ForegroundService.TAG, "startForeground error", e, "com.didi.sdk.service.ForegroundService$1", 95);
                }
            }
        });
        if (isMonitorHandlerOpen()) {
            m26344b();
        }
        IForegroundServiceCallback iForegroundServiceCallback = (IForegroundServiceCallback) ServiceLoader.load(IForegroundServiceCallback.class).get();
        if (iForegroundServiceCallback != null) {
            int intExtra = intent.getIntExtra("role", 0);
            this.f37167c = intExtra;
            iForegroundServiceCallback.onServiceStartCommand(intExtra, intent.getExtras());
        }
        return 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Notification m26339a(int i, String str, String str2) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager == null) {
            return null;
        }
        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(NOTIFICATION_CHANNEL_GROUP_ID, NOTIFICATION_CHANNEL_GROUP_NAME));
        NotificationChannel notificationChannel = new NotificationChannel("1", NOTIFICATION_CHANNEL_NAME, 2);
        notificationChannel.setGroup(NOTIFICATION_CHANNEL_GROUP_ID);
        notificationChannel.setShowBadge(false);
        notificationManager.createNotificationChannel(notificationChannel);
        Notification.Builder builder = new Notification.Builder(this, "1");
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
        builder.setContentIntent(PendingIntent.getActivity(this, NOTIFICATION_ID, intent, View.NAVIGATION_BAR_TRANSIENT));
        return builder.build();
    }

    public void onDestroy() {
        stopForeground(true);
        LoopHandler loopHandler = this.f37166b;
        if (loopHandler != null) {
            loopHandler.removeCallbacksAndMessages((Object) null);
            this.f37166b = null;
        }
        IForegroundServiceCallback iForegroundServiceCallback = (IForegroundServiceCallback) ServiceLoader.load(IForegroundServiceCallback.class).get();
        if (iForegroundServiceCallback != null) {
            iForegroundServiceCallback.onServiceDestroy(this.f37167c);
        }
        super.onDestroy();
    }

    private static class LoopHandler extends Handler {
        private WeakReference<ForegroundService> ref;

        public LoopHandler(ForegroundService foregroundService) {
            this.ref = new WeakReference<>(foregroundService);
        }

        public void handleMessage(Message message) {
            SystemUtils.log(6, "ForegroundLauncher", "handleMessage", (Throwable) null, "com.didi.sdk.service.ForegroundService$LoopHandler", 174);
            WeakReference<ForegroundService> weakReference = this.ref;
            if (weakReference != null) {
                ForegroundService foregroundService = (ForegroundService) weakReference.get();
                try {
                    String str = (String) message.obj;
                    if (!ForegroundService.m26345b(foregroundService, str)) {
                        foregroundService.m26341a();
                        return;
                    }
                    Message obtain = Message.obtain();
                    obtain.obj = str;
                    sendMessageDelayed(obtain, 5000);
                } catch (Exception unused) {
                    foregroundService.m26341a();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26341a() {
        LoopHandler loopHandler = this.f37166b;
        if (loopHandler != null) {
            loopHandler.removeCallbacksAndMessages((Object) null);
        }
        stopSelf();
    }

    /* renamed from: b */
    private void m26344b() {
        String packageName = getPackageName();
        if (m26345b(getApplicationContext(), packageName)) {
            if (this.f37166b == null) {
                this.f37166b = new LoopHandler(this);
            }
            Message obtain = Message.obtain();
            obtain.obj = packageName;
            this.f37166b.sendMessageDelayed(obtain, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0018  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m26345b(android.content.Context r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "activity"
            java.lang.Object r2 = r2.getSystemService(r0)
            android.app.ActivityManager r2 = (android.app.ActivityManager) r2
            r0 = 100
            java.util.List r2 = r2.getRunningTasks(r0)
            java.util.Iterator r2 = r2.iterator()
        L_0x0012:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0038
            java.lang.Object r0 = r2.next()
            android.app.ActivityManager$RunningTaskInfo r0 = (android.app.ActivityManager.RunningTaskInfo) r0
            android.content.ComponentName r1 = r0.topActivity
            java.lang.String r1 = r1.getPackageName()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0036
            android.content.ComponentName r0 = r0.baseActivity
            java.lang.String r0 = r0.getPackageName()
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0012
        L_0x0036:
            r2 = 1
            goto L_0x0039
        L_0x0038:
            r2 = 0
        L_0x0039:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.service.ForegroundService.m26345b(android.content.Context, java.lang.String):boolean");
    }

    public static boolean isMonitorHandlerOpen() {
        try {
            IToggle toggle = Apollo.getToggle("ab_global_foreground_service_self_stop");
            if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam(CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 1)).intValue() != 1) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

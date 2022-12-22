package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.service.ForegroundService;
import com.google.android.play.core.internal.C18432ag;

public class AssetPackExtractionService extends Service {

    /* renamed from: a */
    Context f52695a;

    /* renamed from: b */
    C18401j f52696b;

    /* renamed from: c */
    C18319bb f52697c;

    /* renamed from: d */
    private final C18432ag f52698d = new C18432ag("AssetPackExtractionService");

    /* renamed from: e */
    private C18317b f52699e;

    /* renamed from: f */
    private NotificationManager f52700f;

    /* renamed from: b */
    private final synchronized void m37421b(Bundle bundle) {
        String string = bundle.getString(ForegroundService.ARG_NOTIFICATION_TITLE);
        String string2 = bundle.getString("notification_subtext");
        long j = bundle.getLong("notification_timeout");
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("notification_on_click_intent");
        Notification.Builder timeoutAfter = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(this.f52695a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j) : new Notification.Builder(this.f52695a).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(string).setSubText(string2);
        if (Build.VERSION.SDK_INT >= 21) {
            timeoutAfter.setColor(bundle.getInt("notification_color")).setVisibility(-1);
        }
        Notification build = timeoutAfter.build();
        this.f52698d.mo149084c("Starting foreground service.", new Object[0]);
        this.f52696b.mo149055a(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f52700f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", bundle.getString("notification_channel_name"), 2));
        }
        startForeground(-1883842196, build);
    }

    /* renamed from: a */
    public final synchronized Bundle mo148845a(Bundle bundle) {
        int i = bundle.getInt("action_type");
        C18432ag agVar = this.f52698d;
        Integer valueOf = Integer.valueOf(i);
        agVar.mo149081a("updateServiceState: %d", valueOf);
        if (i == 1) {
            m37421b(bundle);
        } else if (i == 2) {
            mo148846a();
        } else {
            this.f52698d.mo149083b("Unknown action type received: %d", valueOf);
        }
        return new Bundle();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo148846a() {
        this.f52698d.mo149084c("Stopping service.", new Object[0]);
        this.f52696b.mo149055a(false);
        stopForeground(true);
        stopSelf();
    }

    public final IBinder onBind(Intent intent) {
        return this.f52699e;
    }

    public final void onCreate() {
        super.onCreate();
        this.f52698d.mo149081a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, new Object[0]);
        C18373db.m37636a(getApplicationContext()).mo148874a(this);
        this.f52699e = new C18317b(this.f52695a, this, this.f52697c);
        this.f52700f = (NotificationManager) this.f52695a.getSystemService("notification");
    }
}

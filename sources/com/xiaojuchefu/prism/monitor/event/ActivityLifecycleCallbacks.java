package com.xiaojuchefu.prism.monitor.event;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.gson.Gson;
import com.xiaojuchefu.prism.monitor.PrismMonitor;
import com.xiaojuchefu.prism.monitor.model.EventData;

public class ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c */
    private static volatile int f56098c;

    /* renamed from: a */
    PrismMonitor f56099a = PrismMonitor.getInstance();

    /* renamed from: b */
    private Gson f56100b;

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(android.app.Activity r4, android.os.Bundle r5) {
        /*
            r3 = this;
            com.xiaojuchefu.prism.monitor.PrismMonitor r5 = r3.f56099a
            boolean r5 = r5.isTest()
            if (r5 == 0) goto L_0x0031
            android.content.Intent r5 = r4.getIntent()
            android.os.Bundle r5 = r5.getExtras()
            if (r5 == 0) goto L_0x0031
            com.google.gson.Gson r0 = r3.f56100b     // Catch:{ Exception -> 0x0031 }
            if (r0 != 0) goto L_0x002a
            com.google.gson.GsonBuilder r0 = new com.google.gson.GsonBuilder     // Catch:{ Exception -> 0x0031 }
            r0.<init>()     // Catch:{ Exception -> 0x0031 }
            com.xiaojuchefu.prism.monitor.model.BundleTypeAdapterFactory r1 = new com.xiaojuchefu.prism.monitor.model.BundleTypeAdapterFactory     // Catch:{ Exception -> 0x0031 }
            r1.<init>()     // Catch:{ Exception -> 0x0031 }
            com.google.gson.GsonBuilder r0 = r0.registerTypeAdapterFactory(r1)     // Catch:{ Exception -> 0x0031 }
            com.google.gson.Gson r0 = r0.create()     // Catch:{ Exception -> 0x0031 }
            r3.f56100b = r0     // Catch:{ Exception -> 0x0031 }
        L_0x002a:
            com.google.gson.Gson r0 = r3.f56100b     // Catch:{ Exception -> 0x0031 }
            java.lang.String r5 = r0.toJson((java.lang.Object) r5)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            com.xiaojuchefu.prism.monitor.model.EventData r0 = new com.xiaojuchefu.prism.monitor.model.EventData
            r1 = 6
            r0.<init>(r1)
            r0.activity = r4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "an_&_"
            r1.append(r2)
            java.lang.Class r2 = r4.getClass()
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.eventId = r1
            if (r5 == 0) goto L_0x0066
            java.util.HashMap r1 = new java.util.HashMap
            r2 = 1
            r1.<init>(r2)
            r0.data = r1
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.data
            java.lang.String r2 = "bundle"
            r1.put(r2, r5)
        L_0x0066:
            com.xiaojuchefu.prism.monitor.PrismMonitor r5 = r3.f56099a
            r5.post((com.xiaojuchefu.prism.monitor.model.EventData) r0)
            android.content.Intent r4 = r4.getIntent()
            if (r4 == 0) goto L_0x00a6
            java.lang.String r5 = r4.getAction()
            java.lang.String r0 = "android.intent.action.VIEW"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x00a6
            android.net.Uri r4 = r4.getData()
            if (r4 == 0) goto L_0x00a6
            com.xiaojuchefu.prism.monitor.model.EventData r5 = new com.xiaojuchefu.prism.monitor.model.EventData
            r0 = 9
            r5.<init>(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "scheme_&_"
            r0.append(r1)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.eventId = r4
            com.xiaojuchefu.prism.monitor.PrismMonitor r4 = r3.f56099a
            r4.post((com.xiaojuchefu.prism.monitor.model.EventData) r5)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaojuchefu.prism.monitor.event.ActivityLifecycleCallbacks.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public void onActivityStarted(Activity activity) {
        int i = f56098c;
        f56098c = i + 1;
        if (i == 0) {
            EventData eventData = new EventData(3);
            eventData.activity = activity;
            eventData.eventId = "an_&_" + activity.getClass().getName();
            this.f56099a.post(eventData);
        }
    }

    public void onActivityResumed(Activity activity) {
        EventData eventData = new EventData(10);
        eventData.activity = activity;
        eventData.eventId = "an_&_" + activity.getClass().getName();
        this.f56099a.post(eventData);
    }

    public void onActivityPaused(Activity activity) {
        EventData eventData = new EventData(11);
        eventData.activity = activity;
        eventData.eventId = "an_&_" + activity.getClass().getName();
        this.f56099a.post(eventData);
    }

    public void onActivityStopped(Activity activity) {
        int i = f56098c;
        f56098c = i - 1;
        if (1 == i) {
            EventData eventData = new EventData(2);
            eventData.activity = activity;
            eventData.eventId = "an_&_" + activity.getClass().getName();
            this.f56099a.post(eventData);
        }
    }
}

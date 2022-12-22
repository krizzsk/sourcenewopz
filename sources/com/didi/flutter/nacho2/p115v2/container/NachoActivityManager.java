package com.didi.flutter.nacho2.p115v2.container;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.didi.flutter.nacho2.v2.container.NachoActivityManager */
public class NachoActivityManager {

    /* renamed from: a */
    private WeakReference<Activity> f21146a;

    /* renamed from: b */
    private LinkedList<WeakReference<Activity>> f21147b;

    /* renamed from: c */
    private boolean f21148c;

    /* renamed from: d */
    private Application f21149d;

    /* renamed from: e */
    private boolean f21150e;

    private NachoActivityManager() {
        this.f21147b = new LinkedList<>();
        this.f21150e = false;
    }

    /* renamed from: com.didi.flutter.nacho2.v2.container.NachoActivityManager$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static NachoActivityManager INSTANCE = new NachoActivityManager();

        private SingletonHolder() {
        }
    }

    public static NachoActivityManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Application application) {
        if (!this.f21150e) {
            application.registerActivityLifecycleCallbacks(new NachoActivityLifecycleCallbacks());
            this.f21149d = application;
            this.f21150e = true;
        }
    }

    public WeakReference<Activity> getTopActivity() {
        return this.f21146a;
    }

    public void setTopActivity(WeakReference<Activity> weakReference) {
        this.f21146a = weakReference;
    }

    public LinkedList<WeakReference<Activity>> getActivities() {
        return this.f21147b;
    }

    public void setActivities(LinkedList<WeakReference<Activity>> linkedList) {
        this.f21147b = linkedList;
    }

    public boolean isPaddingOpenContainer() {
        return this.f21148c;
    }

    public void setPaddingOpenContainer(boolean z) {
        this.f21148c = z;
    }

    public boolean isFlutterContainer(Activity activity) {
        return activity instanceof NachoFlutterActivity;
    }

    public Activity getStrictTopActivity() {
        if (this.f21146a == null && this.f21147b.size() > 0) {
            this.f21146a = this.f21147b.getLast();
        }
        WeakReference<Activity> weakReference = this.f21146a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public NachoFlutterActivity getTopContainer() {
        Activity strictTopActivity = getStrictTopActivity();
        if (strictTopActivity instanceof NachoFlutterActivity) {
            return (NachoFlutterActivity) strictTopActivity;
        }
        return null;
    }

    public void openNativeActivity(HashMap<String, Object> hashMap, Class cls) {
        Intent intent = new Intent(this.f21149d, cls);
        intent.putExtra("params", hashMap);
        intent.addFlags(268435456);
        this.f21149d.startActivity(intent);
    }

    public void openFlutterActivity(String str, HashMap<String, Object> hashMap, Class cls) {
        Intent intent = new Intent(this.f21149d, cls);
        intent.putExtra("url", str);
        intent.putExtra("params", hashMap);
        intent.addFlags(268435456);
        this.f21149d.startActivity(intent);
    }

    public boolean closeTopActivity(String str) {
        NachoFlutterActivity topContainer = getTopContainer();
        if (topContainer == null || !topContainer.getPageId().equals(str)) {
            return false;
        }
        topContainer.finish();
        return true;
    }
}

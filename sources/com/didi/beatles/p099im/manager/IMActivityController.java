package com.didi.beatles.p099im.manager;

import android.app.Activity;
import android.util.Log;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.didi.beatles.im.manager.IMActivityController */
public final class IMActivityController {

    /* renamed from: a */
    static boolean f9230a = Log.isLoggable("im_activity_controller", 3);

    /* renamed from: d */
    private static final String f9231d = IMActivityController.class.getSimpleName();

    /* renamed from: b */
    SoftReference<Activity> f9232b;

    /* renamed from: c */
    SoftReference<Activity> f9233c;

    /* renamed from: e */
    private ConcurrentHashMap<Integer, SoftReference<Activity>> f9234e;

    public static IMActivityController getInstance() {
        return Holder.INSTANCE;
    }

    private IMActivityController() {
        this.f9234e = new ConcurrentHashMap<>();
    }

    public void addAcitivty(Activity activity) {
        ConcurrentHashMap<Integer, SoftReference<Activity>> concurrentHashMap = this.f9234e;
        if (concurrentHashMap != null && activity != null) {
            concurrentHashMap.put(Integer.valueOf(activity.hashCode()), new SoftReference(activity));
        }
    }

    public void removeActivity(Activity activity) {
        ConcurrentHashMap<Integer, SoftReference<Activity>> concurrentHashMap = this.f9234e;
        if (concurrentHashMap != null && activity != null) {
            concurrentHashMap.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public boolean hasActivity() {
        ConcurrentHashMap<Integer, SoftReference<Activity>> concurrentHashMap = this.f9234e;
        return (concurrentHashMap == null || concurrentHashMap.size() == 0) ? false : true;
    }

    public List<Activity> getActivities() {
        ArrayList arrayList = new ArrayList();
        for (SoftReference<Activity> softReference : this.f9234e.values()) {
            arrayList.add(softReference.get());
        }
        return arrayList;
    }

    public void setTopActivity(Activity activity) {
        if (activity != null) {
            if (f9230a) {
                IMLog.m6631d(f9231d, C4234I.m6591t("NotificationService setTopActivity argu -->", activity.getClass().getSimpleName()));
            }
            this.f9233c = this.f9232b;
            SoftReference<Activity> softReference = new SoftReference<>(activity);
            this.f9232b = softReference;
            if (f9230a) {
                IMLog.m6631d(f9231d, C4234I.m6591t("NotificationService setTopActivity -->", softReference.get().getClass().getSimpleName()));
            }
        }
    }

    public void setTopActivityNull(Activity activity) {
        if (activity != null) {
            if (f9230a) {
                IMLog.m6631d(f9231d, C4234I.m6591t("NotificationService setTopActivityNull -->", activity.getClass().getSimpleName()));
            }
            if (getTopActivity() != null && getTopActivity().getClass().getSimpleName().equals(activity.getClass().getSimpleName())) {
                this.f9232b = null;
            }
        }
    }

    public Activity getTopActivity() {
        SoftReference<Activity> softReference = this.f9232b;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public Activity getSecondActivity() {
        SoftReference<Activity> softReference = this.f9233c;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void clear() {
        ConcurrentHashMap<Integer, SoftReference<Activity>> concurrentHashMap = this.f9234e;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* renamed from: com.didi.beatles.im.manager.IMActivityController$Holder */
    private static class Holder {
        /* access modifiers changed from: private */
        public static final IMActivityController INSTANCE = new IMActivityController();

        private Holder() {
        }
    }
}

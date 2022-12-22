package com.didi.sdk.app;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.didi.app.router.PageRouter;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class ActivityStack {

    /* renamed from: a */
    private static boolean f35109a = false;

    /* renamed from: b */
    private static boolean f35110b = false;

    /* renamed from: c */
    private static final List<Activity> f35111c = new ArrayList();

    /* renamed from: d */
    private static final List<Activity> f35112d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final List<OnStackChangedListener> f35113e = new ArrayList();

    /* renamed from: f */
    private static final Application.ActivityLifecycleCallbacks f35114f = new Application.ActivityLifecycleCallbacks() {
        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            ActivityStack.m24809g(activity);
        }

        public void onActivityStarted(Activity activity) {
            ActivityStack.m24810h(activity);
        }

        public void onActivityStopped(Activity activity) {
            ActivityStack.m24811i(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            Activity unused = ActivityStack.m24800b(ActivityStack.lastIndexOf(activity), false);
        }
    };

    public static abstract class OnStackChangedAdapter implements OnStackChangedListener {
        public void onAppPause() {
        }

        public void onAppResume() {
        }

        public void onPop(Activity activity) {
        }

        public void onPush(Activity activity) {
        }

        public void onStackGonnaEmpty(Activity activity) {
        }
    }

    public interface OnStackChangedListener {
        void onAppPause();

        void onAppResume();

        void onPop(Activity activity);

        void onPush(Activity activity);

        void onStackGonnaEmpty(Activity activity);
    }

    private ActivityStack() {
    }

    public static void init(Application application) {
        init(application, false);
    }

    public static void init(Application application, boolean z) {
        f35109a = z;
        application.registerActivityLifecycleCallbacks(f35114f);
    }

    public static void addStackChangedListener(OnStackChangedListener onStackChangedListener) {
        synchronized (f35113e) {
            f35113e.add(onStackChangedListener);
        }
    }

    public static void removeStackChangedListener(OnStackChangedListener onStackChangedListener) {
        synchronized (f35113e) {
            f35113e.remove(onStackChangedListener);
        }
    }

    public static void removeAllStackChangedListener() {
        synchronized (f35113e) {
            f35113e.clear();
        }
    }

    /* renamed from: d */
    private static void m24806d(final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onPush : ActivityStack.f35113e) {
                    try {
                        onPush.onPush(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private static void m24807e(final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onPop : ActivityStack.f35113e) {
                    try {
                        onPop.onPop(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: f */
    private static void m24808f(final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onStackGonnaEmpty : ActivityStack.f35113e) {
                    try {
                        onStackGonnaEmpty.onStackGonnaEmpty(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: b */
    private static void m24801b() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onAppPause : ActivityStack.f35113e) {
                    try {
                        onAppPause.onAppPause();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: c */
    private static void m24803c() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onAppResume : ActivityStack.f35113e) {
                    try {
                        onAppResume.onAppResume();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static String logStack() {
        StringBuilder sb = new StringBuilder("stack_bottom");
        for (Activity activity : f35111c) {
            sb.append("->" + activity.getClass().getSimpleName());
        }
        sb.append("->stack_head");
        m24799a("ActivityStack", sb.toString());
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static void m24809g(Activity activity) {
        synchronized (f35111c) {
            f35111c.add(activity);
            m24799a("ActivityStack", "pushInstance:" + activity.getClass().getSimpleName());
            logStack();
            m24806d(activity);
        }
    }

    /* renamed from: d */
    private static Activity m24805d() {
        return m24800b(f35111c.size() - 1, false);
    }

    public static Activity takeInstance(int i) {
        return f35111c.get(i);
    }

    public static Activity takeInstance() {
        if (f35111c.size() == 0) {
            return null;
        }
        return takeInstance(f35111c.size() - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Activity m24800b(int i, boolean z) {
        Activity remove;
        if (i == -1) {
            return null;
        }
        synchronized (f35111c) {
            try {
                remove = f35111c.remove(i);
                if (z) {
                    m24797a(i - 1);
                }
                m24799a("ActivityStack", "popInstance:" + remove.getClass().getSimpleName());
                logStack();
                m24807e(remove);
                if (size() == 0) {
                    m24808f(remove);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return remove;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m24797a(int r3) {
        /*
            java.util.List<android.app.Activity> r0 = f35111c
            monitor-enter(r0)
            if (r3 >= 0) goto L_0x0007
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x0007:
            java.util.List<android.app.Activity> r1 = f35111c     // Catch:{ all -> 0x003c }
            int r1 = r1.size()     // Catch:{ all -> 0x003c }
            if (r3 < r1) goto L_0x0017
            java.util.List<android.app.Activity> r3 = f35111c     // Catch:{ all -> 0x003c }
            int r3 = r3.size()     // Catch:{ all -> 0x003c }
            int r3 = r3 + -1
        L_0x0017:
            r1 = r3
        L_0x0018:
            if (r1 < 0) goto L_0x0028
            java.util.List<android.app.Activity> r2 = f35111c     // Catch:{ all -> 0x003c }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x003c }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ all -> 0x003c }
            r2.finish()     // Catch:{ all -> 0x003c }
            int r1 = r1 + -1
            goto L_0x0018
        L_0x0028:
            if (r3 == 0) goto L_0x0035
            java.util.List<android.app.Activity> r1 = f35111c     // Catch:{ all -> 0x003c }
            r2 = 0
            java.util.List r3 = r1.subList(r2, r3)     // Catch:{ all -> 0x003c }
            r3.clear()     // Catch:{ all -> 0x003c }
            goto L_0x003a
        L_0x0035:
            java.util.List<android.app.Activity> r3 = f35111c     // Catch:{ all -> 0x003c }
            r3.clear()     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x003c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.ActivityStack.m24797a(int):void");
    }

    public static void pop2MainActivity() {
        ActivityLifecycleManager instance = ActivityLifecycleManager.getInstance();
        if (!instance.isMainActivityOnTop()) {
            Activity currentActivity = instance.getCurrentActivity();
            Intent intent = new Intent();
            intent.addFlags(View.STATUS_BAR_TRANSIENT);
            PageRouter.getInstance().startMainActivity(currentActivity, intent);
            currentActivity.overridePendingTransition(0, 0);
        }
    }

    public static void exitApplication(boolean z) {
        synchronized (f35111c) {
            if (z) {
                try {
                    for (int size = f35111c.size() - 1; size >= 0; size--) {
                        f35111c.get(size).finish();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                for (int i = 0; i < f35111c.size(); i++) {
                    f35111c.get(i).finish();
                }
            }
            f35111c.clear();
        }
    }

    public static void exitApplication() {
        exitApplication(true);
    }

    public static int size() {
        return f35111c.size();
    }

    public static int indexOf(Activity activity) {
        return f35111c.indexOf(activity);
    }

    public static int lastIndexOf(Activity activity) {
        return f35111c.lastIndexOf(activity);
    }

    public static int indexOf(Class<? extends Activity> cls) {
        for (int i = 0; i < f35111c.size(); i++) {
            if (f35111c.get(i).getClass().equals(cls)) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(Class<? extends Activity> cls) {
        for (int size = f35111c.size() - 1; size >= 0; size--) {
            if (f35111c.get(size).getClass().equals(cls)) {
                return size;
            }
        }
        return -1;
    }

    public static int sizeOf(Class<? extends Activity> cls) {
        int i = 0;
        for (int i2 = 0; i2 < f35111c.size(); i2++) {
            if (f35111c.get(i2).getLocalClassName().equals(cls.getSimpleName())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static void m24810h(Activity activity) {
        synchronized (f35112d) {
            boolean isEmpty = f35112d.isEmpty();
            f35112d.add(activity);
            if (isEmpty) {
                m24799a("ActivityStack", "App resume");
                f35110b = false;
                m24803c();
            } else {
                m24799a("ActivityStack", "saveResume:" + activity.getClass().getSimpleName());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static void m24811i(Activity activity) {
        synchronized (f35112d) {
            f35112d.remove(activity);
            if (f35112d.isEmpty()) {
                m24799a("ActivityStack", "App pause");
                f35110b = true;
                m24801b();
            } else {
                m24799a("ActivityStack", "removeResume:" + activity.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    private static void m24799a(String str, String str2) {
        if (f35109a) {
            SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.sdk.app.ActivityStack", 516);
        }
    }

    public static boolean isBackground() {
        return f35110b;
    }
}

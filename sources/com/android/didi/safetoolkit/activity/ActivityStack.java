package com.android.didi.safetoolkit.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class ActivityStack {
    private static final List<Activity> INSTANCE_STACK = new ArrayList();
    private static final Application.ActivityLifecycleCallbacks LIFECYCLE_CALLBACKS = new Application.ActivityLifecycleCallbacks() {
        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            ActivityStack.pushInstance(activity);
        }

        public void onActivityStarted(Activity activity) {
            ActivityStack.saveResume(activity);
        }

        public void onActivityStopped(Activity activity) {
            ActivityStack.removeResume(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            Activity unused = ActivityStack.popInstance(ActivityStack.lastIndexOf(activity), false);
        }
    };
    /* access modifiers changed from: private */
    public static final List<OnStackChangedListener> LISTENERS = new ArrayList();
    private static final List<Activity> RESUME_LIST = new ArrayList();
    private static boolean isBackground = false;
    private static boolean isDebug;

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
        isDebug = z;
        application.registerActivityLifecycleCallbacks(LIFECYCLE_CALLBACKS);
    }

    public static void addStackChangedListener(OnStackChangedListener onStackChangedListener) {
        synchronized (LISTENERS) {
            LISTENERS.add(onStackChangedListener);
        }
    }

    public static void removeStackChangedListener(OnStackChangedListener onStackChangedListener) {
        synchronized (LISTENERS) {
            LISTENERS.remove(onStackChangedListener);
        }
    }

    public static void removeAllStackChangedListener() {
        synchronized (LISTENERS) {
            LISTENERS.clear();
        }
    }

    private static void notifyPushListener(final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onPush : ActivityStack.LISTENERS) {
                    try {
                        onPush.onPush(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static void notifyPopListener(final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onPop : ActivityStack.LISTENERS) {
                    try {
                        onPop.onPop(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static void notifyGonnaEmptyListener(final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onStackGonnaEmpty : ActivityStack.LISTENERS) {
                    try {
                        onStackGonnaEmpty.onStackGonnaEmpty(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static void notifyAppPause() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onAppPause : ActivityStack.LISTENERS) {
                    try {
                        onAppPause.onAppPause();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static void notifyAppResume() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onAppResume : ActivityStack.LISTENERS) {
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
        for (Activity activity : INSTANCE_STACK) {
            sb.append("->" + activity.getClass().getSimpleName());
        }
        sb.append("->stack_head");
        logI("ActivityStack", sb.toString());
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static void pushInstance(Activity activity) {
        synchronized (INSTANCE_STACK) {
            INSTANCE_STACK.add(activity);
            logI("ActivityStack", "pushInstance:" + activity.getClass().getSimpleName());
            logStack();
            notifyPushListener(activity);
        }
    }

    private static Activity popInstance() {
        return popInstance(INSTANCE_STACK.size() - 1, false);
    }

    public static Activity takeInstance(int i) {
        return INSTANCE_STACK.get(i);
    }

    public static Activity takeInstance() {
        return takeInstance(INSTANCE_STACK.size() - 1);
    }

    /* access modifiers changed from: private */
    public static Activity popInstance(int i, boolean z) {
        Activity remove;
        if (i == -1) {
            return null;
        }
        synchronized (INSTANCE_STACK) {
            try {
                remove = INSTANCE_STACK.remove(i);
                if (z) {
                    clearUpByIndex(i - 1);
                }
                logI("ActivityStack", "popInstance:" + remove.getClass().getSimpleName());
                logStack();
                notifyPopListener(remove);
                if (size() == 0) {
                    notifyGonnaEmptyListener(remove);
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
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void clearUpByIndex(int r3) {
        /*
            java.util.List<android.app.Activity> r0 = INSTANCE_STACK
            monitor-enter(r0)
            if (r3 >= 0) goto L_0x0007
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x0007:
            java.util.List<android.app.Activity> r1 = INSTANCE_STACK     // Catch:{ all -> 0x003c }
            int r1 = r1.size()     // Catch:{ all -> 0x003c }
            if (r3 < r1) goto L_0x0017
            java.util.List<android.app.Activity> r3 = INSTANCE_STACK     // Catch:{ all -> 0x003c }
            int r3 = r3.size()     // Catch:{ all -> 0x003c }
            int r3 = r3 + -1
        L_0x0017:
            r1 = r3
        L_0x0018:
            if (r1 < 0) goto L_0x0028
            java.util.List<android.app.Activity> r2 = INSTANCE_STACK     // Catch:{ all -> 0x003c }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x003c }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ all -> 0x003c }
            r2.finish()     // Catch:{ all -> 0x003c }
            int r1 = r1 + -1
            goto L_0x0018
        L_0x0028:
            if (r3 == 0) goto L_0x0035
            java.util.List<android.app.Activity> r1 = INSTANCE_STACK     // Catch:{ all -> 0x003c }
            r2 = 0
            java.util.List r3 = r1.subList(r2, r3)     // Catch:{ all -> 0x003c }
            r3.clear()     // Catch:{ all -> 0x003c }
            goto L_0x003a
        L_0x0035:
            java.util.List<android.app.Activity> r3 = INSTANCE_STACK     // Catch:{ all -> 0x003c }
            r3.clear()     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x003c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.didi.safetoolkit.activity.ActivityStack.clearUpByIndex(int):void");
    }

    public static void exitApplication(boolean z) {
        synchronized (INSTANCE_STACK) {
            if (z) {
                try {
                    for (int size = INSTANCE_STACK.size() - 1; size >= 0; size--) {
                        INSTANCE_STACK.get(size).finish();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                for (int i = 0; i < INSTANCE_STACK.size(); i++) {
                    INSTANCE_STACK.get(i).finish();
                }
            }
            INSTANCE_STACK.clear();
        }
    }

    public static void exitApplication() {
        exitApplication(true);
    }

    public static int size() {
        return INSTANCE_STACK.size();
    }

    public static int indexOf(Activity activity) {
        return INSTANCE_STACK.indexOf(activity);
    }

    public static int lastIndexOf(Activity activity) {
        return INSTANCE_STACK.lastIndexOf(activity);
    }

    public static int indexOf(Class<? extends Activity> cls) {
        for (int i = 0; i < INSTANCE_STACK.size(); i++) {
            if (INSTANCE_STACK.get(i).getClass().equals(cls)) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(Class<? extends Activity> cls) {
        for (int size = INSTANCE_STACK.size() - 1; size >= 0; size--) {
            if (INSTANCE_STACK.get(size).getClass().equals(cls)) {
                return size;
            }
        }
        return -1;
    }

    public static int sizeOf(Class<? extends Activity> cls) {
        int i = 0;
        for (int i2 = 0; i2 < INSTANCE_STACK.size(); i2++) {
            if (INSTANCE_STACK.get(i2).getLocalClassName().equals(cls.getSimpleName())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static void saveResume(Activity activity) {
        synchronized (RESUME_LIST) {
            boolean isEmpty = RESUME_LIST.isEmpty();
            RESUME_LIST.add(activity);
            if (isEmpty) {
                logI("ActivityStack", "App resume");
                isBackground = false;
                notifyAppResume();
            } else {
                logI("ActivityStack", "saveResume:" + activity.getClass().getSimpleName());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void removeResume(Activity activity) {
        synchronized (RESUME_LIST) {
            RESUME_LIST.remove(activity);
            if (RESUME_LIST.isEmpty()) {
                logI("ActivityStack", "App pause");
                isBackground = true;
                notifyAppPause();
            } else {
                logI("ActivityStack", "removeResume:" + activity.getClass().getSimpleName());
            }
        }
    }

    private static void logI(String str, String str2) {
        if (isDebug) {
            SystemUtils.log(4, str, str2, (Throwable) null, "com.android.didi.safetoolkit.activity.ActivityStack", 499);
        }
    }

    public static boolean isBackground() {
        return isBackground;
    }
}

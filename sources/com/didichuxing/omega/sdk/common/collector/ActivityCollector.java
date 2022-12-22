package com.didichuxing.omega.sdk.common.collector;

import android.app.Activity;
import android.os.Bundle;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.ActivityLifecycleRegister;
import com.didichuxing.omega.sdk.common.utils.BoundedLinkedQueue;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;

public class ActivityCollector {
    private static BoundedLinkedQueue<ActivityKeeper> mActivityQueue = new BoundedLinkedQueue<>(OmegaConfig.ACTIVITY_QUEUE_MAX_LEN);

    public static byte[] getScreenshot() {
        return new byte[0];
    }

    public static void init() {
        ActivityLifecycleRegister.addActivityLifecycleListener(new ActivityLifecycleRegister.ActivityLifecycleListener() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
                ActivityCollector.whenActivityResumed(activity);
            }

            public void onActivityPaused(Activity activity) {
                ActivityCollector.whenActivityPaused(activity);
            }
        });
    }

    public static void whenActivityResumed(Activity activity) {
        ActivityKeeper activityKeeper = new ActivityKeeper(activity);
        activityKeeper.indate = new Date();
        mActivityQueue.add(activityKeeper);
    }

    public static void whenActivityPaused(Activity activity) {
        Iterator descendingIterator = mActivityQueue.descendingIterator();
        ActivityKeeper activityKeeper = null;
        while (descendingIterator.hasNext()) {
            ActivityKeeper activityKeeper2 = (ActivityKeeper) descendingIterator.next();
            if (activityKeeper2.outdate != null) {
                break;
            }
            activityKeeper = activityKeeper2;
        }
        if (activityKeeper != null && activityKeeper.get() != null) {
            activityKeeper.outdate = new Date();
        }
    }

    public static String getCurActivityPage() {
        ActivityKeeper last = mActivityQueue.getLast();
        return (last == null || last.get() == null) ? "" : last.f48476pn;
    }

    public static String getActivityHistory() {
        StringBuilder sb = new StringBuilder();
        Iterator it = mActivityQueue.iterator();
        while (it.hasNext()) {
            ActivityKeeper activityKeeper = (ActivityKeeper) it.next();
            if (activityKeeper != null) {
                sb.append(activityKeeper.f48476pn);
                sb.append(" ● ");
                sb.append(CommonUtil.time2Human(activityKeeper.indate));
                sb.append(" ➜ ");
                if (activityKeeper.outdate == null) {
                    sb.append("... ✘\n");
                } else {
                    sb.append(CommonUtil.time2Human(activityKeeper.outdate));
                    sb.append(" ✔\n");
                }
            }
        }
        return sb.toString();
    }

    static class ActivityKeeper extends WeakReference<Activity> {
        Date indate;
        Date outdate;

        /* renamed from: pn */
        String f48476pn;

        ActivityKeeper(Activity activity) {
            super(activity);
            this.f48476pn = CommonUtil.simplifyClassName(activity.getClass().getName());
        }
    }
}

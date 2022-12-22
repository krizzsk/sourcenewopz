package com.didichuxing.mas.sdk.quality.report.collector;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didichuxing.mas.sdk.quality.report.MASCallback;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.backend.ActivityLifecycleRegister;
import com.didichuxing.mas.sdk.quality.report.customevent.CustomEventMap;
import com.didichuxing.mas.sdk.quality.report.utils.BoundedLinkedQueue;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;

public class ActivityCollector {
    public static final String MAS_CUSTOM_EVENT_ACTIVITY_HISTORY_KEY = "activity_history";
    public static final String MAS_CUSTOM_EVENT_ACTIVITY_KEY = "activity";
    public static final String MAS_CUSTOM_EVENT_FRAGMENT_HISTORY_KEY = "fragment_history";
    public static final String MAS_CUSTOM_EVENT_FRAGMENT_KEY = "fragment";
    public static volatile Activity currentActivity;
    private static BoundedLinkedQueue<ActivityKeeper> mActivityQueue = new BoundedLinkedQueue<>(MASConfig.ACTIVITY_QUEUE_MAX_LEN);

    public static byte[] getScreenshot() {
        return new byte[0];
    }

    public static void init() {
        ActivityLifecycleRegister.addActivityLifecycleListener(new ActivityLifecycleRegister.ActivityLifecycleListener() {
            public void onActivityStarted(Activity activity) {
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof FragmentActivity) {
                    OLog.m34420i("ActivityCollector onActivityCreated: " + activity.getClass().getName());
                    ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
                        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
                            super.onFragmentCreated(fragmentManager, fragment, bundle);
                            String name = fragment.getClass().getName();
                            OLog.m34420i("ActivityCollector onActivityCreated onFragmentCreated: " + name);
                            if (!ActivityCollector.isFilter(name)) {
                                MASConfig.addCustomEvent(CustomEventMap.PUB_BIZ, "fragment", name, false);
                                MASConfig.addCustomEvent(CustomEventMap.PUB_BIZ, ActivityCollector.MAS_CUSTOM_EVENT_FRAGMENT_HISTORY_KEY, name, true);
                            }
                        }
                    }, true);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                ActivityCollector.currentActivity = null;
            }

            public void onActivityStopped(Activity activity) {
                AnalysisDelegater.setAppAtFront(false);
            }

            public void onActivityResumed(Activity activity) {
                ActivityCollector.whenActivityResumed(activity);
            }

            public void onActivityPaused(Activity activity) {
                ActivityCollector.whenActivityPaused(activity);
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean isFilter(String str) {
        return !TextUtils.isEmpty(str) && str.equals("com.bumptech.glide.manager.SupportRequestManagerFragment");
    }

    public static void whenActivityResumed(Activity activity) {
        String name = activity.getClass().getName();
        MASConfig.addCustomEvent(CustomEventMap.PUB_BIZ, "activity", name, false);
        MASConfig.addCustomEvent(CustomEventMap.PUB_BIZ, MAS_CUSTOM_EVENT_ACTIVITY_HISTORY_KEY, name, true);
        ActivityKeeper activityKeeper = new ActivityKeeper(activity);
        activityKeeper.indate = new Date();
        mActivityQueue.add(activityKeeper);
        AnalysisDelegater.setAppAtFront(true);
        currentActivity = activity;
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
        return (last == null || last.get() == null) ? "" : PageCollector.desensitizationString(last.f48286pn);
    }

    public static String getCurPage() {
        String str;
        if (MASCallback.iCurrentPageListener == null) {
            return getCurActivityPage();
        }
        try {
            str = MASCallback.iCurrentPageListener.getCurActivityPage(getCurActivityPage());
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        return TextUtils.isEmpty(str) ? getCurActivityPage() : str;
    }

    public static String getActivityHistory() {
        StringBuilder sb = new StringBuilder();
        Iterator it = mActivityQueue.iterator();
        while (it.hasNext()) {
            ActivityKeeper activityKeeper = (ActivityKeeper) it.next();
            if (activityKeeper != null) {
                sb.append(PageCollector.desensitizationString(activityKeeper.f48286pn));
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
        String f48286pn;

        ActivityKeeper(Activity activity) {
            super(activity);
            this.f48286pn = CommonUtil.simplifyClassName(activity.getClass().getName());
        }
    }
}

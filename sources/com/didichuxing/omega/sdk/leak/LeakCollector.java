package com.didichuxing.omega.sdk.leak;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeakCollector {
    public static int MAX_GC_TIMES = 20;
    public static int MAX_UPPER_COUNT_BY_DAY = 10;
    public static int MAX_WATCH_TIME = 30000;
    public static int WAIT_GC_SLEEP_TIME = 500;
    private static final String sLeakEventID = "omega_leakcanary_object_leaked";
    private static final String sLeakEventObjectNameKey = "leaked_object_name";
    public Map<String, LeakRef> mRefMap = new HashMap();

    public void add(KeyedWeakReference keyedWeakReference, long j, long j2) {
        if (!this.mRefMap.containsKey(keyedWeakReference.key)) {
            LeakRef leakRef = new LeakRef(keyedWeakReference);
            leakRef.startWatchTime = j;
            this.mRefMap.put(keyedWeakReference.key, leakRef);
        }
    }

    public boolean hasRetainedRef() {
        Map<String, LeakRef> map = this.mRefMap;
        return (map == null || map.size() == 0) ? false : true;
    }

    public void onGCRan(long j) {
        if (hasRetainedRef()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : this.mRefMap.entrySet()) {
                if (reportIfNeed((LeakRef) next.getValue(), j)) {
                    arrayList.add(next.getKey());
                }
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.mRefMap.remove((String) it.next());
                }
            }
        }
    }

    private boolean reportIfNeed(LeakRef leakRef, long j) {
        if (leakRef == null) {
            return false;
        }
        leakRef.curGCTimes = (byte) (leakRef.curGCTimes + 1);
        leakRef.lastGCTime = j;
        if (leakRef.isLeak()) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(leakRef.getName())) {
                hashMap.put(sLeakEventObjectNameKey, leakRef.getName());
            }
            if (!CommonUtil.isUpperLimitByDay("upper_limit_obj_leaked_event_key", MAX_UPPER_COUNT_BY_DAY)) {
                CommonUtil.addUpperLimitByDay("upper_limit_obj_leaked_event_key");
                Tracker.trackEvent(sLeakEventID, leakRef.getName(), hashMap);
            }
            System.out.println(hashMap);
            return true;
        } else if (leakRef.get() == null) {
            return true;
        } else {
            return false;
        }
    }
}

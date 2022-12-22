package com.didi.sdk.push;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EventTracker {
    private static final String APOLLO_KEY_LIST = "l";
    private static final String APOLLO_KEY_PUSH_EVENT_REPORT = "push_omg_event_report";
    private static final String TAG = "PushEventTracker";
    private boolean mAllow;
    private HashMap<String, Float> mRateMap;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static EventTracker INSTANCE = new EventTracker();

        private SingletonHolder() {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|15|16|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0075 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private EventTracker() {
        /*
            r8 = this;
            r8.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r8.mRateMap = r0
            java.lang.String r0 = "push_omg_event_report"
            r1 = 0
            com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0, r1)
            boolean r2 = r0.allow()
            r8.mAllow = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "push event tracker enabled ? "
            r2.append(r3)
            boolean r3 = r8.mAllow
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "PushEventTracker"
            com.didi.sdk.push.PushLog.m26280d(r3, r2)
            boolean r2 = r8.mAllow
            if (r2 == 0) goto L_0x0081
            com.didichuxing.apollo.sdk.IExperiment r0 = r0.getExperiment()
            java.lang.String r2 = "l"
            java.lang.String r3 = ""
            java.lang.Object r0 = r0.getParam(r2, r3)
            java.lang.String r0 = (java.lang.String) r0
            java.util.HashMap<java.lang.String, java.lang.Float> r2 = r8.mRateMap     // Catch:{ JSONException -> 0x0081 }
            r2.clear()     // Catch:{ JSONException -> 0x0081 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0081 }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r0 = "events"
            org.json.JSONArray r0 = r2.optJSONArray(r0)     // Catch:{ JSONException -> 0x0081 }
            if (r0 == 0) goto L_0x0081
            r2 = 0
        L_0x0056:
            int r4 = r0.length()     // Catch:{ JSONException -> 0x0081 }
            if (r2 >= r4) goto L_0x0081
            java.lang.String r4 = r0.optString(r2, r3)     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r5 = ","
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ JSONException -> 0x0081 }
            int r5 = r4.length     // Catch:{ JSONException -> 0x0081 }
            r6 = 2
            if (r5 < r6) goto L_0x007e
            r5 = r4[r1]     // Catch:{ JSONException -> 0x0081 }
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 1
            r4 = r4[r7]     // Catch:{ NumberFormatException -> 0x0075 }
            float r6 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x0075 }
        L_0x0075:
            java.util.HashMap<java.lang.String, java.lang.Float> r4 = r8.mRateMap     // Catch:{ JSONException -> 0x0081 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ JSONException -> 0x0081 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0081 }
        L_0x007e:
            int r2 = r2 + 1
            goto L_0x0056
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.push.EventTracker.<init>():void");
    }

    private boolean hitProbability(float f) {
        return new Random().nextFloat() < f;
    }

    static EventTracker getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public void trackEvent(String str, Map<String, Object> map) {
        Float f;
        PushLog.m26280d(TAG, "trackEvent : " + str + ", mAllow:" + this.mAllow + ", rate:" + this.mRateMap.get(str));
        if (!this.mAllow || (f = this.mRateMap.get(str)) == null || hitProbability(f.floatValue())) {
            PushLog.m26280d(TAG, "OmegaSDK.trackEvent : " + str);
            OmegaSDKAdapter.trackEvent(str, map);
        }
    }
}

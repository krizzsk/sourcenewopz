package com.didi.map.global.model.omega;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

public class AlarmOmegaUtil {

    /* renamed from: a */
    private static String f27338a = "tech_global_car_navigator_error";

    /* renamed from: b */
    private static String f27339b = "tech_global_routeplan_error";

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderTrajParamError {
        public static final int DRIVER_ID = 2;
        public static final int PRODUCT_ID = 1;
        public static final int TOKEN = 3;
    }

    /* renamed from: a */
    private static boolean m19308a(String str) {
        IExperiment experiment;
        String str2;
        IToggle toggle = Apollo.getToggle("global_bi_alarm_passenger_upload");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || (str2 = (String) experiment.getParam("android_event_name", "")) == null || str2.isEmpty()) {
            return false;
        }
        return str2.contains(str);
    }

    public static void multiCarNavigatorAlarmOmega(LatLng latLng, String str, int i, String str2, int i2, int i3, String str3) {
        String str4;
        if (m19308a(f27338a)) {
            try {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                if (!LatLngUtils.locateCorrect(latLng)) {
                    if (latLng != null) {
                        str4 = latLng.toString();
                    } else {
                        str4 = "";
                    }
                    sb.append(Const.joLeft);
                    sb.append("lat/lng");
                    sb.append(str4);
                    sb.append("}");
                }
                if (TextUtils.isEmpty(str)) {
                    sb.append(Const.joLeft);
                    sb.append("productId");
                    sb.append("}");
                }
                if (i <= 0) {
                    sb.append(Const.joLeft);
                    sb.append("radius");
                    sb.append("}");
                }
                if (TextUtils.isEmpty(str2)) {
                    sb.append(Const.joLeft);
                    sb.append("phone_num");
                    sb.append("}");
                }
                if (!sb.toString().isEmpty()) {
                    hashMap.put("error_field", sb.toString());
                    hashMap.put("type", 1);
                }
                if (i2 != 0 || i3 < 0) {
                    hashMap.put("errno", Integer.valueOf(i2));
                    hashMap.put("eta_data_error", Integer.valueOf(i3));
                    hashMap.put("traceid", "" + str3);
                    hashMap.put("type", 1);
                }
                if (!hashMap.isEmpty()) {
                    GlobalOmegaTracker.trackEvent(f27338a, hashMap);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void singleCarNavigatorAlarmOmega(String str, String str2, String str3, int i, int i2, String str4) {
        if (m19308a(f27338a)) {
            try {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                if (TextUtils.isEmpty(str)) {
                    sb.append(Const.joLeft);
                    sb.append("productId");
                    sb.append("}");
                }
                if (TextUtils.isEmpty(str3)) {
                    sb.append(Const.joLeft);
                    sb.append("phone_num");
                    sb.append("}");
                }
                if (TextUtils.isEmpty(str2)) {
                    sb.append(Const.joLeft);
                    sb.append("driverids");
                    sb.append("}");
                }
                if (!sb.toString().isEmpty()) {
                    hashMap.put("error_field", sb.toString());
                    hashMap.put("type", 2);
                }
                if (i != 0 || i2 < 0) {
                    hashMap.put("errno", Integer.valueOf(i));
                    hashMap.put("traceid", "" + str4);
                    hashMap.put("type", 2);
                }
                if (!hashMap.isEmpty()) {
                    GlobalOmegaTracker.trackEvent(f27338a, hashMap);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void routePlanAlarmOmega(java.lang.String r4, java.lang.String r5, java.lang.String r6, com.didi.common.map.model.LatLng r7, com.didi.common.map.model.LatLng r8, com.didi.map.sdk.proto.driver_gl.RoutePlanRes r9, int r10, java.lang.String r11) {
        /*
            java.lang.String r0 = f27338a
            boolean r0 = m19308a(r0)
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            java.lang.String r2 = "}"
            java.lang.String r3 = "{"
            if (r4 == 0) goto L_0x0028
            r1.append(r3)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            java.lang.String r4 = "productId"
            r1.append(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            r1.append(r2)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
        L_0x0028:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            if (r4 == 0) goto L_0x0039
            r1.append(r3)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            java.lang.String r4 = "caller"
            r1.append(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            r1.append(r2)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
        L_0x0039:
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            if (r4 == 0) goto L_0x004a
            r1.append(r3)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            java.lang.String r4 = "token"
            r1.append(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            r1.append(r2)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
        L_0x004a:
            boolean r4 = com.didi.common.map.util.LatLngUtils.locateCorrect(r7)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            java.lang.String r5 = ""
            if (r4 != 0) goto L_0x0068
            if (r7 == 0) goto L_0x0059
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            goto L_0x005a
        L_0x0059:
            r4 = r5
        L_0x005a:
            r1.append(r3)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            java.lang.String r6 = "start="
            r1.append(r6)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            r1.append(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            r1.append(r2)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
        L_0x0068:
            boolean r4 = com.didi.common.map.util.LatLngUtils.locateCorrect(r8)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            if (r4 != 0) goto L_0x0082
            if (r8 == 0) goto L_0x0074
            java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
        L_0x0074:
            r1.append(r3)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            java.lang.String r4 = "end="
            r1.append(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            r1.append(r5)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            r1.append(r2)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
        L_0x0082:
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            if (r4 != 0) goto L_0x0091
            java.lang.String r4 = "error_field"
            r0.put(r4, r1)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
        L_0x0091:
            r4 = 1
            if (r9 == 0) goto L_0x00a3
            java.util.List<com.didi.map.sdk.proto.driver_gl.DiffGeoPoints> r5 = r9.routeGeos     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            if (r5 == 0) goto L_0x00a3
            java.util.List<com.didi.map.sdk.proto.driver_gl.DiffGeoPoints> r5 = r9.routeGeos     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            boolean r5 = r5.isEmpty()     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            if (r5 == 0) goto L_0x00a1
            goto L_0x00a3
        L_0x00a1:
            r5 = 0
            goto L_0x00a4
        L_0x00a3:
            r5 = 1
        L_0x00a4:
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            if (r6 == 0) goto L_0x00b2
            if (r10 != 0) goto L_0x00b2
            if (r5 == 0) goto L_0x00c9
        L_0x00b2:
            java.lang.String r5 = "errno"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            r0.put(r5, r6)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            java.lang.String r5 = "traceid"
            r0.put(r5, r11)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            java.lang.String r5 = "empty_data"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
            r0.put(r5, r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d0 }
        L_0x00c9:
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x00e9
            goto L_0x00e4
        L_0x00d0:
            r4 = move-exception
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x00dc
            java.lang.String r5 = f27339b
            com.didi.map.global.model.omega.GlobalOmegaTracker.trackEvent(r5, r0)
        L_0x00dc:
            throw r4
        L_0x00dd:
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x00e9
        L_0x00e4:
            java.lang.String r4 = f27339b
            com.didi.map.global.model.omega.GlobalOmegaTracker.trackEvent(r4, r0)
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.model.omega.AlarmOmegaUtil.routePlanAlarmOmega(java.lang.String, java.lang.String, java.lang.String, com.didi.common.map.model.LatLng, com.didi.common.map.model.LatLng, com.didi.map.sdk.proto.driver_gl.RoutePlanRes, int, java.lang.String):void");
    }

    public static void trackOrderTrajParamError(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_field", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("tech_global_ordertraj_error", (Map<String, Object>) hashMap);
    }

    public static void trackOrderTrajResultError(int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("errno", Integer.valueOf(i));
        hashMap.put("logid", Long.valueOf(j));
        OmegaSDKAdapter.trackEvent("tech_global_ordertraj_error", (Map<String, Object>) hashMap);
    }
}

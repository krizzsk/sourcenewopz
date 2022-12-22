package com.sdk.poibase;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class AlarmOmegaUtil {

    /* renamed from: a */
    private static String f55987a = "tech_global_reversegeo_error";

    /* renamed from: b */
    private static String f55988b = "tech_global_poiinfo_error";

    /* renamed from: c */
    private static String f55989c = "tech_global_recommend_error";

    /* renamed from: d */
    private static String f55990d = "tech_global_textsearch_error";

    /* renamed from: e */
    private static String f55991e = "tech_global_andriod_poiinfo_error";

    /* renamed from: f */
    private static String f55992f = "tech_global_geocode_error";

    /* renamed from: a */
    private static boolean m40317a(String str) {
        IExperiment experiment;
        String str2;
        IToggle toggle = Apollo.getToggle("global_bi_alarm_passenger_upload");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || (str2 = (String) experiment.getParam("android_event_name", "")) == null || str2.isEmpty()) {
            return false;
        }
        return str2.contains(str);
    }

    public static void reverseGeoAlarmOmega(LatLng latLng, ArrayList<RpcPoi> arrayList, int i, String str) {
        if (m40317a(f55987a)) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            try {
                if (!LatLngUtils.locateCorrect(latLng)) {
                    sb.append(Const.joLeft);
                    sb.append("user_loc_lai");
                    sb.append(",");
                    sb.append("user_loc_lng");
                    sb.append("}");
                }
                if (!sb.toString().isEmpty()) {
                    hashMap.put("error_field", sb);
                }
                int a = m40314a(arrayList);
                if (!(sb.toString().isEmpty() && i == 0 && a == 0)) {
                    hashMap.put("errno", Integer.valueOf(i));
                    hashMap.put("traceid", str);
                    hashMap.put("poi_error_type", Integer.valueOf(a));
                }
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Exception unused) {
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Throwable th) {
                if (!hashMap.isEmpty()) {
                    GlobalOmegaTracker.trackEvent(f55987a, hashMap);
                }
                throw th;
            }
            GlobalOmegaTracker.trackEvent(f55987a, hashMap);
        }
    }

    public static void poiInfoAlarmOmega(LatLng latLng, LatLng latLng2, String str, int i, String str2) {
        if (m40317a(f55988b)) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            try {
                if (!LatLngUtils.locateCorrect(latLng)) {
                    sb.append(Const.joLeft);
                    sb.append("user_loc_lai");
                    sb.append(",");
                    sb.append("user_loc_lng");
                    sb.append("}");
                }
                if (!LatLngUtils.locateCorrect(latLng2)) {
                    sb.append(Const.joLeft);
                    sb.append("select_lng");
                    sb.append(",");
                    sb.append("select_lat");
                    sb.append("}");
                }
                if (str == null || str.isEmpty()) {
                    sb.append(Const.joLeft);
                    sb.append(CarServerParam.PARAM_CALL_FROM);
                    sb.append("}");
                }
                if (!sb.toString().isEmpty()) {
                    hashMap.put("error_field", sb);
                }
                hashMap.putAll(m40315a(sb.toString(), i, str2));
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Exception unused) {
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Throwable th) {
                if (!hashMap.isEmpty()) {
                    GlobalOmegaTracker.trackEvent(f55988b, hashMap);
                }
                throw th;
            }
            GlobalOmegaTracker.trackEvent(f55988b, hashMap);
        }
    }

    public static void recommendAlarmOmega(LatLng latLng, LatLng latLng2, int i, int i2, String str, int i3, String str2) {
        if (m40317a(f55989c)) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            try {
                if (!LatLngUtils.locateCorrect(latLng)) {
                    sb.append(Const.joLeft);
                    sb.append("user_loc_lai");
                    sb.append(",");
                    sb.append("user_loc_lng");
                    sb.append("}");
                }
                if (!LatLngUtils.locateCorrect(latLng2)) {
                    sb.append(Const.joLeft);
                    sb.append("select_lng");
                    sb.append(",");
                    sb.append("select_lat");
                    sb.append("}");
                }
                if (i <= 0) {
                    sb.append(Const.joLeft);
                    sb.append("city_id");
                    sb.append("}");
                }
                if (str == null || str.isEmpty()) {
                    sb.append(Const.joLeft);
                    sb.append("departure_time");
                    sb.append("}");
                }
                if (i2 <= 0) {
                    sb.append(Const.joLeft);
                    sb.append("place_type");
                    sb.append("}");
                }
                if (!sb.toString().isEmpty()) {
                    hashMap.put("error_field", sb);
                }
                hashMap.putAll(m40315a(sb.toString(), i3, str2));
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Exception unused) {
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Throwable th) {
                if (!hashMap.isEmpty()) {
                    GlobalOmegaTracker.trackEvent(f55989c, hashMap);
                }
                throw th;
            }
            GlobalOmegaTracker.trackEvent(f55989c, hashMap);
        }
    }

    public static void textSearchAlarmOmega(LatLng latLng, LatLng latLng2, String str, int i, int i2, String str2) {
        if (m40317a(f55990d)) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            try {
                if (!LatLngUtils.locateCorrect(latLng)) {
                    sb.append(Const.joLeft);
                    sb.append("user_loc_lai");
                    sb.append(",");
                    sb.append("user_loc_lng");
                    sb.append("}");
                }
                if (!LatLngUtils.locateCorrect(latLng2)) {
                    sb.append(Const.joLeft);
                    sb.append("select_lng");
                    sb.append(",");
                    sb.append("select_lat");
                    sb.append("}");
                }
                if (str == null || str.isEmpty()) {
                    sb.append(Const.joLeft);
                    sb.append("query");
                    sb.append("}");
                }
                if (i <= 0) {
                    sb.append(Const.joLeft);
                    sb.append("place_type");
                    sb.append("}");
                }
                if (!sb.toString().isEmpty()) {
                    hashMap.put("error_field", sb);
                }
                hashMap.putAll(m40315a(sb.toString(), i2, str2));
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Exception unused) {
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Throwable th) {
                if (!hashMap.isEmpty()) {
                    GlobalOmegaTracker.trackEvent(f55990d, hashMap);
                }
                throw th;
            }
            GlobalOmegaTracker.trackEvent(f55990d, hashMap);
        }
    }

    public static void geoCodeAlarmOmega(String str, String str2, ArrayList<RpcPoi> arrayList, int i, String str3) {
        if (m40317a(f55987a)) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            try {
                if (TextUtils.isEmpty(str)) {
                    sb.append(Const.joLeft);
                    sb.append("poi_id");
                    sb.append("}");
                }
                if (TextUtils.isEmpty(str2)) {
                    sb.append(Const.joLeft);
                    sb.append("display_name");
                    sb.append("}");
                }
                if (!sb.toString().isEmpty()) {
                    hashMap.put("error_field", sb);
                }
                int a = m40314a(arrayList);
                if (!(sb.toString().isEmpty() && i == 0 && a == 0)) {
                    hashMap.put("errno", Integer.valueOf(i));
                    hashMap.put("traceid", str3);
                    hashMap.put("poi_error_type", Integer.valueOf(a));
                }
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Exception unused) {
                if (hashMap.isEmpty()) {
                    return;
                }
            } catch (Throwable th) {
                if (!hashMap.isEmpty()) {
                    GlobalOmegaTracker.trackEvent(f55992f, hashMap);
                }
                throw th;
            }
            GlobalOmegaTracker.trackEvent(f55992f, hashMap);
        }
    }

    /* renamed from: a */
    private static HashMap<String, Object> m40315a(String str, int i, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!str.isEmpty() || i != 0) {
            hashMap.put("errno", Integer.valueOf(i));
            hashMap.put("traceid", str2);
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049 A[Catch:{ Exception -> 0x0079, all -> 0x0075 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0093 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void checkPoiResponseIsValid(com.sdk.poibase.model.poi.ReverseStationsInfo r7, java.lang.String r8) {
        /*
            java.lang.String r0 = f55987a
            boolean r0 = m40317a((java.lang.String) r0)
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r0 = ""
            r1 = 1
            r2 = 0
            if (r7 != 0) goto L_0x0012
            r7 = 0
            r3 = 1
            goto L_0x005b
        L_0x0012:
            java.util.ArrayList<com.sdk.poibase.model.RpcPoi> r3 = r7.result     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            if (r8 == 0) goto L_0x0028
            com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.GLOBAL_HOMEPAGE_STATION     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            if (r8 == r4) goto L_0x0026
            com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.GLOBAL_BUBBLEPAGE_STATION     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            if (r8 != r4) goto L_0x0028
        L_0x0026:
            r8 = 1
            goto L_0x0029
        L_0x0028:
            r8 = 0
        L_0x0029:
            if (r8 != 0) goto L_0x0046
            if (r3 == 0) goto L_0x0044
            boolean r8 = r3.isEmpty()     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            if (r8 != 0) goto L_0x0044
            java.lang.Object r8 = r3.get(r2)     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            if (r8 == 0) goto L_0x0044
            java.lang.Object r8 = r3.get(r2)     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            com.sdk.poibase.model.RpcPoi r8 = (com.sdk.poibase.model.RpcPoi) r8     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            com.sdk.poibase.model.RpcPoiBaseInfo r8 = r8.base_info     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            if (r8 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r8 = 0
            goto L_0x0047
        L_0x0046:
            r8 = 1
        L_0x0047:
            if (r8 == 0) goto L_0x004f
            int r8 = m40314a((java.util.ArrayList<com.sdk.poibase.model.RpcPoi>) r3)     // Catch:{ Exception -> 0x0079, all -> 0x0075 }
            r3 = 0
            goto L_0x0051
        L_0x004f:
            r8 = 0
            r3 = 1
        L_0x0051:
            java.util.ArrayList<com.sdk.poibase.model.RpcPoi> r4 = r7.recStartPoints     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            int r2 = m40314a((java.util.ArrayList<com.sdk.poibase.model.RpcPoi>) r4)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            java.lang.String r0 = r7.searchId     // Catch:{ Exception -> 0x006a, all -> 0x0065 }
            r7 = r2
            r2 = r8
        L_0x005b:
            if (r3 == r1) goto L_0x0061
            if (r2 != 0) goto L_0x0061
            if (r7 == 0) goto L_0x009a
        L_0x0061:
            m40316a(r3, r2, r7, r0)
            goto L_0x009a
        L_0x0065:
            r7 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x009c
        L_0x006a:
            r7 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x007c
        L_0x006f:
            r7 = move-exception
            r2 = r3
            goto L_0x0077
        L_0x0072:
            r7 = move-exception
            r2 = r3
            goto L_0x007b
        L_0x0075:
            r7 = move-exception
            r8 = 0
        L_0x0077:
            r3 = 0
            goto L_0x009c
        L_0x0079:
            r7 = move-exception
            r8 = 0
        L_0x007b:
            r3 = 0
        L_0x007c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r4.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r5 = "埋点过程发生异常啦"
            r4.append(r5)     // Catch:{ all -> 0x009b }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x009b }
            r4.append(r7)     // Catch:{ all -> 0x009b }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x009b }
            if (r2 == r1) goto L_0x0097
            if (r8 != 0) goto L_0x0097
            if (r3 == 0) goto L_0x009a
        L_0x0097:
            m40316a(r2, r8, r3, r7)
        L_0x009a:
            return
        L_0x009b:
            r7 = move-exception
        L_0x009c:
            if (r2 == r1) goto L_0x00a2
            if (r8 != 0) goto L_0x00a2
            if (r3 == 0) goto L_0x00a5
        L_0x00a2:
            m40316a(r2, r8, r3, r0)
        L_0x00a5:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.poibase.AlarmOmegaUtil.checkPoiResponseIsValid(com.sdk.poibase.model.poi.ReverseStationsInfo, java.lang.String):void");
    }

    /* renamed from: a */
    private static int m40314a(ArrayList<RpcPoi> arrayList) {
        if ((arrayList == null || arrayList.isEmpty() || arrayList.get(0) == null || arrayList.get(0).base_info == null) ? false : true) {
            RpcPoiBaseInfo rpcPoiBaseInfo = arrayList.get(0).base_info;
            if (rpcPoiBaseInfo.poi_id == null || rpcPoiBaseInfo.poi_id.isEmpty()) {
                return 1;
            }
            if (rpcPoiBaseInfo.displayname == null || rpcPoiBaseInfo.displayname.isEmpty()) {
                return 2;
            }
            if (!LatLngUtils.locateCorrect(rpcPoiBaseInfo.lat, rpcPoiBaseInfo.lng)) {
                return 3;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static void m40316a(int i, int i2, int i3, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("rego_empty_error", Integer.valueOf(i));
        hashMap.put("rego_error_type", Integer.valueOf(i2));
        hashMap.put("rec_start_error_type", Integer.valueOf(i3));
        hashMap.put("traceid", str);
        GlobalOmegaTracker.trackEvent(f55991e, hashMap);
    }
}

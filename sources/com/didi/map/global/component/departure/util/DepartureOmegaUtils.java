package com.didi.map.global.component.departure.util;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.sdk.poibase.model.RpcPoi;
import java.util.HashMap;
import java.util.Map;

public class DepartureOmegaUtils {

    /* renamed from: a */
    private static final String f25290a = "recommend_location";

    /* renamed from: b */
    private static final String f25291b = "recommend_lng";

    /* renamed from: c */
    private static final String f25292c = "recommend_lat";

    /* renamed from: d */
    private static final String f25293d = "srctag";
    public static boolean hasDragged = false;
    public static boolean isFirst = true;

    public static class OmegaParams {
        public static final int DRAG = 0;
        public static final int HOMING = 1;
        public static final int NONE = -1;
        public static final int RECOMMEND = 1;
        public static final int REVERSE = 0;
        public static int scrollType = -1;
        public static int type = -1;
    }

    public static void trackShowRecMarker(RecPoint recPoint, int i) {
        if (recPoint != null && recPoint.location != null && !TextUtils.isEmpty(recPoint.srctag)) {
            HashMap hashMap = new HashMap();
            hashMap.put("recommend_location", recPoint.addrName);
            hashMap.put("recommend_lng", Double.valueOf(recPoint.location.longitude));
            hashMap.put("recommend_lat", Double.valueOf(recPoint.location.latitude));
            hashMap.put("srctag", recPoint.srctag);
            hashMap.put("type", Integer.valueOf(i));
            GlobalOmegaTracker.trackEvent("map_recommend_sw", hashMap);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0175 A[Catch:{ Exception -> 0x01a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void trackPinMove(com.didi.common.map.model.LatLng r7) {
        /*
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x01a7 }
            r0.<init>()     // Catch:{ Exception -> 0x01a7 }
            if (r7 == 0) goto L_0x001d
            java.lang.String r1 = "lng"
            double r2 = r7.longitude     // Catch:{ Exception -> 0x01a7 }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x01a7 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = "lat"
            double r2 = r7.latitude     // Catch:{ Exception -> 0x01a7 }
            java.lang.Double r7 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x01a7 }
            r0.put(r1, r7)     // Catch:{ Exception -> 0x01a7 }
        L_0x001d:
            java.lang.String r7 = "type"
            int r1 = com.didi.map.global.component.departure.util.DepartureOmegaUtils.OmegaParams.type     // Catch:{ Exception -> 0x01a7 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01a7 }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r7 = "method"
            int r1 = com.didi.map.global.component.departure.util.DepartureOmegaUtils.OmegaParams.scrollType     // Catch:{ Exception -> 0x01a7 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01a7 }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r7 = "if_first"
            boolean r1 = isFirst     // Catch:{ Exception -> 0x01a7 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003e
            r1 = 1
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01a7 }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.PaxEnvironment r7 = com.didi.map.sdk.env.PaxEnvironment.getInstance()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.PointType r7 = r7.getPointType()     // Catch:{ Exception -> 0x01a7 }
            int r7 = r7.getValue()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = "point_type"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x01a7 }
            r0.put(r1, r7)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r7 = "map_pin_move_sd"
            java.lang.String r1 = "timestamp"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01a7 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x01a7 }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = "product_id"
            com.didi.map.sdk.env.PaxEnvironment r4 = com.didi.map.sdk.env.PaxEnvironment.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r4 = r4.getProductId()     // Catch:{ Exception -> 0x01a7 }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = "user_type"
            com.didi.map.sdk.env.PaxEnvironment r4 = com.didi.map.sdk.env.PaxEnvironment.getInstance()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.RoleType r4 = r4.getRoleType()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.RoleType r5 = com.didi.map.sdk.env.RoleType.DRIVER     // Catch:{ Exception -> 0x01a7 }
            if (r4 != r5) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r2 = 0
        L_0x008b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x01a7 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = "uid"
            com.didi.map.sdk.env.PaxEnvironment r2 = com.didi.map.sdk.env.PaxEnvironment.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = r2.getUid()     // Catch:{ Exception -> 0x01a7 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.PaxEnvironment r1 = com.didi.map.sdk.env.PaxEnvironment.getInstance()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.Page r1 = r1.getPage()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.PaxEnvironment r2 = com.didi.map.sdk.env.PaxEnvironment.getInstance()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.Page r2 = r2.getEntrance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.Page r4 = com.didi.map.sdk.env.Page.INSERVICE_PAGE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01a7 }
            boolean r4 = r1.equals(r4)     // Catch:{ Exception -> 0x01a7 }
            if (r4 != 0) goto L_0x0124
            com.didi.map.sdk.env.Page r4 = com.didi.map.sdk.env.Page.INSERVICE_PAGE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01a7 }
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x01a7 }
            if (r4 == 0) goto L_0x00d1
            goto L_0x0124
        L_0x00d1:
            com.didi.map.sdk.env.Page r4 = com.didi.map.sdk.env.Page.CONF_PAGE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01a7 }
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x01a7 }
            if (r4 == 0) goto L_0x0119
            com.didi.map.sdk.env.PaxEnvironment r4 = com.didi.map.sdk.env.PaxEnvironment.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = com.didi.map.sdk.env.CacheKey.CLICK_POSITION     // Catch:{ Exception -> 0x01a7 }
            java.lang.Object r4 = r4.getCache(r5)     // Catch:{ Exception -> 0x01a7 }
            if (r4 == 0) goto L_0x0100
            java.lang.String r5 = r4.toString()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.Page r6 = com.didi.map.sdk.env.Page.START_BUBBLE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01a7 }
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x01a7 }
            if (r5 == 0) goto L_0x0100
            com.didi.map.sdk.env.Page r2 = com.didi.map.sdk.env.Page.START_BUBBLE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01a7 }
            goto L_0x014d
        L_0x0100:
            if (r4 == 0) goto L_0x014d
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.Page r5 = com.didi.map.sdk.env.Page.END_BUBBLE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01a7 }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x01a7 }
            if (r4 == 0) goto L_0x014d
            com.didi.map.sdk.env.Page r2 = com.didi.map.sdk.env.Page.END_BUBBLE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01a7 }
            goto L_0x014d
        L_0x0119:
            com.didi.map.sdk.env.PaxEnvironment r4 = com.didi.map.sdk.env.PaxEnvironment.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = com.didi.map.sdk.env.CacheKey.CLICK_POSITION     // Catch:{ Exception -> 0x01a7 }
            r6 = 0
            r4.setCache(r5, r6)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x014d
        L_0x0124:
            com.didi.map.sdk.env.PaxEnvironment r1 = com.didi.map.sdk.env.PaxEnvironment.getInstance()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r4 = com.didi.map.sdk.env.CacheKey.CLICK_POSITION     // Catch:{ Exception -> 0x01a7 }
            java.lang.Object r1 = r1.getCache(r4)     // Catch:{ Exception -> 0x01a7 }
            if (r1 == 0) goto L_0x0147
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01a7 }
            com.didi.map.sdk.env.Page r4 = com.didi.map.sdk.env.Page.PICKUP_PAGE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01a7 }
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x01a7 }
            if (r1 == 0) goto L_0x0147
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.PICKUP_PAGE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01a7 }
            goto L_0x014d
        L_0x0147:
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.ONTRIP_PAGE     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01a7 }
        L_0x014d:
            java.lang.String r4 = "page"
            r0.put(r4, r1)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r1 = "entrance"
            r0.put(r1, r2)     // Catch:{ Exception -> 0x01a7 }
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r7, (java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ Exception -> 0x01a7 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a7 }
            r1.<init>()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = "【key:"
            r1.append(r2)     // Catch:{ Exception -> 0x01a7 }
            r1.append(r7)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r7 = "】"
            r1.append(r7)     // Catch:{ Exception -> 0x01a7 }
            int r7 = r0.size()     // Catch:{ Exception -> 0x01a7 }
            if (r7 <= 0) goto L_0x01a4
            java.util.Set r7 = r0.entrySet()     // Catch:{ Exception -> 0x01a7 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x01a7 }
        L_0x017d:
            boolean r0 = r7.hasNext()     // Catch:{ Exception -> 0x01a7 }
            if (r0 == 0) goto L_0x01a4
            java.lang.Object r0 = r7.next()     // Catch:{ Exception -> 0x01a7 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch:{ Exception -> 0x01a7 }
            java.lang.Object r2 = r0.getKey()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x01a7 }
            r1.append(r2)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = ":"
            r1.append(r2)     // Catch:{ Exception -> 0x01a7 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ Exception -> 0x01a7 }
            r1.append(r0)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x017d
        L_0x01a4:
            isFirst = r3     // Catch:{ Exception -> 0x01a7 }
            goto L_0x01ab
        L_0x01a7:
            r7 = move-exception
            r7.printStackTrace()
        L_0x01ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.util.DepartureOmegaUtils.trackPinMove(com.didi.common.map.model.LatLng):void");
    }

    /* renamed from: a */
    private static HashMap<String, Object> m18104a(RpcPoi rpcPoi) {
        if (rpcPoi == null || rpcPoi.base_info == null) {
            return null;
        }
        String str = rpcPoi.base_info.displayname;
        if (TextUtils.isEmpty(str)) {
            str = rpcPoi.base_info.addressAll;
        }
        if (TextUtils.isEmpty(str)) {
            str = rpcPoi.base_info.address;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("recommend_location", str);
        hashMap.put("recommend_lng", Double.valueOf(rpcPoi.base_info.lng));
        hashMap.put("recommend_lat", Double.valueOf(rpcPoi.base_info.lat));
        hashMap.put("srctag", rpcPoi.base_info.srctag);
        return hashMap;
    }

    public static void mapDragRecommend(RpcPoi rpcPoi) {
        HashMap<String, Object> a = m18104a(rpcPoi);
        if (a != null) {
            a.put("type", Integer.valueOf(hasDragged ? 2 : 1));
            GlobalOmegaTracker.trackEvent("map_recommend_drag", a);
            if (hasDragged) {
                hasDragged = false;
            }
        }
    }

    public static void trackNoParkingError(LatLng latLng, String str, String str2, int i) {
        HashMap hashMap = new HashMap();
        if (LatLngUtils.locateCorrect(latLng)) {
            hashMap.put("lat", Double.valueOf(latLng.latitude));
            hashMap.put("lng", Double.valueOf(latLng.longitude));
        }
        hashMap.put("poiid", str);
        hashMap.put("fenceid", str2);
        hashMap.put("isfail", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("tech_global_tkp_forbidden_request", (Map<String, Object>) hashMap);
    }

    public static void trackOnLocFollow() {
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", PaxEnvironment.getInstance().getUid());
        OmegaSDKAdapter.trackEvent("map_pinkup_poiinfo_refresh_bt", (Map<String, Object>) hashMap);
    }
}

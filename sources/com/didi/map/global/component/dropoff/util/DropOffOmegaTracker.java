package com.didi.map.global.component.dropoff.util;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.sdk.poibase.model.RpcPoi;
import java.util.HashMap;
import java.util.Map;

public class DropOffOmegaTracker {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void trackPageShow(com.didi.map.global.component.dropoff.model.DropOffLocationInfo r9, java.util.List<com.sdk.poibase.model.RpcPoi> r10, com.sdk.poibase.model.RpcPoi r11, int r12, java.lang.String r13) {
        /*
            boolean r0 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r10)
            r1 = 0
            java.lang.String r2 = ""
            if (r0 != 0) goto L_0x005f
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0059 }
            r0.<init>()     // Catch:{ JSONException -> 0x0059 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ JSONException -> 0x0059 }
            r3 = 0
        L_0x0013:
            boolean r4 = r10.hasNext()     // Catch:{ JSONException -> 0x0057 }
            if (r4 == 0) goto L_0x0052
            java.lang.Object r4 = r10.next()     // Catch:{ JSONException -> 0x0057 }
            com.sdk.poibase.model.RpcPoi r4 = (com.sdk.poibase.model.RpcPoi) r4     // Catch:{ JSONException -> 0x0057 }
            com.sdk.poibase.model.RpcPoiBaseInfo r5 = r4.base_info     // Catch:{ JSONException -> 0x0057 }
            if (r5 == 0) goto L_0x0013
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0057 }
            r5.<init>()     // Catch:{ JSONException -> 0x0057 }
            java.lang.String r6 = "display_name"
            com.sdk.poibase.model.RpcPoiBaseInfo r7 = r4.base_info     // Catch:{ JSONException -> 0x0057 }
            java.lang.String r7 = r7.displayname     // Catch:{ JSONException -> 0x0057 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0057 }
            java.lang.String r6 = "full_name"
            com.sdk.poibase.model.RpcPoiBaseInfo r7 = r4.base_info     // Catch:{ JSONException -> 0x0057 }
            java.lang.String r7 = r7.addressAll     // Catch:{ JSONException -> 0x0057 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0057 }
            java.lang.String r6 = "lat"
            com.sdk.poibase.model.RpcPoiBaseInfo r7 = r4.base_info     // Catch:{ JSONException -> 0x0057 }
            double r7 = r7.lat     // Catch:{ JSONException -> 0x0057 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0057 }
            java.lang.String r6 = "lng"
            com.sdk.poibase.model.RpcPoiBaseInfo r4 = r4.base_info     // Catch:{ JSONException -> 0x0057 }
            double r7 = r4.lng     // Catch:{ JSONException -> 0x0057 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0057 }
            int r3 = r3 + 1
            r0.put(r5)     // Catch:{ JSONException -> 0x0057 }
            goto L_0x0013
        L_0x0052:
            java.lang.String r2 = r0.toString()     // Catch:{ JSONException -> 0x0057 }
            goto L_0x0060
        L_0x0057:
            r10 = move-exception
            goto L_0x005b
        L_0x0059:
            r10 = move-exception
            r3 = 0
        L_0x005b:
            r10.printStackTrace()
            goto L_0x0060
        L_0x005f:
            r3 = 0
        L_0x0060:
            r10 = 2
            if (r12 == r10) goto L_0x0069
            r0 = 3
            if (r12 == r0) goto L_0x0067
            goto L_0x006a
        L_0x0067:
            r1 = 2
            goto L_0x006a
        L_0x0069:
            r1 = 1
        L_0x006a:
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            com.didi.sdk.address.address.entity.Address r12 = r9.sugPoi
            if (r12 == 0) goto L_0x00a3
            com.didi.sdk.address.address.entity.Address r12 = r9.sugPoi
            java.lang.String r12 = r12.uid
            java.lang.String r0 = "to_poi_id"
            r10.put(r0, r12)
            com.didi.sdk.address.address.entity.Address r12 = r9.sugPoi
            double r4 = r12.longitude
            java.lang.Double r12 = java.lang.Double.valueOf(r4)
            java.lang.String r0 = "to_lng"
            r10.put(r0, r12)
            com.didi.sdk.address.address.entity.Address r12 = r9.sugPoi
            double r4 = r12.latitude
            java.lang.Double r12 = java.lang.Double.valueOf(r4)
            java.lang.String r0 = "to_lat"
            r10.put(r0, r12)
            com.didi.sdk.address.address.entity.Address r9 = r9.sugPoi
            java.lang.String r9 = r9.searchId
            java.lang.String r12 = "search_id"
            r10.put(r12, r9)
        L_0x00a3:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            java.lang.String r12 = "initial_dropoff_num"
            r10.put(r12, r9)
            java.lang.String r9 = "dropoff_rec_points"
            r10.put(r9, r2)
            if (r11 == 0) goto L_0x00d1
            com.sdk.poibase.model.RpcPoiBaseInfo r9 = r11.base_info
            if (r9 == 0) goto L_0x00d1
            com.sdk.poibase.model.RpcPoiBaseInfo r9 = r11.base_info
            double r2 = r9.lng
            java.lang.Double r9 = java.lang.Double.valueOf(r2)
            java.lang.String r12 = "adsorption_lng"
            r10.put(r12, r9)
            com.sdk.poibase.model.RpcPoiBaseInfo r9 = r11.base_info
            double r11 = r9.lat
            java.lang.Double r9 = java.lang.Double.valueOf(r11)
            java.lang.String r11 = "adsorption_lat"
            r10.put(r11, r9)
        L_0x00d1:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r1)
            java.lang.String r11 = "rec_sug"
            r10.put(r11, r9)
            java.lang.String r9 = "trace_id"
            r10.put(r9, r13)
            java.lang.String r9 = "map_dropoff_confirm_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r9, (java.util.Map<java.lang.String, java.lang.Object>) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.dropoff.util.DropOffOmegaTracker.trackPageShow(com.didi.map.global.component.dropoff.model.DropOffLocationInfo, java.util.List, com.sdk.poibase.model.RpcPoi, int, java.lang.String):void");
    }

    public static void trackConfirmClick(DropOffAddress dropOffAddress, int i) {
        HashMap hashMap = new HashMap();
        if (dropOffAddress.getAddress() != null) {
            hashMap.put("dropoff_addr", dropOffAddress.getAddress().fullName);
            hashMap.put("dropoff_name", dropOffAddress.getAddress().displayName);
            hashMap.put("dropoff_lng", Double.valueOf(dropOffAddress.getAddress().longitude));
            hashMap.put("dropoff_lat", Double.valueOf(dropOffAddress.getAddress().latitude));
            hashMap.put("dropoff_type", Integer.valueOf(i));
            OmegaSDKAdapter.trackEvent("map_dropoff_confirm_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackMapDragged(DropOffAddress dropOffAddress, DropOffAddress dropOffAddress2, double d) {
        HashMap hashMap = new HashMap();
        if (dropOffAddress.getAddress() != null && dropOffAddress2.getAddress() != null) {
            hashMap.put("lng1", Double.valueOf(dropOffAddress.getAddress().longitude));
            hashMap.put("lat1", Double.valueOf(dropOffAddress.getAddress().latitude));
            hashMap.put("name1", dropOffAddress.getAddress().displayName);
            hashMap.put("addr1", dropOffAddress.getAddress().fullName);
            hashMap.put("lng2", Double.valueOf(dropOffAddress2.getAddress().longitude));
            hashMap.put("lat2", Double.valueOf(dropOffAddress2.getAddress().latitude));
            hashMap.put("name2", dropOffAddress2.getAddress().displayName);
            hashMap.put("addr2", dropOffAddress2.getAddress().fullName);
            hashMap.put("level", Double.valueOf(d));
            OmegaSDKAdapter.trackEvent("map_dropoff_drag_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackMapZoomChanged(String str, LatLng latLng, double d, double d2) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamKeys.PARAM_TO_POI_UID, str);
        hashMap.put("lng", Double.valueOf(latLng.longitude));
        hashMap.put("lat", Double.valueOf(latLng.latitude));
        hashMap.put("level1", Double.valueOf(d));
        hashMap.put("level2", Double.valueOf(d2));
        OmegaSDKAdapter.trackEvent("map_dropoff_zoom_ck", (Map<String, Object>) hashMap);
    }

    public static void trackRecMarkerClick(RpcPoi rpcPoi) {
        HashMap hashMap = new HashMap();
        if (rpcPoi != null && rpcPoi.base_info != null) {
            hashMap.put("poi_id", rpcPoi.base_info.poi_id);
            hashMap.put("lng", Double.valueOf(rpcPoi.base_info.lng));
            hashMap.put("lat", Double.valueOf(rpcPoi.base_info.lat));
            hashMap.put("name", rpcPoi.base_info.displayname);
            hashMap.put("addr", rpcPoi.base_info.addressAll);
            OmegaSDKAdapter.trackEvent("map_dropoff_point_ck", (Map<String, Object>) hashMap);
        }
    }
}

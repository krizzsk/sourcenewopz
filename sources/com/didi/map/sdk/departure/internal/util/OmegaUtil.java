package com.didi.map.sdk.departure.internal.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.map.sdk.departure.internal.markers.RecPoint;
import com.didi.map.sdk.departure.param.DepartureCompParam;
import com.didi.map.sdk.env.CacheKey;
import com.didi.map.sdk.env.Page;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.RoleType;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.RpcPoi;
import java.util.HashMap;
import java.util.Map;

public class OmegaUtil {
    public static final int DRAG = 0;
    public static final int HOMING = 1;
    public static final int NONE = -1;

    /* renamed from: a */
    private static final String f28244a = "recommend_location";

    /* renamed from: b */
    private static final String f28245b = "recommend_lng";

    /* renamed from: c */
    private static final String f28246c = "recommend_lat";

    /* renamed from: d */
    private static final String f28247d = "srctag";
    public static boolean hasDragged = false;
    public static boolean isFirst = true;
    public static boolean isPinFirstShow = false;

    public static void trackPinReqSuccess() {
        GlobalOmegaTracker.trackEvent("map_pin_search_success", new HashMap());
    }

    public static void trackShowRecMarker(RecPoint recPoint) {
        if (recPoint != null && recPoint.location != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("recommend_location", recPoint.addrName);
            hashMap.put("recommend_lng", Double.valueOf(recPoint.location.longitude));
            hashMap.put("recommend_lat", Double.valueOf(recPoint.location.latitude));
            hashMap.put("srctag", recPoint.srctag);
            GlobalOmegaTracker.trackEvent("map_recommend_sw", hashMap);
        }
    }

    public static void trackPinReqFail(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("map_pin_search_fail", hashMap);
    }

    public static void trackRecMarkerClick(RecPoint recPoint) {
        if (recPoint != null && recPoint.location != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("recommend_location", recPoint.addrName);
            hashMap.put("recommend_lng", Double.valueOf(recPoint.location.longitude));
            hashMap.put("recommend_lat", Double.valueOf(recPoint.location.latitude));
            hashMap.put("srctag", recPoint.srctag);
            GlobalOmegaTracker.trackEvent("map_recommend_ck", hashMap);
        }
    }

    public static void trackPinMove(LatLng latLng, int i, int i2, CallFrom callFrom) {
        try {
            HashMap hashMap = new HashMap();
            if (latLng != null) {
                hashMap.put("lng", Double.valueOf(latLng.longitude));
                hashMap.put("lat", Double.valueOf(latLng.latitude));
            }
            hashMap.put("type", Integer.valueOf(i));
            hashMap.put("method", Integer.valueOf(i2));
            hashMap.put("if_first", Integer.valueOf(isFirst ? 1 : 0));
            if (callFrom == CallFrom.PICKUP_PAGE) {
                hashMap.put("page", "piconf_vamos_rider");
            }
            hashMap.put("point_type", Integer.valueOf(PaxEnvironment.getInstance().getPointType().getValue()));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("product_id", PaxEnvironment.getInstance().getProductId());
            hashMap.put("user_type", Integer.valueOf(PaxEnvironment.getInstance().getRoleType() == RoleType.DRIVER ? 1 : 0));
            hashMap.put("uid", PaxEnvironment.getInstance().getUid());
            String page = PaxEnvironment.getInstance().getPage().toString();
            String page2 = PaxEnvironment.getInstance().getEntrance().toString();
            if (!page2.equals(Page.CONF_PAGE.toString()) || !page.equals(Page.SUG_PAGE.toString())) {
                PaxEnvironment.getInstance().setCache(CacheKey.CLICK_POSITION, (Object) null);
            } else {
                Object cache = PaxEnvironment.getInstance().getCache(CacheKey.CLICK_POSITION);
                if (cache != null) {
                    String str = (String) cache;
                    if (str.equals(Page.START_BUBBLE.toString())) {
                        page2 = Page.START_BUBBLE.toString();
                    } else if (str.equals(Page.END_BUBBLE.toString())) {
                        page2 = Page.END_BUBBLE.toString();
                    }
                }
            }
            hashMap.put("page", page);
            hashMap.put("entrance", page2);
            OmegaSDKAdapter.trackEvent("map_pin_move_sd", (Map<String, Object>) hashMap);
            StringBuilder sb = new StringBuilder();
            sb.append("【key:");
            sb.append("map_pin_move_sd");
            sb.append("】");
            if (hashMap.size() > 0) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb.append("\n");
                    sb.append((String) entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                }
            }
            DLog.m7384d("common-model", "trackEvent: %s", sb.toString());
            isFirst = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static HashMap<String, Object> m20056a(RpcPoi rpcPoi) {
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

    public static void map_base_slide() {
        OmegaSDKAdapter.trackEvent("map_base_slide");
    }

    public static void map_recommend_drag(RpcPoi rpcPoi) {
        HashMap<String, Object> a = m20056a(rpcPoi);
        if (a != null) {
            a.put("type", Integer.valueOf(hasDragged ? 2 : 1));
            GlobalOmegaTracker.trackEvent("map_recommend_drag", a);
        }
    }

    /* renamed from: a */
    private static void m20057a(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            hashMap.put("passenger_id", PaxEnvironment.getInstance().getUid());
            hashMap.put("phone", PaxEnvironment.getInstance().getPhoneNumber());
            hashMap.put("product", PaxEnvironment.getInstance().getProductId());
        }
    }

    public static void map_fist_pin_show(Context context, LatLng latLng, DepartureCompParam departureCompParam, boolean z) {
        DIDILocation lastKnownLocation;
        if (!isPinFirstShow) {
            isPinFirstShow = true;
            if (context != null && latLng != null && departureCompParam != null && (lastKnownLocation = LatLngUtil.getLastKnownLocation(context.getApplicationContext())) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pin_lng", Double.valueOf(latLng.longitude));
                hashMap.put("pin_lat", Double.valueOf(latLng.latitude));
                hashMap.put("head_lng", Double.valueOf(lastKnownLocation.getLongitude()));
                hashMap.put("head_lat", Double.valueOf(lastKnownLocation.getLatitude()));
                hashMap.put("head_loc_time", Long.valueOf(lastKnownLocation.getTime()));
                hashMap.put("is_follow", Integer.valueOf(z ? 1 : 0));
                hashMap.put(NNGestureClassfy.SCALE_LABLE, Float.valueOf(departureCompParam.zoom));
                m20057a((HashMap<String, Object>) hashMap);
                GlobalOmegaTracker.trackEvent("map_fist_pin_show", hashMap);
            }
        }
    }
}

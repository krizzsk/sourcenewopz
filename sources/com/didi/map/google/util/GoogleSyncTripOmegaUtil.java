package com.didi.map.google.util;

import com.didi.common.map.model.LatLng;
import com.didi.map.google.model.OmegaTraceEvent;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GoogleSyncTripOmegaUtil {
    public static final int BACKGROUND = 2;
    public static final int FOREGROUND = 0;
    public static final String PARAM_PAGE_VALUE = "inservice_page";

    public enum BindResult {
        SUCCESS(0),
        FAIL_NO_LOC(12),
        FAIL_BIND(11);
        
        public int result;

        private BindResult(int i) {
            this.result = i;
        }
    }

    public static void com_map_PassengerGetRoute_sw_global(String str, String str2, long j, int i, boolean z, String str3, String str4, boolean z2, int i2, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, Long.valueOf(j));
        int i3 = 0;
        hashMap.put("map_type", 0);
        hashMap.put("travelid", str4);
        hashMap.put("countryid", str3);
        if (z2) {
            i3 = 2;
        }
        hashMap.put("app_state", Integer.valueOf(i3));
        OmegaCommonArgsAppender.append(hashMap, str, str2, i, z, i2, str5, PARAM_PAGE_VALUE, str6);
        OmegaSDKAdapter.trackEvent("com_map_PassengerGetRoute_sw_global", (Map<String, Object>) hashMap);
    }

    public static void map_pax_animation_car_delay(String str, String str2, int i, boolean z, int i2, float f, float f2, LatLng latLng, LatLng latLng2, long j, int i3, String str3, String str4) {
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        HashMap hashMap = new HashMap();
        hashMap.put("speed", Integer.valueOf(i2));
        int i4 = 1;
        hashMap.put("dri_loc_eda", String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(f)}));
        hashMap.put("ani_loc_eda", String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(f2)}));
        if (latLng3 != null) {
            hashMap.put("car_lat", String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(latLng3.latitude)}));
            hashMap.put("car_lng", String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(latLng3.longitude)}));
        }
        if (latLng4 != null) {
            hashMap.put("anim_lat", String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(latLng4.latitude)}));
            hashMap.put("anim_lng", String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(latLng4.longitude)}));
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        hashMap.put("yaw_value", Long.valueOf(currentTimeMillis));
        if (currentTimeMillis >= 6000) {
            i4 = 0;
        }
        hashMap.put("is_yaw", Integer.valueOf(i4));
        OmegaCommonArgsAppender.append(hashMap, str, str2, i, z, i3, str3, PARAM_PAGE_VALUE, str4);
        OmegaSDKAdapter.trackEvent(OmegaTraceEvent.Keys.MAP_PAX_ANIMATION_CAR_DELAY, (Map<String, Object>) hashMap);
    }

    public static void map_pax_car_jump(String str, String str2, int i, boolean z, float f, int i2, LatLng latLng, long j, LatLng latLng2, long j2, int i3, String str3, String str4) {
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        HashMap hashMap = new HashMap();
        hashMap.put("distance", Float.valueOf(f));
        hashMap.put("route_display", Integer.valueOf(i2));
        if (latLng4 != null) {
            hashMap.put("new_route_lat", String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(latLng4.latitude)}));
            hashMap.put("new_route_lng", String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(latLng4.longitude)}));
        }
        if (latLng3 != null) {
            hashMap.put("old_car_lat", String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(latLng3.latitude)}));
            hashMap.put("old_car_lng", String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(latLng3.longitude)}));
        }
        hashMap.put("old_car_timestamp", Long.valueOf(j));
        hashMap.put("new_route_timestamp", Long.valueOf(j2));
        OmegaCommonArgsAppender.append(hashMap, str, str2, i, z, i3, str3, PARAM_PAGE_VALUE, str4);
        OmegaSDKAdapter.trackEvent(OmegaTraceEvent.Keys.MAP_PAX_CAR_JUMP, (Map<String, Object>) hashMap);
    }

    public static void traceSctxExceptionEvent(String str, String str2, int i, boolean z, int i2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        OmegaCommonArgsAppender.append(hashMap, str, str2, i, z, i2, str3, PARAM_PAGE_VALUE, str4);
        OmegaSDKAdapter.trackEvent(OmegaTraceEvent.Keys.MAP_PAX_SHOW_DRIVER_EXCEPTION, (Map<String, Object>) hashMap);
    }

    @Deprecated
    public static void com_map_PassengerBindSuccessJump_sw_global(String str, long j, int i, boolean z, String str2, String str3, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, Long.valueOf(j));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        int i2 = 0;
        hashMap.put("map_type", 0);
        hashMap.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, Integer.valueOf(i == 3 ? z ? 1 : 0 : 2));
        hashMap.put("travelid", str3);
        hashMap.put("countryid", str2);
        if (z2) {
            i2 = 2;
        }
        hashMap.put("app_state", Integer.valueOf(i2));
        OmegaSDKAdapter.trackEvent("com_map_PassengerBindSuccessJump_sw_global", (Map<String, Object>) hashMap);
    }

    @Deprecated
    public static void com_map_BindFailFor2_sw_global(String str, long j, int i, boolean z, String str2, String str3, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, Long.valueOf(j));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        int i2 = 0;
        hashMap.put("map_type", 0);
        hashMap.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, Integer.valueOf(i == 3 ? z ? 1 : 0 : 2));
        hashMap.put("travelid", str3);
        hashMap.put("countryid", str2);
        if (z2) {
            i2 = 2;
        }
        hashMap.put("app_state", Integer.valueOf(i2));
        OmegaSDKAdapter.trackEvent("com_map_BindFailFor2_sw_global", (Map<String, Object>) hashMap);
    }

    @Deprecated
    public static void com_map_PassengerNoDriverLocation_sw_global(String str, long j, int i, boolean z, String str2, String str3, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, Long.valueOf(j));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        int i2 = 0;
        hashMap.put("map_type", 0);
        hashMap.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, Integer.valueOf(i == 3 ? z ? 1 : 0 : 2));
        hashMap.put("travelid", str3);
        hashMap.put("countryid", str2);
        if (z2) {
            i2 = 2;
        }
        hashMap.put("app_state", Integer.valueOf(i2));
        OmegaSDKAdapter.trackEvent("com_map_PassengerNoDriverLocation_sw_global", (Map<String, Object>) hashMap);
    }

    @Deprecated
    public static void com_map_BindSuccessOrFail_sw_global(String str, long j, int i, boolean z, String str2, String str3, boolean z2, LatLng latLng, LatLng latLng2, BindResult bindResult, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, Long.valueOf(j));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        int i3 = 0;
        hashMap.put("map_type", 0);
        hashMap.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, Integer.valueOf(i == 3 ? z ? 1 : 0 : 2));
        hashMap.put("travelid", str3);
        hashMap.put("countryid", str2);
        if (z2) {
            i3 = 2;
        }
        hashMap.put("app_state", Integer.valueOf(i3));
        if (latLng != null) {
            hashMap.put("bindcar_lng_before", Double.valueOf(latLng.longitude));
            hashMap.put("bindcar_lat_before", Double.valueOf(latLng.latitude));
        }
        if (latLng2 != null) {
            hashMap.put("bindcar_lng_after", Double.valueOf(latLng2.longitude));
            hashMap.put("bindcar_lat_after", Double.valueOf(latLng2.latitude));
        }
        if (bindResult != null) {
            hashMap.put("error_code", Integer.valueOf(bindResult.result));
        }
        hashMap.put("continuous_failed_count", Integer.valueOf(i2));
        OmegaSDKAdapter.trackEvent("com_map_BindSuccessOrFail_sw_global", (Map<String, Object>) hashMap);
    }

    @Deprecated
    public static void com_map_PassengerCarIsNotMoving_sw_global(String str, long j, int i, boolean z, String str2, String str3, boolean z2, LatLng latLng, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, Long.valueOf(j));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        int i4 = 0;
        hashMap.put("map_type", 0);
        hashMap.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, Integer.valueOf(i == 3 ? z ? 1 : 0 : 2));
        hashMap.put("travelid", str3);
        hashMap.put("countryid", str2);
        if (z2) {
            i4 = 2;
        }
        hashMap.put("app_state", Integer.valueOf(i4));
        if (latLng != null) {
            hashMap.put("car_lng", Double.valueOf(latLng.longitude));
            hashMap.put("car_lat", Double.valueOf(latLng.latitude));
        }
        hashMap.put(C12407a.f36608f, Integer.valueOf(i2));
        hashMap.put("type", Integer.valueOf(i3));
        OmegaSDKAdapter.trackEvent("com_map_PassengerCarIsNotMoving_sw_global", (Map<String, Object>) hashMap);
    }
}

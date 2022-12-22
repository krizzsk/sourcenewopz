package com.didi.trackupload.sdk.utils;

import com.android.didi.bfflib.business.BffNetConstant;
import com.didi.mapbizinterface.common.AppStateMonitor;
import com.didi.trackupload.sdk.BuildConfig;
import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.core.UploadResult;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OmegaUtils {

    /* renamed from: a */
    private static final String f44005a = "TrackOmega";

    /* renamed from: b */
    private static final Random f44006b = new Random();

    /* renamed from: c */
    private static final int f44007c = ApolloUtils.getOmegaUpoadResultSampleRate();

    static {
        TrackLog.m31343d(f44005a, "uploadResultSimpleRate=" + f44007c);
    }

    public static void trackEvent(String str, String str2, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(str, str2, map);
    }

    public static void trackUploadResult(UploadResult uploadResult, Long l, Long l2, Long l3, Long l4, Long l5, Integer num, Boolean bool, Long l6, Integer num2, Integer num3) {
        UploadResult uploadResult2 = uploadResult;
        Long l7 = l;
        Long l8 = l2;
        Long l9 = l3;
        Long l10 = l4;
        Long l11 = l5;
        Integer num4 = num;
        Long l12 = l6;
        if (m31339a(f44007c)) {
            AppStateMonitor.AppState appState = AppStateMonitor.getInstance().getAppState();
            boolean isDirectUploadModeEnabled = TrackController.getIntance().getInitParams().isDirectUploadModeEnabled();
            Event event = new Event("com_map_PassengerTrackSDK_upload", "");
            HashMap hashMap = new HashMap();
            if (uploadResult2 != null) {
                hashMap.put("result", Integer.valueOf(uploadResult.getCode()));
            }
            if (uploadResult2 == UploadResult.ERR_STATE_LAST_LOCATION) {
                hashMap.put("loc_err", LocationCenter.getIntance().getLastError());
                hashMap.put("loc_alive", Integer.valueOf(LocationCenter.getIntance().isLocationServiceAlive() ? 1 : 0));
            }
            if (l7 != null) {
                hashMap.put("time_loc", l);
            }
            if (l8 != null) {
                hashMap.put("time_create", l8);
            }
            if (l9 != null) {
                hashMap.put("time_execute", l9);
            }
            if (l10 != null) {
                hashMap.put("time_send", l10);
            }
            if (l11 != null) {
                hashMap.put("time_completed", l11);
            }
            if (!(appState == null || appState == AppStateMonitor.AppState.UNKNOWN)) {
                hashMap.put("bg", Integer.valueOf(appState == AppStateMonitor.AppState.BACKGROUND ? 1 : 0));
            }
            if (num4 != null) {
                hashMap.put("tx", num4);
            }
            if (bool != null) {
                hashMap.put("track_once", Integer.valueOf(bool.booleanValue() ? 1 : 0));
            }
            if (l12 != null) {
                hashMap.put("flags", l12);
            }
            hashMap.put("direct_upload", Integer.valueOf(isDirectUploadModeEnabled ? 1 : 0));
            hashMap.put("sdk_vertion", BuildConfig.VERSION_NAME);
            hashMap.put("send_type", num2);
            hashMap.put("send_result_detail_code", num3);
            event.putAllAttrs(hashMap);
            event.putNetType();
            OmegaSDKAdapter.trackEvent(event);
        }
    }

    public static void trackDBError(int i, Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put(BffNetConstant.ERR_CODE, Integer.valueOf(i));
        hashMap.put("errmsg", exc.getMessage());
        hashMap.put("sdk_vertion", BuildConfig.VERSION_NAME);
        OmegaSDKAdapter.trackEvent("track_upload_sdk_db_error", (Map<String, Object>) hashMap);
        TrackLog.m31343d(f44005a, "trackDBError errcode=" + i + " errmsg=" + exc.getMessage());
    }

    public static void trackWireError(int i, Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put(BffNetConstant.ERR_CODE, Integer.valueOf(i));
        hashMap.put("errmsg", exc.getMessage());
        hashMap.put("sdk_vertion", BuildConfig.VERSION_NAME);
        OmegaSDKAdapter.trackEvent("track_upload_sdk_wire_error", (Map<String, Object>) hashMap);
        TrackLog.m31343d(f44005a, "trackWireError errcode=" + i + " errmsg=" + exc.getMessage());
    }

    /* renamed from: a */
    private static boolean m31339a(int i) {
        if (i >= 1000) {
            return true;
        }
        return i > 0 && f44006b.nextInt(1000) < i;
    }

    public static void trackHttpBuildMsgErr(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("part", str);
        hashMap.put("errmsg", str2);
        hashMap.put("sdk_vertion", BuildConfig.VERSION_NAME);
        OmegaSDKAdapter.trackEvent("track_http_build_msg_error", (Map<String, Object>) hashMap);
        TrackLog.m31343d(f44005a, "trackHttpBuildMsgErr part=" + str + " errmsg=" + str2);
    }
}

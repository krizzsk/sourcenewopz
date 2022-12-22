package com.didi.address;

import android.text.TextUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import java.util.HashMap;

public class SugAlertOmegaUtil {

    /* renamed from: a */
    private static String f4301a = "tech_global_sug_select_item_error";

    /* renamed from: a */
    private static boolean m2619a(String str) {
        IExperiment experiment;
        String str2;
        IToggle toggle = Apollo.getToggle("global_bi_alarm_passenger_upload");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || (str2 = (String) experiment.getParam("android_event_name", "")) == null || str2.isEmpty()) {
            return false;
        }
        return str2.contains(str);
    }

    /* renamed from: a */
    private static int m2618a(RpcPoi rpcPoi) {
        if (!(rpcPoi == null || rpcPoi.base_info == null)) {
            if (TextUtils.isEmpty(rpcPoi.base_info.poi_id)) {
                return 1;
            }
            if (TextUtils.isEmpty(rpcPoi.base_info.displayname)) {
                return 2;
            }
            if (!LatLngUtils.locateCorrect(rpcPoi.base_info.lat, rpcPoi.base_info.lng)) {
                return 3;
            }
        }
        return -1;
    }

    public static void trackSelectPoiInfoError(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild) {
        int a;
        try {
            if (m2619a(f4301a) && (a = m2618a(rpcPoi)) != -1) {
                HashMap hashMap = new HashMap();
                hashMap.put("poi_error_type", Integer.valueOf(a));
                hashMap.put("description", rpcPoi.toString());
                String str = "";
                if (trackParameterForChild != null) {
                    str = str + trackParameterForChild.search_id;
                }
                hashMap.put("traceid", str);
                GlobalOmegaTracker.trackEvent(f4301a, hashMap);
            }
        } catch (Exception unused) {
        }
    }
}

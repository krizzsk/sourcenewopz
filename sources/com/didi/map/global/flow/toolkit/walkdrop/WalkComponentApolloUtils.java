package com.didi.map.global.flow.toolkit.walkdrop;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

public class WalkComponentApolloUtils {

    /* renamed from: a */
    private static boolean f27244a = false;

    /* renamed from: b */
    private static int f27245b;

    /* renamed from: c */
    private static int f27246c;

    /* renamed from: d */
    private static int f27247d;

    static {
        m19265a();
    }

    /* renamed from: a */
    private static void m19265a() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_sctx_walkline_toggle");
            if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
                int intValue = ((Integer) experiment.getParam("newLineEnable", 0)).intValue();
                f27245b = ((Integer) experiment.getParam("max_distance", 0)).intValue();
                f27246c = ((Integer) experiment.getParam("min_distance", 0)).intValue();
                f27247d = ((Integer) experiment.getParam("push_interval", 0)).intValue();
                boolean z = true;
                if (intValue != 1) {
                    z = false;
                }
                f27244a = z;
                DLog.m7384d("global_map_sctx_walkline_toggle", "isEnable" + f27244a + "maxDistance" + f27245b + "minDistance" + f27246c, new Object[0]);
            }
        } catch (Exception e) {
            DLog.m7384d("global_map_sctx_walkline_toggle", e.toString(), new Object[0]);
            e.printStackTrace();
        }
    }

    public static boolean isUseNewComponent(Context context, LatLng latLng) {
        DIDILocation lastKnownLocation = LocationHelper2.getLastKnownLocation(context, LocationRegisterParam.LocType.FLP);
        LatLng latLng2 = lastKnownLocation != null ? new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()) : null;
        if (!LatLngUtils.locateCorrect(latLng2) || !LatLngUtils.locateCorrect(latLng)) {
            return false;
        }
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng2, latLng);
        DLog.m7384d("NewWalkLine", "distance-->" + computeDistanceBetween, new Object[0]);
        if (!f27244a || computeDistanceBetween >= ((double) f27245b) || computeDistanceBetween <= ((double) f27246c)) {
            return false;
        }
        return true;
    }

    public static int getOraPushInterval() {
        return f27247d;
    }
}

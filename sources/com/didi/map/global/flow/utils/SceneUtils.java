package com.didi.map.global.flow.utils;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

public class SceneUtils {

    /* renamed from: a */
    private static final String f27275a = "SceneUtils";

    public static boolean checkHomeRgeoPax() {
        return true;
    }

    public static boolean isCallForOther(Context context, DepartureAddress departureAddress) {
        DIDILocation dIDILocation;
        String str;
        Context context2 = context;
        if (!MapFlowApolloUtils.getIsEnableCallForOther()) {
            return false;
        }
        int callForOtherStationParam = MapFlowApolloUtils.getCallForOtherStationParam();
        int callForOtherCloseParam = MapFlowApolloUtils.getCallForOtherCloseParam();
        int callForOtherFarParam = MapFlowApolloUtils.getCallForOtherFarParam();
        int callForOtherAccuracyParam = MapFlowApolloUtils.getCallForOtherAccuracyParam();
        int callForOtherSpeedParam = MapFlowApolloUtils.getCallForOtherSpeedParam();
        if (MapFlowApolloUtils.getDepartureNlpParam() == null) {
            dIDILocation = LocationHelper2.getLastKnownLocation(context2, LocationRegisterParam.LocType.FLP);
        } else {
            dIDILocation = LocationHelper2.getLastKnownLocation(context2, LocationRegisterParam.LocType.NLP);
        }
        if (!(dIDILocation == null || departureAddress == null || departureAddress.getAddress() == null)) {
            LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            LatLng latLng2 = new LatLng(departureAddress.getAddress().latitude, departureAddress.getAddress().longitude);
            float speed = dIDILocation.getSpeed();
            float accuracy = dIDILocation.getAccuracy();
            if (dIDILocation != null) {
                boolean z = departureAddress.getZoneType() == 0;
                double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng2, latLng);
                DLog.m7384d(f27275a, " callForOtherParam, myLocation " + latLng + ", orderLocation: " + latLng2 + ", distance: " + computeDistanceBetween + ", speed: " + speed + ", accuracy: " + accuracy + ", isStartTerminal: " + z, new Object[0]);
                if (!z) {
                    if (callForOtherCloseParam < callForOtherFarParam) {
                        String str2 = f27275a;
                        if (computeDistanceBetween <= ((double) callForOtherCloseParam) || computeDistanceBetween >= ((double) callForOtherFarParam)) {
                            str = str2;
                        } else if (accuracy < ((float) callForOtherAccuracyParam) && speed < ((float) callForOtherSpeedParam)) {
                            DLog.m7384d(str2, "not terminal, distance " + computeDistanceBetween + " bigger than " + callForOtherCloseParam + " " + callForOtherFarParam + "，accuracy: " + accuracy + " less than " + callForOtherAccuracyParam + "，is order call for other.", new Object[0]);
                            return true;
                        }
                    } else {
                        str = f27275a;
                    }
                    if (computeDistanceBetween > ((double) callForOtherFarParam)) {
                        DLog.m7384d(str, "not terminal, distance " + computeDistanceBetween + " bigger than " + callForOtherFarParam + "，is order call for other.", new Object[0]);
                        return true;
                    }
                } else if (z && computeDistanceBetween > ((double) callForOtherStationParam)) {
                    DLog.m7384d(f27275a, "terminal and distance " + computeDistanceBetween + "bigger than" + callForOtherStationParam + "，is order call for other.", new Object[0]);
                    return true;
                }
            }
        }
        return false;
    }
}

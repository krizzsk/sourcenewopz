package com.didichuxing.omega.sdk.common.collector;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.yanzhenjie.permission.runtime.Permission;

public class LocationCollector {
    private static Context mContext;
    private static LocationManager mLocationManager;

    public static void init(Context context) {
        mContext = context;
        mLocationManager = (LocationManager) context.getSystemService("location");
    }

    private static double[] getLastKnownLocation() {
        double[] dArr = {0.0d, 0.0d};
        if (mContext == null || mLocationManager == null || (CommonUtil.getAPILevel() >= 23 && mContext.checkSelfPermission(Permission.ACCESS_FINE_LOCATION) != 0 && mContext.checkSelfPermission(Permission.ACCESS_COARSE_LOCATION) != 0)) {
            return dArr;
        }
        try {
            if (mContext.checkCallingOrSelfPermission(Permission.ACCESS_FINE_LOCATION) == 0 && mLocationManager != null) {
                Location lastKnownLocation = mLocationManager.getLastKnownLocation("gps");
                if (lastKnownLocation != null) {
                    dArr[0] = lastKnownLocation.getLongitude();
                    dArr[1] = lastKnownLocation.getLatitude();
                } else {
                    Location lastKnownLocation2 = mLocationManager.getLastKnownLocation("network");
                    if (lastKnownLocation2 != null) {
                        dArr[0] = lastKnownLocation2.getLongitude();
                        dArr[1] = lastKnownLocation2.getLatitude();
                    }
                }
            }
        } catch (Throwable unused) {
            OLog.m34769w("getLastKnownLocation fail!");
        }
        return dArr;
    }

    public static double[] getLocation() {
        if (OmegaConfig.iLocation != null) {
            return OmegaConfig.iLocation.getLocation();
        }
        return getLastKnownLocation();
    }
}

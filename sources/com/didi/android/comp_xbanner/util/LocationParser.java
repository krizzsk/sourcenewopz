package com.didi.android.comp_xbanner.util;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.Utils;

public class LocationParser {
    public static final int APP_TYPE = 2;
    public static final int DEFAULT_TYPE = 0;
    public static final int SYSTEM_TYPE = 1;

    public static int parseLocation(Context context) {
        boolean isLocationSwitchOff = DIDILocationManager.getInstance(context).isLocationSwitchOff();
        int i = !Utils.isLocationPermissionGranted(context) ? 2 : 0;
        if (isLocationSwitchOff) {
            return 1;
        }
        return i;
    }
}

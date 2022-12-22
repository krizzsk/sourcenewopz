package com.didi.map.global.model.location;

import android.content.Context;
import com.didi.common.map.model.GpsLocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import java.util.ArrayList;
import java.util.List;

public class LocationHelper {
    public static void registerListener(Context context, DIDILocationUpdateOption.IntervalMode intervalMode, DIDILocationListener dIDILocationListener) {
        DIDILocationManager instance = DIDILocationManager.getInstance(context);
        if (instance != null) {
            DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
            defaultLocationUpdateOption.setModuleKey("didi.map.global.common.model");
            defaultLocationUpdateOption.setInterval(intervalMode);
            instance.setCoordinateType(0);
            instance.setOnlyOSLocationAbroad(true);
            instance.removeLocationUpdates(dIDILocationListener);
            instance.requestLocationUpdates(dIDILocationListener, defaultLocationUpdateOption);
        }
    }

    public static boolean checkIsNLPEnable(NLPParam nLPParam) {
        if (nLPParam == null || nLPParam.getCallFrom() == null) {
            return false;
        }
        return nLPParam.isNlpEnable();
    }

    public static void unRegisterListener(Context context, DIDILocationListener dIDILocationListener) {
        DIDILocationManager instance = DIDILocationManager.getInstance(context);
        if (instance != null) {
            instance.removeLocationUpdates(dIDILocationListener);
        }
    }

    public static DIDILocation getLastKnownLocation(Context context) {
        DIDILocationManager instance = DIDILocationManager.getInstance(context);
        if (instance != null) {
            return instance.getLastKnownLocation();
        }
        return null;
    }

    public static GpsLocation DIDILocation2GpsLocation(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return null;
        }
        GpsLocation gpsLocation = new GpsLocation();
        gpsLocation.provider = dIDILocation.getProvider();
        gpsLocation.time = dIDILocation.getTime();
        gpsLocation.accuracy = (int) dIDILocation.getAccuracy();
        gpsLocation.direction = dIDILocation.getBearing();
        gpsLocation.altitude = dIDILocation.getAltitude();
        gpsLocation.latitude = dIDILocation.getLatitude();
        gpsLocation.longitude = dIDILocation.getLongitude();
        gpsLocation.velocity = dIDILocation.getSpeed();
        return gpsLocation;
    }

    public static List<GpsLocation> DIDILocations2GpsLocations(List<DIDILocation> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DIDILocation DIDILocation2GpsLocation : list) {
            arrayList.add(DIDILocation2GpsLocation(DIDILocation2GpsLocation));
        }
        return arrayList;
    }
}

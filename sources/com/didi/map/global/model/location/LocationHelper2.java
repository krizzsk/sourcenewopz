package com.didi.map.global.model.location;

import android.content.Context;
import com.didi.common.map.model.GpsLocation;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import java.util.ArrayList;
import java.util.List;

public class LocationHelper2 {

    /* renamed from: a */
    private static NLPLocationListener f27320a;

    /* renamed from: b */
    private static FLPLocationListener f27321b;

    public static void registerListener(Context context, DIDILocationListener dIDILocationListener, LocationRegisterParam locationRegisterParam) {
        if (locationRegisterParam != null) {
            LocationRegisterParam.LocType locType = locationRegisterParam.getLocType();
            if (locType != null) {
                int i = C97711.f27322xb8001039[locType.ordinal()];
                if (i == 1) {
                    m19299b(context, dIDILocationListener, locationRegisterParam);
                } else if (i == 2) {
                    m19297a(context, dIDILocationListener, locationRegisterParam);
                }
            } else {
                m19297a(context, dIDILocationListener, locationRegisterParam);
            }
        } else {
            m19297a(context, dIDILocationListener, new LocationRegisterParam(m19296a((LocationRegisterParam) null), LocationRegisterParam.LocType.NLP));
        }
    }

    /* renamed from: com.didi.map.global.model.location.LocationHelper2$1 */
    static /* synthetic */ class C97711 {

        /* renamed from: $SwitchMap$com$didi$map$global$model$location$LocationRegisterParam$LocType */
        static final /* synthetic */ int[] f27322xb8001039;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.map.global.model.location.LocationRegisterParam$LocType[] r0 = com.didi.map.global.model.location.LocationRegisterParam.LocType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27322xb8001039 = r0
                com.didi.map.global.model.location.LocationRegisterParam$LocType r1 = com.didi.map.global.model.location.LocationRegisterParam.LocType.FLP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27322xb8001039     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.model.location.LocationRegisterParam$LocType r1 = com.didi.map.global.model.location.LocationRegisterParam.LocType.NLP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.model.location.LocationHelper2.C97711.<clinit>():void");
        }
    }

    public static void unRegisterListener(Context context, DIDILocationListener dIDILocationListener) {
        m19298a(dIDILocationListener);
    }

    /* renamed from: a */
    private static void m19297a(Context context, DIDILocationListener dIDILocationListener, LocationRegisterParam locationRegisterParam) {
        if (f27320a == null) {
            f27320a = new NLPLocationListener(locationRegisterParam, context);
        }
        f27320a.updateNlpParam(locationRegisterParam);
        f27320a.registerLocationListener(dIDILocationListener, m19296a(locationRegisterParam));
    }

    /* renamed from: b */
    private static void m19299b(Context context, DIDILocationListener dIDILocationListener, LocationRegisterParam locationRegisterParam) {
        if (f27321b == null) {
            f27321b = new FLPLocationListener(locationRegisterParam, context);
        }
        f27321b.registerLocationListener(dIDILocationListener, m19296a(locationRegisterParam));
    }

    /* renamed from: a */
    private static DIDILocationUpdateOption.IntervalMode m19296a(LocationRegisterParam locationRegisterParam) {
        if (locationRegisterParam == null) {
            return DIDILocationUpdateOption.IntervalMode.NORMAL;
        }
        return locationRegisterParam.getMode();
    }

    /* renamed from: a */
    private static void m19298a(DIDILocationListener dIDILocationListener) {
        NLPLocationListener nLPLocationListener = f27320a;
        if (nLPLocationListener != null) {
            nLPLocationListener.unRegisterLocationListener(dIDILocationListener);
        }
        FLPLocationListener fLPLocationListener = f27321b;
        if (fLPLocationListener != null) {
            fLPLocationListener.unRegisterLocationListener(dIDILocationListener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r1 = com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager.getInstance(r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didichuxing.bigdata.p173dp.locsdk.DIDILocation getLastKnownLocation(android.content.Context r1, com.didi.map.global.model.location.LocationRegisterParam.LocType r2) {
        /*
            com.didi.map.global.model.location.LocationRegisterParam$LocType r0 = com.didi.map.global.model.location.LocationRegisterParam.LocType.NLP
            if (r0 != r2) goto L_0x000d
            com.didi.map.global.model.location.NLPLocationListener r2 = f27320a
            if (r2 == 0) goto L_0x0016
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r2 = r2.getLastKnownLocation()
            goto L_0x0017
        L_0x000d:
            com.didi.map.global.model.location.FLPLocationListener r2 = f27321b
            if (r2 == 0) goto L_0x0016
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r2 = r2.getLastKnownLocation(r1)
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            if (r2 != 0) goto L_0x0023
            com.didichuxing.bigdata.dp.locsdk.DIDILocationManager r1 = com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager.getInstance(r1)
            if (r1 == 0) goto L_0x0023
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r2 = r1.getLastKnownLocation()
        L_0x0023:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.model.location.LocationHelper2.getLastKnownLocation(android.content.Context, com.didi.map.global.model.location.LocationRegisterParam$LocType):com.didichuxing.bigdata.dp.locsdk.DIDILocation");
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

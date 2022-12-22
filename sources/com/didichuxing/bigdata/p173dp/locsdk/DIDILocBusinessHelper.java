package com.didichuxing.bigdata.p173dp.locsdk;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.LocDataDef;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.CellManagerWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.GPSFLPUnifier;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.GpsManager;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.LocationStorage;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.LocationUpdateInternalListener;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.OSNLPManager;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.WifiManagerWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.utils.ApolloProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocBusinessHelper */
public class DIDILocBusinessHelper implements IDIDILocBusinessHelper {

    /* renamed from: a */
    private static final String f45671a = "DIDILocBusinessHelperImpl";

    /* renamed from: b */
    private final int f45672b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Queue<DIDILocation> f45673c;

    /* renamed from: d */
    private LocationUpdateInternalListener f45674d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f45675e;

    /* renamed from: f */
    private Context f45676f;

    private DIDILocBusinessHelper() {
        this.f45672b = 20;
        this.f45673c = new ArrayBlockingQueue(20);
        this.f45674d = new LocationUpdateInternalListener() {
            public void onLocationErr(ErrInfo errInfo, long j) {
            }

            public void onLocationUpdate(DIDILocation dIDILocation, long j) {
                if (DIDILocBusinessHelper.this.f45675e || !DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource())) {
                    if (DIDILocBusinessHelper.this.f45673c.size() == 20) {
                        DIDILocBusinessHelper.this.f45673c.remove();
                    }
                    DIDILocBusinessHelper.this.f45673c.offer(dIDILocation);
                }
            }
        };
        this.f45675e = false;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocBusinessHelper$SingletonHolder */
    private static class SingletonHolder {
        static DIDILocBusinessHelper sInstance = new DIDILocBusinessHelper();

        private SingletonHolder() {
        }
    }

    public static DIDILocBusinessHelper getInstance() {
        return SingletonHolder.sInstance;
    }

    public List<DIDILocation> getRecentEffectiveLocations(int i) {
        ArrayList arrayList = new ArrayList();
        List<DIDILocation> recentLocations = LocationStorage.getInstance().getRecentLocations(i);
        if (recentLocations != null) {
            for (DIDILocation next : recentLocations) {
                if (System.currentTimeMillis() - next.getLocalTime() <= 30000) {
                    arrayList.add(DIDILocation.cloneFrom(next));
                }
            }
        }
        return arrayList;
    }

    public List<DIDILocation> getRecentLocations(int i) {
        ArrayList arrayList = new ArrayList();
        List<DIDILocation> recentLocations = LocationStorage.getInstance().getRecentLocations(i);
        if (recentLocations != null) {
            for (DIDILocation cloneFrom : recentLocations) {
                arrayList.add(DIDILocation.cloneFrom(cloneFrom));
            }
        }
        return arrayList;
    }

    public void init(Context context) {
        this.f45676f = context;
        GPSFLPUnifier.getInstance().addPassiveListener(this.f45674d);
        this.f45675e = ApolloProxy.getInstance().enableInertialVDRAsNormal();
    }

    public void destroy() {
        GPSFLPUnifier.getInstance().removePassiveListener(this.f45674d);
        this.f45675e = false;
    }

    public List<DIDILocation> getRecentGPSLocations(int i) {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.f45673c.toArray(new DIDILocation[0])));
        int size = arrayList.size();
        if (size <= 0) {
            return arrayList;
        }
        if (i >= size) {
            i = size;
        }
        List<DIDILocation> subList = arrayList.subList(size - i, size);
        ArrayList arrayList2 = new ArrayList();
        for (DIDILocation cloneFrom : subList) {
            arrayList2.add(DIDILocation.cloneFrom(cloneFrom));
        }
        return arrayList2;
    }

    public DIDILocation getNewestGeneratedLoc(int i) {
        int nLPCoordinateType = FLPDiffInfoGetter.getInstance().getNLPCoordinateType();
        DIDILocation loadFromGps = DIDILocation.loadFromGps(GpsManager.getInstance().getGPSLocation());
        DIDILocation nLPLocation = OSNLPManager.getInstance().getNLPLocation(nLPCoordinateType);
        DIDILocation lastKnownLocation = LocationStorage.getInstance().getLastKnownLocation();
        if (i == 0) {
            return m32717a(m32717a(lastKnownLocation, loadFromGps), nLPLocation);
        }
        if (i != 1) {
            if (i == 2) {
                if (lastKnownLocation != null && !"gps".equals(lastKnownLocation.getProvider())) {
                    return m32717a(lastKnownLocation, nLPLocation);
                }
                if (nLPLocation != null) {
                    return nLPLocation;
                }
            }
        } else if (lastKnownLocation != null && "gps".equals(lastKnownLocation.getProvider())) {
            return m32717a(lastKnownLocation, loadFromGps);
        } else {
            if (loadFromGps != null) {
                return loadFromGps;
            }
        }
        return null;
    }

    public List<LocDataDef.LocWifiInfo> getCurrentWifiList() {
        return WifiManagerWrapper.getInstance().getValidAPs(true);
    }

    public LocDataDef.LocCellInfo getCurrentCellInfo() {
        return CellManagerWrapper.getInstance().getCurrentCellInfo(this.f45676f);
    }

    /* renamed from: a */
    private DIDILocation m32717a(DIDILocation dIDILocation, DIDILocation dIDILocation2) {
        if (dIDILocation != null && dIDILocation2 != null) {
            return dIDILocation.getLocalTime() > dIDILocation2.getLocalTime() ? dIDILocation : dIDILocation2;
        }
        if (dIDILocation != null) {
            return dIDILocation;
        }
        if (dIDILocation2 != null) {
            return dIDILocation2;
        }
        return null;
    }
}

package com.didi.trackupload.sdk.location;

import android.content.Context;
import android.os.SystemClock;
import com.didi.mapbizinterface.track.MapTrackExtraDataConverter;
import com.didi.trackupload.sdk.core.UploadFlags;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.storage.TrackDataStorage;
import com.didi.trackupload.sdk.utils.ApolloUtils;
import com.didi.trackupload.sdk.utils.LocUtils;
import com.didi.trackupload.sdk.utils.LogStringUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdu.didi.protobuf.MapTrackExtraPointData;
import global.didi.pay.newview.pix.IPixView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LocationCenter {
    public static final String TAG = "TrackLoc";

    /* renamed from: a */
    private ILocationClient f43998a;

    /* renamed from: b */
    private long f43999b;

    /* renamed from: c */
    private long f44000c;

    /* renamed from: d */
    private volatile DIDILocation f44001d;

    /* renamed from: e */
    private TrackLocationInfo f44002e;

    private LocationCenter() {
        this.f44002e = null;
        this.f43998a = new DIDILocationClient();
    }

    public void setSubtitudeLoc(DIDILocation dIDILocation) {
        if (ApolloUtils.isAllowSubtitudeLoc()) {
            this.f44001d = dIDILocation;
            TrackLog.m31343d(TAG, "setSubtitudeLoc " + LogStringUtils.parseDIDILocation(dIDILocation));
        }
    }

    private static class SingletonHolder {
        static final LocationCenter INSTANCE = new LocationCenter();

        private SingletonHolder() {
        }
    }

    public static LocationCenter getIntance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        TrackLog.m31343d(TAG, IPixView.PAGE_STATUS_INIT);
        this.f43998a.init(context);
    }

    public boolean isLocationServiceAlive() {
        return this.f43998a.isLocationServiceAlive();
    }

    public void requestNormalLocationUpdates(TrackLocationListener trackLocationListener, long j) {
        TrackLog.m31343d(TAG, "requestNormalLocationUpdates intervalMillis=" + j);
        this.f43998a.requestNormalLocationUpdates(trackLocationListener, j);
        this.f43999b = j;
    }

    public void removeNormalLocationUpdates() {
        TrackLog.m31343d(TAG, "removeNormalLocationUpdates");
        this.f43998a.removeNormalLocationUpdates();
        this.f43999b = -1;
    }

    public long getNormalLocationUpdateIntervalMillis() {
        return this.f43999b;
    }

    public void requestDirectNotifyLocationUpdates(TrackLocationListener trackLocationListener, long j) {
        TrackLog.m31343d(TAG, "requestDirectNotifyLocationUpdates intervalMillis=" + j);
        this.f43998a.requestDirectNotifyLocationUpdates(trackLocationListener, j);
        this.f44000c = j;
    }

    public void removeDirectNotifyLocationUpdates() {
        TrackLog.m31343d(TAG, "removeDirectNotifyLocationUpdates");
        this.f43998a.removeDirectNotifyLocationUpdates();
        this.f44000c = -1;
    }

    public long getDirectNotifyLocationUpdateIntervalMillis() {
        return this.f44000c;
    }

    public TrackLocationInfo requestLocationOnceSync(long j) {
        TrackLog.m31343d(TAG, "requestLocationOnceSync");
        LocationOnceLatch locationOnceLatch = new LocationOnceLatch();
        this.f43998a.requestLocationUpdateOnce(locationOnceLatch);
        return locationOnceLatch.waitForResult(j);
    }

    public void requestLocationOnceAsync(TrackLocationListener trackLocationListener) {
        TrackLog.m31343d(TAG, "requestLocationOnceAsync");
        this.f43998a.requestLocationUpdateOnce(trackLocationListener);
    }

    public TrackLocationInfo getLastEffectiveLocation() {
        if (this.f44001d != null && LocUtils.isSubtitudeLocEffective(this.f44001d.getLocalTime())) {
            return LocUtils.buildLocationInfo(this.f44001d);
        }
        DIDILocation lastLocation = this.f43998a.getLastLocation();
        if (lastLocation == null || !LocUtils.isLocEffective(lastLocation.getLocalTime())) {
            return null;
        }
        return LocUtils.buildLocationInfo(lastLocation);
    }

    public String getLastError() {
        return this.f43998a.getLastError();
    }

    public List<TrackLocationInfo> getRecentLocations(int i) {
        ArrayList arrayList = new ArrayList();
        List<DIDILocation> recentLocations = this.f43998a.getRecentLocations(i);
        if (recentLocations != null) {
            for (DIDILocation buildLocationInfo : recentLocations) {
                arrayList.add(LocUtils.buildLocationInfo(buildLocationInfo));
            }
        }
        return arrayList;
    }

    private class LocationOnceLatch extends CountDownLatch implements TrackLocationListener {
        TrackLocationInfo mResult = null;

        LocationOnceLatch() {
            super(1);
        }

        /* access modifiers changed from: package-private */
        public TrackLocationInfo waitForResult(long j) {
            try {
                if (await(j, TimeUnit.MILLISECONDS)) {
                    return this.mResult;
                }
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }

        public void onLocationChanged(TrackLocationInfo trackLocationInfo) {
            TrackLog.m31343d(LocationCenter.TAG, "LocationOnceLatch onLocationChanged loc=" + LogStringUtils.parseLocationInfo(trackLocationInfo));
            this.mResult = trackLocationInfo;
            countDown();
        }

        public void onLocationError(int i, String str) {
            TrackLog.m31343d(LocationCenter.TAG, "LocationOnceLatch onLocationError errCode=" + i + " errMsg=" + str);
            countDown();
        }
    }

    public TrackLocationInfo getRetrievedLocInfoRecord() {
        return this.f44002e;
    }

    public TrackLocationInfo retrieveCurrentLocation(long j) {
        this.f44002e = null;
        boolean hasFlag = UploadFlags.hasFlag(j, 4);
        TrackLocationInfo lastEffectiveLocation = getIntance().getLastEffectiveLocation();
        if (lastEffectiveLocation != null) {
            TrackLog.m31343d(TAG, "getLocFromLocCache");
            this.f44002e = new TrackLocationInfo.Builder(lastEffectiveLocation).map_extra_point_data((MapTrackExtraPointData) null).build();
        }
        TrackLocationInfo lastEffectiveLoc = TrackDataStorage.getInstance().getLastEffectiveLoc();
        if (lastEffectiveLoc != null) {
            TrackLog.m31343d(TAG, "getLocFromDBCache");
            this.f44002e = new TrackLocationInfo.Builder(lastEffectiveLoc).map_extra_message_data(MapTrackExtraDataConverter.convert2MessageData(lastEffectiveLoc.map_extra_point_data)).map_extra_point_data((MapTrackExtraPointData) null).build();
        }
        if (hasFlag) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            TrackLocationInfo requestLocationOnceSync = getIntance().requestLocationOnceSync(10000);
            if (requestLocationOnceSync != null) {
                TrackLog.m31343d(TAG, "getLocFromLocOnce timediff=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                this.f44002e = new TrackLocationInfo.Builder(requestLocationOnceSync).map_extra_point_data((MapTrackExtraPointData) null).build();
            }
        }
        if (this.f44002e == null) {
            TrackLog.m31343d(TAG, "getLocFail");
        }
        return this.f44002e;
    }
}

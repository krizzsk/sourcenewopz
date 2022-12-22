package com.sdk.poibase.util;

import android.location.GnssStatus;
import com.sdk.poibase.util.BaseGpsStatusHelper;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/sdk/poibase/util/GpsStatusHelperN$registerGpsStatusListener$gpsListener$1", "Landroid/location/GnssStatus$Callback;", "onFirstFix", "", "ttffMillis", "", "onSatelliteStatusChanged", "status", "Landroid/location/GnssStatus;", "onStarted", "onStopped", "poi_base_lib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GpsStatusHelperN.kt */
public final class GpsStatusHelperN$registerGpsStatusListener$gpsListener$1 extends GnssStatus.Callback {
    final /* synthetic */ BaseGpsStatusHelper.IGpsStatusChanged $listener;

    GpsStatusHelperN$registerGpsStatusListener$gpsListener$1(BaseGpsStatusHelper.IGpsStatusChanged iGpsStatusChanged) {
        this.$listener = iGpsStatusChanged;
    }

    public void onStarted() {
        this.$listener.onStarted();
    }

    public void onStopped() {
        this.$listener.onStopped();
    }

    public void onFirstFix(int i) {
        this.$listener.onFirstFix();
    }

    public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        this.$listener.onSatelliteStatusChanged();
    }
}

package com.sdk.poibase.util;

import android.location.GpsStatus;
import android.location.LocationManager;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.sdk.poibase.util.BaseGpsStatusHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0017J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/sdk/poibase/util/GpsStatusHelperOlder;", "Lcom/sdk/poibase/util/BaseGpsStatusHelper;", "locationManager", "Landroid/location/LocationManager;", "(Landroid/location/LocationManager;)V", "hashMap", "Ljava/util/HashMap;", "Lcom/sdk/poibase/util/BaseGpsStatusHelper$IGpsStatusChanged;", "Landroid/location/GpsStatus$Listener;", "Lkotlin/collections/HashMap;", "registerGpsStatusListener", "", "listener", "unRegisterGpsStatusListener", "poi_base_lib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GpsStatusHelperOlder.kt */
public final class GpsStatusHelperOlder extends BaseGpsStatusHelper {

    /* renamed from: a */
    private final HashMap<BaseGpsStatusHelper.IGpsStatusChanged, GpsStatus.Listener> f56012a = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GpsStatusHelperOlder(LocationManager locationManager) {
        super(locationManager);
        Intrinsics.checkParameterIsNotNull(locationManager, EventConst.Performance.LOCATIONMANAGER);
    }

    public void registerGpsStatusListener(BaseGpsStatusHelper.IGpsStatusChanged iGpsStatusChanged) {
        Intrinsics.checkParameterIsNotNull(iGpsStatusChanged, "listener");
        if (!this.f56012a.containsKey(iGpsStatusChanged)) {
            GpsStatus.Listener gpsStatusHelperOlder$registerGpsStatusListener$gpsListener$1 = new GpsStatusHelperOlder$registerGpsStatusListener$gpsListener$1(iGpsStatusChanged);
            if (getLocationManager().addGpsStatusListener(gpsStatusHelperOlder$registerGpsStatusListener$gpsListener$1)) {
                this.f56012a.put(iGpsStatusChanged, gpsStatusHelperOlder$registerGpsStatusListener$gpsListener$1);
            }
        }
    }

    public void unRegisterGpsStatusListener(BaseGpsStatusHelper.IGpsStatusChanged iGpsStatusChanged) {
        Intrinsics.checkParameterIsNotNull(iGpsStatusChanged, "listener");
        GpsStatus.Listener listener = this.f56012a.get(iGpsStatusChanged);
        if (listener != null) {
            getLocationManager().removeGpsStatusListener(listener);
        }
        this.f56012a.remove(iGpsStatusChanged);
    }
}

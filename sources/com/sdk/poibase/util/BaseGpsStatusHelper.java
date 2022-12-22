package com.sdk.poibase.util;

import android.location.LocationManager;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, mo175978d2 = {"Lcom/sdk/poibase/util/BaseGpsStatusHelper;", "", "locationManager", "Landroid/location/LocationManager;", "(Landroid/location/LocationManager;)V", "getLocationManager", "()Landroid/location/LocationManager;", "registerGpsStatusListener", "", "listener", "Lcom/sdk/poibase/util/BaseGpsStatusHelper$IGpsStatusChanged;", "unRegisterGpsStatusListener", "IGpsStatusChanged", "poi_base_lib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseGpsStatusHelper.kt */
public abstract class BaseGpsStatusHelper {

    /* renamed from: a */
    private final LocationManager f56010a;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/sdk/poibase/util/BaseGpsStatusHelper$IGpsStatusChanged;", "", "onFirstFix", "", "onSatelliteStatusChanged", "onStarted", "onStopped", "poi_base_lib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BaseGpsStatusHelper.kt */
    public interface IGpsStatusChanged {
        void onFirstFix();

        void onSatelliteStatusChanged();

        void onStarted();

        void onStopped();
    }

    public abstract void registerGpsStatusListener(IGpsStatusChanged iGpsStatusChanged);

    public abstract void unRegisterGpsStatusListener(IGpsStatusChanged iGpsStatusChanged);

    public BaseGpsStatusHelper(LocationManager locationManager) {
        Intrinsics.checkParameterIsNotNull(locationManager, EventConst.Performance.LOCATIONMANAGER);
        this.f56010a = locationManager;
    }

    /* access modifiers changed from: protected */
    public final LocationManager getLocationManager() {
        return this.f56010a;
    }
}

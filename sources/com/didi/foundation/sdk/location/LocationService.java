package com.didi.foundation.sdk.location;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.Config;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.io.File;

public final class LocationService implements LocationServiceProvider {

    /* renamed from: a */
    private final LocationServiceProvider f21217a;

    private LocationService() {
        this.f21217a = (LocationServiceProvider) ServiceLoader.load(LocationServiceProvider.class).get();
    }

    public static final LocationService getInstance() {
        return Singleton.INSTANCE;
    }

    public final void initLocationManager(Context context) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            locationServiceProvider.initLocationManager(context);
        }
    }

    public final void requestOnceLocation(DIDILocationListener dIDILocationListener) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            locationServiceProvider.requestOnceLocation(dIDILocationListener);
        }
    }

    public final LocationServiceProvider registerLocationListener(BaseLocationListener baseLocationListener) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.registerLocationListener(baseLocationListener);
        }
        return null;
    }

    public final LocationServiceProvider unRegisterLocationListener(BaseLocationListener baseLocationListener) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.unRegisterLocationListener(baseLocationListener);
        }
        return null;
    }

    public final LocationServiceProvider startLocation(Context context) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.startLocation(context);
        }
        return null;
    }

    public final DIDILocation getLastKnownLocation() {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.getLastKnownLocation();
        }
        return null;
    }

    public final double getLatitude() {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.getLatitude();
        }
        return 0.0d;
    }

    public final double getLongitude() {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.getLongitude();
        }
        return 0.0d;
    }

    public final LocationServiceProvider setLocateMode(Config.LocateMode locateMode) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.setLocateMode(locateMode);
        }
        return null;
    }

    public final LocationServiceProvider setInterval(DIDILocationUpdateOption.IntervalMode intervalMode) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.setInterval(intervalMode);
        }
        return null;
    }

    public final LocationServiceProvider setCoordinateType(int i) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.setCoordinateType(i);
        }
        return null;
    }

    public final LocationServiceProvider stopLocation() {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.stopLocation();
        }
        return null;
    }

    public final LocationServiceProvider enableMock(boolean z) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.enableMock(z);
        }
        return null;
    }

    public final boolean isMockEnabled() {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        return locationServiceProvider != null && locationServiceProvider.isMockEnabled();
    }

    public final LocationServiceProvider setLogPath(File file) {
        LocationServiceProvider locationServiceProvider = this.f21217a;
        if (locationServiceProvider != null) {
            return locationServiceProvider.setLogPath(file);
        }
        return null;
    }

    private static final class Singleton {
        static final LocationService INSTANCE = new LocationService();

        private Singleton() {
        }
    }
}

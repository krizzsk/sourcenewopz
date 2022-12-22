package com.didi.foundation.sdk.location;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.Config;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;
import java.io.File;

@ServiceProviderInterface
public interface LocationServiceProvider {
    LocationServiceProvider enableMock(boolean z);

    DIDILocation getLastKnownLocation();

    double getLatitude();

    double getLongitude();

    void initLocationManager(Context context);

    boolean isMockEnabled();

    LocationServiceProvider registerLocationListener(BaseLocationListener baseLocationListener);

    void requestOnceLocation(DIDILocationListener dIDILocationListener);

    LocationServiceProvider setCoordinateType(int i);

    LocationServiceProvider setInterval(DIDILocationUpdateOption.IntervalMode intervalMode);

    LocationServiceProvider setLocateMode(Config.LocateMode locateMode);

    LocationServiceProvider setLogPath(File file);

    LocationServiceProvider startLocation(Context context);

    LocationServiceProvider stopLocation();

    LocationServiceProvider unRegisterLocationListener(BaseLocationListener baseLocationListener);
}

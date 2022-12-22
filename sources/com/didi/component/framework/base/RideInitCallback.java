package com.didi.component.framework.base;

import android.content.Context;
import com.didi.component.business.secondconf.RideConfImpl;
import com.didi.sdk.app.business.BusinessInitCallback;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.p153v2.SecondConfProxy;
import com.didi.sdk.oneconf.OneConfStore;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "ride", value = {BusinessInitCallback.class})
public class RideInitCallback extends BusinessInitCallback {
    public void onSyncInit(Context context) {
        SecondConfProxy.getInstance().addSecondConf("ride", RideConfImpl.getInstance());
    }

    public void onSwitchToBusiness(Context context, String str) {
        m9488a();
    }

    /* renamed from: a */
    private void m9488a() {
        RideConfImpl instance = RideConfImpl.getInstance();
        DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
        if (lastLocation != null) {
            instance.getSecConfigFromNet(lastLocation.getLongitude(), lastLocation.getLatitude(), OneConfStore.getInstance().getCityId());
        }
    }
}

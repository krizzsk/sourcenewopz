package com.compatible.old.topbar;

import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.oneconf.OneConfStore;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"com/compatible/old/topbar/OneConfManager$locationChangedListener$1", "Lcom/didi/sdk/map/ILocation$ILocationChangedListener;", "mLastDiDiLocation", "Lcom/didichuxing/bigdata/dp/locsdk/DIDILocation;", "onLocationChanged", "", "location", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OneConfManager.kt */
public final class OneConfManager$locationChangedListener$1 implements ILocation.ILocationChangedListener {
    private DIDILocation mLastDiDiLocation;

    OneConfManager$locationChangedListener$1() {
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        Intrinsics.checkNotNullParameter(dIDILocation, "location");
        if (ActivityLifecycleManager.getInstance().isAppActive()) {
            DIDILocation dIDILocation2 = this.mLastDiDiLocation;
            if (dIDILocation2 == null || dIDILocation.distanceTo(dIDILocation2) > 200.0d) {
                OneConfStore.getInstance().getOneConf(DIDIApplication.getAppContext(), dIDILocation.getLatitude(), dIDILocation.getLongitude());
                this.mLastDiDiLocation = dIDILocation;
            }
        }
    }
}

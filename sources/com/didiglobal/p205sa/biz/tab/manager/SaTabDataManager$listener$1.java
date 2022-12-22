package com.didiglobal.p205sa.biz.tab.manager;

import com.didi.sdk.map.ILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"com/didiglobal/sa/biz/tab/manager/SaTabDataManager$listener$1", "Lcom/didi/sdk/map/ILocation$ILocationChangedListener;", "lastLocation", "Lcom/didichuxing/bigdata/dp/locsdk/DIDILocation;", "onLocationChanged", "", "location", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabDataManager$listener$1 */
/* compiled from: SaTabDataManager.kt */
public final class SaTabDataManager$listener$1 implements ILocation.ILocationChangedListener {
    private DIDILocation lastLocation;

    SaTabDataManager$listener$1() {
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        if ((dIDILocation != null && dIDILocation.distanceTo(this.lastLocation) > 200.0d) || this.lastLocation == null) {
            SaTabDataManager.INSTANCE.m36697b(SaTabDataManager.f51229c);
            this.lastLocation = dIDILocation;
        }
    }
}

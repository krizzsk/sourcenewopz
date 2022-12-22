package com.didi.map.global.component.line.pax.walkanddropoff;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.excomponent.GuideLine;
import com.didi.raven.config.RavenKey;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u000f"}, mo175978d2 = {"com/didi/map/global/component/line/pax/walkanddropoff/WalkingLine$addLocListener$1", "Lcom/didichuxing/bigdata/dp/locsdk/DIDILocationListener;", "onLocationChanged", "", "location", "Lcom/didichuxing/bigdata/dp/locsdk/DIDILocation;", "onLocationError", "i", "", "errInfo", "Lcom/didichuxing/bigdata/dp/locsdk/ErrInfo;", "onStatusUpdate", "s", "", "s1", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalkingLine.kt */
public final class WalkingLine$addLocListener$1 implements DIDILocationListener {
    final /* synthetic */ WalkingLine this$0;

    WalkingLine$addLocListener$1(WalkingLine walkingLine) {
        this.this$0 = walkingLine;
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        GuideLine access$getMLineA$p;
        Intrinsics.checkNotNullParameter(dIDILocation, "location");
        DLog.m7384d(this.this$0.f25919a, "onLocationChanged ", new Object[0]);
        if (this.this$0.f25925g && (access$getMLineA$p = this.this$0.f25922d) != null) {
            access$getMLineA$p.updateStartPosition(new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude()));
        }
    }

    public void onLocationError(int i, ErrInfo errInfo) {
        Intrinsics.checkNotNullParameter(errInfo, "errInfo");
        DLog.m7384d(this.this$0.f25919a, "：onLocationError", new Object[0]);
    }

    public void onStatusUpdate(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, RavenKey.STACK);
        Intrinsics.checkNotNullParameter(str2, "s1");
        DLog.m7384d(this.this$0.f25919a, "：onStatusUpdate", new Object[0]);
    }
}

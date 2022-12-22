package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.locator.IFLPLocationListener;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GlobalLocationStrategy$1 */
class GlobalLocationStrategy$1 implements IFLPLocationListener {
    final /* synthetic */ C15135b this$0;

    GlobalLocationStrategy$1(C15135b bVar) {
        this.this$0 = bVar;
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        if (this.this$0.f45928f != null) {
            LocNTPHelper.adjustLocTimestampWhenDispatch(dIDILocation);
            this.this$0.f45928f.onLocationUpdate(dIDILocation, 0);
        }
    }
}

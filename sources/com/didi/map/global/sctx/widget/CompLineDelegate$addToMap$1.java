package com.didi.map.global.sctx.widget;

import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didi/map/global/sctx/widget/CompLineDelegate$addToMap$1", "Lcom/didi/map/global/component/line/component/OnLineDrawStatusListener;", "onLineDrawFinished", "", "onLineDrawStart", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CompLineDelegate.kt */
public final class CompLineDelegate$addToMap$1 implements OnLineDrawStatusListener {
    final /* synthetic */ TrafficLineAnimatorOptions $animatorOptions;

    CompLineDelegate$addToMap$1(TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        this.$animatorOptions = trafficLineAnimatorOptions;
    }

    public void onLineDrawStart() {
        TrafficLineAnimatorOptions.TrafficLineAnimatorListener trafficLineAnimatorListener;
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.$animatorOptions;
        if (trafficLineAnimatorOptions != null && (trafficLineAnimatorListener = trafficLineAnimatorOptions.animatorListener) != null) {
            trafficLineAnimatorListener.onStart();
        }
    }

    public void onLineDrawFinished() {
        TrafficLineAnimatorOptions.TrafficLineAnimatorListener trafficLineAnimatorListener;
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.$animatorOptions;
        if (trafficLineAnimatorOptions != null && (trafficLineAnimatorListener = trafficLineAnimatorOptions.animatorListener) != null) {
            trafficLineAnimatorListener.onEnd();
        }
    }
}

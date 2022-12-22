package com.didi.soda.customer.biz.popdialog;

import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didichuxing.foundation.rpc.Rpc;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/customer/biz/popdialog/AFGroupIdManager$Companion$requestGroupIdMap$1", "Lcom/didi/soda/customer/foundation/util/LocationUtil$LocationCallback;", "onLocationError", "", "onLocationSuccess", "location", "Lcom/didi/common/map/model/LatLng;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AFGroupIdManager.kt */
public final class AFGroupIdManager$Companion$requestGroupIdMap$1 implements LocationUtil.LocationCallback {
    final /* synthetic */ Function0<Rpc> $closure;

    AFGroupIdManager$Companion$requestGroupIdMap$1(Function0<? extends Rpc> function0) {
        this.$closure = function0;
    }

    public void onLocationError() {
        this.$closure.invoke();
    }

    public void onLocationSuccess(LatLng latLng) {
        this.$closure.invoke();
    }
}

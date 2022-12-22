package com.didi.soda.customer.coordshop;

import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.soda.customer.foundation.rpc.entity.CoordShopEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/soda/customer/coordshop/RequestCoordShop$doRequestCoordShop$callback$1", "Lcom/didi/soda/customer/foundation/rpc/net/CRpcCallBackWithTraceId;", "Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "serviceTime", "", "traceId", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RequestCoordShop.kt */
public final class RequestCoordShop$doRequestCoordShop$callback$1 extends CRpcCallBackWithTraceId<CoordShopEntity> {
    final /* synthetic */ LiveData<CoordShopInfo> $liveData;
    final /* synthetic */ RequestInfo $requestInfo;

    RequestCoordShop$doRequestCoordShop$callback$1(LiveData<CoordShopInfo> liveData, RequestInfo requestInfo) {
        this.$liveData = liveData;
        this.$requestInfo = requestInfo;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        this.$liveData.setValue(null);
    }

    public void onRpcSuccess(CoordShopEntity coordShopEntity, long j, String str) {
        Intrinsics.checkNotNullParameter(coordShopEntity, "entity");
        Intrinsics.checkNotNullParameter(str, "traceId");
        this.$liveData.setValue(new CoordShopInfo(str, this.$requestInfo, coordShopEntity));
    }
}

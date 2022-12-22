package com.didi.soda.home.topgun.manager;

import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/soda/home/topgun/manager/HomePreLoadFeed$preLoadFeedFeed$callback$1", "Lcom/didi/soda/customer/foundation/rpc/net/CRpcCallBackWithTraceId;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "data", "serviceTime", "", "traceId", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedPreLoad.kt */
public final class HomePreLoadFeed$preLoadFeedFeed$callback$1 extends CRpcCallBackWithTraceId<HomeEntity> {
    final /* synthetic */ HomePreLoadFeed this$0;

    HomePreLoadFeed$preLoadFeedFeed$callback$1(HomePreLoadFeed homePreLoadFeed) {
        this.this$0 = homePreLoadFeed;
    }

    public void onRpcSuccess(HomeEntity homeEntity, long j, String str) {
        Unit unit;
        Intrinsics.checkNotNullParameter(homeEntity, "data");
        Intrinsics.checkNotNullParameter(str, "traceId");
        this.this$0.f43004e = PreLoadStatus.SUCCESS;
        CRpcCallBackWithTraceId access$getResultCallback$p = this.this$0.f43005f;
        if (access$getResultCallback$p == null) {
            unit = null;
        } else {
            access$getResultCallback$p.onRpcSuccess(homeEntity, j, str);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            HomePreLoadFeed homePreLoadFeed = this.this$0;
            homePreLoadFeed.f43000a = homeEntity;
            homePreLoadFeed.f43001b = j;
            homePreLoadFeed.f43002c = str;
        }
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Unit unit;
        super.onRpcFailure(sFRpcException);
        this.this$0.f43004e = PreLoadStatus.FAIL;
        CRpcCallBackWithTraceId access$getResultCallback$p = this.this$0.f43005f;
        if (access$getResultCallback$p == null) {
            unit = null;
        } else {
            access$getResultCallback$p.onRpcFailure(sFRpcException);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.this$0.f43003d = sFRpcException;
        }
    }
}

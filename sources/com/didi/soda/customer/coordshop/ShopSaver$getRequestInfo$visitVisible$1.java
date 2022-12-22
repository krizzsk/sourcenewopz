package com.didi.soda.customer.coordshop;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "info", "Lcom/didi/soda/customer/coordshop/CollectedShopInfo;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopSaver.kt */
final class ShopSaver$getRequestInfo$visitVisible$1 extends Lambda implements Function1<CollectedShopInfo, Boolean> {
    final /* synthetic */ RequestInfo $requestInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopSaver$getRequestInfo$visitVisible$1(RequestInfo requestInfo) {
        super(1);
        this.$requestInfo = requestInfo;
    }

    public final Boolean invoke(CollectedShopInfo collectedShopInfo) {
        Intrinsics.checkNotNullParameter(collectedShopInfo, "info");
        return Boolean.valueOf(this.$requestInfo.getVisibleShopList().add(collectedShopInfo.getShopId()));
    }
}

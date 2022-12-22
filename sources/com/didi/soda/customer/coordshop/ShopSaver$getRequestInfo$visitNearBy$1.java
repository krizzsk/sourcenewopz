package com.didi.soda.customer.coordshop;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "nearByList", "", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopSaver.kt */
final class ShopSaver$getRequestInfo$visitNearBy$1 extends Lambda implements Function1<List<? extends Object>, Unit> {
    final /* synthetic */ RequestInfo $requestInfo;
    final /* synthetic */ ShopSaver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopSaver$getRequestInfo$visitNearBy$1(ShopSaver shopSaver, RequestInfo requestInfo) {
        super(1);
        this.this$0 = shopSaver;
        this.$requestInfo = requestInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends Object>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends Object> list) {
        CollectedShopInfo access$getSaveDataFromModel;
        Intrinsics.checkNotNullParameter(list, "nearByList");
        ShopSaver shopSaver = this.this$0;
        RequestInfo requestInfo = this.$requestInfo;
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if ((next instanceof RecyclerModel) && (access$getSaveDataFromModel = shopSaver.m29023a(i, (RecyclerModel) next, ModelVisitorType.Home)) != null) {
                requestInfo.getNearByShopList().add(RequestInfo.Companion.createCoordShopRequestEntity(access$getSaveDataFromModel));
            }
            i = i2;
        }
    }
}

package com.didi.soda.customer.coordshop;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.util.CollectionUtilsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopSaver.kt */
final class ShopSaver$getCurVisibleShops$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Set<CollectedShopInfo> $set;
    final /* synthetic */ ShopSaver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopSaver$getCurVisibleShops$1(ShopSaver shopSaver, Set<CollectedShopInfo> set) {
        super(1);
        this.this$0 = shopSaver;
        this.$set = set;
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        CollectedShopInfo access$getSaveDataFromModel;
        C13704a access$getCurSession$p = this.this$0.f40854b;
        Intrinsics.checkNotNull(access$getCurSession$p);
        Object safeGet = CollectionUtilsKt.safeGet(access$getCurSession$p.mo102844d(), i);
        if (safeGet != null && (safeGet instanceof RecyclerModel) && (access$getSaveDataFromModel = this.this$0.m29023a(i, (RecyclerModel) safeGet, ModelVisitorType.Home)) != null) {
            Set<CollectedShopInfo> set = this.$set;
            if (set.contains(access$getSaveDataFromModel)) {
                set.remove(access$getSaveDataFromModel);
            }
            set.add(access$getSaveDataFromModel);
        }
    }
}

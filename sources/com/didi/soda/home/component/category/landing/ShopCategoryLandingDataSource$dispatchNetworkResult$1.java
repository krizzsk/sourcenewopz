package com.didi.soda.home.component.category.landing;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeModuleEntity;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didi/soda/home/topgun/manager/HomeFeedParam;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopCategoryLandingDataSource.kt */
final class ShopCategoryLandingDataSource$dispatchNetworkResult$1 extends Lambda implements Function1<HomeFeedParam, Unit> {
    final /* synthetic */ CustomerResource<HomeEntity> $homeEntity;
    final /* synthetic */ String $traceId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopCategoryLandingDataSource$dispatchNetworkResult$1(CustomerResource<HomeEntity> customerResource, String str) {
        super(1);
        this.$homeEntity = customerResource;
        this.$traceId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HomeFeedParam) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(HomeFeedParam homeFeedParam) {
        Intrinsics.checkNotNullParameter(homeFeedParam, "$this$updateParams");
        HomeModuleEntity mFeedEntity = ((HomeEntity) this.$homeEntity.data).getMFeedEntity();
        homeFeedParam.setHasMore(mFeedEntity == null ? false : Intrinsics.areEqual((Object) mFeedEntity.getMHasMore(), (Object) true));
        homeFeedParam.setRecId(TextUtils.isEmpty(((HomeEntity) this.$homeEntity.data).getMRecId()) ? "" : ((HomeEntity) this.$homeEntity.data).getMRecId());
        homeFeedParam.setTraceId(this.$traceId);
    }
}

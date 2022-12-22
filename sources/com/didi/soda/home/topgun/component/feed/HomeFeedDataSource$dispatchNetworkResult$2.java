package com.didi.soda.home.topgun.component.feed;

import com.didi.soda.home.topgun.manager.HomeFeedParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didi/soda/home/topgun/manager/HomeFeedParam;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedDataSource.kt */
final class HomeFeedDataSource$dispatchNetworkResult$2 extends Lambda implements Function1<HomeFeedParam, Unit> {
    public static final HomeFeedDataSource$dispatchNetworkResult$2 INSTANCE = new HomeFeedDataSource$dispatchNetworkResult$2();

    HomeFeedDataSource$dispatchNetworkResult$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HomeFeedParam) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(HomeFeedParam homeFeedParam) {
        Intrinsics.checkNotNullParameter(homeFeedParam, "$this$updateParams");
        homeFeedParam.setHasMore(false);
        homeFeedParam.setRecId("");
        homeFeedParam.setTraceId("");
    }
}

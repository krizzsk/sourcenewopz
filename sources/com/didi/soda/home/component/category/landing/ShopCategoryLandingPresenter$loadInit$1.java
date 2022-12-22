package com.didi.soda.home.component.category.landing;

import com.didi.soda.home.topgun.manager.HomeFeedParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didi/soda/home/topgun/manager/HomeFeedParam;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopCategoryLandingPresenter.kt */
final class ShopCategoryLandingPresenter$loadInit$1 extends Lambda implements Function1<HomeFeedParam, Unit> {
    final /* synthetic */ ShopCategoryLandingPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopCategoryLandingPresenter$loadInit$1(ShopCategoryLandingPresenter shopCategoryLandingPresenter) {
        super(1);
        this.this$0 = shopCategoryLandingPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HomeFeedParam) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(HomeFeedParam homeFeedParam) {
        homeFeedParam.setRecId(this.this$0.f42564d);
        homeFeedParam.setCateId(this.this$0.f42565e);
    }
}

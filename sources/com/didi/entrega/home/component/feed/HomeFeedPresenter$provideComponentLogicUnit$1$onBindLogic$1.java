package com.didi.entrega.home.component.feed;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.home.component.feed.entity.HomeServiceItemEntity;
import com.didi.entrega.home.policy.HomePolicyHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/home/component/feed/HomeFeedPresenter$provideComponentLogicUnit$1$onBindLogic$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity;", "call", "", "item", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedPresenter.kt */
public final class HomeFeedPresenter$provideComponentLogicUnit$1$onBindLogic$1 implements Action1<HomeServiceItemEntity> {
    final /* synthetic */ HomeFeedPresenter this$0;

    HomeFeedPresenter$provideComponentLogicUnit$1$onBindLogic$1(HomeFeedPresenter homeFeedPresenter) {
        this.this$0 = homeFeedPresenter;
    }

    public void call(HomeServiceItemEntity homeServiceItemEntity) {
        if (!LoginUtil.isLogin()) {
            LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 1);
        } else if (homeServiceItemEntity != null) {
            if (!homeServiceItemEntity.isLawChecked()) {
                ToastUtil.showCustomerToast(this.this$0.getScopeContext(), ResourceHelper.getString(R.string.Entrega_Integration__yHZa));
                return;
            }
            HomePolicyHelper access$getMHomePolicyHelper$p = this.this$0.f20647d;
            if (access$getMHomePolicyHelper$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHomePolicyHelper");
                access$getMHomePolicyHelper$p = null;
            }
            access$getMHomePolicyHelper$p.savePolicyAcceptedState();
            if (homeServiceItemEntity.isUnavailable()) {
                this.this$0.m15104a(homeServiceItemEntity);
            } else {
                this.this$0.openPlaceOrderPage(homeServiceItemEntity);
            }
            LogUtil.m14765i(this.this$0.f20652i, "provideComponentLogicUnit");
        }
    }
}

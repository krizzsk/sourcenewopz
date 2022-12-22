package com.didi.soda.home.topgun.binder;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.home.manager.LandingLogicModel;
import com.didi.soda.home.manager.LandinglogicRepo;
import com.didi.soda.home.topgun.binder.HomeHeaderItemLogicRepo;
import com.didi.soda.home.topgun.component.topicact.TopicActivityPresenter;
import com.didi.soda.home.topgun.manager.FilterNoResultLogicRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/LandingLogicUnit;", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "presenter", "Lcom/didi/soda/home/topgun/component/topicact/TopicActivityPresenter;", "(Lcom/didi/soda/home/topgun/component/topicact/TopicActivityPresenter;)V", "dealFilterLogic", "", "logicType", "", "dealHeaderLogic", "logicModel", "Lcom/didi/soda/home/topgun/binder/HomeHeaderItemLogicRepo$LogicModel;", "dealLogic", "landingLogicModel", "Lcom/didi/soda/home/manager/LandingLogicModel;", "onBindLogic", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LandingLogicUnit.kt */
public final class LandingLogicUnit extends ComponentLogicUnit {

    /* renamed from: a */
    private TopicActivityPresenter f42763a;

    public LandingLogicUnit(TopicActivityPresenter topicActivityPresenter) {
        Intrinsics.checkNotNullParameter(topicActivityPresenter, "presenter");
        this.f42763a = topicActivityPresenter;
    }

    public void onBindLogic() {
        if (this.f42763a.getScopeContext() != null) {
            ((LandinglogicRepo) getLogic(LandinglogicRepo.class)).subscribe(this.f42763a.getScopeContext(), new Action1() {
                public final void call(Object obj) {
                    LandingLogicUnit.m30199a(LandingLogicUnit.this, (LandingLogicModel) obj);
                }
            });
        }
        ((HomeHeaderItemLogicRepo) getLogic(HomeHeaderItemLogicRepo.class)).subscribe(this.f42763a.getScopeContext(), new Action1() {
            public final void call(Object obj) {
                LandingLogicUnit.m30200a(LandingLogicUnit.this, (HomeHeaderItemLogicRepo.LogicModel) obj);
            }
        });
        ((FilterNoResultLogicRepo) getLogic(FilterNoResultLogicRepo.class)).subscribe(this.f42763a.getScopeContext(), new Action1() {
            public final void call(Object obj) {
                LandingLogicUnit.m30201a(LandingLogicUnit.this, (Integer) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30199a(LandingLogicUnit landingLogicUnit, LandingLogicModel landingLogicModel) {
        Intrinsics.checkNotNullParameter(landingLogicUnit, "this$0");
        if (landingLogicModel != null) {
            landingLogicUnit.m30197a(landingLogicModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30200a(LandingLogicUnit landingLogicUnit, HomeHeaderItemLogicRepo.LogicModel logicModel) {
        Intrinsics.checkNotNullParameter(landingLogicUnit, "this$0");
        landingLogicUnit.m30198a(logicModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30201a(LandingLogicUnit landingLogicUnit, Integer num) {
        Intrinsics.checkNotNullParameter(landingLogicUnit, "this$0");
        Intrinsics.checkNotNull(num);
        Intrinsics.checkNotNullExpressionValue(num, "integer!!");
        landingLogicUnit.m30196a(num.intValue());
    }

    /* renamed from: a */
    private final void m30197a(LandingLogicModel landingLogicModel) {
        TabInfoEntity tabInfo;
        if (TextUtils.equals(landingLogicModel.mType, LandinglogicRepo.LOGIC_TYPE_ON_TAB_CLICK) && (tabInfo = landingLogicModel.getTabInfo()) != null) {
            this.f42763a.onTabSwitched(tabInfo);
        }
    }

    /* renamed from: a */
    private final void m30196a(int i) {
        if (i == 1) {
            this.f42763a.resetFilter();
        }
    }

    /* renamed from: a */
    private final void m30198a(HomeHeaderItemLogicRepo.LogicModel logicModel) {
        if (logicModel != null && TextUtils.equals(HomeHeaderItemLogicRepo.TYPE_ON_FILTER_ITEM_CLICK, logicModel.mType)) {
            this.f42763a.notifyFilterItemClick(logicModel.filterModel, logicModel.isFloating());
        }
    }
}

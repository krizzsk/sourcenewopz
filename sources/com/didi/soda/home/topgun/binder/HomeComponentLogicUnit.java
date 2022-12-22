package com.didi.soda.home.topgun.binder;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.home.topgun.binder.HomeHeaderItemLogicRepo;
import com.didi.soda.home.topgun.component.feed.HomeFeedPresenter;
import com.didi.soda.home.topgun.manager.FilterNoResultLogicRepo;

public class HomeComponentLogicUnit extends ComponentLogicUnit {

    /* renamed from: a */
    private HomeFeedPresenter f42752a;

    public HomeComponentLogicUnit(HomeFeedPresenter homeFeedPresenter) {
        this.f42752a = homeFeedPresenter;
    }

    public void onBindLogic() {
        ((HomeHeaderItemLogicRepo) getLogic(HomeHeaderItemLogicRepo.class)).subscribe(this.f42752a.getScopeContext(), new Action1<HomeHeaderItemLogicRepo.LogicModel>() {
            public void call(HomeHeaderItemLogicRepo.LogicModel logicModel) {
                HomeComponentLogicUnit.this.m30184a(logicModel);
            }
        });
        ((FilterNoResultLogicRepo) getLogic(FilterNoResultLogicRepo.class)).subscribe(this.f42752a.getScopeContext(), new Action1<Integer>() {
            public void call(Integer num) {
                HomeComponentLogicUnit.this.m30185a(num);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30185a(Integer num) {
        if (num.intValue() == 1) {
            this.f42752a.resetFilter();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30184a(HomeHeaderItemLogicRepo.LogicModel logicModel) {
        if (logicModel != null && TextUtils.equals(HomeHeaderItemLogicRepo.TYPE_ON_FILTER_ITEM_CLICK, logicModel.mType)) {
            this.f42752a.notifyFilterItemClick(logicModel.filterModel, logicModel.isFloating());
        }
    }
}

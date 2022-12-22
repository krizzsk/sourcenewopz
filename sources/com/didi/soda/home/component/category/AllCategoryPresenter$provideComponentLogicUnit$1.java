package com.didi.soda.home.component.category;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.home.binder.model.AllCategoryItemModel;
import com.didi.soda.home.manager.AllCategoryLogicRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/home/component/category/AllCategoryPresenter$provideComponentLogicUnit$1", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "onBindLogic", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AllCategoryPresenter.kt */
public final class AllCategoryPresenter$provideComponentLogicUnit$1 extends ComponentLogicUnit {
    final /* synthetic */ AllCategoryPresenter this$0;

    AllCategoryPresenter$provideComponentLogicUnit$1(AllCategoryPresenter allCategoryPresenter) {
        this.this$0 = allCategoryPresenter;
    }

    public void onBindLogic() {
        ((AllCategoryLogicRepo) getLogic(AllCategoryLogicRepo.class)).subscribe(this.this$0.getScopeContext(), new Action1() {
            public final void call(Object obj) {
                AllCategoryPresenter$provideComponentLogicUnit$1.m46931onBindLogic$lambda0(AllCategoryPresenter.this, (AllCategoryItemModel) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindLogic$lambda-0  reason: not valid java name */
    public static final void m46931onBindLogic$lambda0(AllCategoryPresenter allCategoryPresenter, AllCategoryItemModel allCategoryItemModel) {
        Intrinsics.checkNotNullParameter(allCategoryPresenter, "this$0");
        allCategoryPresenter.m29996a(allCategoryItemModel);
    }
}

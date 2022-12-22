package com.didi.soda.business.component.dynamic.category;

import com.didi.soda.business.manager.BusinessOmegaHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/soda/business/manager/BusinessOmegaHelper;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDyCategoryPresenter.kt */
final class BusinessDyCategoryPresenter$omegaHelper$2 extends Lambda implements Function0<BusinessOmegaHelper> {
    final /* synthetic */ BusinessDyCategoryPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessDyCategoryPresenter$omegaHelper$2(BusinessDyCategoryPresenter businessDyCategoryPresenter) {
        super(0);
        this.this$0 = businessDyCategoryPresenter;
    }

    public final BusinessOmegaHelper invoke() {
        return new BusinessOmegaHelper(this.this$0.getScopeContext(), this.this$0.f39458c, this.this$0.f39461f);
    }
}

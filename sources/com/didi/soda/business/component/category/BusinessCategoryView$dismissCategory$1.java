package com.didi.soda.business.component.category;

import com.didi.soda.business.component.category.Contract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessCategoryView.kt */
final class BusinessCategoryView$dismissCategory$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $selectedIndex;
    final /* synthetic */ BusinessCategoryView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessCategoryView$dismissCategory$1(BusinessCategoryView businessCategoryView, int i) {
        super(0);
        this.this$0 = businessCategoryView;
        this.$selectedIndex = i;
    }

    public final void invoke() {
        ((Contract.AbsCategoryPresenter) this.this$0.getPresenter()).dismissCategory();
        Integer valueOf = Integer.valueOf(this.$selectedIndex);
        if (!(valueOf.intValue() >= 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            ((Contract.AbsCategoryPresenter) this.this$0.getPresenter()).selectedCategory(valueOf.intValue());
        }
    }
}

package com.didi.soda.business.component.category;

import android.view.View;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/soda/business/component/category/CategoryAnimator;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessCategoryView.kt */
final class BusinessCategoryView$categoryAnimator$2 extends Lambda implements Function0<CategoryAnimator> {
    final /* synthetic */ BusinessCategoryView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessCategoryView$categoryAnimator$2(BusinessCategoryView businessCategoryView) {
        super(0);
        this.this$0 = businessCategoryView;
    }

    public final CategoryAnimator invoke() {
        NovaRecyclerView access$getRecyclerView$p = this.this$0.f39381a;
        View view = null;
        if (access$getRecyclerView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            access$getRecyclerView$p = null;
        }
        View view2 = access$getRecyclerView$p;
        View access$getBackgroundView$p = this.this$0.f39382b;
        if (access$getBackgroundView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
        } else {
            view = access$getBackgroundView$p;
        }
        return new CategoryAnimator(view2, view);
    }
}

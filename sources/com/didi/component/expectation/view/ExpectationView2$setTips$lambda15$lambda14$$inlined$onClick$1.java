package com.didi.component.expectation.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.expectation.AbsExpectationPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/didiglobal/travel/infra/view/ViewKt$onClick$1"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* renamed from: com.didi.component.expectation.view.ExpectationView2$setTips$lambda-15$lambda-14$$inlined$onClick$1  reason: invalid class name */
/* compiled from: View.kt */
public final class ExpectationView2$setTips$lambda15$lambda14$$inlined$onClick$1 implements View.OnClickListener {
    final /* synthetic */ String $act$inlined;
    final /* synthetic */ ExpectationView2 this$0;

    public ExpectationView2$setTips$lambda15$lambda14$$inlined$onClick$1(ExpectationView2 expectationView2, String str) {
        this.this$0 = expectationView2;
        this.$act$inlined = str;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        AbsExpectationPresenter access$getPresenter$p = this.this$0.f13690d;
        if (access$getPresenter$p != null) {
            access$getPresenter$p.iconClick(this.$act$inlined);
        }
    }
}

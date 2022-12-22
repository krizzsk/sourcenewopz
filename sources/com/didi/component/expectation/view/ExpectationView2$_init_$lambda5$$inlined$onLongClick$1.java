package com.didi.component.expectation.view;

import android.view.View;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/didiglobal/travel/infra/view/ViewKt$onLongClick$1"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* renamed from: com.didi.component.expectation.view.ExpectationView2$_init_$lambda-5$$inlined$onLongClick$1  reason: invalid class name */
/* compiled from: View.kt */
public final class ExpectationView2$_init_$lambda5$$inlined$onLongClick$1 implements View.OnLongClickListener {
    final /* synthetic */ ExpectationView2 this$0;

    public ExpectationView2$_init_$lambda5$$inlined$onLongClick$1(ExpectationView2 expectationView2) {
        this.this$0 = expectationView2;
    }

    public final boolean onLongClick(View view) {
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        ExpectationView2 expectationView2 = this.this$0;
        expectationView2.updateViewByIndriver(!expectationView2.f13693g, false, 500, (IXpCompRefresh.IXpCompRefreshCb) null);
        return true;
    }
}

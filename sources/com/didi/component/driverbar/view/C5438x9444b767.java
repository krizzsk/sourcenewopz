package com.didi.component.driverbar.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/didiglobal/travel/infra/view/ViewKt$onClick$1"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* renamed from: com.didi.component.driverbar.view.DriverBarWaitingJapanStyleView$inflateView$lambda-2$$inlined$onClick$1 */
/* compiled from: View.kt */
public final class C5438x9444b767 implements View.OnClickListener {
    final /* synthetic */ DriverBarWaitingJapanStyleView this$0;

    public C5438x9444b767(DriverBarWaitingJapanStyleView driverBarWaitingJapanStyleView) {
        this.this$0 = driverBarWaitingJapanStyleView;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        this.this$0.dispatchDriverClicked(TuplesKt.m42317to("type", "2"));
    }
}

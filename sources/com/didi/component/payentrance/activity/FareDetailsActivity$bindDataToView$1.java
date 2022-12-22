package com.didi.component.payentrance.activity;

import android.content.Context;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.payentrance.model.FareInfoItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FareDetailsActivity.kt */
final class FareDetailsActivity$bindDataToView$1 implements View.OnClickListener {
    final /* synthetic */ FareInfoItem $item;
    final /* synthetic */ FareDetailsActivity this$0;

    FareDetailsActivity$bindDataToView$1(FareDetailsActivity fareDetailsActivity, FareInfoItem fareInfoItem) {
        this.this$0 = fareDetailsActivity;
        this.$item = fareInfoItem;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        FareDetailsActivity fareDetailsActivity = this.this$0;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        fareDetailsActivity.m10678a(context, this.$item.getCarOrder());
    }
}

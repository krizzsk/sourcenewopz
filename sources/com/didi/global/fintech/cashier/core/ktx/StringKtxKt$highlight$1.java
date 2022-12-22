package com.didi.global.fintech.cashier.core.ktx;

import android.text.style.ClickableSpan;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/global/fintech/cashier/core/ktx/StringKtxKt$highlight$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StringKtx.kt */
public final class StringKtxKt$highlight$1 extends ClickableSpan {
    final /* synthetic */ int $curIndex;
    final /* synthetic */ TextClickCallback $onClick;

    StringKtxKt$highlight$1(TextClickCallback textClickCallback, int i) {
        this.$onClick = textClickCallback;
        this.$curIndex = i;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkNotNullParameter(view, "widget");
        this.$onClick.onClick(this.$curIndex);
    }
}

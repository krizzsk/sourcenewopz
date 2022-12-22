package com.didi.global.fintech.cashier.fastpay.view;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.p117ui.viewholder.FastPaySettingContentViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingContentViewHolder;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySettingView.kt */
final class FastPaySettingView$mContentViewHolder$2 extends Lambda implements Function0<FastPaySettingContentViewHolder> {
    final /* synthetic */ FastPaySettingView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FastPaySettingView$mContentViewHolder$2(FastPaySettingView fastPaySettingView) {
        super(0);
        this.this$0 = fastPaySettingView;
    }

    public final FastPaySettingContentViewHolder invoke() {
        FastPaySettingContentViewHolder.Companion companion = FastPaySettingContentViewHolder.Companion;
        Context access$getMContext$p = this.this$0.f21597a;
        ViewGroup access$getMContentView$p = this.this$0.f21600d;
        Intrinsics.checkNotNullExpressionValue(access$getMContentView$p, "mContentView");
        return companion.newInstance(access$getMContext$p, access$getMContentView$p);
    }
}

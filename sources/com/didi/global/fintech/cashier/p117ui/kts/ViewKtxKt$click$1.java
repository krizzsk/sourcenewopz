package com.didi.global.fintech.cashier.p117ui.kts;

import android.view.View;
import com.didi.global.fintech.cashier.p117ui.util.DoubleCheckOnClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/global/fintech/cashier/ui/kts/ViewKtxKt$click$1", "Lcom/didi/global/fintech/cashier/ui/util/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.kts.ViewKtxKt$click$1 */
/* compiled from: ViewKtx.kt */
public final class ViewKtxKt$click$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ Function1<View, Unit> $block;
    final /* synthetic */ long $duration;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewKtxKt$click$1(Function1<? super View, Unit> function1, long j) {
        super(j);
        this.$block = function1;
        this.$duration = j;
    }

    public void doClick(View view) {
        this.$block.invoke(view);
    }
}

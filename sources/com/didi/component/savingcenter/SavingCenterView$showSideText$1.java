package com.didi.component.savingcenter;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SavingCenterView.kt */
final class SavingCenterView$showSideText$1 implements Runnable {
    final /* synthetic */ Integer $hideDelay;
    final /* synthetic */ SavingCenterView this$0;

    SavingCenterView$showSideText$1(SavingCenterView savingCenterView, Integer num) {
        this.this$0 = savingCenterView;
        this.$hideDelay = num;
    }

    public final void run() {
        this.this$0.play(this.$hideDelay);
    }
}

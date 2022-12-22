package com.didi.component.openride.newscan;

import com.didi.component.openride.widget.OpenRideDriverInfoPopWin;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalOpenRideDriverInfoConfirmFragment.kt */
final class GlobalOpenRideDriverInfoConfirmFragment$initData$2 implements Runnable {
    final /* synthetic */ GlobalOpenRideDriverInfoConfirmFragment this$0;

    GlobalOpenRideDriverInfoConfirmFragment$initData$2(GlobalOpenRideDriverInfoConfirmFragment globalOpenRideDriverInfoConfirmFragment) {
        this.this$0 = globalOpenRideDriverInfoConfirmFragment;
    }

    public final void run() {
        OpenRideDriverInfoPopWin access$getMPop$p = this.this$0.f14729a;
        if (access$getMPop$p != null) {
            access$getMPop$p.show();
        }
    }
}

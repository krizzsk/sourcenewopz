package com.didi.component.openride.newscan;

import com.didi.global.loading.Loading;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalOpenRideCodeInputFragment.kt */
final class GlobalOpenRideCodeInputFragment$showRequestLoadingDialog$1 implements Runnable {
    final /* synthetic */ GlobalOpenRideCodeInputFragment this$0;

    GlobalOpenRideCodeInputFragment$showRequestLoadingDialog$1(GlobalOpenRideCodeInputFragment globalOpenRideCodeInputFragment) {
        this.this$0 = globalOpenRideCodeInputFragment;
    }

    public final void run() {
        if (this.this$0.getContext() != null && !this.this$0.isDetached()) {
            Loading.make(this.this$0.getContext(), this.this$0.f14723a).show();
        }
    }
}

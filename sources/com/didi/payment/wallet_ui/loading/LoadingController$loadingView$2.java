package com.didi.payment.wallet_ui.loading;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoadingController.kt */
final class LoadingController$loadingView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ LoadingController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadingController$loadingView$2(LoadingController loadingController) {
        super(0);
        this.this$0 = loadingController;
    }

    public final View invoke() {
        if (this.this$0.f33011b.getLoadingLayoutId() == 0) {
            return this.this$0.f33011b.getLoadingLayoutView();
        }
        return View.inflate(this.this$0.f33010a.getContext(), this.this$0.f33011b.getLoadingLayoutId(), (ViewGroup) null);
    }
}

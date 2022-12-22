package com.didi.soda.home.foster;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/home/foster/Foster$addGlobalLayoutListener$lis$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Foster.kt */
public final class Foster$addGlobalLayoutListener$lis$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ View $view;

    Foster$addGlobalLayoutListener$lis$1(View view) {
        this.$view = view;
    }

    public void onGlobalLayout() {
        this.$view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        Foster.INSTANCE.m30119a(this.$view);
    }
}

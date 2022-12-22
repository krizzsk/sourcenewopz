package com.didiglobal.pay.paysecure.prepaidcard.loading;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingRenderType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/loading/LineLoading;", "Lcom/didiglobal/pay/paysecure/prepaidcard/loading/ILoading;", "()V", "hideLoading", "", "showLoading", "context", "Landroidx/fragment/app/FragmentActivity;", "view", "Landroid/view/View;", "msg", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LineLoading.kt */
public final class LineLoading implements ILoading {
    public void showLoading(FragmentActivity fragmentActivity, View view, String str) {
        Intrinsics.checkParameterIsNotNull(fragmentActivity, "context");
        if (view != null) {
            Loading.make(view.getContext(), LoadingRenderType.ANIMATION, view, true).show();
        }
    }

    public void hideLoading() {
        Loading.hide();
    }
}

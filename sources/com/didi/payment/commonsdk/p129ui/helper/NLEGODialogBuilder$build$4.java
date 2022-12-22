package com.didi.payment.commonsdk.p129ui.helper;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/commonsdk/ui/helper/NLEGODialogBuilder$build$4", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "view", "Landroid/view/View;", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.helper.NLEGODialogBuilder$build$4 */
/* compiled from: NLEGODialogBuilder.kt */
public final class NLEGODialogBuilder$build$4 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ NLEGODialogBuilder this$0;

    NLEGODialogBuilder$build$4(NLEGODialogBuilder nLEGODialogBuilder) {
        this.this$0 = nLEGODialogBuilder;
    }

    public void onAntiShakeClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        DoubleCheckOnClickListener negativeBtnClickListener = this.this$0.getNegativeBtnClickListener();
        if (negativeBtnClickListener != null) {
            negativeBtnClickListener.doClick(view);
        }
    }
}

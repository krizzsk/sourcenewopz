package com.didi.payment.commonsdk.fragment;

import android.view.View;
import android.widget.TextView;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.fragment.QRDetectedDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/commonsdk/fragment/QRDetectedDialog$initView$3", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: QRDetectedDialog.kt */
public final class QRDetectedDialog$initView$3 extends DoubleCheckOnClickListener {
    final /* synthetic */ QRDetectedDialog<T> this$0;

    QRDetectedDialog$initView$3(QRDetectedDialog<T> qRDetectedDialog) {
        this.this$0 = qRDetectedDialog;
    }

    public void doClick(View view) {
        QRDetectedDialog.DialogBtnClicikListener innerClickListener = this.this$0.getInnerClickListener();
        if (innerClickListener != null) {
            QRDetectedDialog<T> qRDetectedDialog = this.this$0;
            qRDetectedDialog.dismiss();
            TextView access$getNegativeBtnTv$p = qRDetectedDialog.f30154b;
            if (access$getNegativeBtnTv$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("negativeBtnTv");
                access$getNegativeBtnTv$p = null;
            }
            innerClickListener.onNegativeClicked(access$getNegativeBtnTv$p);
        }
    }
}

package com.didi.soda.bill.widgets.notify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/bill/widgets/notify/DefaultNotifyView;", "Lcom/didi/soda/bill/widgets/notify/NotifyHolder;", "()V", "content", "", "notifyPreparedCompleted", "Lkotlin/Function0;", "", "view", "Landroid/view/View;", "getView", "parent", "Landroid/view/ViewGroup;", "isPrepared", "", "block", "requestAlertInfo", "shopId", "cartId", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DefaultNotifyView.kt */
public final class DefaultNotifyView implements NotifyHolder {

    /* renamed from: a */
    private View f39310a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f39311b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Function0<Unit> f39312c;

    public View getView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (this.f39310a == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_widget_bill_notify, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…ll_notify, parent, false)");
            this.f39310a = inflate;
        }
        View view = this.f39310a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view = null;
        }
        ((TextView) view.findViewById(R.id.noticeTextView)).setText(this.f39311b);
        View view2 = this.f39310a;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    }

    public boolean isPrepared(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.f39312c = function0;
        CharSequence charSequence = this.f39311b;
        return !(charSequence == null || charSequence.length() == 0);
    }

    public final void requestAlertInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, Const.BundleKey.CART_ID);
        CustomerRpcManagerProxy.get().billAlert(str, str2, new DefaultNotifyView$requestAlertInfo$1(this));
    }
}

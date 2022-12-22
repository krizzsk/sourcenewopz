package com.didi.soda.order.component.evaluatesuccess;

import android.text.style.ClickableSpan;
import android.view.View;
import com.didi.soda.order.component.evaluatesuccess.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/order/component/evaluatesuccess/OrderEvaluateSuccessView$setAfterSaleText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderEvaluateSuccessView.kt */
public final class OrderEvaluateSuccessView$setAfterSaleText$1 extends ClickableSpan {
    final /* synthetic */ String $url;
    final /* synthetic */ OrderEvaluateSuccessView this$0;

    OrderEvaluateSuccessView$setAfterSaleText$1(OrderEvaluateSuccessView orderEvaluateSuccessView, String str) {
        this.this$0 = orderEvaluateSuccessView;
        this.$url = str;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        ((Contract.AbsOrderEvaluateSuccessPresenter) this.this$0.getPresenter()).go2AfterSale(this.$url);
    }
}

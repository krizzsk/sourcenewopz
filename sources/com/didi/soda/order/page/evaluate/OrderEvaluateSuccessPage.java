package com.didi.soda.order.page.evaluate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.order.component.evaluatesuccess.OrderEvaluateSuccessComponent;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/order/page/evaluate/OrderEvaluateSuccessPage;", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "()V", "mComponent", "Lcom/didi/soda/order/component/evaluatesuccess/OrderEvaluateSuccessComponent;", "getStatusBarHeight", "", "onInflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupComponents", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"orderEvaluateSuccessPage"})
/* compiled from: OrderEvaluateSuccessPage.kt */
public final class OrderEvaluateSuccessPage extends CustomerPage {

    /* renamed from: a */
    private OrderEvaluateSuccessComponent f43530a;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_order_evaluate_success, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…uccess, container, false)");
        return inflate;
    }

    public void setupComponents(View view) {
        Intrinsics.checkNotNullParameter(view, "container");
        super.setupComponents(view);
        OrderEvaluateSuccessComponent orderEvaluateSuccessComponent = new OrderEvaluateSuccessComponent((ViewGroup) view);
        this.f43530a = orderEvaluateSuccessComponent;
        Unit unit = Unit.INSTANCE;
        addComponent(orderEvaluateSuccessComponent);
    }
}

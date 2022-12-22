package com.didi.entrega.orderlist.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.entrega.customer.base.pages.CustomerPage;
import com.didi.entrega.orderlist.component.OrderListComponent;
import com.didi.entrega.orderlist.omega.OrderListOmegaHelper;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/page/OrderListPage;", "Lcom/didi/entrega/customer/base/pages/CustomerPage;", "()V", "orderListContainer", "Landroid/widget/FrameLayout;", "onHandleBack", "", "onInflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupComponents", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"orderListPage"})
/* compiled from: OrderListPage.kt */
public final class OrderListPage extends CustomerPage {

    /* renamed from: a */
    private FrameLayout f21000a;

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_page_order_list, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.entrega_fl_order_list_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…_fl_order_list_container)");
        this.f21000a = (FrameLayout) findViewById;
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView");
        return inflate;
    }

    public void setupComponents(View view) {
        Intrinsics.checkNotNullParameter(view, "container");
        super.setupComponents(view);
        FrameLayout frameLayout = this.f21000a;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListContainer");
            frameLayout = null;
        }
        addComponent(new OrderListComponent(frameLayout));
    }

    public boolean onHandleBack() {
        OrderListOmegaHelper.Companion.getInstance().trackReturnBk();
        return super.onHandleBack();
    }
}

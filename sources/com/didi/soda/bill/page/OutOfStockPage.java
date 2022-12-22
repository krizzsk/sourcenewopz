package com.didi.soda.bill.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.bill.component.outofstock.OutOfStockComponent;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/bill/page/OutOfStockPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "mContainer", "Landroid/view/ViewGroup;", "getMContainer", "()Landroid/view/ViewGroup;", "setMContainer", "(Landroid/view/ViewGroup;)V", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "initContentView", "", "onCreate", "view", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"billOutOfStock"})
/* compiled from: OutOfStockPage.kt */
public final class OutOfStockPage extends FloatingCustomerPage {
    public ViewGroup mContainer;
    public View mRootView;

    public final View getMRootView() {
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    public final void setMRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mRootView = view;
    }

    public final ViewGroup getMContainer() {
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    public final void setMContainer(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.mContainer = viewGroup;
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        setContentView(getMRootView());
        setType(2);
        addComponent(new OutOfStockComponent(getMContainer()));
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_out_of_stock, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        setMRootView(inflate);
        View findViewById = getMRootView().findViewById(R.id.customer_fl_cart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R…stomer_fl_cart_container)");
        setMContainer((ViewGroup) findViewById);
    }
}

package com.didi.soda.bill.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.bill.component.ordertip.CartInfoConfirmComponent;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/bill/page/CartInfoConfirmPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "mComponent", "Lcom/didi/soda/bill/component/ordertip/CartInfoConfirmComponent;", "getMComponent", "()Lcom/didi/soda/bill/component/ordertip/CartInfoConfirmComponent;", "setMComponent", "(Lcom/didi/soda/bill/component/ordertip/CartInfoConfirmComponent;)V", "mContainer", "Landroid/view/ViewGroup;", "getMContainer", "()Landroid/view/ViewGroup;", "setMContainer", "(Landroid/view/ViewGroup;)V", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "initContentView", "", "onCreate", "view", "onHandleBack", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"cartInfoConfirmPage"})
/* compiled from: CartInfoConfirmPage.kt */
public final class CartInfoConfirmPage extends FloatingCustomerPage {

    /* renamed from: a */
    private CartInfoConfirmComponent f39146a;
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

    public final CartInfoConfirmComponent getMComponent() {
        return this.f39146a;
    }

    public final void setMComponent(CartInfoConfirmComponent cartInfoConfirmComponent) {
        this.f39146a = cartInfoConfirmComponent;
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        setContentView(getMRootView());
        setType(1);
        CartInfoConfirmComponent cartInfoConfirmComponent = new CartInfoConfirmComponent(getMContainer());
        addComponent(cartInfoConfirmComponent);
        Unit unit = Unit.INSTANCE;
        this.f39146a = cartInfoConfirmComponent;
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_cart_info_confirm, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        setMRootView(inflate);
        View findViewById = getMRootView().findViewById(R.id.customer_fl_cart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R…stomer_fl_cart_container)");
        setMContainer((ViewGroup) findViewById);
    }

    public boolean onHandleBack() {
        CartInfoConfirmComponent cartInfoConfirmComponent = this.f39146a;
        if (cartInfoConfirmComponent == null) {
            return true;
        }
        cartInfoConfirmComponent.onHandleBack();
        return true;
    }
}

package com.didi.soda.cart.component;

import android.view.ViewGroup;
import com.didi.soda.cart.component.Contract;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartComponent;
import com.didi.soda.customer.foundation.util.ClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J(\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0010H\u0016R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/cart/component/CustomerFloatingCartComponent;", "Lcom/didi/soda/customer/component/floatingcarprovider/IFloatingCartComponent;", "Lcom/didi/soda/cart/component/Contract$AbsFloatingCartView;", "Lcom/didi/soda/cart/component/Contract$AbsFloatingCartPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "shopId", "", "(Landroid/view/ViewGroup;Ljava/lang/String;)V", "customerFloatingCartPresenter", "Lcom/didi/soda/cart/component/CustomerFloatingCartPresenter;", "customerFloatingCartView", "Lcom/didi/soda/cart/component/CustomerFloatingCartView;", "getShoppingCartPosition", "", "isFloatingCartExpand", "", "onCreatePresenter", "onCreateView", "playAddToCartAnimation", "", "isOpen", "requestCartInfo", "showFloatingCart", "reversion", "businessState", "", "biData", "needShowCartMenu", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFloatingCartComponent.kt */
public final class CustomerFloatingCartComponent extends IFloatingCartComponent<Contract.AbsFloatingCartView, Contract.AbsFloatingCartPresenter> {

    /* renamed from: a */
    private String f39896a;

    /* renamed from: b */
    private CustomerFloatingCartPresenter f39897b;

    /* renamed from: c */
    private CustomerFloatingCartView f39898c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerFloatingCartComponent(ViewGroup viewGroup, String str) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(str, "shopId");
        this.f39896a = str;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsFloatingCartView onCreateView() {
        CustomerFloatingCartView customerFloatingCartView = new CustomerFloatingCartView();
        this.f39898c = customerFloatingCartView;
        if (customerFloatingCartView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customerFloatingCartView");
            customerFloatingCartView = null;
        }
        return customerFloatingCartView;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsFloatingCartPresenter onCreatePresenter() {
        CustomerFloatingCartPresenter customerFloatingCartPresenter = new CustomerFloatingCartPresenter(this.f39896a);
        this.f39897b = customerFloatingCartPresenter;
        if (customerFloatingCartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customerFloatingCartPresenter");
            customerFloatingCartPresenter = null;
        }
        return customerFloatingCartPresenter;
    }

    public void requestCartInfo() {
        CustomerFloatingCartPresenter customerFloatingCartPresenter = this.f39897b;
        if (customerFloatingCartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customerFloatingCartPresenter");
            customerFloatingCartPresenter = null;
        }
        customerFloatingCartPresenter.getCartInfo();
    }

    public int[] getShoppingCartPosition() {
        CustomerFloatingCartView customerFloatingCartView = this.f39898c;
        if (customerFloatingCartView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customerFloatingCartView");
            customerFloatingCartView = null;
        }
        return customerFloatingCartView.getShoppingCartPosition();
    }

    public void showFloatingCart(String str, int i, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "reversion");
        Intrinsics.checkNotNullParameter(str2, "biData");
        CustomerFloatingCartPresenter customerFloatingCartPresenter = this.f39897b;
        if (customerFloatingCartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customerFloatingCartPresenter");
            customerFloatingCartPresenter = null;
        }
        customerFloatingCartPresenter.showFloatingCart(str, i, str2, z);
    }

    public void playAddToCartAnimation(boolean z) {
        CustomerFloatingCartView customerFloatingCartView = this.f39898c;
        if (customerFloatingCartView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customerFloatingCartView");
            customerFloatingCartView = null;
        }
        customerFloatingCartView.playAddToCartAnimation(z);
    }

    public boolean isFloatingCartExpand() {
        CustomerFloatingCartView customerFloatingCartView = this.f39898c;
        CustomerFloatingCartView customerFloatingCartView2 = null;
        if (customerFloatingCartView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customerFloatingCartView");
            customerFloatingCartView = null;
        }
        if (!customerFloatingCartView.isFloatingCartExpand()) {
            return false;
        }
        if (ClickUtils.isFastClick()) {
            return true;
        }
        CustomerFloatingCartView customerFloatingCartView3 = this.f39898c;
        if (customerFloatingCartView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customerFloatingCartView");
        } else {
            customerFloatingCartView2 = customerFloatingCartView3;
        }
        customerFloatingCartView2.hideCartMenu();
        return true;
    }
}

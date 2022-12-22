package com.didi.soda.address.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.address.component.selectlist.SelectedAddressComponent;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/address/page/SelectedAddressListPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "component", "Lcom/didi/soda/address/component/selectlist/SelectedAddressComponent;", "mCartContainer", "Landroid/widget/FrameLayout;", "mContentView", "Landroid/view/View;", "initContentView", "", "onCreate", "view", "onPageResult", "data", "Landroid/os/Bundle;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"orderAddressListPage"})
/* compiled from: SelectedAddressListPage.kt */
public final class SelectedAddressListPage extends FloatingCustomerPage {

    /* renamed from: a */
    private FrameLayout f38799a;

    /* renamed from: b */
    private View f38800b;

    /* renamed from: c */
    private SelectedAddressComponent f38801c;

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        View view2 = this.f38800b;
        SelectedAddressComponent selectedAddressComponent = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        setContentView(view2);
        setType(2);
        FrameLayout frameLayout = this.f38799a;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCartContainer");
            frameLayout = null;
        }
        SelectedAddressComponent selectedAddressComponent2 = new SelectedAddressComponent(frameLayout);
        this.f38801c = selectedAddressComponent2;
        if (selectedAddressComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        } else {
            selectedAddressComponent = selectedAddressComponent2;
        }
        addComponent(selectedAddressComponent);
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_bill_tip, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        this.f38800b = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.customer_fl_cart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI…stomer_fl_cart_container)");
        this.f38799a = (FrameLayout) findViewById;
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        SelectedAddressComponent selectedAddressComponent = this.f38801c;
        if (selectedAddressComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
            selectedAddressComponent = null;
        }
        selectedAddressComponent.onPageResult(bundle);
    }
}

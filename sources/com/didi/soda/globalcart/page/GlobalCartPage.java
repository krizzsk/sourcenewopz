package com.didi.soda.globalcart.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.globalcart.component.GlobalCartComponent;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/globalcart/page/GlobalCartPage;", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "()V", "cartContainer", "Landroid/widget/FrameLayout;", "getStatusBarHeight", "", "initView", "", "root", "Landroid/view/View;", "onInflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupComponents", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"globalCartPage"})
/* compiled from: GlobalCartPage.kt */
public final class GlobalCartPage extends CustomerPage {

    /* renamed from: a */
    private FrameLayout f42302a;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_cart_container, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        initView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…   initView(it)\n        }");
        return inflate;
    }

    public final void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "root");
        View findViewById = view.findViewById(R.id.customer_fl_cart_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.customer_fl_cart_container)");
        this.f42302a = (FrameLayout) findViewById;
    }

    public void setupComponents(View view) {
        Intrinsics.checkNotNullParameter(view, "container");
        super.setupComponents(view);
        FrameLayout frameLayout = this.f42302a;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartContainer");
            frameLayout = null;
        }
        addComponent(new GlobalCartComponent(frameLayout));
    }
}

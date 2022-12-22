package com.didi.soda.home.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.home.component.category.landing.ShopCategoryLandingComponent;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/home/page/ShopCategoryLandingPage;", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "()V", "mCategoryContainer", "Landroid/widget/FrameLayout;", "mContentView", "Landroid/view/View;", "mShopCateLandingComponent", "Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingComponent;", "getStatusBarHeight", "", "onCreate", "", "view", "onInflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPageResult", "data", "Landroid/os/Bundle;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"shopCategoryLandingPage"})
/* compiled from: ShopCategoryLandingPage.kt */
public final class ShopCategoryLandingPage extends CustomerPage {

    /* renamed from: a */
    private FrameLayout f42703a;

    /* renamed from: b */
    private View f42704b;

    /* renamed from: c */
    private ShopCategoryLandingComponent f42705c;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_all_category_container, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext)\n      …tainer, container, false)");
        this.f42704b = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.customer_fl_category_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI…er_fl_category_container)");
        this.f42703a = (FrameLayout) findViewById;
        View view = this.f42704b;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        return null;
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        FrameLayout frameLayout = this.f42703a;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryContainer");
            frameLayout = null;
        }
        ShopCategoryLandingComponent shopCategoryLandingComponent = new ShopCategoryLandingComponent(frameLayout);
        addComponent(shopCategoryLandingComponent);
        this.f42705c = shopCategoryLandingComponent;
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        ShopCategoryLandingComponent shopCategoryLandingComponent = this.f42705c;
        if (shopCategoryLandingComponent != null) {
            shopCategoryLandingComponent.onPageResult(bundle);
        }
    }
}

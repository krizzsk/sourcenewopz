package com.didi.soda.home.component.category.landing;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingView;", "Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingPresenter;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "mPresenter", "onCreatePresenter", "onCreateView", "onPageResult", "", "data", "Landroid/os/Bundle;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopCategoryLandingComponent.kt */
public final class ShopCategoryLandingComponent extends MvpComponent<ShopCategoryLandingView, ShopCategoryLandingPresenter> {

    /* renamed from: a */
    private ShopCategoryLandingPresenter f42560a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopCategoryLandingComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
    }

    /* access modifiers changed from: protected */
    public ShopCategoryLandingPresenter onCreatePresenter() {
        ShopCategoryLandingPresenter shopCategoryLandingPresenter = new ShopCategoryLandingPresenter();
        this.f42560a = shopCategoryLandingPresenter;
        return shopCategoryLandingPresenter;
    }

    /* access modifiers changed from: protected */
    public ShopCategoryLandingView onCreateView() {
        return new ShopCategoryLandingView();
    }

    public final void onPageResult(Bundle bundle) {
        ShopCategoryLandingPresenter shopCategoryLandingPresenter = this.f42560a;
        if (shopCategoryLandingPresenter != null) {
            shopCategoryLandingPresenter.onPageResult(bundle);
        }
    }
}

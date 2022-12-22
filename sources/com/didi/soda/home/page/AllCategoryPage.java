package com.didi.soda.home.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.drouter.utils.TextUtils;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.home.component.category.AllCategoryComponent;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/home/page/AllCategoryPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "mCategoryContainer", "Landroid/widget/FrameLayout;", "mContentView", "Landroid/view/View;", "initContentView", "", "onCreate", "view", "parseTitle", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route(interceptors = {AllCategoryPageInterceptor.class}, value = {"allCategoryPage"})
/* compiled from: AllCategoryPage.kt */
public final class AllCategoryPage extends FloatingCustomerPage {

    /* renamed from: a */
    private FrameLayout f42688a;

    /* renamed from: b */
    private View f42689b;

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_all_category_container, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        this.f42689b = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.customer_fl_category_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI…er_fl_category_container)");
        this.f42688a = (FrameLayout) findViewById;
    }

    /* renamed from: b */
    private final void m30146b() {
        Bundle bundle;
        String string;
        Bundle bundle2;
        ScopeContext scopeContext = getScopeContext();
        if (!(scopeContext == null || (bundle2 = scopeContext.getBundle()) == null)) {
            bundle2.getString(Const.PageParams.SUB_ITEMS);
        }
        ScopeContext scopeContext2 = getScopeContext();
        if (scopeContext2 != null && (bundle = scopeContext2.getBundle()) != null && (string = bundle.getString(Const.PageParams.SUB_ITEMS)) != null) {
            try {
                AllCategoryEntity allCategoryEntity = (AllCategoryEntity) GsonUtil.fromJson(string, AllCategoryEntity.class);
                if (allCategoryEntity != null) {
                    if (!TextUtils.isEmpty(allCategoryEntity.getTitle())) {
                        RFFloatingNavBar navBar = getNavBar();
                        if (navBar != null) {
                            navBar.setTitle(new RFFloatingTextAttr.Builder(allCategoryEntity.getTitle()).build());
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        View view2 = this.f42689b;
        FrameLayout frameLayout = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        setContentView(view2);
        FrameLayout frameLayout2 = this.f42688a;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryContainer");
        } else {
            frameLayout = frameLayout2;
        }
        addComponent(new AllCategoryComponent(frameLayout));
        setType(2);
        m30146b();
    }
}

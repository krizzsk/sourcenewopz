package com.didi.soda.home.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.home.component.policy.PolicyUpdateComponent;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/home/page/PolicyUpdatePage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "mRootContainer", "Landroid/widget/FrameLayout;", "initContentView", "", "onCreate", "view", "Landroid/view/View;", "onHandleBack", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"policyUpdatePage"})
/* compiled from: PolicyUpdatePage.kt */
public final class PolicyUpdatePage extends FloatingCustomerPage {

    /* renamed from: a */
    private FrameLayout f42702a;

    public boolean onHandleBack() {
        return true;
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        FrameLayout frameLayout = this.f42702a;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            frameLayout = null;
        }
        setContentView((View) frameLayout);
        FrameLayout frameLayout2 = this.f42702a;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            frameLayout2 = null;
        }
        addComponent(new PolicyUpdateComponent(frameLayout2));
        RFFloatingNavBar navBar = getNavBar();
        if (navBar != null) {
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.FoodC_note_Important_updates_yyVS)).build());
        }
        RFFloatingNavBar navBar2 = getNavBar();
        if (navBar2 != null) {
            navBar2.setLeftIcon((RFFloatingIconAttr) null);
        }
        setGestureEnable(false);
        UiHandlerUtil.post($$Lambda$PolicyUpdatePage$uvSP3oOKBdrSeya3lbP97vGPttk.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30151b() {
        GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        this.f42702a = new FrameLayout(getBaseContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        FrameLayout frameLayout = this.f42702a;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            frameLayout = null;
        }
        frameLayout.setLayoutParams(layoutParams);
    }
}

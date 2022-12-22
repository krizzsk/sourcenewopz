package com.didi.soda.business.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.business.component.dynamic.category.BusinessDyCategoryComponent;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/business/page/BusinessCategoryMenuPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "mBusinessDyCategoryComponent", "Lcom/didi/soda/business/component/dynamic/category/BusinessDyCategoryComponent;", "mRootContainer", "Landroid/widget/FrameLayout;", "initContentView", "", "onCreate", "view", "Landroid/view/View;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"businessCategoryMenuPage"})
/* compiled from: BusinessCategoryMenuPage.kt */
public final class BusinessCategoryMenuPage extends FloatingCustomerPage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_REFRESH_SELECTED_CATEGORY = "key_refresh_selected_category";
    public static final String PARAM_REFRESH_SELECTED_CATEGORY_INDEX = "param_refresh_selected_category_index";
    public static final int VALUE_REFRESH_SELECTED_CATEGORY_FLAG = 100;

    /* renamed from: a */
    private BusinessDyCategoryComponent f39720a;

    /* renamed from: b */
    private FrameLayout f39721b;

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006XD¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/business/page/BusinessCategoryMenuPage$Companion;", "", "()V", "KEY_REFRESH_SELECTED_CATEGORY", "", "PARAM_REFRESH_SELECTED_CATEGORY_INDEX", "VALUE_REFRESH_SELECTED_CATEGORY_FLAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessCategoryMenuPage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        FrameLayout frameLayout = this.f39721b;
        BusinessDyCategoryComponent businessDyCategoryComponent = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            frameLayout = null;
        }
        setContentView((View) frameLayout);
        FrameLayout frameLayout2 = this.f39721b;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            frameLayout2 = null;
        }
        BusinessDyCategoryComponent businessDyCategoryComponent2 = new BusinessDyCategoryComponent(frameLayout2);
        this.f39720a = businessDyCategoryComponent2;
        if (businessDyCategoryComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBusinessDyCategoryComponent");
        } else {
            businessDyCategoryComponent = businessDyCategoryComponent2;
        }
        addComponent(businessDyCategoryComponent);
        RFFloatingNavBar navBar = getNavBar();
        if (navBar != null) {
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.FoodC_page__yHgR)).build());
        }
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        FrameLayout frameLayout = new FrameLayout(getBaseContext());
        this.f39721b = frameLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            frameLayout = null;
        }
        frameLayout.setBackgroundResource(R.color.rf_color_v2_grey2_10_a100);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        FrameLayout frameLayout3 = this.f39721b;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.setLayoutParams(layoutParams);
    }
}

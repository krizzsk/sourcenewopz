package com.didi.soda.home.topgun.component.filter.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.ExposureLinearLayout;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001.B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J<\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\b2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000ej\u0002`%J\b\u0010&\u001a\u00020\u0010H&J6\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\b2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000ej\u0002`%H&J\b\u0010+\u001a\u00020\fH&J\u000e\u0010,\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\bJ\b\u0010-\u001a\u00020\u0010H&R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R4\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000ej\u0004\u0018\u0001`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/filter/module/AbsFilterModule;", "", "parent", "Landroid/view/ViewGroup;", "scene", "", "(Landroid/view/ViewGroup;I)V", "mComponentModel", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterComponentModel;", "mContainer", "Landroid/widget/LinearLayout;", "mIsJustSelf", "", "mOnSWFilterItemListener", "Lkotlin/Function2;", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;", "", "Lcom/didi/soda/home/topgun/component/filter/module/OnFilterItemSWListener;", "getMOnSWFilterItemListener", "()Lkotlin/jvm/functions/Function2;", "setMOnSWFilterItemListener", "(Lkotlin/jvm/functions/Function2;)V", "mRootView", "Lcom/didi/soda/home/topgun/widget/ExposureLinearLayout;", "mTitleView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getScene", "()I", "bindModuleOnPanel", "isJustSelf", "isFirst", "componentModel", "listener", "Lcom/didi/soda/home/topgun/component/filter/module/OnFilterItemClickListener;", "confirmFilterModule", "createFilterItemsListView", "Landroid/view/View;", "context", "Landroid/content/Context;", "isOriginal", "onMoudleExposured", "resetFilterModule", "MoudleAppearListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbsFilterModule.kt */
public abstract class AbsFilterModule {

    /* renamed from: a */
    private ViewGroup f42848a;

    /* renamed from: b */
    private final int f42849b;

    /* renamed from: c */
    private Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> f42850c;

    /* renamed from: d */
    private boolean f42851d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FilterModel.FilterComponentModel f42852e;

    /* renamed from: f */
    private CustomerAppCompatTextView f42853f;

    /* renamed from: g */
    private LinearLayout f42854g;

    /* renamed from: h */
    private ExposureLinearLayout f42855h;

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/filter/module/AbsFilterModule$MoudleAppearListener;", "", "onMoudleAppear", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AbsFilterModule.kt */
    public interface MoudleAppearListener {
        void onMoudleAppear();
    }

    public abstract void confirmFilterModule();

    public abstract View createFilterItemsListView(Context context, FilterModel.FilterComponentModel filterComponentModel, Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2);

    public abstract boolean isOriginal();

    public abstract void resetFilterModule();

    public AbsFilterModule(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f42848a = viewGroup;
        this.f42849b = i;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_widget_home_filter_mul_grid, this.f42848a, false);
        if (inflate != null) {
            ExposureLinearLayout exposureLinearLayout = (ExposureLinearLayout) inflate;
            this.f42855h = exposureLinearLayout;
            if (exposureLinearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                exposureLinearLayout = null;
            }
            View findViewById = exposureLinearLayout.findViewById(R.id.customer_tv_home_filter_grid_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…v_home_filter_grid_title)");
            this.f42853f = (CustomerAppCompatTextView) findViewById;
            View findViewById2 = exposureLinearLayout.findViewById(R.id.customer_ll_filter_module_container);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…_filter_module_container)");
            this.f42854g = (LinearLayout) findViewById2;
            exposureLinearLayout.setExposureListener(new AbsFilterModule$1$1(this));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.home.topgun.widget.ExposureLinearLayout");
    }

    public final ViewGroup getParent() {
        return this.f42848a;
    }

    public final int getScene() {
        return this.f42849b;
    }

    public final void setParent(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.f42848a = viewGroup;
    }

    public final Function2<FilterModel.FilterItemRvModel, Boolean, Unit> getMOnSWFilterItemListener() {
        return this.f42850c;
    }

    public final void setMOnSWFilterItemListener(Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2) {
        this.f42850c = function2;
    }

    public final void onMoudleExposured(FilterModel.FilterComponentModel filterComponentModel) {
        Intrinsics.checkNotNullParameter(filterComponentModel, "componentModel");
        HomeOmegaHelper.getInstance().trackMoudleSW(filterComponentModel.mType, this.f42849b);
    }

    public final void bindModuleOnPanel(boolean z, boolean z2, FilterModel.FilterComponentModel filterComponentModel, Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(filterComponentModel, "componentModel");
        Intrinsics.checkNotNullParameter(function2, "listener");
        this.f42851d = z;
        this.f42852e = filterComponentModel;
        ExposureLinearLayout exposureLinearLayout = null;
        if (filterComponentModel != null) {
            Context context = getParent().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            View createFilterItemsListView = createFilterItemsListView(context, filterComponentModel, function2);
            if (createFilterItemsListView != null) {
                LinearLayout linearLayout = this.f42854g;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    linearLayout = null;
                }
                linearLayout.addView(createFilterItemsListView);
            }
        }
        if (this.f42851d) {
            CustomerAppCompatTextView customerAppCompatTextView = this.f42853f;
            if (customerAppCompatTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                customerAppCompatTextView = null;
            }
            customerAppCompatTextView.setVisibility(8);
        } else {
            if (z2) {
                ExposureLinearLayout exposureLinearLayout2 = this.f42855h;
                if (exposureLinearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    exposureLinearLayout2 = null;
                }
                View view = exposureLinearLayout2;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    ((LinearLayout.LayoutParams) layoutParams2).topMargin = DisplayUtils.dip2px(getParent().getContext(), 4.0f);
                    view.setLayoutParams(layoutParams2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
            }
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f42853f;
            if (customerAppCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                customerAppCompatTextView2 = null;
            }
            String str = filterComponentModel.mTitle;
            if (str == null) {
                str = "";
            }
            customerAppCompatTextView2.setText(str);
            CustomerAppCompatTextView customerAppCompatTextView3 = this.f42853f;
            if (customerAppCompatTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                customerAppCompatTextView3 = null;
            }
            customerAppCompatTextView3.setVisibility(0);
        }
        ViewGroup viewGroup = this.f42848a;
        ExposureLinearLayout exposureLinearLayout3 = this.f42855h;
        if (exposureLinearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            exposureLinearLayout = exposureLinearLayout3;
        }
        viewGroup.addView(exposureLinearLayout);
    }
}

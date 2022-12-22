package com.didi.payment.commonsdk.p129ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.commonsdk.p129ui.FragmentSwitchVM;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001aJ\u001c\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0014J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0017H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010*\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006+"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "T", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "()V", "defaultCommonTitlebar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "getDefaultCommonTitlebar", "()Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "setDefaultCommonTitlebar", "(Lcom/didi/sdk/view/titlebar/CommonTitleBar;)V", "pageSwitchVm", "Lcom/didi/payment/commonsdk/ui/FragmentSwitchVM;", "getPageSwitchVm", "()Lcom/didi/payment/commonsdk/ui/FragmentSwitchVM;", "setPageSwitchVm", "(Lcom/didi/payment/commonsdk/ui/FragmentSwitchVM;)V", "backToPrePage", "", "args", "Landroid/os/Bundle;", "backToRoot", "customUTitlebar", "Landroid/view/View;", "forwardNextPage", "fragmentClz", "Ljava/lang/Class;", "extras", "getTitleBarView", "initCommonTitlebar", "commonTitleBar", "initContentView", "view", "initCustomTitlebar", "rootView", "initViewModels", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onViewCreated", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.AbsWBaseFragment */
/* compiled from: AbsWBaseFragment.kt */
public class AbsWBaseFragment<T extends WBaseViewModel> extends WBaseFragment<T> {
    public CommonTitleBar defaultCommonTitlebar;
    public FragmentSwitchVM pageSwitchVm;

    public final void backToRoot() {
    }

    public View customUTitlebar() {
        return null;
    }

    public void initContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public View initCustomTitlebar(View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        return null;
    }

    public void initViewModels() {
    }

    public final CommonTitleBar getDefaultCommonTitlebar() {
        CommonTitleBar commonTitleBar = this.defaultCommonTitlebar;
        if (commonTitleBar != null) {
            return commonTitleBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("defaultCommonTitlebar");
        return null;
    }

    public final void setDefaultCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "<set-?>");
        this.defaultCommonTitlebar = commonTitleBar;
    }

    public final FragmentSwitchVM getPageSwitchVm() {
        FragmentSwitchVM fragmentSwitchVM = this.pageSwitchVm;
        if (fragmentSwitchVM != null) {
            return fragmentSwitchVM;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pageSwitchVm");
        return null;
    }

    public final void setPageSwitchVm(FragmentSwitchVM fragmentSwitchVM) {
        Intrinsics.checkNotNullParameter(fragmentSwitchVM, "<set-?>");
        this.pageSwitchVm = fragmentSwitchVM;
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return getDefaultCommonTitlebar() != null ? getDefaultCommonTitlebar() : customUTitlebar();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (onInflateLayout() > 0) {
            return layoutInflater.inflate(onInflateLayout(), viewGroup, false);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModel viewModel = new ViewModelProvider(activity).get(FragmentSwitchVM.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(hostAc…mentSwitchVM::class.java)");
            setPageSwitchVm((FragmentSwitchVM) viewModel);
        }
        View findViewWithTag = view.findViewWithTag(getString(R.string.common_titlebar_id));
        if (findViewWithTag != null) {
            setDefaultCommonTitlebar((CommonTitleBar) findViewWithTag);
            initCommonTitlebar(getDefaultCommonTitlebar());
            initContentView(view);
            initViewModels();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.sdk.view.titlebar.CommonTitleBar");
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        TextView middleTv = commonTitleBar.getMiddleTv();
        if (middleTv != null) {
            middleTv.setTypeface(Typeface.defaultFromStyle(1));
        }
        TextView middleTv2 = commonTitleBar.getMiddleTv();
        if (middleTv2 != null) {
            middleTv2.setTextSize(2, 20.0f);
        }
        ImageView leftImgView = commonTitleBar.getLeftImgView();
        if (leftImgView != null) {
            leftImgView.setImageResource(R.drawable.common_title_back_arrow);
        }
        View findViewById = commonTitleBar.findViewById(R.id.common_title_bar_line);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public final void forwardNextPage(Class<?> cls) {
        if (cls != null) {
            getPageSwitchVm().getFragmengSwitchLD().setValue(new FragmentSwitchVM.ForwardAction(cls, (Bundle) null));
        }
    }

    public final void forwardNextPage(Class<?> cls, Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "extras");
        if (cls != null) {
            getPageSwitchVm().getFragmengSwitchLD().setValue(new FragmentSwitchVM.ForwardAction(cls, bundle));
        }
    }

    public final void backToPrePage() {
        backToPrePage((Bundle) null);
    }

    public final void backToPrePage(Bundle bundle) {
        FragmentSwitchVM.PageSwitch pageSwitch = new FragmentSwitchVM.PageSwitch(true);
        pageSwitch.setExtras(bundle);
        getPageSwitchVm().getFragmengSwitchLD2().setValue(pageSwitch);
    }
}

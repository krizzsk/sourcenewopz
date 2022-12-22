package com.didi.entrega.info.component;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.abnormal.AbnormalView;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModel;
import com.didi.entrega.customer.widget.titlebar.TitleBarView;
import com.didi.entrega.info.binder.InfoHeaderBinder;
import com.didi.entrega.info.helper.InfoStepConfig;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014J\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\rJ\b\u0010\u0017\u001a\u00020\rH\u0016J\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/entrega/info/component/AbsInfoView;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/entrega/info/component/AbsInfoPresenter;", "()V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "hideAbnormal", "", "hideLoading", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "loading", "loadingAndHideBottomBtn", "onCreate", "scrollAutoHideKeyBoard", "setTitleBarTxt", "config", "Lcom/didi/entrega/info/helper/InfoStepConfig;", "showAbnormal", "abnormalViewModel", "Lcom/didi/entrega/customer/widget/abnormal/AbnormalViewModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbsInfoView.kt */
public abstract class AbsInfoView extends CustomerRecyclerView<AbsInfoPresenter<?>> {
    public View rootView;

    public final View getRootView() {
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final void setRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.rootView = view;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_component_info_view, viewGroup, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…fo_view, container, true)");
        setRootView(inflate);
        return getRootView();
    }

    public void onCreate() {
        super.onCreate();
        ((TitleBarView) getRootView().findViewById(R.id.title_bar)).setBackgroundResource(R.color.rf_color_gery_7_97_F5F5F7);
        ((TitleBarView) getRootView().findViewById(R.id.title_bar)).setBackIconText(R.string.rf_icon_outlined_back_android);
        scrollAutoHideKeyBoard();
    }

    public final void setTitleBarTxt(InfoStepConfig infoStepConfig) {
        Intrinsics.checkNotNullParameter(infoStepConfig, "config");
        if (infoStepConfig.getViewType() != 1) {
            int currentStep = infoStepConfig.getCurrentStep();
            if (currentStep == 1) {
                ((TitleBarView) getRootView().findViewById(R.id.title_bar)).setTitleText(ResourceHelper.getString(R.string.FoodC_info_Fill_in_SDGf));
            } else if (currentStep == 2) {
                ((TitleBarView) getRootView().findViewById(R.id.title_bar)).setTitleText(ResourceHelper.getString(R.string.FoodC_info_Recipient_Information_JGug));
            } else if (currentStep == 3) {
                ((TitleBarView) getRootView().findViewById(R.id.title_bar)).setTitleText(ResourceHelper.getString(R.string.FoodC_info_Item_Information_gDfc));
            }
        }
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = (NovaRecyclerView) getRootView().findViewById(R.id.entrega_info_recyclerview);
        Intrinsics.checkNotNullExpressionValue(novaRecyclerView, "rootView.entrega_info_recyclerview");
        return novaRecyclerView;
    }

    public final void showAbnormal(AbnormalViewModel abnormalViewModel) {
        Intrinsics.checkNotNullParameter(abnormalViewModel, "abnormalViewModel");
        ((AbnormalView) getRootView().findViewById(R.id.entrega_info_abnormal_view)).setVisibility(0);
        ((AbnormalView) getRootView().findViewById(R.id.entrega_info_abnormal_view)).show(abnormalViewModel);
        ((LinearLayout) getRootView().findViewById(R.id.ll_bottom_btn)).setVisibility(4);
        ((NovaRecyclerView) getRootView().findViewById(R.id.entrega_info_recyclerview)).setVisibility(8);
    }

    public final void hideAbnormal() {
        ((AbnormalView) getRootView().findViewById(R.id.entrega_info_abnormal_view)).setVisibility(8);
        ((LinearLayout) getRootView().findViewById(R.id.ll_bottom_btn)).setVisibility(0);
        ((NovaRecyclerView) getRootView().findViewById(R.id.entrega_info_recyclerview)).setVisibility(0);
    }

    public final void loading() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        hideAbnormal();
    }

    public final void loadingAndHideBottomBtn() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        hideAbnormal();
        ((LinearLayout) getRootView().findViewById(R.id.ll_bottom_btn)).setVisibility(4);
    }

    public final void hideLoading() {
        DialogUtil.hideLoadingDialog();
        ((LinearLayout) getRootView().findViewById(R.id.ll_bottom_btn)).setVisibility(0);
    }

    public final void scrollAutoHideKeyBoard() {
        ((NovaRecyclerView) getRootView().findViewById(R.id.entrega_info_recyclerview)).addOnScrollListener(new AbsInfoView$scrollAutoHideKeyBoard$1(this));
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new InfoHeaderBinder());
    }
}

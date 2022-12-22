package com.didi.component.framework.template.confirm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmAddressListener;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.component.confirmupdateaddress.ConfirmUpdateAddressComponent;
import com.didi.component.confirmupdateaddress.view.ConfirmUpdateAddressView;
import com.didi.component.framework.template.common.CommonTemplateFragment;
import com.didi.component.framework.template.common.CommonTemplatePresenter;
import com.didi.component.mapflow.MapFlowComponent;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.util.AppUtils;
import com.didiglobal.p205sa.biz.estimate.EstimateParams;
import com.taxis99.R;
import java.io.Serializable;

public class ConfirmTemplateFragment extends CommonTemplateFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ConfirmUpdateAddressComponent f13962a;

    /* renamed from: b */
    private EstimateParams f13963b;

    /* renamed from: c */
    private ViewGroup f13964c;

    /* renamed from: d */
    private final ConfirmAddressListener f13965d = new ConfirmAddressListener() {
        public void updateAlpha(float f) {
            if (ConfirmTemplateFragment.this.mTitleBackBtn != null) {
                if (ConfirmTemplateFragment.this.mTitleBackBtn.getAlpha() != f) {
                    ConfirmTemplateFragment.this.mTitleBackBtn.setAlpha(f);
                }
                int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i == 0 && ConfirmTemplateFragment.this.mTitleBackBtn.getVisibility() != 8) {
                    ConfirmTemplateFragment.this.mTitleBackBtn.setVisibility(8);
                }
                if (i > 0 && ConfirmTemplateFragment.this.mTitleBackBtn.getVisibility() != 0) {
                    ConfirmTemplateFragment.this.mTitleBackBtn.setVisibility(0);
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1030;
    }

    /* access modifiers changed from: protected */
    public int currentVersionCode() {
        return 2;
    }

    public int getRootLayout() {
        return R.layout.global_fragment_confirm_new;
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        inflateViewlessComponents(ComponentType.PAGE_DATA);
        inflateViewlessComponent(ComponentType.GLOBAL_XENGINE, (Bundle) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, UiUtils.dip2px(getContext(), -5.0f), UiUtils.dip2px(getContext(), -10.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        inflateComponent(ComponentType.RESET_LOCATION, relativeLayout, layoutParams);
        Bundle bundle = new Bundle();
        bundle.putInt(MapFlowComponent.SUG_PAGE_CONTAINER_ID, R.id.rl_global_common_sug_container);
        inflateViewlessComponents("service", "deeplink");
        inflateViewlessComponent("map_flow", bundle);
        inflateComponent(ComponentType.BUBBLE_LAYOUT, relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(UIUtils.dip2pxInt(getContext(), 50.0f), AppUtils.getStatusBarHeight(getContext()), -20, 0);
        layoutParams2.addRule(10);
        this.f13962a = (ConfirmUpdateAddressComponent) inflateComponent(ComponentType.CONFIRM_UPDATE_ADDRESS, relativeLayout, layoutParams2);
        GLog.m7965d("lxslxs", "inflate XEngine");
        inflateViewlessComponent("config", (Bundle) null);
        inflateViewlessComponent(ComponentType.SUBSTITUTE_CALL, (Bundle) null);
        inflateComponent(ComponentType.SELECT_SEAT, relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        inflateViewlessComponent(ComponentType.PRE_ORDER_INTERCEPT_EXPO, (Bundle) null);
        inflateViewlessComponent(ComponentType.OFFER_FLEX_PRICE, (Bundle) null);
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            PageCompDataTransfer.getInstance().getConfirmListener().addConfirmAddressObserver(this.f13965d);
        }
    }

    public View getFallbackView() {
        return this.f13964c;
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).setLoadingGravity(48).setMaskBackgroundColor(Color.parseColor("#6625262D")).setWithMaskLayer(true).build();
    }

    public void showLoading() {
        m9696a(true);
        super.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        m9696a(true);
        super.showLoading(loadingConfig);
    }

    public void showMaskLayerLoading() {
        m9696a(true);
        super.showMaskLayerLoading();
    }

    public void hideLoading() {
        m9696a(false);
        super.hideLoading();
    }

    /* renamed from: a */
    private void m9696a(boolean z) {
        ViewGroup viewGroup = this.f13964c;
        if (viewGroup != null) {
            if (z) {
                viewGroup.setVisibility(0);
                this.f13964c.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                    }
                });
                return;
            }
            viewGroup.setVisibility(8);
            this.f13964c.setOnClickListener((View.OnClickListener) null);
        }
    }

    public void onCreate(Bundle bundle) {
        Serializable serializable;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || (serializable = arguments.getSerializable("estimateParams")) == null)) {
            this.f13963b = (EstimateParams) serializable;
        }
        EstimateParams estimateParams = this.f13963b;
        if (!(estimateParams == null || estimateParams.getStartAddress() == null)) {
            FormStore.getInstance().setStartAddress(this.f13963b.getStartAddress());
            this.mLogger.info("estimateParams---start_Confirm", this.f13963b.getStartAddress().displayName);
        }
        EstimateParams estimateParams2 = this.f13963b;
        if (!(estimateParams2 == null || estimateParams2.getEndAddress() == null)) {
            FormStore.getInstance().setEndAddress(this.f13963b.getEndAddress());
            this.mLogger.info("estimateParams---end_Confirm", this.f13963b.getEndAddress().displayName);
        }
        EstimateParams estimateParams3 = this.f13963b;
        if (!(estimateParams3 == null || estimateParams3.getmWayPointAddressList() == null || this.f13963b.getmWayPointAddressList().size() == 0)) {
            FormStore.getInstance().saveWayPoint(this.f13963b.getmWayPointAddressList());
        }
        EstimateParams estimateParams4 = this.f13963b;
        if (estimateParams4 != null && estimateParams4.isGuessDestination()) {
            FormStore.getInstance().setIsClickGuessDestination(true);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResumeImpl() {
        super.onResumeImpl();
    }

    /* access modifiers changed from: protected */
    public void onPauseImpl() {
        super.onPauseImpl();
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        super.initViews();
        int statusBarHeight = AppUtils.getStatusBarHeight(getContext());
        ViewGroup.LayoutParams layoutParams = this.mTitleBackBtn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = statusBarHeight;
            this.mTitleBackBtn.setLayoutParams(layoutParams);
        }
        ViewGroup viewGroup = (ViewGroup) this.mRootView.findViewById(R.id.common_loading_layout);
        this.f13964c = viewGroup;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams2.topMargin = statusBarHeight;
        this.f13964c.setLayoutParams(layoutParams2);
    }

    /* access modifiers changed from: protected */
    public void updatePaddingTop() {
        this.mCompContainer.post(new Runnable() {
            public void run() {
                if (!ConfirmTemplateFragment.this.isDestroyed() && ConfirmTemplateFragment.this.f13962a != null) {
                    ConfirmUpdateAddressView confirmUpdateAddressView = (ConfirmUpdateAddressView) ConfirmTemplateFragment.this.f13962a.getView();
                    int bestViewTopPadding = confirmUpdateAddressView.getBestViewTopPadding();
                    GLog.m7964d("updatePaddingRunnable>>>mPaddingTop:" + bestViewTopPadding);
                    if (bestViewTopPadding == 0) {
                        confirmUpdateAddressView.sendGetBestViewTopPaddingEvent();
                    } else if (ConfirmTemplateFragment.this.mTopPresenter != null) {
                        ((CommonTemplatePresenter) ConfirmTemplateFragment.this.mTopPresenter).onPaddingTopChanged(bestViewTopPadding);
                    }
                }
            }
        });
    }
}

package com.didi.component.evaluate.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.travel.psnger.model.CommonPopUp;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class UnMatchConfirmDialog extends SimplePopupBase implements View.OnClickListener, ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private FrameLayout f13400a;

    /* renamed from: b */
    private CommonPopUp f13401b;

    /* renamed from: c */
    private String f13402c;

    /* renamed from: d */
    private int f13403d = 0;

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13404e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (UnMatchConfirmDialog.this.isAdded() && !UnMatchConfirmDialog.this.isDetached() && !UnMatchConfirmDialog.this.isRemoving()) {
                UnMatchConfirmDialog.this.dismissAllowingStateLoss();
                UnMatchConfirmDialog.this.hideLoading();
            }
        }
    };

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_unmatch_intercept_popup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        if (this.f13403d == 1) {
            this.mRootView.findViewById(R.id.ll_unmatch_container).setBackgroundResource(R.drawable.g_xp_evaluate_background);
        }
        this.mRootView.findViewById(R.id.tv_unmatch_intercept_cancel).setOnClickListener(this);
        this.mRootView.findViewById(R.id.tv_unmatch_intercept_confirm).setOnClickListener(this);
        this.f13400a = (FrameLayout) this.mRootView.findViewById(R.id.oc_unmatch_loading);
        CommonPopUp commonPopUp = this.f13401b;
        if (commonPopUp != null && !TextUtils.isEmpty(commonPopUp.title)) {
            ((TextView) this.mRootView.findViewById(R.id.tv_unmatch_intercept_title)).setText(this.f13401b.title);
            ((TextView) this.mRootView.findViewById(R.id.tv_unmatch_intercept_subtitle)).setText(this.f13401b.showMsg);
            if (this.f13401b.options != null && this.f13401b.options.size() == 2) {
                ((TextView) this.mRootView.findViewById(R.id.tv_unmatch_intercept_cancel)).setText(this.f13401b.options.get(0).text);
                ((TextView) this.mRootView.findViewById(R.id.tv_unmatch_intercept_confirm)).setText(this.f13401b.options.get(1).text);
            }
        }
    }

    public void setStyle(int i) {
        this.f13403d = i;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (isAdded() && !isDetached() && !isRemoving()) {
            if (view.getId() == R.id.tv_unmatch_intercept_cancel) {
                if (this.f13401b.options == null || this.f13401b.options.get(0) == null) {
                    m9186a();
                } else {
                    m9189b(this.f13401b.options.get(0).type);
                }
            } else if (view.getId() != R.id.tv_unmatch_intercept_confirm) {
            } else {
                if (this.f13401b.options == null || this.f13401b.options.get(1) == null) {
                    m9188b();
                } else {
                    m9189b(this.f13401b.options.get(1).type);
                }
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_UNMATCH_DONE, this.f13404e);
    }

    public void onDetach() {
        super.onDetach();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_UNMATCH_DONE, this.f13404e);
    }

    public View getFallbackView() {
        return this.f13400a;
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).setWithMaskLayer(true).build();
    }

    public void showLoading() {
        if (getFallbackView() != null) {
            Loading.make(getContext(), getFallbackView(), getLoadingConfig()).show();
        }
    }

    public void showLoading(LoadingConfig loadingConfig) {
        if (getFallbackView() != null) {
            LoadingConfig loadingConfig2 = getLoadingConfig();
            loadingConfig2.merge(loadingConfig);
            Loading.make(getContext(), getFallbackView(), loadingConfig2).show();
        }
    }

    public void hideLoading() {
        Loading.hide(getFallbackView());
    }

    public boolean isLoading() {
        return Loading.isShowing(getFallbackView());
    }

    public void setUnMatchPopUp(CommonPopUp commonPopUp) {
        this.f13401b = commonPopUp;
    }

    public void setOrderId(String str) {
        this.f13402c = str;
    }

    /* renamed from: a */
    private void m9187a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_black", Integer.valueOf(i));
        hashMap.put("order_id", this.f13402c);
        OmegaSDKAdapter.trackEvent("gulf_p_f_compblack_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m9189b(int i) {
        if (i == CommonPopUp.PopUpActionType.CONFIRM.type) {
            m9188b();
        } else {
            m9186a();
        }
    }

    /* renamed from: a */
    private void m9186a() {
        dismissAllowingStateLoss();
        m9187a(0);
    }

    /* renamed from: b */
    private void m9188b() {
        showLoading();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_UNMATCH);
        m9187a(1);
    }
}

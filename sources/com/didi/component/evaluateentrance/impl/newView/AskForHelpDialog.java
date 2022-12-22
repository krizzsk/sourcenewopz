package com.didi.component.evaluateentrance.impl.newView;

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
import com.taxis99.R;

public class AskForHelpDialog extends SimplePopupBase implements View.OnClickListener, ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private FrameLayout f13559a;

    /* renamed from: b */
    private CommonPopUp f13560b;

    /* renamed from: c */
    private int f13561c = 0;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_ask_for_help_intercept_popup;
    }

    public AskForHelpDialog() {
    }

    public AskForHelpDialog(int i) {
        this.f13561c = i;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        if (this.f13561c == 1) {
            this.mRootView.findViewById(R.id.ll_ask_for_help_container).setBackgroundResource(R.drawable.g_xp_ask_for_help_background);
        }
        this.mRootView.findViewById(R.id.tv_intercept_cancel).setOnClickListener(this);
        this.mRootView.findViewById(R.id.tv_intercept_confirm).setOnClickListener(this);
        this.f13559a = (FrameLayout) this.mRootView.findViewById(R.id.oc_loading);
        CommonPopUp commonPopUp = this.f13560b;
        if (commonPopUp != null && !TextUtils.isEmpty(commonPopUp.title)) {
            ((TextView) this.mRootView.findViewById(R.id.tv_intercept_title)).setText(this.f13560b.title);
            ((TextView) this.mRootView.findViewById(R.id.tv_intercept_subtitle)).setText(this.f13560b.showMsg);
            if (this.f13560b.options != null && this.f13560b.options.size() == 2) {
                ((TextView) this.mRootView.findViewById(R.id.tv_intercept_cancel)).setText(this.f13560b.options.get(0).text);
                ((TextView) this.mRootView.findViewById(R.id.tv_intercept_confirm)).setText(this.f13560b.options.get(1).text);
            }
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (isAdded() && !isDetached() && !isRemoving()) {
            if (view.getId() == R.id.tv_intercept_cancel) {
                if (this.f13560b.options == null || this.f13560b.options.get(0) == null) {
                    m9312a();
                } else {
                    m9313a(this.f13560b.options.get(0));
                }
            } else if (view.getId() != R.id.tv_intercept_confirm) {
            } else {
                if (this.f13560b.options == null || this.f13560b.options.get(1) == null) {
                    m9314b(this.f13560b.options.get(1));
                } else {
                    m9313a(this.f13560b.options.get(1));
                }
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }

    public View getFallbackView() {
        return this.f13559a;
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

    public void setPopUp(CommonPopUp commonPopUp) {
        this.f13560b = commonPopUp;
    }

    /* renamed from: a */
    private void m9313a(CommonPopUp.PopUpOptions popUpOptions) {
        if (popUpOptions.type == CommonPopUp.PopUpActionType.URL.type) {
            m9314b(popUpOptions);
        } else {
            m9312a();
        }
    }

    /* renamed from: a */
    private void m9312a() {
        dismissAllowingStateLoss();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Evaluate.SHOW_NEXT_EVALUATE, Boolean.TRUE);
    }

    /* renamed from: b */
    private void m9314b(CommonPopUp.PopUpOptions popUpOptions) {
        if (popUpOptions == null || popUpOptions.data == null || TextUtils.isEmpty(popUpOptions.data.url)) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Evaluate.SHOW_NEXT_EVALUATE, Boolean.TRUE);
        } else {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Evaluate.ASK_FOR_HELP, popUpOptions.data.url);
        }
        dismissAllowingStateLoss();
    }
}

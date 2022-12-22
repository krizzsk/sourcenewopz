package com.didi.component.comp_xpanel;

import android.content.Context;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.animator.GlobalXPanelAnimatorImpl;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.component.core.IViewContainer;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.xpanel.channel.global.GlobalXPanel;
import com.didichuxing.xpanel.channel.global.GlobalXPanelView;
import com.didichuxing.xpanel.global.models.XPanelModels;
import com.taxis99.R;

public abstract class AbsGlobalXPanelView implements IGlobalXPanelView, ILoadingHolder {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f12531a;

    /* renamed from: b */
    private View f12532b;
    protected Context mContext;
    protected IGlobalXPanelAnimator.VisibilityChangedListener mListener;
    protected IGlobalXPanelAnimator mPanelAnimator;
    protected GlobalXPanel mXPanel;
    protected AbsGlobalXPanelPresenter mXPanelPresenter;

    /* access modifiers changed from: protected */
    public abstract void initXPanelView(Context context, GlobalXPanelView.XPanelConfig xPanelConfig);

    static {
        XPanelModels.register();
    }

    public AbsGlobalXPanelView(Context context) {
        this.mContext = context;
        createXPanelAnimate();
        GlobalXPanelView.XPanelConfig xPanelConfig = GlobalXPanelView.XPanelConfig.getDefault();
        xPanelConfig.divider_color = ResourcesHelper.getColor(this.mContext, R.color.g_color_FFE5E5E5);
        initXPanelView(context, xPanelConfig);
        if (this.f12532b == null) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            this.f12532b = frameLayout;
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 4.0f, this.mContext.getResources().getDisplayMetrics())));
        }
    }

    /* access modifiers changed from: protected */
    public void createXPanelAnimate() {
        this.mPanelAnimator = new GlobalXPanelAnimatorImpl();
    }

    public void hide() {
        hide(0);
    }

    public void show() {
        show(0);
    }

    public void show(long j, final IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener) {
        if (this.mPanelAnimator != null) {
            this.mPanelAnimator.show(getView(), getAnimateDuration(), j, new IGlobalXPanelAnimator.VisibilityChangedListener() {
                public void onShownStart() {
                    IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener = visibilityChangedListener;
                    if (visibilityChangedListener != null) {
                        visibilityChangedListener.onShownStart();
                    }
                    if (AbsGlobalXPanelView.this.mListener != null) {
                        AbsGlobalXPanelView.this.mListener.onShownStart();
                    }
                    boolean unused = AbsGlobalXPanelView.this.f12531a = true;
                }

                public void onHiddenStart() {
                    IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener = visibilityChangedListener;
                    if (visibilityChangedListener != null) {
                        visibilityChangedListener.onHiddenStart();
                    }
                    if (AbsGlobalXPanelView.this.mListener != null) {
                        AbsGlobalXPanelView.this.mListener.onHiddenStart();
                    }
                    boolean unused = AbsGlobalXPanelView.this.f12531a = true;
                }

                public void onShown() {
                    IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener = visibilityChangedListener;
                    if (visibilityChangedListener != null) {
                        visibilityChangedListener.onShown();
                    }
                    if (AbsGlobalXPanelView.this.mListener != null) {
                        AbsGlobalXPanelView.this.mListener.onShown();
                    }
                    boolean unused = AbsGlobalXPanelView.this.f12531a = false;
                }

                public void onHidden() {
                    IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener = visibilityChangedListener;
                    if (visibilityChangedListener != null) {
                        visibilityChangedListener.onHidden();
                    }
                    if (AbsGlobalXPanelView.this.mListener != null) {
                        AbsGlobalXPanelView.this.mListener.onHidden();
                    }
                    boolean unused = AbsGlobalXPanelView.this.f12531a = false;
                }
            });
        }
    }

    public void hide(long j, final IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener) {
        if (this.mPanelAnimator != null && this.mXPanel != null) {
            View view = getView();
            this.mXPanel.moveToResetPosition();
            this.mPanelAnimator.hide(view, getAnimateDuration(), j, new IGlobalXPanelAnimator.VisibilityChangedListener() {
                public void onShownStart() {
                    IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener = visibilityChangedListener;
                    if (visibilityChangedListener != null) {
                        visibilityChangedListener.onShownStart();
                    }
                    if (AbsGlobalXPanelView.this.mListener != null) {
                        AbsGlobalXPanelView.this.mListener.onShownStart();
                    }
                }

                public void onHiddenStart() {
                    IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener = visibilityChangedListener;
                    if (visibilityChangedListener != null) {
                        visibilityChangedListener.onHiddenStart();
                    }
                    if (AbsGlobalXPanelView.this.mListener != null) {
                        AbsGlobalXPanelView.this.mListener.onHiddenStart();
                    }
                }

                public void onShown() {
                    IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener = visibilityChangedListener;
                    if (visibilityChangedListener != null) {
                        visibilityChangedListener.onShown();
                    }
                    if (AbsGlobalXPanelView.this.mListener != null) {
                        AbsGlobalXPanelView.this.mListener.onShown();
                    }
                }

                public void onHidden() {
                    IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener = visibilityChangedListener;
                    if (visibilityChangedListener != null) {
                        visibilityChangedListener.onHidden();
                    }
                    if (AbsGlobalXPanelView.this.mListener != null) {
                        AbsGlobalXPanelView.this.mListener.onHidden();
                    }
                }
            });
        }
    }

    public void hide(long j) {
        hide(j, (IGlobalXPanelAnimator.VisibilityChangedListener) null);
    }

    public void show(long j) {
        show(j, (IGlobalXPanelAnimator.VisibilityChangedListener) null);
    }

    public boolean isShown() {
        IGlobalXPanelAnimator iGlobalXPanelAnimator = this.mPanelAnimator;
        if (iGlobalXPanelAnimator == null) {
            return false;
        }
        return iGlobalXPanelAnimator.isShown(this.mXPanel.getView());
    }

    public long getAnimateDuration() {
        return (long) getView().getContext().getResources().getInteger(R.integer.component_switch_during_mills);
    }

    public View getView() {
        return this.mXPanel.getView();
    }

    public void setPresenter(AbsGlobalXPanelPresenter absGlobalXPanelPresenter) {
        this.mXPanelPresenter = absGlobalXPanelPresenter;
    }

    public GlobalXPanel getXPanel() {
        return this.mXPanel;
    }

    public void setVisibilityChangedListener(IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener) {
        this.mListener = visibilityChangedListener;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mXPanelPresenter.setComponentCreator(iComponentCreator);
    }

    /* access modifiers changed from: protected */
    public float getMinHeight(Context context) {
        float dip2px = UIUtils.dip2px(context, 68.0f) / ((float) UIUtils.getScreenHeight(context));
        if (dip2px < 0.0f || ((double) dip2px) > 0.5d) {
            return 0.1f;
        }
        return dip2px;
    }

    public void resetHeight(int i) {
        this.mXPanel.clearDefaultScrollFlag(GlobalXPanelView.STYLE_DEFAULT_SHOW_HEIGHT, i);
    }

    public void resetHalfCardHeight(int i) {
        this.mXPanel.clearDefaultScrollFlag(GlobalXPanelView.STYLE_DEFAULT_HALF_HEIGHT, i);
    }

    public void showLoading() {
        showLoading(getLoadingConfig());
    }

    public void showLoading(LoadingConfig loadingConfig) {
        LoadingConfig loadingConfig2 = getLoadingConfig();
        loadingConfig2.merge(loadingConfig);
        this.mXPanel.setLoadingView(this.f12532b);
        GLog.m7965d("zl-loading", "xpanel showLoading with config " + loadingConfig);
        Loading.make(this.mContext, getFallbackView(), loadingConfig2).show();
    }

    public void hideLoading() {
        Loading.hide(getFallbackView());
        if (this.f12532b.getParent() != null) {
            ((ViewGroup) this.f12532b.getParent()).removeView(this.f12532b);
        }
    }

    public boolean isLoading() {
        return Loading.isShowing(getFallbackView());
    }

    public View getFallbackView() {
        return this.f12532b;
    }

    public LoadingConfig getLoadingConfig() {
        if (this.f12531a) {
            return LoadingConfig.create().setLoadingGravity(80).setRenderType(LoadingRenderType.ANIMATION).setStartDelay(getAnimateDuration() + 100).build();
        }
        return LoadingConfig.create().setLoadingGravity(80).setRenderType(LoadingRenderType.ANIMATION).build();
    }

    public boolean isCarPoolLine() {
        int i;
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            i = order.comboType;
        } else {
            i = FormStore.getInstance().getCurrentComboType();
        }
        return i == 4;
    }

    public void setNavigationText(final CharSequence charSequence) {
        setNavigationTextOnMainThread(new Runnable() {
            public void run() {
                if (AbsGlobalXPanelView.this.mXPanel != null) {
                    AbsGlobalXPanelView.this.mXPanel.setNavigationText(charSequence);
                }
            }
        });
    }

    public void setNavigationTextOnMainThread(Runnable runnable) {
        if (runnable != null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                runnable.run();
            } else {
                UiThreadHandler.post(runnable);
            }
        }
    }
}

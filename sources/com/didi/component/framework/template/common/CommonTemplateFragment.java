package com.didi.component.framework.template.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.ComponentStub;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.Utils;
import com.didi.component.common.animator.GlobalXPanelAnimatorImpl;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.animator.VisibilityChangeListenerAdapter;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.common.base.PageProxy;
import com.didi.component.common.util.GLog;
import com.didi.component.core.IComponent;
import com.didi.component.core.IPresenter;
import com.didi.component.framework.base.XPanelLoadingNormalFragment;
import com.didi.component.framework.template.TemplateUtils;
import com.didi.lockscreen.framework.LockScreenService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.travel.util.Preconditions;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class CommonTemplateFragment extends XPanelLoadingNormalFragment<CommonTemplatePresenter> implements View.OnClickListener, ICommonTemplateView {
    protected final String TAG = getClass().getSimpleName();
    /* access modifiers changed from: private */
    public AtomicInteger mAnimationSyncCount = new AtomicInteger();
    private long mAnimatorDuration;
    /* access modifiers changed from: protected */
    public RelativeLayout mCompContainer;
    private ComponentStub mComponentStub;
    protected IGlobalXPanelAnimator mGlobalXpanelAnimator;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());
    private View mMaskView;
    protected PageProxy mPageProxy = new PageProxy(new PageProxy.PageCallback() {
        public int getPageId() {
            return CommonTemplateFragment.this.currentPageId();
        }

        public void beforeCreateSession() {
            super.beforeCreateSession();
            CommonTemplateFragment.this.beforeCreateSession();
        }

        public void afterCreateSession() {
            super.afterCreateSession();
            CommonTemplateFragment.this.afterCreateSession();
        }

        public void beforeDestroySession() {
            super.beforeDestroySession();
            CommonTemplateFragment.this.beforeDestroySession();
        }

        public void afterDestroySession() {
            super.afterDestroySession();
            CommonTemplateFragment.this.afterDestroySession();
        }

        public void beforeOrderIdUpdate() {
            super.beforeOrderIdUpdate();
            CommonTemplateFragment.this.beforeOrderIdUpdate();
        }

        public void afterOrderIdUpdate() {
            super.afterOrderIdUpdate();
            CommonTemplateFragment.this.afterOrderIdUpdate();
        }
    }, getClass().getSimpleName());
    /* access modifiers changed from: private */
    public ComponentWrap mPopupComponentWrap = new ComponentWrap();
    /* access modifiers changed from: private */
    public View mPopupContainer;
    private View mPopupContentContainer;
    private View mPopupView;
    protected View mRootView;
    private View mSugPageContainer;
    /* access modifiers changed from: protected */
    public View mTitleBackBtn;

    public int getRootLayout() {
        return R.layout.global_fragment_common;
    }

    public void hideBottomSheet() {
    }

    public void hidePayProcessLoading() {
    }

    /* access modifiers changed from: protected */
    public abstract void initComponents(RelativeLayout relativeLayout);

    /* access modifiers changed from: protected */
    public boolean isRemoveSugContainer() {
        return false;
    }

    public void showBottomSheet() {
    }

    public void showPayProcessLoading() {
    }

    public void showPayProcessLoading4XPanel() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mAnimatorDuration = (long) context.getResources().getInteger(R.integer.fragment_switch_duration_mills);
        Bundle arguments = getArguments();
        if (Preconditions.nonNull(arguments)) {
            arguments.putInt(TravelConstant.EXTRA_PAGE_ID, currentPageId());
        }
        String str = this.TAG;
        LogUtils.m31493i(str, "onAttach:getArguments() = " + arguments);
        this.mPageProxy.onAttach(arguments);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initAnimator();
        if (getBusinessContext() != null) {
            FormStore.getInstance().setBusinessContext(getBusinessContext());
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mPageProxy.onDetach();
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getRootLayout(), viewGroup, false);
        initViews();
        initComponents(this.mCompContainer);
        return this.mRootView;
    }

    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.mRootView = null;
        this.mPopupComponentWrap = null;
        this.mCompContainer = null;
        this.mLogger.info("Common Page on Destroy", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public CommonTemplatePresenter onCreateTopPresenter() {
        String str = this.TAG;
        LogUtils.m31493i(str, "onCreateTopPresenter:getArguments() = " + getArguments());
        return new CommonTemplatePresenter(getBusinessContext(), getArguments());
    }

    /* access modifiers changed from: protected */
    public void onResumeImpl() {
        super.onResumeImpl();
        try {
            if (Utils.isServiceRunning(getContext(), LockScreenService.class.getName())) {
                return;
            }
            if (Build.VERSION.SDK_INT < 26) {
                getActivity().startService(new Intent(getActivity(), LockScreenService.class));
            } else if (Utils.isAppFront()) {
                getActivity().startService(new Intent(getActivity(), LockScreenService.class));
            }
        } catch (Exception e) {
            GLog.m7964d("LockScreenService start exception : " + Log.getStackTraceString(e));
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("stack", Log.getStackTraceString(e));
            OmegaSDKAdapter.trackEvent("lockscreen_service_start_exception", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void updatePaddingTop() {
        this.mTitleBackBtn.post(new Runnable() {
            public void run() {
                if (!CommonTemplateFragment.this.isDestroyed()) {
                    int[] iArr = new int[2];
                    CommonTemplateFragment.this.mTitleBackBtn.getLocationInWindow(iArr);
                    int measuredHeight = CommonTemplateFragment.this.mTitleBackBtn.getMeasuredHeight() + iArr[1];
                    if (CommonTemplateFragment.this.mTopPresenter != null) {
                        GLog.m7970i("updatePaddingRunnable>>>mPaddingTop:" + measuredHeight);
                        ((CommonTemplatePresenter) CommonTemplateFragment.this.mTopPresenter).onPaddingTopChanged(measuredHeight);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        View findViewById = this.mRootView.findViewById(R.id.global_title_btn_back);
        this.mTitleBackBtn = findViewById;
        findViewById.setOnClickListener(this);
        this.mCompContainer = (RelativeLayout) this.mRootView.findViewById(R.id.rl_global_common_content_container);
        updatePaddingTop();
        this.mSugPageContainer = this.mRootView.findViewById(R.id.rl_global_common_sug_container);
        if (isRemoveSugContainer()) {
            View view = this.mRootView;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeView(this.mSugPageContainer);
            }
        }
    }

    private void initPopupView() {
        if (this.mPopupView == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_common_popup_root, (ViewGroup) null);
            this.mPopupView = inflate;
            ((ViewGroup) this.mRootView).addView(inflate);
            this.mPopupContainer = this.mPopupView.findViewById(R.id.rl_global_common_popup_root);
            this.mPopupContentContainer = this.mPopupView.findViewById(R.id.ll_global_common_popup_container);
            View findViewById = this.mPopupView.findViewById(R.id.v_global_common_popup_mask);
            this.mMaskView = findViewById;
            findViewById.setBackgroundColor(ResourcesHelper.getColor(getContext(), R.color.g_color_B30A121A));
            this.mMaskView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1 && CommonTemplateFragment.this.mPopupComponentWrap != null && CommonTemplateFragment.this.mPopupComponentWrap.isClickMaskHide()) {
                        CommonTemplateFragment commonTemplateFragment = CommonTemplateFragment.this;
                        commonTemplateFragment.hidePopupComponent(commonTemplateFragment.mPopupComponentWrap.getType());
                    }
                    return true;
                }
            });
            this.mComponentStub = (ComponentStub) this.mPopupView.findViewById(R.id.component_stub);
        }
    }

    /* access modifiers changed from: protected */
    public void initAnimator() {
        this.mGlobalXpanelAnimator = new GlobalXPanelAnimatorImpl();
    }

    public void setBackVisible(boolean z) {
        View view = this.mTitleBackBtn;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.global_title_btn_back && this.mTopPresenter != null) {
            ((CommonTemplatePresenter) this.mTopPresenter).dispatchBackPressed(IPresenter.BackType.TopLeft);
        }
    }

    public void showPopupComponent(ComponentWrap componentWrap) {
        if (componentWrap != null && !TextUtils.isEmpty(componentWrap.getType())) {
            initPopupView();
            ComponentWrap componentWrap2 = this.mPopupComponentWrap;
            IComponent component = componentWrap2 != null ? componentWrap2.getComponent(componentWrap.getType()) : null;
            if (component == null) {
                if (this.mComponentStub.getComponentCreator() == null) {
                    this.mComponentStub.setComponentCreator(generateComponentCreator());
                }
                component = this.mComponentStub.inflate(componentWrap.getType(), componentWrap.getBundle());
            }
            if (component != null) {
                this.mPopupComponentWrap = componentWrap;
                componentWrap.setComponent(component);
                showPopupView();
            }
        }
    }

    public boolean hidePopupComponent(String str) {
        ComponentWrap componentWrap;
        if (TextUtils.isEmpty(str) || this.mPopupView == null || (componentWrap = this.mPopupComponentWrap) == null || componentWrap.getComponent(str) == null) {
            return false;
        }
        return hidePopupView();
    }

    public void showSugPageContainer() {
        RelativeLayout relativeLayout = this.mCompContainer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.mSugPageContainer;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void hideSugPageContainer() {
        RelativeLayout relativeLayout = this.mCompContainer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        View view = this.mSugPageContainer;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void clearPopupComponent() {
        if (this.mTopPresenter != null) {
            ComponentStub componentStub = this.mComponentStub;
            if (componentStub != null) {
                componentStub.clear();
            }
            this.mPopupComponentWrap = new ComponentWrap();
        }
    }

    private void showPopupView() {
        FormStore.getInstance().setShowingPopupCompoent(true);
        this.mPopupContainer.setVisibility(0);
        ComponentWrap componentWrap = this.mPopupComponentWrap;
        if (componentWrap != null && componentWrap.isUseMask()) {
            TemplateUtils.toggleMask(true, this.mMaskView, this.mAnimatorDuration);
        }
        this.mGlobalXpanelAnimator.show(this.mPopupContentContainer, this.mAnimatorDuration, 0, (IGlobalXPanelAnimator.VisibilityChangedListener) null);
    }

    private boolean hidePopupView() {
        FormStore.getInstance().setShowingPopupCompoent(false);
        ComponentWrap componentWrap = this.mPopupComponentWrap;
        if (componentWrap != null && componentWrap.isUseMask()) {
            TemplateUtils.toggleMask(false, this.mMaskView, this.mAnimatorDuration);
        }
        this.mGlobalXpanelAnimator.hide(this.mPopupContentContainer, this.mAnimatorDuration, 0, new VisibilityChangeListenerAdapter() {
            public void onHidden() {
                super.onHidden();
                if (CommonTemplateFragment.this.mPopupContainer != null) {
                    CommonTemplateFragment.this.mPopupContainer.setVisibility(8);
                }
                CommonTemplateFragment.this.clearPopupComponent();
            }
        });
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !isInAnimation()) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public Animator offerExitAnimation() {
        RelativeLayout relativeLayout = this.mCompContainer;
        if (relativeLayout != null) {
            TemplateUtils.toggleBottomInOut(this.mGlobalXpanelAnimator, false, (View) relativeLayout, (IGlobalXPanelAnimator.VisibilityChangedListener) null, false);
        }
        return null;
    }

    public void beforeOutAnimation() {
        titleBackBtnOutAnimation();
        offerExitAnimation();
    }

    private void titleBackBtnOutAnimation() {
        View view = this.mTitleBackBtn;
        if (view != null && view.getVisibility() == 0) {
            this.mTitleBackBtn.animate().cancel();
            this.mTitleBackBtn.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setDuration(600).setStartDelay(120).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    CommonTemplateFragment.this.mAnimationSyncCount.incrementAndGet();
                }

                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    CommonTemplateFragment.this.mAnimationSyncCount.decrementAndGet();
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CommonTemplateFragment.this.mAnimationSyncCount.decrementAndGet();
                }
            }).start();
        }
    }

    private boolean isInAnimation() {
        return this.mAnimationSyncCount.get() != 0;
    }

    /* access modifiers changed from: protected */
    public void beforeCreateSession() {
        Bundle fragmentArgument = getFragmentArgument();
        String str = this.TAG;
        LogUtils.m31493i(str, "beforeCreateSession:sessionKey = " + fragmentArgument.getString(TravelConstant.EXTRA_SESSION_KEY));
    }

    /* access modifiers changed from: protected */
    public void afterCreateSession() {
        Bundle fragmentArgument = getFragmentArgument();
        fragmentArgument.putString(TravelConstant.EXTRA_SESSION_KEY, this.mPageProxy.getSession().getKey());
        String str = this.TAG;
        LogUtils.m31493i(str, "afterCreateSession:sessionKey = " + fragmentArgument.getString(TravelConstant.EXTRA_SESSION_KEY));
    }

    /* access modifiers changed from: protected */
    public void beforeDestroySession() {
        Bundle fragmentArgument = getFragmentArgument();
        String str = this.TAG;
        LogUtils.m31493i(str, "beforeDestroySession:sessionKey = " + fragmentArgument.getString(TravelConstant.EXTRA_SESSION_KEY));
    }

    /* access modifiers changed from: protected */
    public void afterDestroySession() {
        Bundle fragmentArgument = getFragmentArgument();
        fragmentArgument.putString(TravelConstant.EXTRA_SESSION_KEY, "");
        String str = this.TAG;
        LogUtils.m31493i(str, "afterDestroySession:sessionKey = " + fragmentArgument.getString(TravelConstant.EXTRA_SESSION_KEY));
    }

    /* access modifiers changed from: protected */
    public void beforeOrderIdUpdate() {
        Bundle fragmentArgument = getFragmentArgument();
        String str = this.TAG;
        LogUtils.m31493i(str, "beforeOrderIdUpdate:orderId = " + fragmentArgument.getString(TravelConstant.EXTRA_ORDER_ID));
    }

    /* access modifiers changed from: protected */
    public void afterOrderIdUpdate() {
        Bundle fragmentArgument = getFragmentArgument();
        fragmentArgument.putString(TravelConstant.EXTRA_ORDER_ID, this.mPageProxy.getOrderId());
        String str = this.TAG;
        LogUtils.m31493i(str, "afterOrderIdUpdate:orderId = " + fragmentArgument.getString(TravelConstant.EXTRA_ORDER_ID));
    }

    private Bundle getFragmentArgument() {
        Bundle arguments = getArguments();
        String str = this.TAG;
        LogUtils.m31493i(str, "getFragmentArgument:bundle = " + arguments);
        return arguments;
    }

    /* access modifiers changed from: protected */
    public CarOrder getCarOrder() {
        Bundle arguments = getArguments();
        Serializable serializable = Preconditions.nonNull(arguments) ? arguments.getSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN) : null;
        if (serializable instanceof CarOrder) {
            return (CarOrder) serializable;
        }
        return CarOrderHelper.getOrder();
    }
}

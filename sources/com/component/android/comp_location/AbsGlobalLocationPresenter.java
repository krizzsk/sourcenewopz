package com.component.android.comp_location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.NonTalkingVisibilityEvent;
import com.didi.component.business.event.OpenRideVisibilityEvent;
import com.didi.component.business.event.ResetMapEvent;
import com.didi.component.business.event.SafeToolkitVisibilityEvent;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.SecondConfProxy;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.taxis99.R;

public abstract class AbsGlobalLocationPresenter extends BaseExpressPresenter<IGlobalLocationView> implements View.OnClickListener {
    public static final int BOTTOM_CONFIRM_LAYOUT_HEIGHT = UiUtils.dip2px(DIDIApplication.getAppContext(), 129.0f);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f3284a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private float f3285b = 0.0f;

    /* renamed from: c */
    private int f3286c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f3287d = false;

    /* renamed from: e */
    private Handler f3288e = new Handler() {
        public void handleMessage(Message message) {
            if (message != null) {
                ResetMapEvent obtain = ResetMapEvent.obtain();
                AbsGlobalLocationPresenter absGlobalLocationPresenter = AbsGlobalLocationPresenter.this;
                int calExtraHeightToShowBestView = absGlobalLocationPresenter.getCalExtraHeightToShowBestView(absGlobalLocationPresenter.mPaddingBottom);
                obtain.fillData(0, AbsGlobalLocationPresenter.this.mPaddingTop, 0, calExtraHeightToShowBestView);
                Logger a = AbsGlobalLocationPresenter.this.f3284a;
                a.info("zl-dobestview ^ EVENT_RESET_MAP:mPaddingTop=" + AbsGlobalLocationPresenter.this.mPaddingTop + ",mPaddingBottom " + calExtraHeightToShowBestView, new Object[0]);
                AbsGlobalLocationPresenter.this.doPublish("event_map_reset_map", obtain);
                AbsGlobalLocationPresenter.this.requestMapLayout();
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener f3289f = new BaseEventPublisher.OnEventListener<Float>() {
        public void onEvent(String str, Float f) {
            if (BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA.equals(str)) {
                AbsGlobalLocationPresenter.this.setAlpha(f.floatValue());
            }
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<Boolean> f3290g = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            boolean unused = AbsGlobalLocationPresenter.this.f3287d = bool.booleanValue();
        }
    };
    protected boolean isAirPortPickUpPoint;
    protected BusinessContext mBusinessContext;
    protected int mDefaultBottom;
    protected BaseEventPublisher.OnEventListener<DepartureAddress> mDepatureLoadedListener = new BaseEventPublisher.OnEventListener<DepartureAddress>() {
        public void onEvent(String str, DepartureAddress departureAddress) {
            AbsGlobalLocationPresenter.this.isAirPortPickUpPoint = departureAddress.getZoneType() == 0;
            if (AbsGlobalLocationPresenter.this.isAirPortPickUpPoint) {
                AbsGlobalLocationPresenter.this.hideResetView();
            }
        }
    };
    protected int mNewPanelDefaultHeight;
    protected BaseEventPublisher.OnEventListener<Integer> mNewXpanelDefaultHeightListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (TextUtils.equals(str, BaseEventKeys.NewXpanel.EVENT_XPANEL_DEFAULT_HEIGHT)) {
                AbsGlobalLocationPresenter.this.mNewPanelDefaultHeight = num.intValue();
            }
        }
    };
    protected int mNonTalkingHeight;
    protected BaseEventPublisher.OnEventListener mOnBestViewListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Location.EVENT_BEST_VIEW.equals(str)) {
                AbsGlobalLocationPresenter.this.doBestView();
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED)) {
                AbsGlobalLocationPresenter.this.onXPanelDefaultHeightChanged(num.intValue());
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnNonTalkingVisibilityListener = new BaseEventPublisher.OnEventListener<NonTalkingVisibilityEvent>() {
        public void onEvent(String str, NonTalkingVisibilityEvent nonTalkingVisibilityEvent) {
            if (str.equalsIgnoreCase(BaseEventKeys.NonTalking.EVENT_VISIBILITY_CHANGED)) {
                AbsGlobalLocationPresenter.this.onNonTalkingVisibilityChanged(nonTalkingVisibilityEvent);
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnOpenRideVisibilityListener = new BaseEventPublisher.OnEventListener<OpenRideVisibilityEvent>() {
        public void onEvent(String str, OpenRideVisibilityEvent openRideVisibilityEvent) {
            if (str.equalsIgnoreCase(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_VISIBILITY_CHANGED)) {
                AbsGlobalLocationPresenter.this.onOpenRideVisibilityChanged(openRideVisibilityEvent);
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnSafeToolkitVisibilityListener = new BaseEventPublisher.OnEventListener<SafeToolkitVisibilityEvent>() {
        public void onEvent(String str, SafeToolkitVisibilityEvent safeToolkitVisibilityEvent) {
            if (str.equalsIgnoreCase(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED)) {
                AbsGlobalLocationPresenter.this.onSafeToolkitVisibilityChanged(safeToolkitVisibilityEvent);
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnScrollEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER)) {
                AbsGlobalLocationPresenter.this.onXPanelScrollChanged(num.intValue());
            }
        }
    };
    protected int mOpenRideHeight;
    protected int mPaddingBottom;
    /* access modifiers changed from: protected */
    public int mPaddingTop;
    protected BaseEventPublisher.OnEventListener mPaddingTopEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.Location.EVENT_PADDING_TOP)) {
                AbsGlobalLocationPresenter.this.mPaddingTop = num.intValue();
                AbsGlobalLocationPresenter.this.doBestView();
            }
        }
    };
    protected int mSafeToolkitHeight;
    protected BaseEventPublisher.OnEventListener mVisibilityChangedListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onEvent(java.lang.String r3, com.didi.component.core.event.BaseEventPublisher.NullEvent r4) {
            /*
                r2 = this;
                int r4 = r3.hashCode()
                r0 = -57941009(0xfffffffffc8be3ef, float:-5.8108184E36)
                r1 = 1
                if (r4 == r0) goto L_0x001a
                r0 = 1775277044(0x69d093f4, float:3.1519407E25)
                if (r4 == r0) goto L_0x0010
                goto L_0x0024
            L_0x0010:
                java.lang.String r4 = "event_hide_reset_map"
                boolean r3 = r3.equals(r4)
                if (r3 == 0) goto L_0x0024
                r3 = 1
                goto L_0x0025
            L_0x001a:
                java.lang.String r4 = "event_show_reset_map"
                boolean r3 = r3.equals(r4)
                if (r3 == 0) goto L_0x0024
                r3 = 0
                goto L_0x0025
            L_0x0024:
                r3 = -1
            L_0x0025:
                if (r3 == 0) goto L_0x0030
                if (r3 == r1) goto L_0x002a
                goto L_0x0035
            L_0x002a:
                com.component.android.comp_location.AbsGlobalLocationPresenter r3 = com.component.android.comp_location.AbsGlobalLocationPresenter.this
                r3.hideResetView()
                goto L_0x0035
            L_0x0030:
                com.component.android.comp_location.AbsGlobalLocationPresenter r3 = com.component.android.comp_location.AbsGlobalLocationPresenter.this
                r3.showResetView()
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.component.android.comp_location.AbsGlobalLocationPresenter.C21738.onEvent(java.lang.String, com.didi.component.core.event.BaseEventPublisher$NullEvent):void");
        }
    };
    protected int mXBannerHeight;
    protected BaseEventPublisher.OnEventListener<Integer> mXBannerHeightListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            AbsGlobalLocationPresenter.this.mXBannerHeight = num.intValue();
            AbsGlobalLocationPresenter absGlobalLocationPresenter = AbsGlobalLocationPresenter.this;
            AbsGlobalLocationPresenter.this.computeNewTranslationY(absGlobalLocationPresenter.getNewHeightWithUIOffset(absGlobalLocationPresenter.mPaddingBottom));
        }
    };

    /* access modifiers changed from: protected */
    public int getExtraHeightToShowBestView() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean needAddExtraHeightToShowBestView() {
        return false;
    }

    public AbsGlobalLocationPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBusinessContext = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onSafeToolkitVisibilityChanged(SafeToolkitVisibilityEvent safeToolkitVisibilityEvent) {
        if (safeToolkitVisibilityEvent.isVisible) {
            this.mSafeToolkitHeight = safeToolkitVisibilityEvent.mViewHeight;
        } else {
            this.mSafeToolkitHeight = 0;
        }
        Logger logger = this.f3284a;
        logger.info("menuHeight mSafeToolkitHeight:" + this.mSafeToolkitHeight, new Object[0]);
        translationY((((-getNewHeightWithUIOffset(this.mPaddingBottom)) - this.mSafeToolkitHeight) - this.mNonTalkingHeight) - this.mOpenRideHeight);
    }

    /* access modifiers changed from: protected */
    public void onNonTalkingVisibilityChanged(NonTalkingVisibilityEvent nonTalkingVisibilityEvent) {
        if (nonTalkingVisibilityEvent.isVisible) {
            this.mNonTalkingHeight = nonTalkingVisibilityEvent.mViewHeight;
        } else {
            this.mNonTalkingHeight = 0;
        }
        Logger logger = this.f3284a;
        logger.info("menuHeight mNonTalkingHeight:" + this.mNonTalkingHeight, new Object[0]);
        translationY((((-getNewHeightWithUIOffset(this.mPaddingBottom)) - this.mSafeToolkitHeight) - this.mNonTalkingHeight) - this.mOpenRideHeight);
    }

    /* access modifiers changed from: protected */
    public void onOpenRideVisibilityChanged(OpenRideVisibilityEvent openRideVisibilityEvent) {
        if (openRideVisibilityEvent.isVisiable) {
            this.mOpenRideHeight = openRideVisibilityEvent.mViewHeight;
        } else {
            this.mOpenRideHeight = 0;
        }
        Logger logger = this.f3284a;
        logger.info("menuHeight mOpenRideHeight:" + this.mOpenRideHeight, new Object[0]);
        translationY((((-getNewHeightWithUIOffset(this.mPaddingBottom)) - this.mSafeToolkitHeight) - this.mNonTalkingHeight) - this.mOpenRideHeight);
    }

    /* access modifiers changed from: protected */
    public void computeNewTranslationY(final int i) {
        if (!SecondConfProxy.getInstance().isCityOpen(this.mBusinessContext.getBusinessGroupType())) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    if (AbsGlobalLocationPresenter.this.mBusinessContext != null) {
                        int bizBarHeight = AbsGlobalLocationPresenter.this.mBusinessContext.getBizBarHeight();
                        AbsGlobalLocationPresenter absGlobalLocationPresenter = AbsGlobalLocationPresenter.this;
                        absGlobalLocationPresenter.translationY(((-i) - bizBarHeight) - absGlobalLocationPresenter.mXBannerHeight);
                    }
                }
            }, 1000);
            return;
        }
        BusinessContext businessContext = this.mBusinessContext;
        if (businessContext != null) {
            translationY(((-i) - businessContext.getBizBarHeight()) - this.mXBannerHeight);
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (this.mView != null) {
            ((IGlobalLocationView) this.mView).setOnClickListener(this);
            ((IGlobalLocationView) this.mView).setOnOverviewClickListener(this);
        }
        this.f3285b = TypedValue.applyDimension(1, 4.0f, this.mContext.getResources().getDisplayMetrics());
        subscribe(BaseEventKeys.Map.EVENT_SHOW_RESET_MAP, this.mVisibilityChangedListener);
        subscribe(BaseEventKeys.Map.EVENT_HIDE_RESET_MAP, this.mVisibilityChangedListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        subscribe(BaseEventKeys.Location.EVENT_BEST_VIEW, this.mOnBestViewListener);
        subscribe(BaseEventKeys.Location.EVENT_PADDING_TOP, this.mPaddingTopEventListener);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, this.mOnSafeToolkitVisibilityListener);
        subscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_VISIBILITY_CHANGED, this.mOnOpenRideVisibilityListener);
        subscribe(BaseEventKeys.NonTalking.EVENT_VISIBILITY_CHANGED, this.mOnNonTalkingVisibilityListener);
        subscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOAD_SUCCESS, this.mDepatureLoadedListener);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.mXBannerHeightListener);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_DEFAULT_HEIGHT, this.mNewXpanelDefaultHeightListener);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f3289f);
        subscribe(BaseEventKeys.Estimate.EVENT_ESTIMATE_IS_ONE_CAR, this.f3290g);
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT);
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Map.EVENT_SHOW_RESET_MAP, this.mVisibilityChangedListener);
        unsubscribe(BaseEventKeys.Map.EVENT_HIDE_RESET_MAP, this.mVisibilityChangedListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        unsubscribe(BaseEventKeys.Location.EVENT_BEST_VIEW, this.mOnBestViewListener);
        unsubscribe(BaseEventKeys.Location.EVENT_PADDING_TOP, this.mPaddingTopEventListener);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, this.mOnSafeToolkitVisibilityListener);
        unsubscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_VISIBILITY_CHANGED, this.mOnOpenRideVisibilityListener);
        unsubscribe(BaseEventKeys.NonTalking.EVENT_VISIBILITY_CHANGED, this.mOnNonTalkingVisibilityListener);
        unsubscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOAD_SUCCESS, this.mDepatureLoadedListener);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.mXBannerHeightListener);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_DEFAULT_HEIGHT, this.mNewXpanelDefaultHeightListener);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f3289f);
        unsubscribe(BaseEventKeys.Estimate.EVENT_ESTIMATE_IS_ONE_CAR, this.f3290g);
    }

    public void onXPanelDefaultHeightChanged(int i) {
        if (i >= 0 && this.mDefaultBottom != i) {
            this.mDefaultBottom = i;
            if (this.mPaddingBottom > i) {
                onXPanelScrollChanged(i);
            }
            doBestView();
        }
    }

    /* access modifiers changed from: protected */
    public int getCalExtraHeightToShowBestView(int i) {
        return needAddExtraHeightToShowBestView() ? i + getExtraHeightToShowBestView() : i;
    }

    public void onXPanelScrollChanged(int i) {
        if (this.mDefaultBottom < 0) {
            this.mDefaultBottom = i;
        }
        this.mPaddingBottom = i;
        translationY((((-getNewHeightWithUIOffset(i)) - this.mSafeToolkitHeight) - this.mNonTalkingHeight) - this.mOpenRideHeight);
        if (this.mNewPanelDefaultHeight <= 0) {
            this.mNewPanelDefaultHeight = (UiUtils.getScreenHeight(this.mContext) / 3) * 2;
        }
    }

    /* access modifiers changed from: protected */
    public void doAnim(int i, int i2) {
        if (this.mView != null) {
            ((IGlobalLocationView) this.mView).doAnim(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void setAlpha(float f) {
        if (this.mView != null) {
            ((IGlobalLocationView) this.mView).setAlpha(f);
        }
    }

    /* access modifiers changed from: protected */
    public void translationY(int i) {
        if (this.mView != null) {
            ((IGlobalLocationView) this.mView).setTranslationY(i);
        }
    }

    /* access modifiers changed from: protected */
    public void doTranslationYAnimate(final int i) {
        if (this.mView != null && ((IGlobalLocationView) this.mView).getView() != null) {
            ((IGlobalLocationView) this.mView).getView().animate().withLayer().translationY((float) i).setDuration(500).setInterpolator(new OvershootInterpolator(0.5f)).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    AbsGlobalLocationPresenter.this.translationY(i);
                }
            }).start();
        }
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        requestMapLayout();
    }

    /* access modifiers changed from: protected */
    public int getNewHeightWithUIOffset(int i) {
        if (this.mView == null) {
            return i;
        }
        float f = (float) i;
        float f2 = this.f3285b;
        return f > f2 ? (int) (f + f2) : i;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.home_reset_location_btn) {
            GlobalOmegaUtils.trackEvent("pas_resetloction_ck");
            doBestView();
            hideResetView();
        }
        if (FormStore.getInstance().isInMiniBus()) {
            switchViewForGetOnAndOff(this.f3286c);
        } else {
            doPublish(BaseEventKeys.Location.EVENT_RESET_BTN_CLICK);
        }
    }

    /* access modifiers changed from: protected */
    public void doBestView() {
        this.f3288e.removeCallbacksAndMessages((Object) null);
        this.f3288e.sendEmptyMessageDelayed(0, 300);
    }

    /* access modifiers changed from: protected */
    public void requestMapLayout() {
        FragmentActivity activity;
        View findViewById;
        Fragment host = getHost();
        if (host != null && (activity = host.getActivity()) != null && (findViewById = activity.findViewById(R.id.home_map_fragment)) != null) {
            findViewById.forceLayout();
            findViewById.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void showResetView() {
        if (this.mView == null) {
            return;
        }
        if (!this.isAirPortPickUpPoint || !GPageIdConstant.G_PAGE_ID_PICONF.equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            ((IGlobalLocationView) this.mView).setVisibility(0);
        } else {
            hideResetView();
        }
    }

    /* access modifiers changed from: protected */
    public void hideResetView() {
        if (this.mView != null && ((IGlobalLocationView) this.mView).getView().getVisibility() == 0) {
            ((IGlobalLocationView) this.mView).setVisibility(4);
        }
    }

    public void switchViewForGetOnAndOff(int i) {
        this.f3286c = i;
        doPublish(BaseEventKeys.Map.EVENT_SWITCH_VIEW_FOR_GET_ON_AND_OFF_MAP, Integer.valueOf(i));
    }
}

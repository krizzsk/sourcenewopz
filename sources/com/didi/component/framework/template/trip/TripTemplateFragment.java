package com.didi.component.framework.template.trip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.util.Supplier;
import androidx.core.view.GravityCompat;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.TripSwitchSceneEvent;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.animator.GlobalXPanelAnimatorWithAlphaImpl;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.common.model.PermissionResults;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.component.confirmupdateaddress.OnServiceUpdateAddressComponent;
import com.didi.component.confirmupdateaddress.view.IUpdateAddress;
import com.didi.component.core.IComponent;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.framework.template.TemplateUtils;
import com.didi.component.framework.template.common.CommonTemplateFragment;
import com.didi.component.framework.template.common.CommonTemplatePresenter;
import com.didi.component.framework.template.endservice.EndServiceTemplatePresenter;
import com.didi.component.framework.template.trip.scene.EndServiceCompScene;
import com.didi.component.framework.template.trip.scene.ICompScene;
import com.didi.component.framework.template.trip.scene.OnServiceCompScene;
import com.didi.component.framework.template.trip.scene.WaitCompScene;
import com.didi.component.framework.template.trip.view.PayNoPsdView;
import com.didi.component.framework.util.TripApolloUtils;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.ComponentConfigManager;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.LockScreenUtilKt;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didiglobal.enginecore.data.model.XEDataHandleModel;
import com.didiglobal.travel.biz.ride.CarOrderUtils;
import com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy;
import com.didiglobal.travel.biz.ride.trip.TripBehaviorController;
import com.didiglobal.travel.util.Preconditions;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class TripTemplateFragment extends CommonTemplateFragment {
    public static final String DELIVERY_LIMIT_KEY = "delivery_limit";
    public static final int DELIVERY_LIMIT_MAX = 5;
    public static final String DELIVERY_PLACE_STRING = "{{product_name}}";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f13976c = TripTemplateFragment.class.getSimpleName();

    /* renamed from: d */
    private static final int f13977d = 20000;

    /* renamed from: a */
    int f13978a = -1;

    /* renamed from: b */
    EndServiceTemplatePresenter f13979b;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f13980e = -1;

    /* renamed from: f */
    private ICompScene f13981f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RelativeLayout f13982g;

    /* renamed from: h */
    private FrameLayout f13983h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PayNoPsdView f13984i;

    /* renamed from: j */
    private boolean f13985j = true;

    /* renamed from: k */
    private PayTimeoutHandler f13986k;

    /* renamed from: l */
    private XEDataHandleModel f13987l;

    /* renamed from: m */
    private IComponent f13988m;

    /* renamed from: n */
    private IComponent f13989n;

    /* renamed from: o */
    private ViewGroup f13990o;

    /* renamed from: p */
    private BaseEventPublisher.OnEventListener<Boolean> f13991p = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                TripTemplateFragment.this.showFlex();
                TripTemplateFragment.this.mLogger.info("lxslxs: showFlex", new Object[0]);
                return;
            }
            TripTemplateFragment.this.hideFlex();
            TripTemplateFragment.this.mLogger.info("lxslxs: hideFlex", new Object[0]);
        }
    };

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener<TripSwitchSceneEvent> f13992q = new BaseEventPublisher.OnEventListener<TripSwitchSceneEvent>() {
        public void onEvent(String str, TripSwitchSceneEvent tripSwitchSceneEvent) {
            if (tripSwitchSceneEvent != null && tripSwitchSceneEvent.scene != -1) {
                if (!(tripSwitchSceneEvent.bundle == null || TripTemplateFragment.this.f13979b == null)) {
                    TripTemplateFragment.this.f13979b.setArguments(tripSwitchSceneEvent.bundle);
                }
                if (!tripSwitchSceneEvent.waitXpanelEvent) {
                    int unused = TripTemplateFragment.this.f13980e = tripSwitchSceneEvent.scene;
                    TripTemplateFragment.this.f13978a = -1;
                    TripTemplateFragment tripTemplateFragment = TripTemplateFragment.this;
                    tripTemplateFragment.m9736a(tripTemplateFragment.f13980e, TripTemplateFragment.this.f13982g, true);
                    TripTemplateFragment.this.mLogger.info("lxslxs: loadComponentsByScene", new Object[0]);
                    return;
                }
                GLog.m7965d(TripTemplateFragment.f13976c, "switch scene wait xpanel");
                TripTemplateFragment.this.f13978a = tripSwitchSceneEvent.scene;
                TripTemplateFragment.this.m9735a(1000);
            }
        }
    };

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1040;
    }

    /* access modifiers changed from: protected */
    public int currentVersionCode() {
        return 2;
    }

    public int getRootLayout() {
        return R.layout.global_fragment_trip_new;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == SctxBTMView.Companion.getBLE_REQUEST_CODE()) {
            PermissionResults permissionResults = new PermissionResults();
            permissionResults.permissions = strArr;
            permissionResults.results = iArr;
            permissionResults.requestCode = i;
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_PERMISSION_RESULT, permissionResults);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13980e = arguments.getInt(BaseExtras.Trip.EXTRA_TRIP_SCENE, -1);
            if (arguments.getSerializable(BaseExtras.Common.EXTRA_GETON_TO_RSP) instanceof XEDataHandleModel) {
                this.f13987l = (XEDataHandleModel) arguments.getSerializable(BaseExtras.Common.EXTRA_GETON_TO_RSP);
            }
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.EVENT_HIDE_HOME_NEW_USER_GUIDE, true);
        m9743b();
    }

    /* renamed from: b */
    private void m9743b() {
        OrderFloatWindowManager.Instance().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Intent intent = new Intent(DIDIApplication.getAppContext(), SchemeDispatcherImpl.class);
                intent.addFlags(268435456);
                DIDIApplication.getAppContext().startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStartImpl() {
        super.onStartImpl();
        m9747c();
        if (this.f13985j) {
            m9751e();
            this.f13985j = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStopImpl() {
        super.onStopImpl();
    }

    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        m9749d();
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13985j = true;
        return super.onCreateViewImpl(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        this.f13982g = relativeLayout;
        m9737a(requireContext());
        int i = this.f13980e;
        if (i != -1) {
            m9736a(i, relativeLayout, false);
        }
    }

    /* access modifiers changed from: protected */
    public CommonTemplatePresenter onCreateTopPresenter() {
        EndServiceTemplatePresenter endServiceTemplatePresenter = new EndServiceTemplatePresenter(getBusinessContext(), getArguments());
        this.f13979b = endServiceTemplatePresenter;
        return endServiceTemplatePresenter;
    }

    public int currentScene() {
        return this.f13980e;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() != R.id.global_title_btn_back) {
            return;
        }
        if ("sodaEntrega".equals(ConfProxy.getInstance().getSelectedType())) {
            if (this.mTopPresenter != null) {
                ((CommonTemplatePresenter) this.mTopPresenter).dispatchBackPressed(IPresenter.BackType.TopLeft);
            }
            CarOrderHelper.saveOrder((CarOrder) null);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_CLEAR_MAP_SCENE);
            DRouter.build(NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://sodaEntrega/homePage?noSwitchTab=1").start();
        } else if (this.mTopPresenter != null) {
            ((CommonTemplatePresenter) this.mTopPresenter).dispatchBackPressed(IPresenter.BackType.TopLeft);
        }
    }

    /* access modifiers changed from: protected */
    public int getComboType() {
        if (this.f13980e != 10401) {
            return super.getComboType();
        }
        int currentComboType = FormStore.getInstance().getCurrentComboType();
        if (currentComboType != 4 || !FormStore.getInstance().isTwoPriceBiz()) {
            return currentComboType;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int currentComboType() {
        if (this.f13980e != 10401) {
            return super.currentComboType();
        }
        Bundle arguments = getArguments();
        int currentComboType = BusinessUtils.getCurrentComboType(CarOrderHelper.getOrder(), arguments != null ? arguments.getBoolean(BaseExtras.ConfirmService.EXTRA_SEND_ORDER_IN_WAIT_RSP_PAGE, false) : false);
        Logger logger = this.mLogger;
        logger.info("WaitRspTemplateFragment#comboType:" + currentComboType, new Object[0]);
        return currentComboType;
    }

    /* access modifiers changed from: protected */
    public Animator offerExitAnimation() {
        boolean z;
        if (this.f13982g != null) {
            IGlobalXPanelAnimator iGlobalXPanelAnimator = this.mGlobalXpanelAnimator;
            if (this.f13980e == 10401) {
                iGlobalXPanelAnimator = new GlobalXPanelAnimatorWithAlphaImpl();
                z = CacheApolloUtils.openWaitRspOptimization();
            } else {
                z = false;
            }
            TemplateUtils.toggleBottomInOut(iGlobalXPanelAnimator, false, (View) this.f13982g, (IGlobalXPanelAnimator.VisibilityChangedListener) null, z);
        }
        return null;
    }

    /* renamed from: a */
    private void m9737a(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(UIUtils.dip2pxInt(context, 70.0f), (int) (((float) AppUtils.getStatusBarHeight(context)) + UIUtils.dip2px(context, 15.0f)), UIUtils.dip2pxInt(context, 10.0f), 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        OnServiceUpdateAddressComponent onServiceUpdateAddressComponent = (OnServiceUpdateAddressComponent) inflateComponent(ComponentType.ON_SERVICE_UPDATE_ADDRESS, this.f13982g, layoutParams);
        IUpdateAddress iUpdateAddress = Preconditions.nonNull(onServiceUpdateAddressComponent) ? (IUpdateAddress) onServiceUpdateAddressComponent.getView() : null;
        if (Preconditions.nonNull(iUpdateAddress)) {
            iUpdateAddress.setViewVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        inflateViewlessComponents(ComponentType.PAGE_DATA);
        inflateViewlessComponent(ComponentType.GLOBAL_XENGINE, (Bundle) null);
        inflateViewlessComponent(ComponentType.GLOBAL_X_ENGINE_ORDER_DETAIL_COMPAT, (Bundle) null);
        inflateViewlessComponent("config", (Bundle) null);
        inflateComponent(ComponentType.NEW_XPANEL, this.f13982g, layoutParams2);
        inflateComponent("message", this.f13982g, layoutParams2);
        m9744b(context);
    }

    /* renamed from: b */
    private void m9744b(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        PayNoPsdView payNoPsdView = new PayNoPsdView(context);
        this.f13984i = payNoPsdView;
        payNoPsdView.setLayoutParams(layoutParams);
        if (this.f13984i.getParent() != null) {
            this.f13982g.removeView(this.f13984i);
        }
        this.f13982g.addView(this.f13984i);
        this.f13984i.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9736a(int i, RelativeLayout relativeLayout, boolean z) {
        Logger logger = LoggerFactory.getLogger(f13976c);
        boolean z2 = false;
        logger.info("loadComponentsByScene:" + i, new Object[0]);
        if (Preconditions.nonNull(this.f13981f)) {
            this.f13981f.unLoadComponents();
            if (this.f13988m != null) {
                generateComponentCreator().removeComponent(this.f13988m);
            }
            if (this.f13989n != null) {
                generateComponentCreator().removeComponent(this.f13989n);
            }
        }
        boolean z3 = true;
        switch (i) {
            case 10401:
                this.f13981f = new WaitCompScene(getContext(), generateComponentCreator());
                GGKConfigManager.requestConfig(getActivity(), m9734a(ComponentConfigManager.BUSINESS_SCENE_WAIT), ComponentConfigManager.BUSINESS_SCENE_WAIT, (String) null, "passenger_newPopup");
                WaitRspBehaviorStrategy orPutRspBehavior = TripBehaviorController.getOrPutRspBehavior(1040, (Supplier<WaitRspBehaviorStrategy>) new Supplier<WaitRspBehaviorStrategy>() {
                    public WaitRspBehaviorStrategy get() {
                        return new WaitRspBehaviorStrategy();
                    }
                });
                if (CarOrderUtils.isInBooking(getCarOrder()) || (getCarOrder() == null && FormStore.getInstance().getTransportTime() > 0)) {
                    orPutRspBehavior.setAllowBack(true);
                    z2 = true;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = AppUtils.getStatusBarHeight(getContext());
                this.f13988m = inflateComponent(ComponentType.FLEX_LIST, this.f13983h, layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = GravityCompat.END;
                layoutParams2.topMargin = AppUtils.getStatusBarHeight(getContext());
                this.f13989n = inflateComponent(ComponentType.FLEX_OPTION, this.f13983h, layoutParams2);
                z3 = z2;
                break;
            case 10402:
                this.mLogger.info("lxslxs: hideFlex onservice", new Object[0]);
                hideFlex();
                this.f13981f = new OnServiceCompScene(getContext(), generateComponentCreator());
                if (CarOrderHelper.getOrder() != null) {
                    String str = CarOrderHelper.getOrder().substatus == 4006 ? ComponentConfigManager.BUSINESS_SCENE_ON_TRIP : ComponentConfigManager.BUSINESS_SCENE_PICK_UP;
                    GGKConfigManager.requestConfig(getActivity(), m9734a(str), str, (String) null, "passenger_newPopup");
                }
                m9753f();
                break;
            case 10403:
                hideFlex();
                this.f13981f = new EndServiceCompScene(getContext(), generateComponentCreator());
                GGKConfigManager.requestConfig(getActivity(), m9734a(ComponentConfigManager.BUSINESS_SCENE_END), ComponentConfigManager.BUSINESS_SCENE_END, (String) null, "passenger_newPopup");
                break;
        }
        if (!Preconditions.isNull(this.f13981f)) {
            Bundle arguments = getArguments();
            if (Preconditions.nonNull(arguments)) {
                arguments.putBoolean(IGroupView.BACK_VISIBILITY, z3);
            }
            m9738a(relativeLayout, z3, z);
        }
    }

    /* renamed from: a */
    private Map<String, Object> m9734a(String str) {
        String str2;
        String str3 = CarOrderHelper.getOrder() != null ? CarOrderHelper.getOrder().oid : "";
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str3);
        if (str.equals(ComponentConfigManager.BUSINESS_SCENE_PICK_UP)) {
            hashMap.put("has_overlay_permission", Boolean.valueOf(LockScreenUtilKt.hasOverlayPermission(getActivity())));
            if (AppUtils.isBrazilApp(getContext())) {
                str2 = getContext().getString(R.string.app_name_99);
            } else {
                str2 = getContext().getString(R.string.app_name_global);
            }
            hashMap.put("app_name", str2);
        }
        return hashMap;
    }

    /* renamed from: c */
    private void m9747c() {
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.Trip.EVENT_TRIP_SCENE_SWITCH, this.f13992q);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, this.f13991p);
    }

    /* renamed from: d */
    private void m9749d() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.Trip.EVENT_TRIP_SCENE_SWITCH, this.f13992q);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, this.f13991p);
    }

    public View getFallbackView() {
        return this.f13990o;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9735a(int i) {
        if (this.f13978a != -1) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    if (TripTemplateFragment.this.isAdded() && TripTemplateFragment.this.f13978a != -1) {
                        TripTemplateFragment tripTemplateFragment = TripTemplateFragment.this;
                        int unused = tripTemplateFragment.f13980e = tripTemplateFragment.f13978a;
                        TripTemplateFragment tripTemplateFragment2 = TripTemplateFragment.this;
                        tripTemplateFragment2.m9736a(tripTemplateFragment2.f13980e, TripTemplateFragment.this.f13982g, true);
                        TripTemplateFragment.this.mLogger.info("lxslxs: post loadComponentsByScene", new Object[0]);
                        TripTemplateFragment.this.f13978a = -1;
                    }
                }
            }, (long) i);
        }
    }

    /* renamed from: a */
    private void m9738a(RelativeLayout relativeLayout, boolean z, boolean z2) {
        setBackVisible(z);
        this.f13981f.loadComponents(relativeLayout);
        if (z2) {
            m9751e();
        }
    }

    /* renamed from: e */
    private void m9751e() {
        CarOrder order = CarOrderHelper.getOrder();
        if (!Preconditions.isNull(order) && !TextUtils.isEmpty(order.oid)) {
            if (Preconditions.isNull(this.f13987l)) {
                XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
                return;
            }
            JsonObject nextActionJsonObject = this.f13987l.getNextActionJsonObject();
            if (Preconditions.nonNull(nextActionJsonObject)) {
                XEngineReq.engineDispatch(nextActionJsonObject, XERequestKey.SCENE_TRIP);
            }
            String nextAction = this.f13987l.getNextAction();
            if (!TextUtils.isEmpty(nextAction)) {
                DRouter.build(nextAction).start();
            }
            this.f13987l = null;
        }
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        super.initViews();
        this.f13983h = (FrameLayout) this.mRootView.findViewById(R.id.flex_driver_container);
        int statusBarHeight = AppUtils.getStatusBarHeight(getContext());
        ViewGroup.LayoutParams layoutParams = this.mTitleBackBtn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = statusBarHeight;
            this.mTitleBackBtn.setLayoutParams(layoutParams);
        }
        ViewGroup viewGroup = (ViewGroup) this.mRootView.findViewById(R.id.trip_loading_layout);
        this.f13990o = viewGroup;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams2.topMargin = statusBarHeight;
        this.f13990o.setLayoutParams(layoutParams2);
    }

    public void showFlex() {
        RelativeLayout relativeLayout = this.f13982g;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(0.0f);
        }
        FrameLayout frameLayout = this.f13983h;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    public void hideFlex() {
        RelativeLayout relativeLayout = this.f13982g;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(1.0f);
        }
        FrameLayout frameLayout = this.f13983h;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void updatePaddingTop() {
        this.mTitleBackBtn.post(new Runnable() {
            public void run() {
                if (TripTemplateFragment.this.mTopPresenter != null) {
                    int tripMapPaddingTop = TripApolloUtils.INSTANCE.getTripMapPaddingTop();
                    GLog.m7964d("updatePaddingTop:tripMapPaddingTop:" + tripMapPaddingTop);
                    ((CommonTemplatePresenter) TripTemplateFragment.this.mTopPresenter).onPaddingTopChanged(UiUtils.dip2px(TripTemplateFragment.this.getContext(), (float) tripMapPaddingTop));
                }
            }
        });
    }

    public void setBackVisible(boolean z) {
        super.setBackVisible(z);
        updatePaddingTop();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ("sodaEntrega".equals(ConfProxy.getInstance().getSelectedType())) {
            CarOrderHelper.saveOrder((CarOrder) null);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_CLEAR_MAP_SCENE);
            DRouter.build(NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://sodaEntrega/homePage?noSwitchTab=1").start();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: f */
    private void m9753f() {
        int intValue = ((Integer) SPUtils.get(getContext(), DELIVERY_LIMIT_KEY, 0)).intValue();
        if (intValue < 5 && CarOrderHelper.getOrder() != null && !TextUtils.isEmpty(CarOrderHelper.getOrder().toastData)) {
            final ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.vs_title_tips_guide);
            try {
                View inflate = viewStub.inflate();
                ((TextView) inflate.findViewById(R.id.tv_title_guide_text)).setText(CarOrderHelper.getOrder().toastData.replace(DELIVERY_PLACE_STRING, NationTypeUtil.getNationComponentData().getBrand()));
                inflate.findViewById(R.id.iv_title_guide_close).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        SPUtils.put(TripTemplateFragment.this.getContext(), TripTemplateFragment.DELIVERY_LIMIT_KEY, 5);
                        ViewStub viewStub = viewStub;
                        if (viewStub != null) {
                            viewStub.setVisibility(8);
                        }
                        GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_deliverymultiple_close_ck");
                    }
                });
                SPUtils.put(getContext(), DELIVERY_LIMIT_KEY, Integer.valueOf(intValue + 1));
            } catch (Exception e) {
                e.printStackTrace();
                if (viewStub != null) {
                    viewStub.setVisibility(0);
                }
            }
            GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_deliverymultiple_sw");
        }
    }

    public void showPayProcessLoading() {
        if (this.f13984i.getVisibility() != 0) {
            float dip2px = (float) UiUtils.dip2px(getContext(), 51.5f);
            this.f13984i.setTranslationY(dip2px);
            this.f13984i.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13984i, "translationY", new float[]{dip2px, 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f13984i, "alpha", new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.start();
        }
    }

    public void showPayProcessLoading4XPanel() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_DOWN, Integer.valueOf(UiUtils.dip2px(getContext(), 51.5f)));
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_TRIP_END_DISMISS_WHEN_PAYING, true);
        m9755g();
    }

    private static class PayTimeoutHandler extends Handler {
        private final WeakReference<TripTemplateFragment> ref;

        public PayTimeoutHandler(TripTemplateFragment tripTemplateFragment) {
            this.ref = new WeakReference<>(tripTemplateFragment);
        }

        public void handleMessage(Message message) {
            if (this.ref.get() != null) {
                ((TripTemplateFragment) this.ref.get()).m9741a(true);
            }
        }
    }

    /* renamed from: g */
    private void m9755g() {
        PayTimeoutHandler payTimeoutHandler = new PayTimeoutHandler(this);
        this.f13986k = payTimeoutHandler;
        payTimeoutHandler.sendEmptyMessageDelayed(1, 20000);
    }

    public void hidePayProcessLoading() {
        super.hidePayProcessLoading();
        m9741a(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9741a(boolean z) {
        if (this.f13984i.getVisibility() == 0 || z) {
            PayTimeoutHandler payTimeoutHandler = this.f13986k;
            if (payTimeoutHandler != null) {
                payTimeoutHandler.removeCallbacksAndMessages((Object) null);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13984i.getInnerLayout(), "translationY", new float[]{0.0f, (float) (-UiUtils.dip2px(getContext(), 51.5f))});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f13984i, "alpha", new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_UP, 0);
                }

                public void onAnimationEnd(Animator animator) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_TRIP_END_DISMISS_WHEN_PAYING, false);
                    TripTemplateFragment.this.f13984i.setVisibility(8);
                }
            });
            animatorSet.setDuration(250).start();
        }
    }
}

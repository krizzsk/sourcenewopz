package com.didi.component.framework.template.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.xbanner.XBannerConstants;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.model.CPFBlockingModel;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.FireBaseEventUtils;
import com.didi.component.common.util.LocationController;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.framework.template.common.CommonTemplatePresenter;
import com.didi.component.framework.template.common.ICommonTemplateView;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.ActivityStack;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.misconfig.p153v2.SecondConfProxy;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.push.IMEITrackUtil;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.WeakReferenceUtils;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class HomeTemplatePresenter extends CommonTemplatePresenter {

    /* renamed from: a */
    private static final String f13968a = HomeTemplatePresenter.class.getSimpleName();

    /* renamed from: b */
    private BusinessContext f13969b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SceneHelper f13970c = SceneHelper.getInstance();

    /* renamed from: d */
    private ILocation.ILocationChangedListener f13971d = new ILocation.ILocationChangedListener() {
        private int mDistance = ((Integer) GlobalApolloUtils.getParamByStatus("refresh_product_conf_distance_filter", "rideMenu", 200, true)).intValue();
        private DIDILocation mLastDiDiLocation;

        public void onLocationChanged(DIDILocation dIDILocation) {
            DIDILocation lastLocation;
            if (dIDILocation != null && ActivityLifecycleManager.getInstance().isAppActive()) {
                DIDILocation dIDILocation2 = this.mLastDiDiLocation;
                if (dIDILocation2 == null || dIDILocation.distanceTo(dIDILocation2) > ((double) this.mDistance)) {
                    if (!(this.mLastDiDiLocation == null || (lastLocation = LocationPerformer.getInstance().getLastLocation()) == null)) {
                        SecondConfProxy.getInstance().getSecConfigFromNet(lastLocation.getLongitude(), lastLocation.getLatitude(), OneConfStore.getInstance().getCityId());
                    }
                    this.mLastDiDiLocation = dIDILocation;
                }
            }
        }
    };

    public HomeTemplatePresenter(BusinessContext businessContext, Bundle bundle) {
        super(businessContext, bundle);
        this.f13969b = businessContext;
        m9723c();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            doPublish(BaseEventKeys.Template.EVENT_CLOSE_FENCE_BACK_HOME, (Address) intent.getSerializableExtra("fence_to_home_address"));
        }
    }

    /* renamed from: b */
    private void m9721b() {
        try {
            IMEITrackUtil.INSTANCE.trackIMEI(this.mContext);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m9721b();
        GlobalApolloUtil.addToTotalSample(GlobalApolloUtil.AB_KEY_ROUTE_EDITOR);
        GlobalApolloUtil.addToTotalSample(GlobalApolloUtil.KEY_NEW_UI_TRIP);
        DDTravelOrderStore.setOrder((ICarOrder) null);
        if (this.mContext != null && CacheApolloUtils.isNewCPFBlockingOpen() == -1) {
            CarRequest.getCPFBlockingSuffixApollo(this.mContext, (ResponseListener<CPFBlockingModel>) null);
        }
        this.f13969b.hideBizBarDivider();
        TripRecordingManager.Companion.getInstance().resumeUploadTasks();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        this.mComponentProxy.updateOrderId(this.mComponentProxy.getPageId(), "");
        this.mComponentProxy.destroySession();
        super.onBackHome(bundle);
        CarOrderHelper.saveOrder((CarOrder) null);
        registerListener();
        this.f13969b.restoreTitleBar();
        this.f13969b.showBizBar();
        this.f13969b.hideBizBarDivider();
        Boolean bool = false;
        try {
            bool = (Boolean) FormStore.getInstance().getData(FormStore.KEY_RECALL_ORDER);
        } catch (Exception unused) {
        }
        if (bool == null || !bool.booleanValue()) {
            FormStore.getInstance().clear();
            FormStore.getInstance().setDepartureAddress((Address) null);
            FormStore.getInstance().setTransportTime(0);
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(IGroupView.BACK_VISIBILITY, true);
            this.mComponentProxy.createSession(TravelConstant.SESSION_TAG_HOME_AUTO_SEND_ORDER);
            forward(1030, bundle2);
        }
        trackPageShowEvent("AOA", (HashMap<String, Object>) null);
        FormStore.getInstance().setSeatCount(1);
        if (TripRecordingManager.Companion.getInstance().isRecording()) {
            TripRecordingManager.Companion.getInstance().stopAndUpload();
            ToastHelper.showShortCompleted(this.mContext, (int) R.string.global_record_stop_toast);
        }
        SafeToolKit.getIns().setProductId(ConfProxy.getInstance().getSelectedGroupId());
        SafeToolKit.getIns().setBusinessType("ride");
        if (!GlobalApolloUtil.isHomeEngine()) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, XBannerConstants.PageState.HOME_KEEP_PAGE_STATE);
        }
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        unregisterListener();
        this.f13969b.hideTitleBar();
        this.f13969b.hideBizBar();
    }

    /* access modifiers changed from: protected */
    public void trackPageShowEvent(final String str, final HashMap<String, Object> hashMap) {
        ApmThreadPool.executeOnSingle(new Runnable() {
            public void run() {
                if (HomeTemplatePresenter.this.f13970c.isTargetTopVisible(HomeTemplatePresenter.this.mContext, HomeTemplateFragment.class)) {
                    GlobalOmegaUtils.putGlobal("g_PageId", "home");
                    HashMap hashMap = new HashMap();
                    DIDILocation lastKnownLocation = LocationController.getInstance().getLastKnownLocation(HomeTemplatePresenter.this.mContext);
                    if (lastKnownLocation != null) {
                        hashMap.put("lng", Double.valueOf(lastKnownLocation.getLongitude()));
                        hashMap.put("lat", Double.valueOf(lastKnownLocation.getLatitude()));
                    } else {
                        hashMap.put("lng", 0);
                        hashMap.put("lat", 0);
                    }
                    hashMap.put("openNotification", Integer.valueOf(NotificationUtils.isNotificationEnabled(HomeTemplatePresenter.this.mContext) ? 1 : 0));
                    hashMap.put("scene", str);
                    HashMap hashMap2 = hashMap;
                    if (hashMap2 != null) {
                        hashMap.putAll(hashMap2);
                    }
                    hashMap.put("city_id", NationComponentDataUtil.getLocCityId());
                    hashMap.put("country_code", NationComponentDataUtil.getLocCountry());
                    SceneHelper.getInstance().setParamsAMA(hashMap);
                    GlobalOmegaUtils.trackEvent("pas_home_sw", (Map<String, Object>) hashMap);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        if (this.f13970c.isFromSA()) {
            trackPageShowEvent("sa", this.f13970c.saMap);
            this.f13970c.setFromSA(false, (HashMap<String, Object>) null);
            this.f13970c.setFirstLaunchHome(false);
        } else if (this.f13970c.isFirstLaunchHome()) {
            trackPageShowEvent("ALoginA", (HashMap<String, Object>) null);
            this.f13970c.setFirstLaunchHome(false);
        } else if (this.f13970c.isFromLoginHome()) {
            trackPageShowEvent("ALoginA", (HashMap<String, Object>) null);
            this.f13970c.setFromLoginHome(false);
        } else if (this.f13970c.isFromBackStackHome()) {
            trackPageShowEvent("ABA", (HashMap<String, Object>) null);
            this.f13970c.setFromBackStackHome(false);
        } else {
            trackPageShowEvent("AOA", (HashMap<String, Object>) null);
        }
        if (!GlobalApolloUtil.isHomeEngine()) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, XBannerConstants.PageState.HOME_KEEP_PAGE_STATE);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        if (((ICommonTemplateView) this.mView).hidePopupComponent(ComponentType.EVALUATE)) {
            return true;
        }
        return super.onBackPressed(backType);
    }

    /* renamed from: c */
    private void m9723c() {
        ICollector iCollector;
        ActivityStack.addStackChangedListener(new StaticOnStackChangedListener(this));
        NationComponentDataUtil.addLoginlistener(new LoginListeners.LoginListener() {
            public void onCancel() {
            }

            public void onSuccess(Activity activity, String str) {
                HomeTemplatePresenter.this.f13970c.setFromLoginHome(true);
                HomeTemplatePresenter.this.f13970c.setFromLoginGuess(true);
                if (HomeTemplatePresenter.this.mContext != null && !OneLoginFacade.getStore().isNewUser()) {
                    FireBaseEventUtils.traceEvent(LoginOmegaUtil.LOGIN_SUCCESS_SW, true);
                }
                FormStore.getInstance().setOrderBan(false);
            }
        });
        if (GlobalApolloUtil.allowUseRemoteConfig() && (iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class, IMSType.GMS)) != null) {
            LogUtil.m26099i(f13968a, "addSceneListener : gmsCollector is load");
            iCollector.remoteConfig(this.mContext, new Runnable() {
                public void run() {
                    FireBaseEventUtils.traceEvent("prediction_sign_up", false);
                }
            });
        }
    }

    private static class StaticOnStackChangedListener implements ActivityStack.OnStackChangedListener {
        private WeakReference<HomeTemplatePresenter> mWeakHomeTemplatePresenter;

        public void onPop(Activity activity) {
        }

        public void onPush(Activity activity) {
        }

        public void onStackGonnaEmpty(Activity activity) {
        }

        public StaticOnStackChangedListener(HomeTemplatePresenter homeTemplatePresenter) {
            this.mWeakHomeTemplatePresenter = new WeakReference<>(homeTemplatePresenter);
        }

        public void onAppPause() {
            SceneHelper b;
            HomeTemplatePresenter homeTemplatePresenter = (HomeTemplatePresenter) WeakReferenceUtils.getObj(this.mWeakHomeTemplatePresenter);
            if (homeTemplatePresenter != null && (b = homeTemplatePresenter.f13970c) != null) {
                b.setFromBackStackHome(true);
                b.setFromBackStackGuess(true);
                b.setFromBackStackBubble(true);
                b.setAppOnResume(false);
                b.setFromBackStackEta(true);
                b.isFromBackStackEstimate = true;
            }
        }

        public void onAppResume() {
            SceneHelper b;
            HomeTemplatePresenter homeTemplatePresenter = (HomeTemplatePresenter) WeakReferenceUtils.getObj(this.mWeakHomeTemplatePresenter);
            if (homeTemplatePresenter != null && (b = homeTemplatePresenter.f13970c) != null) {
                b.setAppOnResume(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void registerListener() {
        super.registerListener();
        LocationPerformer.getInstance().addLocationListener(this.f13971d);
    }

    /* access modifiers changed from: protected */
    public void unregisterListener() {
        super.unregisterListener();
        LocationPerformer.getInstance().removeLocationListener(this.f13971d);
    }
}

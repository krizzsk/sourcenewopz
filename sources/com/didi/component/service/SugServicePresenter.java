package com.didi.component.service;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.component.business.bizconfig.BizConfigFacade;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.deeplink.DeeplinkDispatcherFragment;
import com.didi.component.business.event.DeepLinkEvent;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.dialog.LoadingDialogInfo;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.store.FetchCallback;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.taxis99.R;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SugServicePresenter extends AbsServicePresenter {

    /* renamed from: a */
    private static final int f15616a = 100;

    /* renamed from: b */
    private static final int f15617b = 101;

    /* renamed from: c */
    private boolean f15618c = true;

    /* renamed from: d */
    private boolean f15619d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ForwardConfirmPage f15620e = new ForwardConfirmPage();

    /* renamed from: f */
    private Address f15621f;

    /* renamed from: g */
    private Address f15622g;

    /* renamed from: h */
    private boolean f15623h;

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<SugResult> f15624i = new BaseEventPublisher.OnEventListener<SugResult>() {
        public void onEvent(String str, SugResult sugResult) {
            SystemUtils.log(6, "ccc", "mSugPageCallbackListener", (Throwable) null, "com.didi.component.service.SugServicePresenter$1", 271);
            SugServicePresenter.this.handleSugPageResult(sugResult);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Bundle f15625j;

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener<Bundle> f15626k = new BaseEventPublisher.OnEventListener<Bundle>() {
        public void onEvent(String str, Bundle bundle) {
            SystemUtils.log(6, "ccc", "mSugPage wayponit CallbackListener", (Throwable) null, "com.didi.component.service.SugServicePresenter$2", 280);
            Bundle unused = SugServicePresenter.this.f15625j = bundle;
            NationComponentDataUtil.goToLoginPageForResult(SugServicePresenter.this.getHost(), SugServicePresenter.this.requestCodeForHost(78));
        }
    };

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<DeepLinkEvent> f15627l = new BaseEventPublisher.OnEventListener<DeepLinkEvent>() {
        public void onEvent(String str, DeepLinkEvent deepLinkEvent) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            if (deepLinkEvent != null && !deepLinkEvent.isSameAddress()) {
                SugServicePresenter.this.m11388c();
                SugServicePresenter.this.f15620e.setDeepLinkEvent(deepLinkEvent);
                UiThreadHandler.postDelayed(SugServicePresenter.this.f15620e, 300);
            }
        }
    };
    protected BusinessContext mBusinessContext;
    protected Address mEndAddress;
    protected Address mStartAddress;

    public SugServicePresenter(ComponentParams componentParams) {
        super(componentParams);
        SystemUtils.log(6, "ccc", "SugServicePresenter -create", (Throwable) null, "com.didi.component.service.SugServicePresenter", 64);
        this.mBusinessContext = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        SystemUtils.log(6, "ccc", "SugServicePresenter -onAdd", (Throwable) null, "com.didi.component.service.SugServicePresenter", 70);
        super.onAdd(bundle);
        registerListener();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unregisterListener();
    }

    /* access modifiers changed from: protected */
    public void registerListener() {
        SystemUtils.log(6, "ccc", "registerListener -EVENT_SUG_PAGE_RESULT_CALLBACK", (Throwable) null, "com.didi.component.service.SugServicePresenter", 82);
        subscribe(BaseEventKeys.Map.EVENT_SUG_PAGE_RESULT_CALLBACK, this.f15624i);
        subscribe(BaseEventKeys.Map.EVENT_SUG_PAGE_WAYPOINTS_RESULT_CALLBACK, this.f15626k);
        EventBus.getDefault().register(this);
        subscribe(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f15627l);
    }

    /* access modifiers changed from: protected */
    public void unregisterListener() {
        SystemUtils.log(6, "ccc", "unregisterListener -EVENT_SUG_PAGE_RESULT_CALLBACK", (Throwable) null, "com.didi.component.service.SugServicePresenter", 90);
        unsubscribe(BaseEventKeys.Map.EVENT_SUG_PAGE_RESULT_CALLBACK, this.f15624i);
        unsubscribe(BaseEventKeys.Map.EVENT_SUG_PAGE_WAYPOINTS_RESULT_CALLBACK, this.f15626k);
        EventBus.getDefault().unregister(this);
        unsubscribe(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, this.f15627l);
        UiThreadHandler.removeCallbacks(this.f15620e);
        hideLoading();
    }

    /* renamed from: b */
    private Address m11384b() {
        Address reverseAddress = LocationController.getInstance() != null ? LocationController.getInstance().getReverseAddress() : null;
        if (reverseAddress == null) {
            reverseAddress = new Address();
            reverseAddress.setLatitude(0.0d);
            reverseAddress.setLongitude(0.0d);
            reverseAddress.setCityId(-1);
            String string = this.mContext.getResources().getString(R.string.global_sug_current_location);
            reverseAddress.setDisplayName(string);
            reverseAddress.setAddress(string);
            reverseAddress.setFullName(string);
        }
        if (FormStore.getInstance().isFromOpenRide() && FormStore.getInstance().getDriverInfo() != null) {
            reverseAddress.setLatitude(Double.valueOf(FormStore.getInstance().getDriverInfo().driverLat).doubleValue());
            reverseAddress.setLongitude(Double.valueOf(FormStore.getInstance().getDriverInfo().driverLng).doubleValue());
        }
        return reverseAddress;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchInterceptStartAddress(Address address) {
        if (!EnvPreferenceUtil.getBooleanSafely(DIDIApplication.getAppContext(), "mis_fetch_net_enable", true)) {
        }
        return false;
    }

    /* renamed from: a */
    private void m11381a(Address address) {
        if (address != null) {
            m11388c();
            this.f15619d = true;
            CarRequest.getMisConfigFromNet(address.latitude, address.longitude, address.cityId, (FetchCallback<List<CarGrop>>) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11388c() {
        LoadingDialogInfo loadingDialogInfo = new LoadingDialogInfo(100);
        loadingDialogInfo.setMessage(ResourcesHelper.getString(this.mContext, R.string.loading));
        loadingDialogInfo.setCancelable(false);
        showDialog(loadingDialogInfo);
    }

    /* renamed from: a */
    private void m11383a(Address address, boolean z, Address address2) {
        if (!NationComponentDataUtil.isLoginNow()) {
            this.f15623h = z;
            this.f15621f = address;
            this.f15622g = address2;
            NationComponentDataUtil.goToLoginPageForResult(getHost(), requestCodeForHost(70));
            return;
        }
        this.f15623h = false;
        this.f15621f = null;
        this.f15622g = null;
        m11382a(address, z);
        m11386b(address2);
        Bundle bundle = new Bundle();
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        if (this.mComponentProxy.getSession() == null) {
            bundle = TravelUtil.getBundleOnCreateSession(bundle, true, TravelConstant.SESSION_TAG_NEW_SUG_SET_RESULT, false);
        }
        bundle.putString("page_source", "page_sug");
        forward(1030, bundle);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle bundle;
        Address address;
        super.onActivityResult(i, i2, intent);
        if (i == 70 && i2 == -1) {
            Address address2 = this.f15621f;
            if (address2 != null && (address = this.f15622g) != null) {
                m11383a(address2, this.f15623h, address);
            }
        } else if (i == 78 && i2 == -1 && (bundle = this.f15625j) != null) {
            forward(1030, bundle);
        }
    }

    /* renamed from: b */
    private void m11386b(Address address) {
        FormStore instance = FormStore.getInstance();
        if (address != null) {
            instance.setEndAddress(address);
        } else {
            GLog.m7964d("setAddress null");
        }
    }

    /* renamed from: a */
    private void m11382a(Address address, boolean z) {
        if (address != null) {
            FormStore.getInstance().setStartAddress(address, z);
        } else {
            GLog.m7964d("setAddress null");
        }
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (i == 101) {
            if (i2 == 1) {
                GlobalOmegaUtils.trackEvent("pas_onconffail_return_ck");
                goBack();
            } else if (i2 == 2) {
                m11381a(this.mStartAddress);
                GlobalOmegaUtils.trackEvent("pas_onconffailure_retry_ck");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void handleSugPageResult(SugResult sugResult) {
        if (sugResult != null) {
            SystemUtils.log(6, "ccc", "handleSugPageResult:" + sugResult.toString(), (Throwable) null, "com.didi.component.service.SugServicePresenter", 312);
            this.mStartAddress = sugResult.start;
            Address address = sugResult.end;
            this.mEndAddress = address;
            if (address != null) {
                SearchIdUploadManager.getInstance().addSearchId(this.mEndAddress.searchId);
            }
            this.f15618c = sugResult.isStartNeedNearRoad;
            if (this.mStartAddress == null) {
                this.mStartAddress = m11384b();
            }
            Address address2 = this.mStartAddress;
            if (address2 == null || this.mEndAddress == null) {
                GLog.m7973w("handleSugPageResult mEndAddress:" + this.mEndAddress);
                goBack();
            } else if (!dispatchInterceptStartAddress(address2)) {
                m11383a(this.mStartAddress, sugResult.isStartNeedNearRoad, this.mEndAddress);
            }
        } else {
            SystemUtils.log(6, "ccc", "handleSugPageResult: null", (Throwable) null, "com.didi.component.service.SugServicePresenter", 334);
            GLog.m7973w("handleSugPageResult addressResult is null");
            goBack();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(CarInfoUpdateEvent carInfoUpdateEvent) {
        Address address;
        if (this.f15619d && carInfoUpdateEvent != null && EventKeys.MisConfig.CAR_INFO_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag)) {
            this.f15619d = false;
            hideLoading();
            dismissDialog(100);
            if (carInfoUpdateEvent.result == 1) {
                doPublish(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET);
                Address address2 = this.mStartAddress;
                if (!(address2 == null || (address = this.mEndAddress) == null)) {
                    m11383a(address2, this.f15618c, address);
                }
                BizConfigFacade.getInstance().sendRequest(this.mBusinessContext);
                GlobalOmegaUtils.setBusinessId(this.mBusinessContext);
            }
        }
    }

    private class ForwardConfirmPage implements Runnable {
        private DeepLinkEvent mDeepLinkEvent;

        private ForwardConfirmPage() {
        }

        public void run() {
            SugServicePresenter.this.hideLoading();
            Bundle bundle = new Bundle();
            DeepLinkEvent deepLinkEvent = this.mDeepLinkEvent;
            if (deepLinkEvent != null) {
                bundle.putSerializable("deeplink_context", deepLinkEvent);
            }
            SugServicePresenter.this.forward((Class<? extends Fragment>) DeeplinkDispatcherFragment.class, bundle);
            this.mDeepLinkEvent = null;
        }

        public void setDeepLinkEvent(DeepLinkEvent deepLinkEvent) {
            this.mDeepLinkEvent = deepLinkEvent;
        }
    }
}

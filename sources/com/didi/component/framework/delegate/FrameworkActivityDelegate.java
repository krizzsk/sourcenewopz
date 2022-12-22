package com.didi.component.framework.delegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.ViewGroup;
import com.android.didi.theme.DidiThemeManager;
import com.didi.app.router.PageRouter;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.resource.IMThemeConstant;
import com.didi.component.base.ComponentFramework;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.PaxBizDataGetter;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.track.DidiTrackingClient;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragmentManager;
import com.didi.global.globalgenerickit.drawer.GGKDrawerManager;
import com.didi.onehybrid.FusionEngine;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.apm.utils.RemoteConfiguration;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.app.delegate.ActivityDelegate;
import com.didi.sdk.login.LoginReason;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.oneconf.OneConfData;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.Constant;
import com.didi.sdk.util.LockScreenUtilKt;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.response.CarConfig;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainprocessor.DomainDataContainer;
import com.didiglobal.domainprocessor.service.CompassHandler;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

@ServiceProvider(alias = "extended", value = {ActivityDelegate.class})
public class FrameworkActivityDelegate extends ActivityDelegate {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f13736a;

    /* renamed from: b */
    private LoginListeners.LoginListener f13737b = new LoginListeners.LoginListener() {
        public void onCancel() {
        }

        public void onSuccess(Activity activity, String str) {
            if (activity != null) {
                activity.getApplication();
            } else if (FrameworkActivityDelegate.this.f13736a != null) {
                FrameworkActivityDelegate.this.f13736a.getApplication();
            } else {
                DIDIBaseApplication.getAppContext();
            }
        }
    };

    /* renamed from: c */
    private LoginListeners.LoginOutListener f13738c = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            if (FrameworkActivityDelegate.this.f13736a != null) {
                GlobalSPUtil.setRedPacketOid(FrameworkActivityDelegate.this.f13736a, "");
            }
            GGKDialogFragmentManager.getInstance().dismissAllGGKDialog();
            GGKDrawerManager.dismissGGKDrawer();
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<String> f13739d = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            ELog.log("verify_compass receive countryid change msg: " + str2);
            CompassHandler.getInstance(FrameworkActivityDelegate.this.f13736a).verifyCompass("country_code_change");
        }
    };

    public void onPreCreate(Activity activity) {
        super.onPreCreate(activity);
    }

    public void onCreate(Activity activity) {
        ComponentFramework.supportComponentLayout(activity);
        super.onCreate(activity);
        this.f13736a = activity;
        m9499a(activity);
        OneConfStore.getInstance().addOneConfChangeListener(new OneConfStore.OneConfConfigChangeListener() {
            public void onChanged(OneConfData oneConfData, double d, double d2) {
                if (oneConfData.cityId != -1) {
                    FrameworkActivityDelegate frameworkActivityDelegate = FrameworkActivityDelegate.this;
                    frameworkActivityDelegate.m9499a(frameworkActivityDelegate.f13736a);
                    OneConfStore.getInstance().removeOneConfChangeListener(this);
                }
            }
        });
        OneLoginFacade.getFunction().addLoginListener(this.f13737b);
        OneLoginFacade.getFunction().addLoginOutListener(this.f13738c);
        if (Build.VERSION.SDK_INT >= 18) {
            ((ViewGroup) activity.getWindow().getDecorView()).setLayoutMode(1);
        }
        m9504c();
        m9507f();
        DidiTrackingClient.getInstance().initTrackSDK(this.f13736a);
        m9500a((Context) activity);
        m9502b();
        m9498a();
        m9506e();
        EventBus.getDefault().register(this);
        if (SaApolloUtil.INSTANCE.getSaState()) {
            m9508g();
        }
        if (!SaApolloUtil.INSTANCE.getSaState()) {
            PaxBizDataGetter.setBizDataGetter();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9499a(Activity activity) {
        CarRequest.getConfig(activity, DDTravelConfigStore.getInstance().getCarConfigVersion(), new ResponseListener<CarConfig>() {
            public void onSuccess(CarConfig carConfig) {
                super.onSuccess(carConfig);
                SafeToolKit.getIns().setPolicePhoneFromPGetConfig(DDTravelConfigStore.getInstance().getPolicePhone((JSONObject) null));
            }
        });
    }

    /* renamed from: a */
    private void m9498a() {
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.DomainSwitch.KEY_DOMAINSWITCH_COUNTRY_CODE_CHANGED, this.f13739d);
    }

    /* renamed from: b */
    private void m9502b() {
        CompassHandler.getInstance(this.f13736a).setLogoutListener(new CompassHandler.LogoutListener() {
            public void onLogout() {
                if (OneLoginFacade.getStore().isLoginNow()) {
                    OneLoginFacade.getAction().passiveLogout(FrameworkActivityDelegate.this.f13736a, LoginReason.SIGN_IN_OR_SIGN_OFF_KICK_OFF_DOMAIN_CHANGE, "", "");
                    FormStore.getInstance().clear();
                    DDTravelOrderStore.setOrder((ICarOrder) null);
                }
                Intent intent = new Intent();
                intent.putExtra(Constant.LOGOUT_KEY, true);
                intent.putExtra(Constant.LOGOUT_REASON_SWITCH_SUFFIX_KEY, true);
                intent.setFlags(268435456);
                PageRouter.getInstance().startMainActivity(FrameworkActivityDelegate.this.f13736a, intent);
            }
        });
        if (DomainUtil.isSupportDomainSwitch(this.f13736a)) {
            LocationPerformer.getInstance().addLocationListener(new ILocation.ILocationChangedListener() {
                public void onLocationChanged(DIDILocation dIDILocation) {
                    DomainDataContainer domainDataContainer = (DomainDataContainer) SingletonHolder.getInstance(DomainDataContainer.class);
                    boolean booleanData = domainDataContainer.getBooleanData("verify_compass");
                    ELog.log("    receive locationChanged() hasVerifyCompass = " + booleanData);
                    if (!booleanData) {
                        domainDataContainer.putData("verify_compass", true);
                        CompassHandler.getInstance(FrameworkActivityDelegate.this.f13736a).verifyCompass("location_first_report");
                    }
                    LocationPerformer.getInstance().removeLocationListener(this);
                }
            });
        }
    }

    /* renamed from: c */
    private void m9504c() {
        final boolean isOpen = RemoteConfiguration.isOpen("global_app_preload_webview", false);
        final int intValue = ((Integer) Apollo.getToggle("global_app_preload_webview").getExperiment().getParam("preload_type", 0)).intValue();
        if (isOpen && intValue == 1) {
            m9505d();
        }
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                if (isOpen && intValue == 2) {
                    FrameworkActivityDelegate.this.m9505d();
                }
                FusionEngine.startUp();
            }
        }, 5000);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9505d() {
        if (AppUtils.isRunningInForeground(this.f13736a)) {
            FusionEngine.preloadWebView(this.f13736a);
        }
    }

    /* renamed from: e */
    private void m9506e() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("feature", Integer.valueOf(LockScreenUtilKt.hasLockScreenMap(this.f13736a) ? 1 : 0));
        hashMap.put(ParamKeys.PARAM_SYSTEM_TYPE, Integer.valueOf(Build.VERSION.SDK_INT >= 29 ? 1 : 0));
        hashMap.put("permission_type", Boolean.valueOf(LockScreenUtilKt.hasOverlayPermission(this.f13736a)));
        OmegaSDKAdapter.trackEvent("map_clock_screen_permission_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m9500a(Context context) {
        IMEngine.getInstance(context).registerIMResource(IMThemeConstant.IM_NOEMESSAGE_NEW_ICON, R.drawable.global_im_message_icon_new);
        IMEngine.getInstance(context).registerIMResource("im_nomix_orange", DidiThemeManager.getIns().getResPicker(context).getResIdByTheme(R.attr.caution_color));
        IMEngine.getInstance(context).registerIMResource("im_common_title_bar_btn_back_selector", R.drawable.common_title_bar_btn_back_selector);
        IMEngine.getInstance(context).registerIMResource("im_overtime_icon", R.drawable.global_im_message_icon_overtime);
    }

    /* renamed from: f */
    private void m9507f() {
        ProductControllerStyleManager.getInstance().getProductThemeStyle().setDefaultButtonTextColor(DidiThemeManager.getIns().getResPicker(this.f13736a).getColor(R.attr.caution_color));
    }

    public void onResume(Activity activity) {
        super.onResume(activity);
    }

    public void onDestroy(Activity activity) {
        super.onDestroy(activity);
        FormStore.getInstance().clear();
        OneLoginFacade.getFunction().removeLoginListener(this.f13737b);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f13738c);
        CompassHandler.getInstance(activity).setActivityState(false);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.DomainSwitch.KEY_DOMAINSWITCH_COUNTRY_CODE_CHANGED, this.f13739d);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveCountryCode(ReverseGeoResult reverseGeoResult) {
        DomainDataContainer domainDataContainer = (DomainDataContainer) SingletonHolder.getInstance(DomainDataContainer.class);
        String stringData = domainDataContainer.getStringData("gconf_country_code");
        if (DomainUtil.isSupportDomainSwitch(this.f13736a)) {
            ELog.log("sa reversegeo response success country_code = " + stringData + " ");
            domainDataContainer.putData("gconf_country_code", reverseGeoResult.countryCode);
            if (!TextUtil.isEmpty(stringData) && !stringData.equalsIgnoreCase(reverseGeoResult.countryCode)) {
                CompassHandler.getInstance(this.f13736a).verifyCompass("country_code_change");
            }
        }
    }

    /* renamed from: g */
    private void m9508g() {
        DomainDataContainer domainDataContainer = (DomainDataContainer) SingletonHolder.getInstance(DomainDataContainer.class);
        if (TextUtil.isEmpty(domainDataContainer.getStringData("gconf_country_code"))) {
            domainDataContainer.putData("gconf_country_code", NationTypeUtil.getNationComponentData().getLocCountry());
        }
    }
}

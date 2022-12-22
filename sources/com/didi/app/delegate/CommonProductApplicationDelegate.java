package com.didi.app.delegate;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.theme.DidiThemeManager;
import com.appsflyer.AppsFlyerLib;
import com.didi.app.VisitTrackManager;
import com.didi.app.router.PageRouter;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapsSdkInitialize;
import com.didi.common.map.listener.OnMapsSdkInitializedCallback;
import com.didi.commoninterfacelib.permission.IntentPermissionManager;
import com.didi.commoninterfacelib.permission.PermissionDialogInterface;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.config.ConfigLoader;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.template.yoga.CDNTemplateBinder;
import com.didi.global.ninja.Ninja;
import com.didi.global.ninja.strategy.CountStrategy;
import com.didi.map.global.component.mapviewholder.DDMapInit;
import com.didi.ninja.InternationalNinjaShare;
import com.didi.ninja.NinjaShare;
import com.didi.onekeyshare.ShareConfig;
import com.didi.payment.base.proxy.ConfigProxyHolder;
import com.didi.payment.base.proxy.LocationProxyHolder;
import com.didi.remotereslibrary.IDepartureParam;
import com.didi.remotereslibrary.IDomainParam;
import com.didi.remotereslibrary.ILoginParam;
import com.didi.remotereslibrary.RemoteResourceManager;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityStack;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.OneMessageInit;
import com.didi.sdk.app.delegate.ApplicationDelegate;
import com.didi.sdk.appsflyer.AppsFlyerUtil;
import com.didi.sdk.bff.BffService;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.component.protocol.IA3Manager;
import com.didi.sdk.componentconfig.ComponentStore;
import com.didi.sdk.config.commonconfig.p149sp.CommonConfigSp;
import com.didi.sdk.debug.AppDebugger;
import com.didi.sdk.developermode.DevModeUtil;
import com.didi.sdk.elvish.ElvishInit;
import com.didi.sdk.envsetbase.EnvApi;
import com.didi.sdk.fresco.CommonDelegateLoader;
import com.didi.sdk.fresco.FrescoInit;
import com.didi.sdk.fusionbridge.FusionInitializer;
import com.didi.sdk.idfa.IDFAManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.login.FaceDetectionListener;
import com.didi.sdk.login.LoginPassengerInterceptor;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.map.language.LocaleCodeListener;
import com.didi.sdk.misconfig.MisConfigInitializationer;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.monitor.OmegaTrackLog;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.oneconf.OneConfData;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.p146ad.operation.HomeAdOperation;
import com.didi.sdk.p154ms.common.IAnalytics;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.MSAdapterFacade;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.p154ms.push.ITokenOperation;
import com.didi.sdk.p161sa.SaManager;
import com.didi.sdk.pay.base.PayCommonParamsUtil;
import com.didi.sdk.payment.PayCommonParamsProxy;
import com.didi.sdk.payment.PayWebViewListener;
import com.didi.sdk.payment.view.browser.WebViewListenerHolder;
import com.didi.sdk.push.IMEITrackUtil;
import com.didi.sdk.push.common.ILoginInfoDelegate;
import com.didi.sdk.push.common.IThirdPartyMsgParamsGetter;
import com.didi.sdk.push.common.LoginParams;
import com.didi.sdk.push.common.PushAckParams;
import com.didi.sdk.push.common.ThirdPartyMsgManager;
import com.didi.sdk.push.common.UploadThirdIdParams;
import com.didi.sdk.push.fcm.FcmMsgReceiver;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.setup.mutilocale.LocaleChangeListener;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleUtil;
import com.didi.sdk.tpush.ILogCallbackListener;
import com.didi.sdk.util.AnalysisAPK;
import com.didi.sdk.util.ApkUtils;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.Constant;
import com.didi.sdk.util.DataEntity;
import com.didi.sdk.util.DebugUtils;
import com.didi.sdk.util.DiDiLinkerInstance;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.sdk.util.GlobalScreenFitHelper;
import com.didi.sdk.util.GuideUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.TimePickerMode;
import com.didi.sdk.view.dialog.LocaleDelegate;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.sdk.view.dialog.ProductThemeStyle;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.security.uuid.DeviceTokenManager;
import com.didi.soda.customer.foundation.rpc.ApiUrlFactory;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.location.TrackLocationListener;
import com.didi.unifiedPay.util.ABTestProxyHolder;
import com.didi.unifylogin.api.LoginCountryEnum;
import com.didi.unifylogin.api.LoginInitParam;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.log.LogListener;
import com.didi.unifylogin.base.net.LoginEnvironment;
import com.didi.unifylogin.base.net.LoginNetModeListener;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.listener.pojo.WebViewModel;
import com.didi.usercenter.api.IUserCenterFacade;
import com.didi.usercenter.api.UserCenterFacade;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceConfig;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.login.MsLoginFacade;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didichuxing.p194ms.appflyer.DDAppFlyerLib;
import com.didichuxing.xpanel.xcard.loader.XCardManager;
import com.didiglobal.aurora.AuroraSdk;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.didiglobal.privacy.disclosure.param.GlobalPassenger99InitParam;
import com.didiglobal.privacy.disclosure.param.GlobalPassengerGlobalInitParam;
import com.didiglobal.privacy.domainmonitor.DomainMonitor;
import com.didiglobal.privacysdk.GlobalPrivacyInitParam;
import com.didiglobal.privacysdk.GlobalPrivacyListeners;
import com.didiglobal.privacysdk.GlobalPrivacySDK;
import com.didiglobal.privacysdk.GlobalPrivacyThemeOptions;
import com.didiglobal.privacysdk.app.globalpassenger.GlobalPassengerAppInfo;
import com.didiglobal.privacysdk.law.lawurl.LawUrlBuilder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

@ServiceProvider(alias = "CommonProductApplicationDelegate", value = {ApplicationDelegate.class})
public class CommonProductApplicationDelegate extends ApplicationDelegate {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f8241a = CommonProductApplicationDelegate.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Logger f8242b = LoggerFactory.getLogger("CommonProductDelegate");

    /* renamed from: c */
    private static final String f8243c = "5";

    /* renamed from: d */
    private static final String[] f8244d = {"c++_shared", "conceal", ErrorConst.ModuleName.SECURITY, "didiwsg"};
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f8245e;

    /* renamed from: f */
    private Logger f8246f = LoggerFactory.getLogger((Class<?>) CommonProductApplicationDelegate.class);

    public void attachBaseContext(Application application) {
        super.attachBaseContext(application);
    }

    public void onLoadForground(Application application) {
        super.onLoadForground(application);
        if (CommonDelegateLoader.isAllowed()) {
            if (!FrescoInit.initialized) {
                FrescoInit.init();
            }
            m5402f(application);
        }
    }

    /* renamed from: a */
    private void m5383a(Context context) {
        try {
            Ninja.getInstance(context).initByLocal();
            Ninja.getInstance(context).registe("GOOGLE_LOGIN", new CountStrategy("GOOGLE_LOGIN"));
            Ninja.getInstance(context).registe("FACEBOOK_LOGIN", new CountStrategy("FACEBOOK_LOGIN"));
            NinjaShare.regist(context);
            InternationalNinjaShare.regist(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m5382a(Application application) {
        IMEITrackUtil.INSTANCE.fixDuplicateIMEI(application);
    }

    /* renamed from: b */
    private void m5386b(Application application) {
        VisitTrackManager.INSTANCE.setColdStart(true);
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
                boolean isShowMain = VisitTrackManager.INSTANCE.isShowMain();
                boolean fromBackGround = VisitTrackManager.INSTANCE.getFromBackGround();
                boolean coldStart = VisitTrackManager.INSTANCE.getColdStart();
                if (!isShowMain) {
                    return;
                }
                if (coldStart || fromBackGround) {
                    VisitTrackManager.INSTANCE.track();
                    VisitTrackManager.INSTANCE.setFromBackGround(false);
                    VisitTrackManager.INSTANCE.setColdStart(false);
                }
            }

            public void onActivityStopped(Activity activity) {
                if (!AppUtils.isAppForeground(DIDIApplication.getAppContext())) {
                    VisitTrackManager.INSTANCE.setFromBackGround(true);
                }
            }
        });
    }

    public void onCreate(Application application) {
        try {
            super.onCreate(application);
            m5405g((Context) application);
            SaManager.INSTANCE.initSa();
            m5382a(application);
            m5411j(application);
            m5386b(application);
            DebugUtils.setDebug(application.getApplicationInfo());
            m5383a((Context) application);
            GlobalScreenFitHelper.startFitWholeApp(application);
            m5404g(application);
            Constant.initScreenPixes(application);
            AppDebugger.setIsDebuggable(application.getApplicationInfo());
            m5412j((Context) application);
            IDFAManager.getIdfa(application, new IDFAManager.onIDFAChangeListener() {
                public void onIDFAChanged(String str) {
                }
            });
            CommonConfigSp.getInstance().init(application);
            initLogin(application);
            DidiThemeManager.getIns().init(application);
            m5398e(application);
            m5415m(application);
            m5409i(application);
            m5393d();
            EnvApi.init(application);
            EnvApi.setOriginId("3");
            m5407h(application);
            if (!CommonDelegateLoader.isAllowed()) {
                m5402f(application);
            }
            m5414l(application);
            ComponentStore.getInstance().init(application);
            m5397e();
            ShareConfig.getConfig().setNation(ShareConfig.Nation.GLOBAL);
            ShareConfig.getConfig().setCornerStyle(2);
            m5413k(application);
            m5416n(application);
            DRouter.init(application);
            LocaleCodeHolder.getInstance().setCurrentLang(new LocaleCodeListener() {
                public String getLocaleCode() {
                    return MultiLocaleStore.getInstance().getLocaleCode();
                }
            });
            if (m5391c() || DebugUtils.isDebug()) {
                DIDILocationManager.getInstance(application).enableMockLocation(true);
                f8242b.info("can mock location true", new Object[0]);
            }
            ConfigLoader.init(application);
            if (DebugUtils.isDebug()) {
                AuroraSdk.initAuroraByOllivander(application);
            }
            if (!FrescoInit.isAllowed()) {
                Fresco.initialize(application);
            }
            SafeToolKit.getIns().initialization(application);
            m5410i((Context) application);
            m5417o(application);
            m5394d(application);
            m5387b((Context) application);
            m5390c((Context) application);
            m5401f();
            ActivityStack.init(application);
            GlobalGenericKit.register("_cdn_template", new CDNTemplateBinder(), true);
            OmegaTrackLog.initOmegaTrackLog();
            m5389c(application);
        } catch (Exception e) {
            OmegaSDK.trackError("globalsdk", e);
            throw e;
        }
    }

    /* renamed from: c */
    private void m5389c(final Application application) {
        String idfa = IDFAManager.getIdfa(application, (IDFAManager.onIDFAChangeListener) null);
        final HomeAdOperation homeAdOperation = new HomeAdOperation();
        if (!TextUtils.isEmpty(idfa)) {
            homeAdOperation.request(application, homeAdOperation.getAppEventTypeByLogin(application));
        } else {
            IDFAManager.getIdfa(application, new IDFAManager.onIDFAChangeListener() {
                public void onIDFAChanged(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        HomeAdOperation homeAdOperation = homeAdOperation;
                        Application application = application;
                        homeAdOperation.request(application, homeAdOperation.getAppEventTypeByLogin(application));
                    }
                }
            });
        }
    }

    /* renamed from: d */
    private void m5394d(final Application application) {
        if (!ElvishInit.isAllowed()) {
            Elvish.Companion.init(application, MultiLocaleStore.getInstance().getLocaleCode(), MultiLocaleUtil.getLanguageModel().getLocale(), NationTypeUtil.getNationComponentData().getLocCountry(), NationTypeUtil.getNationComponentData().getCityId());
        }
        OneConfStore.getInstance().addOneConfChangeListener(new OneConfStore.OneConfConfigChangeListener() {
            public void onChanged(OneConfData oneConfData, double d, double d2) {
                String unused = CommonProductApplicationDelegate.this.f8245e = String.valueOf(oneConfData.cityId);
                if (!NationTypeUtil.getNationComponentData().getCityId().equals(CommonProductApplicationDelegate.this.f8245e)) {
                    Elvish.Companion.init(application, MultiLocaleStore.getInstance().getLocaleCode(), MultiLocaleUtil.getLanguageModel().getLocale(), String.valueOf(oneConfData.countryId), CommonProductApplicationDelegate.this.f8245e);
                }
            }
        });
    }

    /* renamed from: c */
    private boolean m5391c() {
        return Apollo.getToggle("global_mock_location_in_release", false).allow();
    }

    /* renamed from: e */
    private void m5398e(Application application) {
        BffInitManager.m5373a(application);
    }

    /* renamed from: f */
    private void m5402f(Application application) {
        ProductThemeStyle productThemeStyle = new ProductThemeStyle();
        ProductThemeStyle.ToastStyle toastStyle = new ProductThemeStyle.ToastStyle();
        DataEntity create = DataEntity.create();
        View view = null;
        try {
            view = LayoutInflater.from(application).inflate(R.layout.global_toast, (ViewGroup) null);
        } catch (InflateException unused) {
        }
        if (view != null) {
            final TextView textView = (TextView) view.findViewById(R.id.tv_msg);
            final ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
            final ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.ll_icon_root);
            create.setDataEntityChangeListener(new DataEntity.IDataEntityChangeListener() {
                public void onChange(String str, int i) {
                    textView.setText(str);
                    if (i > -1) {
                        imageView.setImageResource(i);
                    } else {
                        viewGroup.setVisibility(8);
                    }
                }
            });
            create.setView(view);
        }
        create.setAlign(DataEntity.Align.FILL_TOP_HORIZONTAL);
        toastStyle.setDataEntity(create);
        productThemeStyle.setToastStyle(toastStyle);
        productThemeStyle.getClass();
        ProductThemeStyle.TitleBarStyle titleBarStyle = new ProductThemeStyle.TitleBarStyle();
        titleBarStyle.setTitleColor(application.getResources().getColor(R.color.black));
        productThemeStyle.setMaxToastContentLines(4);
        productThemeStyle.setTimePickerMode(TimePickerMode.Global);
        productThemeStyle.setCommonDialogBg(R.drawable.global_common_dialog_bg_shape);
        productThemeStyle.setIndeterminateDrawable(R.drawable.global_common_loading_progress_bar);
        productThemeStyle.setCommonButtonBackground(R.drawable.global_dialog_btn_bg_shape_lr_recommend_selector);
        productThemeStyle.setProductBasicColor(application.getResources().getColor(R.color.global_orange));
        productThemeStyle.setTitleBarStyle(titleBarStyle);
        ProductControllerStyleManager.getInstance().setProductThemeStyle(productThemeStyle);
        ProductControllerStyleManager.getInstance().setLocaleDelegate(new LocaleDelegate() {
            public Locale getLocale() {
                String[] split;
                String localeCode = MultiLocaleStore.getInstance().getLocaleCode();
                Logger a = CommonProductApplicationDelegate.f8242b;
                a.info("time locale :" + localeCode, new Object[0]);
                if (TextUtil.isEmpty(localeCode) || (split = localeCode.split("-")) == null || split.length != 2) {
                    return Locale.getDefault();
                }
                return new Locale(split[0], split[1]);
            }
        });
    }

    /* renamed from: g */
    private void m5404g(Application application) {
        int i = 0;
        while (i < f8244d.length) {
            try {
                DiDiLinkerInstance.getLinkerInstance().loadLibrary(application, f8244d[i]);
                i++;
            } catch (Throwable th) {
                OmegaSDK.trackError("loadLibrary", th);
                th.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: h */
    private void m5407h(Application application) {
        DDRpcServiceHelper.init(application);
    }

    /* renamed from: d */
    private void m5393d() {
        WebViewListenerHolder.setListener(new PayWebViewListener());
        PayCommonParamsUtil.getInstance().setCommonParamsProxy(new PayCommonParamsProxy());
        ConfigProxyHolder.setProxy(new ConfigProxyHolder.IConfigProxy() {
            public boolean isDebugMode() {
                return AppDebugger.isDebuggable();
            }
        });
        ConfigProxyHolder.setGlobalPageRouterProxy(new ConfigProxyHolder.IGlobalPageRouterProxy() {
            public void toHomeActivity(Context context, boolean z) {
                if (z) {
                    EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
                }
                Intent intent = new Intent();
                intent.addFlags(View.STATUS_BAR_TRANSIENT);
                PageRouter.getInstance().startMainActivity(context, intent);
            }
        });
        LocationProxyHolder.setProxy(new LocationProxyHolder.ILocationProxy() {
            public void requestLocationAndCityId() {
                LocationCenter.getIntance().requestLocationOnceAsync(new TrackLocationListener() {
                    public void onLocationError(int i, String str) {
                    }

                    public void onLocationChanged(TrackLocationInfo trackLocationInfo) {
                        if (trackLocationInfo != null) {
                            OneConfStore.getInstance().getOneConf(CommonProductApplicationDelegate.this.mDIDIBaseApplication, trackLocationInfo.lat.doubleValue(), trackLocationInfo.lng.doubleValue());
                        }
                    }
                });
            }
        });
        ABTestProxyHolder.setNewUISwitch(new ABTestProxyHolder.INewUISwitchProxy() {
            public boolean isNewTrip() {
                return true;
            }
        });
    }

    /* renamed from: i */
    private void m5409i(Application application) {
        FusionInitializer.execute(application);
    }

    /* renamed from: e */
    private void m5397e() {
        ConfProxy.getInstance().updateConfigFromCache();
        if (!GlobalApolloUtils.isNetOpt()) {
            MisConfigInitializationer.getInstance().init();
        }
    }

    /* renamed from: j */
    private void m5411j(Application application) {
        MultiLocaleStore.getInstance().getLocaleHelper().initAppLocale(application);
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(activity);
            }
        });
    }

    public void initLogin(final Context context) {
        LoginInitParam loginInitParam = new LoginInitParam(m5403g());
        boolean z = true;
        loginInitParam.isGlobal = true;
        if (AppUtils.isBrazilApp(context)) {
            loginInitParam.defCountryId = LoginCountryEnum.BRASIL.getCountryId();
        }
        loginInitParam.locationListener = new LoginListeners.LocationListener() {
            public String getMapType() {
                return NationTypeUtil.getNationComponentData().getMapTypeString();
            }

            public double getLat() {
                DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
                if (didiLocation != null) {
                    return didiLocation.getLatitude();
                }
                return 0.0d;
            }

            public double getLng() {
                DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
                if (didiLocation != null) {
                    return didiLocation.getLongitude();
                }
                return 0.0d;
            }

            public int getCityId() {
                return Integer.valueOf(NationTypeUtil.getNationComponentData().getCityId()).intValue();
            }

            public int getUtcOffset() {
                return NationTypeUtil.getNationComponentData().getTimeZoneUtcOffset();
            }
        };
        loginInitParam.globalizationListener = new LoginListeners.GlobalizationListener() {
            public String getLanguage() {
                return NationTypeUtil.getNationComponentData().getLocaleCode();
            }

            public Locale getSystemLocale() {
                return MultiLocaleStore.getInstance().getSystemLocale();
            }
        };
        loginInitParam.logListener = new LogListener() {
            Logger logger = LoggerFactory.getLogger("LoginSdk");

            public void addLogWithTab(String str) {
                this.logger.info(str, new Object[0]);
            }
        };
        loginInitParam.netModeListener = new LoginNetModeListener() {
            public LoginEnvironment getDevMode() {
                if (DevModeUtil.isPreRelease(context)) {
                    return LoginEnvironment.PRE_RELEASE;
                }
                int i = C365637.$SwitchMap$com$didi$sdk$developermode$DevModeUtil$DevEnvironment[DevModeUtil.getDevEnvironment(context).ordinal()];
                if (i == 1) {
                    return LoginEnvironment.DEBUG;
                }
                if (i == 2) {
                    return LoginEnvironment.RELEASE;
                }
                if (i != 3) {
                    return LoginEnvironment.RELEASE;
                }
                return LoginEnvironment.DEBUG;
            }
        };
        loginInitParam.netParamListener = new LoginListeners.NetParamListener() {
            public Map<String, Object> getExtraInfo() {
                HashMap hashMap = new HashMap();
                hashMap.put("oid", OmegaSDK.getOmegaId());
                hashMap.put("aid", AppsFlyerLib.getInstance().getAppsFlyerUID(CommonProductApplicationDelegate.this.mDIDIBaseApplication));
                hashMap.put("frid", CommonConfigSp.getInstance().get(CommonConfigSp.KEY_FIREBASE_APP_ID, ""));
                return hashMap;
            }
        };
        loginInitParam.faceListener = new FaceDetectionListener(context);
        IAnalytics iAnalytics = (IAnalytics) ServiceUtil.getServiceImp(IAnalytics.class);
        if (iAnalytics != null) {
            String str = f8241a;
            LogUtil.m26099i(str, "initLogin : analytics = " + iAnalytics);
            iAnalytics.getAppInstanceIdAsync(this.mDIDIBaseApplication, new Consumer<String>() {
                public void accept(String str) {
                    String b = CommonProductApplicationDelegate.f8241a;
                    LogUtil.m26099i(b, "initLogin.accept : s = " + str);
                    CommonConfigSp.getInstance().put(CommonConfigSp.KEY_FIREBASE_APP_ID, str);
                }
            });
        } else {
            LogUtil.m26101w(f8241a, "initLogin : analytics is null");
        }
        loginInitParam.webViewListener = new LoginListeners.WebViewListener() {
            public void callWebView(WebViewModel webViewModel) {
                Activity activity = webViewModel.getActivity();
                if (activity != null) {
                    com.didi.sdk.webview.WebViewModel webViewModel2 = new com.didi.sdk.webview.WebViewModel();
                    webViewModel2.title = webViewModel.getTitle();
                    webViewModel2.url = webViewModel.getUrl();
                    Intent intent = new Intent(activity, BaseWebActivity.class);
                    intent.putExtra("web_view_model", webViewModel2);
                    activity.startActivity(intent);
                }
            }
        };
        loginInitParam.riskParamListener = new LoginListeners.RiskParamListener() {
            public String getA3(Context context) {
                return CommonProductApplicationDelegate.this.m5400f(context);
            }

            public String getIdfa(Context context) {
                return IDFAManager.getIdfa(context);
            }
        };
        OneLoginFacade.init(context, loginInitParam);
        m5395d(context);
        OneLoginFacade.getFunction().setLoginInterceptor(new LoginPassengerInterceptor());
        OneLoginFacade.getConfigApi().setLawHint(context.getString(R.string.one_login_str_login_law_prompt_back));
        OneLoginFacade.getConfigApi().setButtonStyle(2);
        String countryCodeISO3166 = AppUtils.getCountryCodeISO3166();
        if (!TextUtils.isEmpty(countryCodeISO3166)) {
            Iterator<String> it = GlobalCountryCode.getPrivacyPolicyList().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (countryCodeISO3166.equals(it.next())) {
                        OneLoginFacade.getConfigApi().setIsLawCbUseCache(false);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        OneLoginFacade.getConfigApi().setDefLawSelected(false);
        OneLoginFacade.getConfigApi().setNewUserCpfIntercept(true);
        OneLoginFacade.getConfigApi().setCodeReducedTime(45);
        OneLoginFacade.getConfigApi().setLawUrl(new LawUrlBuilder().build());
        if (!AppUtils.isBrazilApp(context)) {
            OneLoginFacade.getConfigApi().setTheme(R.style.DIYLoginStyle);
        } else {
            OneLoginFacade.getConfigApi().isUnifyPwd(false);
            OneLoginFacade.getConfigApi().setUseWeakPwd(true);
            OneLoginFacade.getConfigApi().setTheme(R.style.BrazilLoginStyle);
        }
        OneLoginFacade.getConfigApi().setDeleteAccountPageUseTextStyle(true);
        OneLoginFacade.getConfigApi().setUsePassengerUIStyle(true);
        OneLoginFacade.getConfigApi().setIsPasswordEncrypt(true);
        OneLoginFacade.getConfigApi().setActivityDelegate(new LoginListeners.LoginBaseActivityDelegate() {
            public void onCreate(Bundle bundle, FragmentActivity fragmentActivity) {
                fragmentActivity.setTheme(R.style.GlobalActivityTheme);
                StatusBarLightingCompat.setStatusBarBgLightning(fragmentActivity, true, fragmentActivity.getResources().getColor(R.color.common_status_background));
                SystemUtils.hookSetRequestedOrientation(fragmentActivity, 7);
                if (!AppDebugger.isDebuggable()) {
                    fragmentActivity.getWindow().setFlags(8192, 8192);
                }
            }

            public void onActivityResult(FragmentActivity fragmentActivity) {
                super.onActivityResult(fragmentActivity);
                MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(fragmentActivity);
            }

            public void onResume(FragmentActivity fragmentActivity) {
                super.onResume(fragmentActivity);
                MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(fragmentActivity);
            }
        });
        MultiLocaleStore.getInstance().addLocaleChangeListener(new LocaleChangeListener() {
            public void onLocaleChange(String str, String str2) {
                OneLoginFacade.getFunction().refreshCountryList();
                OneLoginFacade.getConfigApi().setLawHint(context.getString(R.string.one_login_str_login_law_prompt_back));
                NationTypeUtil.getNationComponentData().getLocaleCode();
                OneLoginFacade.getConfigApi().setExchangeNamePosition("ja-JP".equals(str2));
            }
        });
        OneLoginFacade.getConfigApi().setExchangeNamePosition("ja-JP".equals(MultiLocaleStore.getInstance().getLocaleCode()));
        IUserCenterFacade ins = UserCenterFacade.getIns();
        if (DevModeUtil.DevEnvironment.DEBUG != DevModeUtil.getDevEnvironment(context)) {
            z = false;
        }
        ins.setTest(z);
        UserCenterFacade.getIns().setOnlineUrl("https://common.didiglobal.com");
        m5399e(context);
    }

    /* renamed from: com.didi.app.delegate.CommonProductApplicationDelegate$37 */
    static /* synthetic */ class C365637 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$developermode$DevModeUtil$DevEnvironment;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.sdk.developermode.DevModeUtil$DevEnvironment[] r0 = com.didi.sdk.developermode.DevModeUtil.DevEnvironment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$developermode$DevModeUtil$DevEnvironment = r0
                com.didi.sdk.developermode.DevModeUtil$DevEnvironment r1 = com.didi.sdk.developermode.DevModeUtil.DevEnvironment.DEBUG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$developermode$DevModeUtil$DevEnvironment     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.developermode.DevModeUtil$DevEnvironment r1 = com.didi.sdk.developermode.DevModeUtil.DevEnvironment.RELEASE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$developermode$DevModeUtil$DevEnvironment     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.developermode.DevModeUtil$DevEnvironment r1 = com.didi.sdk.developermode.DevModeUtil.DevEnvironment.UNDEFINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.app.delegate.CommonProductApplicationDelegate.C365637.<clinit>():void");
        }
    }

    /* renamed from: b */
    private void m5387b(Context context) {
        GlobalPrivacyInitParam globalPrivacyInitParam = new GlobalPrivacyInitParam();
        globalPrivacyInitParam.webViewListener = new GlobalPrivacyListeners.WebViewListener() {
            public void jumpWebViewPage(Context context, String str) {
                if (context != null) {
                    com.didi.sdk.webview.WebViewModel webViewModel = new com.didi.sdk.webview.WebViewModel();
                    webViewModel.title = "";
                    webViewModel.url = str;
                    Intent intent = new Intent(context, BaseWebActivity.class);
                    intent.putExtra("web_view_model", webViewModel);
                    context.startActivity(intent);
                }
            }
        };
        globalPrivacyInitParam.appInfo = new GlobalPassengerAppInfo();
        globalPrivacyInitParam.getCommonInfoListener = new GlobalPrivacyListeners.GetCommonInfoListener() {
            public String getAccountType() {
                return "passenger";
            }

            public String getUserId() {
                return BffService.getUid();
            }

            public String getToken() {
                return BffService.getToken();
            }

            public String getAppId(Context context) {
                return BffService.getAppId(context);
            }

            public String getAppType(Context context) {
                return BffService.getAppType(context);
            }
        };
        globalPrivacyInitParam.configThemeResInt = true;
        if (AppUtils.isBrazilApp(DIDIApplication.getAppContext())) {
            globalPrivacyInitParam.themeResInt = 2132017974;
        } else {
            globalPrivacyInitParam.themeResInt = 2132017979;
        }
        globalPrivacyInitParam.itemTitleBold = false;
        globalPrivacyInitParam.finishActivityWhenAppRestarted = true;
        GlobalPrivacySDK.init(globalPrivacyInitParam);
        GlobalPrivacyThemeOptions globalPrivacyThemeOptions = new GlobalPrivacyThemeOptions();
        globalPrivacyThemeOptions.setTitleBarSmallLeftImgRes(R.drawable.common_title_bar_btn_back_selector).setUseTitleBarSmallLeftImg(true);
        GlobalPrivacySDK.setGlobalPrivacyThemeOptions(globalPrivacyThemeOptions);
    }

    /* renamed from: c */
    private void m5390c(final Context context) {
        if (AppUtils.isBrazilApp(context)) {
            PrivacyDisclosureManager.getInstance();
            PrivacyDisclosureManager.init(new GlobalPassenger99InitParam() {
                public int getAppId() {
                    return CommonProductApplicationDelegate.this.m5403g();
                }

                public Map<String, String> getPrivacyTypeIdDescMap() {
                    HashMap hashMap = new HashMap();
                    String typeId = PrivacyTypeEnum.LOCATION.getTypeId();
                    Context context = context;
                    hashMap.put(typeId, context.getString(R.string.GRider_transformation_The_DiDi_aLxC, new Object[]{ApkUtils.getAppName(context)}));
                    String typeId2 = PrivacyTypeEnum.READ_CONTACTS.getTypeId();
                    Context context2 = context;
                    hashMap.put(typeId2, context2.getString(R.string.GRider_transformation_The_DiDi_liyv, new Object[]{ApkUtils.getAppName(context2)}));
                    String typeId3 = PrivacyTypeEnum.ALBUM.getTypeId();
                    Context context3 = context;
                    hashMap.put(typeId3, context3.getString(R.string.GRider_transformation_The_DiDi_FOyc, new Object[]{ApkUtils.getAppName(context3)}));
                    String typeId4 = PrivacyTypeEnum.CAMERA.getTypeId();
                    Context context4 = context;
                    hashMap.put(typeId4, context4.getString(R.string.GRider_transformation_The_DiDi_TNYk, new Object[]{ApkUtils.getAppName(context4)}));
                    hashMap.put(PrivacyTypeEnum.BLUETOOTH.getTypeId(), context.getString(R.string.GRider_navigation__XCDU));
                    return hashMap;
                }
            });
            return;
        }
        PrivacyDisclosureManager.getInstance();
        PrivacyDisclosureManager.init(new GlobalPassengerGlobalInitParam() {
            public int getAppId() {
                return CommonProductApplicationDelegate.this.m5403g();
            }

            public Map<String, String> getPrivacyTypeIdDescMap() {
                HashMap hashMap = new HashMap();
                String typeId = PrivacyTypeEnum.LOCATION.getTypeId();
                Context context = context;
                hashMap.put(typeId, context.getString(R.string.GRider_transformation_The_DiDi_aLxC, new Object[]{ApkUtils.getAppName(context)}));
                String typeId2 = PrivacyTypeEnum.READ_CONTACTS.getTypeId();
                Context context2 = context;
                hashMap.put(typeId2, context2.getString(R.string.GRider_transformation_The_DiDi_liyv, new Object[]{ApkUtils.getAppName(context2)}));
                String typeId3 = PrivacyTypeEnum.ALBUM.getTypeId();
                Context context3 = context;
                hashMap.put(typeId3, context3.getString(R.string.GRider_transformation_The_DiDi_FOyc, new Object[]{ApkUtils.getAppName(context3)}));
                String typeId4 = PrivacyTypeEnum.CAMERA.getTypeId();
                Context context4 = context;
                hashMap.put(typeId4, context4.getString(R.string.GRider_transformation_The_DiDi_TNYk, new Object[]{ApkUtils.getAppName(context4)}));
                hashMap.put(PrivacyTypeEnum.BLUETOOTH.getTypeId(), context.getString(R.string.GRider_navigation__XCDU));
                return hashMap;
            }
        });
    }

    /* renamed from: f */
    private void m5401f() {
        DomainMonitor.initSdkWithApolloName("global_pax_monitor_net_url_enable", "global_pax_redirect_net_url_enable", DebugUtils.isDebug());
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public int m5403g() {
        return "5".equals(NationTypeUtil.getNationComponentData().getOriginID()) ? 60004 : 60000;
    }

    /* renamed from: k */
    private void m5413k(final Application application) {
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onCancel() {
            }

            public void onSuccess(Activity activity, String str) {
                CommonProductApplicationDelegate.f8242b.info("login imit im", new Object[0]);
                OneMessageInit.initIMEngine(application);
            }
        });
        OneLoginFacade.getFunction().addLoginOutListener(new LoginListeners.LoginOutListener() {
            public void onSuccess() {
                CommonProductApplicationDelegate.f8242b.info("logout destroy im", new Object[0]);
                OneMessageInit.destroyIMEngine();
            }
        });
        if (!GlobalApolloUtils.isNetOpt()) {
            OneMessageInit.init(application);
        }
    }

    /* renamed from: l */
    private void m5414l(Application application) {
        RemoteResourceManager.getInstance().setLoginParam(new ILoginParam() {
            public String getToken() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
            }
        });
        RemoteResourceManager.getInstance().setDomainParam(new IDomainParam() {
            public String getDomainUrl() {
                return "https://common.didiglobal.com";
            }
        });
        RemoteResourceManager.getInstance().setDepartureParam(new IDepartureParam() {
            public Pair<Double, Double> getDepartureLatLng() {
                double d;
                DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
                double d2 = 0.0d;
                if (didiLocation != null) {
                    d2 = Double.valueOf(didiLocation.getLatitude()).doubleValue();
                    d = didiLocation.getLongitude();
                } else {
                    d = 0.0d;
                }
                return new Pair<>(Double.valueOf(d2), Double.valueOf(d));
            }
        });
        RemoteResourceManager.getInstance().init(application);
    }

    /* renamed from: d */
    private void m5395d(Context context) {
        if (!Apollo.getToggle("unify_login_close_auto_entrance").allow()) {
            ArrayList arrayList = new ArrayList();
            if (!Ninja.getInstance(context).isHit("FACEBOOK_LOGIN")) {
                arrayList.add("facebook");
            }
            if (!Ninja.getInstance(context).isHit("GOOGLE_LOGIN")) {
                arrayList.add("google");
            }
            MsLoginFacade.init(arrayList);
        }
    }

    /* renamed from: e */
    private void m5399e(final Context context) {
        MSAdapterFacade.init(true);
        ThirdPartyMsgManager.getInstance().init(new IThirdPartyMsgParamsGetter() {
            public UploadThirdIdParams getUploadThirdIdParams() {
                UploadThirdIdParams uploadThirdIdParams = new UploadThirdIdParams();
                uploadThirdIdParams.appversion = SystemUtil.getVersionName(context);
                uploadThirdIdParams.imei = SystemUtil.getIMEI();
                String metaDataByKey = AppUtils.getMetaDataByKey(EventKeys.APP_FCM_APPKEY);
                if (!TextUtils.isEmpty(metaDataByKey)) {
                    uploadThirdIdParams.app_type = Integer.valueOf(metaDataByKey).intValue();
                }
                uploadThirdIdParams.app_type = Integer.valueOf(AppUtils.getMetaDataByKey(EventKeys.APP_FCM_APPKEY)).intValue();
                ITokenOperation iTokenOperation = (ITokenOperation) ServiceUtil.getServiceImp(ITokenOperation.class, IMSType.GMS);
                if (iTokenOperation != null) {
                    LogUtil.m26099i(CommonProductApplicationDelegate.f8241a, "getUploadThirdIdParams:GMS-Push is loaded");
                }
                uploadThirdIdParams.fcm_id = CommonProductApplicationDelegate.this.m5380a(iTokenOperation, context);
                ITokenOperation iTokenOperation2 = (ITokenOperation) ServiceUtil.getServiceImp(ITokenOperation.class, IMSType.HMS);
                if (iTokenOperation2 != null) {
                    LogUtil.m26099i(CommonProductApplicationDelegate.f8241a, "getUploadThirdIdParams:HMS-Push is loaded");
                }
                uploadThirdIdParams.huawei_token = CommonProductApplicationDelegate.this.m5380a(iTokenOperation2, context);
                String b = CommonProductApplicationDelegate.f8241a;
                LogUtil.m26099i(b, "getUploadThirdIdParams:GMS.token = " + uploadThirdIdParams.fcm_id + ", HMS.token = " + uploadThirdIdParams.huawei_token);
                int cityId = ConfProxy.getInstance().getCityId();
                if (cityId > -1) {
                    uploadThirdIdParams.area_id = cityId;
                }
                DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
                if (lastLocation != null) {
                    uploadThirdIdParams.lat = lastLocation.getLatitude();
                    uploadThirdIdParams.lng = lastLocation.getLongitude();
                }
                if (!DeviceTokenManager.getInstance().getDeviceToken().isEmpty()) {
                    uploadThirdIdParams.deviceToken = DeviceTokenManager.getInstance().getDeviceToken();
                }
                if (GuideUtil.getAppLaunchFirstTime(context) == 0) {
                    GuideUtil.setAppLaunchFirstTime(context, System.currentTimeMillis() / 1000);
                }
                long appLaunchFirstTime = GuideUtil.getAppLaunchFirstTime(context);
                if (appLaunchFirstTime > 0) {
                    uploadThirdIdParams.firstOpenTime = appLaunchFirstTime;
                }
                uploadThirdIdParams.host = ApiUrlFactory.GLOBAL_CUSTOMER_PUSH_IP_ONLINE;
                Pair e = CommonProductApplicationDelegate.this.m5406h();
                if (e != null) {
                    uploadThirdIdParams.addExtra("data_mcc", e.first);
                    uploadThirdIdParams.addExtra("data_mnc", e.second);
                }
                return uploadThirdIdParams;
            }

            public PushAckParams getPushAckParams() {
                PushAckParams pushAckParams = new PushAckParams();
                pushAckParams.host = MsgGateService.URL;
                return pushAckParams;
            }
        }, new ILoginInfoDelegate() {
            public boolean isTestEnviroment() {
                return DevModeUtil.DevEnvironment.DEBUG == DevModeUtil.getDevEnvironment(context);
            }

            public LoginParams getLoginParams() {
                LoginParams loginParams = new LoginParams();
                loginParams.phone = NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
                loginParams.token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
                loginParams.uid = NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
                return loginParams;
            }
        }, new ILogCallbackListener() {
            public void onRequested(int i, int i2, byte[] bArr) {
            }

            public void onLog(int i, String str) {
                if (i == 3) {
                    CommonProductApplicationDelegate.f8242b.debug(str, new Object[0]);
                } else {
                    CommonProductApplicationDelegate.f8242b.info(str, new Object[0]);
                }
            }
        });
        ThirdPartyMsgManager.getInstance().addMsgReceiver(new FcmMsgReceiver());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m5380a(ITokenOperation iTokenOperation, Context context) {
        if (iTokenOperation == null) {
            return "";
        }
        String tokenCached = iTokenOperation.getTokenCached(context);
        return TextUtils.isEmpty(tokenCached) ? iTokenOperation.getTokenSync(context) : tokenCached;
    }

    /* renamed from: m */
    private void m5415m(Application application) {
        if (application != null && application.getApplicationContext() != null) {
            this.f8246f.debug(AppsFlyerUtil.getAppsFlyerKey(), new Object[0]);
            DDAppFlyerLib.delayInit(application, AppsFlyerUtil.getAppsFlyerKey());
        }
    }

    /* renamed from: n */
    private void m5416n(final Application application) {
        IntentPermissionManager.getInstance().setPermissionDialogInterface(new PermissionDialogInterface() {
            public String getConfirm() {
                return application.getString(R.string.permission_description_dialog_confirm);
            }

            public String getCancel() {
                return application.getString(R.string.permission_description_dialog_cancel);
            }

            public String getPermissionDescription(String str) {
                try {
                    if (Permission.CAMERA.equalsIgnoreCase(str)) {
                        return application.getString(R.string.permission_description_camera);
                    }
                    if (Permission.READ_EXTERNAL_STORAGE.equalsIgnoreCase(str)) {
                        return application.getString(R.string.permission_description_readstore);
                    }
                    if (Permission.WRITE_EXTERNAL_STORAGE.equalsIgnoreCase(str)) {
                        return application.getString(R.string.permission_description_writestore);
                    }
                    if (Permission.READ_SMS.equalsIgnoreCase(str)) {
                        return application.getString(R.string.permission_description_readsms);
                    }
                    if (Permission.CALL_PHONE.equalsIgnoreCase(str)) {
                        return application.getString(R.string.permission_description_callphone);
                    }
                    if (Permission.ACCESS_COARSE_LOCATION.equalsIgnoreCase(str)) {
                        return application.getString(R.string.permission_description_location);
                    }
                    if (Permission.ACCESS_FINE_LOCATION.equalsIgnoreCase(str)) {
                        return application.getString(R.string.permission_description_location);
                    }
                    if (Permission.RECORD_AUDIO.equalsIgnoreCase(str)) {
                        return application.getString(R.string.permission_description_recording);
                    }
                    if (Permission.READ_PHONE_STATE.equalsIgnoreCase(str)) {
                        return application.getString(R.string.permission_description_phonestate);
                    }
                    return Permission.READ_CONTACTS.equalsIgnoreCase(str) ? application.getString(R.string.permission_description_readcontact) : str;
                } catch (Exception unused) {
                    return str;
                }
            }
        });
    }

    public void onConfigurationChanged(Configuration configuration, Application application) {
        super.onConfigurationChanged(configuration, application);
        MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(application);
        OmegaSDK.putGlobalKV("g_Lang", MultiLocaleStore.getInstance().getLocaleCode());
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m5400f(Context context) {
        IA3Manager iA3Manager = (IA3Manager) ComponentLoadUtil.getComponent(IA3Manager.class);
        return iA3Manager != null ? iA3Manager.getToken(context) : "";
    }

    /* renamed from: g */
    private static void m5405g(Context context) {
        if (m5408h(context)) {
            SystemUtils.log(3, "CommonProductDelegate", "preInitGoogleMap", (Throwable) null, "com.didi.app.delegate.CommonProductApplicationDelegate", 1256);
            MapsSdkInitialize.Renderer renderer = Apollo.getToggle("global_map_google_map_render_toggle").allow() ? MapsSdkInitialize.Renderer.LATEST : MapsSdkInitialize.Renderer.LEGACY;
            SystemUtils.log(6, "ccc", "apollo MapsSdkInitialize.Renderer = " + renderer, (Throwable) null, "com.didi.app.delegate.CommonProductApplicationDelegate", 1259);
            int initialize = MapsSdkInitialize.initialize(context, AnalysisAPK.isGlobalHmsApk(context) ? MapVendor.HUAWEI : MapVendor.GOOGLE, renderer, new OnMapsSdkInitializedCallback() {
                public void onMapsSdkInitialized(MapsSdkInitialize.Renderer renderer) {
                    SystemUtils.log(6, "ccc", "application onMapsSdkInitialized + " + renderer, (Throwable) null, "com.didi.app.delegate.CommonProductApplicationDelegate$36", 1263);
                }
            });
            SystemUtils.log(6, "ccc", "application MapsSdkInitialize.initialize = + " + initialize, (Throwable) null, "com.didi.app.delegate.CommonProductApplicationDelegate", 1266);
            IToggle toggle = Apollo.getToggle("global_passenger_map_init_rollback");
            ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class);
            if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("initmode", 0)).intValue() != 1 || (iCollector != null && !iCollector.isHMSupportPreInitMap())) {
                DDMapInit.getInstance().preInitMap(context);
                return;
            }
            SystemUtils.log(3, "CommonProductDelegate", "MapViewHolder.postInitMap", (Throwable) null, "com.didi.app.delegate.CommonProductApplicationDelegate", 1273);
            MapViewHolder.getInstance().postInitMap(context);
            return;
        }
        SystemUtils.log(5, "CommonProductDelegate", "app is background", (Throwable) null, "com.didi.app.delegate.CommonProductApplicationDelegate", 1279);
    }

    /* renamed from: h */
    private static boolean m5408h(Context context) {
        return AppUtils.isAppForeground(context) || AppUtils.isRunningInForeground(context);
    }

    /* renamed from: i */
    private void m5410i(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            XCardManager.setCacheFilePath(cacheDir.getPath());
        }
    }

    /* renamed from: o */
    private void m5417o(Application application) {
        DiFace.initialize(new DiFaceConfig.Builder().setAppContext(application).setDebug(false).create());
    }

    /* renamed from: j */
    private void m5412j(Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            List<String> a = m5381a(context, context.getPackageName());
            if (a.size() > 1) {
                String curProcessName = getCurProcessName(context);
                if (!TextUtils.isEmpty(curProcessName)) {
                    str = curProcessName + "_passenger";
                } else {
                    str = "passenger";
                }
                WebView.setDataDirectorySuffix(str);
                f8242b.info("initPieWebView", Arrays.toString(a.toArray()));
            }
        }
    }

    /* renamed from: a */
    private List<String> m5381a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (str.equals(next.processName)) {
                    arrayList.add(next.processName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Pair<String, String> m5406h() {
        String simOperator;
        Application appContext = DIDIApplication.getAppContext();
        if (appContext == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) appContext.getSystemService("phone");
        if (telephonyManager.getSimState() != 5) {
            return null;
        }
        IToggle toggle = Apollo.getToggle("ibt_call_collect_device_info");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("mccmnc", -1)).intValue() != 1 || (simOperator = telephonyManager.getSimOperator()) == null || simOperator.length() < 4) {
            return null;
        }
        return new Pair<>(simOperator.substring(0, 3), simOperator.substring(3));
    }
}

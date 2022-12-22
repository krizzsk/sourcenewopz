package com.didi.component.framework.delegate;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.didi.addressold.util.FireBaseEventTrackListener;
import com.didi.addressold.util.FireBaseEventTracker;
import com.didi.boot.task.InflateTask;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.HostConstants;
import com.didi.component.business.security.A3Manager;
import com.didi.component.business.tracker.DevInnerTracker;
import com.didi.component.business.tracker.OmegaInnerTracker;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.util.Utils;
import com.didi.component.business.web.GlobalHybird;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.common.model.LoginEmailSuffixModel;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.net.RequestParamsChecker;
import com.didi.component.common.push.CommonPushComponent;
import com.didi.component.common.push.CommonPushManager;
import com.didi.component.common.util.AddressUtil;
import com.didi.component.common.util.AppForegroundTracker;
import com.didi.component.common.util.FireBaseEventUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.SystemUtil;
import com.didi.component.config.BusinessRegistry;
import com.didi.component.core.ComponentLoader;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.framework.tracker.IBTCommonAttrsGetter;
import com.didi.component.framework.wsg.WirelessSecurityManager;
import com.didi.component.never.core.util.FrameworkRegister;
import com.didi.eventbus.CommonEventBusIndex;
import com.didi.eventbus.GlobalSdkEventBusIndex;
import com.didi.eventbus.HomeDestEventBusIndex;
import com.didi.eventbus.ServiceEventBusIndex;
import com.didi.global.fintech.cashier.user.facade.CashierConfigurationProxy;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierInitConfig;
import com.didi.global.fintech.cashier.user.theme.ThemeType;
import com.didi.map.global.component.slideCars.api.ServerParamConstant;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.map.sdk.navtracker.Tracker;
import com.didi.onehybrid.FusionEngine;
import com.didi.payment.base.proxy.FireBaseProxyHolder;
import com.didi.payment.commonsdk.global.WalletGlobal;
import com.didi.reactive.tracker.AttrsGetter;
import com.didi.reactive.tracker.EventTracker;
import com.didi.reactive.tracker.InnerTracker;
import com.didi.rfusion.config.RFLocale;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.net.ISfRpcRequestParamListener;
import com.didi.safetoolkit.net.SfServerParam;
import com.didi.safetoolkit.util.SfOmegaOptListener;
import com.didi.safety.god.IClientAppInfo;
import com.didi.safety.god.manager.SafetyGod;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.delegate.ApplicationDelegate;
import com.didi.sdk.component.express.ExpressShareStore;
import com.didi.sdk.idfa.IDFAManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.login.PassportUpdateSDk;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.map.language.LocaleCodeListener;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.didi.sdk.reversegeo.ReverseLocationStore;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleUtil;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.DebugUtils;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.security.wireless.SecurityController;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.ApiInvokePolicy;
import com.didi.travel.p171v2.biz.rpc.RpcCommonParamListener;
import com.didi.travel.psnger.IClientConfig;
import com.didi.travel.psnger.IHostConfig;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.TEBridgeConfig;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderCom;
import com.didi.travel.psnger.p170v2.IExpress;
import com.didi.travel.psnger.p170v2.host.HostManager;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.request.ServerParam;
import com.didiglobal.ddmirror.DDMirror;
import com.didiglobal.ddmirror.IDDMirrorInitCallback;
import com.didiglobal.dittoview.DittoKit;
import com.didiglobal.dittoview.impl.DittoViewBinderImpl;
import com.didiglobal.domainprocessor.DomainProcessor;
import com.didiglobal.domainprocessor.module.DomainModule;
import com.didiglobal.eevee_framework.node.register.EeveeRegister;
import com.didiglobal.omegasdkadapter.OmegaAdapterInterceptorManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentRegister;
import com.didiglobal.xpanelnew.util.XpLog;
import com.example.uploadrule.OmegaUploadRuleInterceptor;
import didihttp.ServerCallItem;
import didihttp.StatisticalCallback;
import didihttp.StatisticalContext;
import didinet.NetEngine;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

@ServiceProvider(alias = "extended", value = {ApplicationDelegate.class})
public class FrameworkApplicationDelegate extends ApplicationDelegate {
    public static final String COMPONENT_FRAMEWORK_REGISTER_CLASS = "com.didi.component.framework.base.CompRegister";
    public static final String WHATS_APP_PKG_NAME = "com.whatsapp";

    /* renamed from: a */
    private static final String f13740a = "FrameworkApplicationDelegate";

    /* renamed from: f */
    private static final String f13741f = "global_app_apm_async_inflate";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Logger f13742b = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f13743c;

    /* renamed from: d */
    private StatisticalCallback f13744d = new StatisticalCallback() {
        public void onStatisticalDataCallback(StatisticalContext statisticalContext) {
            ServerCallItem currentServerCallData = statisticalContext.currentServerCallData();
            Logger a = FrameworkApplicationDelegate.this.f13742b;
            a.info("-> CALL REQ:" + statisticalContext.getRequest().url().toString(), new Object[0]);
            Logger a2 = FrameworkApplicationDelegate.this.f13742b;
            a2.info("-> CALL DETAIL:" + currentServerCallData.toString(), new Object[0]);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GlobalLoadingViewListener f13745e = new GlobalLoadingViewListener();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Map<String, Object> f13746g = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnCacheLoadedListener f13747h = new OnCacheLoadedListener() {
        public void onCacheAlreadyLoaded() {
            Apollo.removeCacheLoadedListener(FrameworkApplicationDelegate.this.f13747h);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13748i = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            DDMirror.Companion.doCheckMsg(str);
        }
    };

    public void attachBaseContext(Application application) {
        super.attachBaseContext(application);
        m9538g(application);
    }

    public void onCreate(final Application application) {
        super.onCreate(application);
        FrameworkRegister.init();
        EeveeRegister.register();
        ComponentRegister.INSTANCE.register();
        m9517b();
        m9531e(application);
        C5824a.m9549a();
        m9527d(application);
        m9530e();
        if (GlobalApolloUtil.isInMockLocationWhiteList() || DebugUtils.isDebug()) {
            SystemUtils.log(4, "didi", "mock  open...", (Throwable) null, "com.didi.component.framework.delegate.FrameworkApplicationDelegate", 223);
            GLog.setOutput(true);
            XpLog.setOutput(true);
            NetEngine.getInstance().addStatisticalCallback(this.f13744d);
            this.f13742b.info(" start debug aar mode:", new Object[0]);
            this.f13742b.info("FrameworkApplicationDelegate aar mode:release", new Object[0]);
            Logger logger = this.f13742b;
            logger.info("DebugUtils.isOnlie() " + DebugUtils.isOnlie(), new Object[0]);
            Logger logger2 = this.f13742b;
            logger2.info("DebugUtils.isDebug() " + DebugUtils.isDebug(), new Object[0]);
        }
        DDTravelConfigStore.getInstance().init(application);
        LocaleCodeHolder.getInstance().setCurrentLang(new LocaleCodeListener() {
            public String getLocaleCode() {
                return MultiLocaleStore.getInstance().getLocaleCode();
            }
        });
        m9524c((Context) application);
        FusionEngine.export("GulfstreamModule", GlobalHybird.class);
        FusionEngine.export(DomainModule.class.getSimpleName(), DomainModule.class);
        if (GlobalApolloUtil.isGodAllowInitInApplication()) {
            SafetyGod.init(application.getApplicationContext(), new IClientAppInfo() {
                public String getA3() {
                    return null;
                }

                public double getLat() {
                    return 0.0d;
                }

                public double getLng() {
                    return 0.0d;
                }
            });
        }
        m9519b((Context) application);
        DomainProcessor.getInstance().init(application);
        m9534f();
        SecurityController.getInstance().post((Runnable) new Runnable() {
            public void run() {
                if (!Apollo.getToggle("passport_remove_ab_test", false).allow()) {
                    PassportUpdateSDk.requestPassportUpdate(application);
                }
            }
        });
        OneLoginFacade.getFunction().setWhatsAppListener(new LoginListeners.WhatsAppListener() {
            public boolean supportWhatsAppVerificationCode() {
                return GlobalApolloUtil.isHasWhatsapp();
            }

            public boolean whatsAppInstalled() {
                return Utils.isAppInstalled(application, "com.whatsapp");
            }
        });
        OneLoginFacade.getFunction().setGetParamsListener(new LoginListeners.GetParamsListener() {
            public Map<String, Object> getOmegaParams() {
                FrameworkApplicationDelegate.this.f13746g.put("country", NationComponentDataUtil.getLocCountry());
                return FrameworkApplicationDelegate.this.f13746g;
            }
        });
        OneLoginFacade.getFunction().setIsFirstInstalledListener(new LoginListeners.FirstInstallListener() {
            public String reasonOfFirstInstall() {
                if (!FrameworkApplicationDelegate.this.m9532e((Context) application)) {
                    return null;
                }
                FrameworkApplicationDelegate.this.m9528d((Context) application);
                return "firstInstallSignIn";
            }
        });
        OneLoginFacade.getFunction().addLoginJumpListener(new LoginListeners.LoginJumpListener() {
            public void jump(Activity activity) {
                if (GlobalSPUtil.isFirstInstalled(activity)) {
                    GlobalSPUtil.setFirstInstalled(activity);
                }
                OneLoginFacade.getFunction().removeLoginJumpListener(this);
            }
        });
        if (GlobalSPUtil.isFirstInstalled(application)) {
            OneLoginFacade.getFunction().setShowSkipListener(new LoginListeners.ShowSkipListener() {
                public void isShowSkip(LoginListeners.ShowSkipCallBack showSkipCallBack) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            Apollo.addCacheLoadedListener(FrameworkApplicationDelegate.this.f13747h);
                        }
                    });
                    OneLoginFacade.getFunction().setShowSkipListener((LoginListeners.ShowSkipListener) null);
                }
            });
        }
        OneLoginFacade.getFunction().addLoginOutListener(new LoginListeners.LoginOutListener() {
            public void onSuccess() {
                if (GlobalSPUtil.isFirstInstalled(application)) {
                    GlobalSPUtil.setFirstInstalled(application);
                    OneLoginFacade.getFunction().setShowSkipListener((LoginListeners.ShowSkipListener) null);
                }
            }
        });
        OneLoginFacade.getFunction().setEmailSuffixListener(new EmailSuffixListener());
        OneLoginFacade.getFunction().refreshToken(application);
        OneLoginFacade.getFunction().setLoadingViewListener(this.f13745e);
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onSuccess(Activity activity, String str) {
                if (GlobalSPUtil.isFirstInstalled(activity)) {
                    GlobalSPUtil.setFirstInstalled(activity);
                }
                FrameworkApplicationDelegate.this.f13745e.destroy();
            }

            public void onCancel() {
                FrameworkApplicationDelegate.this.f13745e.destroy();
            }
        });
        LoginListeners.InfoAutoFillListener infoAutoFillListener = (LoginListeners.InfoAutoFillListener) ServiceLoader.load(LoginListeners.InfoAutoFillListener.class).get();
        if (infoAutoFillListener != null) {
            OneLoginFacade.getFunction().setInfoAutoFillListener(infoAutoFillListener);
        }
        m9526d();
        m9522c();
        AppForegroundTracker.track(application, new AppForegroundTracker.AppStateChangeListener() {
            public void appTurnIntoForeground() {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Common.KEY_APPLICATION_STATE_CHANGED, true);
                OrderFloatWindowManager.Instance().appTurnIntoForeground();
            }

            public void appTurnIntoBackGround() {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Common.KEY_APPLICATION_STATE_CHANGED, false);
                OrderFloatWindowManager.Instance().appTurnIntoBackGround();
            }
        });
        OrderFloatWindowManager.Instance().setContext(application);
        m9535f(application);
        if (Apollo.getToggle(f13741f, false).allow()) {
            new InflateTask().run();
        }
        LocationPerformer.getInstance().addLocationListener(new ILocation.ILocationChangedListener() {
            private String mLastCityId;
            private String mLastCountryCode;
            private DIDILocation mLastDiDiLocation;

            public void onLocationChanged(DIDILocation dIDILocation) {
                if (dIDILocation != null) {
                    DIDILocation dIDILocation2 = this.mLastDiDiLocation;
                    if (dIDILocation2 == null || dIDILocation.distanceTo(dIDILocation2) > 200.0d) {
                        this.mLastDiDiLocation = dIDILocation;
                        if (!TextUtils.isEmpty(NationComponentDataUtil.getLocCityId()) && !TextUtils.isEmpty(NationComponentDataUtil.getLocCountry())) {
                            if (TextUtils.isEmpty(this.mLastCityId) || !this.mLastCityId.equals(NationComponentDataUtil.getLocCityId())) {
                                this.mLastCityId = NationComponentDataUtil.getLocCityId();
                                GlobalOmegaUtils.putGlobal("g_city_id", NationComponentDataUtil.getLocCityId());
                                if (TextUtils.isEmpty(this.mLastCountryCode) || !this.mLastCountryCode.equals(NationComponentDataUtil.getLocCountry())) {
                                    this.mLastCountryCode = NationComponentDataUtil.getLocCountry();
                                    GlobalOmegaUtils.putGlobal("g_country_code", NationComponentDataUtil.getLocCountry());
                                }
                            }
                        }
                    }
                }
            }
        });
        m9540h(application);
        m9523c(application);
        m9537g();
        m9511a(application);
        m9518b(application);
        LogUtil.setDebug(true);
        m9542i(application);
        DittoKit.register("_cdn_template", new DittoViewBinderImpl(), true);
        m9510a();
    }

    /* renamed from: a */
    private static boolean m9514a(Context context) {
        return AppUtils.isAppForeground(context) || AppUtils.isRunningInForeground(context);
    }

    /* renamed from: a */
    private void m9510a() {
        OmegaAdapterInterceptorManager.getInstance().registerOmegaAdapterInterceptors(new OmegaUploadRuleInterceptor(new OmegaUploadRuleInterceptor.ParamsProvider() {
            public String getOrderId() {
                OrderCom orderCom = OrderComManager.getInstance().getOrderCom();
                return (orderCom == null || TextUtils.isEmpty(orderCom.getOid())) ? "" : orderCom.getOid();
            }

            public Context getContext() {
                return FrameworkApplicationDelegate.this.mDIDIBaseApplication;
            }
        }));
    }

    /* renamed from: a */
    private void m9511a(Application application) {
        WalletGlobal.init(application);
    }

    /* renamed from: b */
    private void m9518b(final Application application) {
        ThemeType themeType = ThemeType.THEME_99;
        if (application.getPackageName().equals("com.didiglobal.passenger")) {
            themeType = ThemeType.THEME_GLOBAL;
        }
        CashierFacade.getInstance().updateConfigurationProxy(new CashierConfigurationProxy() {
            public void updateConfiguration(Context context) {
                Resources resources = context.getResources();
                Configuration configuration = resources.getConfiguration();
                Locale locale = configuration.locale;
                if (AppUtils.isBrazilApp(context)) {
                    if ("pt".equals(locale.getLanguage())) {
                        configuration.locale = new Locale("pt", "BR");
                    } else {
                        configuration.locale = new Locale("en", GlobalCountryCode.AMERICA);
                    }
                } else if ("en".equals(locale.getLanguage())) {
                    if ("AU".equals(locale.getCountry()) || GlobalCountryCode.ENGLAND.equals(locale.getCountry()) || HistoryRecordFragment.COUNTRY_CODE_NZ.equals(locale.getCountry()) || HistoryRecordFragment.COUNTRY_CODE_ZA.equals(locale.getCountry())) {
                        configuration.locale = new Locale("en", "AU");
                    } else {
                        configuration.locale = new Locale("en", GlobalCountryCode.AMERICA);
                    }
                } else if ("pt".equals(locale.getLanguage())) {
                    configuration.locale = new Locale("en", GlobalCountryCode.AMERICA);
                } else if (RFLocale.CHINESE.equals(locale.getLanguage())) {
                    configuration.locale = new Locale("en", GlobalCountryCode.AMERICA);
                }
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
        });
        CashierFacade.getInstance().init(application, themeType, new CashierInitConfig() {
            public Map<String, Object> getExtraInfo() {
                return null;
            }

            public String getUid() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
            }

            public String getUUID() {
                return SecurityUtil.getUUID();
            }

            public String getToken() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
            }

            public String getTerminalID() {
                return NationTypeUtil.getNationComponentData().getTerminal_id();
            }

            public String getSUUID() {
                return SecurityUtil.getSUUID();
            }

            public String getLocale() {
                return MultiLocaleUtil.getLanguageModel().getLocale();
            }

            public double getLng() {
                return LocationController.getInstance().getLng(application.getApplicationContext());
            }

            public double getLat() {
                return LocationController.getInstance().getLat(application.getApplicationContext());
            }

            public String getLanguage() {
                return LocaleCodeHolder.getInstance().getCurrentLang();
            }

            public String getDeviceId() {
                return SecurityUtil.getDeviceId();
            }

            public String getCityId() {
                return NationTypeUtil.getNationComponentData().getCityId();
            }
        });
    }

    /* renamed from: c */
    private void m9523c(final Application application) {
        if (OneLoginFacade.getStore().isLoginNow()) {
            Tracker.updateMapAdditionArgs(application, NationComponentDataUtil.getLocCountry(), OneLoginFacade.getStore().getUid(), OneLoginFacade.getStore().getPhone(), didihttpdns.toolbox.AppUtils.getVersionName(application));
        } else {
            OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
                public void onCancel() {
                }

                public void onSuccess(Activity activity, String str) {
                    Tracker.updateMapAdditionArgs(application, NationComponentDataUtil.getLocCountry(), OneLoginFacade.getStore().getUid(), OneLoginFacade.getStore().getPhone(), didihttpdns.toolbox.AppUtils.getVersionName(application));
                }
            });
        }
    }

    /* renamed from: b */
    private void m9517b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m9522c() {
        this.f13743c = System.currentTimeMillis();
        LocationController.getInstance().requestLocationUpdateOnce(this.mDIDIBaseApplication, new LocationController.OneCarLocationListener() {
            public void onLocationError(int i, ErrInfo errInfo) {
            }

            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                if (FrameworkApplicationDelegate.this.f13743c != 0 && dIDILocation != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("duration", Long.valueOf(dIDILocation.getLocalTime() - FrameworkApplicationDelegate.this.f13743c));
                    OmegaSDKAdapter.trackEvent("t_first_get_location", "", hashMap);
                }
            }
        });
    }

    /* renamed from: d */
    private void m9526d() {
        CommonPushManager.getInstance().register();
        DPushManager.getInstance().addExtraPushComponent(CommonPushComponent.getInstance());
        CommonPushComponent.getInstance().initPush(this.mDIDIBaseApplication.getApplicationContext());
    }

    /* renamed from: d */
    private void m9527d(final Application application) {
        C580220 r0 = new IHostConfig() {
            public String couponPayHost() {
                return null;
            }

            public String routeTrackHost() {
                return null;
            }

            public String businessHost() {
                return HostConstants.getHostApi();
            }

            public String evaluateHost() {
                return HostConstants.getHostApi();
            }

            public String activityHost() {
                return HostConstants.getHostRes();
            }

            public String carSlidingHost() {
                return HostConstants.getHostCommon();
            }

            public String enterprisePayHost() {
                return HostConstants.getHostPayEnterprise();
            }
        };
        C580321 r1 = new IClientConfig() {
            public int currentBid() {
                return 0;
            }

            public int departAreaUtcOffset() {
                return 0;
            }

            public int locationCity() {
                return 0;
            }

            public String locationCountry() {
                return null;
            }

            public int timezoneUtcOffset() {
                return 0;
            }

            public String token() {
                return NationComponentDataUtil.getToken();
            }

            public String uid() {
                return NationComponentDataUtil.getLoginInfo().getUid();
            }

            public String phone() {
                return NationComponentDataUtil.getPhone();
            }

            public String locale() {
                return MultiLocaleStore.getInstance().getLocaleCode();
            }

            public String mapType() {
                return NationComponentDataUtil.getMapTypeStringForApi();
            }

            public int mapTypeInt() {
                return NationComponentDataUtil.getMapTypeIntForApi();
            }

            public String a3Token() {
                return A3Manager.getA3Token(application);
            }

            public String idfa() {
                return IDFAManager.getIdfa(application, (IDFAManager.onIDFAChangeListener) null);
            }

            public String tripCountry() {
                return AddressUtil.getTripCountry(NationTypeUtil.getNationComponentData());
            }

            public int cityId() {
                Address fromAddress = ExpressShareStore.getInstance().getFromAddress();
                if (fromAddress == null || fromAddress.getCityId() == -1) {
                    return ReverseLocationStore.getsInstance().getCityId();
                }
                return fromAddress.getCityId();
            }

            public String originId() {
                return NationComponentDataUtil.getOriginID();
            }
        };
        TEBridgeConfig tEBridgeConfig = new TEBridgeConfig();
        tEBridgeConfig.setApplication(application);
        tEBridgeConfig.setHostConfig(r0);
        tEBridgeConfig.setClientConfig(r1);
        TEBridge.init(tEBridgeConfig);
        HostManager.setHostConfig(r0);
        TravelSDKV2.init(application, (application.getApplicationInfo() == null || (application.getApplicationInfo().flags & 2) == 0) ? false : true);
        TravelSDKV2.loadBiz(IExpress.class);
        TravelSDKV2.getBiz(IExpress.class).addRpcInvokeBeforeListener(new RpcCommonParamListener() {
            public Map<String, Object> generateRequestParamMap(Api api, Map<String, Object> map) {
                if (api != null && api.getApiInvokePolicy() == ApiInvokePolicy.RPC) {
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    String a3Token = TEBridge.clientConfig().a3Token();
                    if (!TextUtils.isEmpty(a3Token)) {
                        map.put(ServerParamConstant.KEY_A3_TOKEN, a3Token);
                    }
                    map.putAll(BaseRequest.createCommonParams(application));
                }
                return map;
            }
        });
    }

    /* renamed from: e */
    private void m9530e() {
        SafeToolKit.getIns().setRequestParamListener(new ISfRpcRequestParamListener() {
            public <T> T getParam(String str, String str2) {
                if (!SfServerParam.SERVICE_SAFETY_CENTER.equals(str)) {
                    return null;
                }
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != -199317292) {
                    if (hashCode != 3314158) {
                        if (hashCode == 110541305 && str2.equals("token")) {
                            c = 0;
                        }
                    } else if (str2.equals("lang")) {
                        c = 1;
                    }
                } else if (str2.equals("origin_id")) {
                    c = 2;
                }
                if (c == 0) {
                    return NationComponentDataUtil.getToken();
                }
                if (c == 1) {
                    return NationTypeUtil.getNationComponentData().getGLang();
                }
                if (c != 2) {
                    return null;
                }
                return NationComponentDataUtil.getOriginID();
            }
        });
        SafeToolKit.getIns().setOmegaOptListener(new SfOmegaOptListener() {
            public boolean isReportOmega(String str) {
                return true;
            }
        });
    }

    /* renamed from: f */
    private void m9534f() {
        WirelessSecurityManager.init();
    }

    /* renamed from: b */
    private void m9519b(Context context) {
        if (!GlobalSPUtil.isTrackCpuBits(context)) {
            HashMap hashMap = new HashMap();
            String str = SystemUtil.isCPU64() ? DiFaceLogger.EVENT_ID_SUBMIT_MATERIALS_CALLBACK : DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT;
            hashMap.put("cpu_bits", str);
            String cpuProcessor = SystemUtil.getCpuProcessor();
            hashMap.put("cpu_processor", cpuProcessor);
            OmegaSDKAdapter.trackEvent("global_p_cpu_bits", (Map<String, Object>) hashMap);
            GlobalSPUtil.setTrackCpuBits(context);
            Logger logger = this.f13742b;
            logger.info("cpu_bits:" + str + "||cpu_processor:" + cpuProcessor, new Object[0]);
        }
    }

    /* renamed from: c */
    private void m9524c(Context context) {
        ComponentLoader.load(COMPONENT_FRAMEWORK_REGISTER_CLASS);
        BusinessRegistry.registerLocalBusiness(new BusinessRegistry.Entry(30008, "", GlobalComponentConfig.GLOBAL_COMMON));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9528d(Context context) {
        ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class, IMSType.GMS);
        if (context != null && iCollector != null) {
            com.didi.sdk.p154ms.common.utils.LogUtil.m26099i(f13740a, "mapVersionTrack:gmsCollector is Load");
            this.f13742b.info("mapVersionTrack", new Object[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("client_version", Integer.valueOf(iCollector.getMSVersionCode()));
            Logger logger = this.f13742b;
            logger.info("mapVersionTrack GOOGLE_PLAY_SERVICES_VERSION_CODE:" + iCollector.getMSVersionCode(), new Object[0]);
            try {
                PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), iCollector.getMSPackageId(), 0);
                hashMap.put(ServerParam.PARAM_VERSION_CODE, Integer.valueOf(packageInfo.versionCode));
                hashMap.put("version_name", packageInfo.versionName);
                Logger logger2 = this.f13742b;
                logger2.info("mapVersionTrack packageInfo.versionCode:" + packageInfo.versionCode + " packageInfo.versionName:" + packageInfo.versionName, new Object[0]);
            } catch (Exception unused) {
                hashMap.put(ServerParam.PARAM_VERSION_CODE, -1);
                hashMap.put("version_name", "null");
            }
            OmegaSDKAdapter.trackEvent("x_google_pay_service_info", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m9532e(Context context) {
        if (context == null) {
            return false;
        }
        boolean isFirstInstall = GlobalSPUtil.isFirstInstall(context);
        if (isFirstInstall) {
            GlobalSPUtil.setFirstInstall(context);
        }
        return isFirstInstall;
    }

    /* renamed from: e */
    private void m9531e(final Application application) {
        final boolean z = (application.getApplicationInfo() == null || (application.getApplicationInfo().flags & 2) == 0) ? false : true;
        EventTracker.init(new EventTracker.Initializer() {
            public InnerTracker[] createInnerTracker() {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(new DevInnerTracker());
                }
                arrayList.add(new OmegaInnerTracker());
                return (InnerTracker[]) arrayList.toArray(new InnerTracker[0]);
            }

            public AttrsGetter createCommonAttrsGetter() {
                return new IBTCommonAttrsGetter(application);
            }

            public int currentModel() {
                return z ? 0 : 10;
            }

            public boolean isEnabled() {
                return GlobalApolloUtil.isRxTrackEnable();
            }
        });
    }

    /* renamed from: f */
    private void m9535f(final Application application) {
        this.f13743c = System.currentTimeMillis();
        if (application != null && !GlobalSPUtil.getLocationChangeRequestOnce(application)) {
            LocationController.getInstance().requestLocationUpdateOnce(application, new LocationController.OneCarLocationListener() {
                public void onLocationChanged(DIDILocation dIDILocation) {
                    if (dIDILocation != null) {
                        if (FrameworkApplicationDelegate.this.f13743c != 0) {
                            long localTime = dIDILocation.getLocalTime() - FrameworkApplicationDelegate.this.f13743c;
                            HashMap hashMap = new HashMap();
                            hashMap.put("duration", Long.valueOf(localTime));
                            OmegaSDKAdapter.trackEvent("t_first_get_location", "", hashMap);
                        }
                        Logger a = FrameworkApplicationDelegate.this.f13742b;
                        a.info("latitude：" + dIDILocation.getLatitude() + ";longitude：" + dIDILocation.getLongitude(), new Object[0]);
                        if (!TextUtils.isEmpty(NationComponentDataUtil.getToken())) {
                            FrameworkApplicationDelegate.this.m9512a((Context) application, (Map<String, Object>) null);
                        }
                    }
                }

                public void onLocationError(int i, ErrInfo errInfo) {
                    Logger a = FrameworkApplicationDelegate.this.f13742b;
                    a.info("monitorLocationChanged#onLocationError：" + i, new Object[0]);
                }

                public void onStatusUpdate(String str, int i, String str2) {
                    Logger a = FrameworkApplicationDelegate.this.f13742b;
                    a.info("monitorLocationChanged#onStatusUpdate：" + str, new Object[0]);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9512a(final Context context, Map<String, Object> map) {
        OneLoginFacade.getFunction().uploadLocation(context, map, new LoginListeners.PassportServerCallback() {
            public void onSucc(int i, JSONObject jSONObject) {
                if (i == 0) {
                    GlobalSPUtil.setLocationChangeRequestOnce(context, true);
                }
                Logger a = FrameworkApplicationDelegate.this.f13742b;
                a.info("uploadLocation#onSucc#errono=" + i, new Object[0]);
            }

            public void onFail(IOException iOException) {
                FrameworkApplicationDelegate.this.f13742b.info("uploadLocation#onFail", (Throwable) iOException);
            }
        });
    }

    private class EmailSuffixListener implements LoginListeners.ShowEmailSuffixListener {
        private EmailSuffixListener() {
        }

        public void isShowEmailSuffix(final LoginListeners.ShowEmailSuffixCallBack showEmailSuffixCallBack) {
            CarRequest.getLoginEmailSuffixApollo(FrameworkApplicationDelegate.this.mDIDIBaseApplication, new ResponseListener<LoginEmailSuffixModel>() {
                public void onSuccess(LoginEmailSuffixModel loginEmailSuffixModel) {
                    super.onSuccess(loginEmailSuffixModel);
                    if (AppUtils.isGlobalApp(FrameworkApplicationDelegate.this.mDIDIBaseApplication)) {
                        showEmailSuffixCallBack.showEmailSuffix(loginEmailSuffixModel.emailSuffix);
                    } else if (loginEmailSuffixModel.isAllow && "treatment_group".equals(loginEmailSuffixModel.pidGroupName)) {
                        showEmailSuffixCallBack.showEmailSuffix(loginEmailSuffixModel.emailSuffix);
                    }
                }
            });
        }
    }

    /* renamed from: g */
    private void m9538g(Application application) {
        try {
            EventBus.builder().addIndex(new CommonEventBusIndex()).addIndex(new ServiceEventBusIndex()).addIndex(new HomeDestEventBusIndex()).addIndex(new GlobalSdkEventBusIndex()).installDefaultEventBus();
        } catch (Throwable th) {
            th.printStackTrace();
            if ((application.getApplicationInfo() == null || (application.getApplicationInfo().flags & 2) == 0) ? false : true) {
                throw th;
            }
        }
    }

    /* renamed from: h */
    private void m9540h(Application application) {
        ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class, IMSType.GMS);
        if (iCollector != null) {
            iCollector.initFirebaseApp(application);
            FireBaseProxyHolder.setProxy(new FireBaseProxyHolder.IFireBaseProxy() {
                public void trackEvent(String str, Map<String, Object> map) {
                    FireBaseEventUtils.traceEvent(str, false);
                }
            });
            FireBaseEventTracker.setFireBaseEventTrackListener(new FireBaseEventTrackListener() {
                public void trackEvent(String str, Map<String, Object> map) {
                    FireBaseEventUtils.traceEvent(str, false);
                }
            });
        }
    }

    /* renamed from: g */
    private void m9537g() {
        RequestParamsChecker.initRequestCheckConfig();
    }

    /* renamed from: i */
    private void m9542i(Application application) {
        if (GlobalApolloUtil.isDDMirrorUiCheckerEnable()) {
            DDMirror.Companion.initUiChecker(application, GlobalApolloUtil.getDDMirrorUiCheckerConfig(), new IDDMirrorInitCallback() {
                public void onInit(Set<String> set) {
                    for (String subscribe : set) {
                        BaseEventPublisher.getPublisher().subscribe(subscribe, FrameworkApplicationDelegate.this.f13748i);
                    }
                }
            });
        }
        if (GlobalApolloUtil.isDDMirrorNetCheckEnable()) {
            DDMirror.Companion.initNetChecker(application, GlobalApolloUtil.getDDMirrorNetCheckerConfig());
        }
    }
}

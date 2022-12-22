package com.didi.global.flutter.linker;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.util.ApkUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.dvm.patch.dvm_patch.DVMPatchManager;
import com.didi.flutter.hotpatch.flutterhotpatch.FlutterhotpatchPlugin;
import com.didi.flutter.nacho.Default;
import com.didi.flutter.nacho.EngineOption;
import com.didi.flutter.nacho.INachoApp;
import com.didi.flutter.nacho.Nacho;
import com.didi.flutter.nacho.NachoFlutterActivity;
import com.didi.flutter.nacho.NachoPlugin;
import com.didi.flutter.nacho.Page;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DDLaunchTaskManage;
import com.didi.sdk.app.delegate.ApplicationDelegate;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.sidebar.setup.mutilocale.LocaleChangeListener;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.AppUtils;
import com.didi.soda.customer.biz.popdialog.AppsFlyerHelperKt;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.interceptor.LoginActionInterceptor;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.ApolloSwitch;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.omega.sdk.Omega;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

@ServiceProvider(alias = "extended", value = {ApplicationDelegate.class})
public class FlutterApplicationDelegate extends ApplicationDelegate {
    public static final int PASSPORT_FLUTTER_FORCE_CLOSE = 2;
    public static final int PASSPORT_FLUTTER_FORCE_OPEN = 1;
    public static final int PASSPORT_FLUTTER_NO_CONTROL = 0;
    public static final String USER_CENTER_ENGINE_ID = "Engine_userCenter";

    /* renamed from: a */
    long f22027a;

    /* renamed from: b */
    private final Logger f22028b = LoggerFactory.getLogger(getClass());

    /* renamed from: c */
    private boolean f22029c = false;

    public void onCreate(Application application) {
        super.onCreate(application);
        if (!DDLaunchTaskManage.isAllowed()) {
            m15962a(application);
        }
    }

    public void onLoadForground(Application application) {
        if (DDLaunchTaskManage.isAllowed()) {
            m15962a(application);
        }
    }

    /* renamed from: a */
    private void m15962a(final Application application) {
        this.f22027a = System.currentTimeMillis();
        DVMPatchManager.init(application, "dvm_patch_control");
        m15963a("dvm");
        m15965b(application);
        m15963a("init nacho");
        OneLoginFacade.getFunction().addLoginOutListener(new LoginListeners.LoginOutListener() {
            public void onSuccess() {
                INachoApp topContainer = Nacho.getInstance().getTopContainer();
                if (topContainer instanceof NachoFlutterActivity) {
                    ((NachoFlutterActivity) topContainer).finish();
                }
            }
        });
        m15963a("add listener");
        OneLoginFacade.getAction().setInterceptor(new LoginActionInterceptor() {
            public boolean go2Login(Context context) {
                boolean isLoginSDKUIV2 = ApolloSwitch.getInstance().isLoginSDKUIV2(AppUtils.isGlobalApp(application) || Build.VERSION.SDK_INT == 23);
                boolean isEngineStarted = Nacho.getInstance().isEngineStarted();
                int flutterPassportSwitchStatus = GlobalApolloUtil.flutterPassportSwitchStatus();
                if (flutterPassportSwitchStatus != 1) {
                    if (flutterPassportSwitchStatus == 2 || !isLoginSDKUIV2 || !isEngineStarted) {
                        return false;
                    }
                    DRouter.build("GuaranaOneTravel://one/login/login_index").start(context);
                    return true;
                } else if (!isEngineStarted) {
                    return false;
                } else {
                    DRouter.build("GuaranaOneTravel://one/login/login_index").start(context);
                    return true;
                }
            }
        });
        m15963a("interceptor");
    }

    /* renamed from: a */
    private static boolean m15964a(Context context) {
        return AppUtils.isAppForeground(context) || AppUtils.isRunningInForeground(context);
    }

    /* renamed from: b */
    private void m15965b(final Application application) {
        Nacho.LaunchMode launchMode = Nacho.LaunchMode.Immediate;
        IToggle toggle = Apollo.getToggle("flutter_launchmode_config");
        this.f22029c = Apollo.getToggle("nacho_engine_create_by_switch").allow();
        boolean z = true;
        if (Build.VERSION.SDK_INT == 23) {
            launchMode = Nacho.LaunchMode.Requirement;
        } else if (toggle != null && toggle.allow()) {
            int intValue = ((Integer) toggle.getExperiment().getParam(ParamKeys.PARAM_MODE, 0)).intValue();
            if (intValue == 1) {
                launchMode = Nacho.LaunchMode.Idle;
            } else if (intValue == 2) {
                launchMode = Nacho.LaunchMode.Requirement;
            } else if (intValue == 0) {
                launchMode = m15964a((Context) application) ? Nacho.LaunchMode.Immediate : Nacho.LaunchMode.Requirement;
            }
        }
        Logger logger = this.f22028b;
        logger.info("flutter launch mode:" + launchMode, new Object[0]);
        try {
            Nacho.beginConfig(application).setLaunchMode(launchMode).addEngineOption(new EngineOption(Nacho.DEFAULT_ENGINE_ID).createByGroup(!this.f22029c).addArg("passenger")).lifecycleListener(new Default.DefaultFlutterEngineLifecycleListener() {
                long startTime;

                public void onPreStart(Context context, String str) {
                    this.startTime = SystemClock.uptimeMillis();
                    FlutterhotpatchPlugin.init(application);
                }

                public void onPostStart(Context context, String str) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
                    HashMap hashMap = new HashMap();
                    hashMap.put("cost", Long.valueOf(uptimeMillis));
                    OmegaSDKAdapter.trackEvent("tech_flutter_engine_post_start", (Map<String, Object>) hashMap);
                }
            }).nativeInfoFetcher(new Default.DefaultNativeInfoFetcher() {
                public Map<String, Object> getInfo(Context context) {
                    Map<String, Object> info = super.getInfo(context);
                    info.put("isGlobal", Boolean.valueOf(AppUtils.isGlobalApp(context)));
                    info.put("is99", Boolean.valueOf(AppUtils.isBrazilApp(context)));
                    info.put("appID", Integer.valueOf(LoginStore.getInstance().getAppId()));
                    info.put("lang", MultiLocaleStore.getInstance().getLocaleCode());
                    info.put(AppsFlyerHelperKt.appLinkAppName, ApkUtils.getAppName(context));
                    try {
                        info.put("country", CountryManager.getIns().getDefCountry().toJSON());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return info;
                }
            }).router(new Default.DefaultRouter() {
                /* access modifiers changed from: protected */
                public boolean dispatch2Native(String str, HashMap<String, Object> hashMap) {
                    return hashMap != null && hashMap.containsKey("_nacho_url");
                }

                /* access modifiers changed from: protected */
                public boolean openNative(Context context, String str, HashMap<String, Object> hashMap) {
                    Request build = DRouter.build(str);
                    build.addition = hashMap;
                    build.start(context);
                    return true;
                }
            }).init();
            m15961a();
            Nacho instance = Nacho.getInstance();
            EngineOption engineOption = new EngineOption(USER_CENTER_ENGINE_ID);
            if (this.f22029c) {
                z = false;
            }
            instance.addEngineOption(engineOption.createByGroup(z).addArg("passenger"));
            MultiLocaleStore.getInstance().addLocaleChangeListener(new LocaleChangeListener() {
                public void onLocaleChange(String str, String str2) {
                    NachoPlugin nachoPlugin = Nacho.getInstance().getNachoPlugin();
                    if (nachoPlugin != null) {
                        nachoPlugin.envChanged();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Omega.trackError("flutter", e);
            HashMap hashMap = new HashMap();
            hashMap.put("e", "" + e);
            OmegaSDKAdapter.trackEvent("tech_flutter_engine_init_error", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private void m15961a() {
        Nacho.Router().register(new Page("/safety_panel") {
            public void doOpen(Context context, String str, String str2, HashMap hashMap) {
                openFlutterBottomSheetDialog(context, str, str2, hashMap);
            }
        });
        Nacho.Router().register(new Page("/delivery_consignee"));
        Nacho.Router().register(new Page("/login_index"));
        Nacho.Router().register(new Page("/login_auth"));
        Nacho.Router().register(new Page("/crypto_index"));
        Nacho.Router().register(new Page("/buy_bitcoin"));
        Nacho.Router().register(new Page("/sell_bitcoin"));
        Nacho.Router().register(new Page("/welcome_page"));
        Nacho.Router().register(new Page("/transaction_history"));
        Nacho.Router().register(new Page("/buy_bitcoin_keyBoard"));
        Nacho.Router().register(new Page("/sell_bitcoin_keyBoard"));
        Nacho.Router().register(new Page("/account_under_review"));
        Nacho.Router().register(new Page("/kyc_policy_page"));
        Nacho.Router().register(new Page("/calling_code"));
        Nacho.Router().register(new Page("/wallet_topup_main"));
        Nacho.Router().register(new Page("/wallet_topup_boleto"));
        Nacho.Router().register(new Page("/pax_flex_price_page"));
    }

    /* renamed from: a */
    private void m15963a(String str) {
        SystemUtils.log(3, "FlutterAppDelegate", str + " time cost: " + (System.currentTimeMillis() - this.f22027a), (Throwable) null, "com.didi.global.flutter.linker.FlutterApplicationDelegate", 279);
        this.f22027a = System.currentTimeMillis();
    }
}

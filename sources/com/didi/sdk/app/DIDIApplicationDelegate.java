package com.didi.sdk.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.commoninterfacelib.ServiceProviderManager;
import com.didi.dynamic.manager.DownloadManager;
import com.didi.sdk.apm.ApmServiceManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.apm.utils.DebugUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.delegate.ApplicationDelegate;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.dependency.ConstantHolder;
import com.didi.sdk.dependency.ConstantListener;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerConfig;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.logging.util.Supplier;
import com.didi.sdk.logtime.DDMethodIntervalTrack;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.net.INetLibConfigService;
import com.didi.sdk.netintegration.basecore.NetIntegration;
import com.didi.sdk.netintegration.psnger.GlobalPsngerNetParamsAPI;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.downloader.HotPatchDownloadListener;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.ApplicationLifeUtils;
import com.didi.sdk.util.Constant;
import com.didi.sdk.util.LogTimer;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.NumUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.store.LoginStore;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.log.ApolloErrorLog;
import com.didichuxing.apollo.sdk.log.ApolloLog;
import com.didichuxing.apollo.sdk.log.ILogDelegate;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.net.RequestParams;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.Reflect;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.mas.sdk.quality.init.MASSDK;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.omega.sdk.Omega;
import com.didichuxing.omega.sdk.common.OmegaCallback;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didichuxing.swarm.launcher.SwarmLauncher;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import didihttpdns.HttpDnsManager;
import didihttpdns.model.DnsParam;
import didinet.NetEngine;
import java.io.File;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.FrameworkListener;

public class DIDIApplicationDelegate extends ApplicationDelegate implements FrameworkListener {
    private static final String OMEGA_URL = "omgup.didiglobal.com";
    private static final String TAG = "DIDIApplicationDelegate";
    private static Application appContext;
    public static long launchingTime;
    /* access modifiers changed from: private */
    public static INetLibConfigService.NetLibConfig netConfig;
    private ApplicationDelegateManager delegateManager;
    /* access modifiers changed from: private */
    public boolean isFirstActivityLaunched = false;
    /* access modifiers changed from: private */
    public long mLocationStartTime = 0;
    /* access modifiers changed from: private */
    public Logger sLogger;

    public void attachBaseContext(Application application) {
        DDMethodIntervalTrack.get().methodStart("attachBaseContext");
        try {
            SystemUtils.log(3, TAG, "------language:" + Locale.getDefault().getLanguage(), (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 124);
            Class<DIDIBaseApplication> cls = DIDIBaseApplication.class;
            Field declaredField = cls.getDeclaredField("appContext");
            declaredField.setAccessible(true);
            declaredField.set(cls, application);
        } catch (Exception e) {
            e.printStackTrace();
        }
        launchingTime = System.currentTimeMillis();
        appContext = application;
        LogTimer.get().reset();
        createLogger();
        initBaseStore();
        initApollo(appContext);
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                Apollo.getToggle(SystemUtils.TOGGLE_APM_FIREBASEINSTANCEIDRECEIVER, false);
            }
        });
        initApplicationDelegateManager(application);
        this.delegateManager.notifyAttachBaseContextMethod();
        DDMethodIntervalTrack.get().methodEnd("attachBaseContext");
    }

    public static Application getAppContext() {
        return appContext;
    }

    public void onCreate(Application application) {
        DDMethodIntervalTrack.get().methodStart(DDMethodIntervalTrack.application_create_time);
        initLogger(application);
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                if (DIDIApplicationDelegate.this.sLogger != null) {
                    DIDIApplicationDelegate.this.sLogger.info("start log info", new Object[0]);
                    DIDIApplicationDelegate.this.sLogger.debug("start log debug", new Object[0]);
                }
            }
        });
        super.onCreate(application);
        try {
            Class.forName("com.didichuxing.foundation.spi.annotation.ServiceProvider");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        appContext = application;
        initDomainService(application);
        initTLS(application);
        SecurityUtil.init(application);
        SystemUtil.init(application);
        initLoginStore(application);
        Omega.init(application);
        OmegaSDK.setUploadHost(rebuildServerHost("omgup.didiglobal.com"));
        OmegaSDK.setLocationBackgroundEnable(false);
        initMas(application);
        ApmServiceManager.getInstance().init(getAppContext());
        initLocation(application);
        this.delegateManager.notifyOnCreateMethod();
        ApplicationLifeUtils.setApplicationBeginInit(application);
        BizVisibilityDelegateManager.getInstance().loadDelegates();
        AsyncTask.class.toString();
        ActivityLifecycleManager.init(application);
        ActivityLifecycleManager.getInstance().registerActivityLifecycleCallbacks(new ActivityLifecycleManager.AbsActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                try {
                    if (!DIDIApplicationDelegate.this.isFirstActivityLaunched) {
                        SystemUtils.log(4, DIDIApplicationDelegate.TAG, "onActivityCreated: " + activity.getClass().getName(), (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate$3", 213);
                        boolean unused = DIDIApplicationDelegate.this.isFirstActivityLaunched = true;
                        if (!Class.forName("com.didi.sdk.splash.SplashActivity").isInstance(activity)) {
                            SystemUtils.log(4, DIDIApplicationDelegate.TAG, "onActivityCreated: is not SplashActivity", (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate$3", 216);
                            DDLaunchTaskManage.getInstance().notifyLoadForground();
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        SystemUtils.log(3, TAG, "notifyOnCreateMethod", (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 225);
        initNetwork(application);
        DDRpcServiceHelper.init(application);
        initHotpatch(application);
        initOmegaSDKAdapter(application);
        initSwarm(application);
        DDMethodIntervalTrack.get().methodEnd(DDMethodIntervalTrack.application_create_time);
        DDMethodIntervalTrack.get().dump();
        if (EnvPreferenceUtil.getBooleanSafely(appContext, "evn_http_transf_close", false)) {
            NetEngine.getInstance().setTransEnabled(false);
        } else {
            NetEngine.getInstance().setTransEnabled(true);
        }
    }

    private void initOmegaSDKAdapter(Application application) {
        boolean z = false;
        IToggle toggle = Apollo.getToggle("omegaAdapter_switch_toggle", false);
        if (toggle != null && toggle.allow()) {
            z = true;
        }
        SystemUtils.log(3, TAG, "initOmegaSDKAdapter: enable " + z, (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 248);
        OmegaSDKAdapter.init(application, z);
    }

    private void initMas(final Application application) {
        new Thread(new Runnable() {
            public void run() {
                DIDIApplicationDelegate.this.configMAS(application);
            }
        }, "thread - massdk init").start();
    }

    /* access modifiers changed from: private */
    public void configMAS(Application application) {
        MASSDK.setOmegaSDKVersion(OmegaConfig.SDK_VERSION);
        MASSDK.launch(application);
        MASSDK.setUploadHost(rebuildServerHost("omgup.didiglobal.com"));
        MASSDK.setGetUid(new MASConfig.IGetUid() {
            public String getUid() {
                String uid = (NationTypeUtil.getNationComponentData() == null || NationTypeUtil.getNationComponentData().getLoginInfo() == null) ? null : NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
                if (uid == null || !uid.equals("-1")) {
                    return uid;
                }
                return null;
            }
        });
        MASSDK.setGetPhone(new MASConfig.IGetPhone() {
            public String getPhone() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
            }
        });
        MASSDK.setGetCityId(new MASConfig.IGetCityId() {
            public int getCityId() {
                return Integer.valueOf(NationTypeUtil.getNationComponentData().getCityId()).intValue();
            }
        });
        MASSDK.setGetDidiDeviceId(new MASConfig.IGetDidiDeviceId() {
            public String getDidiDeviceId() {
                return SecurityUtil.getDeviceId();
            }
        });
        MASSDK.setGetChannel(new MASConfig.IGetChannel() {
            public String getChannel() {
                return SystemUtil.getChannelId();
            }
        });
        MASSDK.setGetDidiSuuid(new MASConfig.IGetDidiSuuid() {
            public String getDidiSuuid() {
                return SecurityUtil.getSUUID();
            }
        });
    }

    private void initDomainService(Application application) {
        DomainServiceManager.getInstance().initService(application);
        ELog.log("load domain services in ApplicationDelegate#onCreate()");
    }

    private void initTLS(Application application) {
        ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class, IMSType.GMS);
        if (iCollector != null) {
            LogUtil.m26099i(TAG, "initTLS : gmsCollector is load");
            iCollector.sslSecurity(application);
            return;
        }
        LogUtil.m26099i(TAG, "initTLS : no Collector is load");
    }

    private String rebuildServerHost(String str) {
        if (!DomainUtil.isSupportDomainSwitch(appContext)) {
            return str;
        }
        ELog.log("domain switch open, try to rebuild host: " + str);
        String rebuildHost = DomainUtil.rebuildHost(str, DomainServiceManager.getInstance().getDomainSuffix(appContext));
        ELog.log(" after rebuild new host: " + rebuildHost);
        return rebuildHost;
    }

    private void initLogger(Context context) {
        if (context != null) {
            String rebuildServerHost = rebuildServerHost(LoggerConfig.GLOBAL_SERVER_HOST);
            SystemUtils.log(3, TAG, "logger serverhost is :" + rebuildServerHost, (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 384);
            boolean isDebuggableApp = DebugUtils.isDebuggableApp(context);
            LoggerFactory.init(context, new LoggerConfig.Builder().serverHost(rebuildServerHost).fileMaxHistory(7).totalFileSize(73400320).maxFileSize(5242880).fileSectionLength(1048576).fileLogEnabled(true).debuggable(isDebuggableApp).logcatLogEnabled(isDebuggableApp).uid(new Supplier<String>() {
                public String get() {
                    return OneLoginFacade.getStore().getUid();
                }
            }).build());
        }
    }

    private void initLoginStore(Application application) {
        if (application != null) {
            SystemUtils.log(2, TAG, "init login store", (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 416);
            LoginStore.setContext(application);
            LoginStore.getInstance().putAndSave((Context) application, "temp_init_key", 0);
        }
    }

    private void initLocation(Application application) {
        try {
            boolean isMainProcess = isMainProcess(application);
            String curProcessName = getCurProcessName(application);
            Logger logger = this.sLogger;
            logger.info(TAG, "current process name is :" + curProcessName + " and process is mainProcess or not : " + isMainProcess);
            HashMap hashMap = new HashMap();
            hashMap.put("processName", curProcessName);
            hashMap.put("isMainProcess", Boolean.valueOf(isMainProcess));
            OmegaSDKAdapter.trackEvent("global_location_init", (Map<String, Object>) hashMap);
        } catch (Exception unused) {
        }
        this.mLocationStartTime = 0;
        final DIDILocationManager instance = DIDILocationManager.getInstance(application);
        DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
        defaultLocationUpdateOption.setModuleKey("application");
        IToggle toggle = Apollo.getToggle("global_road_test_simulate_toggle");
        if (toggle.allow() && (toggle != null)) {
            instance.setCoordinateType(1);
        } else {
            instance.setCoordinateType(0);
        }
        final C1193212 r0 = new DIDILocationListener() {
            public void onLocationError(int i, ErrInfo errInfo) {
            }

            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - DIDIApplicationDelegate.this.mLocationStartTime;
                if (elapsedRealtime > 0) {
                    SystemUtils.log(3, DIDIApplicationDelegate.TAG, "initLocation#locationCostTime:" + elapsedRealtime, (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate$12", 458);
                }
                SystemUtils.log(3, DIDIApplicationDelegate.TAG, "initLocation#location:" + dIDILocation, (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate$12", 460);
            }
        };
        instance.requestLocationUpdates(r0, defaultLocationUpdateOption);
        this.mLocationStartTime = SystemClock.elapsedRealtime();
        SystemUtils.log(3, TAG, "initLocation#initTime:" + System.currentTimeMillis(), (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 476);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                instance.removeLocationUpdates(r0);
            }
        }, 3000);
    }

    private void initApplicationDelegateManager(Application application) {
        this.delegateManager = new ApplicationDelegateManager(application);
        DDLaunchTaskManage.getInstance().setDelegateMge(this.delegateManager);
    }

    private void createLogger() {
        if (this.sLogger == null) {
            this.sLogger = LoggerFactory.getLogger(TAG);
        }
    }

    private void initBaseStore() {
        ConstantHolder.getInstance().setConstantListener(new ConstantListener() {
            public String[] getBusinessIds() {
                return Constant.BUSINESS_IDS;
            }
        });
    }

    private void initSwarm(Application application) {
        AbsActivator absActivator = (AbsActivator) ComponentLoadUtil.getComponent(AbsActivator.class);
        SwarmLauncher.getInstance().launch(application, absActivator, absActivator.getAssetBundles(), this);
    }

    private void initHotpatch(Application application) {
        try {
            String host = PatchManager.getHost(application);
            String appKey = PatchManager.getAppKey(application);
            DownloadManager.setModuleUrlHost(host);
            DownloadManager instance = DownloadManager.getInstance(application);
            int strToInt = NumUtil.strToInt(NationTypeUtil.getNationComponentData().getCityId());
            instance.setExtraParameter(appKey, MD5.toMD5(NationTypeUtil.getNationComponentData().getLoginInfo().getPhone() + "20200323"), strToInt, -1.0d, -1.0d, "");
            HashMap hashMap = new HashMap();
            hashMap.put("local", NationTypeUtil.getNationComponentData().getLocaleCode());
            hashMap.put("country", NationTypeUtil.getNationComponentData().getLocCountry());
            Logger logger = this.sLogger;
            logger.debug("hotpatch extra params:" + new Gson().toJson((Object) hashMap), new Object[0]);
            instance.setExtraParamMap(hashMap);
            instance.addDownloadListener(1, new HotPatchDownloadListener(application));
            instance.checkModuleAndDownload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initOmegaSDK(final Application application) {
        String omegaId = Omega.getOmegaId();
        SystemUtils.log(4, "OmegaId", "OmegaId: " + omegaId, (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 545);
        final NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        OmegaSDK.setGetUid(new OmegaConfig.IGetUid() {
            public String getDidiPassengerUid() {
                String uid = (NationTypeUtil.getNationComponentData() == null || NationTypeUtil.getNationComponentData().getLoginInfo() == null) ? null : NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
                if (uid == null || !uid.equals("-1")) {
                    return uid;
                }
                return null;
            }
        });
        OmegaSDK.setGetDailingCountryCode(new OmegaConfig.IGetDailingCountryCode() {
            public String getDailingCountryCode() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getPhoneCountryCode();
            }
        });
        OmegaSDK.setGetPhone(new OmegaConfig.IGetPhone() {
            public String getPhone() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
            }
        });
        String omegaSDKUploadHost = nationComponentData.getOmegaSDKUploadHost();
        if (!TextUtil.isEmpty(omegaSDKUploadHost)) {
            OmegaSDK.setUploadHost(omegaSDKUploadHost);
            OmegaSDK.switchUseHttps(true);
        }
        OmegaSDK.setGetCityId(new OmegaConfig.IGetCityId() {
            public int getCityId() {
                return Integer.valueOf(NationTypeUtil.getNationComponentData().getCityId()).intValue();
            }
        });
        OmegaSDK.setPrintLogListener(new OmegaCallback.PrintLogListener() {
            private Logger log = LoggerFactory.getLogger((Class<?>) OmegaSDK.class);

            public void printLog(int i, String str, Throwable th) {
                this.log.info(str, th);
            }
        });
        OmegaSDK.setAsyncInit(new OmegaCallback.AsyncInit() {
            public void init() {
                OmegaSDK.setChannel(SystemUtil.getChannelId());
                OmegaSDK.setDidiSuuid(SecurityUtil.getSUUID());
                OmegaSDK.setDidiDeviceId(SecurityUtil.getDeviceId());
                OmegaSDK.setAppVersion(DIDIApplicationDelegate.getIssueString(application));
                OmegaSDK.setGetuiCid(nationComponentData.getPushConfig().getPushId());
                OmegaSDK.setCustomLocale(new OmegaConfig.ILocale() {
                    public String getLocale() {
                        return nationComponentData.getGLang();
                    }
                });
            }
        });
    }

    private void initNetwork(Application application) {
        INetLibConfigService.NetLibConfig netLibConfig = null;
        INetLibConfigService iNetLibConfigService = (INetLibConfigService) ServiceProviderManager.getInstance().getComponent(INetLibConfigService.class);
        if (iNetLibConfigService != null) {
            netLibConfig = iNetLibConfigService.getNetLibConfig();
        }
        netConfig = netLibConfig;
        NetIntegration.getInstance().init(application, new GlobalPsngerNetParamsAPI() {
            public boolean getTransEnable(Context context) {
                return true;
            }

            public boolean manualInitHttpDns() {
                return true;
            }

            public DnsParam getDnsParam() {
                DnsParam dnsParam = new DnsParam();
                HashMap hashMap = new HashMap();
                int i = 1;
                hashMap.put("net_config_is_null", Integer.valueOf(DIDIApplicationDelegate.netConfig != null ? 1 : 0));
                if (DIDIApplicationDelegate.netConfig == null || DIDIApplicationDelegate.netConfig.httpdnsBatchHosts == null) {
                    i = 0;
                }
                hashMap.put("httpdns_batch_host_is_null", Integer.valueOf(i));
                OmegaSDKAdapter.trackEvent("tech_pax_httpdns_init_params_monitor", (Map<String, Object>) hashMap);
                if (!(DIDIApplicationDelegate.netConfig == null || DIDIApplicationDelegate.netConfig.httpdnsBatchHosts == null)) {
                    dnsParam.hostNames = Arrays.asList(DIDIApplicationDelegate.netConfig.httpdnsBatchHosts);
                    dnsParam.apolloName = DIDIApplicationDelegate.netConfig.httpDnsApolloName;
                    dnsParam.requestHttpDnsUrl = DIDIApplicationDelegate.netConfig.httpdnsUrl;
                    if (DIDIApplicationDelegate.netConfig.blackHosts != null) {
                        dnsParam.blackHosts = Arrays.asList(DIDIApplicationDelegate.netConfig.blackHosts);
                    }
                }
                dnsParam.uid = NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
                return dnsParam;
            }

            public String getUid() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
            }

            public String getTerminalTag() {
                if (DIDIApplicationDelegate.netConfig != null) {
                    return DIDIApplicationDelegate.netConfig.terminalTag;
                }
                return null;
            }

            public int getFlowTag() {
                return (!Apollo.getToggle("flow_mark").allow() || !SystemUtil.getChannelId().equals("1")) ? 0 : 1;
            }

            public int getCityID(Context context) {
                return Integer.valueOf(NationTypeUtil.getNationComponentData().getCityId()).intValue();
            }
        });
        if (!isDelayInitHttpDns()) {
            initHttpDns(application);
        }
        whetherSkipIpv6();
    }

    private static void initHttpDns(Context context) {
        NetIntegration.getInstance().initHttpDns(context);
    }

    private void whetherSkipIpv6() {
        HttpDnsManager.getInstance().setIpv6Limit(new HttpDnsManager.Ipv6Limit() {
            public boolean ignoreLimit(InetSocketAddress inetSocketAddress) {
                IToggle toggle = Apollo.getToggle("whether_to_skip_ipv6", false);
                if (toggle == null || !toggle.allow()) {
                    return false;
                }
                return true;
            }
        });
    }

    private static boolean isDelayInitHttpDns() {
        IToggle toggle = Apollo.getToggle("init_httpdns_later");
        return toggle != null && toggle.allow();
    }

    public static void delayInitHttpDns(Context context) {
        if (isDelayInitHttpDns()) {
            initHttpDns(context);
        }
    }

    static String getProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, "unknown"});
        } catch (Throwable unused) {
        }
        return str2;
    }

    private void initApollo(Application application) {
        Apollo.setContext(application);
        Apollo.setRequestHandler(new RequestHandler() {
            public void handleRequestParams(RequestParams requestParams) {
                String str;
                Map<String, String> apolloParams;
                requestParams.addParam("origin_id", NationTypeUtil.getNationComponentData().getOriginID());
                requestParams.addParam("map_type", NationTypeUtil.getNationComponentData().getMapTypeString());
                if (TextUtils.isEmpty(NationTypeUtil.getNationComponentData().getLocCountry())) {
                    str = "5".equals(NationTypeUtil.getNationComponentData().getOriginID()) ? "BR" : "";
                } else {
                    str = NationTypeUtil.getNationComponentData().getLocCountry();
                }
                requestParams.addParam("location_country", str);
                requestParams.addParam("brand", Build.BRAND);
                try {
                    String str2 = (String) Reflect.getStaticProp("com.didi.abtest.ABTest", "AB_TEST_KEY");
                    String str3 = (String) Reflect.getStaticProp("com.didi.abtest.ABTest", "AB_TEST_VALUE");
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        requestParams.addParam(str2, str3);
                    }
                } catch (Exception unused) {
                }
                requestParams.addParam("oid", Omega.getOmegaId());
                requestParams.addParam("__exclude_false", "true");
                try {
                    IParamProvider iParamProvider = (IParamProvider) ServiceLoader.load(IParamProvider.class).get();
                    if (iParamProvider != null && (apolloParams = iParamProvider.getApolloParams()) != null && apolloParams.size() > 0) {
                        for (String next : apolloParams.keySet()) {
                            if (!requestParams.getParams().containsKey(next)) {
                                requestParams.addParam(next, apolloParams.get(next));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Apollo.init(application);
        Apollo.setServerHost(rebuildServerHost(Apollo.getServerHost()));
        final C12017i iVar = new C12017i();
        Apollo.setLogDelegate(new ILogDelegate() {
            public void saveLog(ApolloLog apolloLog) {
                iVar.transmit(apolloLog);
            }

            public void saveErrorLog(ApolloErrorLog apolloErrorLog) {
                iVar.transmit(apolloErrorLog);
            }
        });
        ANRApolloHelper.addToggleStateChangeListener(application);
        DiPushApolloHelper.addToggleStateChangeListener(application);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r3 = r3.metaData.getString("issue");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getIssueString(android.content.Context r3) {
        /*
            java.lang.String r0 = "issue"
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch:{ Exception -> 0x002f }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x002f }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r3 = com.didi.sdk.apm.SystemUtils.getApplicationInfo(r1, r3, r2)     // Catch:{ Exception -> 0x002f }
            android.os.Bundle r1 = r3.metaData     // Catch:{ Exception -> 0x002f }
            if (r1 == 0) goto L_0x002f
            android.os.Bundle r1 = r3.metaData     // Catch:{ Exception -> 0x002f }
            boolean r1 = r1.containsKey(r0)     // Catch:{ Exception -> 0x002f }
            if (r1 == 0) goto L_0x002f
            android.os.Bundle r3 = r3.metaData     // Catch:{ Exception -> 0x002f }
            java.lang.String r3 = r3.getString(r0)     // Catch:{ Exception -> 0x002f }
            if (r3 == 0) goto L_0x002f
            java.lang.String r0 = r3.trim()     // Catch:{ Exception -> 0x002f }
            int r0 = r0.length()     // Catch:{ Exception -> 0x002f }
            if (r0 <= 0) goto L_0x002f
            return r3
        L_0x002f:
            java.lang.String r3 = "unknown"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.DIDIApplicationDelegate.getIssueString(android.content.Context):java.lang.String");
    }

    public void frameworkEvent(FrameworkEvent frameworkEvent) {
        int type = frameworkEvent.getType();
        if (type == 1) {
            this.sLogger.debug("Swarm framework started", new Object[0]);
            BundleContext bundleContext = SwarmLauncher.getInstance().getFramework().getBundleContext();
            initOmegaSDK((Application) bundleContext.getService(bundleContext.getServiceReference(Application.class)));
        } else if (type == 2) {
            this.sLogger.debug("Swarm framework error", new Object[0]);
        }
    }

    public void onConfigurationChanged(Configuration configuration, Application application) {
        super.onConfigurationChanged(configuration, application);
        ApplicationDelegateManager applicationDelegateManager = this.delegateManager;
        if (applicationDelegateManager != null) {
            applicationDelegateManager.notifyOnConfigurationChanged(configuration, application);
        }
    }

    private void cleanMapData() {
        IToggle toggle = Apollo.getToggle("global_passenger_clean_map_data", true);
        if (toggle.allow()) {
            try {
                SystemUtils.log(5, TAG, "fix google map bug", (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 870);
                SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(appContext, (String) toggle.getExperiment().getParam("sp_name", "google_bug_154855417v2"), 0);
                if (sharedPreferences != null && !sharedPreferences.contains("fixed")) {
                    File file = new File(appContext.getFilesDir(), "ZoomTables.data");
                    File file2 = new File(appContext.getFilesDir(), "SavedClientParameters.data.cs");
                    File filesDir = appContext.getFilesDir();
                    File file3 = new File(filesDir, "DATA_ServerControlledParametersManager.data." + appContext.getPackageName());
                    File filesDir2 = appContext.getFilesDir();
                    File file4 = new File(filesDir2, "DATA_ServerControlledParametersManager.data.v1." + appContext.getPackageName());
                    file.delete();
                    file2.delete();
                    file3.delete();
                    file4.delete();
                    sharedPreferences.edit().putBoolean("fixed", true).apply();
                    SystemUtils.log(5, TAG, "delete files done", (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 891);
                }
            } catch (Throwable th) {
                SystemUtils.log(5, TAG, "fix google map bug failed:" + th.getMessage(), (Throwable) null, "com.didi.sdk.app.DIDIApplicationDelegate", 894);
                Omega.trackError("google_bug_154855417", th);
            }
        }
    }
}

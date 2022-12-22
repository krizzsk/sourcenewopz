package com.didi.dimina.container;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.FontResourceLoader;
import com.didi.dimina.container.bridge.JSBridgePluginLoader;
import com.didi.dimina.container.bridge.base.BridgeModule;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.dimina.container.bridge.plugin.GlobalJSModuleManager;
import com.didi.dimina.container.bridge.plugin.exception.GlobalBridgeModuleNotFoundException;
import com.didi.dimina.container.bridge.plugin.exception.GlobalBridgeModuleRegisteredException;
import com.didi.dimina.container.debug.IWebSocketMsgSender;
import com.didi.dimina.container.debug.OnWebSocketStatus;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.mina.DMLaunchLifecycleManager;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.DefaultDMNavigator;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.mina.IDMNavigator;
import com.didi.dimina.container.p106ui.custom.ComponentManager;
import com.didi.dimina.container.p106ui.custom.CustomComponent;
import com.didi.dimina.container.service.CityDataService;
import com.didi.dimina.container.service.ImageLoaderService;
import com.didi.dimina.container.service.LogService;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.service.PermissionService;
import com.didi.dimina.container.service.RegionConfigService;
import com.didi.dimina.container.service.TraceActionService;
import com.didi.dimina.container.service.TraceService;
import com.didi.dimina.container.service.WsgService;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.dimina.container.util.TraceUtil;

public class Dimina {

    /* renamed from: a */
    private static boolean f16555a = false;

    /* renamed from: b */
    private static Config f16556b;

    public interface AppInstallCallback {
        void onLocalInstalled();

        void onRemoteInstalled();
    }

    public static String getVersion() {
        return "2.24.4";
    }

    public static Config getConfig() {
        m12173a();
        return f16556b;
    }

    public static boolean isInit() {
        return f16555a;
    }

    public static void init(Config config) {
        if (!f16555a) {
            f16555a = true;
            f16556b = config;
            if (config.checkParam()) {
                JSBridgePluginLoader.loadPlugin(config.mApp);
                FontResourceLoader.load(config.mApp);
                NetWorkStateReceiver.getInstance().init(config.mApp);
                return;
            }
            throw new IllegalArgumentException("参数出错");
        }
    }

    public static DMMina requireInstall(DMConfig dMConfig, final AppInstallCallback appInstallCallback) {
        m12173a();
        DMMina generate = DMMinaPool.generate((FragmentActivity) null, dMConfig);
        final String obj = dMConfig.toString();
        final int minaIndex = generate.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.DIMINA_REQUIRE_INSTALL_START, obj);
        generate.mo53970a((IDMCommonAction<Void>) new IDMCommonAction<Void>() {
            public void callback(Void voidR) {
                AppInstallCallback appInstallCallback = appInstallCallback;
                if (appInstallCallback != null) {
                    appInstallCallback.onLocalInstalled();
                }
                TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.DIMINA_REQUIRE_INSTALL_END_LOCAL, obj);
            }
        }, (IDMCommonAction<Void>) new IDMCommonAction<Void>() {
            public void callback(Void voidR) {
                AppInstallCallback appInstallCallback = appInstallCallback;
                if (appInstallCallback != null) {
                    appInstallCallback.onRemoteInstalled();
                }
                TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.DIMINA_REQUIRE_INSTALL_END_REMOTE, obj);
            }
        }, (IDMCommonAction<DMMina.InstallStatus>) null);
        return generate;
    }

    public static DMMina requireInstall(DMConfig dMConfig) {
        m12173a();
        return requireInstall(dMConfig, (AppInstallCallback) null);
    }

    public static DMMina launch(FragmentActivity fragmentActivity, DMConfig dMConfig, IDMNavigator iDMNavigator) {
        return launch(fragmentActivity, dMConfig, iDMNavigator, (IWebSocketMsgSender) null);
    }

    public static DMMina launch(FragmentActivity fragmentActivity, DMConfig dMConfig, final IDMNavigator iDMNavigator, IWebSocketMsgSender iWebSocketMsgSender) {
        final DMMina generate = DMMinaPool.generate(fragmentActivity, dMConfig);
        TraceUtil.trackEventCoreDotting(generate.getMinaIndex(), Constant.CORE_DOTTING.DIMINA_LAUNCH, dMConfig.toString());
        if (iWebSocketMsgSender != null) {
            generate.setWebSocketMsgSender(iWebSocketMsgSender);
            iWebSocketMsgSender.startConnect(generate, dMConfig.getLaunchConfig().getIDEDebugUrl(), new OnWebSocketStatus() {
                public void onFailed() {
                }

                public void onSuccess() {
                    generate.launch(iDMNavigator);
                }
            });
        } else {
            generate.launch(iDMNavigator);
        }
        return generate;
    }

    public static void releaseDMMina(int i) {
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.DIMINA_RELEASE, "minaIndex: " + i);
        DMMinaPool.remove(i, false);
    }

    public static IDMNavigator generateDefaultDMNavigator(FragmentManager fragmentManager, int i) {
        return new DefaultDMNavigator(fragmentManager, i);
    }

    public static void registerLaunchLifecycleCallback(DMLaunchLifecycleManager.LaunchLifecycleCallback launchLifecycleCallback) {
        TraceUtil.trackEventCoreDotting(TraceUtil.MINA_INDEX_UN_KNOW, Constant.CORE_DOTTING.DIMINA_REGISTER_LAUNCH_LIFECYCLE_CALLBACK, launchLifecycleCallback.toString());
        DMLaunchLifecycleManager.getInstance().registerPageLifecycleCallback(launchLifecycleCallback);
    }

    public static void unregisterLaunchLifecycleCallback(DMLaunchLifecycleManager.LaunchLifecycleCallback launchLifecycleCallback) {
        TraceUtil.trackEventCoreDotting(TraceUtil.MINA_INDEX_UN_KNOW, Constant.CORE_DOTTING.DIMINA_UN_REGISTER_LAUNCH_LIFECYCLE_CALLBACK, launchLifecycleCallback.toString());
        DMLaunchLifecycleManager.getInstance().unregisterPageLifecycleCallback(launchLifecycleCallback);
    }

    public static void registerCustomComponent(String str, Class<? extends CustomComponent> cls) {
        TraceUtil.trackEventCoreDotting(TraceUtil.MINA_INDEX_UN_KNOW, Constant.CORE_DOTTING.DIMINA_REGISTER_CUSTOM_COMPONENT, "name: " + str + " | clazz: " + cls);
        ComponentManager.registerCustomComponent(str, cls);
    }

    public static void registerJSModule(Class<? extends BaseServiceModule> cls) throws GlobalBridgeModuleNotFoundException, GlobalBridgeModuleRegisteredException {
        if (cls != null) {
            String name = cls.getName();
            BridgeModule bridgeModule = (BridgeModule) cls.getAnnotation(BridgeModule.class);
            if (bridgeModule == null || TextUtils.isEmpty(bridgeModule.name())) {
                throw new GlobalBridgeModuleNotFoundException("自定义的全局Bridge模块类，必须用com.didi.dimina.container.bridge.base.BridgeModule注解注明模块名称");
            }
            if (!TextUtils.isEmpty(bridgeModule.name())) {
                name = bridgeModule.name();
            }
            TraceUtil.trackEventCoreDotting(TraceUtil.MINA_INDEX_UN_KNOW, Constant.CORE_DOTTING.DIMINA_REGISTER_JS_MODULE, "name: " + name + " | clazz: " + cls);
            GlobalJSModuleManager.registerJSModule(name, cls);
        }
    }

    public static void registerDMServiceSubJSModule(Class<? extends BaseServiceModule> cls) {
        if (cls != null) {
            GlobalJSModuleManager.registerDMServiceSubJSModule(cls);
        }
    }

    /* renamed from: a */
    private static void m12173a() {
        if (!f16555a) {
            throw new IllegalStateException("请先进行初始化操作");
        }
    }

    public static class Config {
        private final AdapterConfig mAdapterConfig = new AdapterConfig();
        /* access modifiers changed from: private */
        public Application mApp;
        private boolean mIsBlackScreenAllow = true;
        private boolean mIsDebug = false;
        private String mJsSdkId;

        /* access modifiers changed from: private */
        public boolean checkParam() {
            return this.mApp != null;
        }

        public void setApp(Application application) {
            this.mApp = application;
        }

        public Application getApp() {
            return this.mApp;
        }

        public void setIsDebug(boolean z) {
            this.mIsDebug = z;
        }

        public boolean isDebug() {
            return this.mIsDebug;
        }

        public AdapterConfig getAdapterConfig() {
            return this.mAdapterConfig;
        }

        public String getJsSdkId() {
            if (TextUtil.isEmpty(this.mJsSdkId)) {
                return Constant.DEFAULT_JS_SDK_ID;
            }
            return this.mJsSdkId;
        }

        public boolean isJsSdkDefault() {
            return TextUtil.isEmpty(this.mJsSdkId);
        }

        public void setJsSdkId(String str) {
            this.mJsSdkId = str;
        }

        public boolean isBlackScreenAllow() {
            return this.mIsBlackScreenAllow;
        }

        public void setIsBlackScreenAllow(boolean z) {
            this.mIsBlackScreenAllow = z;
        }
    }

    public static class AdapterConfig {
        private CityDataService mCityDataService;
        private NetworkService mHttpService;
        private ImageLoaderService mImageLoaderService;
        private LogService mLogService;
        private PermissionService mPermissionService;
        private RegionConfigService mRegionConfigService = new RegionConfigService();
        private TraceActionService mTraceActionService;
        private TraceService mTraceService;
        private WsgService mWsgService;

        public NetworkService getHttpService() {
            return this.mHttpService;
        }

        public void setHttpService(NetworkService networkService) {
            this.mHttpService = networkService;
        }

        public CityDataService getCityDataService() {
            return this.mCityDataService;
        }

        public ImageLoaderService getImageLoaderService() {
            return this.mImageLoaderService;
        }

        public void setImageLoaderService(ImageLoaderService imageLoaderService) {
            this.mImageLoaderService = imageLoaderService;
        }

        public WsgService getWsgService() {
            return this.mWsgService;
        }

        public void setWsgService(WsgService wsgService) {
            this.mWsgService = wsgService;
        }

        public PermissionService getPermissionService() {
            return this.mPermissionService;
        }

        public void setPermissionService(PermissionService permissionService) {
            this.mPermissionService = permissionService;
        }

        public void setCityDataService(CityDataService cityDataService) {
            this.mCityDataService = cityDataService;
        }

        public TraceService getTraceService() {
            return this.mTraceService;
        }

        public void setTraceService(TraceService traceService) {
            this.mTraceService = traceService;
        }

        public TraceActionService getTraceActionService() {
            return this.mTraceActionService;
        }

        public void setTraceActionService(TraceActionService traceActionService) {
            this.mTraceActionService = traceActionService;
        }

        public LogService getLogService() {
            return this.mLogService;
        }

        public void setLogService(LogService logService) {
            this.mLogService = logService;
        }

        public RegionConfigService getRegionConfigService() {
            ensureRegistonConfig();
            return this.mRegionConfigService;
        }

        public void setRegionConfigService(RegionConfigService regionConfigService) {
            this.mRegionConfigService = regionConfigService;
        }

        private void ensureRegistonConfig() {
            if (this.mRegionConfigService.getState() == RegionConfigService.RegionState.DEFAULT) {
                try {
                    Class<?> cls = Class.forName("com.didi.dimina.config.national.NationalConfig");
                    if (cls != null) {
                        this.mRegionConfigService = (RegionConfigService) cls.newInstance();
                    }
                } catch (ClassNotFoundException e) {
                    LogUtil.eRelease("AdapterConfig", " 配置错误, 请联系星河开发人员, 或参考星河文档进行配置, https://docx.intra.xiaojukeji.com/docs/dimina/#/change/android_list 搜索关键词 \"合规配置模块\" ");
                    LogUtil.eRelease("AdapterConfig", Log.getStackTraceString(e));
                    e.printStackTrace();
                    this.mRegionConfigService.setState(RegionConfigService.RegionState.NATIONAL_INIT_FAIL);
                } catch (Exception e2) {
                    LogUtil.iRelease("AdapterConfig", "RegionConfig 转化异常 " + Log.getStackTraceString(e2));
                    e2.printStackTrace();
                    this.mRegionConfigService.setState(RegionConfigService.RegionState.NATIONAL_INIT_FAIL);
                }
            }
        }
    }
}

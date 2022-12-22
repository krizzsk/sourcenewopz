package com.didi.dimina.container.secondparty;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.secondparty.bundle.PreInstallManager;
import com.didi.dimina.container.secondparty.citydata.DiminaCityDataService;
import com.didi.dimina.container.secondparty.http.DidiNetworkServiceManager;
import com.didi.dimina.container.secondparty.image.DidiImageLoaderServiceManager;
import com.didi.dimina.container.secondparty.jsmodule.DMServiceTwoPartJSModule;
import com.didi.dimina.container.secondparty.log.DiminaLogService;
import com.didi.dimina.container.secondparty.permission.DidiPermissionManager;
import com.didi.dimina.container.secondparty.pushpage.DiminaPushPageHelper;
import com.didi.dimina.container.secondparty.route.RouteConfig;
import com.didi.dimina.container.secondparty.route.RouteParseManager;
import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.dimina.container.secondparty.trace.TraceActionServiceImpl;
import com.didi.dimina.container.secondparty.util.ApolloUtil;
import com.didi.dimina.container.secondparty.wsg.DidiWsgServiceManager;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import java.util.HashMap;

public class Dimina4Di extends Dimina {

    /* renamed from: a */
    private static boolean f17043a = false;

    public static void init(Config config) {
        if (!f17043a) {
            f17043a = true;
            Dimina.init(config);
            if (((Integer) ApolloUtil.getApolloValue("dimina_saga_system_config", "socket_upload_disable", 0)).intValue() == 1) {
                config.setTraceWebSocket(false);
            }
            registerLaunchLifecycleCallback(DiminaPushPageHelper.INSTANCE);
            TraceUtil.trackEventCoreDotting(TraceUtil.MINA_INDEX_UN_KNOW, Constant.CORE_DOTTING.DIMINA_INIT, config.toString());
            if (((Integer) ApolloUtil.getApolloValue("dimina_saga_system_config", "webview_blank_disable", 0)).intValue() == 1) {
                config.setIsBlackScreenAllow(false);
            }
        }
    }

    public static int requireInstallWithStrategy(DMConfig dMConfig, Dimina.AppInstallCallback appInstallCallback) {
        PreInstallManager.Strategy checkStrategy = PreInstallManager.checkStrategy(dMConfig);
        if (checkStrategy != PreInstallManager.Strategy.MISS) {
            LogUtil.iRelease("requireInstallWithStrategy", "预安装 命中策略:" + checkStrategy.getIndex() + ", 执行预安装动作");
            Dimina.requireInstall(dMConfig, appInstallCallback);
        }
        return checkStrategy.getIndex();
    }

    public static class Config extends Dimina.Config {
        private String mPckManagerHostDomain;
        private String mStarBoxAppId;
        private boolean mTraceWebSocket = true;
        private String mWxAppID;
        private final HashMap<String, String> mWxIDtoAppIDMap = new HashMap<>();

        public Config() {
            getAdapterConfig().setHttpService(new DidiNetworkServiceManager());
            getAdapterConfig().setCityDataService(new DiminaCityDataService());
            getAdapterConfig().setTraceService(new DiminaTraceService());
            getAdapterConfig().setTraceActionService(new TraceActionServiceImpl());
            getAdapterConfig().setLogService(new DiminaLogService());
            getAdapterConfig().setImageLoaderService(new DidiImageLoaderServiceManager());
            getAdapterConfig().setWsgService(new DidiWsgServiceManager());
            getAdapterConfig().setPermissionService(new DidiPermissionManager());
            Dimina.registerDMServiceSubJSModule(DMServiceTwoPartJSModule.class);
        }

        public void setWxAppID(String str) {
            this.mWxAppID = str;
        }

        public String getWxAppID() {
            return this.mWxAppID;
        }

        public boolean isTraceWebSocket() {
            return this.mTraceWebSocket;
        }

        public void setTraceWebSocket(boolean z) {
            this.mTraceWebSocket = z;
        }

        public HashMap<String, String> getWXIDtoAppIDMap() {
            return this.mWxIDtoAppIDMap;
        }

        public void setWXIDtoAppIDMap(HashMap<String, String> hashMap) {
            this.mWxIDtoAppIDMap.clear();
            this.mWxIDtoAppIDMap.putAll(hashMap);
        }

        public String getPckManagerHostDomain() {
            return this.mPckManagerHostDomain;
        }

        public void setPckManagerHostDomain(String str) {
            this.mPckManagerHostDomain = str;
        }

        public String getStarBoxAppId() {
            return this.mStarBoxAppId;
        }

        public void setStarBoxAppId(String str) {
            this.mStarBoxAppId = str;
        }
    }

    public static class Router {
        private final Context mContext;
        private RouteConfig mRouteConfig;
        private Uri mUri;

        public static Router with(Activity activity) {
            return new Router(activity);
        }

        public static Router with(Fragment fragment) {
            return new Router(fragment.getActivity());
        }

        private Router(Context context) {
            this.mContext = context;
        }

        public Router setUri(Uri uri) {
            this.mUri = uri;
            return this;
        }

        public Router setRouteConfig(RouteConfig routeConfig) {
            this.mRouteConfig = routeConfig;
            return this;
        }

        public void start() {
            if (this.mRouteConfig == null) {
                this.mRouteConfig = RouteParseManager.parseUri(this.mContext, this.mUri);
            }
            if (Dimina.isInit()) {
                Dimina4DiContainerActivity.open(this.mContext, this.mRouteConfig);
                return;
            }
            throw new IllegalArgumentException("未初始化 请先执行Dimina.init");
        }
    }
}

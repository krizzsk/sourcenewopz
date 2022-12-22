package com.didi.dimina.container;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bridge.permission.DMPermissionDescConfig;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.debug.DevModeManager;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.jsengine.web.WebSystemJSEngine;
import com.didi.dimina.container.mina.DMMemoryManager;
import com.didi.dimina.container.monitor.DiminaMonitorSwitchConfig;
import com.didi.dimina.container.p106ui.launchview.DMBaseLaunchView;
import com.didi.dimina.container.p106ui.launchview.DMDefaultLaunchView;
import com.didi.dimina.container.p106ui.loadpage.DMBaseLoadingView;
import com.didi.dimina.container.p106ui.loadpage.DMCommonLoadingView;
import com.didi.dimina.container.p106ui.loadpage.DMDefaultLoadingView;
import com.didi.dimina.container.p106ui.loadpage.DMNoTitleLoadingView;
import com.didi.dimina.container.p106ui.refresh.AbsOverView;
import com.didi.dimina.container.p106ui.refresh.TextOverView;
import com.didi.dimina.container.p106ui.subpackage.DMSubPackageLoadingView;
import com.didi.dimina.container.p106ui.tabbar.BottomTabBar;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.service.CapsuleButtonService;
import com.didi.dimina.container.service.FirstFetchService;
import com.didi.dimina.container.service.MapService;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.container.webengine.webview.DMGeneralWebView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class DMConfig {
    public static final String TAG = "DMConfig";

    /* renamed from: a */
    private final Context f16522a;
    protected AdapterConfig mAdapterConfig = new AdapterConfig();
    protected CallBackConfig mCbConfig = new CallBackConfig();
    protected ForceUpdateConfig mForceUpdateConfig = new ForceUpdateConfig();
    protected LaunchConfig mLaunchConfig = new LaunchConfig();
    protected UIConfig mUIConfig = new UIConfig();

    public interface EngineFactory {
        JSEngine createJSEngine();

        WebViewEngine createWebViewEngine(Activity activity);
    }

    public interface OnAppConfigJsonLoaded {
        void callback(JSAppConfig jSAppConfig, DMMina dMMina);
    }

    public interface OnBridgeCallbackListener {

        public enum FROM {
            WEB_VIEW,
            SERVICE
        }

        public enum TYPE {
            ASYNC,
            SYNC
        }

        void onBridgeCallback(FROM from, TYPE type, String str, String str2, Object obj, Object obj2);

        void onBridgeCalled(FROM from, String str, String str2, JSONObject jSONObject, Object obj);
    }

    public interface OnTabSelectInterceptor {
        void onInterceptor(int i, int i2, JSAppConfig.TabBar.Item item, BottomTabBar.onTabSelectInterceptorCallBack ontabselectinterceptorcallback);
    }

    public interface ReLaunchCallback {
        DMMina relaunch(DMMina dMMina);
    }

    public DMConfig(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f16522a = applicationContext;
        if (applicationContext != null) {
            applicationContext.registerComponentCallbacks(DMMemoryManager.getInstance());
        }
    }

    public boolean checkParam() {
        return !TextUtils.isEmpty(this.mLaunchConfig.getAppId()) && this.mLaunchConfig.getBundleManagerStrategy() != null;
    }

    public Context getContext() {
        return this.f16522a;
    }

    public LaunchConfig getLaunchConfig() {
        return this.mLaunchConfig;
    }

    public ForceUpdateConfig getForceUpdateConfig() {
        return this.mForceUpdateConfig;
    }

    public UIConfig getUIConfig() {
        return this.mUIConfig;
    }

    public AdapterConfig getAdapterConfig() {
        return this.mAdapterConfig;
    }

    public CallBackConfig getCallbackConfig() {
        return this.mCbConfig;
    }

    public static class ForceUpdateConfig {
        private String mForceUpdateAppVersion = "";
        private String mForceUpdateJSSDKVersion = "";
        private long mForceUpdateTimeout = 0;

        public long getForceUpdateTimeout() {
            return this.mForceUpdateTimeout;
        }

        public void setForceUpdateTimeout(Long l) {
            this.mForceUpdateTimeout = l.longValue();
        }

        public String getForceUpdateJSSDKVersion() {
            return this.mForceUpdateJSSDKVersion;
        }

        public void setForceUpdateJSSDKVersion(String str) {
            this.mForceUpdateJSSDKVersion = str;
        }

        public String getForceUpdateAppVersion() {
            return this.mForceUpdateAppVersion;
        }

        public void setForceUpdateAppVersion(String str) {
            this.mForceUpdateAppVersion = str;
        }
    }

    public static class CallBackConfig {
        private OnTabSelectInterceptor bottomBarSelectInterceptor;
        private OnBridgeCallbackListener mBridgeCallbackListener;
        private CapsuleButtonService mCapsuleButtonService = new CapsuleButtonService.DefaultCapsuleButtonServiceImpl();
        private ReLaunchCallback mRelaunchCallback;
        private OnAppConfigJsonLoaded onAppConfigJsonLoaded;

        CallBackConfig() {
        }

        public void setRelaunchCallback(ReLaunchCallback reLaunchCallback) {
            this.mRelaunchCallback = reLaunchCallback;
        }

        public ReLaunchCallback getRelaunchCallback() {
            return this.mRelaunchCallback;
        }

        public void setBottomBarSelectInterceptor(OnTabSelectInterceptor onTabSelectInterceptor) {
            this.bottomBarSelectInterceptor = onTabSelectInterceptor;
        }

        public OnTabSelectInterceptor getBottomBarSelectInterceptor() {
            return this.bottomBarSelectInterceptor;
        }

        public OnBridgeCallbackListener getBridgeCallbackListener() {
            return this.mBridgeCallbackListener;
        }

        public void setBridgeCallbackListener(OnBridgeCallbackListener onBridgeCallbackListener) {
            this.mBridgeCallbackListener = onBridgeCallbackListener;
        }

        public OnAppConfigJsonLoaded getOnAppConfigJsonLoaded() {
            return this.onAppConfigJsonLoaded;
        }

        public void setOnAppConfigJsonLoaded(OnAppConfigJsonLoaded onAppConfigJsonLoaded2) {
            this.onAppConfigJsonLoaded = onAppConfigJsonLoaded2;
        }

        public void setCapsuleButtonService(CapsuleButtonService capsuleButtonService) {
            this.mCapsuleButtonService = capsuleButtonService;
        }

        public CapsuleButtonService getCapsuleButtonService() {
            return this.mCapsuleButtonService;
        }
    }

    public static class AdapterConfig {
        private FirstFetchService mFirstFetchService;
        private MapService mMapService = new MapService.DefaultMapServiceImpl();

        public void setFirstFetchService(FirstFetchService firstFetchService) {
            this.mFirstFetchService = firstFetchService;
        }

        public FirstFetchService getFirstFetchService() {
            return this.mFirstFetchService;
        }

        public void setMapService(MapService mapService) {
            this.mMapService = mapService;
        }

        public MapService getMapService() {
            return this.mMapService;
        }
    }

    public class LaunchConfig {
        private BlankScreenConfig checkScreenBlankConfig = new BlankScreenConfig();
        private String mAppId;
        private boolean mBindActivityLifecycle = true;
        private BundleManagerStrategy mBundleManagerStrategy;
        private JSONObject mCameraComponentConfig = new JSONObject();
        private DevModeManager mDevModeManager;
        private EngineFactory mEngineFactory = new EngineFactory() {
            public WebViewEngine createWebViewEngine(Activity activity) {
                return new DMGeneralWebView(activity);
            }

            public JSEngine createJSEngine() {
                return new WebSystemJSEngine();
            }
        };
        private String mEntryPath;
        private JSONObject mExtraOptions = new JSONObject();
        private String mExtraUA = "";
        private boolean mForceRelease = false;
        private String mIDEDebugUrl;
        private boolean mIsUseReLaunch = false;
        private final int mLaunchType = 1;
        private DiminaMonitorSwitchConfig mMonitorLogConfig = new DiminaMonitorSwitchConfig();
        private WebViewEngine.OnWebViewLoadListener mOnWebViewLoadListener;
        private long mReLaunchTimeDiff = 30000;
        private JSONObject mSameRenderLayerComponentConfig = new JSONObject();
        private int mScene = 1000;
        private SnapshotConfig mSnapshotConfig = new SnapshotConfig();
        @Deprecated
        private int maxPageSize = 9999;

        @Deprecated
        public LaunchConfig setMaxPageSize(int i) {
            return this;
        }

        public JSONObject getSameRenderLayerComponentConfig() {
            return this.mSameRenderLayerComponentConfig;
        }

        public void setSameRenderLayerComponentConfig(JSONObject jSONObject) {
            this.mSameRenderLayerComponentConfig = jSONObject;
        }

        public JSONObject getCameraComponentConfig() {
            return this.mCameraComponentConfig;
        }

        public void setCameraComponentConfig(JSONObject jSONObject) {
            this.mCameraComponentConfig = jSONObject;
        }

        protected LaunchConfig() {
        }

        public String getAppId() {
            return this.mAppId;
        }

        public boolean isBindActivityLifecycle() {
            return this.mBindActivityLifecycle;
        }

        public void setBindActivityLifecycle(boolean z) {
            this.mBindActivityLifecycle = z;
        }

        public void setAppId(String str) {
            this.mAppId = str;
            this.mDevModeManager = new DevModeManager(str);
        }

        public EngineFactory getEngineFactory() {
            return this.mEngineFactory;
        }

        public void setEngineFactory(EngineFactory engineFactory) {
            this.mEngineFactory = engineFactory;
        }

        public LaunchConfig setExtraOptions(JSONObject jSONObject) {
            this.mExtraOptions = jSONObject;
            return this;
        }

        public String getIDEDebugUrl() {
            return this.mIDEDebugUrl;
        }

        public void setIDEDebugUrl(String str) {
            this.mIDEDebugUrl = str;
        }

        public JSONObject getExtraOptions() {
            return this.mExtraOptions;
        }

        public boolean isForceRelease() {
            return this.mForceRelease;
        }

        public LaunchConfig setForceRelease(boolean z) {
            this.mForceRelease = z;
            return this;
        }

        public String getEntryPath() {
            return this.mEntryPath;
        }

        public LaunchConfig setEntryPath(String str) {
            this.mEntryPath = str;
            return this;
        }

        public int getScene() {
            return this.mScene;
        }

        public LaunchConfig setScene(int i) {
            this.mScene = i;
            return this;
        }

        public LaunchConfig setBundleManagerStrategy(BundleManagerStrategy bundleManagerStrategy) {
            this.mBundleManagerStrategy = bundleManagerStrategy;
            return this;
        }

        @Deprecated
        public int getMaxPageSize() {
            return this.maxPageSize;
        }

        public String getExtraUA() {
            return this.mExtraUA;
        }

        public void setExtraUA(String str) {
            this.mExtraUA = str;
        }

        public void setCheckBlankScreenConfig(BlankScreenConfig blankScreenConfig) {
            this.checkScreenBlankConfig = blankScreenConfig;
        }

        public BlankScreenConfig getCheckScreenBlankConfig() {
            return this.checkScreenBlankConfig;
        }

        public boolean isIsUseReLaunch() {
            return this.mIsUseReLaunch;
        }

        public void setIsUseReLaunch(boolean z) {
            this.mIsUseReLaunch = z;
        }

        public long getReLaunchTimeDiff() {
            return this.mReLaunchTimeDiff;
        }

        public void setReLaunchTimeDiff(long j) {
            this.mReLaunchTimeDiff = j;
        }

        public BundleManagerStrategy getBundleManagerStrategy() {
            return this.mDevModeManager.getBundleManagerStrategy(this.mBundleManagerStrategy);
        }

        public WebViewEngine.OnWebViewLoadListener getOnWebViewLoadListener() {
            return this.mOnWebViewLoadListener;
        }

        public void setOnWebViewLoadListener(WebViewEngine.OnWebViewLoadListener onWebViewLoadListener) {
            this.mOnWebViewLoadListener = onWebViewLoadListener;
        }

        public SnapshotConfig getSnapshotConfig() {
            return this.mSnapshotConfig;
        }

        public void setSnapshotConfig(SnapshotConfig snapshotConfig) {
            this.mSnapshotConfig = snapshotConfig;
        }

        public DiminaMonitorSwitchConfig getMonitorLogConfig() {
            return this.mMonitorLogConfig;
        }

        public void setMonitorLogConfig(DiminaMonitorSwitchConfig diminaMonitorSwitchConfig) {
            this.mMonitorLogConfig = diminaMonitorSwitchConfig;
        }
    }

    public static class UIConfig {
        private boolean hasCapsuleButton = false;
        private boolean mCanSwipeBack = true;
        private Class<? extends DMCommonLoadingView> mCommonLoadingViewClazz;
        private Class<? extends DMBaseLaunchView> mLaunchViewClass = DMDefaultLaunchView.class;
        private Class<? extends DMNoTitleLoadingView> mNoTitleLoadingViewClazz;
        private Class<? extends DMBaseLoadingView> mPageLoadingViewClass = DMDefaultLoadingView.class;
        private DMPermissionDescConfig mPermissionDescConfig;
        private int mProgressBarColor = -224941;
        private Class<? extends AbsOverView> mRefreshOverViewClass = TextOverView.class;
        private Class<? extends DMSubPackageLoadingView> mSubPackageLoadingViewClazz;

        public Class<? extends DMSubPackageLoadingView> getSubPackageLoadingViewClazz() {
            return this.mSubPackageLoadingViewClazz;
        }

        public UIConfig setSubPackageLoadingViewClazz(Class<? extends DMSubPackageLoadingView> cls) {
            this.mSubPackageLoadingViewClazz = cls;
            return this;
        }

        public Class<? extends DMNoTitleLoadingView> getNoTitleLoadingViewClazz() {
            return this.mNoTitleLoadingViewClazz;
        }

        public UIConfig setNoTitleLoadingViewClazz(Class<? extends DMNoTitleLoadingView> cls) {
            this.mNoTitleLoadingViewClazz = cls;
            return this;
        }

        public Class<? extends DMCommonLoadingView> getCommonLoadingViewClazz() {
            return this.mCommonLoadingViewClazz;
        }

        public UIConfig setCommonLoadingViewClazz(Class<? extends DMCommonLoadingView> cls) {
            this.mCommonLoadingViewClazz = cls;
            return this;
        }

        public Class<? extends AbsOverView> getRefreshOverViewClass() {
            return this.mRefreshOverViewClass;
        }

        public UIConfig setRefreshOverViewClass(Class<? extends AbsOverView> cls) {
            this.mRefreshOverViewClass = cls;
            return this;
        }

        public UIConfig setLaunchView(Class<? extends DMBaseLaunchView> cls) {
            this.mLaunchViewClass = cls;
            return this;
        }

        public Class<? extends DMBaseLaunchView> getLaunchViewClazz() {
            return this.mLaunchViewClass;
        }

        public Class<? extends DMBaseLoadingView> getPageLoadingViewClass() {
            return this.mPageLoadingViewClass;
        }

        public UIConfig setPageLoadingViewClass(Class<? extends DMBaseLoadingView> cls) {
            this.mPageLoadingViewClass = cls;
            return this;
        }

        public boolean hasCapsuleButton() {
            return this.hasCapsuleButton;
        }

        public UIConfig setHasCapsuleButton(boolean z) {
            this.hasCapsuleButton = z;
            return this;
        }

        public DMPermissionDescConfig getPermissionDescConfig() {
            return this.mPermissionDescConfig;
        }

        public void setPermissionDescConfig(DMPermissionDescConfig dMPermissionDescConfig) {
            this.mPermissionDescConfig = dMPermissionDescConfig;
        }

        public boolean canSwipeBack() {
            return this.mCanSwipeBack;
        }

        public void setCanSwipeBack(boolean z) {
            this.mCanSwipeBack = z;
        }

        public int getProgressBarColor() {
            return this.mProgressBarColor;
        }

        public void setProgressBarColor(int i) {
            this.mProgressBarColor = i;
        }
    }

    public static class SnapshotConfig {
        private boolean hasUsedSnapshot = false;
        private boolean isSnapshotAllow = false;
        private long mSnapshotDurationTime = 5000;
        private int mSnapshotFirstTimeInterval = 200;
        private int mSnapshotMaxTimes = 3;
        private int mSnapshotTimeInterval = 1000;

        public boolean getSnapshotAllow() {
            return this.isSnapshotAllow;
        }

        public void setSnapshotAllow(boolean z) {
            this.isSnapshotAllow = z;
        }

        public long getSnapshotDurationTime() {
            return this.mSnapshotDurationTime;
        }

        public void setSnapshotDurationTime(long j) {
            this.mSnapshotDurationTime = j;
        }

        public boolean getHasUsedSnapshot() {
            return this.hasUsedSnapshot;
        }

        public void setHasUsedSnapshot(boolean z) {
            this.hasUsedSnapshot = z;
        }

        public int getSnapshotMaxTimes() {
            return this.mSnapshotMaxTimes;
        }

        public void setSnapshotMaxTimes(int i) {
            this.mSnapshotMaxTimes = i;
        }

        public int getSnapshotTimeInterval() {
            return this.mSnapshotTimeInterval;
        }

        public void setSnapshotTimeInterval(int i) {
            this.mSnapshotTimeInterval = i;
        }

        public int getSnapshotFirstTimeInterval() {
            return this.mSnapshotFirstTimeInterval;
        }

        public void setSnapshotFirstTimeInterval(int i) {
            this.mSnapshotFirstTimeInterval = i;
        }
    }

    public static class BlankScreenConfig {
        private OnCheckBlankListener mBlankListener;
        @Deprecated
        private int mHCount = 0;
        private double mHorizontalRate = 0.0d;
        private List<String> mIgnoreH5UrlConfig;
        private List<String> mIgnorePath;
        private OnCheckBlankInWhiteListener mIsInWhiteListListener;
        private double mRate = 1.0d;
        private String mSkeletonCommonId;
        private List<String> mSkeletonPathConfig;
        private ArrayList<Long> mStrategy;
        @Deprecated
        private int mVCount = 0;
        private double mVerticalRate = 0.0d;

        public interface OnCheckBlankInWhiteListener {
            boolean checkBlankInWhiteCallback(String str);
        }

        public interface OnCheckBlankListener {
            void checkBlankListener(DMMina dMMina, DMPage dMPage, Map<String, String> map);
        }

        public ArrayList<Long> getStrategy() {
            return this.mStrategy;
        }

        public void setStrategy(ArrayList<Long> arrayList) {
            this.mStrategy = arrayList;
        }

        @Deprecated
        public int getVCount() {
            return this.mVCount;
        }

        @Deprecated
        public void setVCount(int i) {
            this.mVCount = i;
        }

        @Deprecated
        public int getHCount() {
            return this.mHCount;
        }

        @Deprecated
        public void setHCount(int i) {
            this.mHCount = i;
        }

        public double getRate() {
            return this.mRate;
        }

        public void setRate(double d) {
            if (d > 1.0d) {
                LogUtil.eRelease(DMConfig.TAG, "白屏检测 rate配置" + d + ">1, 配置非法不生效");
                return;
            }
            this.mRate = d;
        }

        public List<String> getSkeletonPathConfig() {
            return this.mSkeletonPathConfig;
        }

        public void setSkeletonPathConfig(List<String> list) {
            this.mSkeletonPathConfig = list;
        }

        public String getSkeletonCommonId() {
            return this.mSkeletonCommonId;
        }

        public void setSkeletonCommonId(String str) {
            this.mSkeletonCommonId = str;
        }

        public List<String> getIgnorePath() {
            return this.mIgnorePath;
        }

        public void setIgnorePath(List<String> list) {
            this.mIgnorePath = list;
        }

        public List<String> getIgnoreH5UrlConfig() {
            return this.mIgnoreH5UrlConfig;
        }

        public void setIgnoreH5UrlConfig(List<String> list) {
            this.mIgnoreH5UrlConfig = list;
        }

        public OnCheckBlankInWhiteListener getIsInWhiteListListener() {
            return this.mIsInWhiteListListener;
        }

        public void setIsInWhiteListListener(OnCheckBlankInWhiteListener onCheckBlankInWhiteListener) {
            this.mIsInWhiteListListener = onCheckBlankInWhiteListener;
        }

        public OnCheckBlankListener getBlankListener() {
            return this.mBlankListener;
        }

        public void setBlankListener(OnCheckBlankListener onCheckBlankListener) {
            this.mBlankListener = onCheckBlankListener;
        }

        public double getHorizontalRate() {
            return this.mHorizontalRate;
        }

        public void setHorizontalRate(double d) {
            if (d >= 1.0d || d <= 0.0d) {
                LogUtil.eRelease(DMConfig.TAG, "白屏检测 horizontalRate配置 非法，不生效");
            } else {
                this.mHorizontalRate = d;
            }
        }

        public double getVerticalRate() {
            return this.mVerticalRate;
        }

        public void setVerticalRate(double d) {
            if (d >= 1.0d || d <= 0.0d) {
                LogUtil.eRelease(DMConfig.TAG, "白屏检测 verticalRate 配置 非法，不生效");
            } else {
                this.mVerticalRate = d;
            }
        }

        public String toString() {
            return "BlankScreenConfig{mStrategy=" + this.mStrategy + ", mVCount=" + this.mVCount + ", mHCount=" + this.mHCount + ", mRate=" + this.mRate + ", mSkeletonPathConfig=" + this.mSkeletonPathConfig + ", mIgnorePath=" + this.mIgnorePath + ", mIgnoreH5UrlConfig=" + this.mIgnoreH5UrlConfig + ", mSkeletonCommonId='" + this.mSkeletonCommonId + ", mIsInWhiteListListener=" + this.mIsInWhiteListListener + ", mHorizontalRate=" + this.mHorizontalRate + ", mVerticalRate=" + this.mVerticalRate + ", mBlankListener=" + this.mBlankListener + '}';
        }
    }
}

package com.didi.dimina.container.secondparty;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.jsengine.DiminaEngine;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.secondparty.imghook.ImgLoadHooker;
import com.didi.dimina.container.secondparty.prefetch.FirstTogetherManager;
import com.didi.dimina.container.secondparty.util.ApolloUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.webview.dmwebview.DMWebView;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.util.ArrayList;
import java.util.List;

public class DMConfig4Di extends DMConfig {
    public DMConfig4Di(Context context) {
        super(context);
        this.mAdapterConfig = new AdapterConfig();
        this.mLaunchConfig = new LaunchConfig();
    }

    public LaunchConfig getLaunchConfig() {
        return (LaunchConfig) this.mLaunchConfig;
    }

    public AdapterConfig getAdapterConfig() {
        return (AdapterConfig) this.mAdapterConfig;
    }

    public static class AdapterConfig extends DMConfig.AdapterConfig {
        public AdapterConfig() {
            setFirstFetchService(new FirstTogetherManager());
        }
    }

    public class LaunchConfig extends DMConfig.LaunchConfig {
        private String mBundleManagerBusinessParams;
        private boolean mIsLogServerOn = true;
        private boolean mOpenMasCrossPlatformMonitor;
        private String mRavenId = "1391";

        public LaunchConfig() {
            super();
            setIsUseReLaunch("1".equals(ApolloUtil.getApolloValue("dimina_memory_relaunch_config", "use_config", "0")));
            try {
                setReLaunchTimeDiff((long) (Integer.parseInt((String) ApolloUtil.getApolloValue("dimina_memory_relaunch_config", "reset_time_diff", DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_PHOTO_DEMO_CHECK)) * 1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            DMConfig.SnapshotConfig snapshotConfig = new DMConfig.SnapshotConfig();
            snapshotConfig.setSnapshotAllow(ApolloUtil.getApolloAllow("dimina_cxyx_snapshot_allow"));
            snapshotConfig.setSnapshotDurationTime((long) ((Integer) ApolloUtil.getApolloValue("dimina_cxyx_snapshot_allow", "durationTime", 5000)).intValue());
            snapshotConfig.setSnapshotMaxTimes(((Integer) ApolloUtil.getApolloValue("dimina_cxyx_snapshot_allow", "maxTimes", 3)).intValue());
            snapshotConfig.setSnapshotTimeInterval(((Integer) ApolloUtil.getApolloValue("dimina_cxyx_snapshot_allow", "timeInterval", 1000)).intValue());
            snapshotConfig.setSnapshotFirstTimeInterval(((Integer) ApolloUtil.getApolloValue("dimina_cxyx_snapshot_allow", "firstTimeInterval", 200)).intValue());
            setSnapshotConfig(snapshotConfig);
            setEngineFactory(new DMConfig.EngineFactory(DMConfig4Di.this) {
                public WebViewEngine createWebViewEngine(Activity activity) {
                    return new DMWebView(activity);
                }

                public JSEngine createJSEngine() {
                    return new DiminaEngine();
                }
            });
            setOnWebViewLoadListener(new WebViewEngine.OnWebViewLoadListener(DMConfig4Di.this) {
                public void onPageFinished(WebViewEngine webViewEngine, String str) {
                }

                public void onReceivedError(WebViewEngine webViewEngine, String str) {
                }

                public Boolean shouldOverrideUrlLoading(WebViewEngine webViewEngine, String str) {
                    return null;
                }

                public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, String str, String str2) {
                    return ImgLoadHooker.getIns(Dimina4Di.getConfig().getApp()).shouldInterceptRequest(webViewEngine, str, str2);
                }

                public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, WebResourceRequest webResourceRequest, String str) {
                    return ImgLoadHooker.getIns(Dimina4Di.getConfig().getApp()).shouldInterceptRequest(webViewEngine, webResourceRequest, str);
                }
            });
            setOpenMasCrossPlatformMonitor(ApolloUtil.getApolloAllow("dimina_cxyx_open_mas_cross_platform_monitor"));
            if (((Integer) ApolloUtil.getApolloValue("dimina_saga_system_config", "dataStatistic_disable", 0)).intValue() == 1) {
                setLogServerOn(false);
            }
            if (ApolloUtil.getApolloAllow("dimina_samelayer_component_control")) {
                setSameRenderLayerComponentConfig(Apollo.getToggle("dimina_samelayer_component_control").getExperiment().toJsonObject().optJSONObject("params"));
            }
            if (ApolloUtil.getApolloAllow("dimina_camera_component_control")) {
                setCameraComponentConfig(Apollo.getToggle("dimina_camera_component_control").getExperiment().toJsonObject().optJSONObject("params"));
            }
            blankScreenCheckConfig();
        }

        private void blankScreenCheckConfig() {
            String[] split = ((String) ApolloUtil.getApolloValue("cxyx_saga_check_blank_screen", "check_policy", "2,1,3")).split(",");
            ArrayList arrayList = new ArrayList();
            try {
                for (String parseLong : split) {
                    arrayList.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            } catch (Exception e) {
                LogUtil.eRelease(DMConfig.TAG, "转化发生异常:" + Log.getStackTraceString(e));
                e.printStackTrace();
            }
            if (arrayList.isEmpty()) {
                arrayList.add(2L);
                arrayList.add(1L);
                arrayList.add(3L);
            }
            getCheckScreenBlankConfig().setStrategy(arrayList);
            getCheckScreenBlankConfig().setRate(((Double) ApolloUtil.getApolloValue("cxyx_saga_check_blank_screen", "sample_rate", Double.valueOf(0.9d))).doubleValue());
            getCheckScreenBlankConfig().setSkeletonPathConfig((List) ApolloUtil.getApolloValue("cxyx_saga_check_blank_screen", "skeleton_path_config", new ArrayList()));
            getCheckScreenBlankConfig().setVCount(((Integer) ApolloUtil.getApolloValue("cxyx_saga_check_blank_screen", "vertical_count", 60)).intValue());
            getCheckScreenBlankConfig().setHCount(((Integer) ApolloUtil.getApolloValue("cxyx_saga_check_blank_screen", "horizontal_count", 30)).intValue());
            getCheckScreenBlankConfig().setHorizontalRate(((Double) ApolloUtil.getApolloValue("cxyx_saga_check_blank_screen", "horizontal_rate", Double.valueOf(0.1d))).doubleValue());
            getCheckScreenBlankConfig().setVerticalRate(((Double) ApolloUtil.getApolloValue("cxyx_saga_check_blank_screen", "vertical_rate", Double.valueOf(0.1d))).doubleValue());
        }

        public void setAppId(String str) {
            super.setAppId(str);
        }

        public boolean isOpenMasCrossPlatformMonitor() {
            return this.mOpenMasCrossPlatformMonitor;
        }

        public void setOpenMasCrossPlatformMonitor(boolean z) {
            this.mOpenMasCrossPlatformMonitor = z;
        }

        public boolean isLogServerOn() {
            return this.mIsLogServerOn;
        }

        public void setLogServerOn(boolean z) {
            this.mIsLogServerOn = z;
        }

        public String getRavenId() {
            return this.mRavenId;
        }

        public void setRavenId(String str) {
            this.mRavenId = str;
        }

        public String getBundleManagerBusinessParams() {
            return this.mBundleManagerBusinessParams;
        }

        public void setBundleManagerBusinessParams(String str) {
            this.mBundleManagerBusinessParams = str;
        }
    }
}

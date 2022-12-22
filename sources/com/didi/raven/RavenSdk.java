package com.didi.raven;

import android.content.Context;
import android.text.TextUtils;
import com.didi.raven.cache.RavenData;
import com.didi.raven.config.RavenConstants;
import com.didi.raven.manger.RavenPoolManger;
import com.didi.raven.model.RavenPoolConfigModel;
import com.didi.raven.net.RavenNetManger;
import com.didi.raven.utils.DeviceUtils;
import com.didi.raven.utils.RavenUtils;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.tencent.mmkv.MMKV;
import java.util.List;
import java.util.Map;

public class RavenSdk {
    private static final String TAG = "RavenSdk";
    private boolean ravenSwitch = false;

    public String getVersion() {
        return RavenConstants.SDK_VERSION;
    }

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static final RavenSdk INSTANCE = new RavenSdk();

        private SingleTon() {
        }
    }

    public static RavenSdk getInstance() {
        return SingleTon.INSTANCE;
    }

    public static boolean isInit() {
        RavenNetManger netManger = RavenHttpManger.getInstance().getNetManger();
        if (netManger == null) {
            return false;
        }
        return netManger.isInit();
    }

    public static void init(Context context) {
        try {
            MMKV.initialize(context);
            DeviceUtils.init(context);
            RavenDataManger.getInstance().init();
            getInstance().initApollo();
            RavenHttpManger.getInstance().mo87141a(context);
            RavenPoolManger.getInstance().start();
            RavenDataManger.getInstance().uploadLastData();
        } catch (Exception e) {
            LoggerFactory.getLogger(RavenConstants.TAG).error("init failed", (Throwable) e);
        }
    }

    private void initApollo() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("raven_switch");
        if (toggle != null && toggle.allow()) {
            this.ravenSwitch = true;
        }
        IToggle toggle2 = Apollo.getToggle("raven_upload_strategy");
        if (toggle2 != null && toggle2.allow() && (experiment = toggle2.getExperiment()) != null) {
            getPoolConfig().setMax(((Integer) experiment.getParam("raven_upload_max_cache_count", 300)).intValue());
            getPoolConfig().setCacheMax(((Integer) experiment.getParam("raven_upload_max_cache_size", 2048)).intValue());
            getPoolConfig().setPostMax(((Integer) experiment.getParam("raven_upload_batch_size", 20)).intValue());
            getPoolConfig().setCount(((Integer) experiment.getParam("raven_upload_batch_count", 10)).intValue());
            getPoolConfig().setDelay(((long) ((Integer) experiment.getParam("raven_upload_timeinterval", 30)).intValue()) * 1000);
        }
    }

    private RavenData getRavenData(String str) {
        return RavenDataManger.getInstance().getRavenData(str);
    }

    private RavenPoolConfigModel getPoolConfig() {
        return RavenDataManger.getInstance().getPoolConfig();
    }

    public boolean getSwitch() {
        return this.ravenSwitch;
    }

    public void setPath(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                getRavenData(str).setBaseUrl(str2);
            } catch (Exception e) {
                LoggerFactory.getLogger(RavenConstants.TAG).error("setPath failed", (Throwable) e);
            }
        }
    }

    public void trackEvent(String str, String str2, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                RavenUtils.removeNullData(map);
                RavenHttpManger.getInstance().mo87144a(str, str2, map);
            } catch (Exception e) {
                LoggerFactory.getLogger(RavenConstants.TAG).error("trackEvent failed", (Throwable) e);
            }
        }
    }

    public void trackRequest(String str, String str2, String str3, Object obj, Object obj2, long j, long j2, int i) {
        trackRequest(str, str2, str3, obj, obj2, j, j2, i, (Map<String, Object>) null);
    }

    public void trackRequest(String str, String str2, String str3, Object obj, Object obj2, long j, long j2, int i, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                RavenHttpManger.getInstance().mo87143a(str, str2, str3, j, j2, obj, obj2, i, map);
            } catch (Exception e) {
                LoggerFactory.getLogger(RavenConstants.TAG).error("trackRequest failed", (Throwable) e);
            }
        }
    }

    public void trackError(String str, Throwable th) {
        String[] throwableToStrings = RavenUtils.getThrowableToStrings(th);
        trackError(str, throwableToStrings[0], throwableToStrings[1], throwableToStrings[2], (Map<String, Object>) null);
    }

    public void trackError(String str, Throwable th, Map<String, Object> map) {
        String[] throwableToStrings = RavenUtils.getThrowableToStrings(th);
        trackError(str, throwableToStrings[0], throwableToStrings[1], throwableToStrings[2], map);
    }

    public void trackError(String str, String str2, Throwable th) {
        String[] throwableToStrings = RavenUtils.getThrowableToStrings(th);
        trackError(str, str2, throwableToStrings[1], throwableToStrings[2], (Map<String, Object>) null);
    }

    public void trackError(String str, String str2, Throwable th, Map<String, Object> map) {
        String[] throwableToStrings = RavenUtils.getThrowableToStrings(th);
        trackError(str, str2, throwableToStrings[1], throwableToStrings[2], map);
    }

    public void trackError(String str, String str2, Map<String, Object> map) {
        trackError(str, str2, "", "", map);
    }

    public void trackError(String str, String str2, String str3) {
        trackError(str, str2, str3, "", (Map<String, Object>) null);
    }

    public void trackError(String str, String str2, String str3, Map<String, Object> map) {
        trackError(str, str2, str3, "", map);
    }

    public void trackError(String str, String str2, String str3, String str4) {
        trackError(str, str2, str3, str4, (Map<String, Object>) null);
    }

    public void trackError(String str, String str2, String str3, String str4, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                RavenUtils.removeNullData(map);
                RavenHttpManger.getInstance().mo87145a(str, map, str2, str3, str4);
            } catch (Exception e) {
                LoggerFactory.getLogger(RavenConstants.TAG).error("trackError failed", (Throwable) e);
            }
        }
    }

    private void trackPool(List<Map<String, Object>> list) {
        try {
            RavenHttpManger.getInstance().trackPool(list);
        } catch (Exception e) {
            LoggerFactory.getLogger(RavenConstants.TAG).error("trackPool failed", (Throwable) e);
        }
    }

    @Deprecated
    public void clearPool(String str) {
        clearPool();
    }

    public void clearPool() {
        trackPool(RavenDataManger.getInstance().getParams());
        RavenDataManger.getInstance().clearPool();
    }

    private void trackTime(String str, String str2, long j, long j2, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                RavenUtils.removeNullData(map);
                RavenHttpManger.getInstance().mo87142a(str, str2, j, j2, map);
            } catch (Exception e) {
                LoggerFactory.getLogger(RavenConstants.TAG).error("trackTime failed", (Throwable) e);
            }
        }
    }

    public void setAttrs(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            try {
                RavenUtils.removeNullData(map);
                getRavenData(str).getAttrs().clear();
                getRavenData(str).getAttrs().putAll(map);
            } catch (Exception e) {
                LoggerFactory.getLogger(RavenConstants.TAG).error("setAttrs failed", (Throwable) e);
            }
        }
    }

    public void addAttrs(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            try {
                RavenUtils.removeNullData(map);
                getRavenData(str).getAttrs().putAll(map);
            } catch (Exception e) {
                LoggerFactory.getLogger(RavenConstants.TAG).error("addAttrs failed", (Throwable) e);
            }
        }
    }

    public Map<String, Object> getAttrs(String str) {
        return getRavenData(str).getAttrs();
    }

    public void setConfig(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                RavenUtils.removeNullData(map);
                if (map != null) {
                    for (String next : map.keySet()) {
                        if (map.get(next) != null) {
                            getRavenData(str).getConfig().put(next, map.get(next));
                        }
                    }
                }
                if (configNotHasAppId(str)) {
                    getRavenData(str).getConfig().put("aid", str);
                }
            } catch (Exception e) {
                LoggerFactory.getLogger(RavenConstants.TAG).error("setConfig failed", (Throwable) e);
            }
        }
    }

    private boolean configNotHasAppId(String str) {
        Map<String, Object> config = getRavenData(str).getConfig();
        return !config.containsKey("aid") || ((config.get("aid") instanceof String) && TextUtils.isEmpty(String.valueOf(config.get("aid"))));
    }

    public Map<String, Object> getConfig(String str) {
        return getRavenData(str).getConfig();
    }

    public void stopPool() {
        RavenPoolManger.getInstance().stop();
    }
}

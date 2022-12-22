package com.didi.hawaii.basic;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.dmap.apollo.ApolloDelegate;

public class ApolloHawaii {
    private static final String APOLLO_HAWAII_IS_USE_TEST_URL = "apollo_hawaii_is_use_test_url";
    private static final String APOLLO_HAWAII_LOG_SDK_SELECT = "apollo_hawaii_log_sdk_select";
    private static final String HAWAII_ANDROID_NAVI_PRELOAD = "hawaii_android_navi_preload";
    private static final String HAWAII_ANDROID_THREAD_POOL_EXECUTOR_DISABLE = "hawaii_android_thread_pool_executor_disable";
    private static final String HAWAII_ANDROID_USE_ONE_LOGGER = "hawaii_android_use_one_logger";
    private static final String HAWAII_NAVI_IS_DEL_OLD_LOG = "hawaii_navi_is_del_old_log";
    private static final String HAWAII_SDK_REQUEST_FREQ_MONITOR = "hawaii_sdk_request_freq_monitor";
    private static final ApolloDelegate apolloDelegate = new ApolloDelegate();
    private static final boolean isNewLogSDK = newLogSDK();

    public static boolean useNewLogSDK() {
        return isNewLogSDK;
    }

    public static boolean isUseTestUrl() {
        return Apollo.getToggle(APOLLO_HAWAII_IS_USE_TEST_URL).allow();
    }

    public static boolean isUseOneLogger() {
        return Apollo.getToggle(HAWAII_ANDROID_USE_ONE_LOGGER).allow();
    }

    public static boolean isDelOldLogFile() {
        return Apollo.getToggle(HAWAII_NAVI_IS_DEL_OLD_LOG).allow();
    }

    public static boolean getReportRequestLimitEnable() {
        return apolloDelegate.getToggleCache(HAWAII_SDK_REQUEST_FREQ_MONITOR).allow();
    }

    public static int getReportRequestLimitCount() {
        IToggle toggleCache = apolloDelegate.getToggleCache(HAWAII_SDK_REQUEST_FREQ_MONITOR);
        if (toggleCache.allow()) {
            toggleCache.getExperiment().getParam("limit", 10);
        }
        return 10;
    }

    public static int getReportRequestTime() {
        IToggle toggleCache = apolloDelegate.getToggleCache(HAWAII_SDK_REQUEST_FREQ_MONITOR);
        if (toggleCache.allow()) {
            toggleCache.getExperiment().getParam("window", 60);
        }
        return 60;
    }

    public static boolean getThreadPoolExecutorDisable() {
        return apolloDelegate.getToggleCache(HAWAII_ANDROID_THREAD_POOL_EXECUTOR_DISABLE).allow();
    }

    public static boolean shutDownPreLoad() {
        return Apollo.getToggle(HAWAII_ANDROID_NAVI_PRELOAD).allow();
    }

    private static boolean newLogSDK() {
        return Apollo.getToggle(APOLLO_HAWAII_LOG_SDK_SELECT).allow();
    }
}

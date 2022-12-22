package com.didi.trackupload.sdk.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtils {
    public static String getApolloTestValue() {
        IToggle toggle = Apollo.getToggle("snser_apollo_toggle_share_test");
        if (toggle == null || !toggle.allow()) {
            return null;
        }
        return (String) toggle.getExperiment().getParam("value_os_type", "null");
    }

    public static boolean isTrackSDKAllowedPassenger() {
        IToggle toggle = Apollo.getToggle("isOpenDMTrackManager");
        return toggle != null && toggle.allow() && "1".equals(toggle.getExperiment().getParam("isOpen_android", "0"));
    }

    public static boolean isPushSDKUseNewPush() {
        IToggle toggle = Apollo.getToggle("new_push_switcher");
        return toggle != null && toggle.allow();
    }

    public static int getOmegaUpoadResultSampleRate() {
        int intValue;
        IToggle toggle = Apollo.getToggle("tracksdk_allow_omega_upload");
        if (toggle == null || !toggle.allow() || (intValue = ((Integer) toggle.getExperiment().getParam("sample_rate", 0)).intValue()) <= 0 || intValue > 1000) {
            return 0;
        }
        return intValue;
    }

    public static long[] requestRecoverUploadParams() {
        long[] jArr = {1000, 30000};
        IToggle toggle = Apollo.getToggle("tracksdk_recover_upload_params");
        if (toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            jArr[0] = ((Long) experiment.getParam("start_delay", 1000L)).longValue();
            jArr[1] = ((Long) experiment.getParam("retry_interval", 30000L)).longValue();
        }
        return jArr;
    }

    public static long[] requestUploadIntervalParams() {
        IToggle toggle = Apollo.getToggle("tracksdk_upload_interval_params");
        if (!toggle.allow()) {
            return null;
        }
        IExperiment experiment = toggle.getExperiment();
        return new long[]{(long) ((Integer) experiment.getParam("upload_interval_high_frequency_value", 3000)).intValue(), (long) ((Integer) experiment.getParam("upload_interval_normal_value", 9000)).intValue(), (long) ((Integer) experiment.getParam("upload_interval_low_frequency_value", 36000)).intValue(), (long) ((Integer) experiment.getParam("upload_interval_battery_save_value", 72000)).intValue()};
    }

    public static int requestCountPerPatchParam() {
        IToggle toggle = Apollo.getToggle("tracksdk_count_per_patch_param");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("count_per_patch", 500)).intValue();
        }
        return 500;
    }

    public static boolean isAllowHttpUpload() {
        return Apollo.getToggle("tracksdk_allow_http_upload").allow();
    }

    public static boolean isAllowSubtitudeLoc() {
        return Apollo.getToggle("tracksdk_allow_subtitude_loc").allow();
    }

    public static boolean usePathLogger() {
        return Apollo.getToggle("tracksdk_use_path_logger").allow();
    }
}

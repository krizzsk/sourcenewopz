package com.didi.map.global.component.bluetooth.apollo;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.diface.logger.DiFaceLogger;

public class BluetoothApolloUtil {
    public static ApolloParamRssi2Distance getApolloParamRssi2Distance() {
        ApolloParamRssi2Distance apolloParamRssi2Distance = new ApolloParamRssi2Distance();
        apolloParamRssi2Distance.A_Value = 59.0d;
        apolloParamRssi2Distance.n_Value = 2.0d;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_parameter");
        if (toggle.allow()) {
            String str = (String) toggle.getExperiment().getParam("rssi2distance_A_param", DiFaceLogger.EVENT_ID_COMPARE_FAILED_EXIT_CLICKED);
            if (!TextUtils.isEmpty(str)) {
                apolloParamRssi2Distance.A_Value = Double.parseDouble(str);
            }
            String str2 = (String) toggle.getExperiment().getParam("rssi2distance_n_param", "2.0");
            if (!TextUtils.isEmpty(str2)) {
                apolloParamRssi2Distance.n_Value = Double.parseDouble(str2);
            }
        }
        return apolloParamRssi2Distance;
    }

    public static long getBleScanFailedInterval() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_v2_parameter");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 20000;
        }
        return (long) ((Integer) experiment.getParam("ble_scan_failed_interval", 20000)).intValue();
    }

    public static long getBleRssiFailedInterval() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_v2_parameter");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 20000;
        }
        return (long) ((Integer) experiment.getParam("ble_scan_failed_interval", 20000)).intValue();
    }

    public static long getBleReadDataInterval() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_v2_parameter");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 1000;
        }
        return (long) ((Integer) experiment.getParam("ble_read_data_interval", 1000)).intValue();
    }

    public static long getBleReadRssiInterval() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_v2_parameter");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 200;
        }
        return (long) ((Integer) experiment.getParam("ble_read_rssi_interval", 200)).intValue();
    }

    public static int getBleMaxTryConnectCount() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_v2_parameter");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 5;
        }
        return ((Integer) experiment.getParam("ble_max_try_connect_count", 5)).intValue();
    }

    public static int getBleMaxMutSize() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_v2_parameter");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 100;
        }
        return ((Integer) experiment.getParam("ble_max_mut_size", 100)).intValue();
    }

    public static long getEngineValidTimeInterval() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_v2_parameter");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 5000;
        }
        return (long) ((Integer) experiment.getParam("engine_valid_time_interval", 5000)).intValue();
    }
}

package com.didi.map.global.sdk.movement.apollo;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.diface.logger.DiFaceLogger;

public class MovementApolloUtil {
    public static float getEngineValidAcc() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_v2_parameter");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 20.0f;
        }
        return (float) ((Integer) experiment.getParam("engine_valid_acc", 20)).intValue();
    }

    public static float getEngineStepLength() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_v2_parameter");
        if (!(toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null)) {
            String str = (String) experiment.getParam("engine_step_length", "0.8");
            if (!TextUtils.isEmpty(str)) {
                return Float.parseFloat(str);
            }
        }
        return 0.8f;
    }

    public static ApolloParamRssi2Distance getApolloParamRssi2Distance() {
        ApolloParamRssi2Distance apolloParamRssi2Distance = new ApolloParamRssi2Distance();
        apolloParamRssi2Distance.A_Value = 59.0d;
        apolloParamRssi2Distance.n_Value = 2.0d;
        IToggle toggle = Apollo.getToggle("global_map_bluetooth_parameter");
        if (toggle.allow()) {
            String str = (String) toggle.getExperiment().getParam("rssi2distance_A_param", DiFaceLogger.EVENT_ID_SDK_EXIT_DIALOG_CANCEL);
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

    public static int getBleTrackRate() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_ble_track_rate_toggle");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 0;
        }
        return ((Integer) experiment.getParam("engine_step_length", 0)).intValue();
    }
}

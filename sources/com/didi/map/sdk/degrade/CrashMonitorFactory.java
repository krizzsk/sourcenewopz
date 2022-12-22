package com.didi.map.sdk.degrade;

import android.content.Context;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class CrashMonitorFactory {
    public static ICrashMonitor create(Context context) {
        IToggle toggle = Apollo.getToggle("global_android_map_degradation_toggle");
        int i = 0;
        if (toggle != null && toggle.allow()) {
            i = ((Integer) toggle.getExperiment().getParam(SfViewMenuModel.TYPE_REALTIME_MONITOR, 0)).intValue();
        }
        if (i == 0) {
            return new CrashMonitorImplV1();
        }
        return new CrashMonitorImplV2();
    }
}

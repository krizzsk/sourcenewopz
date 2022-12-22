package com.didichuxing.omega.sdk.corelink.node;

import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;

public class EventSampleNode {
    public static boolean isSampled(String str, float f) {
        StringBuilder sb = new StringBuilder();
        sb.append(PersistentInfoCollector.getOmegaId());
        sb.append(str);
        return ((int) (f * 10000.0f)) >= Math.abs(sb.toString().hashCode()) % 10000;
    }
}

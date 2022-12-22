package com.didi.map.sdk.nav.inertia;

import java.util.Locale;

public class ApolloParamsSctxPrediction {
    public static final float COEFFICIENT_DEFAULT = 0.8f;
    public static final int DIST_DISABLE_MOCK_DEFAULT = 10;
    public static final int ENABLE_MOCK_DEFAULT = 0;
    public static final int ENABLE_OMG_DEFAULT = 0;
    public static final int START_OMG_DIST_DEFAULT = 300;
    public float coefficient = 0.8f;
    public int distDisableMock = 10;
    public int enableMock = 0;
    public int enableOmg = 0;
    public int startOmgDist = 300;

    public boolean isPredictionEnabled() {
        return this.enableMock > 0;
    }

    public boolean isPredictionOmegaEnabled() {
        return isPredictionEnabled() && this.enableOmg > 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("预判数据: apollo ");
        stringBuffer.append(isPredictionEnabled() ? "enabled" : "disabled");
        if (isPredictionEnabled()) {
            stringBuffer.append(String.format(Locale.getDefault(), ", coefficient:%.2f, distDisableMock:%d, enableOmg:%d, startOmgDist:%d", new Object[]{Float.valueOf(this.coefficient), Integer.valueOf(this.distDisableMock), Integer.valueOf(this.enableOmg), Integer.valueOf(this.startOmgDist)}));
        }
        return stringBuffer.toString();
    }
}

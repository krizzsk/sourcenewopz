package com.didichuxing.mas.sdk.quality.report.collector;

import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;

public class LocationCollector {
    public static double[] getLocation() {
        if (MASConfig.iLocation == null || !isNeedUploadLocation() || !AnalysisDelegater.isAppAtFront()) {
            return null;
        }
        return MASConfig.iLocation.getLocation();
    }

    public static boolean isNeedUploadLocation() {
        if (MASConfig.iLocationConfig != null) {
            return MASConfig.iLocationConfig.isNeedUploadLocation();
        }
        return true;
    }
}

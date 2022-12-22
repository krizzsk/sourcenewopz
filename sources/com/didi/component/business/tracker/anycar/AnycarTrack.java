package com.didi.component.business.tracker.anycar;

import com.didi.sdk.monitor.QualityCheckTrackImpl;
import java.util.Map;

public class AnycarTrack {

    /* renamed from: a */
    private static String f11370a = "anycar";
    public static int mSceneAnycarResponse = 1;
    public static int mSceneAppendCarList = 3;
    public static int mSceneChangeCity = 4;
    public static int mSceneChangePayMethod = 7;
    public static int mSceneChangeSeat = 8;
    public static int mSceneConfirmNewSheet = 9;
    public static int mSceneExpectationCarList = 2;
    public static int mSceneSubstituteCall = 5;

    public static void anycarMonitorTrack(int i, Map<String, Object> map) {
        QualityCheckTrackImpl.trackError(f11370a, i, map);
    }
}

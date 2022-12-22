package com.didi.map.common;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class BlockAccidentApolloManager {
    private static final String DOLPHIN_REPORT_WINDOW_BUBBLE = "dolphin_report_windowbubble";
    private static final boolean IS_APOLLO_OPEN = getDolphinReportWindowBubble();
    private static boolean isTrafficWindowAutoShow = false;
    private static boolean isWindowAutoShow = false;
    private static int sAccidentDistanceThreshold = 2000;
    private static int sApolloWindowAutoShow = 0;
    private static int sBubbleCloseTime = 10;
    private static int sDialogDistanceThreshold = 800;
    private static int sFusionDistanceThreshold = 2000;
    private static int sTrafficBubbleDistance = 1300;
    private static int sTrafficWindowAutoShowDistance = 800;
    private static int sWindowCloseTime = 20;

    private BlockAccidentApolloManager() {
    }

    private static boolean getDolphinReportWindowBubble() {
        IToggle toggle = Apollo.getToggle(DOLPHIN_REPORT_WINDOW_BUBBLE);
        if (toggle.allow()) {
            sWindowCloseTime = ((Integer) toggle.getExperiment().getParam("window_detail_autoclose_time", 20)).intValue();
            sBubbleCloseTime = ((Integer) toggle.getExperiment().getParam("window_autoclose_time", 10)).intValue();
            boolean z = true;
            sApolloWindowAutoShow = ((Integer) toggle.getExperiment().getParam("window_autoshow", 1)).intValue();
            sAccidentDistanceThreshold = ((Integer) toggle.getExperiment().getParam("shigu_bubble_distance", 2000)).intValue();
            sFusionDistanceThreshold = ((Integer) toggle.getExperiment().getParam("shiguyongdu_bubble_distance", 2000)).intValue();
            sDialogDistanceThreshold = ((Integer) toggle.getExperiment().getParam("window_autoshow_distance", 800)).intValue();
            if (((Integer) toggle.getExperiment().getParam("traffic_window_autoshow", 0)).intValue() != 1) {
                z = false;
            }
            isTrafficWindowAutoShow = z;
            sTrafficBubbleDistance = ((Integer) toggle.getExperiment().getParam("traffic_window_autoshow_preload", 1300)).intValue();
            sTrafficWindowAutoShowDistance = ((Integer) toggle.getExperiment().getParam("traffic_window_autoshow_distance", 800)).intValue();
        }
        return toggle.allow();
    }

    public static boolean isApolloOpen() {
        return IS_APOLLO_OPEN;
    }

    public static int getsWindowCloseTime() {
        return sWindowCloseTime;
    }

    public static int getsBubbleCloseTime() {
        return sBubbleCloseTime;
    }

    public static int getsAccidentDistanceThreshold() {
        return sAccidentDistanceThreshold;
    }

    public static int getsFusionDistanceThreshold() {
        return sFusionDistanceThreshold;
    }

    public static int getsDialogDistanceThreshold() {
        return sDialogDistanceThreshold;
    }

    public static boolean isWindowAutoShow() {
        return sApolloWindowAutoShow == 1 && isWindowAutoShow;
    }

    public static void setCurrentSceneWindowAutoShow(boolean z) {
        isWindowAutoShow = z;
    }

    public static int getsTrafficBubbleDistance() {
        return sTrafficBubbleDistance;
    }

    public static int getsTrafficWindowAutoShowDistance() {
        return sTrafficWindowAutoShowDistance;
    }

    public static boolean isTrafficWindowAutoShow() {
        return isTrafficWindowAutoShow;
    }
}

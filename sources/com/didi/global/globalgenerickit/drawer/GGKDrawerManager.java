package com.didi.global.globalgenerickit.drawer;

public class GGKDrawerManager {
    public static GGKAbsDrawer showingDrawer;

    public static void dismissGGKDrawer() {
        GGKAbsDrawer gGKAbsDrawer = showingDrawer;
        if (gGKAbsDrawer != null && gGKAbsDrawer.isShowing()) {
            showingDrawer.dismiss();
        }
    }
}

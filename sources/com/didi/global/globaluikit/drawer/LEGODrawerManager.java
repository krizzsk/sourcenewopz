package com.didi.global.globaluikit.drawer;

public class LEGODrawerManager {
    public static LEGOAbsDrawer showingDrawer;

    public static void dismissGGKDrawer() {
        LEGOAbsDrawer lEGOAbsDrawer = showingDrawer;
        if (lEGOAbsDrawer != null && lEGOAbsDrawer.isShowing()) {
            showingDrawer.dismiss();
        }
    }
}

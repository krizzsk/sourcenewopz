package com.didi.rfusion.utils.tracker;

import com.didi.rfusion.RFusion;

public class RFTrackerHelper {
    public static void trackFloatingShow() {
        m23429a("tech_rf_floating_sw").track();
    }

    public static void trackDialogShow() {
        m23429a("tech_rf_dialog_sw").track();
    }

    /* renamed from: a */
    private static RFEventTracker m23429a(String str) {
        RFEventTracker event = RFEventTracker.event(str);
        m23430a(event);
        return event;
    }

    /* renamed from: a */
    private static void m23430a(RFEventTracker rFEventTracker) {
        rFEventTracker.param("pkgName", RFusion.getContext().getPackageName());
    }
}

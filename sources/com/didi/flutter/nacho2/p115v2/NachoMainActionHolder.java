package com.didi.flutter.nacho2.p115v2;

/* renamed from: com.didi.flutter.nacho2.v2.NachoMainActionHolder */
public class NachoMainActionHolder {

    /* renamed from: a */
    private static NachoAction f21145a;

    private NachoMainActionHolder() {
    }

    public static void setMainAction(NachoAction nachoAction) {
        if (f21145a == null) {
            f21145a = nachoAction;
            return;
        }
        throw new RuntimeException("Nacho MainAction duplicated init.");
    }

    public static NachoAction getMainAction() {
        return f21145a;
    }
}

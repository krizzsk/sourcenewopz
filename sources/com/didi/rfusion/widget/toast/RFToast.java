package com.didi.rfusion.widget.toast;

import com.didi.rfusion.utils.RFResUtils;

public class RFToast {

    /* renamed from: a */
    private static int f34000a;

    public static void setDefaultType(int i) {
        f34000a = i;
    }

    public static int getDefaultType() {
        return f34000a;
    }

    public static void show(String str) {
        show(str, f34000a);
    }

    public static void show(String str, int i) {
        RFToastController.m24003a().mo88597a(str, i, false);
    }

    public static void show(int i) {
        show(i, f34000a);
    }

    public static void show(int i, int i2) {
        show(RFResUtils.getString(i), i2);
    }

    public static void showAllowInBg(String str) {
        showAllowInBg(str, f34000a);
    }

    public static void showAllowInBg(String str, int i) {
        RFToastController.m24003a().mo88597a(str, i, true);
    }

    public static void showAllowInBg(int i) {
        showAllowInBg(i, f34000a);
    }

    public static void showAllowInBg(int i, int i2) {
        showAllowInBg(RFResUtils.getString(i), i2);
    }
}

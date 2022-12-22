package com.didi.component.evaluate.util;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Stack;

public class TempUtil {

    /* renamed from: a */
    private static Stack<SoftInputMode> f13327a = new Stack<>();

    public static void restoreSoftInputMode(Fragment fragment) {
        FragmentActivity activity;
        if (fragment != null && f13327a.size() != 0 && (activity = fragment.getActivity()) != null) {
            activity.getWindow().setSoftInputMode(f13327a.pop().mode);
        }
    }

    public static void saveSoftInputMode(Fragment fragment) {
        FragmentActivity activity;
        WindowManager.LayoutParams attributes;
        if (fragment != null && (activity = fragment.getActivity()) != null && (attributes = activity.getWindow().getAttributes()) != null) {
            f13327a.push(new SoftInputMode(attributes.softInputMode));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r3 = r3.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setSoftInputMode(androidx.fragment.app.Fragment r3, int r4) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            androidx.fragment.app.FragmentActivity r3 = r3.getActivity()
            if (r3 == 0) goto L_0x0022
            android.view.Window r3 = r3.getWindow()
            android.view.WindowManager$LayoutParams r0 = r3.getAttributes()
            if (r0 == 0) goto L_0x0022
            java.util.Stack<com.didi.component.evaluate.util.TempUtil$SoftInputMode> r1 = f13327a
            com.didi.component.evaluate.util.TempUtil$SoftInputMode r2 = new com.didi.component.evaluate.util.TempUtil$SoftInputMode
            int r0 = r0.softInputMode
            r2.<init>(r0)
            r1.push(r2)
            r3.setSoftInputMode(r4)
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.evaluate.util.TempUtil.setSoftInputMode(androidx.fragment.app.Fragment, int):void");
    }

    public static int setInputMode(Activity activity, int i) {
        int i2 = 32;
        if (activity != null) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                i2 = attributes.softInputMode;
            }
            window.setSoftInputMode(i);
        }
        return i2;
    }

    static class SoftInputMode {
        int mode;

        public SoftInputMode(int i) {
            this.mode = i;
        }
    }
}

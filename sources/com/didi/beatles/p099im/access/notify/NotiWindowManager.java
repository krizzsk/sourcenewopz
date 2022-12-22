package com.didi.beatles.p099im.access.notify;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.didi.beatles.p099im.IMContextInfoHelper;

/* renamed from: com.didi.beatles.im.access.notify.NotiWindowManager */
public class NotiWindowManager {

    /* renamed from: a */
    private static WindowManager f8797a;

    /* renamed from: a */
    private static WindowManager m5870a() {
        if (f8797a == null) {
            f8797a = (WindowManager) IMContextInfoHelper.getContext().getSystemService("window");
        }
        return f8797a;
    }

    public static boolean addView(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            m5870a().addView(view, layoutParams);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void removeView(View view) {
        try {
            m5870a().removeView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            m5870a().updateViewLayout(view, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WindowManager.LayoutParams getBaseWindowLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.flags = 584;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        return layoutParams;
    }

    public static String getModel() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "" : str;
    }
}

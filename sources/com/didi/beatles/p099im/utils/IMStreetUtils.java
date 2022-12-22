package com.didi.beatles.p099im.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.beatles.p099im.api.entity.IMOrderStatusChangeBody;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.views.widget.WaterMarkBg;
import java.util.ArrayList;

/* renamed from: com.didi.beatles.im.utils.IMStreetUtils */
public class IMStreetUtils {

    /* renamed from: a */
    private static long f9790a = 0;

    /* renamed from: b */
    private static final int f9791b = 30000;

    public static boolean isExpiredPic(IMMessage iMMessage, IMOrderStatusChangeBody iMOrderStatusChangeBody) {
        if (iMOrderStatusChangeBody == null || iMMessage == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        boolean z = iMMessage.getMessageExtendInfo().getPicIsExpired() == 1;
        if (currentTimeMillis >= iMOrderStatusChangeBody.streetImage.expiresAt || z) {
            return true;
        }
        return false;
    }

    public static boolean isExpiredPic(IMMessage iMMessage) {
        return iMMessage == null || iMMessage.getMessageExtendInfo().getPicIsExpired() == 1;
    }

    public static boolean canClickStreetView() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = f9790a;
        long j2 = currentTimeMillis - j;
        if (j > 0 && Math.abs(j2) < 30000) {
            return false;
        }
        f9790a = currentTimeMillis;
        return true;
    }

    public static boolean enableStreetImage(IMSession iMSession) {
        return (iMSession == null || iMSession.getExtendSessionInfo() == null || iMSession.getExtendSessionInfo().openActionIds == null || (!iMSession.getExtendSessionInfo().openActionIds.contains(8) && !iMSession.getExtendSessionInfo().openActionIds.contains(7))) ? false : true;
    }

    public static boolean containsStreetImage(IMSession iMSession) {
        return (iMSession == null || iMSession.getExtendSessionInfo() == null || iMSession.getExtendSessionInfo().actionIds == null || (!iMSession.getExtendSessionInfo().actionIds.contains(8) && !iMSession.getExtendSessionInfo().actionIds.contains(7))) ? false : true;
    }

    public static void addWaterMark(Activity activity, String str) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            FrameLayout frameLayout = new FrameLayout(activity);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            IMViewUtil.setBackgroundCompat(frameLayout, new WaterMarkBg(activity, arrayList, -30, 12));
            ((ViewGroup) activity.findViewById(16908290)).addView(frameLayout);
        }
    }
}

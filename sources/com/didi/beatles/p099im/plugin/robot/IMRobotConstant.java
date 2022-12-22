package com.didi.beatles.p099im.plugin.robot;

import com.didi.beatles.p099im.utils.IMLog;
import java.util.Map;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotConstant */
public final class IMRobotConstant {
    public static final int PLUGIN_ID_ROBOT = 3;

    /* renamed from: a */
    private static String f9473a;

    /* renamed from: b */
    private static Map<String, String> f9474b;

    /* renamed from: c */
    private static int f9475c;

    private IMRobotConstant() {
    }

    public static void setData(String str, Map<String, String> map, int i) {
        IMLog.m6631d("IMRobotConstant", "[setData] orderId=" + str);
        f9473a = str;
        f9474b = map;
        f9475c = i;
    }

    public static String getOrderId() {
        return f9473a;
    }

    public static Map<String, String> getExtraTraceMap() {
        return f9474b;
    }

    public static int getActionSource() {
        return f9475c;
    }
}

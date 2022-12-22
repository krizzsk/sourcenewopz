package com.didi.app.nova.skeleton.tools;

import com.didi.app.nova.skeleton.Skeleton;

public class TraceUtil {
    public static boolean ENABLE = false;
    public static Skeleton.Tracer tracer;

    public static void trace(String str, String str2) {
        Skeleton.Tracer tracer2;
        if (ENABLE && (tracer2 = tracer) != null) {
            tracer2.trace("[Skeleton] " + str, str2);
        }
    }
}

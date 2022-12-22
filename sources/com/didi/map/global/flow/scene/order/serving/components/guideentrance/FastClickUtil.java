package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

public class FastClickUtil {

    /* renamed from: a */
    private static long f26845a = 0;

    /* renamed from: b */
    private static final long f26846b = 1000;

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f26845a;
        if (0 < j && j < 1000) {
            return true;
        }
        f26845a = currentTimeMillis;
        return false;
    }
}

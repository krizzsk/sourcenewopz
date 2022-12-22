package com.didi.component.common.base;

public class CompSceneUtil {
    public static int pageIdtoScene(int i) {
        if (i == 1005) {
            return 10401;
        }
        if (i == 1010) {
            return 10402;
        }
        if (i != 1015) {
            return i != 1025 ? -1 : 10401;
        }
        return 10403;
    }
}

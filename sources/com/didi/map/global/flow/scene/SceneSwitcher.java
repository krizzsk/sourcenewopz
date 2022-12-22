package com.didi.map.global.flow.scene;

import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.model.Bundle;

public class SceneSwitcher {
    public static IScene switchScene(IScene iScene, IScene iScene2) {
        Bundle bundle;
        if (iScene != null) {
            bundle = iScene.transferParams();
            iScene.leave();
        } else {
            bundle = null;
        }
        DLog.m7384d("mapflow", "leave scene: " + m18604a(iScene) + "; enter scene: " + m18604a(iScene2), new Object[0]);
        iScene2.enter(bundle);
        return iScene2;
    }

    /* renamed from: a */
    private static String m18604a(Object obj) {
        return obj != null ? obj.getClass().getSimpleName() : "unknown";
    }
}

package com.dmap.navigation.engine;

import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.engine.core.INaviEngine;
import com.dmap.navigation.engine.core.INaviEngineVP;
import com.dmap.navigation.engine.p207a.C17402o;
import com.dmap.navigation.engine.p207a.C17405p;

public class NaviEngineFactory {
    public static INaviEngine createNaviEngine(INaviContext iNaviContext) {
        return new C17402o(iNaviContext);
    }

    public static INaviEngineVP createNaviEngineVP(INaviContext iNaviContext) {
        return new C17405p(iNaviContext);
    }
}

package com.dmap.navigation.api.core.impl;

import com.dmap.navigation.api.core.INormalNaviAPI;
import com.dmap.navigation.api.core.IOrderNaviAPI;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.engine.p207a.C17383b;
import com.dmap.navigation.engine.p207a.C17384c;

public final class NaviAPIFactory {
    private NaviAPIFactory() {
    }

    public static IOrderNaviAPI createOrderNaviAPI(INaviContext iNaviContext) {
        return new C17384c(iNaviContext);
    }

    public static INormalNaviAPI createNormalNaviAPI(INaviContext iNaviContext) {
        return new C17383b(iNaviContext);
    }
}

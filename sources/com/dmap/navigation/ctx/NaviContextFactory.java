package com.dmap.navigation.ctx;

import android.content.Context;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.engine.p207a.C17401n;

public class NaviContextFactory {
    private NaviContextFactory() {
    }

    public static INaviContext createNaviContext(Context context) {
        return new C17401n(context);
    }
}

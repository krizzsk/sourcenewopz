package com.didi.map.sdk.sharetrack.external;

import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.logger.DLog;

public class GoogleRouteOptManager {

    /* renamed from: a */
    private static final String f28673a = "GoogleRouteOpt";

    /* renamed from: b */
    private boolean f28674b;

    /* renamed from: c */
    private boolean f28675c;

    private GoogleRouteOptManager() {
        this.f28674b = false;
        this.f28675c = false;
    }

    private static class Holder {
        public static GoogleRouteOptManager opt = new GoogleRouteOptManager();

        private Holder() {
        }
    }

    public static GoogleRouteOptManager getInstance() {
        return Holder.opt;
    }

    public void updateRouteOpt(NaviRoute naviRoute) {
        log("updateRouteOpt = " + naviRoute);
        if (naviRoute != null) {
            this.f28674b = naviRoute.avoidTolls();
            this.f28675c = naviRoute.routeShorter();
            return;
        }
        reset();
    }

    public void reset() {
        log("reset");
        this.f28674b = false;
        this.f28675c = false;
    }

    public boolean avoidTolls() {
        log("avoidTolls = " + this.f28674b);
        return this.f28674b;
    }

    public boolean routeShorter() {
        log("routeShorter = " + this.f28675c);
        return this.f28675c;
    }

    public void log(String str) {
        DLog.m20357d(f28673a, str, new Object[0]);
    }
}

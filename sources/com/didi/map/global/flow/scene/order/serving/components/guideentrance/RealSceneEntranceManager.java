package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import com.didi.map.global.flow.scene.order.serving.param.ServingParam;

public class RealSceneEntranceManager {

    /* renamed from: a */
    private static RealSceneEntranceManager f26878a;

    /* renamed from: b */
    private ServingParam f26879b;

    private RealSceneEntranceManager(ServingParam servingParam) {
        this.f26879b = servingParam;
    }

    public static RealSceneEntranceManager getInstance(ServingParam servingParam) {
        if (f26878a == null) {
            f26878a = new RealSceneEntranceManager(servingParam);
        }
        return f26878a;
    }

    public void showReal() {
        ServingParam servingParam = this.f26879b;
        if (servingParam != null && servingParam.getGuideEntranceCallback() != null && this.f26879b.getOrderParams() != null) {
            this.f26879b.getGuideEntranceCallback().onNavigateToRealScene(this.f26879b.getOrderParams().stationWalkGuideLink);
        }
    }

    public void destroy() {
        this.f26879b = null;
    }
}

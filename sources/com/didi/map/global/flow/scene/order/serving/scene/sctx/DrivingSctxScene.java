package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import com.didi.common.map.model.Padding;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;

@IScene.Scene(mo74615id = 1006)
public class DrivingSctxScene extends BaseScene {
    public static final int STAGE_ON_TRIP = 1;
    public static final int STAGE_PICKUP = 0;

    public DrivingSctxScene(ServingParam servingParam, MapViewHolder mapViewHolder, int i) {
        super(servingParam, mapViewHolder);
        if (servingParam != null) {
            this.mPage = getPage(i, servingParam);
        }
    }

    public BasePage getPage(int i, ServingParam servingParam) {
        if (i == 0) {
            return new WaitingForDrivingPage(this, servingParam, this.mMapView);
        }
        if (i == 1) {
            return new DriveOffPage(this, servingParam, this.mMapView);
        }
        return null;
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.mPage != null) {
            this.mPage.doBestView(padding);
        }
    }
}

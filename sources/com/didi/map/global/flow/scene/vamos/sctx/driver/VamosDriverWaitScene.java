package com.didi.map.global.flow.scene.vamos.sctx.driver;

import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.vamos.sctx.driver.param.VamosDriverSctxParam;

@IScene.Scene(mo74615id = 2010)
public class VamosDriverWaitScene extends VamosDriverPickupScene {
    /* access modifiers changed from: protected */
    public int getInnerOrderStage() {
        return 2;
    }

    public VamosDriverWaitScene(VamosDriverSctxParam vamosDriverSctxParam, MapViewHolder mapViewHolder) {
        super(vamosDriverSctxParam, mapViewHolder);
    }
}

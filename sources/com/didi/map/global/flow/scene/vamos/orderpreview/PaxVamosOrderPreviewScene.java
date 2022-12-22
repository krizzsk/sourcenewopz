package com.didi.map.global.flow.scene.vamos.orderpreview;

import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.vamos.orderpreview.param.VamosOrderPreviewParams;

@IScene.Scene(mo74615id = 2006)
public class PaxVamosOrderPreviewScene extends VamosOrderPreviewScene {
    public void onPause() {
    }

    public PaxVamosOrderPreviewScene(VamosOrderPreviewParams vamosOrderPreviewParams, MapViewHolder mapViewHolder) {
        super(vamosOrderPreviewParams, mapViewHolder);
    }
}

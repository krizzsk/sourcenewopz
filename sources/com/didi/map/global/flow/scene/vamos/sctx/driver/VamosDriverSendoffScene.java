package com.didi.map.global.flow.scene.vamos.sctx.driver;

import android.view.View;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.InfoWindow;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.vamos.sctx.driver.param.VamosDriverSctxParam;
import com.didi.map.global.flow.utils.MarkerUtil;
import java.util.ArrayList;
import java.util.List;

@IScene.Scene(mo74615id = 2011)
public class VamosDriverSendoffScene extends VamosDriverBaseSctxScene {
    /* access modifiers changed from: protected */
    public int getInnerOrderStage() {
        return 4;
    }

    public VamosDriverSendoffScene(VamosDriverSctxParam vamosDriverSctxParam, MapViewHolder mapViewHolder) {
        super(vamosDriverSctxParam, mapViewHolder);
    }

    public void updateMarkerBubble(View view) {
        if (this.isSceneValid && this.mMapView != null) {
            MarkerUtil.showInfoWindow(this.mMapView.getMapView(), this.mOrderEndMarker, view, this.mOrderEndMarker.getZIndex(), (InfoWindow.Position) null);
        }
    }

    /* access modifiers changed from: protected */
    public List<IMapElement> getBestViewMapElements() {
        ArrayList arrayList = new ArrayList();
        if (this.mOrderEndMarker != null) {
            arrayList.add(this.mOrderEndMarker);
        }
        return arrayList;
    }
}

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

@IScene.Scene(mo74615id = 2009)
public class VamosDriverPickupScene extends VamosDriverBaseSctxScene {
    /* access modifiers changed from: protected */
    public int getInnerOrderStage() {
        return 1;
    }

    public VamosDriverPickupScene(VamosDriverSctxParam vamosDriverSctxParam, MapViewHolder mapViewHolder) {
        super(vamosDriverSctxParam, mapViewHolder);
        setInitPsgComponent(true);
    }

    public void updateMarkerBubble(View view) {
        if (this.isSceneValid && this.mMapView != null && this.mMapView.getMapView() != null) {
            MarkerUtil.showInfoWindow(this.mMapView.getMapView(), this.mOrderStartMarker, view, this.mOrderStartMarker.getZIndex(), (InfoWindow.Position) null);
        }
    }

    /* access modifiers changed from: protected */
    public List<IMapElement> getBestViewMapElements() {
        ArrayList arrayList = new ArrayList();
        if (this.mOrderStartMarker != null) {
            arrayList.add(this.mOrderStartMarker);
        }
        return arrayList;
    }
}

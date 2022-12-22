package com.didi.map.global.flow.scene.vamos.orderwait;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.vamos.orderwait.param.VamosOrderWaitParams;
import java.util.ArrayList;
import java.util.List;

@IScene.Scene(mo74615id = 2008)
public class PaxVamosOrderWaitScene extends VamosOrderWaitScene {

    /* renamed from: a */
    private static final String f27115a = "PaxVamosOrderWaitScene";

    /* access modifiers changed from: protected */
    public boolean isAutoPolling() {
        return false;
    }

    public void onPause() {
    }

    public PaxVamosOrderWaitScene(VamosOrderWaitParams vamosOrderWaitParams, MapViewHolder mapViewHolder) {
        super(vamosOrderWaitParams, mapViewHolder);
    }

    /* access modifiers changed from: protected */
    public LatLng getRouteEndPoint() {
        return ((VamosOrderWaitParams) this.mParam).getVamosMarkerModel().mPaxEndPosition;
    }

    /* access modifiers changed from: protected */
    public boolean paramsCheck() {
        return (this.mParam == null || ((VamosOrderWaitParams) this.mParam).getVamosMarkerModel() == null || ((VamosOrderWaitParams) this.mParam).getVamosMarkerModel().mDriverStartPosition == null || ((VamosOrderWaitParams) this.mParam).getVamosMarkerModel().mPaxEndPosition == null || ((VamosOrderWaitParams) this.mParam).getVamosMarkerModel().mPaxStartPosition == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    public List<LatLng> getWayPoint() {
        ArrayList arrayList = new ArrayList();
        if (!(this.mParam == null || ((VamosOrderWaitParams) this.mParam).getVamosMarkerModel() == null || ((VamosOrderWaitParams) this.mParam).getVamosMarkerModel().mPaxStartPosition == null)) {
            arrayList.add(((VamosOrderWaitParams) this.mParam).getVamosMarkerModel().mPaxStartPosition);
        }
        return arrayList;
    }
}

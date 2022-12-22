package com.didi.map.global.flow.scene.vamos.homepage;

import com.didi.common.map.BestViewer;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageScene;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

@IScene.Scene(mo74615id = 2001)
public class VamosHomePageScene extends BaseVamosPageScene<VamosHomePageSceneParam> {
    public void onPause() {
    }

    public void onResume() {
    }

    public VamosHomePageScene(VamosHomePageSceneParam vamosHomePageSceneParam, MapViewHolder mapViewHolder) {
        super(vamosHomePageSceneParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
    }

    public void leave() {
        super.leave();
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null) {
            hideResetView();
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext().getApplicationContext());
            if (lastKnownLocation != null) {
                BestViewer.doBestView_Animate(getMap(), new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()), padding);
            }
        }
    }
}

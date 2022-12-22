package com.didi.map.global.flow.scene.vamos.sctx.passenger;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.param.VamosSctxSceneParam;
import com.didi.map.sdk.nav.car.CarMarker;
import java.util.ArrayList;
import java.util.List;

@IScene.Scene(mo74615id = 2014)
public class VamosInServiceScene extends VamosBaseSctxScene {

    /* renamed from: a */
    private static final String f27166a = VamosInServiceScene.class.getSimpleName();

    /* access modifiers changed from: protected */
    public int getOrderStage() {
        return 4;
    }

    public VamosInServiceScene(VamosSctxSceneParam vamosSctxSceneParam, MapViewHolder mapViewHolder) {
        super(vamosSctxSceneParam, mapViewHolder);
    }

    /* access modifiers changed from: protected */
    public void doSceneBestView(Padding padding, boolean z) {
        if (this.isSceneValid) {
            Padding mapInPadding = getMapInPadding();
            ArrayList arrayList = new ArrayList();
            if (this.mCachedValue.startEndMarker != null) {
                arrayList.addAll(this.mCachedValue.startEndMarker.getEndMapElements());
                if (!(this.mCachedValue.startEndMarker.getEndIconMarker() == null || this.mCachedValue.startEndMarker.getEndIconMarker().getInfoWindow() == null || this.mCachedValue.startEndMarker.getEndIconMarker().getInfoWindow().getInfoWindowMarker() == null)) {
                    arrayList.add(this.mCachedValue.startEndMarker.getEndIconMarker().getInfoWindow().getInfoWindowMarker());
                }
            }
            CarMarker carMarker = this.mPassengerSctx.getCarMarker();
            if (!(carMarker == null || carMarker.getMarker() == null)) {
                arrayList.add(carMarker.getMarker());
            }
            List<IMapElement> routeElements = getRouteElements();
            if (routeElements != null) {
                arrayList.addAll(routeElements);
            }
            if (!(this.mPassengerSctx == null || this.mPassengerSctx.getLines() == null)) {
                arrayList.addAll(this.mPassengerSctx.getLines());
            }
            boolean z2 = false;
            if (this.mapAutoBestViewLoop != null) {
                z2 = this.mapAutoBestViewLoop.doBestViewExecute(arrayList, padding, mapInPadding, z);
            } else {
                DLog.m7384d(f27166a, "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                hideResetView();
            }
        }
    }

    public void refreshStartEndMarker(LatLng latLng, LatLng latLng2) {
        refreshEndPointMarker(latLng2, false);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        addEndPointMarker(((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().end, false);
        if (this.mMapView != null) {
            this.mMapView.setLocationVisible(false);
        }
    }

    public void leave() {
        super.leave();
    }
}

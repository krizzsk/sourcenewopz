package com.didi.map.global.flow.scene.vamos.sctx.passenger;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.param.VamosSctxSceneParam;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@IScene.Scene(mo74615id = 2013)
public class VamosWaitingScene extends VamosPickupScene {
    /* access modifiers changed from: protected */
    public int getOrderStage() {
        return 3;
    }

    public VamosWaitingScene(VamosSctxSceneParam vamosSctxSceneParam, MapViewHolder mapViewHolder) {
        super(vamosSctxSceneParam, mapViewHolder);
    }

    /* access modifiers changed from: protected */
    public void doSceneBestView(Padding padding, boolean z) {
        CarMarker carMarker;
        List<IMapElement> myLocationMarkers;
        if (this.isSceneValid) {
            Padding mapInPadding = getMapInPadding();
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            boolean z2 = false;
            if (isUserLocationVisible()) {
                boolean z3 = true;
                DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
                if (lastKnownLocation != null) {
                    LatLng latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                    if (LatLngUtils.locateCorrect(latLng) && this.mCachedValue.startEndMarker != null && ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel() != null && DDSphericalUtil.computeDistanceBetween(latLng, ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().start) > 5000.0d) {
                        z3 = false;
                    }
                }
                if (!(!z3 || this.mMapView == null || (myLocationMarkers = this.mMapView.getMyLocationMarkers()) == null)) {
                    copyOnWriteArrayList.addAll(myLocationMarkers);
                }
            }
            if (this.mCachedValue.startEndMarker != null) {
                copyOnWriteArrayList.addAll(this.mCachedValue.startEndMarker.getStartMapElements());
            }
            if (!(((VamosSctxSceneParam) this.mParam).getOrderParams() == null || (carMarker = this.mPassengerSctx.getCarMarker()) == null || carMarker.getMarker() == null)) {
                copyOnWriteArrayList.add(carMarker.getMarker());
            }
            List<IMapElement> routeElements = getRouteElements();
            if (routeElements != null) {
                copyOnWriteArrayList.addAll(routeElements);
            }
            if (this.mPassengerSctx.getLines() != null) {
                copyOnWriteArrayList.addAll(this.mPassengerSctx.getLines());
            }
            if (this.mapAutoBestViewLoop != null) {
                z2 = this.mapAutoBestViewLoop.doBestViewExecute(copyOnWriteArrayList, padding, mapInPadding, z);
            } else {
                DLog.m7384d("VamosWaitingScene", "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                hideResetView();
            }
        }
    }
}

package com.didi.map.global.flow.scene.vamos.sctx.passenger;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.param.VamosSctxSceneParam;
import com.didi.map.global.flow.toolkit.walkdrop.WalkParam;
import com.didi.map.global.flow.toolkit.walkdrop.WalkingLineManager;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@IScene.Scene(mo74615id = 2012)
public class VamosPickupScene extends VamosBaseSctxScene {

    /* renamed from: a */
    private static final String f27167a = "didifence_airport";

    /* renamed from: b */
    private String f27168b;

    /* renamed from: c */
    private WalkingLineManager f27169c;

    /* access modifiers changed from: protected */
    public int getOrderStage() {
        return 3;
    }

    public VamosPickupScene(VamosSctxSceneParam vamosSctxSceneParam, MapViewHolder mapViewHolder) {
        super(vamosSctxSceneParam, mapViewHolder);
    }

    public void refreshStartEndMarker(LatLng latLng, LatLng latLng2) {
        refreshStartPointMarker(latLng2, true);
        WalkingLineManager walkingLineManager = this.f27169c;
        if (walkingLineManager != null) {
            walkingLineManager.updateWalkingLine(latLng2);
        }
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        addStartPointMarker(((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().start, false);
        if (this.mParam != null && ((VamosSctxSceneParam) this.mParam).getOrderParams() != null) {
            WalkParam walkParam = new WalkParam();
            walkParam.setCallFromm(CallFrom.ORDERROUTEAPI_VAMOS);
            walkParam.setAnimate(true);
            walkParam.setProductId(((VamosSctxSceneParam) this.mParam).getOrderParams().productID);
            walkParam.setSrcTag(((VamosSctxSceneParam) this.mParam).getOrderParams().srcTag);
            walkParam.setOrderId(((VamosSctxSceneParam) this.mParam).getOrderParams().orderId);
            this.f27169c = new WalkingLineManager(getContext(), getMap(), walkParam);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void leave() {
        super.leave();
        WalkingLineManager walkingLineManager = this.f27169c;
        if (walkingLineManager != null) {
            walkingLineManager.destroy();
            this.f27169c = null;
        }
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
            if (!(this.mCachedValue == null || this.mCachedValue.startEndMarker == null)) {
                copyOnWriteArrayList.addAll(this.mCachedValue.startEndMarker.getStartMapElements());
            }
            WalkingLineManager walkingLineManager = this.f27169c;
            if (walkingLineManager != null && !CollectionUtil.isEmpty((Collection<?>) walkingLineManager.getWalkLine())) {
                copyOnWriteArrayList.addAll(this.f27169c.getWalkLine());
            }
            if (!(this.mParam == null || ((VamosSctxSceneParam) this.mParam).getOrderParams() == null || this.mPassengerSctx == null || (carMarker = this.mPassengerSctx.getCarMarker()) == null || carMarker.getMarker() == null)) {
                copyOnWriteArrayList.add(carMarker.getMarker());
            }
            List<IMapElement> routeElements = getRouteElements();
            if (routeElements != null) {
                copyOnWriteArrayList.addAll(routeElements);
            }
            if (!(this.mPassengerSctx == null || this.mPassengerSctx.getLines() == null)) {
                copyOnWriteArrayList.addAll(this.mPassengerSctx.getLines());
            }
            if (this.mapAutoBestViewLoop != null) {
                z2 = this.mapAutoBestViewLoop.doBestViewExecute(copyOnWriteArrayList, padding, mapInPadding, z);
            } else {
                DLog.m7384d("VamosPickupScene", "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                hideResetView();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onGetOraResult(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        WalkingLineManager walkingLineManager;
        if (this.mParam != null && ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel() != null && (walkingLineManager = this.f27169c) != null) {
            walkingLineManager.updateWalkingLine(((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().start);
        }
    }
}

package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import android.view.View;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.sctx.SctxService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo74615id = 1008)
public class WaitingForDrivingAppointScene extends BaseScene {
    public EtaEda getLastEtaEda() {
        return null;
    }

    public void updateMarkerBubble(MapElementId mapElementId, View view) {
    }

    public WaitingForDrivingAppointScene(ServingParam servingParam, MapViewHolder mapViewHolder) {
        super(servingParam, mapViewHolder);
        this.mPage = new WaitingForDrivingAppointPage(this, servingParam, mapViewHolder);
    }

    private static class WaitingForDrivingAppointPage extends BasePage {
        private SctxService.SctxCallback mSctxCallback = new SctxService.SctxCallbackAdapter() {
            public void onStartDestinationUpdate(LatLng latLng, LatLng latLng2) {
                WaitingForDrivingAppointPage.this.refreshStartPointMarker(latLng2, true);
            }
        };

        /* access modifiers changed from: protected */
        public int getOrderStage() {
            return 3;
        }

        public void onPause() {
        }

        public void onResume() {
        }

        /* access modifiers changed from: protected */
        public boolean showOdPoints() {
            return false;
        }

        public WaitingForDrivingAppointPage(PageScene pageScene, ServingParam servingParam, MapViewHolder mapViewHolder) {
            super(pageScene, servingParam, mapViewHolder);
        }

        public void enter(boolean z) {
            super.enter(false);
            setSctxCallback(this.mSctxCallback);
            this.mMarkerManager.addMarker(MapElementId.ID_MARKER_START, true);
        }

        public void leave() {
            super.leave();
        }

        /* access modifiers changed from: protected */
        public void doSceneBestView(Padding padding, boolean z) {
            List<IMapElement> myLocationMarkers;
            if (this.isSceneValid) {
                Padding mapInPadding = getMapInPadding();
                ArrayList arrayList = new ArrayList();
                if (!(this.mMapView == null || (myLocationMarkers = this.mMapView.getMyLocationMarkers()) == null)) {
                    arrayList.addAll(myLocationMarkers);
                }
                List<IMapElement> makerMapElements = this.mMarkerManager.getMakerMapElements(MapElementId.ID_MARKER_START);
                if (!CollectionUtil.isEmpty((Collection<?>) makerMapElements)) {
                    arrayList.addAll(makerMapElements);
                }
                boolean z2 = false;
                if (this.mapAutoBestViewLooper != null) {
                    z2 = this.mapAutoBestViewLooper.doBestViewExecute(arrayList, padding, mapInPadding, z);
                } else {
                    DLog.m7384d("WaitingForDrivingAppointScene", "doSceneBestView, mBestViewFilter is null", new Object[0]);
                }
                if (z2) {
                    this.mScene.hideResetView();
                }
            }
        }
    }
}

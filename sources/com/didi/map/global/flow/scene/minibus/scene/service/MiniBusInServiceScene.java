package com.didi.map.global.flow.scene.minibus.scene.service;

import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo74615id = 3004)
public class MiniBusInServiceScene extends BaseMiniBusSctxScene {
    protected long onTripSctxIntervalMillis = MapFlowApolloUtils.getOnTripSxtxIntervalMillis();

    /* access modifiers changed from: protected */
    public int getOrderStage() {
        return 4;
    }

    public void onOrderStateChanged(int i, OrderParams orderParams) {
    }

    /* access modifiers changed from: protected */
    public boolean showWayPoints() {
        return true;
    }

    public MiniBusInServiceScene(MiniBusSctxSceneParam miniBusSctxSceneParam, MapViewHolder mapViewHolder) {
        super(miniBusSctxSceneParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (this.mMapView != null) {
            this.mMapView.setLocationVisible(false);
        }
        enterSctxService();
    }

    public void leave() {
        super.leave();
    }

    /* access modifiers changed from: protected */
    public long getOraRequestIntervalMillis() {
        return this.onTripSctxIntervalMillis;
    }

    /* access modifiers changed from: protected */
    public List<CommonLineParam> getDashLineParams() {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) this.lineParams)) {
            for (CommonLineParam commonLineParam : this.lineParams) {
                if (commonLineParam != null && MapElementId.ID_LINE_DROPOFF_END == commonLineParam.getId()) {
                    arrayList.add(commonLineParam);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<CommonMarkerParam> getShowMarkerParams() {
        ArrayList arrayList = new ArrayList();
        if (this.markerParams != null && !CollectionUtil.isEmpty((Collection<?>) this.markerParams)) {
            for (CommonMarkerParam commonMarkerParam : this.markerParams) {
                if (commonMarkerParam != null && (MapElementId.ID_MARKER_END == commonMarkerParam.getId() || MapElementId.ID_MARKER_DROP_OFF == commonMarkerParam.getId())) {
                    arrayList.add(commonMarkerParam);
                }
            }
        }
        return arrayList;
    }
}

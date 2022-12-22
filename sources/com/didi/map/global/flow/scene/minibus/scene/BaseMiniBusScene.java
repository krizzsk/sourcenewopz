package com.didi.map.global.flow.scene.minibus.scene;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;

public abstract class BaseMiniBusScene<P extends PageSceneParam> extends PageScene<P> {
    public BaseMiniBusScene(P p, MapViewHolder mapViewHolder) {
        super(p, mapViewHolder);
    }

    /* access modifiers changed from: protected */
    public MarkerModel paramConvertToMarkerModel(CommonMarkerParam commonMarkerParam) {
        if (commonMarkerParam == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        if (commonMarkerParam.getPoint() != null) {
            markerModel.setPoint(new LatLng(commonMarkerParam.getPoint().latitude, commonMarkerParam.getPoint().longitude));
        }
        markerModel.setAnchorU(commonMarkerParam.getAnchorU());
        markerModel.setAnchorV(commonMarkerParam.getAnchorV());
        markerModel.setMarkerIcon(commonMarkerParam.getMarkerIcon());
        markerModel.setId(commonMarkerParam.getId().name());
        markerModel.setZOrder(commonMarkerParam.getZIndex());
        return markerModel;
    }

    /* access modifiers changed from: protected */
    public Padding getDefaultPadding() {
        return new Padding(DisplayUtils.dp2px(getContext(), 10.0f), 0, DisplayUtils.dp2px(getContext(), 10.0f), DisplayUtils.dp2px(getContext(), 4.0f));
    }
}

package com.didi.hawaii.mapsdkv2.adapter.option;

import com.didi.hawaii.mapsdkv2.common.DataUtil;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLPolyline;
import com.didi.map.outer.model.PolylineOptions;

public final class GLPolylineOptionAdapter implements GLViewOptionAdapter<GLPolyline.Option, PolylineOptions> {
    public GLPolyline.Option get(PolylineOptions polylineOptions, GLViewManager gLViewManager) {
        if (!polylineOptions.isRoad()) {
            GLPolyline.Option option = new GLPolyline.Option();
            option.setAlpha(polylineOptions.getAlpha());
            option.setVisible(polylineOptions.isVisible());
            option.setZIndex(Integer.valueOf((int) polylineOptions.getZIndex()));
            option.setPts(DataUtil.latLng2array(polylineOptions.getPoints()));
            option.setWidth(polylineOptions.getWidth());
            option.setColor(polylineOptions.getColor());
            option.setForceLoad(polylineOptions.getIsForceLoad());
            return option;
        }
        throw new IllegalArgumentException("PolylineOptions.isRoad() can't be true, use GLRouteOptionAdapter instead.");
    }
}

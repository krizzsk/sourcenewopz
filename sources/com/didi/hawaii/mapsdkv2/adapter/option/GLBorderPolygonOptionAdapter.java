package com.didi.hawaii.mapsdkv2.adapter.option;

import com.didi.hawaii.mapsdkv2.common.DataUtil;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLBorderPolygon;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.outer.model.PolygonOptions;

public final class GLBorderPolygonOptionAdapter implements GLViewOptionAdapter<GLBorderPolygon.Option, PolygonOptions> {
    public GLBorderPolygon.Option get(PolygonOptions polygonOptions, GLViewManager gLViewManager) {
        GLBorderPolygon.Option option = new GLBorderPolygon.Option();
        option.setAlpha(1.0f);
        option.setForceLoad(polygonOptions.getIsForceLoad());
        option.setVisible(polygonOptions.isVisible());
        option.setZIndex(Integer.valueOf((int) polygonOptions.getZIndex()));
        option.setPts(DataUtil.latLng2array(polygonOptions.getPoints()));
        option.setColor(polygonOptions.getFillColor());
        option.setBellowRoute(polygonOptions.getIsBellowRoute());
        option.setClickable(polygonOptions.isClickable());
        option.setBorderWidth(polygonOptions.getStrokeWidth() / SystemUtil.getDensity(gLViewManager.getMapContext().getAndroidContext()));
        option.setBorderColor(polygonOptions.getStrokeColor());
        return option;
    }
}

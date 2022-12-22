package com.didi.hawaii.mapsdkv2.adapter.option;

import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLBorderCircle;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.outer.model.CircleOptions;
import com.didi.map.outer.model.LatLng;

public final class GLCircleOptionAdapter implements GLViewOptionAdapter<GLBorderCircle.Option, CircleOptions> {
    public GLBorderCircle.Option get(CircleOptions circleOptions, GLViewManager gLViewManager) {
        GLBorderCircle.Option option = new GLBorderCircle.Option();
        option.setAlpha(1.0f);
        option.setVisible(circleOptions.isVisible());
        option.setZIndex(Integer.valueOf((int) circleOptions.getZIndex()));
        option.setColor(circleOptions.getFillColor());
        option.setBorderColor(circleOptions.getStrokeColor());
        option.setIsMask(circleOptions.isMask());
        option.setBorderWidth(circleOptions.getStrokeWidth() / SystemUtil.getDensity(gLViewManager.getMapContext().getAndroidContext()));
        LatLng center = circleOptions.getCenter();
        if (center == null) {
            center = new LatLng(0.0d, 0.0d);
        }
        option.setCenter(center);
        option.setRadius((float) circleOptions.getRadius());
        return option;
    }
}

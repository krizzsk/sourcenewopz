package com.didi.hawaii.mapsdkv2.adapter.option;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarker;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarkerInfo;
import com.didi.map.outer.model.MarkerOptions;

public final class GLMarkerOptionAdapter implements GLViewOptionAdapter<GLMarker.Option, MarkerOptions> {
    public GLMarkerInfo.Option get(MarkerOptions markerOptions, GLViewManager gLViewManager) {
        GLMarkerInfo.Option option = new GLMarkerInfo.Option();
        option.setAlpha(markerOptions.getAlpha());
        option.setVisible(markerOptions.isVisible());
        option.setZIndex(Integer.valueOf((int) markerOptions.getZIndex()));
        option.setAvoidAnno(markerOptions.isAvoidAnnocation());
        option.setClockwise(markerOptions.isClockwise());
        option.setClickable(markerOptions.isClickable());
        option.setFlat(markerOptions.isFlat() || markerOptions.is3D());
        Bitmap bitmap = markerOptions.getIcon().getBitmap(gLViewManager.getMapContext().getAndroidContext());
        if (bitmap != null) {
            option.setTexture(Texture.bitmap(gLViewManager.getMapContext().getResources(), bitmap));
        }
        if (markerOptions.getInfoWindowOption() != null) {
            option.setBestViewInclude(markerOptions.getInfoWindowOption().bestViewInclude);
            option.setInfoWindowZindex(markerOptions.getInfoWindowOption().infoWindowZindex);
        }
        option.setPosition(markerOptions.getPosition().longitude, markerOptions.getPosition().latitude);
        option.setAnchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        option.setAngle(markerOptions.getRotateAngle());
        PointF scaleXY = markerOptions.getScaleXY();
        if (scaleXY != null) {
            option.setScale(scaleXY.x, scaleXY.y);
        }
        PointF offset = markerOptions.getOffset();
        if (offset != null) {
            option.setOffset(offset.x, offset.y);
        }
        option.setOrthographicProject(markerOptions.isNoDistanceScale());
        option.setBubbleId(markerOptions.getBubbleId());
        option.setIs2DGround(markerOptions.is2DGround());
        option.setGroundBounds(markerOptions.groundBounds());
        return option;
    }
}

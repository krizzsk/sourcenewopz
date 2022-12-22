package com.didi.hawaii.mapsdkv2.adapter.option;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.Resources;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLCollisionMarker;
import com.didi.hawaii.mapsdkv2.jni.DiAnimationType;
import com.didi.hawaii.mapsdkv2.jni.DiInterpolatorType;
import com.didi.hawaii.mapsdkv2.jni.MapVisibleChangeAnimateAttrs;
import com.didi.map.base.bubble.AnimationSetting;
import com.didi.map.outer.model.AnchorBitmapDescriptor;
import com.didi.map.outer.model.CollisionMarkerOption;
import java.util.ArrayList;

public class GLCollisionMarkerOptionAdapter implements GLViewOptionAdapter<GLCollisionMarker.Option, CollisionMarkerOption> {
    public static final GLCollisionMarkerOptionAdapter GL_COLLISION_MARKER_OPTION_ADAPTER = new GLCollisionMarkerOptionAdapter();

    public GLCollisionMarker.Option get(CollisionMarkerOption collisionMarkerOption, GLViewManager gLViewManager) {
        int i;
        int i2;
        GLCollisionMarker.Option option = new GLCollisionMarker.Option();
        option.setAlpha(collisionMarkerOption.getAlpha());
        option.setVisible(collisionMarkerOption.isVisible());
        option.setZIndex(Integer.valueOf((int) collisionMarkerOption.getZIndex()));
        option.setAvoidAnno(collisionMarkerOption.isAvoidAnnocation());
        option.setClockwise(collisionMarkerOption.isClockwise());
        option.setClickable(collisionMarkerOption.isClickable());
        option.setFlat(collisionMarkerOption.isFlat() || collisionMarkerOption.is3D());
        if (collisionMarkerOption.getPosition() != null) {
            option.setPosition(collisionMarkerOption.getPosition().longitude, collisionMarkerOption.getPosition().latitude);
        }
        option.setAngle(collisionMarkerOption.getRotateAngle());
        PointF scaleXY = collisionMarkerOption.getScaleXY();
        if (scaleXY != null) {
            option.setScale(scaleXY.x, scaleXY.y);
        }
        PointF offset = collisionMarkerOption.getOffset();
        if (offset != null) {
            option.setOffset(offset.x, offset.y);
        }
        option.setOrthographicProject(collisionMarkerOption.isNoDistanceScale());
        option.setType(collisionMarkerOption.getType());
        option.setCollisionType(collisionMarkerOption.getCollisionType());
        option.setGroupId(collisionMarkerOption.getGroupId());
        option.setPriority(collisionMarkerOption.getPriority());
        option.setInfoWindowCollied(collisionMarkerOption.isInfoWindowCollied());
        ArrayList arrayList = new ArrayList();
        for (AnchorBitmapDescriptor next : collisionMarkerOption.getAllAnchorBitmap()) {
            Bitmap bitmap = next.getBitmap(gLViewManager.getMapContext().getAndroidContext());
            Resources resources = gLViewManager.getMapContext().getResources();
            if (next.getWidth() == -1) {
                i = bitmap.getWidth();
            } else {
                i = next.getWidth();
            }
            if (next.getHeight() == -1) {
                i2 = bitmap.getHeight();
            } else {
                i2 = next.getHeight();
            }
            arrayList.add(Texture.anchorBitmap(resources, bitmap, i, i2, next.getAnchorX(), next.getAnchorY()));
        }
        CollisionMarkerOption.Section section = collisionMarkerOption.getSection();
        if (!(section == null || section.routePoints == null)) {
            GLCollisionMarker.Option.MarkerSection markerSection = new GLCollisionMarker.Option.MarkerSection();
            markerSection.points = section.routePoints;
            markerSection.startNums = new int[section.startNums.length];
            System.arraycopy(section.startNums, 0, markerSection.startNums, 0, section.startNums.length);
            markerSection.endNums = new int[section.endNums.length];
            System.arraycopy(section.endNums, 0, markerSection.endNums, 0, section.endNums.length);
            markerSection.routeID = section.routeID;
            markerSection.sectionCount = section.endNums.length;
            option.setPointArea(markerSection);
        }
        AnimationSetting animationSetting = collisionMarkerOption.getAnimationSetting();
        if (animationSetting != null) {
            MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs = new MapVisibleChangeAnimateAttrs();
            mapVisibleChangeAnimateAttrs.setNeedAnimate(animationSetting.needAnimation);
            mapVisibleChangeAnimateAttrs.setDuration((int) animationSetting.duration);
            int i3 = animationSetting.type;
            if (i3 == 0) {
                mapVisibleChangeAnimateAttrs.setAnimationType(DiAnimationType.DiAlpha);
            } else if (i3 != 1) {
                mapVisibleChangeAnimateAttrs.setAnimationType(DiAnimationType.DiAlpha);
            } else {
                mapVisibleChangeAnimateAttrs.setAnimationType(DiAnimationType.DiScale);
            }
            int i4 = animationSetting.interpolatorType;
            if (i4 == 0) {
                mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiLinear);
            } else if (i4 == 1) {
                mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiDecelerate);
            } else if (i4 == 2) {
                mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiFastOutSlow);
            } else if (i4 != 3) {
                mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiLinear);
            } else {
                mapVisibleChangeAnimateAttrs.setInterpolatorType(DiInterpolatorType.DiLinearOutSlow);
            }
            option.setAnimateAttrs(mapVisibleChangeAnimateAttrs);
        }
        option.setRects(arrayList);
        return option;
    }
}

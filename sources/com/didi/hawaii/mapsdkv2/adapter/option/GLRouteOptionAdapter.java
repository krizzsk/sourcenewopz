package com.didi.hawaii.mapsdkv2.adapter.option;

import android.graphics.Bitmap;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.common.DataUtil;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.MapPack;
import com.didi.hawaii.mapsdkv2.core.RouteName;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLRoute;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.outer.model.PolylineOptions;
import java.util.HashSet;
import java.util.List;

public final class GLRouteOptionAdapter implements GLViewOptionAdapter<GLRoute.Option, PolylineOptions> {

    /* renamed from: a */
    private static final HashSet<Integer> f23764a;

    static {
        HashSet<Integer> hashSet = new HashSet<>(8);
        f23764a = hashSet;
        hashSet.add(0);
        f23764a.add(1);
        f23764a.add(2);
        f23764a.add(3);
        f23764a.add(4);
        f23764a.add(6);
        f23764a.add(33);
    }

    public GLRoute.Option get(PolylineOptions polylineOptions, GLViewManager gLViewManager) {
        Texture texture;
        if (polylineOptions.isRoad()) {
            GLRoute.Option option = new GLRoute.Option();
            option.setAlpha(polylineOptions.getAlpha());
            option.setAnimateEnable(polylineOptions.isEnableRouteAnimate());
            option.setCollisionEnable(polylineOptions.isCollisionAble());
            option.setVisible(polylineOptions.isVisible());
            option.setZIndex(Integer.valueOf((int) polylineOptions.getZIndex()));
            option.setPts(DataUtil.latLng2array(polylineOptions.getNewPoints()));
            option.setOriginPts(DataUtil.latLng2array(polylineOptions.getPoints()));
            option.setWidth(polylineOptions.getWidth());
            option.setDrawCap(polylineOptions.getLineCap());
            option.setShowArrow(polylineOptions.isArrow());
            option.setArrowTextureName(polylineOptions.getArrowTextureName());
            int i = 6;
            if (polylineOptions.getLineType() == 6) {
                option.setLineType(5);
            } else {
                option.setLineType(polylineOptions.getLineType());
            }
            option.setErase(polylineOptions.isErase());
            int[][] colors = polylineOptions.getColors();
            if (polylineOptions.getLineType() == 5) {
                option.setTexture(new int[]{0}, new int[]{0}, Texture.customBitmap(polylineOptions.getColor()));
            } else if (polylineOptions.getLineType() == 7) {
                Bitmap customTextureBitmap = polylineOptions.getCustomTextureBitmap();
                if (customTextureBitmap == null || colors == null || colors.length < 2 || colors[0] == null || colors[1] == null) {
                    Texture texture2 = MapPack.POLYLINE_RAINBOW_TEXTURE;
                    int color = polylineOptions.getColor();
                    if (!f23764a.contains(Integer.valueOf(color))) {
                        color = 1;
                    }
                    option.setTexture(new int[]{0}, new int[]{color}, texture2);
                    HWLog.m16759d("自定义路线纹理资源出错", "");
                } else {
                    option.setTexture(colors[1], colors[0], Texture.bitmap(gLViewManager.getMapContext().getResources(), customTextureBitmap));
                }
            } else {
                if (polylineOptions.getTextureName() == null) {
                    texture = MapPack.POLYLINE_RAINBOW_TEXTURE;
                } else {
                    texture = Texture.mappack(polylineOptions.getTextureName(), polylineOptions.getTextureCount(), polylineOptions.getTextureCount());
                }
                if (colors != null) {
                    option.setTexture(colors[1], colors[0], texture);
                } else {
                    int textureCount = polylineOptions.getTextureCount();
                    int color2 = polylineOptions.getColor();
                    if (f23764a.contains(Integer.valueOf(color2))) {
                        i = color2;
                    }
                    if (textureCount > 0 && i >= textureCount) {
                        i = textureCount - 1;
                    }
                    option.setTexture(new int[]{0}, new int[]{i}, texture);
                }
            }
            if (polylineOptions.getRouteId() > 0) {
                option.setRouteNameKey(polylineOptions.getRouteId());
                option.setIsMainRoute(polylineOptions.isMainRoute());
            }
            List<RouteSectionWithName> list = polylineOptions.mRoadNames;
            if (list != null) {
                RouteName[] routeNameArr = new RouteName[list.size()];
                for (int i2 = 0; i2 < list.size(); i2++) {
                    RouteSectionWithName routeSectionWithName = list.get(i2);
                    routeNameArr[i2] = new RouteName(routeSectionWithName.startNum, routeSectionWithName.endNum, routeSectionWithName.color, routeSectionWithName.roadName);
                }
                option.setRouteNames(routeNameArr);
            }
            return option;
        }
        throw new IllegalArgumentException("PolylineOptions.isRoad() can't be false, use GLPolylineOptionAdapter instead.");
    }
}

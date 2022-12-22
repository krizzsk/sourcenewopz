package com.didi.hawaii.mapsdkv2.jni;

import android.graphics.Color;
import com.didi.hawaii.mapsdkv2.core.GLOverlayLayer;
import com.didi.map.outer.model.LatLng;

public final class JniHelper {
    private JniHelper() {
    }

    public static short[] color4DMapVector4ub(int i) {
        return new short[]{(short) Color.alpha(i), (short) Color.red(i), (short) Color.green(i), (short) Color.blue(i)};
    }

    public static DMapVector4f colorDMapVector4f(int i) {
        DMapVector4f dMapVector4f = new DMapVector4f();
        dMapVector4f.setA(((float) ((short) Color.alpha(i))) / 255.0f);
        dMapVector4f.setR(((float) ((short) Color.red(i))) / 255.0f);
        dMapVector4f.setG(((float) ((short) Color.green(i))) / 255.0f);
        dMapVector4f.setB(((float) ((short) Color.blue(i))) / 255.0f);
        return dMapVector4f;
    }

    public static DMapVector2f makeDMapVector2f(float f, float f2) {
        DMapVector2f dMapVector2f = new DMapVector2f();
        dMapVector2f.setX(f);
        dMapVector2f.setY(f2);
        return dMapVector2f;
    }

    public static DMapVector2d DMapVector4dForCoordinate(double d, double d2) {
        DMapVector2d dMapVector2d = new DMapVector2d();
        dMapVector2d.setX(((d + 180.0d) / 360.0d) * 2.68435456E8d);
        dMapVector2d.setY(((180.0d - (Math.log(Math.tan((d2 + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d)) / 360.0d) * 2.68435456E8d);
        return dMapVector2d;
    }

    public static LatLng Coordinate4dForDMapVector(DMapVector2d dMapVector2d) {
        return new LatLng((Math.atan(Math.exp((180.0d - ((dMapVector2d.getY() * 360.0d) / 2.68435456E8d)) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d, ((dMapVector2d.getX() * 360.0d) / 2.68435456E8d) - 180.0d);
    }

    public static int getZIndexStart(GLOverlayLayer gLOverlayLayer) {
        int i;
        if (gLOverlayLayer.equals(GLOverlayLayer.ROUTE)) {
            i = 9;
        } else if (gLOverlayLayer.equals(GLOverlayLayer.OVERLAY)) {
            i = 24;
        } else {
            i = gLOverlayLayer.equals(GLOverlayLayer.MASKLAYER) ? 3 : 0;
        }
        if (i != 0) {
            return MapEngineJNI.GetZIndexStart_Wrap(i);
        }
        throw new IllegalArgumentException("Unknown layer type, please fill in.");
    }

    public static long castAsLong(SWIGTYPE_p_void sWIGTYPE_p_void) {
        return SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void);
    }

    public static SWIGTYPE_p_void castAsPVoid(long j) {
        return new SWIGTYPE_p_void(j, false);
    }

    public static long getRouteAnimateManagerPtr(HWBSRAManager hWBSRAManager) {
        return HWBSRAManager.getCPtr(hWBSRAManager);
    }
}

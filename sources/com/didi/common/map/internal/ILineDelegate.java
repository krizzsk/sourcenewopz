package com.didi.common.map.internal;

import android.graphics.Bitmap;
import com.didi.common.map.model.GeoPoint;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import java.util.List;

public interface ILineDelegate extends IMapElementDelegate {

    /* renamed from: com.didi.common.map.internal.ILineDelegate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static GeoPoint $default$getTrueInsertPoint(ILineDelegate iLineDelegate) {
            return null;
        }

        public static void $default$insertPoint(ILineDelegate iLineDelegate, int i, LatLng latLng) {
        }

        public static void $default$insertPoint(ILineDelegate iLineDelegate, int i, LatLng latLng, int i2, int i3) {
        }

        public static void $default$modLineColor(ILineDelegate iLineDelegate, int i) {
        }

        public static void $default$setNaviRouteLineErase(ILineDelegate iLineDelegate, boolean z) {
        }

        public static void $default$setPulseBitmap(ILineDelegate iLineDelegate, Bitmap bitmap) {
        }

        public static void $default$setPulsePercent(ILineDelegate iLineDelegate, float f) {
        }
    }

    Bitmap getBitmap() throws MapNotExistApiException;

    int getColor() throws MapNotExistApiException;

    int getLineEndType() throws MapNotExistApiException;

    int getLineJoinType() throws MapNotExistApiException;

    LineOptions.MultiColorLineInfo[] getMultiColorLineInfo() throws MapNotExistApiException;

    List<LatLng> getPoints() throws MapNotExistApiException;

    int getStretchFactor() throws MapNotExistApiException;

    GeoPoint getTrueInsertPoint();

    double getWidth() throws MapNotExistApiException;

    void insertPoint(int i, LatLng latLng);

    void insertPoint(int i, LatLng latLng, int i2, int i3);

    void modLineColor(int i);

    void setBitmap(Bitmap bitmap) throws MapNotExistApiException;

    void setColor(int i) throws MapNotExistApiException;

    void setLineEndType(int i) throws MapNotExistApiException;

    void setLineJoinType(int i) throws MapNotExistApiException;

    void setMultiColorLineInfo(LineOptions.MultiColorLineInfo[] multiColorLineInfoArr) throws MapNotExistApiException;

    void setNaviRouteLineErase(boolean z);

    void setPoints(List<LatLng> list) throws MapNotExistApiException;

    void setPulseBitmap(Bitmap bitmap);

    void setPulsePercent(float f);

    void setStretchFactor(int i) throws MapNotExistApiException;

    void setWidth(double d) throws MapNotExistApiException;
}

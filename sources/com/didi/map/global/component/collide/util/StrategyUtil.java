package com.didi.map.global.component.collide.util;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.collide.common.DMarker;
import com.didi.map.global.component.collide.strategy2.RouteInfo;

public class StrategyUtil {
    public static boolean isMarkerInScreen(Marker marker, Map map) {
        if (marker == null || map == null || map.getProjection() == null) {
            return false;
        }
        PointF screenLocation = map.getProjection().toScreenLocation(marker.getPosition());
        return screenLocation.x > -1000.0f && screenLocation.x < 4000.0f && screenLocation.y > -1000.0f && screenLocation.y < 4000.0f;
    }

    public static Rect getLabelMarkerRectWithDirect(Map map, DMarker dMarker, int i) {
        if (!(dMarker == null || map == null || map.getProjection() == null)) {
            Marker marker = dMarker.mLabelMarker;
            Marker marker2 = dMarker.mRootMarker;
            if (!(marker == null || marker2 == null)) {
                int i2 = marker2.getMarkerSize().width;
                int i3 = marker2.getMarkerSize().height;
                if (dMarker.mRootMarkerPadding != null) {
                    i2 = (marker2.getMarkerSize().width - dMarker.mRootMarkerPadding.left) - dMarker.mRootMarkerPadding.right;
                    i3 = (marker2.getMarkerSize().height - dMarker.mRootMarkerPadding.top) - dMarker.mRootMarkerPadding.bottom;
                }
                int i4 = marker.getMarkerSize().width;
                int i5 = marker.getMarkerSize().height;
                if (dMarker.mLabelMarkerPadding != null) {
                    i4 = (marker.getMarkerSize().width - dMarker.mLabelMarkerPadding.left) - dMarker.mLabelMarkerPadding.right;
                    i5 = (marker.getMarkerSize().height - dMarker.mLabelMarkerPadding.top) - dMarker.mLabelMarkerPadding.bottom;
                }
                Rect markerRect = getMarkerRect(map, marker2, dMarker.mRootMarkerPadding, false);
                if (markerRect == null) {
                    return null;
                }
                Rect rect = new Rect();
                if (i == 16) {
                    rect.left = markerRect.left - i4;
                    rect.right = markerRect.left;
                    int i6 = (i5 - i3) / 2;
                    rect.top = markerRect.top - i6;
                    rect.bottom = markerRect.bottom + i6;
                } else if (i == 8) {
                    rect.left = markerRect.left - i4;
                    rect.right = markerRect.left;
                    rect.top = markerRect.bottom;
                    rect.bottom = markerRect.bottom + i5;
                } else if (i == 32) {
                    rect.left = markerRect.left - i4;
                    rect.right = markerRect.left;
                    rect.top = markerRect.top - i5;
                    rect.bottom = markerRect.top;
                } else if (i == 1) {
                    rect.left = markerRect.right;
                    rect.right = markerRect.right + i4;
                    int i7 = (i5 - i3) / 2;
                    rect.top = markerRect.top - i7;
                    rect.bottom = markerRect.bottom + i7;
                } else if (i == 2) {
                    rect.left = markerRect.right;
                    rect.right = markerRect.right + i4;
                    rect.top = markerRect.bottom;
                    rect.bottom = markerRect.bottom + i5;
                } else if (i == 128) {
                    rect.left = markerRect.right;
                    rect.right = markerRect.right + i4;
                    rect.top = markerRect.top - i5;
                    rect.bottom = markerRect.top;
                } else if (i == 64) {
                    int i8 = (i2 - i4) / 2;
                    rect.left = markerRect.left + i8;
                    rect.right = markerRect.right - i8;
                    rect.top = markerRect.top - i5;
                    rect.bottom = markerRect.top;
                } else if (i == 4) {
                    int i9 = (i2 - i4) / 2;
                    rect.left = markerRect.left + i9;
                    rect.right = markerRect.right - i9;
                    rect.top = markerRect.bottom;
                    rect.bottom = markerRect.bottom + i5;
                }
                return rect;
            }
        }
        return null;
    }

    public static Bitmap getDefaultAnchorBitmap() {
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    }

    public static int getDefaultDirect(RouteInfo routeInfo) {
        if (!(routeInfo == null || routeInfo.latLngs == null || routeInfo.latLngs.size() <= 1)) {
            LatLng latLng = routeInfo.latLngs.get(0);
            LatLng latLng2 = routeInfo.latLngs.get(routeInfo.latLngs.size() - 1);
            double computeHeading = (DDSphericalUtil.computeHeading(latLng, latLng2) + 360.0d) % 360.0d;
            if (computeHeading > 0.0d && computeHeading < 90.0d) {
                return 2;
            }
            if (computeHeading > 90.0d && computeHeading < 180.0d) {
                return 128;
            }
            if (computeHeading > 180.0d && computeHeading < 270.0d) {
                return 32;
            }
            if (computeHeading > 270.0d && computeHeading < 360.0d) {
                return 8;
            }
            if (Math.abs(latLng.latitude - latLng2.latitude) > 9.999999747378752E-6d && Math.abs(latLng.longitude - latLng2.longitude) <= 9.999999747378752E-6d) {
            }
        }
        return 2;
    }

    public static Rect getMarkerRect(Map map, Marker marker, Padding padding, boolean z) {
        if (marker == null || map == null || map.getProjection() == null || marker.getPosition() == null) {
            return null;
        }
        PointF screenLocation = map.getProjection().toScreenLocation(marker.getPosition());
        float anchorU = marker.getOptions().getAnchorU();
        float anchorV = marker.getOptions().getAnchorV();
        int i = marker.getMarkerSize().width;
        int i2 = marker.getMarkerSize().height;
        Rect rect = new Rect();
        float f = (float) i;
        rect.left = (int) (screenLocation.x - (f * anchorU));
        rect.right = (int) (screenLocation.x + (f * (1.0f - anchorU)));
        float f2 = (float) i2;
        rect.top = (int) (screenLocation.y - (f2 * anchorV));
        rect.bottom = (int) (screenLocation.y + (f2 * (1.0f - anchorV)));
        if (padding != null) {
            rect.left += padding.left;
            rect.right -= padding.right;
            rect.top += padding.top;
            rect.bottom -= padding.bottom;
        }
        if (z && marker.isInfoWindowShown()) {
            Marker infoWindowMarker = marker.getInfoWindow().getInfoWindowMarker();
            PointF screenLocation2 = map.getProjection().toScreenLocation(infoWindowMarker.getPosition());
            float anchorU2 = infoWindowMarker.getOptions().getAnchorU();
            float anchorV2 = infoWindowMarker.getOptions().getAnchorV();
            int i3 = infoWindowMarker.getMarkerSize().width;
            int i4 = infoWindowMarker.getMarkerSize().height;
            Rect rect2 = new Rect();
            float f3 = (float) i3;
            rect2.left = (int) (screenLocation2.x - (f3 * anchorU2));
            rect2.right = (int) (screenLocation2.x + (f3 * (1.0f - anchorU2)));
            float f4 = (float) i4;
            rect2.top = (int) (screenLocation2.y - (f4 * anchorV2));
            rect2.bottom = (int) (screenLocation2.y + (f4 * (1.0f - anchorV2)));
            rect.left = Math.min(rect.left, rect2.left);
            rect.right = Math.max(rect.right, rect2.right);
            rect.top = Math.min(rect.top, rect2.top);
            rect.bottom = Math.max(rect.bottom, rect2.bottom);
        }
        return rect;
    }

    public static boolean isIntersect(Rect rect, Rect rect2) {
        if (rect.left > rect2.right || rect.right < rect2.left) {
            DLog.m7384d("ccc", "isIntersect false: " + rect + "," + rect2, new Object[0]);
            return false;
        } else if (rect.top > rect2.bottom || rect.bottom < rect2.top) {
            DLog.m7384d("ccc", "isIntersect false: " + rect + "," + rect2, new Object[0]);
            return false;
        } else {
            DLog.m7384d("ccc", "isIntersect true: " + rect + "," + rect2, new Object[0]);
            return true;
        }
    }

    public static boolean isLineIntersectWithRect(Rect rect, PointF pointF, PointF pointF2) {
        if (rect == null || pointF2 == null || pointF == null) {
            return false;
        }
        DLog.m7384d("ccc", "isLineIntersectWithRect: rect=" + rect + ",lineStart=" + pointF + ",lineEnd=" + pointF2, new Object[0]);
        if (rect.contains((int) pointF.x, (int) pointF.y) || rect.contains((int) pointF2.x, (int) pointF2.y)) {
            return true;
        }
        PointF pointF3 = new PointF((float) rect.left, (float) rect.top);
        PointF pointF4 = new PointF((float) rect.left, (float) rect.bottom);
        if (m17703a(pointF, pointF2, pointF3, pointF4)) {
            return true;
        }
        PointF pointF5 = new PointF((float) rect.right, (float) rect.top);
        if (m17703a(pointF, pointF2, pointF3, pointF5)) {
            return true;
        }
        PointF pointF6 = new PointF((float) rect.right, (float) rect.bottom);
        if (!m17703a(pointF, pointF2, pointF5, pointF6) && !m17703a(pointF, pointF2, pointF4, pointF6)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m17703a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        if (Math.min(pointF.x, pointF2.x) > Math.max(pointF3.x, pointF4.x) || Math.min(pointF3.y, pointF4.y) > Math.max(pointF.y, pointF2.y) || Math.min(pointF3.x, pointF4.x) > Math.max(pointF.x, pointF2.x) || Math.min(pointF.y, pointF2.y) > Math.max(pointF3.y, pointF4.y)) {
            return false;
        }
        double d = (double) (((pointF.x - pointF3.x) * (pointF4.y - pointF3.y)) - ((pointF4.x - pointF3.x) * (pointF.y - pointF3.y)));
        double d2 = (double) (((pointF2.x - pointF3.x) * (pointF4.y - pointF3.y)) - ((pointF4.x - pointF3.x) * (pointF2.y - pointF3.y)));
        if (((double) (((pointF3.x - pointF.x) * (pointF2.y - pointF.y)) - ((pointF2.x - pointF.x) * (pointF3.y - pointF.y)))) * ((double) (((pointF4.x - pointF.x) * (pointF2.y - pointF.y)) - ((pointF2.x - pointF.x) * (pointF4.y - pointF.y)))) > 0.0d || d * d2 > 0.0d) {
            return false;
        }
        return true;
    }
}

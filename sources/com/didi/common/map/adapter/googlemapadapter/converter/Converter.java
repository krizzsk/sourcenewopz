package com.didi.common.map.adapter.googlemapadapter.converter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.TypedValue;
import com.didi.common.map.adapter.googlemapadapter.DDGoogleMap;
import com.didi.common.map.adapter.googlemapadapter.util.SystemUtil;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.GroundOverlay;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.VisibleRegion;
import com.didi.common.map.util.DLog;
import com.didi.entrega.customer.foundation.rpc.ApiErrorConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.SphericalUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Converter {

    /* renamed from: a */
    private static final int[] f10781a = {50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 25000, ApiErrorConst.Code.ERROR_50000, 100000, 200000, 500000, 1000000, 2000000};

    public static LatLng convertFromGoogleLatLng(com.google.android.gms.maps.model.LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new LatLng(latLng.latitude, latLng.longitude);
    }

    public static com.google.android.gms.maps.model.LatLng convertToGoogleLatLng(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new com.google.android.gms.maps.model.LatLng(latLng.latitude, latLng.longitude);
    }

    public static List<com.google.android.gms.maps.model.LatLng> convertToGoogleLatLngs(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (LatLng convertToGoogleLatLng : list) {
            arrayList.add(convertToGoogleLatLng(convertToGoogleLatLng));
        }
        return arrayList;
    }

    public static List<LatLng> convertFromGoogleLatLngs(List<com.google.android.gms.maps.model.LatLng> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (com.google.android.gms.maps.model.LatLng convertFromGoogleLatLng : list) {
            arrayList.add(convertFromGoogleLatLng(convertFromGoogleLatLng));
        }
        return arrayList;
    }

    public static PointF convertToPointF(Point point) {
        if (point == null) {
            return null;
        }
        return new PointF((float) point.x, (float) point.y);
    }

    public static Point convertToPoint(PointF pointF) {
        if (pointF == null) {
            return null;
        }
        return new Point((int) pointF.x, (int) pointF.y);
    }

    public static CameraUpdate convertToGoogleCameraUpdate(DDGoogleMap dDGoogleMap, com.didi.common.map.model.CameraUpdate cameraUpdate) {
        CameraUpdate cameraUpdate2 = null;
        if (!(cameraUpdate == null || cameraUpdate.getCameraUpdateParams() == null)) {
            CameraUpdate.CameraUpdateParams cameraUpdateParams = cameraUpdate.getCameraUpdateParams();
            if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.ZOOM_IN) {
                cameraUpdate2 = CameraUpdateFactory.zoomIn();
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.ZOOM_OUT) {
                cameraUpdate2 = CameraUpdateFactory.zoomOut();
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.ZOOM_TO) {
                cameraUpdate2 = CameraUpdateFactory.zoomTo((float) cameraUpdateParams.level);
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.ZOOM_BY) {
                cameraUpdate2 = CameraUpdateFactory.zoomBy((float) cameraUpdateParams.level);
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.CENTER) {
                cameraUpdate2 = CameraUpdateFactory.newLatLng(convertToGoogleLatLng(cameraUpdateParams.latLng));
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.CENTER_ZOOM) {
                cameraUpdate2 = cameraUpdateParams.level > 0.0d ? CameraUpdateFactory.newLatLngZoom(convertToGoogleLatLng(cameraUpdateParams.latLng), (float) cameraUpdateParams.level) : CameraUpdateFactory.newLatLng(convertToGoogleLatLng(cameraUpdateParams.latLng));
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.BOUNDS) {
                cameraUpdate2 = CameraUpdateFactory.newLatLngBounds(convertToGoogleLatLngBounds(cameraUpdateParams.latlngbounds), cameraUpdateParams.getPadding());
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.BOUNDS_RECT) {
                cameraUpdate2 = m7340a(dDGoogleMap, cameraUpdateParams.marginLeft, cameraUpdateParams.marginTop, cameraUpdateParams.marginRight, cameraUpdateParams.marginBom, (ArrayList<Marker>) null, cameraUpdateParams.latlngbounds.latLngList);
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.SCROLL_BY) {
                cameraUpdate2 = CameraUpdateFactory.scrollBy(cameraUpdateParams.scrollbyX, cameraUpdateParams.scrollbyY);
            } else if (cameraUpdateParams.type != CameraUpdate.CameraUpdateParams.CameraUpdateType.ROTATE_TO) {
                if (cameraUpdateParams.type != CameraUpdate.CameraUpdateParams.CameraUpdateType.ELEMENTS_BOUNDS_RECT) {
                    cameraUpdate2 = CameraUpdateFactory.newCameraPosition(new CameraPosition(convertToGoogleLatLng(cameraUpdateParams.latLng), (float) cameraUpdateParams.level, cameraUpdateParams.tilt, cameraUpdateParams.bearing));
                } else if (cameraUpdateParams.elements != null && !cameraUpdateParams.elements.isEmpty()) {
                    cameraUpdate2 = m7341a(cameraUpdateParams.elements, dDGoogleMap, cameraUpdateParams.marginLeft, cameraUpdateParams.marginTop, cameraUpdateParams.marginRight, cameraUpdateParams.marginBom);
                }
            }
            if (cameraUpdate2 == null) {
                DLog.m7384d("map", "zl map Converter convertToGoogleCameraUpdate convert is error, googleCU = null", new Object[0]);
            }
        }
        return cameraUpdate2;
    }

    /* renamed from: a */
    private static Padding m7339a(Context context, LatLngBounds latLngBounds, List<Marker> list, float f) {
        Context context2 = context;
        LatLngBounds latLngBounds2 = latLngBounds;
        float f2 = f;
        Padding padding = new Padding();
        if (!(list == null || list.isEmpty() || latLngBounds2 == null)) {
            PointF pointF = new PointF(SystemUtil.lng2Pixel(context2, latLngBounds2.northeast.longitude, f2), SystemUtil.lat2Pixel(context2, latLngBounds2.northeast.latitude, f2));
            PointF pointF2 = new PointF(SystemUtil.lng2Pixel(context2, latLngBounds2.southwest.longitude, f2), SystemUtil.lat2Pixel(context2, latLngBounds2.southwest.latitude, f2));
            PointF pointF3 = new PointF();
            for (Marker next : list) {
                if (next.getPosition() != null) {
                    PointF pointF4 = new PointF();
                    pointF4.x = SystemUtil.lng2Pixel(context2, next.getPosition().longitude, f2);
                    pointF4.y = SystemUtil.lat2Pixel(context2, next.getPosition().latitude, f2);
                    float anchorU = next.getOptions().getAnchorU();
                    float anchorV = next.getOptions().getAnchorV();
                    Marker.MarkerSize markerSize = next.getMarkerSize();
                    float f3 = ((float) markerSize.width) * anchorU;
                    float f4 = ((float) markerSize.width) - f3;
                    float f5 = ((float) markerSize.height) * anchorV;
                    float f6 = ((float) markerSize.height) - f5;
                    pointF3.x = pointF4.x - f3;
                    pointF3.y = pointF4.y - f5;
                    if (pointF2.x > pointF3.x && pointF2.x - pointF3.x > ((float) padding.left)) {
                        padding.left = (int) (pointF2.x - pointF3.x);
                    }
                    if (pointF3.y < pointF.y && pointF.y - pointF3.y > ((float) padding.top)) {
                        padding.top = (int) (pointF.y - pointF3.y);
                    }
                    pointF3.x = pointF4.x + f4;
                    pointF3.y = pointF4.y - f5;
                    if (pointF3.x > pointF.x && pointF3.x - pointF.x > ((float) padding.right)) {
                        padding.right = (int) (pointF3.x - pointF.x);
                    }
                    pointF3.x = pointF4.x - f3;
                    pointF3.y = pointF4.y + f6;
                    if (pointF3.y > pointF2.y && pointF3.y - pointF2.y > ((float) padding.bottom)) {
                        padding.bottom = (int) (pointF3.y - pointF2.y);
                    }
                    if (!(next.getInfoWindow() == null || next.getInfoWindow().getInfoWindowMarker() == null)) {
                        float f7 = ((float) markerSize.height) * anchorV;
                        Marker.MarkerSize markerSize2 = next.getInfoWindow().getInfoWindowMarker().getMarkerSize();
                        float anchorU2 = next.getInfoWindow().getInfoWindowMarker().getOptions().getAnchorU();
                        float anchorV2 = next.getInfoWindow().getInfoWindowMarker().getOptions().getAnchorV();
                        float f8 = ((float) markerSize2.width) * anchorU2;
                        float f9 = ((float) markerSize2.width) - f8;
                        float f10 = ((float) markerSize2.height) * anchorV2;
                        int i = markerSize2.height;
                        pointF3.x = pointF4.x - f8;
                        pointF3.y = (pointF4.y - f10) - f7;
                        if (pointF2.x > pointF3.x && pointF2.x - pointF3.x > ((float) padding.left)) {
                            padding.left = (int) (pointF2.x - pointF3.x);
                        }
                        if (pointF3.y < pointF.y && pointF.y - pointF3.y > ((float) padding.top)) {
                            padding.top = (int) (pointF.y - pointF3.y);
                        }
                        pointF3.x = pointF4.x + f9;
                        pointF3.y = (pointF4.y - f10) - f7;
                        if (pointF3.x > pointF.x && pointF3.x - pointF.x > ((float) padding.right)) {
                            padding.right = (int) (pointF3.x - pointF.x);
                        }
                        pointF3.x = pointF4.x - f8;
                        pointF3.y = pointF4.y - f7;
                        if (pointF3.y > pointF2.y && pointF3.y - pointF2.y > ((float) padding.bottom)) {
                            padding.bottom = (int) (pointF3.y - pointF2.y);
                        }
                    }
                    context2 = context;
                }
            }
        }
        return padding;
    }

    /* renamed from: a */
    private static com.google.android.gms.maps.CameraUpdate m7341a(List<IMapElement> list, DDGoogleMap dDGoogleMap, int i, int i2, int i3, int i4) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        dDGoogleMap.stopAnimation();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (IMapElement next : list) {
            if (next instanceof Line) {
                Line line = (Line) next;
                if (line.getBounderPoints() != null) {
                    arrayList2.addAll(line.getBounderPoints());
                }
            } else if (next instanceof Marker) {
                Marker marker = (Marker) next;
                arrayList.add(marker);
                if (marker.getPosition() != null) {
                    arrayList2.add(marker.getPosition());
                }
            } else if (next instanceof Circle) {
                Circle circle = (Circle) next;
                if (circle.getBounderPoints() != null) {
                    arrayList2.addAll(circle.getBounderPoints());
                }
            } else if (next instanceof GroundOverlay) {
                GroundOverlay groundOverlay = (GroundOverlay) next;
                if (groundOverlay.getBounderPoints() != null) {
                    arrayList2.addAll(groundOverlay.getBounderPoints());
                }
            } else if (next instanceof Polygon) {
                Polygon polygon = (Polygon) next;
                if (polygon.getBounderPoints() != null) {
                    arrayList2.addAll(polygon.getBounderPoints());
                }
            }
        }
        return m7340a(dDGoogleMap, i, i2, i3, i4, arrayList, arrayList2);
    }

    /* renamed from: a */
    private static com.google.android.gms.maps.CameraUpdate m7340a(DDGoogleMap dDGoogleMap, int i, int i2, int i3, int i4, ArrayList<Marker> arrayList, List<LatLng> list) {
        ArrayList<Marker> arrayList2 = arrayList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (LatLng include : list) {
            builder.include(include);
        }
        LatLngBounds build = builder.build();
        dDGoogleMap.calculateZoomToSpanLevel(build.northeast, build.southwest);
        float calculateZoomToSpanLevel = dDGoogleMap.calculateZoomToSpanLevel(i, i3, i2, i4, build.northeast, build.southwest, (LatLng) null);
        if (arrayList2 != null && !arrayList.isEmpty()) {
            Padding padding = new Padding();
            Padding a = m7339a(dDGoogleMap.getContext(), build, arrayList2, calculateZoomToSpanLevel);
            if (a.left + a.right + i + i3 < dDGoogleMap.getWidth() && a.top + a.bottom + i2 + i4 < dDGoogleMap.getHeight()) {
                padding = a;
            }
            DDGoogleMap dDGoogleMap2 = dDGoogleMap;
            float calculateZoomToSpanLevel2 = dDGoogleMap2.calculateZoomToSpanLevel(i + padding.left, i3 + padding.right, i2 + padding.top, i4 + padding.bottom, build.northeast, build.southwest, (LatLng) null);
            builder.include(m7342a(i, i2, i3, i4, list, dDGoogleMap.getContext(), build, arrayList, calculateZoomToSpanLevel2));
            build = builder.build();
        }
        com.google.android.gms.maps.model.LatLngBounds convertToGoogleLatLngBounds = convertToGoogleLatLngBounds(build);
        if (build != null) {
            return CameraUpdateFactory.newLatLngBounds(convertToGoogleLatLngBounds, 1);
        }
        return null;
    }

    /* renamed from: a */
    private static List<LatLng> m7342a(int i, int i2, int i3, int i4, List<LatLng> list, Context context, LatLngBounds latLngBounds, ArrayList<Marker> arrayList, float f) {
        List<LatLng> list2;
        int i5 = i4;
        List<LatLng> list3 = list;
        Context context2 = context;
        float f2 = f;
        if (arrayList == null || arrayList.isEmpty()) {
            return list3;
        }
        if (list3 == null || list.isEmpty()) {
            return list3;
        }
        int applyDimension = (int) (((float) i2) + TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics()));
        int applyDimension2 = (int) (((float) i) + TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()));
        int applyDimension3 = (int) (((float) i3) + TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()));
        if (applyDimension2 == 0 && applyDimension == 0 && applyDimension3 == 0 && i5 == 0) {
            int i6 = i5;
            list2 = list3;
        } else {
            LatLng latLng = list3.get(0);
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            LatLng latLng3 = new LatLng(latLng.latitude, latLng.longitude);
            LatLng latLng4 = new LatLng(latLng.latitude, latLng.longitude);
            LatLng latLng5 = new LatLng(latLng.latitude, latLng.longitude);
            int i7 = 1;
            while (i7 < list.size()) {
                LatLng latLng6 = list3.get(i7);
                if (latLng6.longitude < latLng2.longitude) {
                    latLng2.longitude = latLng6.longitude;
                    latLng2.latitude = latLng6.latitude;
                }
                if (latLng6.longitude > latLng4.longitude) {
                    latLng4.longitude = latLng6.longitude;
                    latLng4.latitude = latLng6.latitude;
                }
                if (latLng6.latitude > latLng3.latitude) {
                    latLng3.latitude = latLng6.latitude;
                    latLng3.longitude = latLng6.longitude;
                }
                if (latLng6.latitude < latLng5.latitude) {
                    latLng5.latitude = latLng6.latitude;
                    latLng5.longitude = latLng6.longitude;
                }
                i7++;
                int i8 = i4;
                list3 = list;
            }
            PointF pointF = new PointF();
            pointF.x = SystemUtil.lng2Pixel(context2, latLng2.longitude, f2);
            pointF.y = SystemUtil.lat2Pixel(context2, latLng2.latitude, f2);
            pointF.x -= (float) applyDimension2;
            list2 = list;
            list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF.x, f2)));
            pointF.x = SystemUtil.lng2Pixel(context2, latLng3.longitude, f2);
            pointF.y = SystemUtil.lat2Pixel(context2, latLng3.latitude, f2);
            pointF.y -= (float) applyDimension;
            list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF.x, f2)));
            pointF.x = SystemUtil.lng2Pixel(context2, latLng4.longitude, f2);
            pointF.y = SystemUtil.lat2Pixel(context2, latLng4.latitude, f2);
            pointF.x += (float) applyDimension3;
            list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF.x, f2)));
            pointF.x = SystemUtil.lng2Pixel(context2, latLng5.longitude, f2);
            pointF.y = SystemUtil.lat2Pixel(context2, latLng5.latitude, f2);
            pointF.y += (float) i4;
            list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF.x, f2)));
        }
        PointF pointF2 = new PointF();
        Iterator<Marker> it = arrayList.iterator();
        while (it.hasNext()) {
            Marker next = it.next();
            if (next.getPosition() != null) {
                PointF pointF3 = new PointF();
                pointF3.x = SystemUtil.lng2Pixel(context2, next.getPosition().longitude, f2);
                pointF3.y = SystemUtil.lat2Pixel(context2, next.getPosition().latitude, f2);
                float anchorU = next.getOptions().getAnchorU();
                float anchorV = next.getOptions().getAnchorV();
                Marker.MarkerSize markerSize = next.getMarkerSize();
                float f3 = ((float) markerSize.width) * anchorU;
                float f4 = ((float) markerSize.width) - f3;
                float f5 = ((float) markerSize.height) * anchorV;
                Iterator<Marker> it2 = it;
                float f6 = ((float) markerSize.height) - f5;
                float f7 = anchorV;
                Marker.MarkerSize markerSize2 = markerSize;
                float f8 = (float) applyDimension2;
                pointF2.x = (pointF3.x - f3) - f8;
                int i9 = applyDimension2;
                float f9 = (float) applyDimension;
                pointF2.y = (pointF3.y - f5) - f9;
                int i10 = applyDimension;
                Marker marker = next;
                float f10 = f8;
                list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF2.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF2.x, f2)));
                float f11 = (float) applyDimension3;
                pointF2.x = pointF3.x + f4 + f11;
                pointF2.y = (pointF3.y - f5) - f9;
                list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF2.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF2.x, f2)));
                pointF2.x = (pointF3.x - f3) - f10;
                int i11 = i4;
                float f12 = (float) i11;
                pointF2.y = pointF3.y + f6 + f12;
                float f13 = f9;
                int i12 = applyDimension3;
                list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF2.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF2.x, f2)));
                pointF2.x = pointF3.x + f4 + f11;
                pointF2.y = pointF3.y + f6 + f12;
                list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF2.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF2.x, f2)));
                if (!(marker.getInfoWindow() == null || marker.getInfoWindow().getInfoWindowMarker() == null)) {
                    float f14 = ((float) markerSize2.height) * f7;
                    Marker.MarkerSize markerSize3 = marker.getInfoWindow().getInfoWindowMarker().getMarkerSize();
                    float anchorU2 = marker.getInfoWindow().getInfoWindowMarker().getOptions().getAnchorU();
                    float anchorV2 = marker.getInfoWindow().getInfoWindowMarker().getOptions().getAnchorV();
                    float f15 = ((float) markerSize3.width) * anchorU2;
                    float f16 = ((float) markerSize3.width) - f15;
                    float f17 = ((float) markerSize3.height) * anchorV2;
                    int i13 = markerSize3.height;
                    pointF2.x = (pointF3.x - f15) - f10;
                    pointF2.y = ((pointF3.y - f17) - f14) - f13;
                    float f18 = f12;
                    list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF2.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF2.x, f2)));
                    pointF2.x = pointF3.x + f16 + f11;
                    pointF2.y = ((pointF3.y - f17) - f14) - f13;
                    list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF2.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF2.x, f2)));
                    pointF2.x = (pointF3.x - f15) - f10;
                    pointF2.y = (pointF3.y - f14) + f18;
                    list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF2.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF2.x, f2)));
                    pointF2.x = pointF3.x + f16 + f11;
                    pointF2.y = (pointF3.y - f14) + f18;
                    list2.add(new LatLng((double) SystemUtil.pixel2Lat(context2, (double) pointF2.y, f2), (double) SystemUtil.pixel2Lng(context2, (double) pointF2.x, f2)));
                }
                it = it2;
                applyDimension2 = i9;
                int i14 = i11;
                applyDimension = i10;
                applyDimension3 = i12;
            }
        }
        return list2;
    }

    public static CameraPosition convertToGoogleCameraPosition(com.didi.common.map.model.CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        return new CameraPosition(convertToGoogleLatLng(cameraPosition.target), (float) cameraPosition.zoom, cameraPosition.tilt, cameraPosition.bearing);
    }

    public static com.didi.common.map.model.CameraPosition convertFromGoogleCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        return new com.didi.common.map.model.CameraPosition(convertFromGoogleLatLng(cameraPosition.target), (double) cameraPosition.zoom, cameraPosition.tilt, cameraPosition.bearing);
    }

    public static com.google.android.gms.maps.model.LatLngBounds convertToGoogleLatLngBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return null;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(convertToGoogleLatLng(latLngBounds.southwest));
        builder.include(convertToGoogleLatLng(latLngBounds.northeast));
        if (latLngBounds.latLngList != null) {
            for (LatLng convertToGoogleLatLng : latLngBounds.latLngList) {
                builder.include(convertToGoogleLatLng(convertToGoogleLatLng));
            }
        }
        try {
            return builder.build();
        } catch (Exception e) {
            DLog.m7384d("gmap", "convertToGoogleLatLngBounds: " + e.toString(), new Object[0]);
            return null;
        }
    }

    public static VisibleRegion fromGoogleVisibleRegion(com.google.android.gms.maps.model.VisibleRegion visibleRegion) {
        if (visibleRegion == null) {
            return null;
        }
        return new VisibleRegion(convertFromGoogleLatLng(visibleRegion.nearRight), convertFromGoogleLatLng(visibleRegion.farRight), convertFromGoogleLatLng(visibleRegion.nearLeft), convertFromGoogleLatLng(visibleRegion.farLeft));
    }

    public static GoogleMap.CancelableCallback convertToGoogleCallback(final CancelableCallback cancelableCallback) {
        if (cancelableCallback == null) {
            return null;
        }
        return new GoogleMap.CancelableCallback() {
            public void onCancel() {
                cancelableCallback.onCancel();
            }

            public void onFinish() {
                cancelableCallback.onFinish();
            }
        };
    }

    public static MarkerOptions convertToGoogleMarkerOption(com.didi.common.map.model.MarkerOptions markerOptions) {
        if (markerOptions == null) {
            return null;
        }
        MarkerOptions markerOptions2 = new MarkerOptions();
        if (markerOptions.getTitle() != null) {
            markerOptions2.title(markerOptions.getTitle());
        }
        if (markerOptions.getSnippet() != null) {
            markerOptions2.snippet(markerOptions.getSnippet());
        }
        com.google.android.gms.maps.model.LatLng convertToGoogleLatLng = convertToGoogleLatLng(markerOptions.getPosition());
        if (convertToGoogleLatLng != null) {
            markerOptions2.position(convertToGoogleLatLng);
        }
        BitmapDescriptor convertToGoogleBitmapDescriptor = convertToGoogleBitmapDescriptor(markerOptions.getIcon());
        if (convertToGoogleBitmapDescriptor != null) {
            markerOptions2.icon(convertToGoogleBitmapDescriptor);
        }
        markerOptions2.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        markerOptions2.rotation(markerOptions.getRotation());
        markerOptions2.alpha(markerOptions.getAlpha());
        markerOptions2.visible(markerOptions.isVisible());
        markerOptions2.zIndex((float) markerOptions.getZIndex());
        markerOptions2.draggable(markerOptions.isDraggable());
        markerOptions2.flat(markerOptions.isFlat());
        return markerOptions2;
    }

    public static PolylineOptions convertToGooglePolyLineOption(LineOptions lineOptions) {
        if (lineOptions == null) {
            return null;
        }
        PolylineOptions polylineOptions = new PolylineOptions();
        List<com.google.android.gms.maps.model.LatLng> convertToGoogleLatLngs = convertToGoogleLatLngs(lineOptions.getPoints());
        if (convertToGoogleLatLngs != null) {
            polylineOptions.addAll(convertToGoogleLatLngs);
        }
        polylineOptions.color(lineOptions.getColor());
        polylineOptions.width((float) lineOptions.getWidth());
        polylineOptions.zIndex((float) lineOptions.getZIndex());
        polylineOptions.visible(lineOptions.isVisible());
        polylineOptions.clickable(lineOptions.isClickable());
        if (lineOptions.getType() == 2) {
            if (polylineOptions.getColor() == 0) {
                polylineOptions.color(Color.parseColor("#538bb8"));
            }
            polylineOptions.pattern(Arrays.asList(new PatternItem[]{new Dot(), new Gap(lineOptions.getSpacing())}));
        }
        LineOptions.MultiColorLineInfo[] multiColorLineInfo = lineOptions.getMultiColorLineInfo();
        if (multiColorLineInfo != null) {
            int[] iArr = new int[multiColorLineInfo.length];
            int[] iArr2 = new int[multiColorLineInfo.length];
            for (int i = 0; i < multiColorLineInfo.length; i++) {
                iArr[i] = multiColorLineInfo[i].colorIndex;
                iArr2[i] = multiColorLineInfo[i].pointIndex;
            }
        }
        int lineEndType = lineOptions.getLineEndType();
        return polylineOptions;
    }

    public static LineOptions convertFromGooglePolyLineOptions(PolylineOptions polylineOptions, Context context) {
        if (polylineOptions == null) {
            return null;
        }
        LineOptions lineOptions = new LineOptions();
        List<com.google.android.gms.maps.model.LatLng> points = polylineOptions.getPoints();
        ArrayList arrayList = new ArrayList(points.size());
        for (com.google.android.gms.maps.model.LatLng convertFromGoogleLatLng : points) {
            arrayList.add(convertFromGoogleLatLng(convertFromGoogleLatLng));
        }
        lineOptions.add((List<LatLng>) arrayList);
        lineOptions.color(polylineOptions.getColor());
        lineOptions.width((double) com.didi.common.map.util.SystemUtil.dip2px(context, polylineOptions.getWidth()));
        lineOptions.zIndex((int) polylineOptions.getZIndex());
        lineOptions.visible(polylineOptions.isVisible());
        return lineOptions;
    }

    public static PolygonOptions convertToGooglePolygonOptions(com.didi.common.map.model.PolygonOptions polygonOptions) {
        List<com.google.android.gms.maps.model.LatLng> convertToGoogleLatLngs;
        if (polygonOptions == null) {
            return null;
        }
        PolygonOptions polygonOptions2 = new PolygonOptions();
        List<com.google.android.gms.maps.model.LatLng> convertToGoogleLatLngs2 = convertToGoogleLatLngs(polygonOptions.getPoints());
        if (convertToGoogleLatLngs2 != null) {
            polygonOptions2.addAll(convertToGoogleLatLngs2);
        }
        polygonOptions2.fillColor(polygonOptions.getFillColor());
        polygonOptions2.strokeColor(polygonOptions.getStrokeColor());
        if (polygonOptions.getStrokeWidth() == -1.0f) {
            polygonOptions2.strokeWidth(0.0f);
        } else {
            polygonOptions2.strokeWidth(polygonOptions.getStrokeWidth());
        }
        polygonOptions2.visible(polygonOptions.isVisible());
        polygonOptions2.zIndex((float) polygonOptions.getZIndex());
        polygonOptions2.clickable(polygonOptions.isClickable());
        polygonOptions2.geodesic(polygonOptions.isGeodesic());
        List<List<LatLng>> holes = polygonOptions.getHoles();
        if (holes != null) {
            for (List next : holes) {
                if (!(next == null || (convertToGoogleLatLngs = convertToGoogleLatLngs(next)) == null)) {
                    polygonOptions2.addHole(convertToGoogleLatLngs);
                }
            }
        }
        if (polygonOptions.getPolygonPatternType() == 1) {
            polygonOptions2.strokePattern(Arrays.asList(new PatternItem[]{new Dash(polygonOptions.getDashLengthPx()), new Gap(polygonOptions.getGapLengthPx())}));
        }
        return polygonOptions2;
    }

    public static CircleOptions convertToGoogleCircleOptions(com.didi.common.map.model.CircleOptions circleOptions) {
        if (circleOptions == null) {
            return null;
        }
        CircleOptions circleOptions2 = new CircleOptions();
        double d = 0.0d;
        if (circleOptions.getCenter() == null) {
            circleOptions2.center(new com.google.android.gms.maps.model.LatLng(0.0d, 0.0d));
        } else {
            circleOptions2.center(convertToGoogleLatLng(circleOptions.getCenter()));
        }
        circleOptions2.fillColor(circleOptions.getFillColor());
        if (circleOptions.getRadius() > 0.0d) {
            d = circleOptions.getRadius();
        }
        circleOptions2.radius(d);
        circleOptions2.strokeColor(circleOptions.getStrokeColor());
        if (circleOptions.getStrokeWidth() == -1.0f) {
            circleOptions2.strokeWidth(0.0f);
        } else {
            circleOptions2.strokeWidth(circleOptions.getStrokeWidth());
        }
        circleOptions2.visible(circleOptions.isVisible());
        circleOptions2.zIndex((float) circleOptions.getZIndex());
        return circleOptions2;
    }

    public static int getBitmapSize(Bitmap bitmap) {
        if (SystemUtil.hasKitKat()) {
            return bitmap.getAllocationByteCount();
        }
        if (SystemUtil.hasHoneycombMR1()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static BitmapDescriptor convertToGoogleBitmapDescriptor(com.didi.common.map.model.BitmapDescriptor bitmapDescriptor) {
        if (!(bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled())) {
            try {
                return BitmapDescriptorFactory.fromBitmap(bitmapDescriptor.getBitmap());
            } catch (Exception e) {
                HashMap hashMap = new HashMap();
                hashMap.put("status", "-1");
                hashMap.put("message", "convertToGoogleBitmapDescriptor--->errorMessage" + e.getMessage());
                OmegaSDKAdapter.trackEvent("tech_marker_set_icon_status", "-1", hashMap);
            }
        }
        return null;
    }

    public static int calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double computeDistanceBetween = SphericalUtil.computeDistanceBetween(convertToGoogleLatLng(latLng), convertToGoogleLatLng(latLng2));
        int i5 = 0;
        while (true) {
            int[] iArr = f10781a;
            if (i5 >= iArr.length) {
                return 16;
            }
            if (((double) iArr[i5]) - ((((double) i3) + computeDistanceBetween) + ((double) i4)) > 0.0d) {
                return (18 - i5) + 3;
            }
            i5++;
        }
    }

    public static GroundOverlayOptions convertToGoogleGroundOverlayOptions(com.didi.common.map.model.GroundOverlayOptions groundOverlayOptions) {
        if (groundOverlayOptions == null) {
            return null;
        }
        GroundOverlayOptions groundOverlayOptions2 = new GroundOverlayOptions();
        BitmapDescriptor convertToGoogleBitmapDescriptor = convertToGoogleBitmapDescriptor(groundOverlayOptions.getImage());
        if (convertToGoogleBitmapDescriptor != null) {
            groundOverlayOptions2.image(convertToGoogleBitmapDescriptor);
        }
        groundOverlayOptions2.clickable(groundOverlayOptions.isClickable()).anchor(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV()).transparency(groundOverlayOptions.getAlpha()).clickable(groundOverlayOptions.isClickable()).zIndex((float) groundOverlayOptions.getZIndex());
        if (groundOverlayOptions.getPosition() != null) {
            groundOverlayOptions2.position(convertToGoogleLatLng(groundOverlayOptions.getPosition()), groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        } else if (groundOverlayOptions.getBounds() != null) {
            groundOverlayOptions2.positionFromBounds(convertToGoogleLatLngBounds(groundOverlayOptions.getBounds()));
        }
        return groundOverlayOptions2;
    }
}

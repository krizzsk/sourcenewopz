package com.didi.common.map.adapter.didiadapter.converter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.didi.common.map.adapter.didiadapter.DDMap;
import com.didi.common.map.adapter.didiadapter.TextureBitmapFactory;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.GeoPoint;
import com.didi.common.map.model.GroundOverlayOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.VisibleRegion;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.SystemUtil;
import com.didi.map.core.element.BaseClickBubbleParam;
import com.didi.map.core.element.MapAnnotation;
import com.didi.map.core.element.MapExtendIcon;
import com.didi.map.core.element.MapTrafficIcon;
import com.didi.map.core.element.OnMapElementClickListener;
import com.didi.map.outer.map.CameraUpdate;
import com.didi.map.outer.map.CameraUpdateFactory;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.BitmapDescriptorFactory;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.CircleOptions;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.MarkerOptions;
import com.didi.map.outer.model.MaskLayerOptions;
import com.didi.map.outer.model.PolygonOptions;
import com.didi.map.outer.model.PolylineOptions;
import com.didi.map.outer.model.animation.Animation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Converter {

    /* renamed from: a */
    private static String f10729a = "color_texture_driver_dark_didi.png";

    /* renamed from: b */
    private static String f10730b = "color_texture.png";

    /* renamed from: c */
    private static String f10731c = "color_texture_2.png";

    /* renamed from: d */
    private static final String f10732d = "color_point_texture_didi.png";

    /* renamed from: e */
    private static final String f10733e = "color_arrow_texture_didi.png";

    /* renamed from: f */
    private static final String f10734f = "color_point_texture_for_walk_blue_didi.png";

    /* renamed from: g */
    private static final String f10735g = "color_point_texture_for_walk_gray_didi.png";

    /* renamed from: h */
    private static final String f10736h = "color_point_texture_didi_gray.png";

    /* renamed from: i */
    private static final String f10737i = "di_ar_st_end_dot_line_global_2x.png";

    /* renamed from: j */
    private static final String f10738j = "color_texture_dot_dark.png";

    /* renamed from: k */
    private static final String f10739k = "color_texture_dot_light.png";

    public static LatLng convertFromDidiLatLng(com.didi.map.outer.model.LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new LatLng(latLng.latitude, latLng.longitude);
    }

    public static com.didi.map.outer.model.LatLng convertToDidiLatLng(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new com.didi.map.outer.model.LatLng(latLng.latitude, latLng.longitude);
    }

    public static List<com.didi.map.outer.model.LatLng> convertToDidiLatLngs(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (LatLng convertToDidiLatLng : list) {
            arrayList.add(convertToDidiLatLng(convertToDidiLatLng));
        }
        return arrayList;
    }

    public static List<LatLng> convertFromDidiLatLngs(List<com.didi.map.outer.model.LatLng> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (com.didi.map.outer.model.LatLng convertFromDidiLatLng : list) {
            arrayList.add(convertFromDidiLatLng(convertFromDidiLatLng));
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

    public static CameraUpdate convertToTencentCameraUpdate(DDMap dDMap, com.didi.common.map.model.CameraUpdate cameraUpdate) {
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
                cameraUpdate2 = CameraUpdateFactory.newLatLng(convertToDidiLatLng(cameraUpdateParams.latLng));
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.CENTER_ZOOM) {
                cameraUpdate2 = cameraUpdateParams.level > 0.0d ? CameraUpdateFactory.newLatLngZoom(convertToDidiLatLng(cameraUpdateParams.latLng), (float) cameraUpdateParams.level) : CameraUpdateFactory.newLatLng(convertToDidiLatLng(cameraUpdateParams.latLng));
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.BOUNDS) {
                cameraUpdate2 = CameraUpdateFactory.newLatLngBounds(convertToDidiLatLngBounds(cameraUpdateParams.latlngbounds), cameraUpdateParams.marginTop);
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.BOUNDS_RECT) {
                cameraUpdate2 = CameraUpdateFactory.newLatLngBoundsRect(convertToDidiLatLngBounds(cameraUpdateParams.latlngbounds), dDMap.getPadding().left + cameraUpdateParams.marginLeft, dDMap.getPadding().right + cameraUpdateParams.marginRight, dDMap.getPadding().top + cameraUpdateParams.marginTop, dDMap.getPadding().bottom + cameraUpdateParams.marginBom);
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.SCROLL_BY) {
                cameraUpdate2 = CameraUpdateFactory.scrollBy(cameraUpdateParams.scrollbyX, cameraUpdateParams.scrollbyY);
            } else if (cameraUpdateParams.type == CameraUpdate.CameraUpdateParams.CameraUpdateType.ROTATE_TO) {
                cameraUpdate2 = CameraUpdateFactory.rotateTo(360.0f - cameraUpdateParams.bearing, cameraUpdateParams.tilt);
            } else if (cameraUpdateParams.type != CameraUpdate.CameraUpdateParams.CameraUpdateType.ELEMENTS_BOUNDS_RECT) {
                cameraUpdate2 = CameraUpdateFactory.newCameraPosition(new CameraPosition(convertToDidiLatLng(cameraUpdateParams.latLng), (float) cameraUpdateParams.level, cameraUpdateParams.tilt, 360.0f - cameraUpdateParams.bearing));
            } else if (cameraUpdateParams.elements != null && !cameraUpdateParams.elements.isEmpty()) {
                cameraUpdate2 = m7324a(cameraUpdateParams.elements, dDMap, cameraUpdateParams.marginLeft, cameraUpdateParams.marginTop, cameraUpdateParams.marginRight, cameraUpdateParams.marginBom);
            }
            if (!(cameraUpdate2 == null || cameraUpdateParams == null)) {
                cameraUpdate2.getParams().alwaysAnimate = cameraUpdateParams.alwaysAnimate;
            }
        }
        return cameraUpdate2;
    }

    /* renamed from: a */
    private static com.didi.map.outer.map.CameraUpdate m7324a(List<IMapElement> list, DDMap dDMap, int i, int i2, int i3, int i4) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        dDMap.stopAnimation();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (IMapElement next : list) {
            if (next instanceof Marker) {
                Marker marker = (Marker) next;
                if (marker.getInfoWindow() != null && marker.getInfoWindow().isInfoWindowShown()) {
                    arrayList.add(marker.getInfoWindow().getInfoWindowMarker());
                }
            }
        }
        com.didi.map.outer.map.CameraUpdate newElementBoundsRect = CameraUpdateFactory.newElementBoundsRect(convertToDidiMapElements(arrayList), dDMap.getPadding().left + i, dDMap.getPadding().right + i3, dDMap.getPadding().top + i2, dDMap.getPadding().bottom + i4);
        dDMap.setPadding(0, 0, 0, 0);
        return newElementBoundsRect;
    }

    public static CameraPosition convertToDidiCameraPosition(com.didi.common.map.model.CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        return new CameraPosition(convertToDidiLatLng(cameraPosition.target), (float) cameraPosition.zoom, cameraPosition.tilt, 360.0f - cameraPosition.bearing);
    }

    public static com.didi.common.map.model.CameraPosition convertFromDidiCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        return new com.didi.common.map.model.CameraPosition(convertFromDidiLatLng(cameraPosition.target), (double) cameraPosition.zoom, cameraPosition.tilt, 360.0f - cameraPosition.bearing);
    }

    public static LatLngBounds convertToDidiLatLngBounds(com.didi.common.map.model.LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return null;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(convertToDidiLatLng(latLngBounds.southwest));
        builder.include(convertToDidiLatLng(latLngBounds.northeast));
        return builder.build();
    }

    public static VisibleRegion convertFromDidiVisibleRegion(com.didi.map.outer.model.VisibleRegion visibleRegion) {
        if (visibleRegion == null) {
            return null;
        }
        return new VisibleRegion(convertFromDidiLatLng(visibleRegion.nearRight), convertFromDidiLatLng(visibleRegion.farRight), convertFromDidiLatLng(visibleRegion.nearLeft), convertFromDidiLatLng(visibleRegion.farLeft));
    }

    public static DidiMap.CancelableCallback convertToDidiCallback(final CancelableCallback cancelableCallback) {
        if (cancelableCallback == null) {
            return null;
        }
        return new DidiMap.CancelableCallback() {
            public void onCancel() {
                cancelableCallback.onCancel();
            }

            public void onFinish() {
                cancelableCallback.onFinish();
            }
        };
    }

    public static MarkerOptions convertToDidiMarkerOption(GroundOverlayOptions groundOverlayOptions) {
        if (groundOverlayOptions == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        com.didi.map.outer.model.LatLng convertToDidiLatLng = convertToDidiLatLng(groundOverlayOptions.getPosition());
        if (convertToDidiLatLng != null) {
            markerOptions.position(convertToDidiLatLng);
        }
        BitmapDescriptor convertToDidiBitmapDescriptor = convertToDidiBitmapDescriptor(groundOverlayOptions.getImage());
        if (convertToDidiBitmapDescriptor != null) {
            markerOptions.icon(convertToDidiBitmapDescriptor);
        }
        markerOptions.anchor(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        markerOptions.rotateAngle(0.0f);
        markerOptions.clockwise(true);
        markerOptions.alpha(1.0f - groundOverlayOptions.getAlpha());
        markerOptions.visible(groundOverlayOptions.isVisible());
        markerOptions.zIndex((float) groundOverlayOptions.getZIndex());
        markerOptions.draggable(false);
        markerOptions.is3D(false);
        markerOptions.avoidAnnocation(false);
        markerOptions.displayLevel(groundOverlayOptions.getZIndex());
        markerOptions.clickable(groundOverlayOptions.isClickable());
        markerOptions.flat(true);
        markerOptions.ground(true);
        markerOptions.groundBounds(convertToDidiLatLngBounds(groundOverlayOptions.getBounds()));
        return markerOptions;
    }

    public static MarkerOptions convertToDidiMarkerOption(com.didi.common.map.model.MarkerOptions markerOptions) {
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
        com.didi.map.outer.model.LatLng convertToDidiLatLng = convertToDidiLatLng(markerOptions.getPosition());
        if (convertToDidiLatLng != null) {
            markerOptions2.position(convertToDidiLatLng);
        }
        BitmapDescriptor convertToDidiBitmapDescriptor = convertToDidiBitmapDescriptor(markerOptions.getIcon());
        if (convertToDidiBitmapDescriptor != null) {
            markerOptions2.icon(convertToDidiBitmapDescriptor);
        }
        markerOptions2.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        markerOptions2.rotateAngle(360.0f - markerOptions.getRotation());
        markerOptions2.clockwise(markerOptions.isClockwise());
        markerOptions2.alpha(markerOptions.getAlpha());
        markerOptions2.visible(markerOptions.isVisible());
        markerOptions2.zIndex((float) markerOptions.getZIndex());
        markerOptions2.draggable(markerOptions.isDraggable());
        markerOptions2.is3D(markerOptions.isFlat());
        markerOptions2.avoidAnnocation(markerOptions.isDodgeAnnotation());
        markerOptions2.displayLevel(markerOptions.getZIndex());
        markerOptions2.avoidAnnocation(markerOptions.isAvoidAnnocation());
        markerOptions2.clickable(markerOptions.isClickable());
        markerOptions2.flat(markerOptions.isFlat());
        return markerOptions2;
    }

    public static com.didi.common.map.model.MarkerOptions convertFromDidiMarkerOptions(MarkerOptions markerOptions, Context context) {
        if (markerOptions == null) {
            return null;
        }
        com.didi.common.map.model.MarkerOptions markerOptions2 = new com.didi.common.map.model.MarkerOptions();
        if (markerOptions.getTitle() != null) {
            markerOptions2.title(markerOptions.getTitle());
        }
        if (markerOptions.getSnippet() != null) {
            markerOptions2.snippet(markerOptions.getSnippet());
        }
        LatLng convertFromDidiLatLng = convertFromDidiLatLng(markerOptions.getPosition());
        if (convertFromDidiLatLng != null) {
            markerOptions2.position(convertFromDidiLatLng);
        }
        com.didi.common.map.model.BitmapDescriptor convertFromDidiBitmapDescriptor = convertFromDidiBitmapDescriptor(markerOptions.getIcon(), context);
        if (convertFromDidiBitmapDescriptor != null) {
            markerOptions2.icon(convertFromDidiBitmapDescriptor);
        }
        markerOptions2.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        markerOptions2.rotation(360.0f - markerOptions.getRotateAngle());
        markerOptions2.clockwise(markerOptions.isClockwise());
        markerOptions2.alpha(markerOptions.getAlpha());
        markerOptions2.visible(markerOptions.isVisible());
        markerOptions2.zIndex((int) markerOptions.getZIndex());
        markerOptions2.draggable(markerOptions.isDraggable());
        markerOptions2.flat(markerOptions.is3D());
        markerOptions2.dodgeAnnotation(markerOptions.isAvoidAnnocation());
        markerOptions2.clickable(markerOptions.isClickable());
        return markerOptions2;
    }

    public static PolylineOptions convertToDidiPolyLineOption(LineOptions lineOptions, Context context) {
        if (lineOptions == null) {
            return null;
        }
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.arrowTextureName(f10733e);
        List<LatLng> points = lineOptions.getPoints();
        ArrayList arrayList = new ArrayList(points.size());
        for (LatLng convertToDidiLatLng : points) {
            arrayList.add(convertToDidiLatLng(convertToDidiLatLng));
        }
        polylineOptions.setLineType(lineOptions.getType());
        polylineOptions.setLatLngs(arrayList);
        polylineOptions.color(lineOptions.getColor());
        polylineOptions.width((float) SystemUtil.px2dip(context, (float) lineOptions.getWidth()));
        polylineOptions.zIndex((float) lineOptions.getZIndex());
        polylineOptions.visible(lineOptions.isVisible());
        polylineOptions.arrow(lineOptions.hasDirectionArrow());
        polylineOptions.road(lineOptions.isRoad());
        polylineOptions.setRouteId(lineOptions.getRouteId());
        polylineOptions.insertNewRouteLatLngs(lineOptions.getGetRouteTrafficIndex(), convertToDidiLatLngs(lineOptions.getGetTrafficInsertPoint()));
        if (lineOptions.getType() == 2 || lineOptions.getType() == 5) {
            if (lineOptions.getType() == 5) {
                polylineOptions.setLineType(4);
            } else {
                polylineOptions.setLineType(2);
            }
            if (lineOptions.getDottedResType() == 1) {
                polylineOptions.setColorTexture(f10734f, "", 1);
            } else if (lineOptions.getDottedResType() == 2) {
                polylineOptions.setColorTexture(f10735g, "", 1);
            } else if (lineOptions.getDottedResType() == 3) {
                String customImageNameInAssets = lineOptions.getCustomImageNameInAssets();
                if (!TextUtils.isEmpty(customImageNameInAssets)) {
                    polylineOptions.setColorTexture(customImageNameInAssets, "", 1);
                } else {
                    polylineOptions.setColorTexture(f10732d, "", 1);
                }
            } else if (lineOptions.getDottedResType() == 4) {
                polylineOptions.setColorTexture(f10736h, "", 1);
            } else if (lineOptions.getDottedResType() == 5) {
                polylineOptions.setColorTexture(f10737i, "", 1);
            } else if (lineOptions.getDottedResType() == 6) {
                polylineOptions.setColorTexture(f10738j, "", 1);
            } else if (lineOptions.getDottedResType() == 7) {
                polylineOptions.setColorTexture(f10739k, "", 1);
            } else {
                polylineOptions.setColorTexture(f10732d, "", 1);
            }
        } else if (lineOptions.getType() == 4) {
            polylineOptions.setLineType(5);
        } else if (lineOptions.getType() == 1) {
            polylineOptions.setLineType(2);
            String customImageNameInAssets2 = lineOptions.getCustomImageNameInAssets();
            if (!TextUtils.isEmpty(customImageNameInAssets2)) {
                polylineOptions.setColorTexture(customImageNameInAssets2, "", 1);
            } else {
                polylineOptions.setColorTexture(f10732d, "", 1);
            }
        } else if (lineOptions.getType() == 6) {
            polylineOptions.setLineType(6);
        } else if (lineOptions.getType() == 0) {
            polylineOptions.setColorTexture(f10730b, "", 1);
        } else if (lineOptions.getType() == 7) {
            polylineOptions.setColorTexture(f10731c, "", 1);
            polylineOptions.setLineType(0);
        } else if (lineOptions.getType() == 8) {
            List<Integer> cusTextureBitmapColors = lineOptions.getCusTextureBitmapColors();
            if (!CollectionUtil.isEmpty((Collection<?>) cusTextureBitmapColors)) {
                Bitmap createBitmap = TextureBitmapFactory.createBitmap(cusTextureBitmapColors, (TextureBitmapFactory.TextureConfig) null);
                polylineOptions.setLineType(7);
                polylineOptions.setCustomTextureBitmap(createBitmap);
            }
        } else {
            polylineOptions.setColorTexture(f10729a, "", 12);
        }
        LineOptions.MultiColorLineInfo[] multiColorLineInfo = lineOptions.getMultiColorLineInfo();
        if (multiColorLineInfo != null) {
            int[] iArr = new int[multiColorLineInfo.length];
            int[] iArr2 = new int[multiColorLineInfo.length];
            for (int i = 0; i < multiColorLineInfo.length; i++) {
                iArr[i] = multiColorLineInfo[i].colorIndex;
                iArr2[i] = multiColorLineInfo[i].pointIndex;
            }
            polylineOptions.setColors(iArr, iArr2);
        }
        List<LineOptions.RouteWithName> routeNamesInfo = lineOptions.getRouteNamesInfo();
        ArrayList arrayList2 = new ArrayList();
        if (routeNamesInfo != null && !routeNamesInfo.isEmpty()) {
            for (LineOptions.RouteWithName next : routeNamesInfo) {
                if (next != null) {
                    PolylineOptions.RouteWithName routeWithName = new PolylineOptions.RouteWithName();
                    routeWithName.setColor(next.getColor());
                    routeWithName.setStartNum(next.getStartNum());
                    routeWithName.setEndNum(next.getEndNum());
                    routeWithName.setRoadName(next.getRoadName());
                    routeWithName.setType(next.getType());
                    arrayList2.add(routeWithName);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            polylineOptions.setRouteName(arrayList2);
        }
        int lineEndType = lineOptions.getLineEndType();
        if (lineEndType == 0) {
            polylineOptions.lineCap(false);
        } else if (lineEndType == 1) {
            polylineOptions.lineCap(true);
        }
        polylineOptions.setBezierInfo(lineOptions.getBezierOrder(), convertToDidiLatLngs(lineOptions.getBezierControlPoints()), lineOptions.isBezierUseDefaultControl());
        return polylineOptions;
    }

    public static LineOptions convertFromDidiPolyLineOptions(PolylineOptions polylineOptions, Context context) {
        if (polylineOptions == null) {
            return null;
        }
        LineOptions lineOptions = new LineOptions();
        List<com.didi.map.outer.model.LatLng> points = polylineOptions.getPoints();
        ArrayList arrayList = new ArrayList(points.size());
        for (com.didi.map.outer.model.LatLng convertFromDidiLatLng : points) {
            arrayList.add(convertFromDidiLatLng(convertFromDidiLatLng));
        }
        lineOptions.add((List<LatLng>) arrayList);
        lineOptions.color(polylineOptions.getColor());
        lineOptions.width((double) SystemUtil.px2dip(context, polylineOptions.getWidth()));
        lineOptions.zIndex((int) polylineOptions.getZIndex());
        lineOptions.visible(polylineOptions.isVisible());
        lineOptions.directionArrow(polylineOptions.isArrow());
        lineOptions.routeId(polylineOptions.getRouteId());
        if (polylineOptions.getLineCap()) {
            lineOptions.lineEndType(1);
        } else {
            lineOptions.lineEndType(0);
        }
        int[][] colors = polylineOptions.getColors();
        if (colors != null && colors.length == 2) {
            int[] iArr = colors[0];
            int[] iArr2 = colors[1];
            if (!(iArr == null || iArr2 == null || iArr.length != iArr2.length)) {
                LineOptions.MultiColorLineInfo[] multiColorLineInfoArr = new LineOptions.MultiColorLineInfo[iArr.length];
                for (int i = 0; i < iArr.length; i++) {
                    multiColorLineInfoArr[i] = new LineOptions.MultiColorLineInfo();
                    multiColorLineInfoArr[i].pointIndex = iArr2[i];
                    multiColorLineInfoArr[i].colorIndex = iArr[i];
                }
                lineOptions.multiColorLineInfo(multiColorLineInfoArr);
            }
        }
        lineOptions.setBezierInfo(polylineOptions.getBezierOrder(), convertFromDidiLatLngs(polylineOptions.getBezierControlPoints()), polylineOptions.isBezierUseDefaultControl());
        return lineOptions;
    }

    public static PolygonOptions convertToDidiPolygonOptions(com.didi.common.map.model.PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            return null;
        }
        PolygonOptions polygonOptions2 = new PolygonOptions();
        polygonOptions2.addAll(convertToDidiLatLngs(polygonOptions.getPoints()));
        polygonOptions2.fillColor(polygonOptions.getFillColor());
        polygonOptions2.strokeColor(polygonOptions.getStrokeColor());
        polygonOptions2.strokeWidth(polygonOptions.getStrokeWidth());
        polygonOptions2.visible(polygonOptions.isVisible());
        polygonOptions2.zIndex((float) polygonOptions.getZIndex());
        polygonOptions2.text(polygonOptions.getText());
        polygonOptions2.textColor(polygonOptions.getTextColor());
        polygonOptions2.textTypeface(polygonOptions.getTextTypeface());
        polygonOptions2.maxTextSize(polygonOptions.getMaxTextSize());
        polygonOptions2.minTextSize(polygonOptions.getMinTextSize());
        return polygonOptions2;
    }

    public static CircleOptions convertToDidiCircleOptions(com.didi.common.map.model.CircleOptions circleOptions) {
        if (circleOptions == null) {
            return null;
        }
        CircleOptions circleOptions2 = new CircleOptions();
        circleOptions2.center(convertToDidiLatLng(circleOptions.getCenter()));
        circleOptions2.fillColor(circleOptions.getFillColor());
        circleOptions2.radius(circleOptions.getRadius());
        circleOptions2.strokeColor(circleOptions.getStrokeColor());
        circleOptions2.strokeWidth(circleOptions.getStrokeWidth());
        circleOptions2.visible(circleOptions.isVisible());
        circleOptions2.zIndex((float) circleOptions.getZIndex());
        return circleOptions2;
    }

    public static MaskLayerOptions convertToDidiMaskLayerOptions(com.didi.common.map.model.MaskLayerOptions maskLayerOptions) {
        if (maskLayerOptions == null) {
            return null;
        }
        MaskLayerOptions maskLayerOptions2 = new MaskLayerOptions();
        maskLayerOptions2.color(maskLayerOptions.getColor());
        maskLayerOptions2.animationDuration(maskLayerOptions.getAnimationDuration());
        maskLayerOptions2.zIndex(maskLayerOptions.getZIndex());
        return maskLayerOptions2;
    }

    public static BitmapDescriptor convertToDidiBitmapDescriptor(com.didi.common.map.model.BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled()) {
            return null;
        }
        return BitmapDescriptorFactory.fromBitmap(bitmapDescriptor.getBitmap());
    }

    public static com.didi.common.map.model.BitmapDescriptor convertFromDidiBitmapDescriptor(BitmapDescriptor bitmapDescriptor, Context context) {
        if (bitmapDescriptor == null || context == null || bitmapDescriptor.getBitmap(context) == null || bitmapDescriptor.getBitmap(context).isRecycled()) {
            return null;
        }
        return com.didi.common.map.model.BitmapDescriptorFactory.fromBitmap(bitmapDescriptor.getBitmap(context));
    }

    public static List<com.didi.map.outer.model.IMapElement> convertToDidiMapElements(List<IMapElement> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (IMapElement element : list) {
            arrayList.add((com.didi.map.outer.model.IMapElement) element.getElement());
        }
        return arrayList;
    }

    public static OnMapElementClickListener convertToDidiMapElementClickListener(OnMapElementClickListener onMapElementClickListener) {
        if (onMapElementClickListener == null) {
            return null;
        }
        return new OnMapElementClickListener() {
            public void onAnnoClick(MapAnnotation mapAnnotation) {
            }

            public /* synthetic */ void onClickBubble(BaseClickBubbleParam baseClickBubbleParam) {
                OnMapElementClickListener.CC.$default$onClickBubble(this, baseClickBubbleParam);
            }

            public void onExtendIconClick(MapExtendIcon mapExtendIcon) {
            }

            public void onPoiIconClick(String str) {
            }

            public void onTrafficIconClick(MapTrafficIcon mapTrafficIcon) {
            }
        };
    }

    public static GeoPoint convertToDidiGeoPoint(com.didi.map.core.point.GeoPoint geoPoint) {
        return new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
    }

    public static Animation convertToDidiAnimation(com.didi.common.map.model.animation.Animation animation) {
        if (animation == null) {
            return null;
        }
        return m7325a(animation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b7  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.didi.map.outer.model.animation.Animation m7325a(com.didi.common.map.model.animation.Animation r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.didi.common.map.model.animation.Animation$AnimationType r1 = r8.getType()
            com.didi.common.map.model.animation.Animation$AnimationType r2 = com.didi.common.map.model.animation.Animation.AnimationType.ALPHA
            if (r1 != r2) goto L_0x001f
            r0 = r8
            com.didi.common.map.model.animation.AlphaAnimation r0 = (com.didi.common.map.model.animation.AlphaAnimation) r0
            com.didi.map.outer.model.animation.AlphaAnimation r1 = new com.didi.map.outer.model.animation.AlphaAnimation
            float r2 = r0.getFromAlpha()
            float r0 = r0.getToAlpha()
            r1.<init>(r2, r0)
        L_0x001c:
            r0 = r1
            goto L_0x00b5
        L_0x001f:
            com.didi.common.map.model.animation.Animation$AnimationType r2 = com.didi.common.map.model.animation.Animation.AnimationType.SCALE
            if (r1 != r2) goto L_0x003c
            r0 = r8
            com.didi.common.map.model.animation.ScaleAnimation r0 = (com.didi.common.map.model.animation.ScaleAnimation) r0
            com.didi.map.outer.model.animation.ScaleAnimation r1 = new com.didi.map.outer.model.animation.ScaleAnimation
            float r2 = r0.getFromX()
            float r3 = r0.getToX()
            float r4 = r0.getFromY()
            float r0 = r0.getToY()
            r1.<init>(r2, r3, r4, r0)
            goto L_0x001c
        L_0x003c:
            com.didi.common.map.model.animation.Animation$AnimationType r2 = com.didi.common.map.model.animation.Animation.AnimationType.TRANSLATE
            if (r1 != r2) goto L_0x0051
            r0 = r8
            com.didi.common.map.model.animation.TranslateAnimation r0 = (com.didi.common.map.model.animation.TranslateAnimation) r0
            com.didi.map.outer.model.animation.TranslateAnimation r1 = new com.didi.map.outer.model.animation.TranslateAnimation
            com.didi.common.map.model.LatLng r0 = r0.getTarget()
            com.didi.map.outer.model.LatLng r0 = convertToDidiLatLng(r0)
            r1.<init>(r0)
            goto L_0x001c
        L_0x0051:
            com.didi.common.map.model.animation.Animation$AnimationType r2 = com.didi.common.map.model.animation.Animation.AnimationType.ROTATE
            if (r1 != r2) goto L_0x0074
            r0 = r8
            com.didi.common.map.model.animation.RotateAnimation r0 = (com.didi.common.map.model.animation.RotateAnimation) r0
            com.didi.map.outer.model.animation.RotateAnimation r7 = new com.didi.map.outer.model.animation.RotateAnimation
            float r2 = r0.getFromDegree()
            float r3 = r0.getToDegree()
            float r4 = r0.getPivotX()
            float r5 = r0.getPivotY()
            float r6 = r0.getPivotZ()
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r0 = r7
            goto L_0x00b5
        L_0x0074:
            com.didi.common.map.model.animation.Animation$AnimationType r2 = com.didi.common.map.model.animation.Animation.AnimationType.EMERGE
            if (r1 != r2) goto L_0x0089
            r0 = r8
            com.didi.common.map.model.animation.EmergeAnimation r0 = (com.didi.common.map.model.animation.EmergeAnimation) r0
            com.didi.map.outer.model.animation.EmergeAnimation r1 = new com.didi.map.outer.model.animation.EmergeAnimation
            com.didi.common.map.model.LatLng r0 = r0.getStartPoint()
            com.didi.map.outer.model.LatLng r0 = convertToDidiLatLng(r0)
            r1.<init>(r0)
            goto L_0x001c
        L_0x0089:
            com.didi.common.map.model.animation.Animation$AnimationType r2 = com.didi.common.map.model.animation.Animation.AnimationType.SET
            if (r1 != r2) goto L_0x00b5
            r0 = r8
            com.didi.common.map.model.animation.AnimationSet r0 = (com.didi.common.map.model.animation.AnimationSet) r0
            com.didi.map.outer.model.animation.AnimationSet r1 = new com.didi.map.outer.model.animation.AnimationSet
            boolean r2 = r0.getShareInterpolator()
            r1.<init>(r2)
            java.util.ArrayList r0 = r0.getAllAnimations()
            java.util.Iterator r0 = r0.iterator()
        L_0x00a1:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001c
            java.lang.Object r2 = r0.next()
            com.didi.common.map.model.animation.Animation r2 = (com.didi.common.map.model.animation.Animation) r2
            com.didi.map.outer.model.animation.Animation r2 = m7325a(r2)
            r1.addAnimation(r2)
            goto L_0x00a1
        L_0x00b5:
            if (r0 == 0) goto L_0x00c5
            android.view.animation.Interpolator r1 = r8.getInterpolator()
            r0.setInterpolator(r1)
            long r1 = r8.getDuration()
            r0.setDuration(r1)
        L_0x00c5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.common.map.adapter.didiadapter.converter.Converter.m7325a(com.didi.common.map.model.animation.Animation):com.didi.map.outer.model.animation.Animation");
    }
}

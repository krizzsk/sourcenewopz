package com.didi.common.map;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.GroundOverlay;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BestViewer {

    /* renamed from: a */
    private static float f10680a = 16.0f;

    /* renamed from: b */
    private static int f10681b = 250;

    public interface IBestViewListener {
        void onFinished();
    }

    public static void doBestView_Animate(Map map, LatLng latLng, Padding padding) {
        doBestView(map, true, Float.valueOf(getDefaultZoomLevel()), latLng, padding, (IBestViewListener) null);
    }

    public static void doBestView_Move(Map map, LatLng latLng, Padding padding) {
        doBestView(map, false, Float.valueOf(getDefaultZoomLevel()), latLng, padding, (IBestViewListener) null);
    }

    public static void doBestView(Map map, boolean z, Float f, LatLng latLng, Padding padding, final IBestViewListener iBestViewListener) {
        if (map != null) {
            if (padding == null) {
                padding = map.getPadding();
            }
            map.setPadding(padding.left, padding.top, padding.right, padding.bottom);
            if (latLng != null) {
                CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLng, f.floatValue());
                if (z) {
                    map.animateCamera(newLatLngZoom, getDefaultDuration(), new CancelableCallback() {
                        public void onFinish() {
                            IBestViewListener iBestViewListener = iBestViewListener;
                            if (iBestViewListener != null) {
                                iBestViewListener.onFinished();
                            }
                        }

                        public void onCancel() {
                            IBestViewListener iBestViewListener = iBestViewListener;
                            if (iBestViewListener != null) {
                                iBestViewListener.onFinished();
                            }
                        }
                    });
                    return;
                }
                map.moveCamera(newLatLngZoom);
                if (iBestViewListener != null) {
                    iBestViewListener.onFinished();
                }
            }
        }
    }

    public static void doBestView(Map map, boolean z, LatLng latLng, List<LatLng> list, Padding padding, Padding padding2) {
        doBestView(map, z, latLng, list, padding, padding2, (IBestViewListener) null);
    }

    public static void doBestView(Map map, boolean z, LatLng latLng, List<LatLng> list, Padding padding, Padding padding2, IBestViewListener iBestViewListener) {
        if (map != null) {
            if (LatLngUtils.locateCorrect(latLng) || !CollectionUtil.isEmpty((Collection<?>) list)) {
                if (!LatLngUtils.locateCorrect(latLng) || !CollectionUtil.isEmpty((Collection<?>) list)) {
                    ArrayList arrayList = new ArrayList();
                    if (LatLngUtils.locateCorrect(latLng)) {
                        for (LatLng next : list) {
                            if (!latLng.equals(next)) {
                                arrayList.add(next);
                            }
                        }
                    } else {
                        arrayList.addAll(list);
                    }
                    if (arrayList.size() == 0) {
                        doBestView(map, z, Float.valueOf(getDefaultZoomLevel()), latLng, padding, iBestViewListener);
                    } else if (!LatLngUtils.locateCorrect(latLng) && arrayList.size() == 1) {
                        doBestView(map, z, Float.valueOf(getDefaultZoomLevel()), (LatLng) arrayList.get(0), padding, iBestViewListener);
                    } else if (map.getMapVendor() == MapVendor.DIDI || map.getMapVendor() == MapVendor.G_DIDI) {
                        m7297a(map, z, getDefaultDuration(), latLng, arrayList, padding, padding2, iBestViewListener);
                    } else {
                        m7299b(map, z, getDefaultDuration(), latLng, arrayList, padding, padding2, iBestViewListener);
                    }
                } else {
                    doBestView(map, z, Float.valueOf(getDefaultZoomLevel()), latLng, padding, iBestViewListener);
                }
            } else if (padding != null) {
                map.setPadding(padding.left, padding.top, padding.right, padding.bottom);
            }
        }
    }

    /* renamed from: a */
    private static void m7297a(Map map, boolean z, int i, LatLng latLng, List<LatLng> list, Padding padding, Padding padding2, final IBestViewListener iBestViewListener) {
        if (padding == null) {
            padding = map.getPadding();
        }
        Padding padding3 = padding;
        if (padding2 == null) {
            padding2 = new Padding(0, 0, 0, 0);
        }
        map.setPadding(padding3.left, padding3.top, padding3.right, padding3.bottom);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            builder.include(list.get(i2));
            if (latLng != null) {
                builder.include(MapUtils.getSymmetry(list.get(i2), latLng));
            }
        }
        if (latLng != null) {
            builder.include(latLng);
        }
        LatLngBounds build = builder.build();
        if (DDSphericalUtil.computeDistanceBetween(build.northeast, build.southwest) < 50.0d) {
            doBestView(map, z, Float.valueOf(20.0f), build.getCenter(), padding3, iBestViewListener);
            return;
        }
        CameraUpdate newLatLngBoundsRect = CameraUpdateFactory.newLatLngBoundsRect(build, padding2.left, padding2.right, padding2.top, padding2.bottom);
        if (z) {
            if (i == 0) {
                i = getDefaultDuration();
            }
            map.animateCamera(newLatLngBoundsRect, i, new CancelableCallback() {
                public void onFinish() {
                    IBestViewListener iBestViewListener = iBestViewListener;
                    if (iBestViewListener != null) {
                        iBestViewListener.onFinished();
                    }
                }

                public void onCancel() {
                    IBestViewListener iBestViewListener = iBestViewListener;
                    if (iBestViewListener != null) {
                        iBestViewListener.onFinished();
                    }
                }
            });
            return;
        }
        map.moveCamera(newLatLngBoundsRect);
        if (iBestViewListener != null) {
            iBestViewListener.onFinished();
        }
    }

    /* renamed from: b */
    private static void m7299b(Map map, boolean z, int i, LatLng latLng, List<LatLng> list, Padding padding, Padding padding2, final IBestViewListener iBestViewListener) {
        CameraUpdate cameraUpdate;
        if (padding == null) {
            padding = map.getPadding();
        }
        Padding padding3 = padding;
        if (padding2 == null) {
            padding2 = new Padding(0, 0, 0, 0);
        }
        DLog.m7384d("BestViewUtil", "set map padding: left:%s top:%s right:%s bottom:%s", Integer.valueOf(padding3.left), Integer.valueOf(padding3.top), Integer.valueOf(padding3.right), Integer.valueOf(padding3.bottom));
        map.setPadding(padding3.left, padding3.top, padding3.right, padding3.bottom);
        if (list != null && !list.isEmpty()) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                builder.include(list.get(i2));
            }
            if (latLng != null) {
                LatLngBounds recalculateBounds = MapUtils.recalculateBounds(builder.build(), latLng);
                Map map2 = map;
                cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, map2.calculateZoomToSpanLevel(padding2.left, padding2.right, padding2.top, padding2.bottom, new LatLng(recalculateBounds.northeast.latitude, recalculateBounds.southwest.longitude), new LatLng(recalculateBounds.southwest.latitude, recalculateBounds.northeast.longitude)));
            } else {
                cameraUpdate = CameraUpdateFactory.newLatLngBounds(builder.build(), 1);
            }
            if (z) {
                if (i == 0) {
                    i = getDefaultDuration();
                }
                map.animateCamera(cameraUpdate, i, new CancelableCallback() {
                    public void onFinish() {
                        IBestViewListener iBestViewListener = iBestViewListener;
                        if (iBestViewListener != null) {
                            iBestViewListener.onFinished();
                        }
                    }

                    public void onCancel() {
                        IBestViewListener iBestViewListener = iBestViewListener;
                        if (iBestViewListener != null) {
                            iBestViewListener.onFinished();
                        }
                    }
                });
                return;
            }
            map.moveCamera(cameraUpdate);
            if (iBestViewListener != null) {
                iBestViewListener.onFinished();
            }
        } else if (latLng != null) {
            doBestView(map, z, Float.valueOf(getDefaultZoomLevel()), latLng, padding3, (IBestViewListener) null);
        }
    }

    public static void doBestView(Map map, boolean z, List<IMapElement> list, Padding padding, Padding padding2, IBestViewListener iBestViewListener) {
        if (map != null) {
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                DLog.m7384d("BestViewUtil", "mapElements is empty", new Object[0]);
                if (padding != null) {
                    map.setPadding(padding.left, padding.top, padding.right, padding.bottom);
                    return;
                }
                return;
            }
            if (padding == null) {
                padding = map.getPadding();
            }
            Padding padding3 = padding;
            if (padding2 == null) {
                padding2 = new Padding();
            }
            Padding padding4 = padding2;
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (IMapElement next : list) {
                if (next instanceof Line) {
                    Line line = (Line) next;
                    if (line.getBounderPoints() != null) {
                        builder.include(line.getBounderPoints());
                    }
                } else if (next instanceof Marker) {
                    Marker marker = (Marker) next;
                    if (marker.getPosition() != null) {
                        builder.include(marker.getPosition());
                    }
                } else if (next instanceof Circle) {
                    Circle circle = (Circle) next;
                    if (circle.getBounderPoints() != null) {
                        builder.include(circle.getBounderPoints());
                    }
                } else if (next instanceof GroundOverlay) {
                    GroundOverlay groundOverlay = (GroundOverlay) next;
                    if (groundOverlay.getBounderPoints() != null) {
                        builder.include(groundOverlay.getBounderPoints());
                    }
                } else if (next instanceof Polygon) {
                    Polygon polygon = (Polygon) next;
                    if (polygon.getBounderPoints() != null) {
                        builder.include(polygon.getBounderPoints());
                    }
                }
            }
            LatLngBounds build = builder.build();
            if (DDSphericalUtil.computeDistanceBetween(build.northeast, build.southwest) < 5.0d) {
                DLog.m7384d("BestViewUtil", "map elements is near, < 5m", new Object[0]);
                doBestView(map, z, Float.valueOf(getDefaultZoomLevel()), build.getCenter(), padding3, iBestViewListener);
            } else if (map.getMapVendor() == MapVendor.DIDI || map.getMapVendor() == MapVendor.G_DIDI) {
                m7300b(map, z, getDefaultDuration(), list, padding3, padding4, iBestViewListener);
            } else if (map.getMapVendor() == MapVendor.GOOGLE || map.getMapVendor() == MapVendor.HUAWEI) {
                m7298a(map, z, getDefaultDuration(), list, padding3, padding4, iBestViewListener);
            }
        }
    }

    /* renamed from: a */
    private static void m7298a(Map map, boolean z, int i, List<IMapElement> list, Padding padding, Padding padding2, final IBestViewListener iBestViewListener) {
        if (map != null) {
            if (list == null || list.isEmpty()) {
                DLog.m7384d("BestViewUtil", "elements and latLngs is null", new Object[0]);
                return;
            }
            map.stopAnimation();
            map.setPadding(padding.left, padding.top, padding.right, padding.bottom);
            CameraUpdate newLatLngBoundRect = CameraUpdateFactory.newLatLngBoundRect(list, padding2.left, padding2.right, padding2.top, padding2.bottom);
            if (z) {
                if (i == 0) {
                    i = getDefaultDuration();
                }
                map.animateCamera(newLatLngBoundRect, i, new CancelableCallback() {
                    public void onFinish() {
                        IBestViewListener iBestViewListener = iBestViewListener;
                        if (iBestViewListener != null) {
                            iBestViewListener.onFinished();
                        }
                    }

                    public void onCancel() {
                        IBestViewListener iBestViewListener = iBestViewListener;
                        if (iBestViewListener != null) {
                            iBestViewListener.onFinished();
                        }
                    }
                });
                return;
            }
            map.moveCamera(newLatLngBoundRect);
            if (iBestViewListener != null) {
                iBestViewListener.onFinished();
            }
        }
    }

    /* renamed from: b */
    private static void m7300b(Map map, boolean z, int i, List<IMapElement> list, Padding padding, Padding padding2, final IBestViewListener iBestViewListener) {
        if (map != null) {
            if (list == null || list.isEmpty()) {
                DLog.m7384d("BestViewUtil", "elements and latLngs is null", new Object[0]);
                return;
            }
            map.stopAnimation();
            if (map.getPadding() != null && !map.getPadding().equals(padding)) {
                map.setPadding(padding.left, padding.top, padding.right, padding.bottom);
            }
            CameraUpdate newLatLngBoundRect = CameraUpdateFactory.newLatLngBoundRect(list, padding2.left, padding2.right, padding2.top, padding2.bottom);
            if (z) {
                if (i == 0) {
                    i = getDefaultDuration();
                }
                map.animateCamera(newLatLngBoundRect, i, new CancelableCallback() {
                    public void onFinish() {
                        IBestViewListener iBestViewListener = iBestViewListener;
                        if (iBestViewListener != null) {
                            iBestViewListener.onFinished();
                        }
                    }

                    public void onCancel() {
                        IBestViewListener iBestViewListener = iBestViewListener;
                        if (iBestViewListener != null) {
                            iBestViewListener.onFinished();
                        }
                    }
                });
                return;
            }
            map.moveCamera(newLatLngBoundRect);
            if (iBestViewListener != null) {
                iBestViewListener.onFinished();
            }
        }
    }

    public static void doBestView_Animate(Map map, int i, LatLng latLng, List<LatLng> list, Padding padding, Padding padding2, IBestViewListener iBestViewListener) {
        if (map != null) {
            if (LatLngUtils.locateCorrect(latLng) || !CollectionUtil.isEmpty((Collection<?>) list)) {
                if (!LatLngUtils.locateCorrect(latLng) || !CollectionUtil.isEmpty((Collection<?>) list)) {
                    ArrayList arrayList = new ArrayList();
                    if (LatLngUtils.locateCorrect(latLng)) {
                        for (LatLng next : list) {
                            if (!latLng.equals(next)) {
                                arrayList.add(next);
                            }
                        }
                    } else {
                        arrayList.addAll(list);
                    }
                    if (arrayList.size() == 0) {
                        doBestView_Animate(map, i, Float.valueOf(getDefaultZoomLevel()), latLng, padding, iBestViewListener);
                    } else if (!LatLngUtils.locateCorrect(latLng) && arrayList.size() == 1) {
                        doBestView_Animate(map, i, Float.valueOf(getDefaultZoomLevel()), (LatLng) arrayList.get(0), padding, iBestViewListener);
                    } else if (map.getMapVendor() == MapVendor.DIDI || map.getMapVendor() == MapVendor.G_DIDI) {
                        m7297a(map, true, i, latLng, arrayList, padding, padding2, iBestViewListener);
                    } else {
                        m7299b(map, true, i, latLng, arrayList, padding, padding2, iBestViewListener);
                    }
                } else {
                    doBestView_Animate(map, i, Float.valueOf(getDefaultZoomLevel()), latLng, padding, iBestViewListener);
                }
            } else if (padding != null) {
                map.setPadding(padding.left, padding.top, padding.right, padding.bottom);
            }
        }
    }

    public static void doBestView_Animate(Map map, int i, List<IMapElement> list, Padding padding, Padding padding2, IBestViewListener iBestViewListener) {
        if (map != null) {
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                DLog.m7384d("BestViewUtil", "mapElements is empty", new Object[0]);
                if (padding != null) {
                    map.setPadding(padding.left, padding.top, padding.right, padding.bottom);
                    return;
                }
                return;
            }
            if (padding == null) {
                padding = map.getPadding();
            }
            Padding padding3 = padding;
            if (padding2 == null) {
                padding2 = new Padding();
            }
            Padding padding4 = padding2;
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (IMapElement next : list) {
                if (next instanceof Line) {
                    Line line = (Line) next;
                    if (line.getBounderPoints() != null) {
                        builder.include(line.getBounderPoints());
                    }
                } else if (next instanceof Marker) {
                    Marker marker = (Marker) next;
                    if (marker.getPosition() != null) {
                        builder.include(marker.getPosition());
                    }
                } else if (next instanceof Circle) {
                    Circle circle = (Circle) next;
                    if (circle.getBounderPoints() != null) {
                        builder.include(circle.getBounderPoints());
                    }
                } else if (next instanceof GroundOverlay) {
                    GroundOverlay groundOverlay = (GroundOverlay) next;
                    if (groundOverlay.getBounderPoints() != null) {
                        builder.include(groundOverlay.getBounderPoints());
                    }
                } else if (next instanceof Polygon) {
                    Polygon polygon = (Polygon) next;
                    if (polygon.getBounderPoints() != null) {
                        builder.include(polygon.getBounderPoints());
                    }
                }
            }
            LatLngBounds build = builder.build();
            if (DDSphericalUtil.computeDistanceBetween(build.northeast, build.southwest) < 5.0d) {
                DLog.m7384d("BestViewUtil", "map elements is near, < 5m", new Object[0]);
                doBestView_Animate(map, i, Float.valueOf(getDefaultZoomLevel()), build.getCenter(), padding3, iBestViewListener);
            } else if (map.getMapVendor() == MapVendor.DIDI || map.getMapVendor() == MapVendor.G_DIDI) {
                m7300b(map, true, i, list, padding3, padding4, iBestViewListener);
            } else if (map.getMapVendor() == MapVendor.GOOGLE || map.getMapVendor() == MapVendor.HUAWEI) {
                m7298a(map, true, i, list, padding3, padding4, iBestViewListener);
            }
        }
    }

    public static void doBestView_Animate(Map map, int i, Float f, LatLng latLng, Padding padding, final IBestViewListener iBestViewListener) {
        if (map != null) {
            if (padding == null) {
                padding = map.getPadding();
            }
            if (padding != null) {
                map.setPadding(padding.left, padding.top, padding.right, padding.bottom);
                if (latLng != null) {
                    CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLng, f.floatValue());
                    if (i == 0) {
                        i = getDefaultDuration();
                    }
                    map.animateCamera(newLatLngZoom, i, new CancelableCallback() {
                        public void onFinish() {
                            IBestViewListener iBestViewListener = iBestViewListener;
                            if (iBestViewListener != null) {
                                iBestViewListener.onFinished();
                            }
                        }

                        public void onCancel() {
                            IBestViewListener iBestViewListener = iBestViewListener;
                            if (iBestViewListener != null) {
                                iBestViewListener.onFinished();
                            }
                        }
                    });
                }
            }
        }
    }

    public static float getDefaultZoomLevel() {
        return f10680a;
    }

    public static void setDefaultZoomLevel(float f) {
        f10680a = f;
    }

    public static void setDefaultDuration(int i) {
        f10681b = i;
    }

    public static int getDefaultDuration() {
        return f10681b;
    }
}

package com.didi.common.map.util;

import android.graphics.PointF;
import android.graphics.Rect;
import com.didi.common.map.Map;
import com.didi.common.map.Projection;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;

public class ProjectionUtils {
    public static boolean isRectIntersectWithRect(Rect rect, Rect rect2) {
        return Math.abs(((rect.left + rect.right) / 2) - ((rect2.left + rect2.right) / 2)) < (((rect.right - rect.left) + rect2.right) - rect2.left) / 2 && Math.abs(((rect.top + rect.bottom) / 2) - ((rect2.top + rect2.bottom) / 2)) < (((rect.bottom - rect.top) + rect2.bottom) - rect2.top) / 2;
    }

    public static List<LatLng> getInfoWindowBounderPoints(Projection projection, InfoWindow.Position position, Marker marker, int i, int i2) {
        float f;
        int i3;
        ArrayList arrayList = new ArrayList();
        if (projection == null || marker == null || marker.getIcon() == null || marker.getIcon().getBitmap() == null) {
            return arrayList;
        }
        LatLng position2 = marker.getPosition();
        MarkerOptions options = marker.getOptions();
        int width = marker.getIcon().getBitmap().getWidth();
        if (position == InfoWindow.Position.LEFT || position == InfoWindow.Position.LEFT_TOP || position == InfoWindow.Position.LEFT_BOTTOM) {
            float f2 = (float) width;
            f = f2 - (options.getAnchorU() * f2);
        } else {
            f = ((float) width) * options.getAnchorU();
        }
        int i4 = (int) f;
        int height = marker.getIcon().getBitmap().getHeight();
        if (position == InfoWindow.Position.BOTTOM || position == InfoWindow.Position.LEFT_BOTTOM || position == InfoWindow.Position.RIGHT_BOTTOM) {
            float f3 = (float) height;
            i3 = (int) (f3 - (options.getAnchorV() * f3));
        } else {
            i3 = (int) (((float) height) * marker.getOptions().getAnchorV());
        }
        PointF screenLocation = projection.toScreenLocation(position2);
        if (screenLocation == null) {
            return arrayList;
        }
        switch (C45091.$SwitchMap$com$didi$common$map$model$InfoWindow$Position[position.ordinal()]) {
            case 1:
                screenLocation.y -= (float) i3;
                break;
            case 2:
                screenLocation.y += (float) i3;
                break;
            case 3:
                screenLocation.x -= (float) i4;
                break;
            case 4:
                screenLocation.x -= (float) i4;
                screenLocation.y -= (float) i3;
                break;
            case 5:
                screenLocation.x -= (float) i4;
                screenLocation.y += (float) i3;
                break;
            case 6:
                screenLocation.x += (float) i4;
                break;
            case 7:
                screenLocation.x += (float) i4;
                screenLocation.y -= (float) i3;
                break;
            case 8:
                screenLocation.x += (float) i4;
                screenLocation.y += (float) i3;
                break;
        }
        LatLng fromScreenLocation = projection.fromScreenLocation(screenLocation);
        if (fromScreenLocation != null) {
            position2 = fromScreenLocation;
        }
        PointF screenLocation2 = projection.toScreenLocation(position2);
        if (screenLocation2 == null) {
            return arrayList;
        }
        switch (C45091.$SwitchMap$com$didi$common$map$model$InfoWindow$Position[position.ordinal()]) {
            case 1:
                return m7397a(projection, screenLocation2, i, i2);
            case 2:
                return m7398b(projection, screenLocation2, i, i2);
            case 3:
                return m7399c(projection, screenLocation2, i, i2);
            case 4:
                return m7400d(projection, screenLocation2, i, i2);
            case 5:
                return m7401e(projection, screenLocation2, i, i2);
            case 6:
                return m7402f(projection, screenLocation2, i, i2);
            case 7:
                return m7403g(projection, screenLocation2, i, i2);
            case 8:
                return m7404h(projection, screenLocation2, i, i2);
            default:
                return arrayList;
        }
    }

    /* renamed from: com.didi.common.map.util.ProjectionUtils$1 */
    static /* synthetic */ class C45091 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$model$InfoWindow$Position;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.common.map.model.InfoWindow$Position[] r0 = com.didi.common.map.model.InfoWindow.Position.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$model$InfoWindow$Position = r0
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.BOTTOM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.RIGHT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.common.map.util.ProjectionUtils.C45091.<clinit>():void");
        }
    }

    /* renamed from: a */
    private static List<LatLng> m7397a(Projection projection, PointF pointF, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        PointF pointF2 = new PointF();
        float f = (((float) i) * 1.0f) / 2.0f;
        pointF2.x = pointF.x - f;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x - f;
        float f2 = (float) i2;
        pointF2.y = pointF.y - f2;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x + f;
        pointF2.y = pointF.y - f2;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x + f;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        return arrayList;
    }

    /* renamed from: b */
    private static List<LatLng> m7398b(Projection projection, PointF pointF, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        PointF pointF2 = new PointF();
        float f = (((float) i) * 1.0f) / 2.0f;
        pointF2.x = pointF.x - f;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x - f;
        float f2 = (float) i2;
        pointF2.y = pointF.y + f2;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x + f;
        pointF2.y = pointF.y + f2;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x + f;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        return arrayList;
    }

    /* renamed from: c */
    private static List<LatLng> m7399c(Projection projection, PointF pointF, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        PointF pointF2 = new PointF();
        float f = (float) i;
        pointF2.x = pointF.x - f;
        float f2 = (((float) i2) * 1.0f) / 2.0f;
        pointF2.y = pointF.y + f2;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x - f;
        pointF2.y = pointF.y - f2;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x;
        pointF2.y = pointF.y - f2;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x;
        pointF2.y = pointF.y + f2;
        arrayList.add(projection.fromScreenLocation(pointF2));
        return arrayList;
    }

    /* renamed from: d */
    private static List<LatLng> m7400d(Projection projection, PointF pointF, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        PointF pointF2 = new PointF();
        pointF2.x = pointF.x;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x;
        float f = (float) i2;
        pointF2.y = pointF.y - f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        float f2 = (float) i;
        pointF2.x = pointF.x - f2;
        pointF2.y = pointF.y - f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x - f2;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        return arrayList;
    }

    /* renamed from: e */
    private static List<LatLng> m7401e(Projection projection, PointF pointF, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        PointF pointF2 = new PointF();
        pointF2.x = pointF.x;
        float f = (float) i2;
        pointF2.y = pointF.y + f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        float f2 = (float) i;
        pointF2.x = pointF.x - f2;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x - f2;
        pointF2.y = pointF.y + f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        return arrayList;
    }

    /* renamed from: f */
    private static List<LatLng> m7402f(Projection projection, PointF pointF, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        PointF pointF2 = new PointF();
        pointF2.x = pointF.x;
        float f = (((float) i2) * 1.0f) / 2.0f;
        pointF2.y = pointF.y + f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x;
        pointF2.y = pointF.y - f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        float f2 = (float) i;
        pointF2.x = pointF.x + f2;
        pointF2.y = pointF.y - f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x + f2;
        pointF2.y = pointF.y + f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        return arrayList;
    }

    /* renamed from: g */
    private static List<LatLng> m7403g(Projection projection, PointF pointF, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        PointF pointF2 = new PointF();
        pointF2.x = pointF.x;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x;
        float f = (float) i2;
        pointF2.y = pointF.y - f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        float f2 = (float) i;
        pointF2.x = pointF.x + f2;
        pointF2.y = pointF.y - f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x + f2;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        return arrayList;
    }

    /* renamed from: h */
    private static List<LatLng> m7404h(Projection projection, PointF pointF, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        PointF pointF2 = new PointF();
        pointF2.x = pointF.x;
        float f = (float) i2;
        pointF2.y = pointF.y + f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        float f2 = (float) i;
        pointF2.x = pointF.x + f2;
        pointF2.y = pointF.y;
        arrayList.add(projection.fromScreenLocation(pointF2));
        pointF2.x = pointF.x + f2;
        pointF2.y = pointF.y + f;
        arrayList.add(projection.fromScreenLocation(pointF2));
        return arrayList;
    }

    public static Rect getInfoWindowRect(Projection projection, List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<PointF> arrayList = new ArrayList<>();
        for (LatLng screenLocation : list) {
            PointF screenLocation2 = projection.toScreenLocation(screenLocation);
            if (screenLocation2 == null) {
                return null;
            }
            arrayList.add(screenLocation2);
        }
        if (arrayList.size() != 4) {
            return null;
        }
        PointF pointF = (PointF) arrayList.get(0);
        float f = pointF.x;
        float f2 = pointF.y;
        float f3 = pointF.x;
        float f4 = pointF.y;
        for (PointF pointF2 : arrayList) {
            if (pointF2.x < f) {
                f = pointF2.x;
            }
            if (pointF2.y < f2) {
                f2 = pointF2.y;
            }
            if (pointF2.x > f3) {
                f3 = pointF2.x;
            }
            if (pointF2.y > f4) {
                f4 = pointF2.y;
            }
        }
        return new Rect((int) f, (int) f2, (int) f3, (int) f4);
    }

    public static boolean isLatLngInRect(Projection projection, Rect rect, LatLng latLng) {
        PointF screenLocation = projection.toScreenLocation(latLng);
        int i = (int) screenLocation.x;
        int i2 = (int) screenLocation.y;
        return i > rect.left && i < rect.right && i2 > rect.top && i2 < rect.bottom;
    }

    /* renamed from: a */
    private double m7396a(Map map, LatLng latLng, LatLng latLng2) {
        if (map == null || map.getProjection() == null || latLng == null || latLng2 == null) {
            return -1.0d;
        }
        Projection projection = map.getProjection();
        PointF screenLocation = projection.toScreenLocation(latLng);
        PointF screenLocation2 = projection.toScreenLocation(latLng2);
        return Math.sqrt(Math.pow((double) Math.abs(screenLocation.x - screenLocation2.x), 2.0d) + Math.pow((double) Math.abs(screenLocation.y - screenLocation2.y), 2.0d));
    }
}

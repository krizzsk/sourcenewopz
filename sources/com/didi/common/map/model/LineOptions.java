package com.didi.common.map.model;

import android.graphics.Bitmap;
import com.didi.common.map.internal.IMapElementOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LineOptions extends IMapElementOptions {
    public static final int LINE_END_TYPE_ROUND = 1;
    public static final int LINE_END_TYPE_STRAIGHT = 0;
    public static final int LINE_JOINT_TYPE_NONE = 0;
    public static final int LINE_JOINT_TYPE_ROUND = 2;
    public static final int LINE_JOINT_TYPE_STRAIGHT = 1;

    /* renamed from: a */
    private List<LatLng> f10833a;

    /* renamed from: b */
    private double f10834b;

    /* renamed from: c */
    private int f10835c;

    /* renamed from: d */
    private Bitmap f10836d;

    /* renamed from: e */
    private int f10837e;

    /* renamed from: f */
    private int f10838f;

    /* renamed from: g */
    private int f10839g;

    /* renamed from: h */
    private List<LatLng> f10840h;

    /* renamed from: i */
    private List<Integer> f10841i;

    /* renamed from: j */
    private long f10842j;

    /* renamed from: k */
    private String f10843k;

    /* renamed from: l */
    private float f10844l;

    /* renamed from: m */
    private int f10845m;

    /* renamed from: n */
    private boolean f10846n;

    /* renamed from: o */
    private boolean f10847o;

    /* renamed from: p */
    private int f10848p;

    /* renamed from: q */
    private List<LatLng> f10849q;

    /* renamed from: r */
    private boolean f10850r;

    /* renamed from: s */
    private boolean f10851s;

    /* renamed from: t */
    private int f10852t;

    /* renamed from: u */
    private String f10853u;

    /* renamed from: v */
    private int f10854v;

    /* renamed from: w */
    private MultiColorLineInfo[] f10855w;

    /* renamed from: x */
    private List<RouteWithName> f10856x;

    /* renamed from: y */
    private boolean f10857y;

    /* renamed from: z */
    private List<Integer> f10858z;

    public static class COLOR {
        public static final int BLACK_262B2E = 11;
        public static final int BLUE_00BEFF = 24;
        public static final int BLUE_33BBFF = 23;
        public static final int BLUE_5DA2ED = 1;
        public static final int BLUE_61ADD3 = 1;
        public static final int BLUE_65D8FF = 25;
        public static final int BLUE_7CB5F3 = 6;
        public static final int BLUE_A6DFFF = 29;
        public static final int BLUE_A7CEFC = 9;
        public static final int BLUE_B4E6FF = 2;
        public static final int BLUE_BDDAF9 = 5;
        public static final int GREEN_4CC186 = 4;
        public static final int GREY_C2C2C2 = 0;
        public static final int RED_B63C47 = 10;
        public static final int RED_E96461 = 2;
        public static final int TRANSPARENT = 0;
        public static final int WHITE_2 = 8;
        public static final int WRITE_1 = 7;
        public static final int YELLOW_F4C286 = 3;
    }

    public static class DottedResType {
        public static final int ARROW_BULE = 1;
        public static final int ARROW_GRAY = 2;
        public static final int DEFAUT = 0;
        public static final int DOT_BLUE = 5;
        public static final int DOT_GRAY = 4;
        public static final int DOT_INNER_DARK = 6;
        public static final int DOT_INNER_LIGHT = 7;
        public static final int USE_CUSTOM_IMAGE = 3;
    }

    public static final class LineType {
        public static final int LINE_TYPE_ANIMATION = 6;
        public static final int LINE_TYPE_ARGB = 4;
        public static final int LINE_TYPE_DOTTED = 2;
        public static final int LINE_TYPE_DOTTED_ANIMATION = 5;
        public static final int LINE_TYPE_IMAGEINARY = 1;
        public static final int LINE_TYPE_MULTICOLOR = 0;
        public static final int LINE_TYPE_MULTICOLOR_2 = 7;
        public static final int LINE_TYPE_MULTICOLOR_BITMAP = 8;
    }

    public static final class MultiColorLineInfo {
        public int colorIndex;
        public int pointIndex;
    }

    public LineOptions() {
        this.f10834b = 36.0d;
        this.f10835c = 0;
        this.f10837e = 0;
        this.f10838f = 2;
        this.f10839g = 1;
        this.f10842j = 0;
        this.f10843k = "";
        this.f10845m = 0;
        this.f10846n = true;
        this.f10847o = false;
        this.f10848p = 0;
        this.f10850r = false;
        this.f10851s = false;
        this.f10852t = 4;
        this.f10854v = 0;
        this.f10857y = true;
        this.f10834b = 36.0d;
        this.mZIndex = 0;
        this.f10844l = 200.0f;
        this.mVisible = true;
        this.f10857y = true;
        this.f10839g = 0;
        this.f10845m = 0;
        this.f10833a = new ArrayList();
        this.f10848p = 0;
        this.f10849q = new ArrayList();
        this.f10850r = false;
    }

    public List<LatLng> getGetTrafficInsertPoint() {
        return this.f10840h;
    }

    public void setGetTrafficInsertPoint(List<LatLng> list) {
        this.f10840h = list;
    }

    public void setCusTextureBitmapColors(List<Integer> list) {
        this.f10858z = list;
    }

    public List<Integer> getCusTextureBitmapColors() {
        return this.f10858z;
    }

    public List<Integer> getGetRouteTrafficIndex() {
        return this.f10841i;
    }

    public void setGetRouteTrafficIndex(List<Integer> list) {
        this.f10841i = list;
    }

    public List<LatLng> getPoints() {
        return this.f10833a;
    }

    public LineOptions setPoints(List<LatLng> list) {
        this.f10833a = list;
        return this;
    }

    public LineOptions customImageNameInAssets(String str) {
        this.f10843k = str;
        return this;
    }

    public String getCustomImageNameInAssets() {
        return this.f10843k;
    }

    public LineOptions add(LatLng latLng) {
        this.f10833a.add(latLng);
        return this;
    }

    public LineOptions add(LatLng... latLngArr) {
        this.f10833a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public LineOptions add(List<LatLng> list) {
        this.f10833a.addAll(list);
        return this;
    }

    public LineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable == null) {
            return this;
        }
        for (LatLng next : iterable) {
            if (next != null) {
                this.f10833a.add(next);
            }
        }
        return this;
    }

    public LineOptions road(boolean z) {
        this.f10857y = z;
        return this;
    }

    public boolean isRoad() {
        return this.f10857y;
    }

    public LineOptions spacing(float f) {
        this.f10844l = f;
        return this;
    }

    public LineOptions routeId(long j) {
        this.f10842j = j;
        return this;
    }

    public long getRouteId() {
        return this.f10842j;
    }

    public float getSpacing() {
        return this.f10844l;
    }

    public double getWidth() {
        return this.f10834b;
    }

    public LineOptions width(double d) {
        this.f10834b = d;
        return this;
    }

    public int getColor() {
        return this.f10835c;
    }

    public LineOptions color(int i) {
        this.f10835c = i;
        return this;
    }

    public LineOptions dottedResType(int i) {
        this.f10845m = i;
        return this;
    }

    public int getDottedResType() {
        return this.f10845m;
    }

    public Bitmap getBitmap() {
        return this.f10836d;
    }

    public LineOptions bitmap(Bitmap bitmap) {
        this.f10836d = bitmap;
        return this;
    }

    public int getStretchFactor() {
        return this.f10837e;
    }

    public LineOptions stretchFactor(int i) {
        this.f10837e = i;
        return this;
    }

    public int getLineJoinType() {
        return this.f10838f;
    }

    public LineOptions lineJoinType(int i) {
        this.f10838f = i;
        return this;
    }

    public int getLineEndType() {
        return this.f10839g;
    }

    public LineOptions lineEndType(int i) {
        this.f10839g = i;
        return this;
    }

    public LineOptions directionArrow(boolean z) {
        this.f10846n = z;
        return this;
    }

    public boolean hasDirectionArrow() {
        return this.f10846n;
    }

    public LineOptions turnArrow(boolean z) {
        this.f10847o = z;
        return this;
    }

    public boolean hasTurnArrow() {
        return this.f10847o;
    }

    public LineOptions bezierInfo(int i, List<LatLng> list, boolean z) {
        this.f10848p = i;
        this.f10850r = z;
        if (this.f10849q == null) {
            this.f10849q = new ArrayList();
        }
        this.f10849q.clear();
        this.f10849q.addAll(list);
        return this;
    }

    public int getBezierOrder() {
        return this.f10848p;
    }

    public List<LatLng> getBezierControlPoints() {
        return this.f10849q;
    }

    public LineOptions aboveBuilding(boolean z) {
        this.f10851s = z;
        return this;
    }

    public boolean isAboveBuilding() {
        return this.f10851s;
    }

    public LineOptions type(int i) {
        this.f10852t = i;
        return this;
    }

    public int getType() {
        return this.f10852t;
    }

    public LineOptions routeNamesInfo(List<RouteWithName> list) {
        this.f10856x = list;
        return this;
    }

    public List<RouteWithName> getRouteNamesInfo() {
        return this.f10856x;
    }

    public LineOptions multiColorLineInfo(MultiColorLineInfo[] multiColorLineInfoArr) {
        this.f10855w = multiColorLineInfoArr;
        return this;
    }

    public MultiColorLineInfo[] getMultiColorLineInfo() {
        return this.f10855w;
    }

    public void setBezierInfo(int i, List<LatLng> list, boolean z) {
        this.f10848p = i;
        this.f10849q.clear();
        this.f10850r = z;
        if (z) {
            if (list == null || (list != null && list.size() < 2)) {
                throw new IllegalArgumentException("bezier曲线使用默认控制点需要先设置起终点");
            }
            LatLng latLng = list.get(0);
            LatLng latLng2 = list.get(1);
            new LatLng((latLng.latitude + latLng2.latitude) / 2.0d, (latLng.longitude + latLng2.longitude) / 2.0d);
            if (i != 1) {
                if (i == 2) {
                    this.f10849q.add(new LatLng((((latLng.latitude + latLng2.latitude) + latLng2.longitude) - latLng.longitude) / 2.0d, (((latLng.longitude + latLng2.longitude) + latLng.latitude) - latLng2.latitude) / 2.0d));
                } else if (i == 3) {
                    LatLng latLng3 = new LatLng((((latLng.latitude + latLng2.latitude) + latLng2.longitude) - latLng.longitude) / 2.0d, (((latLng.longitude + latLng2.longitude) + latLng.latitude) - latLng2.latitude) / 2.0d);
                    LatLng latLng4 = new LatLng((latLng3.latitude + latLng.latitude) / 2.0d, (latLng3.longitude + latLng.longitude) / 2.0d);
                    LatLng latLng5 = new LatLng((latLng3.latitude + latLng2.latitude) / 2.0d, (latLng3.longitude + latLng2.longitude) / 2.0d);
                    this.f10849q.add(latLng4);
                    this.f10849q.add(latLng5);
                } else {
                    throw new IllegalArgumentException("bezier曲线阶数为1，2，3");
                }
            }
        } else if (list != null) {
            this.f10849q.addAll(list);
        }
    }

    public List<LatLng> getListBezierControlPoints() {
        return this.f10849q;
    }

    public boolean isBezierUseDefaultControl() {
        return this.f10850r;
    }

    public static class RouteWithName {
        public static final int ROUTE_NAME_TYPE_MAIN = 0;
        public static final int ROUTE_NAME_TYPE_MUITL = 1;
        private int color;
        private int endNum;
        private String roadName;
        private int startNum;
        private int type;

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public int getStartNum() {
            return this.startNum;
        }

        public void setStartNum(int i) {
            this.startNum = i;
        }

        public int getEndNum() {
            return this.endNum;
        }

        public void setEndNum(int i) {
            this.endNum = i;
        }

        public int getColor() {
            return this.color;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public String getRoadName() {
            return this.roadName;
        }

        public void setRoadName(String str) {
            this.roadName = str;
        }
    }
}

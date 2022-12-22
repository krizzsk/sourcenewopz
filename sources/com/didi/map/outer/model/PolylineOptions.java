package com.didi.map.outer.model;

import android.graphics.Bitmap;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.common.utils.MapSerializeUtil;
import com.didi.map.common.utils.TransformUtil;
import com.didi.map.outer.model.animation.Animation;
import com.didi.util.CrashTryCatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolylineOptions {

    /* renamed from: E */
    private static String f28024E;

    /* renamed from: F */
    private static String f28025F;

    /* renamed from: A */
    private boolean f28026A;

    /* renamed from: B */
    private String f28027B;

    /* renamed from: C */
    private long f28028C;

    /* renamed from: D */
    private boolean f28029D;

    /* renamed from: G */
    private boolean f28030G;

    /* renamed from: H */
    private boolean f28031H;

    /* renamed from: I */
    private Bitmap f28032I;

    /* renamed from: J */
    private ColorType f28033J;

    /* renamed from: a */
    private final List<LatLng> f28034a;

    /* renamed from: b */
    private final List<LatLng> f28035b;

    /* renamed from: c */
    private Map<Integer, Integer> f28036c;

    /* renamed from: d */
    private float f28037d;

    /* renamed from: e */
    private int f28038e;

    /* renamed from: f */
    private float f28039f;

    /* renamed from: g */
    private boolean f28040g;

    /* renamed from: h */
    private boolean f28041h;

    /* renamed from: i */
    private boolean f28042i;

    /* renamed from: j */
    private float f28043j;

    /* renamed from: k */
    private boolean f28044k;

    /* renamed from: l */
    private boolean f28045l;

    /* renamed from: m */
    private boolean f28046m;
    public Collection<RouteSectionWithName> mFishBoneRoadNames;
    public List<RouteSectionWithName> mRoadNames;

    /* renamed from: n */
    private boolean f28047n;

    /* renamed from: o */
    private Animation f28048o;

    /* renamed from: p */
    private int[] f28049p;

    /* renamed from: q */
    private int[] f28050q;

    /* renamed from: r */
    private int f28051r;

    /* renamed from: s */
    private String f28052s;

    /* renamed from: t */
    private String f28053t;

    /* renamed from: u */
    private int f28054u;

    /* renamed from: v */
    private boolean f28055v;

    /* renamed from: w */
    private int f28056w;

    /* renamed from: x */
    private boolean f28057x;

    /* renamed from: y */
    private boolean f28058y;

    /* renamed from: z */
    private List<LatLng> f28059z;

    public enum ColorType {
        LINE_COLOR_NONE,
        LINE_COLOR_TEXTURE,
        LINE_COLOR_ARGB
    }

    public static final class Colors {
        public static final int DARK_BLUE = 6;
        public static final int DASHED = 33;
        public static final int GRAYBLUE = 8;
        public static final int GREEN = 4;
        public static final int GREY = 0;
        public static final int LAST_BLUE = 20;
        public static final int LIGHT_BLUE = 1;
        public static final int LIVER_RED = 9;
        public static final int MID_BLUE = 5;
        public static final int RED = 2;
        public static final int TRANSPARENT = 7;
        public static final int WHITE_BLUE = 19;
        public static final int YELLOW = 3;
    }

    public static final class LineType {
        public static final String CUSTOM_COLOR_LINE_HEAD = "CUSTOM_COLOR_LINE_HEAD";
        public static final int LINE_TYPE_ANIMATION = 6;
        public static final int LINE_TYPE_CUSTOMCOLORLINE = 5;
        public static final int LINE_TYPE_CUSTOM_COLOR_BITMAP = 7;
        public static final int LINE_TYPE_DOTTEDLINE = 2;
        public static final int LINE_TYPE_DOTTEDLINE_ANIMATION = 4;
        public static final int LINE_TYPE_IMAGEINARYLINE = 1;
        public static final int LINE_TYPE_MULTICOLORCAP = 3;
        public static final int LINE_TYPE_MULTICOLORLINE = 0;
    }

    public int getBezierOrder() {
        return this.f28056w;
    }

    public boolean isBezierUseDefaultControl() {
        return this.f28026A;
    }

    public List<LatLng> getBezierControlPoints() {
        return this.f28059z;
    }

    public boolean isBoTrafficUpdate() {
        return this.f28031H;
    }

    public void setBoTrafficUpdate(boolean z) {
        this.f28031H = z;
    }

    public void setCustomTextureBitmap(Bitmap bitmap) {
        this.f28032I = bitmap;
    }

    public Bitmap getCustomTextureBitmap() {
        return this.f28032I;
    }

    public boolean isMainRoute() {
        return this.f28029D;
    }

    public void setMainRoute(boolean z) {
        this.f28029D = z;
    }

    public long getRouteId() {
        return this.f28028C;
    }

    public void setRouteId(long j) {
        this.f28028C = j;
    }

    public PolylineOptions() {
        this.f28049p = null;
        this.f28050q = null;
        this.f28051r = 0;
        this.f28052s = f28024E;
        this.f28053t = null;
        this.f28054u = 0;
        this.f28055v = false;
        this.f28056w = 0;
        this.f28057x = true;
        this.f28058y = false;
        this.f28026A = false;
        this.f28027B = f28025F;
        this.f28030G = false;
        this.f28037d = 15.0f;
        this.f28038e = MapUtil.COLOR_DEFAULT_POLYLINE;
        this.f28039f = 0.0f;
        this.f28040g = true;
        this.f28041h = false;
        this.f28034a = new ArrayList();
        this.f28035b = new ArrayList();
        this.f28043j = 1.0f;
        this.f28044k = false;
        this.f28056w = 0;
        this.f28039f = 0.0f;
        this.f28059z = new ArrayList();
        this.f28036c = new HashMap();
    }

    public void setLatLngs(List<LatLng> list) {
        this.f28034a.clear();
        if (list != null) {
            this.f28034a.addAll(list);
            this.f28035b.clear();
            if (list != null) {
                this.f28035b.addAll(list);
                this.f28036c.clear();
                for (int i = 0; i < list.size(); i++) {
                    this.f28036c.put(Integer.valueOf(i), Integer.valueOf(i));
                }
            }
        }
    }

    public void insertNewRouteLatLngs(List<Integer> list, List<LatLng> list2) {
        int i;
        int i2;
        int i3;
        HashMap hashMap;
        List<LatLng> list3;
        List<LatLng> list4;
        List<LatLng> list5;
        int i4;
        int i5;
        List<Integer> list6 = list;
        List<LatLng> list7 = list2;
        try {
            List<LatLng> list8 = this.f28034a;
            if (list8 != null) {
                if (!(list6 == null || list.size() <= 0 || list7 == null)) {
                    if (list2.size() > 0) {
                        int size = list8.size();
                        ArrayList arrayList = new ArrayList();
                        if (size > 0) {
                            this.f28036c.clear();
                            this.f28035b.clear();
                            HashMap hashMap2 = new HashMap();
                            int size2 = list.size() / 3;
                            for (int i6 = 0; i6 < size2; i6++) {
                                int i7 = i6 * 3;
                                int i8 = i7 + 1;
                                if (list6.get(i8) != null) {
                                    i5 = list6.get(i8).intValue();
                                } else {
                                    if (i6 > 0) {
                                        int i9 = i7 - 1;
                                        if (list6.get(i9) != null) {
                                            i5 = list6.get(i9).intValue();
                                        }
                                    }
                                    list7.remove(i6);
                                }
                                if (hashMap2.get(Integer.valueOf(i5)) == null) {
                                    hashMap2.put(Integer.valueOf(i5), 1);
                                } else {
                                    hashMap2.put(Integer.valueOf(i5), Integer.valueOf(((Integer) hashMap2.get(Integer.valueOf(i5))).intValue() + 1));
                                }
                            }
                            this.f28036c.put(0, 0);
                            this.f28035b.add(list8.get(0));
                            int i10 = 0;
                            int i11 = 0;
                            int i12 = 0;
                            while (i10 < size - 1) {
                                if (hashMap2.get(Integer.valueOf(i10)) == null) {
                                    i11++;
                                    int i13 = i10 + 1;
                                    this.f28036c.put(Integer.valueOf(i13), Integer.valueOf(i11));
                                    this.f28035b.add(list8.get(i13));
                                    list4 = list7;
                                    i = size;
                                    hashMap = hashMap2;
                                    i3 = size2;
                                    i2 = i10;
                                    list3 = list8;
                                } else {
                                    int intValue = ((Integer) hashMap2.get(Integer.valueOf(i10))).intValue();
                                    int i14 = 0;
                                    int i15 = 0;
                                    boolean z = true;
                                    while (i14 < intValue && i12 < size2) {
                                        int i16 = intValue;
                                        LatLng latLng = this.f28035b.get(this.f28035b.size() - 1);
                                        LatLng latLng2 = list7.get(i12);
                                        HashMap hashMap3 = hashMap2;
                                        int i17 = size2;
                                        int i18 = i10;
                                        List<LatLng> list9 = list8;
                                        int i19 = size;
                                        if (TransformUtil.distanceBetween(latLng2.latitude, latLng2.longitude, latLng.latitude, latLng.longitude) <= 5.0d) {
                                            if (z) {
                                                int i20 = i12 * 3;
                                                if (list6.get(i20) != null) {
                                                    arrayList.add(list6.get(i20));
                                                } else {
                                                    arrayList.add(1);
                                                }
                                                arrayList.add(Integer.valueOf(i11));
                                                arrayList.add(0);
                                                z = false;
                                            }
                                            i12++;
                                            list5 = list2;
                                        } else {
                                            int i21 = i12 * 3;
                                            if (list6.get(i21) != null) {
                                                arrayList.add(list6.get(i21));
                                            } else {
                                                if (i12 > 0) {
                                                    int i22 = (i12 - 1) * 3;
                                                    if (list6.get(i22) != null) {
                                                        arrayList.add(list6.get(i22));
                                                    }
                                                }
                                                i4 = 1;
                                                arrayList.add(1);
                                                arrayList.add(Integer.valueOf(i11 + i15 + i4));
                                                arrayList.add(0);
                                                i15++;
                                                list5 = list2;
                                                this.f28035b.add(list5.get(i12));
                                                i12++;
                                            }
                                            i4 = 1;
                                            arrayList.add(Integer.valueOf(i11 + i15 + i4));
                                            arrayList.add(0);
                                            i15++;
                                            list5 = list2;
                                            this.f28035b.add(list5.get(i12));
                                            i12++;
                                        }
                                        i14++;
                                        list7 = list5;
                                        intValue = i16;
                                        hashMap2 = hashMap3;
                                        size2 = i17;
                                        i10 = i18;
                                        list8 = list9;
                                        size = i19;
                                    }
                                    list4 = list7;
                                    i = size;
                                    hashMap = hashMap2;
                                    i3 = size2;
                                    i2 = i10;
                                    i11 = i11 + i15 + 1;
                                    int i23 = i2 + 1;
                                    list3 = list8;
                                    this.f28035b.add(list3.get(i23));
                                    this.f28036c.put(Integer.valueOf(i23), Integer.valueOf(i11));
                                }
                                i10 = i2 + 1;
                                list7 = list4;
                                list8 = list3;
                                hashMap2 = hashMap;
                                size2 = i3;
                                size = i;
                            }
                            int size3 = arrayList.size();
                            int[] iArr = new int[(size3 / 3)];
                            this.f28050q = iArr;
                            int[] iArr2 = new int[(size3 / 3)];
                            this.f28049p = iArr2;
                            m19953a(iArr2, iArr, arrayList);
                            return;
                        }
                        return;
                    }
                }
                this.f28035b.clear();
                this.f28035b.addAll(this.f28034a);
                this.f28036c.clear();
                for (int i24 = 0; i24 < this.f28034a.size(); i24++) {
                    this.f28036c.put(Integer.valueOf(i24), Integer.valueOf(i24));
                }
                return;
            }
            throw new IllegalStateException("need set listLatlngs first");
        } catch (Exception e) {
            CrashTryCatcher.logCrash(e);
        }
    }

    /* renamed from: a */
    private void m19953a(int[] iArr, int[] iArr2, List<Integer> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            int i = size / 3;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * 3;
                if (list.get(i3) != null) {
                    int i4 = i3 + 1;
                    if (list.get(i4) != null) {
                        int intValue = list.get(i3).intValue();
                        int i5 = 4;
                        if (intValue != 0) {
                            if (intValue != 1) {
                                if (intValue == 2) {
                                    i5 = 3;
                                } else if (intValue == 3) {
                                    i5 = 2;
                                } else if (intValue == 4) {
                                    i5 = 9;
                                }
                            }
                            iArr[i2] = i5;
                            iArr2[i2] = list.get(i4).intValue();
                        }
                        i5 = 6;
                        iArr[i2] = i5;
                        iArr2[i2] = list.get(i4).intValue();
                    }
                }
            }
        }
    }

    public int getNewIndex(int i) {
        Integer num = this.f28036c.get(Integer.valueOf(i));
        return num != null ? num.intValue() : i;
    }

    public int getNewIndex(int i, LatLng latLng) {
        int i2 = i + 1;
        int intValue = this.f28036c.get(Integer.valueOf(i)).intValue();
        if (((double) (this.f28036c.get(Integer.valueOf(i2)).intValue() - intValue)) > 1.1d) {
            int i3 = intValue + 1;
            LatLng latLng2 = this.f28035b.get(intValue);
            LatLng latLng3 = this.f28035b.get(i3);
            if (TransformUtil.distanceBetween(latLng2.latitude, latLng2.longitude, latLng.latitude, latLng.longitude) >= TransformUtil.distanceBetween(latLng3.latitude, latLng3.longitude, latLng.latitude, latLng.longitude)) {
                return i3;
            }
        }
        return intValue;
    }

    public PolylineOptions add(LatLng latLng, LatLng... latLngArr) {
        this.f28034a.add(latLng);
        this.f28035b.add(latLng);
        this.f28036c.clear();
        for (int i = 0; i < this.f28034a.size(); i++) {
            this.f28036c.put(Integer.valueOf(i), Integer.valueOf(i));
        }
        if (latLngArr != null) {
            add(latLngArr);
        }
        return this;
    }

    public PolylineOptions add(LatLng[] latLngArr) {
        this.f28034a.addAll(Arrays.asList(latLngArr));
        this.f28035b.addAll(Arrays.asList(latLngArr));
        this.f28036c.clear();
        for (int i = 0; i < this.f28034a.size(); i++) {
            this.f28036c.put(Integer.valueOf(i), Integer.valueOf(i));
        }
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            for (LatLng add : iterable) {
                add(add, new LatLng[0]);
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PolylineOptions mo77272a(Iterable<LatLng> iterable) {
        this.f28034a.clear();
        addAll(iterable);
        return this;
    }

    public PolylineOptions width(float f) {
        this.f28037d = f;
        return this;
    }

    public PolylineOptions color(int i) {
        this.f28038e = i;
        return this;
    }

    public PolylineOptions colors(int[] iArr, int[] iArr2) {
        this.f28049p = iArr;
        this.f28050q = iArr2;
        return this;
    }

    public PolylineOptions zIndex(float f) {
        this.f28039f = f;
        return this;
    }

    public PolylineOptions animateEnable(boolean z) {
        this.f28046m = z;
        return this;
    }

    public PolylineOptions collisionEnable(boolean z) {
        this.f28047n = z;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.f28040g = z;
        return this;
    }

    public void setColors(int[] iArr, int[] iArr2) {
        this.f28049p = iArr;
        this.f28050q = iArr2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PolylineOptions mo77273a(boolean z) {
        this.f28041h = z;
        return this;
    }

    public PolylineOptions arrow(boolean z) {
        this.f28042i = z;
        return this;
    }

    public PolylineOptions alpha(float f) {
        this.f28043j = f;
        return this;
    }

    public PolylineOptions lineCap(boolean z) {
        this.f28044k = z;
        return this;
    }

    public PolylineOptions animation(Animation animation) {
        this.f28048o = animation;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f28034a;
    }

    public List<LatLng> getNewPoints() {
        return this.f28035b;
    }

    public float getWidth() {
        return this.f28037d;
    }

    public int getColor() {
        return this.f28038e;
    }

    public int[][] getColors() {
        int[] iArr;
        int[] iArr2 = this.f28049p;
        if (iArr2 == null || (iArr = this.f28050q) == null || iArr2.length != iArr.length) {
            return null;
        }
        int[] iArr3 = new int[2];
        iArr3[1] = iArr2.length;
        iArr3[0] = 2;
        int[][] iArr4 = (int[][]) Array.newInstance(int.class, iArr3);
        iArr4[0] = this.f28049p;
        iArr4[1] = this.f28050q;
        return iArr4;
    }

    public float getZIndex() {
        return this.f28039f;
    }

    public boolean isVisible() {
        return this.f28040g;
    }

    public boolean isGeodesic() {
        return this.f28041h;
    }

    public boolean isEnableRouteAnimate() {
        return this.f28046m;
    }

    public boolean isCollisionAble() {
        return this.f28047n;
    }

    public boolean isArrow() {
        return this.f28042i;
    }

    public float getAlpha() {
        return this.f28043j;
    }

    public boolean getLineCap() {
        return this.f28044k;
    }

    public Animation getAnimation() {
        return this.f28048o;
    }

    public int getLineType() {
        return this.f28051r;
    }

    public void setLineType(int i) {
        this.f28051r = i;
    }

    public void setErase(boolean z) {
        this.f28045l = z;
    }

    public boolean isErase() {
        return this.f28045l;
    }

    public void setColorTexture(String str, String str2, int i) {
        this.f28052s = str;
        this.f28053t = str2;
        this.f28054u = i;
    }

    public String getTextureName() {
        if (getLineType() != 5) {
            return this.f28052s;
        }
        return LineType.CUSTOM_COLOR_LINE_HEAD + (getColor() + "");
    }

    public String getTextureCapName() {
        return this.f28053t;
    }

    public int getTextureCount() {
        return this.f28054u;
    }

    public void setBezierInfo(int i, List<LatLng> list, boolean z) {
        this.f28056w = i;
        this.f28026A = z;
        this.f28059z.clear();
        if (z) {
            List<LatLng> list2 = this.f28034a;
            if (list2 == null || (list2 != null && list2.size() < 2)) {
                throw new IllegalArgumentException("bezier曲线使用默认控制点需要先设置起终点");
            }
            LatLng latLng = this.f28034a.get(0);
            LatLng latLng2 = this.f28034a.get(1);
            new LatLng((latLng.latitude + latLng2.latitude) / 2.0d, (latLng.longitude + latLng2.longitude) / 2.0d);
            if (i != 1) {
                if (i == 2) {
                    this.f28059z.add(new LatLng((((latLng.latitude + latLng2.latitude) + latLng2.longitude) - latLng.longitude) / 2.0d, (((latLng.longitude + latLng2.longitude) + latLng.latitude) - latLng2.latitude) / 2.0d));
                } else if (i == 3) {
                    LatLng latLng3 = new LatLng((((latLng.latitude + latLng2.latitude) + latLng2.longitude) - latLng.longitude) / 2.0d, (((latLng.longitude + latLng2.longitude) + latLng.latitude) - latLng2.latitude) / 2.0d);
                    LatLng latLng4 = new LatLng((latLng3.latitude + latLng.latitude) / 2.0d, (latLng3.longitude + latLng.longitude) / 2.0d);
                    LatLng latLng5 = new LatLng((latLng3.latitude + latLng2.latitude) / 2.0d, (latLng3.longitude + latLng2.longitude) / 2.0d);
                    this.f28059z.add(latLng4);
                    this.f28059z.add(latLng5);
                } else {
                    throw new IllegalArgumentException("bezier曲线阶数为1，2，3");
                }
            }
        } else if (list != null) {
            this.f28059z.addAll(list);
        }
    }

    public List<LatLng> getListBezierControlPoints() {
        return this.f28059z;
    }

    public PolylineOptions aboveMaskLayer(boolean z) {
        this.f28055v = z;
        return this;
    }

    public boolean isAboveMaskLayer() {
        return this.f28055v;
    }

    public PolylineOptions road(boolean z) {
        this.f28057x = z;
        return this;
    }

    public boolean isRoad() {
        return this.f28057x;
    }

    public PolylineOptions marker(boolean z) {
        this.f28058y = z;
        return this;
    }

    public boolean isMarker() {
        return this.f28058y;
    }

    public PolylineOptions arrowTextureName(String str) {
        this.f28027B = str;
        return this;
    }

    public PolylineOptions setForceLoad(boolean z) {
        this.f28030G = z;
        return this;
    }

    public boolean getIsForceLoad() {
        return this.f28030G;
    }

    public static void setDefaultColorTexture(String str) {
        f28024E = str;
    }

    public static String getDefaultColorTexture() {
        return f28024E;
    }

    public static void setDefaultArrowTexture(String str) {
        f28025F = str;
    }

    public static String getsDefaultArrowTexture() {
        return f28025F;
    }

    public String getArrowTextureName() {
        return this.f28027B;
    }

    public void addAllRoadNames(List<RouteSectionWithName> list) {
        if (list != null) {
            this.mRoadNames = list;
        }
    }

    public void addAllFishBoneRoadNames(Collection<RouteSectionWithName> collection) {
        if (collection != null) {
            this.mFishBoneRoadNames = collection;
        }
    }

    public void setRouteName(List<RouteWithName> list) {
        ArrayList arrayList = new ArrayList();
        for (RouteWithName next : list) {
            RouteSectionWithName routeSectionWithName = new RouteSectionWithName();
            routeSectionWithName.startNum = next.getStartNum();
            routeSectionWithName.endNum = next.getEndNum();
            routeSectionWithName.color = next.getColor();
            routeSectionWithName.roadName = MapSerializeUtil.stringToBytesEndNull(next.getRoadName());
            routeSectionWithName.type = next.getType();
            arrayList.add(routeSectionWithName);
        }
        addAllRoadNames(arrayList);
    }

    public static class RouteWithName {
        public static final int ROUTE_NAME_TYPE_MAIN = 0;
        public static final int ROUTE_NAME_TYPE_MUITL = 1;
        private int color;
        private int endNum;
        private String roadName;
        private int startNum;
        private int type;

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

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    public ColorType getColorType() {
        return this.f28033J;
    }

    public void setColorType(ColorType colorType) {
        this.f28033J = colorType;
    }
}

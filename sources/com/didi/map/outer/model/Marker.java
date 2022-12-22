package com.didi.map.outer.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.alpha.maps.internal.MarkerControl;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.core.base.OnMapTransformer;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.DMarker;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.animation.Animation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import rui.config.RConfigConstants;

public final class Marker extends DMarker<DidiMap.MultiPositionInfoWindowAdapter, DidiMap.OnMarkerClickListener, DidiMap.OnInfoWindowClickListener> implements IMapElement {
    public static final int BOTTOM = 3;
    public static final int INFO_WINDOW_TYPE_ANDROID_VIEW = 2;
    public static final int INFO_WINDOW_TYPE_MARKER = 1;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int TOP = 1;

    /* renamed from: a */
    private static Handler f27944a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private boolean f27945b = false;

    /* renamed from: c */
    private String f27946c;

    /* renamed from: d */
    private int f27947d = -1;

    /* renamed from: e */
    private boolean f27948e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MarkerOptions f27949f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f27950g = "";

    /* renamed from: h */
    private boolean f27951h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MarkerControl f27952i = null;

    /* renamed from: j */
    private boolean f27953j = false;

    /* renamed from: k */
    private int f27954k = 0;

    /* renamed from: l */
    private boolean f27955l = false;

    /* renamed from: m */
    private String f27956m = "";

    /* renamed from: n */
    private DidiMap.MultiPositionInfoWindowAdapter f27957n;

    /* renamed from: o */
    private int f27958o = 1;

    /* renamed from: p */
    private DidiMap.OnMarkerDragListener f27959p;

    /* renamed from: q */
    private DidiMap.OnInfoWindowClickListener f27960q;

    /* renamed from: r */
    private DidiMap.OnInfoWindowVisibleChangeListener f27961r;

    /* renamed from: s */
    private DoublePoint f27962s;

    /* renamed from: t */
    private int f27963t;

    /* renamed from: u */
    private int f27964u;

    /* renamed from: v */
    private int f27965v;

    /* renamed from: w */
    private LatLng f27966w;

    /* renamed from: x */
    private String f27967x;

    /* renamed from: y */
    private String f27968y = "";

    /* renamed from: z */
    private boolean f27969z = false;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Gravity {
    }

    public DoublePoint getDoublePoint() {
        return this.f27962s;
    }

    public void setDoublePoint(DoublePoint doublePoint) {
        this.f27962s = doublePoint;
    }

    public Marker(MarkerOptions markerOptions, MarkerControl markerControl, String str) {
        super(markerOptions, markerControl, str);
        this.f27950g = str;
        this.f27949f = markerOptions;
        this.f27952i = markerControl;
        this.f27955l = markerOptions.isInfoWindowAutoOverturn();
        this.f27954k = markerOptions.getDisplayLevel();
        this.f27958o = markerOptions.getInfoWindowType();
    }

    public String getTouchableContent() {
        return this.f27968y;
    }

    public void setTouchableContent(String str) {
        this.f27968y = str;
        if (!TextUtils.isEmpty(str)) {
            this.f27952i.onSetTouchableContent(this);
        }
    }

    public void setMarkerInfoOption(MarkerInfoWindowOption markerInfoWindowOption) {
        this.f27952i.setMarkerInfoOption(this.f27950g, markerInfoWindowOption);
        this.f27949f.setMarkerInfoOption(markerInfoWindowOption);
    }

    public String getStrChargeInfo() {
        return this.f27967x;
    }

    public void setStrChargeInfo(String str) {
        this.f27967x = str;
    }

    public LatLng getCachePosition() {
        return this.f27966w;
    }

    public void setCachePosition(LatLng latLng) {
        this.f27966w = latLng;
    }

    public int getLableType() {
        return this.f27965v;
    }

    public void setLableType(int i) {
        this.f27965v = i;
    }

    public int getChangeNum() {
        return this.f27964u;
    }

    public void setChangeNum(int i) {
        this.f27964u = i;
    }

    public void calculateChangeNum() {
        this.f27964u++;
    }

    public int getDirection() {
        return this.f27963t;
    }

    public void setDirection(int i) {
        this.f27963t = i;
    }

    public String getStrFileName() {
        return this.f27956m;
    }

    public void setStrFileName(String str) {
        this.f27956m = str;
    }

    public void setBubbleInfoWindow(boolean z) {
        if (this.f27952i != null) {
            this.f27945b = z;
        }
    }

    public void setBubbleContent(String str) {
        if (this.f27952i != null) {
            this.f27946c = str;
            this.f27945b = true;
        }
    }

    public String getBubbleContent() {
        return this.f27946c;
    }

    public boolean isBubbleInfoWindow() {
        return this.f27945b;
    }

    public void setBubbleId(int i) {
        if (this.f27952i != null) {
            this.f27947d = i;
        }
    }

    public int getBubbleId() {
        return this.f27947d;
    }

    public void setOnTapMapViewBubbleHidden(boolean z) {
        if (this.f27952i != null) {
            this.f27948e = z;
        }
    }

    public boolean onTapMapViewBubbleHidden() {
        return this.f27948e;
    }

    public void remove() {
        C99181 r0 = new Runnable() {
            public void run() {
                if (Marker.this.f27952i != null) {
                    Marker.this.f27952i.removeMarker(Marker.this.f27950g);
                    LableMarkerManager.removeOtherMarker(Marker.this);
                }
            }
        };
        if (SystemUtil.isUIThread()) {
            r0.run();
        } else {
            f27944a.post(r0);
        }
    }

    public String getId() {
        return this.f27950g;
    }

    public void setPosition(LatLng latLng) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && latLng != null && this.f27949f != null) {
            markerControl.setPosition(this.f27950g, latLng);
            this.f27949f.position(latLng);
        }
    }

    public void setInfoWindowEnable(boolean z) {
        MarkerOptions markerOptions;
        if (this.f27952i != null && (markerOptions = this.f27949f) != null) {
            markerOptions.infoWindowEnable(z);
        }
    }

    public boolean isInfoWindowEnable() {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null) {
            return false;
        }
        return markerOptions.isInfoWindowEnable();
    }

    public void setPositionNotUpdate(LatLng latLng) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setPosition(this.f27950g, latLng);
            this.f27949f.position(latLng);
        }
    }

    public void setNaviState(boolean z, boolean z2) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null) {
            markerControl.setNaviState(this.f27950g, z, z2);
            this.f27951h = z;
        }
    }

    public boolean isNaviState() {
        return this.f27951h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r2.f27949f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.map.outer.model.LatLng getPosition() {
        /*
            r2 = this;
            com.didi.map.alpha.maps.internal.MarkerControl r0 = r2.f27952i
            java.lang.String r1 = r2.f27950g
            com.didi.map.outer.model.LatLng r0 = r0.getPosition(r1)
            if (r0 != 0) goto L_0x0012
            com.didi.map.outer.model.MarkerOptions r1 = r2.f27949f
            if (r1 == 0) goto L_0x0012
            com.didi.map.outer.model.LatLng r0 = r1.getPosition()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.outer.model.Marker.getPosition():com.didi.map.outer.model.LatLng");
    }

    public void setTitle(String str) {
        MarkerOptions markerOptions;
        if (this.f27952i != null && (markerOptions = this.f27949f) != null) {
            markerOptions.title(str);
            this.f27952i.setTitle(this.f27950g, str);
        }
    }

    public String getTitle() {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null) {
            return "";
        }
        return markerOptions.getTitle();
    }

    public void setSnippet(String str) {
        MarkerOptions markerOptions;
        if (this.f27952i != null && (markerOptions = this.f27949f) != null) {
            markerOptions.snippet(str);
            this.f27952i.setSnippet(this.f27950g, str);
        }
    }

    public String getSnippet() {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null) {
            return "";
        }
        return markerOptions.getSnippet();
    }

    public float getAlpha() {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null) {
            return 0.0f;
        }
        return markerOptions.getAlpha();
    }

    public void setDraggable(boolean z) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setDraggable(this.f27950g, z);
            this.f27949f.draggable(z);
        }
    }

    public boolean isDraggable() {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null) {
            return false;
        }
        return markerOptions.isDraggable();
    }

    public void showInfoWindow() {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && markerControl.showInfoWindow(this.f27950g) && !this.f27953j) {
            this.f27953j = true;
            DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener = this.f27961r;
            if (onInfoWindowVisibleChangeListener != null) {
                onInfoWindowVisibleChangeListener.onInfoWindowVisibleChange(true);
            }
        }
    }

    public void showInfoWindowWithGravity(int i) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && markerControl.showInfoWindowWithGravity(this.f27950g, i) && !this.f27953j) {
            this.f27953j = true;
            DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener = this.f27961r;
            if (onInfoWindowVisibleChangeListener != null) {
                onInfoWindowVisibleChangeListener.onInfoWindowVisibleChange(true);
            }
        }
    }

    public void hideInfoWindow() {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && markerControl.hideInfoWindow(this.f27950g) && this.f27953j) {
            this.f27953j = false;
            DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener = this.f27961r;
            if (onInfoWindowVisibleChangeListener != null) {
                onInfoWindowVisibleChangeListener.onInfoWindowVisibleChange(false);
            }
        }
    }

    public boolean isInfoWindowShown() {
        MarkerControl markerControl = this.f27952i;
        if (markerControl == null) {
            return false;
        }
        return markerControl.isInfoWindowShown(this.f27950g);
    }

    public void setAnchor(float f, float f2) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setAnchor(this.f27950g, f, f2);
            this.f27949f.anchor(f, f2);
        }
    }

    public void setVisible(final boolean z) {
        C99192 r0 = new Runnable() {
            public void run() {
                if (Marker.this.f27952i != null && Marker.this.f27949f != null) {
                    Marker.this.f27952i.setVisible(Marker.this.f27950g, z);
                    Marker.this.f27949f.visible(z);
                }
            }
        };
        if (Looper.myLooper() == f27944a.getLooper()) {
            r0.run();
        } else {
            f27944a.post(r0);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setIcon(this.f27950g, bitmapDescriptor);
            this.f27949f.icon(bitmapDescriptor);
        }
    }

    public void setRotateAngle(float f) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setMarkerRotateAngle(this.f27950g, f);
            this.f27949f.rotateAngle(f);
        }
    }

    public float getRotateAngle() {
        MarkerControl markerControl = this.f27952i;
        if (markerControl == null) {
            return 0.0f;
        }
        return markerControl.getRotateAngle(this.f27950g);
    }

    public void setRotateAngleNotUpdate(float f) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setRotateAngleNotUpdate(this.f27950g, f);
            this.f27949f.rotateAngle(f);
        }
    }

    public boolean isVisible() {
        MarkerOptions markerOptions;
        if (this.f27952i == null || (markerOptions = this.f27949f) == null) {
            return false;
        }
        return markerOptions.isVisible();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        return this.f27950g.equals(((Marker) obj).f27950g);
    }

    public void setAnimation(Animation animation) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && animation != null) {
            markerControl.setAnimation(this.f27950g, animation);
            if (!this.f27969z) {
                this.f27952i.setAnimationListener(this.f27950g, animation.getListener());
            }
        }
    }

    public boolean startAnimation() {
        MarkerControl markerControl = this.f27952i;
        if (markerControl == null) {
            return false;
        }
        return markerControl.startAnimation(this.f27950g);
    }

    @Deprecated
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null) {
            markerControl.setAnimationListener(this.f27950g, animationListener);
            this.f27969z = true;
        }
    }

    public void setScale(PointF pointF) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setScale(this.f27950g, pointF);
            this.f27949f.scaleXY(pointF);
        }
    }

    public void setOffset(PointF pointF) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setOffset(this.f27950g, pointF);
            this.f27949f.offset(pointF);
        }
    }

    public void setGroundIcon(LatLngBounds latLngBounds, BitmapDescriptor bitmapDescriptor) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null && latLngBounds != null && bitmapDescriptor != null) {
            markerControl.setGroundIcon(this.f27950g, latLngBounds, bitmapDescriptor);
            this.f27949f.ground(true);
            this.f27949f.groundBounds(latLngBounds);
            this.f27949f.icon(bitmapDescriptor);
        }
    }

    public PointF getOffset() {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null) {
            return null;
        }
        return markerOptions.getOffset();
    }

    public void setAlpha(float f) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setAlpha(this.f27950g, f);
            this.f27949f.alpha(f);
        }
    }

    public void setClickable(boolean z) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null) {
            markerControl.setClickable(this.f27950g, z);
        }
    }

    public boolean isClickable() {
        MarkerControl markerControl = this.f27952i;
        if (markerControl == null) {
            return false;
        }
        return markerControl.isClickable(this.f27950g);
    }

    public void setFixingPointEnable(boolean z) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null) {
            markerControl.setFixingPointEnable(this.f27950g, z);
        }
    }

    public boolean isFixingPointEnabled() {
        return this.f27952i.isFixingPointEnabled(this.f27950g);
    }

    public void setFixingPoint(int i, int i2) {
        this.f27952i.setFixingPoint(this.f27950g, i, i2);
    }

    public Point getFixingPoint() {
        return this.f27952i.getFixingPoint(this.f27950g);
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        if (markerOptions != null && this.f27949f != null) {
            this.f27952i.setMarkerOptions(this.f27950g, markerOptions);
            this.f27949f.position(markerOptions.getPosition());
            this.f27949f.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
            this.f27949f.title(markerOptions.getTitle());
            this.f27949f.snippet(markerOptions.getSnippet());
            this.f27949f.draggable(markerOptions.isDraggable());
            this.f27949f.visible(markerOptions.isVisible());
            this.f27949f.rotateAngle(markerOptions.getRotateAngle());
            this.f27949f.icon(markerOptions.getIcon());
            this.f27949f.alpha(markerOptions.getAlpha());
            this.f27949f.zIndex(markerOptions.getZIndex());
            this.f27949f.ground(markerOptions.is2DGround());
            this.f27949f.clickable(markerOptions.isClickable());
            this.f27949f.groundBounds(markerOptions.groundBounds());
        }
    }

    public MarkerOptions getOptions() {
        return this.f27949f;
    }

    public void setZIndex(float f) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl != null && this.f27949f != null) {
            markerControl.setZIndex(this.f27950g, f);
            this.f27949f.zIndex(f);
        }
    }

    public int getWidth(Context context) {
        BitmapDescriptor icon;
        Bitmap bitmap;
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null || (icon = markerOptions.getIcon()) == null || (bitmap = icon.getFormater().getBitmap(context)) == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public int getHeight(Context context) {
        BitmapDescriptor icon;
        Bitmap bitmap;
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null || (icon = markerOptions.getIcon()) == null || (bitmap = icon.getFormater().getBitmap(context)) == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public float getAnchorU() {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null) {
            return 0.0f;
        }
        return markerOptions.getAnchorU();
    }

    public float getAnchorV() {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions == null) {
            return 0.0f;
        }
        return markerOptions.getAnchorV();
    }

    public int getDisplayLevel() {
        return this.f27954k;
    }

    public void setDisplayLevel(int i) {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions != null) {
            this.f27954k = i;
            markerOptions.displayLevel(i);
        }
    }

    public boolean isInfoWindowAutoOverturn() {
        return this.f27955l;
    }

    public void setAutoOverturnInfoWindow(boolean z) {
        MarkerOptions markerOptions = this.f27949f;
        if (markerOptions != null) {
            this.f27955l = z;
            markerOptions.autoOverturnInfoWindow(z);
        }
    }

    public void setInfoWindowAdapter(DidiMap.MultiPositionInfoWindowAdapter multiPositionInfoWindowAdapter) {
        this.f27957n = multiPositionInfoWindowAdapter;
    }

    public int getInfoWindowType() {
        return this.f27958o;
    }

    public DidiMap.MultiPositionInfoWindowAdapter getInfoWindowAdapter() {
        return this.f27957n;
    }

    public void setOnClickListener(DidiMap.OnMarkerClickListener onMarkerClickListener) {
        this.f27952i.setOnClickListener(this.f27950g, onMarkerClickListener);
    }

    public DidiMap.OnMarkerClickListener getOnClickListener() {
        return this.f27952i.getOnClickListener(this.f27950g);
    }

    public void setOnDragListener(DidiMap.OnMarkerDragListener onMarkerDragListener) {
        this.f27959p = onMarkerDragListener;
    }

    public DidiMap.OnMarkerDragListener getOnDragListener() {
        return this.f27959p;
    }

    public void setOnInfoWindowClickListener(DidiMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f27960q = onInfoWindowClickListener;
    }

    public void setOnInfoWindowVisibleChangeListener(DidiMap.OnInfoWindowVisibleChangeListener onInfoWindowVisibleChangeListener) {
        this.f27961r = onInfoWindowVisibleChangeListener;
    }

    public DidiMap.OnInfoWindowClickListener getOnInfoWindowClickListener() {
        return this.f27960q;
    }

    public void setOnMarkerVisibleChangeListener(DidiMap.OnMarkerVisibleChangeListener onMarkerVisibleChangeListener) {
        this.f27952i.setOnVisibleChangeListener(this.f27950g, onMarkerVisibleChangeListener);
    }

    public Rect getBound(OnMapTransformer onMapTransformer, Context context) {
        Bitmap bitmap;
        MarkerOptions options = getOptions();
        if (options == null || getPosition() == null || (bitmap = options.getIcon().getFormater().getBitmap(context)) == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width / 2;
        int i2 = height / 2;
        DoublePoint screentLocation = onMapTransformer.toScreentLocation(m19943a(getPosition()));
        float anchorU = options.getAnchorU();
        float anchorV = options.getAnchorV();
        if (anchorU >= 0.0f && anchorU <= 1.0f) {
            screentLocation.f24753x -= (((double) anchorU) - 0.5d) * ((double) width);
        }
        if (anchorV >= 0.0f && anchorV <= 1.0f) {
            screentLocation.f24754y -= (((double) anchorV) - 0.5d) * ((double) height);
        }
        DoublePoint doublePoint = new DoublePoint();
        DoublePoint doublePoint2 = new DoublePoint();
        double d = (double) i;
        doublePoint.f24753x = screentLocation.f24753x - d;
        doublePoint2.f24753x = screentLocation.f24753x + d;
        double d2 = (double) i2;
        doublePoint.f24754y = screentLocation.f24754y - d2;
        doublePoint2.f24754y = screentLocation.f24754y + d2;
        return new Rect((int) doublePoint.f24753x, (int) doublePoint.f24754y, (int) doublePoint2.f24753x, (int) doublePoint2.f24754y);
    }

    public int hashCode() {
        return this.f27950g.hashCode();
    }

    /* renamed from: a */
    private GeoPoint m19943a(LatLng latLng) {
        if (latLng != null) {
            return new GeoPoint((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        }
        HWLog.m16760e(1, "Marker", "point is null,return default geo");
        return new GeoPoint();
    }

    public Rect getScreenRect() {
        MarkerControl markerControl = this.f27952i;
        if (markerControl == null) {
            return null;
        }
        return markerControl.getScreenRect(this.f27950g);
    }

    public RectF getInfoWindowScreenRect() {
        MarkerControl markerControl = this.f27952i;
        if (markerControl == null) {
            return null;
        }
        return markerControl.getInfoWindowScreenRect(this.f27950g);
    }

    public Rect getBound() {
        MarkerControl markerControl = this.f27952i;
        if (markerControl == null) {
            return new Rect();
        }
        return markerControl.getBound(this.f27950g);
    }

    public RectF getPixel20Bound(float f) {
        MarkerControl markerControl = this.f27952i;
        if (markerControl == null) {
            return null;
        }
        return markerControl.getPixel20Bound(this.f27950g, f);
    }

    public String toString() {
        return super.toString() + RConfigConstants.KEYWORD_COLOR_SIGN + this.f27950g;
    }
}

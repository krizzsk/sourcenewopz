package com.didi.map.sdk.departure.internal.rec;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.map.sdk.departure.internal.sensing.SensingCircles;
import com.didi.map.sdk.departure.internal.util.LatLngUtil;
import com.didi.map.sdk.departure.internal.util.OmegaUtil;
import com.didi.map.sdk.departure.internal.util.ZIndexUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class RecMarkerImpl implements IRecMarker {

    /* renamed from: a */
    private static final String f28205a = "RecMarkerImpl";

    /* renamed from: b */
    private Context f28206b;

    /* renamed from: c */
    private Map f28207c;

    /* renamed from: d */
    private float f28208d = 0.0f;

    /* renamed from: e */
    private float f28209e = 0.0f;

    /* renamed from: f */
    private int f28210f = 1;

    /* renamed from: g */
    private int f28211g = 1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RecMarkerParam f28212h;

    /* renamed from: i */
    private SensingCircles f28213i;

    /* renamed from: j */
    private boolean f28214j = false;

    /* renamed from: k */
    private boolean f28215k = false;

    /* renamed from: l */
    private boolean f28216l = false;

    /* renamed from: m */
    private OnMarkerClickListener f28217m = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (RecMarkerImpl.this.f28212h == null || marker != RecMarkerImpl.this.mMarker) {
                return false;
            }
            OmegaUtil.trackRecMarkerClick(RecMarkerImpl.this.f28212h.point);
            if (RecMarkerImpl.this.f28212h.listener == null) {
                return true;
            }
            RecMarkerImpl.this.f28212h.listener.onClick(RecMarkerImpl.this);
            return true;
        }
    };
    protected Marker mMarker;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f28206b = context.getApplicationContext();
        this.f28207c = map;
        map.addOnMarkerClickListener(this.f28217m);
    }

    public void destroy() {
        remove();
        this.f28207c = null;
        this.f28206b = null;
    }

    public void setConfigParam(RecMarkerParam recMarkerParam) {
        this.f28212h = recMarkerParam;
    }

    public void add() {
        RecMarkerParam recMarkerParam;
        Map map = this.f28207c;
        if (map != null && map.getProjection() != null && (recMarkerParam = this.f28212h) != null && recMarkerParam.point != null && this.f28212h.point.location != null) {
            Marker marker = this.mMarker;
            if (marker == null) {
                m20038a();
            } else {
                marker.setPosition(this.f28212h.point.location);
            }
        }
    }

    public void remove() {
        if (this.mMarker != null) {
            hideCircles();
            Map map = this.f28207c;
            if (map != null) {
                map.remove(this.mMarker);
            }
            this.mMarker = null;
        }
    }

    public void visible(boolean z) {
        Marker marker = this.mMarker;
        if (marker != null && marker.isVisible() != z) {
            this.mMarker.setVisible(z);
        }
    }

    public boolean isVisible() {
        Marker marker = this.mMarker;
        if (marker != null) {
            return marker.isVisible();
        }
        return false;
    }

    /* renamed from: a */
    private void m20038a() {
        RecMarkerParam recMarkerParam;
        if (this.f28207c != null && (recMarkerParam = this.f28212h) != null && recMarkerParam.icon != null && this.f28212h.selectedIcon != null && this.f28212h.point != null && this.f28212h.point.location != null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.zIndex(ZIndexUtil.getZIndex(6));
            markerOptions.position(this.f28212h.point.location);
            Bitmap bitmap = this.f28212h.icon;
            this.f28208d = (float) bitmap.getWidth();
            this.f28209e = (float) bitmap.getHeight();
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.clickable(this.f28212h.isClickEnable);
            markerOptions.visible(true);
            this.f28211g = this.f28210f;
            Marker addMarker = this.f28207c.addMarker(markerOptions);
            this.mMarker = addMarker;
            if (addMarker != null) {
                m20040b();
            }
        }
    }

    /* renamed from: a */
    private static Bitmap m20036a(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getResources().getDisplayMetrics().widthPixels / 2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(view.getResources().getDisplayMetrics().heightPixels / 2, Integer.MIN_VALUE));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public double getX() {
        Map map = this.f28207c;
        if (map == null || map.getProjection() == null || this.mMarker == null) {
            return 0.0d;
        }
        return (double) (this.f28207c.getProjection().toScreenLocation(this.mMarker.getPosition()).x - (this.mMarker.getOptions().getAnchorU() * this.f28208d));
    }

    public double getY() {
        Map map = this.f28207c;
        if (map == null || map.getProjection() == null || this.mMarker == null) {
            return 0.0d;
        }
        return (double) (this.f28207c.getProjection().toScreenLocation(this.mMarker.getPosition()).y - (this.mMarker.getOptions().getAnchorV() * this.f28209e));
    }

    public float getWidth() {
        return this.f28208d;
    }

    public float getHeight() {
        return this.f28209e;
    }

    public void handler(int i) {
        this.f28210f = i;
    }

    public void apply() {
        if (this.f28211g != this.f28210f) {
            remove();
            add();
        }
    }

    public int getDirection() {
        return this.f28210f;
    }

    public void setDirection(int i) {
        if (this.f28210f != i) {
            this.f28210f = i;
            remove();
            add();
        }
    }

    public int compareTo(Square square) {
        if (this == square || !(square instanceof RecMarkerImpl)) {
            return 0;
        }
        return getX() > square.getX() ? 1 : -1;
    }

    public void showCircles() {
        Context context;
        hideCircles();
        Map map = this.f28207c;
        if (map != null && (context = this.f28206b) != null && this.mMarker != null) {
            SensingCircles sensingCircles = new SensingCircles(context, map);
            this.f28213i = sensingCircles;
            sensingCircles.show(this.mMarker.getPosition());
        }
    }

    public void hideCircles() {
        SensingCircles sensingCircles = this.f28213i;
        if (sensingCircles != null && sensingCircles.isShow()) {
            this.f28213i.hide();
        }
        this.f28213i = null;
    }

    public void showTransientCircles() {
        Marker marker;
        if (this.f28207c != null && this.f28206b != null && (marker = this.mMarker) != null && marker.getPosition() != null) {
            this.mMarker.setVisible(true);
            new SensingCircles(this.f28206b, this.f28207c, (int) R.color.mappoiselect_departure_sensing_circle, SensingCircles.TIME_TRANSIEN_PERIOD, 48.0f).showTransientCircles(this.mMarker.getPosition());
        }
    }

    public LatLng getLocation() {
        if (this.mMarker == null) {
            return null;
        }
        RecMarkerParam recMarkerParam = this.f28212h;
        return (recMarkerParam == null || recMarkerParam.point == null) ? this.mMarker.getPosition() : this.f28212h.point.location;
    }

    public float getAlpha() {
        Marker marker = this.mMarker;
        if (marker != null) {
            return marker.getAlpha();
        }
        return 0.0f;
    }

    public void setAlpha(float f) {
        Marker marker = this.mMarker;
        if (marker != null) {
            marker.setAlpha(f);
        }
    }

    public boolean isInCenter() {
        if (this.f28207c == null || this.f28212h.point == null) {
            return false;
        }
        return LatLngUtil.isSameLatLng(this.f28207c.getCameraPosition().target, this.f28212h.point.location);
    }

    public void onMapStable() {
        m20040b();
    }

    public void setNeedShowInfoWindow(boolean z) {
        this.f28214j = z;
    }

    /* renamed from: b */
    private void m20040b() {
        boolean isInCenter = isInCenter();
        if (isInCenter && !this.f28216l) {
            this.f28216l = true;
            m20041c();
            m20039a(this.f28216l);
        } else if (!isInCenter && this.f28216l) {
            this.f28216l = false;
            m20042d();
            m20039a(this.f28216l);
        }
    }

    /* renamed from: c */
    private void m20041c() {
        if (this.mMarker != null && this.f28207c != null && this.f28206b != null && this.f28212h != null) {
            SystemUtils.log(6, "ccc", "showInfoWindowInternal , isShowInfoWindow= " + this.f28214j, (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 339);
            if (!this.f28215k && this.f28214j) {
                this.f28215k = true;
                this.mMarker.buildInfoWindow(this.f28207c, this.f28206b, InfoWindow.Position.BOTTOM).showInfoWindow(LayoutInflater.from(this.f28206b).inflate(R.layout.layout_map_departure_recommend_departure_bubble, (ViewGroup) null));
                SystemUtils.log(6, "ccc", "showInfoWindowInternal ok", (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 345);
            }
        }
    }

    /* renamed from: d */
    private void m20042d() {
        if (this.mMarker != null) {
            SystemUtils.log(6, "ccc", "hideInfoWindowInternal", (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 353);
            if (this.f28215k) {
                this.f28215k = false;
                this.mMarker.hideInfoWindow();
                SystemUtils.log(6, "ccc", "hideInfoWindowInternal:ok ", (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 357);
            }
        }
    }

    /* renamed from: a */
    private void m20039a(boolean z) {
        RecMarkerParam recMarkerParam;
        SystemUtils.log(6, "ccc", "updateIcon:" + z, (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 362);
        if (this.mMarker != null && this.f28206b != null && (recMarkerParam = this.f28212h) != null) {
            Bitmap bitmap = z ? recMarkerParam.selectedIcon : recMarkerParam.icon;
            this.f28208d = (float) bitmap.getWidth();
            this.f28209e = (float) bitmap.getHeight();
            this.mMarker.setIcon(this.f28206b, BitmapDescriptorFactory.fromBitmap(bitmap));
            SystemUtils.log(6, "ccc", "updateIcon:ok：mWidth=" + this.f28208d + ",mHeight=" + this.f28209e, (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 368);
        }
    }
}

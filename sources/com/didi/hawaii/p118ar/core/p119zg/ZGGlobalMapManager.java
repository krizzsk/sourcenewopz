package com.didi.hawaii.p118ar.core.p119zg;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapOption;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.hawaii.p118ar.utils.DisplayUtils;
import com.didi.hawaii.p118ar.utils.LocationUtil;
import com.didi.map.global.component.line.excomponent.GuideLine;
import com.didi.map.global.component.line.excomponent.GuideLineParam;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.hawaii.ar.core.zg.ZGGlobalMapManager */
public class ZGGlobalMapManager {
    public static final int DEFAULT_MAP_PADDING_DP = 20;

    /* renamed from: a */
    MapView f23144a;

    /* renamed from: b */
    private Context f23145b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f23146c = null;

    /* renamed from: d */
    private LatLng f23147d = null;

    /* renamed from: e */
    private LatLng f23148e = null;

    /* renamed from: f */
    private Marker f23149f = null;

    /* renamed from: g */
    private boolean f23150g = false;

    /* renamed from: h */
    private float f23151h = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MapViewHolder f23152i;

    /* renamed from: j */
    private String f23153j = "ZGGlobalMapManager";

    /* renamed from: k */
    private float f23154k = 5.0f;

    /* renamed from: l */
    private GuideLine f23155l;

    /* renamed from: m */
    private Marker f23156m;

    public void onRestart() {
    }

    public void setDestLocation(LatLng latLng) {
        this.f23148e = latLng;
        m16614b();
        m16618d();
    }

    public ZGGlobalMapManager(Context context, ViewGroup viewGroup, boolean z) {
        DLog.m7384d("ZGGlobalMapManager", " map ZGGlobalMapManager", new Object[0]);
        this.f23145b = context;
        m16613a(viewGroup, z);
    }

    /* renamed from: a */
    private void m16613a(ViewGroup viewGroup, boolean z) {
        MapOption mapOption = new MapOption();
        mapOption.setUseTextureMap(z);
        MapViewHolder mapViewHolder = new MapViewHolder(this.f23145b, mapOption);
        this.f23152i = mapViewHolder;
        mapViewHolder.getMapAsync(new OnMapReadyCallBack() {
            public void onMapReady(Map map) {
                ZGGlobalMapManager.this.f23152i.setLocationVisible(true);
                Map unused = ZGGlobalMapManager.this.f23146c = map;
                ZGGlobalMapManager.this.m16611a();
            }
        });
        MapView mapView = this.f23152i.getMapView();
        if (mapView != null) {
            viewGroup.addView(mapView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16611a() {
        Map map = this.f23146c;
        if (map != null && !this.f23150g) {
            if (map.getUiSettings() != null) {
                this.f23146c.getUiSettings().setAllGesturesEnabled(false);
            }
            m16614b();
            m16617c();
            m16618d();
            this.f23150g = true;
        }
    }

    /* renamed from: b */
    private void m16614b() {
        if (this.f23145b != null && this.f23146c != null && LatLngUtils.locateCorrect(this.f23148e) && this.f23149f == null) {
            DLog.m7384d("AR-ZG", "addDestMarker:" + this.f23148e.longitude + "," + this.f23148e.latitude, new Object[0]);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.position(this.f23148e);
            markerOptions.icon(BitmapDescriptorFactory.fromResource(this.f23145b, ZGThemeManager.getInstance().fromResource(R.drawable.direction_start_global)));
            this.f23149f = this.f23146c.addMarker(markerOptions);
        }
    }

    /* renamed from: c */
    private void m16617c() {
        if (this.f23145b != null && this.f23146c != null && LatLngUtils.locateCorrect(this.f23147d) && LatLngUtils.locateCorrect(this.f23148e)) {
            GuideLine guideLine = this.f23155l;
            if (guideLine != null) {
                guideLine.destroy();
                this.f23155l = null;
            }
            this.f23155l = new GuideLine();
            this.f23155l.setConfigParam(new GuideLineParam(Color.parseColor("#5DBAF9"), this.f23147d, this.f23148e));
            this.f23155l.create(this.f23145b, this.f23146c);
            this.f23155l.setVisible(true);
        }
    }

    /* renamed from: d */
    private void m16618d() {
        if (this.f23146c != null && this.f23145b != null) {
            ArrayList arrayList = new ArrayList();
            LatLng latLng = this.f23148e;
            if (latLng != null) {
                arrayList.add(latLng);
            }
            LatLng latLng2 = this.f23147d;
            if (latLng2 != null) {
                arrayList.add(latLng2);
            }
            Marker marker = this.f23156m;
            if (marker != null) {
                arrayList.add(marker.getPosition());
            }
            BestViewer.doBestView(this.f23146c, false, this.f23147d, (List<LatLng>) arrayList, (Padding) null, m16619e());
        }
    }

    /* renamed from: a */
    private void m16612a(float f) {
        float f2 = this.f23151h;
        if (f2 == 0.0f || Math.abs(f - f2) >= this.f23154k) {
            this.f23151h = f;
            Map map = this.f23146c;
            if (map != null) {
                if (map.getMapVendor() == MapVendor.GOOGLE) {
                    this.f23146c.setRotateAngle(f);
                } else {
                    this.f23146c.setRotateAngle(-f);
                }
            }
            m16615b(f);
            m16618d();
        }
    }

    /* renamed from: e */
    private Padding m16619e() {
        int i;
        int dip2px = DisplayUtils.dip2px(this.f23145b, 20.0f);
        if (this.f23146c.getMapVendor() == MapVendor.DIDI || this.f23146c.getMapVendor() == MapVendor.G_DIDI) {
            i = DisplayUtils.dip2px(this.f23145b, 20.0f);
        } else {
            i = (this.f23145b.getResources().getDisplayMetrics().heightPixels / 3) * 2;
        }
        return new Padding(dip2px, i, dip2px, DisplayUtils.dip2px(this.f23145b, 20.0f));
    }

    public void onStart() {
        MapViewHolder mapViewHolder = this.f23152i;
        if (mapViewHolder != null) {
            mapViewHolder.onStart();
        }
        MapView mapView = this.f23144a;
        if (mapView != null) {
            mapView.onStart();
        }
    }

    public void onResume() {
        MapViewHolder mapViewHolder = this.f23152i;
        if (mapViewHolder != null) {
            mapViewHolder.onResume();
        }
        MapView mapView = this.f23144a;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void onPause() {
        MapViewHolder mapViewHolder = this.f23152i;
        if (mapViewHolder != null) {
            mapViewHolder.onPause();
        }
        MapView mapView = this.f23144a;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void onStop() {
        MapViewHolder mapViewHolder = this.f23152i;
        if (mapViewHolder != null) {
            mapViewHolder.onStop();
        }
        MapView mapView = this.f23144a;
        if (mapView != null) {
            mapView.onStop();
        }
    }

    public void onDestroy() {
        MapViewHolder mapViewHolder = this.f23152i;
        if (mapViewHolder != null) {
            mapViewHolder.onDestroy();
        }
        MapView mapView = this.f23144a;
        if (mapView != null) {
            mapView.onDestroy();
        }
    }

    public void onOrientationChanged(float f) {
        if (this.f23150g) {
            float f2 = (f + 360.0f) % 360.0f;
            float f3 = this.f23151h;
            if (f3 < 0.0f || (Math.abs(f2 - f3) + 360.0f) % 360.0f >= 2.0f) {
                m16612a(f2);
            }
        }
    }

    public void onLocationChanged(LocationUtil.GpscurLocation gpscurLocation) {
        if (this.f23146c != null && gpscurLocation != null && this.f23150g && LatLngUtils.locateCorrect(this.f23148e)) {
            LatLng latLng = new LatLng(gpscurLocation.latitude, gpscurLocation.longitude);
            if (!LatLngUtils.isSameLatLng(this.f23147d, latLng)) {
                this.f23147d = latLng;
                GuideLine guideLine = this.f23155l;
                if (guideLine == null) {
                    m16617c();
                } else {
                    guideLine.updateStartPosition(latLng);
                }
                m16614b();
                m16618d();
            }
        }
    }

    /* renamed from: b */
    private void m16615b(float f) {
        if (this.f23146c != null && LatLngUtils.locateCorrect(this.f23147d) && LatLngUtils.locateCorrect(this.f23148e) && this.f23146c.getProjection() != null) {
            double radians = Math.toRadians((double) f);
            PointF screenLocation = this.f23146c.getProjection().toScreenLocation(this.f23147d);
            PointF screenLocation2 = this.f23146c.getProjection().toScreenLocation(this.f23148e);
            double d = (double) (screenLocation2.x - screenLocation.x);
            double d2 = (double) (screenLocation2.y - screenLocation.y);
            PointF pointF = new PointF();
            double d3 = -radians;
            pointF.x = (float) (((Math.cos(d3) * d) - (Math.sin(d3) * d2)) + ((double) screenLocation.x));
            pointF.y = (float) ((d * Math.sin(d3)) + (d2 * Math.cos(d3)) + ((double) screenLocation.y));
            LatLng fromScreenLocation = this.f23146c.getProjection().fromScreenLocation(pointF);
            Marker marker = this.f23156m;
            if (marker != null) {
                marker.setPosition(fromScreenLocation);
                return;
            }
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.position(fromScreenLocation);
            markerOptions.icon(BitmapDescriptorFactory.fromResource(this.f23145b, R.drawable.direction_start));
            markerOptions.visible(false);
            this.f23156m = this.f23146c.addMarker(markerOptions);
        }
    }
}

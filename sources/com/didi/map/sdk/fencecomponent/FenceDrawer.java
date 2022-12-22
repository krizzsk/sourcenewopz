package com.didi.map.sdk.fencecomponent;

import android.content.Context;
import android.util.SparseIntArray;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.listener.OnPolygonClickListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.util.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FenceDrawer implements IFenceDrawer {

    /* renamed from: a */
    private static final String f28272a = "FenceDrawer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f28273b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FenceComponentParam f28274c;

    /* renamed from: d */
    private boolean f28275d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public double f28276e = 0.0d;

    /* renamed from: f */
    private String f28277f = "global_fences";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SparseIntArray f28278g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SparseIntArray f28279h;

    /* renamed from: i */
    private OnCameraChangeListener f28280i = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            if (FenceDrawer.this.f28273b != null && FenceDrawer.this.f28274c.limitZoom >= 0.0d) {
                if (FenceDrawer.this.f28276e >= FenceDrawer.this.f28274c.limitZoom && FenceDrawer.this.f28273b.getCameraPosition().zoom < FenceDrawer.this.f28274c.limitZoom) {
                    FenceDrawer.this.visible(false);
                } else if (FenceDrawer.this.f28276e < FenceDrawer.this.f28274c.limitZoom && FenceDrawer.this.f28273b.getCameraPosition().zoom >= FenceDrawer.this.f28274c.limitZoom) {
                    FenceDrawer.this.visible(true);
                }
                FenceDrawer fenceDrawer = FenceDrawer.this;
                double unused = fenceDrawer.f28276e = fenceDrawer.f28273b.getCameraPosition().zoom;
            }
        }
    };

    /* renamed from: j */
    private OnPolygonClickListener f28281j = new OnPolygonClickListener() {
        public void onPolygonClick(Polygon polygon) {
            if (FenceDrawer.this.f28274c != null && FenceDrawer.this.f28274c.onFenceChangeListener != null && polygon != null) {
                int i = 0;
                if (FenceDrawer.this.f28278g != null) {
                    i = FenceDrawer.this.f28278g.get(polygon.hashCode());
                }
                FenceDrawer.this.f28274c.onFenceChangeListener.onClickFencePolygon(i);
            }
        }
    };

    /* renamed from: k */
    private OnMarkerClickListener f28282k = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (!(FenceDrawer.this.f28274c == null || FenceDrawer.this.f28274c.onFenceChangeListener == null || marker == null)) {
                FenceDrawer.this.f28274c.onFenceChangeListener.onClickFenceMarker(FenceDrawer.this.f28279h != null ? FenceDrawer.this.f28279h.get(marker.hashCode()) : 0);
            }
            return false;
        }
    };

    public void onMapVisible(boolean z) {
    }

    public FenceDrawer() {
        this.f28277f += hashCode();
        this.f28278g = new SparseIntArray();
        this.f28279h = new SparseIntArray();
    }

    public void create(Context context, Map map) {
        if (map != null) {
            this.f28273b = map;
            this.f28276e = map.getCameraPosition().zoom;
            this.f28273b.addOnMarkerClickListener(this.f28282k);
            return;
        }
        throw new IllegalArgumentException("map is null");
    }

    public void destroy() {
        remove();
        Map map = this.f28273b;
        if (map != null) {
            map.removeOnMarkerClickListener(this.f28282k);
            this.f28273b = null;
        }
        this.f28274c = null;
    }

    public void setConfigParam(FenceComponentParam fenceComponentParam) {
        this.f28274c = fenceComponentParam;
    }

    public void add() {
        FenceComponentParam fenceComponentParam = this.f28274c;
        if (fenceComponentParam != null && this.f28273b != null && !CollectionUtil.isEmpty((Collection<?>) fenceComponentParam.fences)) {
            m20064a(this.f28274c.fences);
            if (this.f28274c.limitZoom > -1.0d) {
                this.f28273b.addOnCameraChangeListener(this.f28280i);
            }
            if (this.f28274c.onFenceChangeListener != null) {
                this.f28273b.addOnPolygonClickListener(this.f28281j);
            }
        }
    }

    /* renamed from: a */
    private void m20064a(List<FencePolygon> list) {
        SparseIntArray sparseIntArray;
        SparseIntArray sparseIntArray2;
        if (this.f28273b != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            remove();
            for (FencePolygon next : list) {
                if (!CollectionUtil.isEmpty((Collection<?>) next.polygon)) {
                    PolygonOptions polygonOptions = new PolygonOptions();
                    for (LatLng next2 : next.polygon) {
                        polygonOptions.add(new LatLng(next2.latitude, next2.longitude));
                    }
                    polygonOptions.fillColor(this.f28274c.fillColor).strokeColor(this.f28274c.strokeColor).strokeWidth(this.f28274c.strokeWidth).zIndex(this.f28274c.polygonZIndex).visible(this.f28275d).clickable(true);
                    Polygon addPolygon = this.f28273b.addPolygon(this.f28277f, polygonOptions);
                    if (!(addPolygon == null || (sparseIntArray2 = this.f28278g) == null)) {
                        sparseIntArray2.put(addPolygon.hashCode(), next.f28283id);
                    }
                }
                if (!(next.marker == null || next.icon == null)) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(next.marker).icon(next.icon).zIndex(this.f28274c.markerZIndex).visible(this.f28275d);
                    Marker addMarker = this.f28273b.addMarker(this.f28277f, markerOptions);
                    if (!(addMarker == null || (sparseIntArray = this.f28279h) == null)) {
                        sparseIntArray.put(addMarker.hashCode(), next.f28283id);
                    }
                }
            }
        }
    }

    public void remove() {
        Map map = this.f28273b;
        if (map != null) {
            map.removeElementGroupByTag(this.f28277f);
            this.f28273b.removeOnCameraChangeListener(this.f28280i);
            this.f28273b.removeOnPolygonClickListener(this.f28281j);
            this.f28273b.removeOnMarkerClickListener(this.f28282k);
            this.f28278g.clear();
            this.f28279h.clear();
        }
    }

    public void visible(boolean z) {
        Map map;
        if (this.f28275d != z && (map = this.f28273b) != null) {
            this.f28275d = z;
            ArrayList<IMapElement> elementGroup = map.getElementGroup(this.f28277f);
            if (!CollectionUtil.isEmpty((Collection<?>) elementGroup)) {
                Iterator<IMapElement> it = elementGroup.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(this.f28275d);
                }
            }
        }
    }

    public boolean isVisible() {
        return this.f28275d;
    }
}

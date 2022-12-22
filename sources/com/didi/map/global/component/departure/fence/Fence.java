package com.didi.map.global.component.departure.fence;

import android.util.SparseIntArray;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
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

public class Fence implements IFence {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Map f25119a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FenceOptions f25120b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public double f25121c = 0.0d;

    /* renamed from: d */
    private boolean f25122d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f25123e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SparseIntArray f25124f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SparseIntArray f25125g;

    /* renamed from: h */
    private String f25126h;

    /* renamed from: i */
    private OnCameraChangeListener f25127i = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            if (Fence.this.f25119a != null && Fence.this.f25120b != null && Fence.this.f25120b.getLimitZoom() >= 0.0d) {
                if (Fence.this.f25123e) {
                    if (Fence.this.f25121c >= Fence.this.f25120b.getLimitZoom() && Fence.this.f25119a.getCameraPosition().zoom < Fence.this.f25120b.getLimitZoom()) {
                        Fence.this.setVisible(false);
                    } else if (Fence.this.f25121c < Fence.this.f25120b.getLimitZoom() && Fence.this.f25119a.getCameraPosition().zoom >= Fence.this.f25120b.getLimitZoom()) {
                        Fence.this.setVisible(true);
                    }
                }
                Fence fence = Fence.this;
                double unused = fence.f25121c = fence.f25119a.getCameraPosition().zoom;
            }
        }
    };

    /* renamed from: j */
    private OnMarkerClickListener f25128j = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (!(Fence.this.f25120b == null || Fence.this.f25120b.getFenceListener() == null || marker == null)) {
                Fence.this.f25120b.getFenceListener().onClickFenceMarker(Fence.this.f25125g != null ? Fence.this.f25125g.get(marker.hashCode()) : 0);
            }
            return false;
        }
    };

    /* renamed from: k */
    private OnPolygonClickListener f25129k = new OnPolygonClickListener() {
        public void onPolygonClick(Polygon polygon) {
            if (Fence.this.f25120b != null && Fence.this.f25120b.getFenceListener() != null && polygon != null) {
                Fence.this.f25120b.getFenceListener().onClickFencePolygon(Fence.this.f25124f != null ? Fence.this.f25124f.get(polygon.hashCode()) : 0);
            }
        }
    };

    public Fence(FenceOptions fenceOptions, String str) {
        this.f25120b = fenceOptions;
        this.f25126h = str;
    }

    public void addToMap(Map map) {
        if (map != null && this.f25120b != null && this.f25119a == null) {
            this.f25119a = map;
            m18038a();
            m18041b();
        }
    }

    /* renamed from: a */
    private void m18038a() {
        this.f25124f = new SparseIntArray();
        this.f25125g = new SparseIntArray();
    }

    public void updateFences(List<FencePolygon> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            FenceOptions fenceOptions = this.f25120b;
            if (fenceOptions != null) {
                fenceOptions.setFences(list);
            }
            if (this.f25119a != null) {
                m18041b();
            }
        }
    }

    /* renamed from: b */
    private void m18041b() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f25120b.getFences())) {
            m18039a(this.f25120b.getFences());
            m18042c();
        }
    }

    /* renamed from: c */
    private void m18042c() {
        Map map = this.f25119a;
        if (map != null) {
            this.f25121c = map.getCameraPosition().zoom;
            this.f25119a.addOnMarkerClickListener(this.f25128j);
            if (this.f25120b.getLimitZoom() > -1.0d) {
                this.f25119a.addOnCameraChangeListener(this.f25127i);
            }
            if (this.f25120b.getFenceListener() != null) {
                this.f25119a.addOnPolygonClickListener(this.f25129k);
            }
        }
    }

    /* renamed from: a */
    private void m18039a(List<FencePolygon> list) {
        if (this.f25119a != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            m18045d();
            for (FencePolygon next : list) {
                boolean z = false;
                if (!CollectionUtil.isEmpty((Collection<?>) next.polygon)) {
                    PolygonOptions polygonOptions = new PolygonOptions();
                    for (LatLng next2 : next.polygon) {
                        polygonOptions.add(new LatLng(next2.latitude, next2.longitude));
                    }
                    polygonOptions.fillColor(this.f25120b.getFillColor()).strokeColor(this.f25120b.getStrokeColor()).strokeWidth(this.f25120b.getStrokeWidth()).zIndex(this.f25120b.getPolygonZIndex()).visible(this.f25122d && this.f25123e).clickable(true);
                    Polygon addPolygon = this.f25119a.addPolygon(this.f25126h, polygonOptions);
                    SparseIntArray sparseIntArray = this.f25124f;
                    if (!(sparseIntArray == null || addPolygon == null)) {
                        sparseIntArray.put(addPolygon.hashCode(), next.f25149id);
                    }
                }
                if (!(next.marker == null || next.icon == null)) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    IMapElementOptions zIndex = markerOptions.position(next.marker).icon(next.icon).zIndex(this.f25120b.getMarkerZIndex());
                    if (this.f25122d && this.f25123e) {
                        z = true;
                    }
                    zIndex.visible(z);
                    Marker addMarker = this.f25119a.addMarker(this.f25126h, markerOptions);
                    SparseIntArray sparseIntArray2 = this.f25125g;
                    if (!(sparseIntArray2 == null || addMarker == null)) {
                        sparseIntArray2.put(addMarker.hashCode(), next.f25149id);
                    }
                }
            }
        }
    }

    public void setFenceVisible(boolean z) {
        this.f25123e = z;
        if (!z) {
            setVisible(false);
        } else if (this.f25120b.getLimitZoom() < 0.0d) {
            setVisible(false);
        } else if (this.f25121c < this.f25120b.getLimitZoom()) {
            setVisible(false);
        } else if (this.f25121c >= this.f25120b.getLimitZoom()) {
            setVisible(true);
        }
    }

    public void setVisible(boolean z) {
        Map map;
        if (this.f25122d != z && (map = this.f25119a) != null) {
            this.f25122d = z;
            ArrayList<IMapElement> elementGroup = map.getElementGroup(this.f25126h);
            if (!CollectionUtil.isEmpty((Collection<?>) elementGroup)) {
                Iterator<IMapElement> it = elementGroup.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(this.f25122d);
                }
            }
        }
    }

    /* renamed from: d */
    private void m18045d() {
        Map map = this.f25119a;
        if (map != null) {
            map.removeOnCameraChangeListener(this.f25127i);
            this.f25119a.removeOnPolygonClickListener(this.f25129k);
            this.f25119a.removeOnMarkerClickListener(this.f25128j);
            this.f25119a.removeElementGroupByTag(this.f25126h);
        }
        SparseIntArray sparseIntArray = this.f25124f;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
        }
        SparseIntArray sparseIntArray2 = this.f25125g;
        if (sparseIntArray2 != null) {
            sparseIntArray2.clear();
        }
    }

    public void remove() {
        m18045d();
        this.f25120b = null;
        this.f25119a = null;
    }
}

package com.didi.map.global.component.departure.circle;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ZoneCircleController implements Observer {

    /* renamed from: a */
    private Map f25015a;

    /* renamed from: b */
    private Circle f25016b;

    /* renamed from: c */
    private ZoneCircleOption f25017c;

    /* renamed from: d */
    private Context f25018d;

    /* renamed from: e */
    private boolean f25019e = false;

    public ZoneCircleController(Map map, ZoneCircleOption zoneCircleOption, Context context) {
        this.f25017c = zoneCircleOption;
        this.f25015a = map;
        this.f25018d = context;
        zoneCircleOption.addObserver(this);
    }

    public void showCircle() {
        hideCircle();
        this.f25016b = this.f25015a.addCircle(this.f25017c.getCircleOptions());
    }

    public void hideCircle() {
        Circle circle = this.f25016b;
        if (circle != null) {
            this.f25015a.remove(circle);
            this.f25016b = null;
        }
    }

    public List<LatLng> getBestViewPoints() {
        ArrayList arrayList = new ArrayList();
        Circle circle = this.f25016b;
        if (circle != null) {
            arrayList.addAll(circle.getBounderPoints());
        }
        return arrayList;
    }

    public LatLng getCenter() {
        return this.f25017c.getCenter();
    }

    public boolean allowDragToOuter() {
        ZoneCircleOption zoneCircleOption = this.f25017c;
        if (zoneCircleOption == null) {
            return true;
        }
        return zoneCircleOption.isAllowDragToOuter();
    }

    public boolean isOutside() {
        Map map;
        if (this.f25016b == null || (map = this.f25015a) == null || map.getCameraPosition() == null) {
            return false;
        }
        boolean z = !this.f25016b.contains(this.f25015a.getCameraPosition().target);
        this.f25019e = z;
        return z;
    }

    public boolean handleMapDrag(LatLng latLng) {
        Circle circle;
        if (latLng == null || (circle = this.f25016b) == null) {
            return this.f25019e;
        }
        boolean contains = circle.contains(latLng);
        if (contains) {
            if (this.f25019e) {
                this.f25016b.setStrokeColor(this.f25017c.getStrokeColor());
                this.f25016b.setFillColor(this.f25017c.getFillColor());
            }
        } else if (!this.f25019e) {
            this.f25016b.setStrokeColor(-49056);
            this.f25016b.setFillColor(872366176);
        }
        boolean z = !contains;
        this.f25019e = z;
        return z;
    }

    public void update(Observable observable, Object obj) {
        if (observable instanceof ZoneCircleOption) {
            this.f25017c = (ZoneCircleOption) observable;
            showCircle();
        }
    }

    public Circle getCircle() {
        return this.f25016b;
    }
}

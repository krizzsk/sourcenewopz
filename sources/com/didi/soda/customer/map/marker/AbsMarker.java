package com.didi.soda.customer.map.marker;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.foundation.sdk.map.IMapView;
import com.didi.global.map.animation.transition.util.AngleUtil;
import com.didi.map.global.component.line.component.ArcLineComponent;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapUtil;
import com.didi.soda.customer.map.InfoWindowOptions;
import com.didi.soda.customer.map.MapInfoWindowManager;
import java.util.Collection;
import java.util.List;

public abstract class AbsMarker {

    /* renamed from: d */
    private static final int f41368d = 4;

    /* renamed from: e */
    private static final String f41369e = "#ADE3CC";

    /* renamed from: a */
    private Marker f41370a;

    /* renamed from: b */
    private IMapView f41371b;

    /* renamed from: c */
    private ICompLineContract f41372c;

    /* renamed from: f */
    private boolean f41373f = false;
    protected Context mContext;
    protected InfoWindow mInfoWindow;

    public void attachToMap(LatLng latLng) {
    }

    public abstract String getTag();

    public void onAdd() {
    }

    public abstract void show(LatLng latLng);

    AbsMarker(Context context, IMapView iMapView) {
        this.mContext = context;
        this.f41371b = iMapView;
    }

    public void updateMapView(IMapView iMapView) {
        if (this.f41371b == null) {
            this.f41371b = iMapView;
        }
    }

    public Marker getMarker() {
        return this.f41370a;
    }

    public void setVisible(boolean z) {
        Marker marker = this.f41370a;
        if (marker != null) {
            marker.setVisible(z);
        }
    }

    public boolean isVisible() {
        try {
            if (this.f41370a == null) {
                return false;
            }
            return this.f41370a.isVisible();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isExist() {
        return this.f41373f;
    }

    public void removeLine() {
        ICompLineContract iCompLineContract = this.f41372c;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f41372c = null;
        }
    }

    public void setLineVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f41372c;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }

    /* access modifiers changed from: protected */
    public void draw(MarkerOptions markerOptions) {
        if (this.f41373f) {
            remove();
        }
        IMapView iMapView = this.f41371b;
        if (iMapView != null) {
            this.f41370a = iMapView.addMarker(getTag(), markerOptions);
            this.f41373f = true;
            onAdd();
        }
    }

    /* access modifiers changed from: protected */
    public void draw(MarkerOptions markerOptions, List<LatLng> list) {
        if (this.f41373f) {
            remove();
        }
        if (this.f41371b != null) {
            if (list != null && list.size() == 2) {
                LineParams lineParams = new LineParams(list, Color.parseColor(f41369e), 4);
                lineParams.setEnableEarthWormLine(false);
                lineParams.setZIndex(10);
                lineParams.setLinePoints(list);
                lineParams.setEnableDirArrow(false);
                if (m29309a(list.get(0), list.get(1))) {
                    this.f41372c = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_ARC, this.f41371b.getDidiCommonMap(), this.mContext, lineParams);
                } else {
                    this.f41372c = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f41371b.getDidiCommonMap(), this.mContext, lineParams);
                }
                this.f41372c.start();
                this.f41372c.setLineVisible(false);
            }
            this.f41370a = this.f41371b.addMarker(getTag(), markerOptions);
            this.f41373f = true;
            onAdd();
        }
    }

    public void remove() {
        removeInfoWindow();
        IMapView iMapView = this.f41371b;
        if (iMapView != null) {
            iMapView.removeElement(getTag());
        }
        ICompLineContract iCompLineContract = this.f41372c;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.mInfoWindow = null;
        this.f41373f = false;
    }

    public void onDestroy() {
        removeInfoWindow();
        IMapView iMapView = this.f41371b;
        if (iMapView != null) {
            iMapView.removeElement(getTag());
        }
        ICompLineContract iCompLineContract = this.f41372c;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f41372c = null;
        }
        this.f41370a = null;
        this.mInfoWindow = null;
        this.f41373f = false;
    }

    public void hideInfoWindow() {
        m29308a(false);
    }

    /* renamed from: a */
    private void m29308a(boolean z) {
        MapInfoWindowManager.Companion.getInstance().setInfoWindowVisible(this.f41370a, z);
    }

    public void removeInfoWindow() {
        MapInfoWindowManager.Companion.getInstance().removeInfoWindow(this.f41370a);
    }

    public void showInfoWindow() {
        m29308a(true);
    }

    public InfoWindow buildInfoWindow(Context context, InfoWindowOptions infoWindowOptions) {
        return MapInfoWindowManager.Companion.getInstance().createInfoWindow(this.f41370a, this.f41371b, infoWindowOptions, context);
    }

    public LatLng getLineCenter() {
        ICompLineContract iCompLineContract = this.f41372c;
        if (iCompLineContract == null) {
            return null;
        }
        List<LatLng> allLinePoints = iCompLineContract.getAllLinePoints();
        if (CollectionUtil.isEmpty((Collection<?>) allLinePoints)) {
            return null;
        }
        if (!(this.f41372c instanceof ArcLineComponent) || allLinePoints.size() <= 2) {
            return OrderMapUtil.getLineCenter(allLinePoints.get(0), allLinePoints.get(allLinePoints.size() - 1));
        }
        return allLinePoints.get(allLinePoints.size() / 2);
    }

    /* renamed from: a */
    private boolean m29309a(LatLng latLng, LatLng latLng2) {
        double angle = (double) AngleUtil.getAngle(latLng, latLng2);
        return Math.abs(angle) % 90.0d > 15.0d && Math.abs(angle) % 90.0d < 90.0d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f41370a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRealExistInMapView() {
        /*
            r1 = this;
            boolean r0 = r1.isExist()
            if (r0 == 0) goto L_0x0012
            com.didi.common.map.model.Marker r0 = r1.f41370a
            if (r0 == 0) goto L_0x0012
            com.didi.common.map.model.MarkerOptions r0 = r0.getOptions()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.map.marker.AbsMarker.isRealExistInMapView():boolean");
    }
}

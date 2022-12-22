package com.didi.map.global.component.line.pax.walkanddropoff.newversion;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.component.myLocation.view.LocationAccuracyCircleOptions;
import com.didi.map.global.component.myLocation.view.MyLocationMarker;
import com.didi.map.global.component.myLocation.view.MyLocationMarkerOptions;
import java.util.ArrayList;
import java.util.List;

public class PsgLocationMarker {

    /* renamed from: a */
    private String f25951a = "PsgLocationMarker";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MyLocationMarker f25952b;

    /* renamed from: c */
    private Context f25953c;

    /* renamed from: d */
    private Map f25954d;

    /* renamed from: e */
    private OrientationListener f25955e;

    public PsgLocationMarker(Context context, Map map) {
        this.f25953c = context;
        this.f25954d = map;
        MyLocationMarker myLocationMarker = new MyLocationMarker(new MyLocationMarkerOptions.Builder().accuracyCircleOptions((LocationAccuracyCircleOptions) null).zIndex(1).map(this.f25954d).build());
        this.f25952b = myLocationMarker;
        myLocationMarker.addSelf();
        this.f25952b.setVisible(true);
        m18444a();
    }

    public void updatePosition(LatLng latLng) {
        MyLocationMarker myLocationMarker;
        if (LatLngUtils.locateCorrect(latLng) && (myLocationMarker = this.f25952b) != null) {
            myLocationMarker.updatePosition(latLng);
        }
    }

    public void destroy() {
        MyLocationMarker myLocationMarker = this.f25952b;
        if (myLocationMarker != null) {
            myLocationMarker.removeSelf(false, 0);
            this.f25952b = null;
        }
        if (this.f25955e != null) {
            OrientationManager.getInstance(this.f25953c).removeOrientationListener(this.f25955e);
            this.f25955e = null;
        }
    }

    /* renamed from: a */
    private void m18444a() {
        if (this.f25953c != null && this.f25954d != null) {
            this.f25955e = new OrientationListener() {
                public void onOrientationChanged(float f, float f2, float f3) {
                    if (PsgLocationMarker.this.f25952b != null) {
                        PsgLocationMarker.this.f25952b.updateArrowRotateAngle(f);
                    }
                }
            };
            OrientationManager.getInstance(this.f25953c).addOrientationListener(this.f25955e);
        }
    }

    public List<IMapElement> getBestViewElements() {
        MyLocationMarker myLocationMarker = this.f25952b;
        if (myLocationMarker != null) {
            return myLocationMarker.getMarkers();
        }
        return new ArrayList();
    }
}

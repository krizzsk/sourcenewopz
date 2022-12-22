package com.didi.hawaii.mapsdkv2.adapter;

import android.graphics.Color;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.hawaii.mapsdkv2.core.GLAndroidView;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.map.alpha.maps.internal.MarkerViewControl;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.MapView;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.MarkerView;
import java.util.Map;

public class MarkerViewDelegate extends C9003b implements MarkerViewControl {

    /* renamed from: b */
    private final MapView f23722b;

    /* renamed from: c */
    private final DidiMap f23723c;

    /* renamed from: d */
    private FrameLayout f23724d = null;

    /* renamed from: e */
    private int f23725e = 0;

    public MarkerViewDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map, MapView mapView, DidiMap didiMap) {
        super(gLViewManager, map);
        this.f23722b = mapView;
        this.f23723c = didiMap;
    }

    public MarkerView add(View view, LatLng latLng) {
        return add(view, latLng, 0.5f, 0.5f);
    }

    public MarkerView add(View view, LatLng latLng, float f, float f2) {
        if (this.f23723c.isDestroyed()) {
            return null;
        }
        this.f23725e++;
        ensureHostView();
        GLAndroidView.Option option = new GLAndroidView.Option();
        option.setVisible(true);
        option.view = view;
        option.latLng = latLng;
        option.anchorX = f;
        option.anchorY = f2;
        GLAndroidView gLAndroidView = new GLAndroidView(this.viewManager, option, this.f23724d);
        this.viewManager.addView((GLOverlayView) gLAndroidView);
        return new MarkerView(this, gLAndroidView);
    }

    public FrameLayout ensureHostView() {
        if (this.f23724d == null) {
            FrameLayout frameLayout = new FrameLayout(this.context);
            this.f23724d = frameLayout;
            frameLayout.setBackgroundColor(Color.argb(0, 255, 255, 255));
            this.f23722b.addView(this.f23724d);
        }
        return this.f23724d;
    }

    public void remove(MarkerView markerView, Object obj) {
        FrameLayout frameLayout;
        GLAndroidView a = m16865a(obj);
        if (a != null) {
            this.viewManager.removeView(a);
            int i = this.f23725e - 1;
            this.f23725e = i;
            if (i == 0 && (frameLayout = this.f23724d) != null) {
                this.f23722b.removeView(frameLayout);
            }
        }
    }

    public void setCenter(MarkerView markerView, Object obj, LatLng latLng) {
        GLAndroidView a = m16865a(obj);
        if (a != null) {
            a.setCenter(latLng);
        }
    }

    /* renamed from: a */
    private static GLAndroidView m16865a(Object obj) {
        if (obj instanceof GLAndroidView) {
            return (GLAndroidView) obj;
        }
        return null;
    }
}

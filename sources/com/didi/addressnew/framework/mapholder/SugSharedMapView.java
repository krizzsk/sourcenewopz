package com.didi.addressnew.framework.mapholder;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.internal.IMapElement;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

public class SugSharedMapView {

    /* renamed from: f */
    private static SugSharedMapView f7390f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MapViewHolder f7391a;

    /* renamed from: b */
    private Context f7392b;

    /* renamed from: c */
    private ViewGroup f7393c;

    /* renamed from: d */
    private HighEndMobile f7394d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f7395e = true;

    public static SugSharedMapView getInstance(Context context) {
        synchronized (SugSharedMapView.class) {
            if (f7390f == null) {
                f7390f = new SugSharedMapView(context.getApplicationContext());
            }
        }
        return f7390f;
    }

    private SugSharedMapView(Context context) {
        this.f7392b = context;
        MapViewHolder mapViewHolder = new MapViewHolder(context);
        this.f7391a = mapViewHolder;
        mapViewHolder.getMapAsync(new OnMapReadyCallBack() {
            public void onMapReady(Map map) {
                if (SugSharedMapView.this.f7391a != null) {
                    SugSharedMapView.this.f7391a.setLocationVisible(SugSharedMapView.this.f7395e);
                }
            }
        });
        this.f7394d = new HighEndMobile();
    }

    public List<IMapElement> getMyLocationMarkers() {
        MapViewHolder mapViewHolder = this.f7391a;
        if (mapViewHolder != null) {
            return mapViewHolder.getMyLocationMarkers();
        }
        return null;
    }

    public MapView getMapView() {
        MapViewHolder mapViewHolder = this.f7391a;
        if (mapViewHolder == null) {
            return null;
        }
        return mapViewHolder.getMapView();
    }

    public void setNeedLocation(boolean z) {
        this.f7395e = z;
    }

    public void onAdd(ViewGroup viewGroup) {
        MapViewHolder mapViewHolder;
        if (viewGroup != this.f7393c && (mapViewHolder = this.f7391a) != null && mapViewHolder.getMapView() != null && viewGroup != null) {
            onRemove(this.f7393c);
            viewGroup.addView(this.f7391a.getMapView());
            this.f7393c = viewGroup;
            this.f7391a.setLocationVisible(this.f7395e);
            SystemUtils.log(3, "LocXXX", "onAdd: ", (Throwable) null, "com.didi.addressnew.framework.mapholder.SugSharedMapView", 81);
        }
    }

    public void onRemove(ViewGroup viewGroup) {
        MapViewHolder mapViewHolder;
        if (viewGroup != null && (mapViewHolder = this.f7391a) != null && mapViewHolder.getMapView() != null && viewGroup == this.f7393c) {
            viewGroup.removeView(this.f7391a.getMapView());
            this.f7393c = null;
        }
    }

    public void onStart() {
        MapViewHolder mapViewHolder = this.f7391a;
        if (mapViewHolder != null) {
            mapViewHolder.onStart();
        }
    }

    public void onResume() {
        MapViewHolder mapViewHolder = this.f7391a;
        if (mapViewHolder != null) {
            mapViewHolder.onResume();
            this.f7391a.setLocationVisible(this.f7395e);
        }
    }

    public void onPause() {
        MapViewHolder mapViewHolder = this.f7391a;
        if (mapViewHolder != null) {
            mapViewHolder.onPause();
            this.f7391a.setLocationVisible(false);
        }
    }

    public void onStop() {
        MapViewHolder mapViewHolder = this.f7391a;
        if (mapViewHolder != null) {
            mapViewHolder.onStop();
        }
    }

    public void onDestroy() {
        onRemove(this.f7393c);
        m4631a();
    }

    /* renamed from: a */
    private void m4631a() {
        if (!this.f7394d.isHighEndMobile(this.f7392b)) {
            MapViewHolder mapViewHolder = this.f7391a;
            if (mapViewHolder != null) {
                mapViewHolder.onDestroy();
                this.f7391a = null;
            }
            this.f7394d = null;
            f7390f = null;
        }
    }

    public void onLowMemory() {
        MapViewHolder mapViewHolder = this.f7391a;
        if (mapViewHolder != null) {
            mapViewHolder.onLowMemory();
        }
    }
}

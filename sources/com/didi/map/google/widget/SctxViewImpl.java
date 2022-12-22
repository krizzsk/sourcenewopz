package com.didi.map.google.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.model.ErrorCodeCollect;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.taxis99.R;
import java.util.List;

public class SctxViewImpl implements ISctxViewDelegate {
    public static final int LINE_COLOR = Color.parseColor("#262B2E");
    public static final int LINE_COLOR_HAS_TRAFFIC = Color.parseColor("#6883F4");
    public static final float MASK_ALPHA = 0.1f;
    public static final int MASK_COLOR = Color.parseColor("#B4E6FF");
    public static final int NEW_LINE_COLOR = Color.parseColor("#33BBFF");

    /* renamed from: e */
    private static final float f27812e = 0.5f;

    /* renamed from: a */
    private final Context f27813a;

    /* renamed from: b */
    private Map f27814b;

    /* renamed from: c */
    private BitmapDescriptor f27815c;

    /* renamed from: d */
    private int f27816d;

    /* renamed from: f */
    private InfoWindow f27817f;

    /* renamed from: g */
    private IMyLocationDelegate f27818g;

    /* renamed from: h */
    private ErrorCodeCollect f27819h;

    public SctxViewImpl(Context context, Map map, IMyLocationDelegate iMyLocationDelegate, ErrorCodeCollect errorCodeCollect) {
        this.f27819h = errorCodeCollect;
        this.f27813a = context;
        this.f27814b = map;
        this.f27818g = iMyLocationDelegate;
    }

    public void setLocationDelegate(IMyLocationDelegate iMyLocationDelegate) {
        this.f27818g = iMyLocationDelegate;
    }

    public void setCarMarkerBitmap(BitmapDescriptor bitmapDescriptor) {
        this.f27815c = bitmapDescriptor;
        IMyLocationDelegate iMyLocationDelegate = this.f27818g;
        if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
            this.f27818g.getCarMarker().setIcon(this.f27813a, this.f27815c);
        }
    }

    public void setCarMarkerZIndex(int i) {
        this.f27816d = i;
    }

    public void set3DCarEnabled(boolean z) {
        IMyLocationDelegate iMyLocationDelegate = this.f27818g;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.set3DCarEnabled(z);
        }
    }

    public void set3DCarIcons(List<String> list) {
        IMyLocationDelegate iMyLocationDelegate = this.f27818g;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.set3DCarIcons(list);
        }
    }

    public boolean refresh3DCarIcons(boolean z, List<String> list) {
        IMyLocationDelegate iMyLocationDelegate = this.f27818g;
        if (iMyLocationDelegate != null) {
            return iMyLocationDelegate.refresh3DCarIcons(z, list);
        }
        return false;
    }

    public CarMarker getCarMarker() {
        return this.f27818g.getCarMarker();
    }

    public void removeMarker() {
        IMyLocationDelegate iMyLocationDelegate;
        Map map = this.f27814b;
        if (map != null && (iMyLocationDelegate = this.f27818g) != null) {
            map.remove(iMyLocationDelegate.getCarMarker());
        }
    }

    public void updateCarMarker(LatLng latLng) {
        if (this.f27815c == null) {
            this.f27815c = BitmapDescriptorFactory.fromResource(this.f27813a, R.drawable.gua_sliding_pop);
        }
        IMyLocationDelegate iMyLocationDelegate = this.f27818g;
        if (iMyLocationDelegate == null) {
            return;
        }
        if (iMyLocationDelegate.getCarMarker() == null) {
            this.f27818g.setCarMarkerOptions(SctxService.SctxMapElementTags.CAR_MARKER, new MarkerOptions().icon(this.f27815c).draggable(false).anchor(0.5f, 0.5f).position(latLng));
            if (this.f27816d <= 0 || this.f27818g.getCarMarker() == null) {
                this.f27819h.setDriverError(4);
            } else {
                this.f27818g.getCarMarker().setZIndex(this.f27816d);
            }
        } else {
            this.f27818g.getCarMarker().setPosition(latLng);
        }
    }

    public void updateCarDirection(float f) {
        IMyLocationDelegate iMyLocationDelegate = this.f27818g;
        if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
            this.f27818g.getCarMarker().setRotation(f);
        }
    }

    public void showInfoWindow(Map map, View view) {
        IMyLocationDelegate iMyLocationDelegate;
        if (!(this.f27817f != null || (iMyLocationDelegate = this.f27818g) == null || iMyLocationDelegate.getCarMarker() == null)) {
            this.f27817f = this.f27818g.getCarMarker().buildInfoWindow(map, this.f27813a);
        }
        InfoWindow infoWindow = this.f27817f;
        if (infoWindow != null) {
            infoWindow.showInfoWindow(view);
        }
    }

    public void destroyInfoWindow() {
        InfoWindow infoWindow = this.f27817f;
        if (infoWindow != null) {
            infoWindow.destroy();
            this.f27817f = null;
        }
    }

    public void destroy() {
        IMyLocationDelegate iMyLocationDelegate = this.f27818g;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
        }
        destroyInfoWindow();
        removeMarker();
    }
}

package com.didi.common.map.model.infowindow;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;

public final class InfoWindowV2 implements InfoWindow {
    public static final String MARKER_INFOWINDOW_TAG = "infoWindow_tag";

    /* renamed from: a */
    private InfoWindow.Position f10931a;

    /* renamed from: b */
    private Context f10932b;

    /* renamed from: c */
    private Map f10933c;

    /* renamed from: d */
    private Marker f10934d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Marker f10935e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnInfoWindowClickListener f10936f;

    /* renamed from: g */
    private OnMarkerClickListener f10937g = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (marker == null || !marker.equals(InfoWindowV2.this.f10935e) || InfoWindowV2.this.f10936f == null) {
                return false;
            }
            InfoWindowV2.this.f10936f.onInfoWindowClick(marker);
            return false;
        }
    };

    public InfoWindowV2(Map map, Context context, Marker marker) {
        this.f10933c = map;
        this.f10932b = context.getApplicationContext();
        this.f10934d = marker;
        m7378e();
        this.f10931a = InfoWindow.Position.TOP;
    }

    public InfoWindowV2(Map map, Context context, InfoWindow.Position position, Marker marker) {
        this.f10933c = map;
        this.f10931a = position;
        this.f10934d = marker;
        this.f10932b = context.getApplicationContext();
        m7378e();
    }

    public void setPosition(InfoWindow.Position position) {
        this.f10931a = position;
    }

    public void showInfoWindow(View view) {
        if (view != null && this.f10934d != null) {
            if (this.f10935e == null) {
                this.f10935e = this.f10933c.addMarker(m7372a(view));
                return;
            }
            try {
                Bitmap viewBitmap = MapUtils.getViewBitmap(view);
                this.f10935e.setVisible(true);
                this.f10935e.setAnchor(m7368a(viewBitmap), m7373b(viewBitmap));
                this.f10935e.setPosition(m7370a(this.f10934d));
                this.f10935e.setIcon(this.f10932b, BitmapDescriptorFactory.fromBitmap(viewBitmap));
            } catch (Exception e) {
                HashMap hashMap = new HashMap();
                hashMap.put("status", "-1");
                hashMap.put("message", "mInfoWindowMarker" + this.f10935e + "--->errorMessage" + e.getMessage());
                OmegaSDKAdapter.trackEvent("tech_marker_set_icon_status", "-1", hashMap);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(e.getMessage());
                DLog.m7384d("infoWindow_tag", sb.toString(), new Object[0]);
            }
        }
    }

    /* renamed from: a */
    private float m7368a(Bitmap bitmap) {
        Marker marker = this.f10934d;
        if (marker == null || bitmap == null || marker.getOptions() == null || this.f10931a == null) {
            return 0.5f;
        }
        float anchorU = this.f10934d.getOptions().getAnchorU();
        if (this.f10931a == InfoWindow.Position.TOP || this.f10931a == InfoWindow.Position.BOTTOM) {
            return anchorU;
        }
        if (this.f10931a == InfoWindow.Position.LEFT || this.f10931a == InfoWindow.Position.LEFT_TOP || this.f10931a == InfoWindow.Position.LEFT_BOTTOM) {
            return ((m7376c() * anchorU) / ((float) bitmap.getWidth())) + 1.0f;
        } else if (this.f10931a != InfoWindow.Position.RIGHT && this.f10931a != InfoWindow.Position.RIGHT_TOP && this.f10931a != InfoWindow.Position.RIGHT_BOTTOM) {
            return 0.5f;
        } else {
            float c = m7376c();
            return -((c - (anchorU * c)) / ((float) bitmap.getWidth()));
        }
    }

    /* renamed from: b */
    private float m7373b(Bitmap bitmap) {
        Marker marker = this.f10934d;
        if (marker == null || bitmap == null || marker.getOptions() == null || this.f10931a == null) {
            return 1.0f;
        }
        float anchorV = this.f10934d.getOptions().getAnchorV();
        if (this.f10931a == InfoWindow.Position.LEFT || this.f10931a == InfoWindow.Position.RIGHT) {
            return anchorV;
        }
        if (this.f10931a == InfoWindow.Position.TOP || this.f10931a == InfoWindow.Position.LEFT_TOP || this.f10931a == InfoWindow.Position.RIGHT_TOP) {
            return ((m7377d() * anchorV) / ((float) bitmap.getHeight())) + 1.0f;
        } else if (this.f10931a != InfoWindow.Position.BOTTOM && this.f10931a != InfoWindow.Position.LEFT_BOTTOM && this.f10931a != InfoWindow.Position.RIGHT_BOTTOM) {
            return 1.0f;
        } else {
            float d = m7377d();
            return (-(d - (anchorV * d))) / ((float) bitmap.getHeight());
        }
    }

    /* renamed from: a */
    private MarkerOptions m7372a(View view) {
        if (this.f10934d == null) {
            return null;
        }
        Bitmap viewBitmap = MapUtils.getViewBitmap(view);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(this.f10934d.getPosition());
        markerOptions.anchor(m7368a(viewBitmap), m7373b(viewBitmap));
        markerOptions.flat(this.f10934d.isFlat());
        markerOptions.zIndex(this.f10934d.getZIndex());
        markerOptions.clickable(true);
        markerOptions.visible(true);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(viewBitmap));
        return markerOptions;
    }

    /* renamed from: a */
    private LatLng m7370a(Marker marker) {
        if (marker == null) {
            return null;
        }
        return marker.getPosition();
    }

    /* renamed from: a */
    private int m7369a() {
        Marker marker = this.f10934d;
        if (marker == null || marker.getIcon() == null || this.f10934d.getIcon().getBitmap() == null || this.f10934d.getOptions() == null) {
            return 0;
        }
        return this.f10934d.getIcon().getBitmap().getWidth();
    }

    /* renamed from: b */
    private int m7374b() {
        Marker marker = this.f10934d;
        if (marker == null || marker.getIcon() == null || this.f10934d.getIcon().getBitmap() == null || this.f10934d.getOptions() == null) {
            return 0;
        }
        return this.f10934d.getIcon().getBitmap().getHeight();
    }

    /* renamed from: c */
    private float m7376c() {
        return (float) m7369a();
    }

    /* renamed from: d */
    private float m7377d() {
        Marker marker = this.f10934d;
        if (marker == null || !marker.getEnableTopHeightInterval()) {
            return (float) m7374b();
        }
        return this.f10934d.getTopHeightInterval();
    }

    public void setPosition(LatLng latLng) {
        if (this.f10935e != null && LatLngUtils.locateCorrect(latLng)) {
            this.f10935e.setPosition(latLng);
        }
    }

    public void hideInfoWindow() {
        Marker marker = this.f10935e;
        if (marker != null) {
            marker.setVisible(false);
        }
    }

    public Marker getInfoWindowMarker() {
        return this.f10935e;
    }

    public boolean isInfoWindowShown() {
        Marker marker = this.f10935e;
        return marker != null && marker.isVisible();
    }

    public void updateAnchor() {
        Marker marker = this.f10935e;
        if (marker != null && marker.getIcon() != null) {
            this.f10935e.setAnchor(m7368a(this.f10935e.getIcon().getBitmap()), m7373b(this.f10935e.getIcon().getBitmap()));
        }
    }

    /* renamed from: e */
    private void m7378e() {
        Map map = this.f10933c;
        if (map != null) {
            map.addOnMarkerClickListener(this.f10937g);
        }
    }

    /* renamed from: f */
    private void m7379f() {
        Map map = this.f10933c;
        if (map != null) {
            map.removeOnMarkerClickListener(this.f10937g);
        }
    }

    public void addOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (this.f10933c != null && onInfoWindowClickListener != null) {
            this.f10936f = onInfoWindowClickListener;
        }
    }

    public void removeOnInfoWindowClickListener() {
        this.f10936f = null;
    }

    public void destroy() {
        Marker marker;
        Map map = this.f10933c;
        if (!(map == null || (marker = this.f10935e) == null)) {
            map.remove(marker);
            this.f10935e = null;
        }
        removeOnInfoWindowClickListener();
        this.f10937g = null;
        m7379f();
        this.f10933c = null;
        this.f10932b = null;
    }
}

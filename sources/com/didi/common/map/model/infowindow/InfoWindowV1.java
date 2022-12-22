package com.didi.common.map.model.infowindow;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.Projection;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;

public final class InfoWindowV1 implements InfoWindow {
    public static final String MARKER_INFOWINDOW_TAG = "infoWindow_tag";

    /* renamed from: a */
    private InfoWindow.Position f10920a;

    /* renamed from: b */
    private Context f10921b;

    /* renamed from: c */
    private Map f10922c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Marker f10923d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Marker f10924e;

    /* renamed from: f */
    private Projection f10925f;

    /* renamed from: g */
    private int f10926g;

    /* renamed from: h */
    private int f10927h;

    /* renamed from: i */
    private OnCameraChangeListener f10928i = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            InfoWindowV1 infoWindowV1 = InfoWindowV1.this;
            infoWindowV1.m7363b(infoWindowV1.f10923d);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public OnInfoWindowClickListener f10929j;

    /* renamed from: k */
    private OnMarkerClickListener f10930k = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (marker == null || !marker.equals(InfoWindowV1.this.f10924e) || InfoWindowV1.this.f10929j == null) {
                return false;
            }
            InfoWindowV1.this.f10929j.onInfoWindowClick(marker);
            return false;
        }
    };

    public InfoWindowV1(Map map, Context context, Marker marker) {
        this.f10922c = map;
        this.f10921b = context.getApplicationContext();
        this.f10923d = marker;
        Map map2 = this.f10922c;
        if (map2 != null) {
            this.f10925f = map2.getProjection();
        }
        m7366d();
    }

    public InfoWindowV1(Map map, Context context, InfoWindow.Position position, Marker marker) {
        this.f10922c = map;
        this.f10920a = position;
        this.f10923d = marker;
        this.f10921b = context.getApplicationContext();
        Map map2 = this.f10922c;
        if (map2 != null) {
            this.f10925f = map2.getProjection();
        }
        m7366d();
    }

    public void setPosition(InfoWindow.Position position) {
        this.f10920a = position;
    }

    public void showInfoWindow(View view) {
        if (view != null && this.f10923d != null) {
            m7359a();
            m7362b();
            if (this.f10924e != null || this.f10922c == null) {
                try {
                    this.f10924e.setVisible(true);
                    this.f10924e.setPosition(m7356a(this.f10923d));
                    this.f10924e.setIcon(this.f10921b, BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(view)));
                } catch (Exception e) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("status", "-1");
                    hashMap.put("message", "mInfoWindowMarker" + this.f10924e + "--->errorMessage" + e.getMessage());
                    OmegaSDKAdapter.trackEvent("tech_marker_set_icon_status", "-1", hashMap);
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(e.getMessage());
                    DLog.m7384d("infoWindow_tag", sb.toString(), new Object[0]);
                }
            } else {
                this.f10924e = this.f10922c.addMarker(m7358a(view));
            }
        }
    }

    /* renamed from: a */
    private void m7359a() {
        Marker marker = this.f10923d;
        if (marker != null && marker.getIcon() != null && this.f10923d.getIcon().getBitmap() != null && this.f10923d.getOptions() != null) {
            int width = this.f10923d.getIcon().getBitmap().getWidth();
            InfoWindow.Position position = this.f10920a;
            if (position == null) {
                this.f10926g = (int) (((float) width) * this.f10923d.getOptions().getAnchorU());
            } else if (position == InfoWindow.Position.LEFT || this.f10920a == InfoWindow.Position.LEFT_TOP || this.f10920a == InfoWindow.Position.LEFT_BOTTOM) {
                float f = (float) width;
                this.f10926g = (int) (f - (this.f10923d.getOptions().getAnchorU() * f));
            } else {
                this.f10926g = (int) (((float) width) * this.f10923d.getOptions().getAnchorU());
            }
        }
    }

    /* renamed from: b */
    private void m7362b() {
        Marker marker = this.f10923d;
        if (marker != null && marker.getIcon() != null && this.f10923d.getIcon().getBitmap() != null && this.f10923d.getOptions() != null) {
            int height = this.f10923d.getIcon().getBitmap().getHeight();
            InfoWindow.Position position = this.f10920a;
            if (position == null) {
                this.f10927h = (int) (((float) height) * this.f10923d.getOptions().getAnchorV());
            } else if (position == InfoWindow.Position.BOTTOM || this.f10920a == InfoWindow.Position.LEFT_BOTTOM || this.f10920a == InfoWindow.Position.RIGHT_BOTTOM) {
                float f = (float) height;
                this.f10927h = (int) (f - (this.f10923d.getOptions().getAnchorV() * f));
            } else {
                this.f10927h = (int) (((float) height) * this.f10923d.getOptions().getAnchorV());
            }
        }
    }

    /* renamed from: a */
    private MarkerOptions m7358a(View view) {
        if (this.f10923d == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(m7356a(this.f10923d));
        InfoWindow.Position position = this.f10920a;
        if (position == null) {
            markerOptions.anchor(0.5f, 1.0f);
        } else if (position == InfoWindow.Position.TOP) {
            markerOptions.anchor(0.5f, 1.0f);
        } else if (this.f10920a == InfoWindow.Position.BOTTOM) {
            markerOptions.anchor(0.5f, 0.0f);
        } else if (this.f10920a == InfoWindow.Position.LEFT) {
            markerOptions.anchor(1.0f, 0.5f);
        } else if (this.f10920a == InfoWindow.Position.LEFT_TOP) {
            markerOptions.anchor(1.0f, 1.0f);
        } else if (this.f10920a == InfoWindow.Position.LEFT_BOTTOM) {
            markerOptions.anchor(1.0f, 0.0f);
        } else if (this.f10920a == InfoWindow.Position.RIGHT) {
            markerOptions.anchor(0.0f, 0.5f);
        } else if (this.f10920a == InfoWindow.Position.RIGHT_TOP) {
            markerOptions.anchor(0.0f, 1.0f);
        } else if (this.f10920a == InfoWindow.Position.RIGHT_BOTTOM) {
            markerOptions.anchor(0.0f, 0.0f);
        } else {
            markerOptions.anchor(0.5f, 1.0f);
        }
        markerOptions.zIndex(this.f10923d.getZIndex());
        markerOptions.flat(this.f10923d.isFlat());
        markerOptions.clickable(true);
        markerOptions.visible(true);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(view)));
        return markerOptions;
    }

    /* renamed from: a */
    private LatLng m7356a(Marker marker) {
        return m7355a(marker.getPosition());
    }

    /* renamed from: a */
    private LatLng m7355a(LatLng latLng) {
        Map map;
        if (this.f10925f == null && (map = this.f10922c) != null) {
            this.f10925f = map.getProjection();
        }
        PointF pointF = null;
        Projection projection = this.f10925f;
        if (projection != null) {
            pointF = projection.toScreenLocation(latLng);
        }
        if (pointF == null) {
            return latLng;
        }
        if (this.f10920a != null) {
            switch (C45053.$SwitchMap$com$didi$common$map$model$InfoWindow$Position[this.f10920a.ordinal()]) {
                case 1:
                    pointF.y += (float) this.f10927h;
                    break;
                case 2:
                    pointF.x -= (float) this.f10926g;
                    break;
                case 3:
                    pointF.x -= (float) this.f10926g;
                    pointF.y -= (float) this.f10927h;
                    break;
                case 4:
                    pointF.x -= (float) this.f10926g;
                    pointF.y += (float) this.f10927h;
                    break;
                case 5:
                    pointF.x += (float) this.f10926g;
                    break;
                case 6:
                    pointF.x += (float) this.f10926g;
                    pointF.y -= (float) this.f10927h;
                    break;
                case 7:
                    pointF.x += (float) this.f10926g;
                    pointF.y += (float) this.f10927h;
                    break;
                default:
                    pointF.y -= m7364c();
                    break;
            }
        } else {
            pointF.y -= m7364c();
        }
        LatLng fromScreenLocation = this.f10925f.fromScreenLocation(pointF);
        return !LatLngUtils.locateCorrect(fromScreenLocation) ? latLng : fromScreenLocation;
    }

    /* renamed from: com.didi.common.map.model.infowindow.InfoWindowV1$3 */
    static /* synthetic */ class C45053 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$model$InfoWindow$Position;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.common.map.model.InfoWindow$Position[] r0 = com.didi.common.map.model.InfoWindow.Position.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$model$InfoWindow$Position = r0
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.RIGHT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$common$map$model$InfoWindow$Position     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.common.map.model.InfoWindow$Position r1 = com.didi.common.map.model.InfoWindow.Position.TOP     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.common.map.model.infowindow.InfoWindowV1.C45053.<clinit>():void");
        }
    }

    /* renamed from: c */
    private float m7364c() {
        Marker marker = this.f10923d;
        if (marker == null || !marker.getEnableTopHeightInterval()) {
            return (float) this.f10927h;
        }
        return this.f10923d.getTopHeightInterval();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7363b(Marker marker) {
        Marker marker2 = this.f10924e;
        if (marker2 != null) {
            marker2.setPosition(m7356a(marker));
        }
    }

    public void setInfoWindowPosition(LatLng latLng) {
        Marker marker = this.f10924e;
        if (marker != null) {
            marker.setPosition(m7355a(latLng));
        }
    }

    public void setPosition(LatLng latLng) {
        Marker marker = this.f10923d;
        if (marker != null) {
            m7363b(marker);
        }
    }

    public void hideInfoWindow() {
        Marker marker = this.f10924e;
        if (marker != null) {
            marker.setVisible(false);
        }
    }

    public Marker getInfoWindowMarker() {
        return this.f10924e;
    }

    public boolean isInfoWindowShown() {
        Marker marker = this.f10924e;
        return marker != null && marker.isVisible();
    }

    public void updateAnchor() {
        if (this.f10923d != null) {
            m7359a();
            m7362b();
            m7363b(this.f10923d);
        }
    }

    /* renamed from: d */
    private void m7366d() {
        Map map = this.f10922c;
        if (map != null) {
            map.addOnCameraChangeListener(this.f10928i);
            this.f10922c.addOnMarkerClickListener(this.f10930k);
        }
    }

    /* renamed from: e */
    private void m7367e() {
        Map map = this.f10922c;
        if (map != null) {
            map.removeOnCameraChangeListener(this.f10928i);
            this.f10922c.removeOnMarkerClickListener(this.f10930k);
        }
    }

    public void addOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (this.f10922c != null && onInfoWindowClickListener != null) {
            this.f10929j = onInfoWindowClickListener;
        }
    }

    public void removeOnInfoWindowClickListener() {
        this.f10929j = null;
    }

    public void destroy() {
        Marker marker;
        Map map = this.f10922c;
        if (!(map == null || (marker = this.f10924e) == null)) {
            map.remove(marker);
            this.f10924e = null;
        }
        removeOnInfoWindowClickListener();
        this.f10930k = null;
        m7367e();
        this.f10925f = null;
        this.f10922c = null;
        this.f10921b = null;
        this.f10928i = null;
    }
}

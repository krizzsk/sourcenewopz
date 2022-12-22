package com.didi.map.outer.map;

import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.LatLng;

public class MapOptions {

    /* renamed from: a */
    private static final double f27851a = 116.306178d;

    /* renamed from: b */
    private static final double f27852b = 40.053036d;

    /* renamed from: c */
    private boolean f27853c = false;

    /* renamed from: d */
    private boolean f27854d;

    /* renamed from: e */
    private boolean f27855e;

    /* renamed from: f */
    private boolean f27856f;

    /* renamed from: g */
    private boolean f27857g = false;

    /* renamed from: h */
    private boolean f27858h = false;

    /* renamed from: i */
    private boolean f27859i = false;

    /* renamed from: j */
    private int f27860j;

    /* renamed from: k */
    private int f27861k = 0;

    /* renamed from: l */
    private float f27862l = 35.0f;

    /* renamed from: m */
    private CameraPosition f27863m = new CameraPosition(new LatLng((double) f27852b, (double) f27851a), 17.0f, 0.0f, 0.0f);

    public boolean isMediaOverlay() {
        return this.f27858h;
    }

    public void setMediaOverlay(boolean z) {
        this.f27858h = z;
    }

    public MapOptions isNight(boolean z) {
        this.f27854d = z;
        return this;
    }

    public MapOptions isNavi(boolean z) {
        this.f27855e = z;
        return this;
    }

    public MapOptions isTraffic(boolean z) {
        this.f27856f = z;
        return this;
    }

    public MapOptions maxSkewAngle(float f) {
        this.f27862l = f;
        return this;
    }

    public MapOptions isDynamicLayerEnable(boolean z) {
        this.f27859i = z;
        return this;
    }

    public MapOptions useBetterDisplay(boolean z) {
        this.f27857g = z;
        return this;
    }

    public MapOptions useTextureMapView(boolean z) {
        this.f27853c = z;
        return this;
    }

    public int getMapTheme() {
        return this.f27860j;
    }

    public void setMapTheme(int i) {
        this.f27860j = i;
    }

    public MapOptions cameraPosition(CameraPosition cameraPosition) {
        this.f27863m = cameraPosition;
        return this;
    }

    public MapOptions setLanguage(int i) {
        this.f27861k = i;
        return this;
    }

    public static MapOptions createDefaultOptions() {
        return new MapOptions().isNight(false).isNavi(false).isTraffic(false).cameraPosition(new CameraPosition(new LatLng((double) f27852b, (double) f27851a), 17.0f, 0.0f, 0.0f));
    }

    public boolean isNight() {
        return this.f27854d;
    }

    public boolean isNavi() {
        return this.f27855e;
    }

    public boolean isTraffic() {
        return this.f27856f;
    }

    public boolean isBetterDisplay() {
        return this.f27857g;
    }

    public CameraPosition getCameraPosition() {
        return this.f27863m;
    }

    public boolean isUseTextureMapView() {
        return this.f27853c;
    }

    public int getLanguage() {
        return this.f27861k;
    }

    public float getMaxSkewAngle() {
        return this.f27862l;
    }

    public boolean isDynamicLayerEnable() {
        return this.f27859i;
    }
}

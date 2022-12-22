package com.didi.hawaii.mapsdkv2.core;

import android.view.ViewDebug;

public class GLUiSetting {
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: a */
    private boolean f23925a = true;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: b */
    private boolean f23926b = true;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: c */
    private boolean f23927c = true;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: d */
    private boolean f23928d = true;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: e */
    private boolean f23929e = false;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: f */
    private boolean f23930f = false;
    @ViewDebug.ExportedProperty(category = "hawaii")

    /* renamed from: g */
    private boolean f23931g = false;

    /* renamed from: h */
    private boolean f23932h = true;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo70180a() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo70181b() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo70182c() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo70183d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo70184e() {
        return true;
    }

    public void setZoomControlsEnabled(boolean z) {
        this.f23929e = z;
    }

    public void setCompassEnabled(boolean z) {
        this.f23931g = z;
    }

    public void setMyLocationButtonEnabled(boolean z) {
        this.f23930f = z;
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f23925a = z;
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f23926b = z;
    }

    public void setTiltGesturesEnabled(boolean z) {
        this.f23927c = z;
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f23928d = z;
    }

    public void setAllGesturesEnabled(boolean z) {
        this.f23932h = z;
        setRotateGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setScrollGesturesEnabled(z);
    }

    public boolean isAllGestureEnabled() {
        return this.f23932h;
    }

    public boolean isRotateGesturesEnabled() {
        return this.f23925a;
    }

    public boolean isScrollGesturesEnabled() {
        return this.f23926b;
    }

    public boolean isTiltGesturesEnabled() {
        return this.f23927c;
    }

    public boolean isZoomGesturesEnabled() {
        return this.f23928d;
    }

    public boolean isZoomControlsEnabled() {
        return this.f23929e;
    }

    public boolean isMyLocationButtonEnabled() {
        return this.f23930f;
    }

    public boolean isCompassEnabled() {
        return this.f23931g;
    }
}

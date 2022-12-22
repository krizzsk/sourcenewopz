package com.didi.zxing.barcodescanner.camera;

public class CameraSettings {

    /* renamed from: a */
    private int f45371a = -1;

    /* renamed from: b */
    private boolean f45372b = false;

    /* renamed from: c */
    private boolean f45373c = false;

    /* renamed from: d */
    private boolean f45374d = false;

    /* renamed from: e */
    private boolean f45375e = true;

    /* renamed from: f */
    private boolean f45376f = false;
    public FocusMode focusMode = FocusMode.AUTO;

    /* renamed from: g */
    private boolean f45377g = false;

    /* renamed from: h */
    private boolean f45378h = false;

    /* renamed from: i */
    private float f45379i = 2.0f;

    public enum FocusMode {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public int getRequestedCameraId() {
        return this.f45371a;
    }

    public void setRequestedCameraId(int i) {
        this.f45371a = i;
    }

    public boolean isScanInverted() {
        return this.f45372b;
    }

    public void setScanInverted(boolean z) {
        this.f45372b = z;
    }

    public boolean isBarcodeSceneModeEnabled() {
        return this.f45373c;
    }

    public void setBarcodeSceneModeEnabled(boolean z) {
        this.f45373c = z;
    }

    public boolean isExposureEnabled() {
        return this.f45377g;
    }

    public void setExposureEnabled(boolean z) {
        this.f45377g = z;
    }

    public boolean isMeteringEnabled() {
        return this.f45374d;
    }

    public void setMeteringEnabled(boolean z) {
        this.f45374d = z;
    }

    public boolean isAutoFocusEnabled() {
        return this.f45375e;
    }

    public void setAutoFocusEnabled(boolean z) {
        this.f45375e = z;
        if (z && this.f45376f) {
            this.focusMode = FocusMode.CONTINUOUS;
        } else if (z) {
            this.focusMode = FocusMode.AUTO;
        } else {
            this.focusMode = null;
        }
    }

    public boolean isContinuousFocusEnabled() {
        return this.f45376f;
    }

    public void setContinuousFocusEnabled(boolean z) {
        this.f45376f = z;
        if (z) {
            this.focusMode = FocusMode.CONTINUOUS;
        } else if (this.f45375e) {
            this.focusMode = FocusMode.AUTO;
        } else {
            this.focusMode = null;
        }
    }

    public FocusMode getFocusMode() {
        return this.focusMode;
    }

    public void setFocusMode(FocusMode focusMode2) {
        this.focusMode = focusMode2;
    }

    public boolean isAutoTorchEnabled() {
        return this.f45378h;
    }

    public void setAutoTorchEnabled(boolean z) {
        this.f45378h = z;
    }

    public void setZoom(float f) {
        this.f45379i = f;
    }

    public float getZoom() {
        return this.f45379i;
    }
}

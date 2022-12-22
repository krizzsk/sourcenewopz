package com.microblink.blinkbarcode.hardware.camera;

import com.microblink.blinkbarcode.hardware.accelerometer.ShakeCallback;
import com.microblink.blinkbarcode.secured.llIllllIIl;
import com.microblink.blinkbarcode.view.surface.CameraSurface;

/* compiled from: line */
public class IlIllIlIIl {
    private boolean IIlIIIllIl = false;
    private boolean IlIllIlIIl = false;
    private boolean IlIllIlllI = false;
    private ShakeCallback IllIIIIllI = ShakeCallback.EMPTY;
    private boolean IllIIIllII = false;
    private boolean IllIIlIIII = false;
    private boolean lIIIIIlIlI = false;
    private CameraSurface lIIIIIllll = CameraSurface.SURFACE_DEFAULT;
    private CameraType lIlIIIIlIl = CameraType.CAMERA_DEFAULT;
    private int llIIIlllll = 230400;
    private float llIIlIIlll = 0.0f;
    private VideoResolutionPreset llIIlIlIIl = VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT;
    private llIllllIIl lllIIIlIlI;
    private int lllIlIlIIl = 2;

    public VideoResolutionPreset IIlIIIllIl() {
        return this.llIIlIlIIl;
    }

    public void IlIllIlIIl(int i) {
        this.llIIIlllll = i;
    }

    public boolean IlIllIlllI() {
        return this.IIlIIIllIl;
    }

    public int IllIIIIllI() {
        return this.llIIIlllll;
    }

    public void IllIIIllII(boolean z) {
        this.IlIllIlIIl = z;
    }

    public boolean IllIIlIIII() {
        return this.IlIllIlIIl;
    }

    public boolean lIIIIIlIlI() {
        return this.lIIIIIlIlI;
    }

    public boolean lIIIIIllll() {
        return this.IllIIlIIII;
    }

    public void lIlIIIIlIl(boolean z) {
        this.IIlIIIllIl = z;
    }

    public float llIIIlllll() {
        return this.llIIlIIlll;
    }

    public ShakeCallback llIIlIIlll() {
        return this.IllIIIIllI;
    }

    public void llIIlIlIIl(ShakeCallback shakeCallback) {
        if (shakeCallback != null) {
            this.IllIIIIllI = shakeCallback;
        }
    }

    public boolean lllIIIlIlI() {
        return this.IlIllIlllI;
    }

    public boolean lllIlIlIIl() {
        return this.IllIIIllII;
    }

    public CameraType IlIllIlIIl() {
        return this.lIlIIIIlIl;
    }

    public void IllIIIIllI(boolean z) {
        this.IlIllIlllI = z;
    }

    public int IllIIIllII() {
        return this.lllIlIlIIl;
    }

    public CameraSurface lIlIIIIlIl() {
        return this.lIIIIIllll;
    }

    public void llIIIlllll(boolean z) {
        this.lIIIIIlIlI = z;
    }

    public void llIIlIlIIl(boolean z) {
        this.IllIIIllII = z;
    }

    public void IlIllIlIIl(boolean z) {
        this.IllIIlIIII = z;
    }

    public void llIIlIlIIl(VideoResolutionPreset videoResolutionPreset) {
        if (videoResolutionPreset != null) {
            this.llIIlIlIIl = videoResolutionPreset;
        } else {
            this.llIIlIlIIl = VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT;
        }
    }

    public void llIIlIlIIl(CameraType cameraType) {
        this.lIlIIIIlIl = cameraType;
    }

    public void llIIlIlIIl(float f) {
        this.llIIlIIlll = f;
    }

    public void llIIlIlIIl(CameraSurface cameraSurface) {
        this.lIIIIIllll = cameraSurface;
    }

    public llIllllIIl llIIlIlIIl() {
        return this.lllIIIlIlI;
    }

    public void llIIlIlIIl(llIllllIIl llilllliil) {
        this.lllIIIlIlI = llilllliil;
    }

    public void llIIlIlIIl(int i) {
        this.lllIlIlIIl = i;
    }
}

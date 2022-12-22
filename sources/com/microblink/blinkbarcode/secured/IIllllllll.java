package com.microblink.blinkbarcode.secured;

import android.hardware.camera2.CameraCaptureSession;

/* compiled from: line */
class IIllllllll extends lllIIIllII {
    public final /* synthetic */ IIlIlIIlll llIIlIlIIl;

    public IIllllllll(IIlIlIIlll iIlIlIIlll) {
        this.llIIlIlIIl = iIlIlIIlll;
    }

    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        CameraCaptureSession unused = this.llIIlIlIIl.lIIIIIlIlI = null;
        this.llIIlIlIIl.IIIIIIIIII.llIIIlllll();
        boolean unused2 = this.llIIlIlIIl.IlIIIIIlll = false;
        boolean unused3 = this.llIIlIlIIl.lllIIlIIlI = false;
        this.llIIlIlIIl.IlIllIlllI.llIIlIlIIl(new RuntimeException("Failed to configure camera capture session"));
    }

    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        if (!this.llIIlIlIIl.IlllIIIllI) {
            CameraCaptureSession unused = this.llIIlIlIIl.lIIIIIlIlI = cameraCaptureSession;
            boolean unused2 = this.llIIlIlIIl.IlIIIIIlll = false;
            boolean unused3 = this.llIIlIlIIl.lllIIlIIlI = true;
            this.llIIlIlIIl.IlIIlllIIl();
        }
    }
}

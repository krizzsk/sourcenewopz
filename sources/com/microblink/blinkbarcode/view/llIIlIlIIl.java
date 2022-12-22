package com.microblink.blinkbarcode.view;

import com.microblink.blinkbarcode.hardware.camera.IllIIIllII;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.surface.ICameraView;

/* compiled from: line */
class llIIlIlIIl implements IllIIIllII.llIIlIlIIl {
    public final /* synthetic */ BaseCameraView llIIlIlIIl;

    /* compiled from: line */
    public class IlIllIlIIl implements Runnable {
        public IlIllIlIIl() {
        }

        public void run() {
            CameraEventsListener cameraEventsListener;
            if (llIIlIlIIl.this.llIIlIlIIl.IlIIlIIIII && (cameraEventsListener = llIIlIlIIl.this.llIIlIlIIl.llIIlIlIIl) != null) {
                cameraEventsListener.onCameraPreviewStarted();
            }
        }
    }

    /* compiled from: line */
    public class IllIIIllII implements Runnable {
        public final /* synthetic */ int IlIllIlIIl;
        public final /* synthetic */ int llIIlIlIIl;

        public IllIIIllII(int i, int i2) {
            this.llIIlIlIIl = i;
            this.IlIllIlIIl = i2;
        }

        public void run() {
            ICameraView iCameraView = llIIlIlIIl.this.llIIlIlIIl.IllIIIIllI;
            if (iCameraView != null) {
                iCameraView.setPreviewSize(this.llIIlIlIIl, this.IlIllIlIIl);
            }
        }
    }

    /* compiled from: line */
    public class llIIIlllll implements Runnable {
        public llIIIlllll() {
        }

        public void run() {
            CameraEventsListener cameraEventsListener;
            if (!llIIlIlIIl.this.llIIlIlIIl.IlIIlIIIII && (cameraEventsListener = llIIlIlIIl.this.llIIlIlIIl.llIIlIlIIl) != null) {
                cameraEventsListener.onCameraPreviewStopped();
            }
        }
    }

    /* renamed from: com.microblink.blinkbarcode.view.llIIlIlIIl$llIIlIlIIl  reason: collision with other inner class name */
    /* compiled from: line */
    public class C22037llIIlIlIIl implements Runnable {
        public final /* synthetic */ Throwable llIIlIlIIl;

        public C22037llIIlIlIIl(Throwable th) {
            this.llIIlIlIIl = th;
        }

        public void run() {
            CameraEventsListener cameraEventsListener = llIIlIlIIl.this.llIIlIlIIl.llIIlIlIIl;
            if (cameraEventsListener != null) {
                cameraEventsListener.onError(this.llIIlIlIIl);
            }
        }
    }

    public llIIlIlIIl(BaseCameraView baseCameraView) {
        this.llIIlIlIIl = baseCameraView;
    }

    public void IlIllIlIIl() {
        this.llIIlIlIIl.lllIIIlIlI();
        boolean unused = this.llIIlIlIIl.IlIIlIIIII = false;
        BaseCameraView baseCameraView = this.llIIlIlIIl;
        if (baseCameraView.llIIlIlIIl != null) {
            baseCameraView.llIIlIlIIl((Runnable) new llIIIlllll());
        }
    }

    public void llIIlIlIIl(Throwable th) {
        Log.m40230e(this.llIIlIlIIl, th, "Exception caught on camera startup", new Object[0]);
        boolean unused = this.llIIlIlIIl.IlIIlIIIII = false;
        BaseCameraView baseCameraView = this.llIIlIlIIl;
        baseCameraView.IlIllIlIIl = true;
        baseCameraView.IlllIIIllI.post(new C22037llIIlIlIIl(th));
    }

    public void llIIlIlIIl() {
        this.llIIlIlIIl.lIIIIIllll();
        boolean unused = this.llIIlIlIIl.IlIIlIIIII = true;
        BaseCameraView baseCameraView = this.llIIlIlIIl;
        if (baseCameraView.llIIlIlIIl != null) {
            baseCameraView.llIIlIlIIl((Runnable) new IlIllIlIIl());
        }
    }

    public void llIIlIlIIl(int i, int i2) {
        this.llIIlIlIIl.IlllIIIllI.post(new IllIIIllII(i, i2));
    }
}

package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.hardware.camera.IllIIIllII;
import com.microblink.blinkbarcode.util.Log;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* compiled from: line */
class llllIllllI {
    private static Semaphore lIIIIIllll = new Semaphore(1);
    private CameraDevice.StateCallback IIlIIIllIl = new llIIlIlIIl();
    private com.microblink.blinkbarcode.util.IllIIIllII IlIllIlIIl;
    /* access modifiers changed from: private */
    public IllIIIllII.llIIlIlIIl IllIIIIllI;
    private CameraManager IllIIIllII;
    /* access modifiers changed from: private */
    public IlIllIlIIl lIlIIIIlIl;
    private IllIllIllI llIIIlllll;
    /* access modifiers changed from: private */
    public IllIIIllII llIIlIIlll = IllIIIllII.INACTIVE;
    /* access modifiers changed from: private */
    public CameraDevice llIIlIlIIl;

    /* compiled from: line */
    public interface IlIllIlIIl {
    }

    /* compiled from: line */
    public enum IllIIIllII {
        INACTIVE,
        OPENING,
        CLOSING,
        NEEDS_CLOSING,
        ACTIVE
    }

    /* compiled from: line */
    public class llIIlIlIIl extends CameraDevice.StateCallback {
        public llIIlIlIIl() {
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            llllIllllI llllilllli = llllIllllI.this;
            Log.m40227d(llllilllli, "Closing from disconnected " + llllIllllI.this.hashCode(), new Object[0]);
            llllIllllI.this.llIIIlllll();
            llllIllllI.this.IllIIIIllI.llIIlIlIIl(new Exception("Camera has been disconnected!"));
        }

        public void onError(CameraDevice cameraDevice, int i) {
            String str;
            Log.m40227d(llllIllllI.this, "Closing from error " + llllIllllI.this.hashCode(), new Object[0]);
            llllIllllI.this.llIIIlllll();
            if (i == 1) {
                str = "Camera device is already in use.";
            } else if (i == 2) {
                str = "Too many other open camera devices";
            } else if (i == 3) {
                str = "Camera device could not be opened due to a device policy.";
            } else if (i == 4) {
                str = "Camera device has encountered a fatal error.";
            } else if (i != 5) {
                str = "Unknown camera error: " + i;
            } else {
                str = "Camera service has encountered a fatal error. Please reboot the device!";
            }
            llllIllllI.this.IllIIIIllI.llIIlIlIIl(new Exception(str));
        }

        public void onOpened(CameraDevice cameraDevice) {
            llllIllllI llllilllli = llllIllllI.this;
            Log.m40227d(llllilllli, "OPENED " + llllIllllI.this.hashCode(), new Object[0]);
            CameraDevice unused = llllIllllI.this.llIIlIlIIl = cameraDevice;
            if (llllIllllI.this.llIIlIIlll == IllIIIllII.NEEDS_CLOSING) {
                llllIllllI llllilllli2 = llllIllllI.this;
                Log.m40227d(llllilllli2, "Closing from on opened " + llllIllllI.this.hashCode(), new Object[0]);
                llllIllllI.this.llIIIlllll();
                return;
            }
            llllIllllI.this.llIIlIlIIl(IllIIIllII.ACTIVE);
            IIlIlIIlll.this.lIIIIIlIlI();
        }
    }

    public llllIllllI(Context context, com.microblink.blinkbarcode.util.IllIIIllII illIIIllII) {
        this.IlIllIlIIl = illIIIllII;
        this.IllIIIllII = (CameraManager) context.getSystemService("camera");
        this.llIIIlllll = new IllIllIllI();
    }

    public boolean IIlIIIllIl() {
        return this.llIIlIlIIl != null;
    }

    public void IlIllIlllI() {
        if (this.llIIlIIlll == IllIIIllII.OPENING) {
            llIIlIlIIl(IllIIIllII.NEEDS_CLOSING);
        } else {
            llIIlIlIIl(IllIIIllII.CLOSING);
        }
    }

    public CaptureRequest.Builder IllIIIIllI() throws CameraAccessException {
        return this.llIIlIlIIl.createCaptureRequest(1);
    }

    public boolean lIIIIIllll() {
        IllIIIllII illIIIllII = this.llIIlIIlll;
        return illIIIllII == IllIIIllII.NEEDS_CLOSING || illIIIllII == IllIIIllII.CLOSING;
    }

    public int lIlIIIIlIl() {
        return this.llIIIlllll.IllIIIllII();
    }

    public void llIIIlllll() {
        Log.m40227d(this, "CLOSING " + hashCode(), new Object[0]);
        CameraDevice cameraDevice = this.llIIlIlIIl;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.llIIlIlIIl = null;
            llIIlIlIIl(IllIIIllII.INACTIVE);
            Log.m40227d(this, "CLOSED " + hashCode(), new Object[0]);
            lIIIIIllll.release();
        }
    }

    public CameraType llIIlIIlll() {
        return this.llIIIlllll.llIIIlllll();
    }

    public boolean lllIIIlIlI() {
        if (this.llIIlIIlll != IllIIIllII.INACTIVE) {
            return false;
        }
        llIIlIlIIl(IllIIIllII.OPENING);
        return true;
    }

    public boolean IlIllIlIIl() {
        return IIlIIIllIl() && this.llIIlIIlll == IllIIIllII.ACTIVE;
    }

    public void IllIIIllII() {
        this.llIIIlllll.IlIllIlIIl();
        llIIlIlIIl(IllIIIllII.INACTIVE);
    }

    public void llIIlIlIIl(List<Surface> list, CameraCaptureSession.StateCallback stateCallback) throws CameraAccessException {
        this.llIIlIlIIl.createCaptureSession(list, stateCallback, this.IlIllIlIIl.llIIlIlIIl());
    }

    public CameraCharacteristics llIIlIlIIl(CameraType cameraType, IllIIIllII.llIIlIlIIl lliililiil, IlIllIlIIl ilIllIlIIl) throws CameraAccessException, SecurityException {
        this.IllIIIIllI = lliililiil;
        this.lIlIIIIlIl = ilIllIlIIl;
        String llIIlIlIIl2 = this.llIIIlllll.llIIlIlIIl(this.IllIIIllII, cameraType);
        if (llIIlIlIIl2 != null) {
            try {
                Log.m40227d(this, "WAIT TO OPEN " + hashCode(), new Object[0]);
                if (!lIIIIIllll.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                    return null;
                }
                Log.m40227d(this, "AQUIRED OPEN LOCK " + hashCode(), new Object[0]);
                this.IllIIIllII.openCamera(llIIlIlIIl2, this.IIlIIIllIl, this.IlIllIlIIl.llIIlIlIIl());
                return this.IllIIIllII.getCameraCharacteristics(llIIlIlIIl2);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while trying to lock camera opening.", e);
            }
        } else {
            throw new RuntimeException("Unable to select camera. External cameras are currently not supported.");
        }
    }

    public boolean llIIlIlIIl() {
        return this.llIIIlllll.llIIlIlIIl();
    }

    /* access modifiers changed from: private */
    public void llIIlIlIIl(IllIIIllII illIIIllII) {
        Log.m40227d(this, "SState " + illIIIllII + " " + hashCode(), new Object[0]);
        this.llIIlIIlll = illIIIllII;
    }
}

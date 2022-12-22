package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.hardware.Camera;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.util.Log;
import java.util.List;

/* compiled from: line */
public abstract class IlIIIIIlll {
    public List<Camera.Size> IlIllIlIIl;
    public int IllIIIllII = 0;
    public int llIIIlllll = 230400;
    public Camera llIIlIlIIl;

    /* compiled from: line */
    public static class llIIlIlIIl {
        private int IlIllIlIIl;
        private int llIIlIlIIl;

        public llIIlIlIIl(int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                throw new IllegalArgumentException("Width and mHeight must be larger than zero!");
            }
            this.llIIlIlIIl = i;
            this.IlIllIlIIl = i2;
        }

        public int IlIllIlIIl() {
            return this.llIIlIlIIl;
        }

        public int llIIlIlIIl() {
            return this.IlIllIlIIl;
        }
    }

    public IlIIIIIlll(Camera camera, int i, Context context) {
        if (camera != null) {
            this.llIIlIlIIl = camera;
            this.llIIIlllll = i;
            this.IlIllIlIIl = camera.getParameters().getSupportedPreviewSizes();
            int ordinal = Log.getCurrentLogLevel().ordinal();
            Log.LogLevel logLevel = Log.LogLevel.LOG_VERBOSE;
            if (ordinal >= 4) {
                List<Camera.Size> list = this.IlIllIlIIl;
                if (list == null) {
                    Log.m40227d(this, "List of supported preview sizes is null!", new Object[0]);
                    return;
                }
                for (Camera.Size next : list) {
                    Log.m40227d(this, "Camera supported preview size: {}x{}", Integer.valueOf(next.width), Integer.valueOf(next.height));
                }
                return;
            }
            return;
        }
        Log.m40229e(this, "Camera cannot be null while initializing camera strategy", new Object[0]);
        throw new NullPointerException("Camera for CameraStragy cannot be null");
    }

    public abstract void IlIllIlIIl();

    public abstract double llIIlIlIIl(Camera.Size size, double d, long j, CameraType cameraType);

    public abstract Camera.Size llIIlIlIIl(int i, int i2, CameraType cameraType);

    public boolean llIIlIlIIl(Camera.Size size, CameraType cameraType) {
        Camera.Size llIIlIlIIl2 = llIIlIlIIl(cameraType);
        boolean z = size.height * size.width >= this.llIIIlllll;
        boolean z2 = llIIlIlIIl2 != null && llIIlIlIIl2.equals(size);
        if (Log.getCurrentLogLevel().ordinal() >= 4) {
            Log.m40233v(this, "Resolution {}x{}: resolution high enough: {}, resolution specific for device: {}", Integer.valueOf(size.width), Integer.valueOf(size.height), Boolean.valueOf(z), Boolean.valueOf(z2));
        }
        if (z || z2) {
            return true;
        }
        return false;
    }

    public Camera.Size llIIlIlIIl(CameraType cameraType) {
        llIIlIlIIl lliililiil;
        if (cameraType == CameraType.CAMERA_FRONTFACE) {
            lliililiil = IllIIIllII.llIIlIIlll().IllIIlIIII();
        } else {
            lliililiil = IllIIIllII.llIIlIIlll().lllIlIlIIl();
        }
        if (lliililiil == null || this.llIIlIlIIl == null) {
            return null;
        }
        Camera camera = this.llIIlIlIIl;
        camera.getClass();
        Camera.Size size = new Camera.Size(camera, lliililiil.IlIllIlIIl(), lliililiil.llIIlIlIIl());
        List<Camera.Size> list = this.IlIllIlIIl;
        if (list == null || !list.contains(size)) {
            Log.m40235w(this, "Device specific resolution {}x{} is not supported on Camera1 API. If possible, use Camera2 API.", Integer.valueOf(lliililiil.IlIllIlIIl()), Integer.valueOf(lliililiil.llIIlIlIIl()));
            return null;
        }
        Log.m40233v(this, "Using device specific resolution {}x{}", Integer.valueOf(lliililiil.IlIllIlIIl()), Integer.valueOf(lliililiil.llIIlIlIIl()));
        return size;
    }

    public Camera.Size llIIlIlIIl(List<Camera.Size> list, double d, long j, CameraType cameraType) {
        Camera.Size size = null;
        double d2 = Double.POSITIVE_INFINITY;
        for (Camera.Size next : list) {
            if (next.width % 4 == 0) {
                double llIIlIlIIl2 = llIIlIlIIl(next, d, j, cameraType);
                if (llIIlIlIIl2 < d2) {
                    size = next;
                    d2 = llIIlIlIIl2;
                }
                Object[] objArr = {Integer.valueOf(next.width), Integer.valueOf(next.height), Double.valueOf(llIIlIlIIl2)};
                Log.m40233v(this, "Compatibility for preview size {}x{} is {}", objArr);
            }
        }
        return size;
    }

    public int llIIlIlIIl() {
        return this.IllIIIllII;
    }

    public void llIIlIlIIl(int i) {
        this.IllIIIllII = i;
    }
}

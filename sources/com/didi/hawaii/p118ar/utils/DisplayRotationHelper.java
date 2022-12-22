package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import com.google.p217ar.core.Session;

/* renamed from: com.didi.hawaii.ar.utils.DisplayRotationHelper */
public final class DisplayRotationHelper implements DisplayManager.DisplayListener {

    /* renamed from: a */
    private boolean f23310a;

    /* renamed from: b */
    private int f23311b;

    /* renamed from: c */
    private int f23312c;

    /* renamed from: d */
    private final Display f23313d;

    /* renamed from: e */
    private final DisplayManager f23314e;

    /* renamed from: f */
    private final CameraManager f23315f;

    public void onDisplayAdded(int i) {
    }

    public void onDisplayRemoved(int i) {
    }

    public DisplayRotationHelper(Context context) {
        this.f23314e = (DisplayManager) context.getSystemService("display");
        this.f23315f = (CameraManager) context.getSystemService("camera");
        this.f23313d = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public void onResume() {
        this.f23314e.registerDisplayListener(this, (Handler) null);
    }

    public void onPause() {
        this.f23314e.unregisterDisplayListener(this);
    }

    public void onSurfaceChanged(int i, int i2) {
        this.f23311b = i;
        this.f23312c = i2;
        this.f23310a = true;
    }

    public void updateSessionIfNeeded(Session session) {
        if (this.f23310a) {
            session.setDisplayGeometry(this.f23313d.getRotation(), this.f23311b, this.f23312c);
            this.f23310a = false;
        }
    }

    public float getCameraSensorRelativeViewportAspectRatio(String str) {
        float f;
        int i;
        int cameraSensorToDisplayRotation = getCameraSensorToDisplayRotation(str);
        if (cameraSensorToDisplayRotation != 0) {
            if (cameraSensorToDisplayRotation != 90) {
                if (cameraSensorToDisplayRotation != 180) {
                    if (cameraSensorToDisplayRotation != 270) {
                        throw new RuntimeException("Unhandled rotation: " + cameraSensorToDisplayRotation);
                    }
                }
            }
            f = (float) this.f23312c;
            i = this.f23311b;
            return f / ((float) i);
        }
        f = (float) this.f23311b;
        i = this.f23312c;
        return f / ((float) i);
    }

    public int getCameraSensorToDisplayRotation(String str) {
        try {
            return ((((Integer) this.f23315f.getCameraCharacteristics(str).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - m16711a(this.f23313d.getRotation())) + 360) % 360;
        } catch (CameraAccessException e) {
            throw new RuntimeException("Unable to determine display orientation", e);
        }
    }

    /* renamed from: a */
    private int m16711a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 90;
        }
        if (i == 2) {
            return 180;
        }
        if (i == 3) {
            return 270;
        }
        throw new RuntimeException("Unknown rotation " + i);
    }

    public void onDisplayChanged(int i) {
        this.f23310a = true;
    }
}

package com.microblink.blinkbarcode.secured;

import android.graphics.Rect;
import android.hardware.Camera;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.hardware.camera.AutofocusListener;
import com.microblink.blinkbarcode.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: line */
public class IlIIlllIIl implements lllllIlIll {
    private boolean IIlIIIllIl;
    /* access modifiers changed from: private */
    public AutofocusListener IlIllIlIIl;
    /* access modifiers changed from: private */
    public boolean IllIIIIllI = false;
    /* access modifiers changed from: private */
    public boolean IllIIIllII = false;
    /* access modifiers changed from: private */
    public boolean lIlIIIIlIl = false;
    /* access modifiers changed from: private */
    public Rect[] llIIIlllll = null;
    /* access modifiers changed from: private */
    public IllIIIllII llIIlIIlll;
    /* access modifiers changed from: private */
    public Camera llIIlIlIIl;

    /* compiled from: line */
    public class IlIllIlIIl implements Camera.AutoFocusMoveCallback {
        public IlIllIlIIl() {
        }

        public void onAutoFocusMoving(boolean z, Camera camera) {
            Log.m40227d(IlIIlllIIl.this, "Autofocus move callback start: {}", Boolean.valueOf(z));
            boolean unused = IlIIlllIIl.this.IllIIIllII = z;
            if (IlIIlllIIl.this.IlIllIlIIl == null) {
                return;
            }
            if (z) {
                IlIIlllIIl.this.IlIllIlIIl.onAutofocusStarted(IlIIlllIIl.this.llIIIlllll);
                boolean unused2 = IlIIlllIIl.this.lIlIIIIlIl = false;
                return;
            }
            IlIIlllIIl.this.IlIllIlIIl.onAutofocusStopped(IlIIlllIIl.this.llIIIlllll);
            boolean unused3 = IlIIlllIIl.this.lIlIIIIlIl = true;
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl implements Camera.AutoFocusCallback {
        public llIIlIlIIl() {
        }

        public void onAutoFocus(boolean z, Camera camera) {
            Log.m40233v(IlIIlllIIl.this, "Full autofocus cycle completed with success: {}", Boolean.valueOf(z));
            boolean unused = IlIIlllIIl.this.IllIIIIllI = false;
            boolean unused2 = IlIIlllIIl.this.IllIIIllII = false;
            if (IlIIlllIIl.this.llIIlIIlll != null && IlIIlllIIl.this.llIIlIIlll.IlIIlllIIl()) {
                Log.m40231i(IlIIlllIIl.this, "This is a device with untrusty focus. We will assume that focus has succeeded!", new Object[0]);
                z = true;
            }
            if (IlIIlllIIl.this.IlIllIlIIl != null) {
                IlIIlllIIl.this.IlIllIlIIl.onAutofocusStopped(IlIIlllIIl.this.llIIIlllll);
                boolean unused3 = IlIIlllIIl.this.lIlIIIIlIl = z;
                if (!z) {
                    IlIIlllIIl.this.IlIllIlIIl.onAutofocusFailed();
                }
            }
            if (IlIIlllIIl.this.llIIlIlIIl != null) {
                try {
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFocusMode("continuous-picture");
                    camera.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.m40236w(IlIIlllIIl.this, e, "Failed to transfer camera back into continuous autofocus mode! This is a device issue!", new Object[0]);
                }
            }
        }
    }

    public IlIIlllIIl(AutofocusListener autofocusListener, IllIIIllII illIIIllII, boolean z) {
        this.IlIllIlIIl = autofocusListener;
        this.llIIlIIlll = illIIIllII;
        if (illIIIllII.lIIIIIlIlI()) {
            this.IIlIIIllIl = z;
            return;
        }
        throw new IllegalArgumentException("Device manager needs to have device lists loaded");
    }

    public void IIlIIIllIl() {
        this.lIlIIIIlIl = false;
    }

    public boolean IlIllIlIIl() {
        return true;
    }

    public void IllIIIIllI() {
    }

    public void dispose() {
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.llIIIlllll = null;
        this.llIIlIIlll = null;
    }

    public void lIIIIIllll() {
    }

    public boolean lIlIIIIlIl() {
        return this.lIlIIIIlIl;
    }

    public boolean llIIIlllll() {
        return true;
    }

    public void llIIlIIlll() {
        Camera camera = this.llIIlIlIIl;
        if (camera != null && this.IllIIIIllI) {
            try {
                camera.cancelAutoFocus();
                Camera.Parameters parameters = this.llIIlIlIIl.getParameters();
                parameters.setFocusMode("continuous-picture");
                this.llIIlIlIIl.setParameters(parameters);
            } catch (RuntimeException e) {
                Log.m40236w(this, e, "Failed to resume continuous autofocus because attempt to modify camera parameters failed or because autofocus cancelling has failed.", new Object[0]);
            }
        }
    }

    public void llIIlIlIIl() {
    }

    public boolean IllIIIllII() {
        Log.m40233v(this, "Focus in progress: {}, full autofocus in progress: {}", Boolean.valueOf(this.IllIIIllII), Boolean.valueOf(this.IllIIIIllI));
        if (this.IllIIIllII || this.IllIIIIllI) {
            return true;
        }
        return false;
    }

    public void llIIlIlIIl(boolean z) {
        if ((z || !this.lIlIIIIlIl) && !this.IllIIIIllI && this.llIIlIlIIl != null) {
            Log.m40233v(this, "Performing full autofocus cycle", new Object[0]);
            try {
                IllIIlIIII illIIlIIII = new IllIIlIIII(this.llIIlIlIIl);
                illIIlIIII.llIIlIlIIl(this.IIlIIIllIl);
                try {
                    illIIlIIII.llIIlIlIIl(this.llIIlIlIIl);
                } catch (RuntimeException e) {
                    Log.m40236w(this, e, "Failed to transfer camera into autofocus mode from continuous autofocus. Focus may fail! This is a device issue!", new Object[0]);
                }
                AutofocusListener autofocusListener = this.IlIllIlIIl;
                if (autofocusListener != null) {
                    autofocusListener.onAutofocusStarted(this.llIIIlllll);
                }
                this.IllIIIIllI = true;
                this.IllIIIllII = true;
                try {
                    this.llIIlIlIIl.autoFocus(new llIIlIlIIl());
                } catch (RuntimeException e2) {
                    Log.m40236w(this, e2, "A runtime exception occurred while attempting to perform autofocus", new Object[0]);
                    this.IllIIIIllI = false;
                    this.IllIIIllII = false;
                    this.lIlIIIIlIl = false;
                    AutofocusListener autofocusListener2 = this.IlIllIlIIl;
                    if (autofocusListener2 != null) {
                        autofocusListener2.onAutofocusStopped(this.llIIIlllll);
                    }
                    Camera camera = this.llIIlIlIIl;
                    if (camera != null) {
                        try {
                            Camera.Parameters parameters = camera.getParameters();
                            parameters.setFocusMode("continuous-picture");
                            this.llIIlIlIIl.setParameters(parameters);
                        } catch (RuntimeException e3) {
                            Log.m40236w(this, e3, "Failed to transfer camera back into continuous autofocus mode! This is a device issue!", new Object[0]);
                        }
                    }
                }
            } catch (RuntimeException e4) {
                Log.m40236w(this, e4, "Failed to obtain parameters from camera! Cannot perform autofocus cycle.", new Object[0]);
            }
        }
    }

    public void llIIlIlIIl(Camera camera) {
        if (camera != null) {
            this.llIIlIlIIl = camera;
            camera.setAutoFocusMoveCallback(new IlIllIlIIl());
        }
    }

    public void llIIlIlIIl(Rect[] rectArr) {
        Camera camera = this.llIIlIlIIl;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (rectArr == null) {
                    parameters.setMeteringAreas((List) null);
                    parameters.setFocusAreas((List) null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < parameters.getMaxNumFocusAreas() && i < rectArr.length) {
                        Log.m40227d(this, "Adding focus area {}", rectArr[i]);
                        arrayList.add(new Camera.Area(rectArr[i], 1000));
                        i++;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    while (i2 < parameters.getMaxNumMeteringAreas() && i2 < rectArr.length) {
                        Log.m40227d(this, "Adding metering area {}", rectArr[i2]);
                        arrayList2.add(new Camera.Area(rectArr[i2], 1000));
                        i2++;
                    }
                    parameters.setMeteringAreas(arrayList2);
                    parameters.setFocusAreas(arrayList);
                }
                try {
                    this.llIIlIlIIl.setParameters(parameters);
                    this.llIIIlllll = rectArr;
                } catch (RuntimeException unused) {
                    Log.m40229e(this, "Failed to apply new camera parameters!", new Object[0]);
                }
            } catch (RuntimeException e) {
                Log.m40236w(this, e, "Failed to obtain camera paremeters. Cannot set metering areas!", new Object[0]);
            }
        } else {
            Log.m40235w(this, "Cannot set focus area, camera is null", new Object[0]);
        }
    }
}

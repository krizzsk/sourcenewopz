package com.microblink.blinkbarcode.secured;

import android.graphics.Rect;
import android.hardware.Camera;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.hardware.camera.AutofocusListener;
import com.microblink.blinkbarcode.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import kotlinx.coroutines.DebugKt;

/* compiled from: line */
public class llIIlIIIll implements lllllIlIll {
    /* access modifiers changed from: private */
    public Rect[] IIlIIIllIl = null;
    public volatile boolean IlIllIlIIl = false;
    private final Camera.AutoFocusCallback IlIllIlllI = new llIIlIlIIl();
    /* access modifiers changed from: private */
    public volatile boolean IllIIIIllI = false;
    public volatile boolean IllIIIllII;
    /* access modifiers changed from: private */
    public IllIIIllII lIIIIIllll;
    /* access modifiers changed from: private */
    public int lIlIIIIlIl = 0;
    public Timer llIIIlllll = null;
    /* access modifiers changed from: private */
    public AutofocusListener llIIlIIlll;
    public Camera llIIlIlIIl;
    /* access modifiers changed from: private */
    public volatile int lllIIIlIlI = 0;

    /* compiled from: line */
    public class llIIlIlIIl implements Camera.AutoFocusCallback {
        public llIIlIlIIl() {
        }

        private void llIIlIlIIl(String str) {
            Camera camera = llIIlIIIll.this.llIIlIlIIl;
            if (camera != null) {
                try {
                    Camera.Parameters parameters = camera.getParameters();
                    List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                    String focusMode = parameters.getFocusMode();
                    if (supportedFocusModes != null && supportedFocusModes.contains(str) && !str.equals(focusMode)) {
                        parameters.setFocusMode(str);
                        Log.m40227d(llIIlIIIll.this, "Setting focus mode to {}", str);
                        try {
                            llIIlIIIll.this.llIIlIlIIl.setParameters(parameters);
                        } catch (RuntimeException e) {
                            Log.m40230e(llIIlIIIll.this, e, "Setting new camera parameters failed!", new Object[0]);
                        }
                    }
                } catch (RuntimeException e2) {
                    Log.m40236w(this, e2, "Failed to get camera parameters! Cannot set focus mode!", new Object[0]);
                }
            }
        }

        public void onAutoFocus(boolean z, Camera camera) {
            Camera camera2;
            if (llIIlIIIll.this.llIIlIIlll != null) {
                llIIlIIIll.this.llIIlIIlll.onAutofocusStopped(llIIlIIIll.this.IIlIIIllIl);
            }
            boolean z2 = false;
            llIIlIIIll.this.IllIIIllII = false;
            llIIlIIIll.llIIIlllll(llIIlIIIll.this);
            Log.m40231i(llIIlIIIll.this, "Autofocus request ended with {}. Request count: {}", Boolean.valueOf(z), Integer.valueOf(llIIlIIIll.this.lllIIIlIlI));
            if (llIIlIIIll.this.lIIIIIllll.IlIIlllIIl()) {
                Log.m40231i(llIIlIIIll.this, "This is a device with untrusty focus. We will assume that focus has succeeded!", new Object[0]);
                z = true;
            }
            llIIlIIIll.this.IlIllIlIIl = z;
            boolean z3 = llIIlIIIll.this.IlIllIlIIl;
            int unused = llIIlIIIll.this.lIlIIIIlIl;
            if (z) {
                llIIlIIIll.IlIllIlIIl(llIIlIIIll.this, 3000);
                int unused2 = llIIlIIIll.this.lIlIIIIlIl = 0;
            } else if (!llIIlIIIll.this.IllIIIIllI) {
                llIIlIIIll.llIIlIIlll(llIIlIIIll.this);
                if (llIIlIIIll.this.lIlIIIIlIl % 2 == 0 && (camera2 = llIIlIIIll.this.llIIlIlIIl) != null) {
                    try {
                        String focusMode = camera2.getParameters().getFocusMode();
                        if ("macro".equals(focusMode)) {
                            llIIlIlIIl(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                        } else if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(focusMode)) {
                            llIIlIlIIl("macro");
                        }
                    } catch (RuntimeException e) {
                        Log.m40236w(this, e, "Failed to get camera parameters. Cannot toggle autofocus mode!", new Object[0]);
                    }
                }
                if (llIIlIIIll.this.lIlIIIIlIl == 4 && llIIlIIIll.this.llIIlIIlll != null) {
                    llIIlIIIll.this.llIIlIIlll.onAutofocusFailed();
                }
                z2 = true;
            }
            if (z2) {
                llIIlIIIll.IlIllIlIIl(llIIlIIIll.this, 500);
            }
        }
    }

    public llIIlIIIll(AutofocusListener autofocusListener, IllIIIllII illIIIllII) {
        this.llIIlIIlll = autofocusListener;
        this.lIIIIIllll = illIIIllII;
        if (!illIIIllII.lIIIIIlIlI()) {
            throw new IllegalArgumentException("Device manager needs to have device lists loaded");
        }
    }

    public static /* synthetic */ int llIIIlllll(llIIlIIIll lliiliiill) {
        int i = lliiliiill.lllIIIlIlI;
        lliiliiill.lllIIIlIlI = i - 1;
        return i;
    }

    public static /* synthetic */ int llIIlIIlll(llIIlIIIll lliiliiill) {
        int i = lliiliiill.lIlIIIIlIl;
        lliiliiill.lIlIIIIlIl = i + 1;
        return i;
    }

    public boolean IlIllIlIIl() {
        return false;
    }

    public void dispose() {
        this.llIIlIlIIl = null;
        Timer timer = this.llIIIlllll;
        if (timer != null) {
            timer.cancel();
        }
        this.llIIIlllll = null;
        this.llIIlIIlll = null;
        this.IIlIIIllIl = null;
        this.lIIIIIllll = null;
    }

    public void lIIIIIllll() {
        this.IllIIIIllI = true;
        this.IlIllIlIIl = false;
    }

    public boolean llIIIlllll() {
        return true;
    }

    public static void IlIllIlIIl(llIIlIIIll lliiliiill, int i) {
        Timer timer = lliiliiill.llIIIlllll;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        lliiliiill.llIIIlllll = timer2;
        timer2.schedule(new IlIlllllII(lliiliiill), 3000);
        Log.m40233v(lliiliiill, "focus timer set", new Object[0]);
    }

    public void IIlIIIllIl() {
        Log.m40233v(this, "invalidating focus", new Object[0]);
        this.IlIllIlIIl = false;
        Timer timer = this.llIIIlllll;
        if (timer != null) {
            timer.cancel();
        }
        this.llIIIlllll = null;
    }

    public void IllIIIIllI() {
        this.IllIIIIllI = false;
    }

    public boolean IllIIIllII() {
        return this.IllIIIllII;
    }

    public boolean lIlIIIIlIl() {
        return this.IlIllIlIIl;
    }

    public void llIIlIIlll() {
        if (this.llIIlIlIIl != null && this.IllIIIllII) {
            try {
                this.llIIlIlIIl.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.m40236w(this, e, "There has been error in cancelling autofocus cycle. This probably a bug in device", new Object[0]);
            }
            this.IllIIIllII = false;
            this.lllIIIlIlI--;
        }
    }

    public void llIIlIlIIl(Camera camera) {
        this.llIIlIlIIl = camera;
        this.IllIIIllII = false;
        Timer timer = this.llIIIlllll;
        if (timer != null) {
            timer.cancel();
            this.llIIIlllll = null;
        }
    }

    public void llIIlIlIIl(boolean z) {
        if (this.llIIlIlIIl != null && this.IlIllIlllI != null && !this.IllIIIIllI) {
            if (this.IlIllIlIIl && !z) {
                return;
            }
            if (this.IllIIIllII) {
                Log.m40233v(this, "Autofocus is in progress...", new Object[0]);
                return;
            }
            try {
                this.IllIIIllII = true;
                Timer timer = this.llIIIlllll;
                if (timer != null) {
                    timer.cancel();
                    this.llIIIlllll = null;
                }
                Log.m40227d(this, "requesting autofocus...", new Object[0]);
                this.lllIIIlIlI++;
                Log.m40231i(this, "Requests count: {}", Integer.valueOf(this.lllIIIlIlI));
                AutofocusListener autofocusListener = this.llIIlIIlll;
                if (autofocusListener != null) {
                    autofocusListener.onAutofocusStarted(this.IIlIIIllIl);
                }
                this.llIIlIlIIl.autoFocus(this.IlIllIlllI);
                Log.m40227d(this, "request issued", new Object[0]);
            } catch (RuntimeException e) {
                Log.m40236w(this, e, "Autofocus call failed!", new Object[0]);
                this.IlIllIlllI.onAutoFocus(false, this.llIIlIlIIl);
            }
        }
    }

    public void llIIlIlIIl() {
        llIIlIlIIl(false);
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
                    this.IIlIIIllIl = rectArr;
                    IIlIIIllIl();
                    llIIlIlIIl(false);
                } catch (RuntimeException unused) {
                    Log.m40229e(this, "Failed to apply new camera parameters!", new Object[0]);
                }
            } catch (RuntimeException e) {
                Log.m40236w(this, e, "Failed to get camera parameters. Cannot set metering areas!", new Object[0]);
            }
        } else {
            Log.m40235w(this, "Cannot set focus area, camera is null", new Object[0]);
        }
    }
}

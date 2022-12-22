package com.microblink.blinkbarcode.secured;

import android.hardware.camera2.CaptureRequest;
import com.microblink.blinkbarcode.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: line */
class IlIlIIllll {
    private boolean IlIllIlIIl = false;
    private int IllIIIllII;
    private AtomicBoolean llIIIlllll;
    private boolean llIIlIlIIl = false;

    public boolean IlIllIlIIl() {
        int i = this.IllIIIllII;
        return i == 4 || i == 2;
    }

    public void IllIIIllII() {
        this.llIIIlllll = new AtomicBoolean(true);
        this.IllIIIllII = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037 A[SYNTHETIC, Splitter:B:8:0x0037] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void llIIlIlIIl(android.hardware.camera2.CameraCharacteristics r6, com.microblink.blinkbarcode.hardware.IllIIIllII r7) {
        /*
            r5 = this;
            android.hardware.camera2.CameraCharacteristics$Key r0 = android.hardware.camera2.CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE
            java.lang.Object r0 = r6.get(r0)
            java.lang.Float r0 = (java.lang.Float) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0020
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r3[r2] = r0
            java.lang.String r4 = "Minimum focus distance: {}"
            com.microblink.blinkbarcode.util.Log.m40233v(r5, r4, r3)
            float r0 = r0.floatValue()
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            r3[r2] = r4
            java.lang.String r4 = "Camera has fixed lens: {}"
            com.microblink.blinkbarcode.util.Log.m40231i(r5, r4, r3)
            r0 = r0 ^ r1
            r5.llIIlIlIIl = r0
            boolean r0 = com.microblink.blinkbarcode.secured.llIllIIlll.llIIlIlIIl()
            if (r0 == 0) goto L_0x0075
            android.hardware.camera2.CameraCharacteristics$Key<java.lang.Boolean> r0 = com.microblink.blinkbarcode.secured.IIIlllIlII.llIIlIlIIl     // Catch:{ IllegalArgumentException -> 0x005d }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ IllegalArgumentException -> 0x005d }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ IllegalArgumentException -> 0x005d }
            if (r6 == 0) goto L_0x0066
            boolean r0 = r6.booleanValue()     // Catch:{ IllegalArgumentException -> 0x005d }
            if (r0 == 0) goto L_0x0056
            boolean r7 = r7.lIlllIlIlI()     // Catch:{ IllegalArgumentException -> 0x005d }
            if (r7 == 0) goto L_0x0056
            java.lang.String r6 = "Samsung Phase AF is supported, but buggy on this device. Will not enabled it!"
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ IllegalArgumentException -> 0x005d }
            com.microblink.blinkbarcode.util.Log.m40231i(r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x005d }
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ IllegalArgumentException -> 0x005d }
        L_0x0056:
            boolean r6 = r6.booleanValue()     // Catch:{ IllegalArgumentException -> 0x005d }
            r5.IlIllIlIIl = r6     // Catch:{ IllegalArgumentException -> 0x005d }
            goto L_0x0066
        L_0x005d:
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r7 = "Unable to query device for PAF availability"
            com.microblink.blinkbarcode.util.Log.m40231i(r5, r7, r6)
            r5.IlIllIlIIl = r2
        L_0x0066:
            java.lang.Object[] r6 = new java.lang.Object[r1]
            boolean r7 = r5.IlIllIlIIl
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r6[r2] = r7
            java.lang.String r7 = "Samsung Phase AF supported: {}"
            com.microblink.blinkbarcode.util.Log.m40231i(r5, r7, r6)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.secured.IlIlIIllll.llIIlIlIIl(android.hardware.camera2.CameraCharacteristics, com.microblink.blinkbarcode.hardware.IllIIIllII):void");
    }

    public void llIIlIlIIl(CaptureRequest.Builder builder) {
        if (this.llIIlIlIIl) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        } else {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
        }
        if (this.IlIllIlIIl) {
            Log.m40227d(this, "Activating Samsung Phase AF", new Object[0]);
            builder.set(lIIIIIllIl.llIIlIlIIl, 1);
        }
    }

    public boolean llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r5.llIIIlllll.get() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        com.microblink.blinkbarcode.util.Log.m40233v(r5, "Focus state: Focused", new java.lang.Object[0]);
        r1 = r5.IllIIIllII;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        if (r1 == 3) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        if (r1 != 1) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        r7.onAutofocusStopped(r8.llIIlIlIIl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
        com.microblink.blinkbarcode.util.Log.m40233v(r5, "Focus state: Focus in progress...", new java.lang.Object[0]);
        r1 = r5.IllIIIllII;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        if (r1 == 3) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
        if (r1 == 1) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        r7.onAutofocusStarted(r8.llIIlIlIIl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        r5.IllIIIllII = r6.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a7, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean llIIlIlIIl(android.hardware.camera2.TotalCaptureResult r6, com.microblink.blinkbarcode.hardware.camera.AutofocusListener r7, com.microblink.blinkbarcode.secured.IlIIlllIll r8) {
        /*
            r5 = this;
            android.hardware.camera2.CaptureResult$Key r0 = android.hardware.camera2.CaptureResult.CONTROL_AF_STATE
            java.lang.Object r6 = r6.get(r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            r0 = 0
            if (r6 != 0) goto L_0x0013
            java.lang.Object[] r6 = new java.lang.Object[r0]
            java.lang.String r7 = "Focus state is null! This is a bug in device!"
            com.microblink.blinkbarcode.util.Log.wtf(r5, r7, r6)
            return r0
        L_0x0013:
            int r1 = r6.intValue()
            r2 = 3
            r3 = 1
            switch(r1) {
                case 0: goto L_0x008d;
                case 1: goto L_0x0078;
                case 2: goto L_0x0063;
                case 3: goto L_0x005b;
                case 4: goto L_0x003e;
                case 5: goto L_0x001e;
                case 6: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x00a1
        L_0x001e:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Unfocused"
            com.microblink.blinkbarcode.util.Log.m40233v(r5, r4, r1)
            int r1 = r5.IllIIIllII
            if (r1 == r2) goto L_0x002b
            if (r1 != r3) goto L_0x0035
        L_0x002b:
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStopped(r8)
            r7.onAutofocusFailed()
        L_0x0035:
            java.util.concurrent.atomic.AtomicBoolean r7 = r5.llIIIlllll
            boolean r7 = r7.get()
            if (r7 != 0) goto L_0x00a1
            goto L_0x0059
        L_0x003e:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Focus locked"
            com.microblink.blinkbarcode.util.Log.m40233v(r5, r4, r1)
            java.util.concurrent.atomic.AtomicBoolean r1 = r5.llIIIlllll
            boolean r1 = r1.get()
            if (r1 != 0) goto L_0x0063
            int r0 = r5.IllIIIllII
            r1 = 4
            if (r0 == r1) goto L_0x0059
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStopped(r8)
        L_0x0059:
            r0 = 1
            goto L_0x00a1
        L_0x005b:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Active scan in progress..."
            com.microblink.blinkbarcode.util.Log.m40233v(r5, r4, r1)
            goto L_0x0078
        L_0x0063:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Focused"
            com.microblink.blinkbarcode.util.Log.m40233v(r5, r4, r1)
            int r1 = r5.IllIIIllII
            if (r1 == r2) goto L_0x0070
            if (r1 != r3) goto L_0x00a1
        L_0x0070:
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStopped(r8)
            goto L_0x00a1
        L_0x0078:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Focus in progress..."
            com.microblink.blinkbarcode.util.Log.m40233v(r5, r4, r1)
            int r1 = r5.IllIIIllII
            if (r1 == r2) goto L_0x00a1
            if (r1 == r3) goto L_0x00a1
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStarted(r8)
            goto L_0x00a1
        L_0x008d:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "Focus state: Focus is currently inactive"
            com.microblink.blinkbarcode.util.Log.m40233v(r5, r4, r1)
            int r1 = r5.IllIIIllII
            if (r1 == r2) goto L_0x009a
            if (r1 != r3) goto L_0x00a1
        L_0x009a:
            android.graphics.Rect[] r8 = r8.llIIlIlIIl()
            r7.onAutofocusStopped(r8)
        L_0x00a1:
            int r6 = r6.intValue()
            r5.IllIIIllII = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.secured.IlIlIIllll.llIIlIlIIl(android.hardware.camera2.TotalCaptureResult, com.microblink.blinkbarcode.hardware.camera.AutofocusListener, com.microblink.blinkbarcode.secured.IlIIlllIll):boolean");
    }

    public void llIIlIlIIl(boolean z) {
        this.llIIIlllll.set(z);
    }
}

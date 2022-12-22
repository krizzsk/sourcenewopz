package com.microblink.blinkbarcode.util;

import android.content.Context;
import android.os.Build;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.hardware.MicroblinkDeviceManager;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;
import com.microblink.blinkbarcode.secured.IIIIlIllIl;

/* compiled from: line */
public class RecognizerCompatibility {
    private static RecognizerCompatibilityStatus llIIlIlIIl;

    public static boolean cameraHasAutofocus(CameraType cameraType, Context context) {
        int i = IllIIIllII.lIlIIIIlIl;
        if (Build.VERSION.SDK_INT >= 21) {
            return IIIIlIllIl.llIIlIlIIl(context.getApplicationContext(), cameraType);
        }
        return llIIlIlIIl(cameraType, context);
    }

    public static RecognizerCompatibilityStatus getRecognizerCompatibilityStatus(Context context) {
        Class<RecognizerCompatibility> cls = RecognizerCompatibility.class;
        if (llIIlIlIIl == null) {
            try {
                IlIllIlIIl.llIIlIlIIl();
                IllIIIllII.llIIlIlIIl(context, "microblink");
                IllIIIllII llIIlIIlll = IllIIIllII.llIIlIIlll();
                if (!MicroblinkDeviceManager.lIlIIIIlIl()) {
                    Log.m40229e(cls, "Device has ARMv7 processor without NEON support. These processors are not supported!", new Object[0]);
                    llIIlIlIIl = RecognizerCompatibilityStatus.PROCESSOR_ARCHITECTURE_NOT_SUPPORTED;
                } else if (Build.VERSION.SDK_INT < 16) {
                    Log.m40229e(cls, "Device is running an unsupported Android version!", new Object[0]);
                    llIIlIlIIl = RecognizerCompatibilityStatus.UNSUPPORTED_ANDROID_VERSION;
                } else if (llIIlIIlll.llIIlIlIIl()) {
                    llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED;
                } else {
                    Log.m40229e(cls, "Device does not have a camera", new Object[0]);
                    llIIlIlIIl = RecognizerCompatibilityStatus.NO_CAMERA;
                }
            } catch (Throwable th) {
                Log.m40230e(cls, th, "Unable to load native library. Native recognizer will not be supported!", new Object[0]);
                llIIlIlIIl = RecognizerCompatibilityStatus.PROCESSOR_ARCHITECTURE_NOT_SUPPORTED;
            }
        }
        return llIIlIlIIl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r9 != 2) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r6 != -1) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r6 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean llIIlIlIIl(com.microblink.blinkbarcode.hardware.camera.CameraType r9, android.content.Context r10) {
        /*
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo
            r0.<init>()
            int r1 = android.hardware.Camera.getNumberOfCameras()
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = -1
            r6 = -1
        L_0x000e:
            r7 = 1
            if (r4 >= r1) goto L_0x0021
            android.hardware.Camera.getCameraInfo(r4, r0)
            int r8 = r0.facing
            if (r8 == 0) goto L_0x001d
            if (r8 == r7) goto L_0x001b
            goto L_0x001e
        L_0x001b:
            r6 = r4
            goto L_0x001e
        L_0x001d:
            r5 = r4
        L_0x001e:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0021:
            int r9 = r9.ordinal()
            if (r9 == 0) goto L_0x002d
            if (r9 == r7) goto L_0x002f
            r0 = 2
            if (r9 == r0) goto L_0x0035
            goto L_0x0034
        L_0x002d:
            if (r5 == r3) goto L_0x0031
        L_0x002f:
            r6 = r5
            goto L_0x0035
        L_0x0031:
            if (r6 == r3) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r6 = -1
        L_0x0035:
            if (r6 != r3) goto L_0x0038
            return r2
        L_0x0038:
            if (r6 != r5) goto L_0x0045
            android.content.pm.PackageManager r9 = r10.getPackageManager()
            java.lang.String r10 = "android.hardware.camera.autofocus"
            boolean r9 = r9.hasSystemFeature(r10)
            return r9
        L_0x0045:
            android.hardware.Camera r9 = android.hardware.Camera.open(r6)     // Catch:{ RuntimeException -> 0x0067 }
            android.hardware.Camera$Parameters r10 = r9.getParameters()     // Catch:{ RuntimeException -> 0x0067 }
            java.util.List r10 = r10.getSupportedFocusModes()     // Catch:{ RuntimeException -> 0x0067 }
            java.lang.String r0 = "auto"
            boolean r0 = r10.contains(r0)     // Catch:{ RuntimeException -> 0x0067 }
            if (r0 != 0) goto L_0x0063
            java.lang.String r0 = "macro"
            boolean r10 = r10.contains(r0)     // Catch:{ RuntimeException -> 0x0067 }
            if (r10 == 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r7 = 0
        L_0x0063:
            r9.release()     // Catch:{ RuntimeException -> 0x0067 }
            return r7
        L_0x0067:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.util.RecognizerCompatibility.llIIlIlIIl(com.microblink.blinkbarcode.hardware.camera.CameraType, android.content.Context):boolean");
    }
}

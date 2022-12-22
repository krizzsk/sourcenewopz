package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class IIIIlIllIl {
    public static boolean IlIllIlIIl(Context context, CameraType cameraType) throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) context.getApplicationContext().getSystemService("camera");
        if (cameraManager == null) {
            Log.m40229e(IIlIlIIlll.class, "Cannot obtain camera manager from context!", new Object[0]);
            return false;
        }
        String llIIlIlIIl = llIIlIlIIl(cameraManager, cameraType);
        if (llIIlIlIIl == null) {
            Log.m40229e(IIlIlIIlll.class, "Cannot obtain information for camera type {}", cameraType);
            return false;
        }
        Integer num = (Integer) cameraManager.getCameraCharacteristics(llIIlIlIIl).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num == null) {
            Log.m40227d(IIlIlIIlll.class, "Supported hardware level is 'null'", new Object[0]);
            return false;
        }
        Class<IIlIlIIlll> cls = IIlIlIIlll.class;
        Object[] objArr = new Object[1];
        objArr[0] = num.intValue() == 1 ? "full" : num.intValue() == 0 ? "limited" : "legacy";
        Log.m40227d(cls, "Camera 2 supported HW level is '{}'", objArr);
        if (num.intValue() != 2) {
            return true;
        }
        return false;
    }

    public static boolean llIIlIlIIl(Context context, CameraType cameraType) {
        CameraManager cameraManager = (CameraManager) context.getApplicationContext().getSystemService("camera");
        boolean z = false;
        if (cameraManager == null) {
            Log.m40229e(IIlIlIIlll.class, "Cannot obtain camera manager from context!", new Object[0]);
            return false;
        }
        try {
            String llIIlIlIIl = llIIlIlIIl(cameraManager, cameraType);
            if (llIIlIlIIl == null) {
                Log.m40229e(IIlIlIIlll.class, "Cannot obtain information for camera type {}", cameraType);
                return false;
            }
            Float f = (Float) cameraManager.getCameraCharacteristics(llIIlIlIIl).get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
            if (f != null) {
                Log.m40231i(IIlIlIIlll.class, "{} minimum focus distance: {}", cameraType, f);
                if (f.floatValue() == 0.0f) {
                    z = true;
                }
            }
            return !z;
        } catch (CameraAccessException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0089, code lost:
        if (r5 != null) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String llIIlIlIIl(android.hardware.camera2.CameraManager r11, com.microblink.blinkbarcode.hardware.camera.CameraType r12) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String[] r2 = r11.getCameraIdList()     // Catch:{ AssertionError -> 0x00b7, NullPointerException -> 0x00ad, NumberFormatException -> 0x00a3, all -> 0x0098 }
            int r3 = r2.length
            r5 = r1
            r6 = r5
            r4 = 0
        L_0x000a:
            if (r4 >= r3) goto L_0x0085
            r7 = r2[r4]
            android.hardware.camera2.CameraCharacteristics r8 = r11.getCameraCharacteristics(r7)     // Catch:{ CameraAccessException -> 0x0064, AssertionError -> 0x005a, NullPointerException -> 0x0050, NumberFormatException -> 0x0046, all -> 0x003b }
            android.hardware.camera2.CameraCharacteristics$Key r9 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x0064, AssertionError -> 0x005a, NullPointerException -> 0x0050, NumberFormatException -> 0x0046, all -> 0x003b }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ CameraAccessException -> 0x0064, AssertionError -> 0x005a, NullPointerException -> 0x0050, NumberFormatException -> 0x0046, all -> 0x003b }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ CameraAccessException -> 0x0064, AssertionError -> 0x005a, NullPointerException -> 0x0050, NumberFormatException -> 0x0046, all -> 0x003b }
            if (r8 != 0) goto L_0x0026
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r8 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            java.lang.String r9 = "Obtained null value for lens facing info. This is a bug in device!"
            java.lang.Object[] r10 = new java.lang.Object[r0]     // Catch:{ CameraAccessException -> 0x0064, AssertionError -> 0x005a, NullPointerException -> 0x0050, NumberFormatException -> 0x0046, all -> 0x003b }
            com.microblink.blinkbarcode.util.Log.m40235w(r8, r9, r10)     // Catch:{ CameraAccessException -> 0x0064, AssertionError -> 0x005a, NullPointerException -> 0x0050, NumberFormatException -> 0x0046, all -> 0x003b }
            return r1
        L_0x0026:
            int r9 = r8.intValue()     // Catch:{ CameraAccessException -> 0x0064, AssertionError -> 0x005a, NullPointerException -> 0x0050, NumberFormatException -> 0x0046, all -> 0x003b }
            if (r9 != 0) goto L_0x0030
            if (r6 != 0) goto L_0x0082
            r6 = r7
            goto L_0x0082
        L_0x0030:
            int r8 = r8.intValue()     // Catch:{ CameraAccessException -> 0x0064, AssertionError -> 0x005a, NullPointerException -> 0x0050, NumberFormatException -> 0x0046, all -> 0x003b }
            r9 = 1
            if (r8 != r9) goto L_0x0082
            if (r5 != 0) goto L_0x0082
            r5 = r7
            goto L_0x0082
        L_0x003b:
            r11 = move-exception
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r0 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            java.lang.String r2 = "There was unhandled exception when calling getCameraCharacteristics. This is probably a bug in device!"
            com.microblink.blinkbarcode.util.Log.m40236w(r0, r11, r2, r12)
            return r1
        L_0x0046:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r12 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            java.lang.String r0 = "There was a NumberFormatException when calling getCameraCharacteristics. This is probably a bug in device!"
            com.microblink.blinkbarcode.util.Log.m40235w(r12, r0, r11)
            return r1
        L_0x0050:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r12 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            java.lang.String r0 = "There was a NullPointerException when calling getCameraCharacteristics. This is probably a bug in device!"
            com.microblink.blinkbarcode.util.Log.m40235w(r12, r0, r11)
            return r1
        L_0x005a:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r12 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            java.lang.String r0 = "There was assertion error when calling getCameraCharacteristics. This is probably a bug in device!"
            com.microblink.blinkbarcode.util.Log.m40235w(r12, r0, r11)
            return r1
        L_0x0064:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Unable to access camera with ID "
            r9.append(r10)
            r9.append(r7)
            java.lang.String r7 = ". Skipping it..."
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.Object[] r9 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r10 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            com.microblink.blinkbarcode.util.Log.m40230e(r10, r8, r7, r9)
        L_0x0082:
            int r4 = r4 + 1
            goto L_0x000a
        L_0x0085:
            com.microblink.blinkbarcode.hardware.camera.CameraType r11 = com.microblink.blinkbarcode.hardware.camera.CameraType.CAMERA_DEFAULT
            if (r12 != r11) goto L_0x008c
            if (r5 == 0) goto L_0x0096
            goto L_0x0090
        L_0x008c:
            com.microblink.blinkbarcode.hardware.camera.CameraType r11 = com.microblink.blinkbarcode.hardware.camera.CameraType.CAMERA_BACKFACE
            if (r12 != r11) goto L_0x0092
        L_0x0090:
            r1 = r5
            goto L_0x0097
        L_0x0092:
            com.microblink.blinkbarcode.hardware.camera.CameraType r11 = com.microblink.blinkbarcode.hardware.camera.CameraType.CAMERA_FRONTFACE
            if (r12 != r11) goto L_0x0097
        L_0x0096:
            r1 = r6
        L_0x0097:
            return r1
        L_0x0098:
            r11 = move-exception
            java.lang.Object[] r12 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r0 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            java.lang.String r2 = "There was unhandled exception when calling getCameraIdList. This is probably a bug in device!"
            com.microblink.blinkbarcode.util.Log.m40236w(r0, r11, r2, r12)
            return r1
        L_0x00a3:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r12 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            java.lang.String r0 = "There was a NumberFormatException when calling getCameraIdList. This is probably a bug in device!"
            com.microblink.blinkbarcode.util.Log.m40235w(r12, r0, r11)
            return r1
        L_0x00ad:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r12 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            java.lang.String r0 = "There was a NullPointerException when calling getCameraIdList. This is probably a bug in device!"
            com.microblink.blinkbarcode.util.Log.m40235w(r12, r0, r11)
            return r1
        L_0x00b7:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.Class<com.microblink.blinkbarcode.secured.IIlIlIIlll> r12 = com.microblink.blinkbarcode.secured.IIlIlIIlll.class
            java.lang.String r0 = "There was assertion error when calling getCameraIdList. This is probably a bug in device!"
            com.microblink.blinkbarcode.util.Log.m40235w(r12, r0, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.secured.IIIIlIllIl.llIIlIlIIl(android.hardware.camera2.CameraManager, com.microblink.blinkbarcode.hardware.camera.CameraType):java.lang.String");
    }
}

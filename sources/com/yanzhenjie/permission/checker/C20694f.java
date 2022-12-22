package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.hardware.Camera;

/* renamed from: com.yanzhenjie.permission.checker.f */
/* compiled from: CameraTest */
class C20694f implements PermissionTest {

    /* renamed from: b */
    private static final Camera.PreviewCallback f56182b = new CameraTest$1();

    /* renamed from: a */
    private Context f56183a;

    C20694f(Context context) {
        this.f56183a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        return true ^ r5.f56183a.getPackageManager().hasSystemFeature("android.hardware.camera");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r2 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        r2.stopPreview();
        r2.setPreviewCallback((android.hardware.Camera.PreviewCallback) null);
        r2.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0022 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo169065a() throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            android.hardware.Camera r2 = android.hardware.Camera.open()     // Catch:{ all -> 0x0021 }
            android.hardware.Camera$Parameters r3 = r2.getParameters()     // Catch:{ all -> 0x0022 }
            r2.setParameters(r3)     // Catch:{ all -> 0x0022 }
            android.hardware.Camera$PreviewCallback r3 = f56182b     // Catch:{ all -> 0x0022 }
            r2.setPreviewCallback(r3)     // Catch:{ all -> 0x0022 }
            r2.startPreview()     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x0020
            r2.stopPreview()
            r2.setPreviewCallback(r1)
            r2.release()
        L_0x0020:
            return r0
        L_0x0021:
            r2 = r1
        L_0x0022:
            android.content.Context r3 = r5.f56183a     // Catch:{ all -> 0x003b }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ all -> 0x003b }
            java.lang.String r4 = "android.hardware.camera"
            boolean r3 = r3.hasSystemFeature(r4)     // Catch:{ all -> 0x003b }
            r0 = r0 ^ r3
            if (r2 == 0) goto L_0x003a
            r2.stopPreview()
            r2.setPreviewCallback(r1)
            r2.release()
        L_0x003a:
            return r0
        L_0x003b:
            r0 = move-exception
            if (r2 == 0) goto L_0x0047
            r2.stopPreview()
            r2.setPreviewCallback(r1)
            r2.release()
        L_0x0047:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.permission.checker.C20694f.mo169065a():boolean");
    }
}

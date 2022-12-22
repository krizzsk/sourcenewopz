package com.iproov.sdk.cameray;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.iproov.sdk.cameray.C19771case;
import com.iproov.sdk.cameray.C19792try;
import java.util.ArrayList;
import p232do.C20818case;
import p232do.C20819do;
import p232do.C20822goto;
import p232do.C20823if;
import p232do.C20826try;

/* renamed from: com.iproov.sdk.cameray.goto */
/* compiled from: CameraFactoryImpl */
public class C19781goto implements C19778else {

    /* renamed from: com.iproov.sdk.cameray.goto$do */
    /* compiled from: CameraFactoryImpl */
    static /* synthetic */ class C19782do {

        /* renamed from: do */
        static final /* synthetic */ int[] f54046do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.iproov.sdk.cameray.const[] r0 = com.iproov.sdk.cameray.C19775const.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f54046do = r0
                com.iproov.sdk.cameray.const r1 = com.iproov.sdk.cameray.C19775const.CAMERA1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f54046do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.cameray.const r1 = com.iproov.sdk.cameray.C19775const.CAMERA2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.cameray.C19781goto.C19782do.<clinit>():void");
        }
    }

    /* renamed from: a */
    private C19779final m38716a(Context context) throws C19771case {
        ArrayList arrayList = new ArrayList();
        try {
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            if (cameraManager != null) {
                for (String str : cameraManager.getCameraIdList()) {
                    Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                    if (num != null) {
                        arrayList.add(new C20823if(arrayList.size(), m38714a(num.intValue()), str));
                    }
                }
            }
            return new C19779final(C19775const.CAMERA2, arrayList);
        } catch (CameraAccessException | RuntimeException e) {
            e.printStackTrace();
            throw new C19771case(C19771case.C19772do.CAMERA_ERROR, e.getLocalizedMessage());
        }
    }

    /* renamed from: do */
    public C19792try mo161915do(Context context, C20818case caseR, C19792try.C19793do doVar, C20826try tryR, C20822goto gotoR) throws C19771case {
        StringBuilder sb = new StringBuilder();
        sb.append("Camera selected: ");
        C20818case caseR2 = caseR;
        sb.append(caseR);
        if (caseR.mo170636if() != C19775const.CAMERA2) {
            return new C19776do(caseR.m47611new(), caseR.mo170634do(), doVar, tryR, gotoR);
        }
        return new C19783if(context, caseR.m47610for(), caseR.mo170634do(), doVar, tryR, gotoR);
    }

    /* renamed from: do */
    public C19773catch mo161913do(Context context) throws C19771case {
        C20818case a = m38716a(context).mo161916a();
        if (a == null) {
            return null;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(a.m47610for()).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                if (num != null) {
                    int intValue = num.intValue();
                    if (intValue == 0) {
                        return C19773catch.CAMERA2_LIMITED;
                    }
                    if (intValue == 1) {
                        return C19773catch.CAMERA2_FULL;
                    }
                    if (intValue == 2) {
                        return C19773catch.CAMERA2_LEGACY;
                    }
                    if (intValue == 3) {
                        return C19773catch.CAMERA2_LEVEL3;
                    }
                    if (intValue == 4) {
                        return C19773catch.CAMERA2_EXTERNAL;
                    }
                }
            } catch (CameraAccessException | RuntimeException e) {
                e.printStackTrace();
                throw new C19771case(C19771case.C19772do.CAMERA_ERROR, e.getLocalizedMessage());
            }
        }
        return C19773catch.CAMERA1;
    }

    /* renamed from: do */
    public C19779final mo161914do(Context context, C19775const constR) throws C19771case {
        if (constR == null) {
            return null;
        }
        int i = C19782do.f54046do[constR.ordinal()];
        if (i == 1) {
            return m38715a();
        }
        if (i != 2) {
            return null;
        }
        return m38716a(context);
    }

    /* renamed from: a */
    private C19779final m38715a() {
        C19768break breakR;
        ArrayList arrayList = new ArrayList();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                breakR = C19768break.f54006if;
            } else {
                breakR = C19768break.f54005do;
            }
            arrayList.add(new C20819do(i, breakR));
        }
        return new C19779final(C19775const.CAMERA1, arrayList);
    }

    /* renamed from: a */
    private C19768break m38714a(int i) {
        if (i == 0) {
            return C19768break.f54005do;
        }
        if (i != 2) {
            return C19768break.f54006if;
        }
        return C19768break.EXTERNAL;
    }
}

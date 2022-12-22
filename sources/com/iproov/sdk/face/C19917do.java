package com.iproov.sdk.face;

import android.content.Context;
import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.FaceDetectorException;
import p233else.C20829if;

/* renamed from: com.iproov.sdk.face.do */
/* compiled from: FaceDetectorFactoryProvider */
public class C19917do {

    /* renamed from: com.iproov.sdk.face.do$do */
    /* compiled from: FaceDetectorFactoryProvider */
    static /* synthetic */ class C19918do {

        /* renamed from: do */
        static final /* synthetic */ int[] f54358do;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.iproov.sdk.IProov$FaceDetector[] r0 = com.iproov.sdk.IProov.FaceDetector.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f54358do = r0
                com.iproov.sdk.IProov$FaceDetector r1 = com.iproov.sdk.IProov.FaceDetector.AUTO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f54358do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.IProov$FaceDetector r1 = com.iproov.sdk.IProov.FaceDetector.CLASSIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f54358do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.IProov$FaceDetector r1 = com.iproov.sdk.IProov.FaceDetector.BLAZEFACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f54358do     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.IProov$FaceDetector r1 = com.iproov.sdk.IProov.FaceDetector.ML_KIT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.face.C19917do.C19918do.<clinit>():void");
        }
    }

    /* renamed from: a */
    private static FaceDetectorFactory m39281a() {
        try {
            return (FaceDetectorFactory) Class.forName("com.iproov.sdk.face.MLKitFaceDetectorFactory").newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static FaceDetectorFactory m39282b() {
        return new C20829if();
    }

    /* renamed from: do */
    public static FaceDetectorFactory m39284do(Context context, IProov.Options.Capture capture) throws FaceDetectorException {
        int i = C19918do.f54358do[capture.faceDetector.ordinal()];
        if (i == 1) {
            FaceDetectorFactory a = m39281a();
            if (a != null) {
                return a;
            }
            FaceDetectorFactory c = m39283c();
            return c == null ? m39282b() : c;
        } else if (i == 2) {
            return m39282b();
        } else {
            if (i == 3) {
                FaceDetectorFactory c2 = m39283c();
                if (c2 != null) {
                    return c2;
                }
                throw new FaceDetectorException(context, "BlazeFace module not available");
            } else if (i != 4) {
                return null;
            } else {
                FaceDetectorFactory a2 = m39281a();
                if (a2 != null) {
                    return a2;
                }
                throw new FaceDetectorException(context, "ML Kit module not available. Please ensure you have added the iproov-mlkit module to your app. Visit https://github.com/iProov/android#-mlkit-support for further details.");
            }
        }
    }

    /* renamed from: c */
    private static FaceDetectorFactory m39283c() {
        try {
            return (FaceDetectorFactory) Class.forName("com.iproov.sdk.face.BlazeFaceDetectorFactory").newInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}

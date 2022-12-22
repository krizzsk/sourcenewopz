package com.didi.sec.algo;

import com.didi.safety.god.util.LogUtils;

public class AlgDetector {

    /* renamed from: a */
    private static final float f38513a = 0.03f;

    public native long GetModelVersion(int i);

    public native float calculatelightness(byte[] bArr, int i, int i2, int i3, boolean z);

    public native float[] detect(byte[] bArr, int i, int i2);

    public native boolean init(String str);

    public native boolean uninit();

    public native float[] yuvdetect(byte[] bArr, int i, int i2, int i3, boolean z);

    public native void yuvtoargb(byte[] bArr, int i, int i2, byte[] bArr2, int i3, boolean z);

    public RawDetectInfo detectYuv(byte[] bArr, int i, int i2) {
        RawDetectInfo rawDetectInfo;
        LogUtils.m24584i("detectYuv begin, width===" + i + ", height=" + i2);
        float[] yuvdetect = yuvdetect(bArr, i, i2, 0, false);
        if (yuvdetect == null || yuvdetect.length < 6) {
            rawDetectInfo = null;
        } else {
            rawDetectInfo = new RawDetectInfo();
            rawDetectInfo.label = (int) yuvdetect[4];
            rawDetectInfo.score = yuvdetect[5];
            rawDetectInfo.data = bArr;
            rawDetectInfo.qScore = yuvdetect.length >= 7 ? yuvdetect[6] : 1.0f;
            if (yuvdetect.length >= 9) {
                rawDetectInfo.bScore = yuvdetect[7];
                rawDetectInfo.rScore = yuvdetect[8];
            }
            float f = yuvdetect[0];
            float f2 = yuvdetect[1];
            float f3 = yuvdetect[2];
            float f4 = yuvdetect[3];
            float f5 = f3 - f;
            float f6 = f4 - f2;
            float f7 = (float) i;
            float f8 = (float) i2;
            float f9 = (((f5 * f6) * 1.0f) / f7) / f8;
            if (f9 <= 0.32f) {
                rawDetectInfo.disState = 1;
            } else if (f9 >= 0.8f) {
                rawDetectInfo.disState = 2;
            } else {
                rawDetectInfo.disState = 0;
            }
            float min = Math.min(f, f7 - f3);
            float min2 = Math.min(f2, f8 - f4);
            if (min / f7 < f38513a || min2 / f8 < f38513a) {
                rawDetectInfo.notCentered = true;
            }
            float f10 = (f5 * 0.0488f) / 2.0f;
            float f11 = (f6 * 0.0488f) / 2.0f;
            rawDetectInfo.f38514x1 = (int) Math.max(0.0f, f - f10);
            rawDetectInfo.f38516y1 = (int) Math.max(0.0f, f2 - f11);
            rawDetectInfo.f38515x2 = (int) Math.min(f3 + f10, f7);
            rawDetectInfo.f38517y2 = (int) Math.min(f4 + f11, f8);
        }
        LogUtils.m24584i("detectYuv finish, detectInfo===" + rawDetectInfo);
        return rawDetectInfo;
    }

    public RawDetectInfo detectArgb(byte[] bArr, int i, int i2) {
        RawDetectInfo rawDetectInfo;
        LogUtils.m24584i("detectArgb begin, width===" + i + ", height=" + i2);
        float[] detect = detect(bArr, i, i2);
        if (detect == null || detect.length < 6) {
            rawDetectInfo = null;
        } else {
            rawDetectInfo = new RawDetectInfo();
            int i3 = (int) detect[4];
            float f = detect[5];
            float f2 = 1.0f;
            if (detect.length >= 7) {
                f2 = detect[6];
            }
            rawDetectInfo.label = i3;
            rawDetectInfo.score = f;
            rawDetectInfo.qScore = f2;
            rawDetectInfo.data = bArr;
            if (detect.length >= 9) {
                rawDetectInfo.bScore = detect[7];
                rawDetectInfo.rScore = detect[8];
            }
            float f3 = detect[0];
            float f4 = detect[1];
            float f5 = detect[2];
            float f6 = detect[3];
            float f7 = ((f5 - f3) * 0.0488f) / 2.0f;
            float f8 = ((f6 - f4) * 0.0488f) / 2.0f;
            rawDetectInfo.f38514x1 = (int) Math.max(0.0f, f3 - f7);
            rawDetectInfo.f38516y1 = (int) Math.max(0.0f, f4 - f8);
            rawDetectInfo.f38515x2 = (int) Math.min(f5 + f7, (float) i);
            rawDetectInfo.f38517y2 = (int) Math.min(f6 + f8, (float) i2);
        }
        LogUtils.m24584i("detectArgb finish, result = " + rawDetectInfo);
        return rawDetectInfo;
    }

    static {
        try {
            System.loadLibrary("c++_shared");
        } catch (Throwable th) {
            LogUtils.logStackTrace(th);
        }
        try {
            System.loadLibrary("algdetector");
        } catch (UnsatisfiedLinkError e) {
            LogUtils.logStackTrace(e);
        }
    }
}

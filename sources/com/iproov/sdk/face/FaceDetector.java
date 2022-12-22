package com.iproov.sdk.face;

import android.graphics.Bitmap;
import com.iproov.sdk.IProov;
import com.iproov.sdk.face.model.FaceFeature;

public interface FaceDetector {
    public static final double FACE_TO_EYE_MULTIPLIER = 2.4d;

    /* renamed from: com.iproov.sdk.face.FaceDetector$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int calculateNormalisationFactor(int i, int i2) {
            return Math.min(i, i2);
        }
    }

    FaceFeature detectFace(Bitmap bitmap);

    IProov.FaceDetector getFaceDetector();

    void release();

    void setOmega(double d);
}

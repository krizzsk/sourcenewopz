package com.jumio.jvision.jvimgjava.swig;

import com.jumio.jvision.jvcorejava.swig.ImageSource;

public class ImageQualityAcquisition {

    /* renamed from: a */
    public transient long f55071a;
    public transient boolean swigCMemOwn;

    public ImageQualityAcquisition(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55071a = j;
    }

    public static float Evaluate(ImageSource imageSource) {
        return JVImgJavaJNI.ImageQualityAcquisition_Evaluate(ImageSource.getCPtr(imageSource), imageSource);
    }

    public static long getCPtr(ImageQualityAcquisition imageQualityAcquisition) {
        if (imageQualityAcquisition == null) {
            return 0;
        }
        return imageQualityAcquisition.f55071a;
    }

    public synchronized void delete() {
        if (this.f55071a != 0) {
            if (!this.swigCMemOwn) {
                this.f55071a = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
    }
}

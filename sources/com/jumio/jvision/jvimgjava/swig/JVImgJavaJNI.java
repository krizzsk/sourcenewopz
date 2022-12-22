package com.jumio.jvision.jvimgjava.swig;

import com.jumio.jvision.jvcorejava.swig.ImageSource;

public class JVImgJavaJNI {
    public static final native float ImageCheck_computeFlashConfidence(long j, ImageSource imageSource);

    public static final native boolean ImageCheck_isFlashNeeded(long j, ImageSource imageSource, int i);

    public static final native boolean ImageCheck_isRefocusNeeded(long j, ImageSource imageSource, int i);

    public static final native float ImageQualityAcquisition_Evaluate(long j, ImageSource imageSource);

    public static final native void delete_ImageCheck(long j);

    public static final native long new_ImageCheck();
}

package com.jumio.core;

import com.jumio.commons.log.Log;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import com.jumio.jvision.jvimgjava.swig.ImageQualityAcquisition;

public class ImageQuality {
    public static final float FOCUS_THRESHOLD = 0.12f;

    public static float calculateFocus(ImageSource imageSource) {
        try {
            return ImageQualityAcquisition.Evaluate(imageSource);
        } catch (Exception e) {
            Log.m39477w("ImageCheck", "computeFocusConfidence failed!", (Throwable) e);
            return -1.0f;
        }
    }
}

package com.facebook.drawee.backends.pipeline.info;

import com.adyen.checkout.components.status.api.StatusResponseUtils;

public class ImagePerfUtils {
    public static String toString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "error" : StatusResponseUtils.RESULT_CANCELED : "success" : "intermediate_available" : "origin_available" : "requested";
    }

    private ImagePerfUtils() {
    }
}

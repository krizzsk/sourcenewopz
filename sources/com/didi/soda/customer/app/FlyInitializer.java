package com.didi.soda.customer.app;

import android.content.Context;
import com.didi.app.nova.skeleton.image.Fly;
import com.didi.app.nova.skeleton.image.performance.ImagePerformance;
import com.didi.app.nova.skeleton.image.performance.ImagePerformanceListener;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.sofa.utils.CommonUtils;

public final class FlyInitializer {
    private FlyInitializer() {
    }

    public static void init(Context context) {
        Fly.setup(context);
        Fly.setmImagePerformanceListener(new ImagePerformanceListener() {
            public void onImagePerformance(ImagePerformance imagePerformance) {
                int imageCacheType = getImageCacheType(imagePerformance);
                LogUtil.m29100d("onImagePerformance", " type: " + imagePerformance.type + " totalTime: " + imagePerformance.totalTime + " isFromMemoryCache: " + imagePerformance.isFromMemoryCache + " imageCacheType: " + imageCacheType + " url: " + imagePerformance.url);
                PerformanceOmegaHelper.getInstance().trackImagePerformance(imagePerformance.url, imagePerformance.totalTime, imageCacheType);
            }

            private int getImageCacheType(ImagePerformance imagePerformance) {
                if (CommonUtils.equals(imagePerformance.type, "network")) {
                    return imagePerformance.isFromMemoryCache ? 2 : 0;
                }
                return -1;
            }
        });
    }
}

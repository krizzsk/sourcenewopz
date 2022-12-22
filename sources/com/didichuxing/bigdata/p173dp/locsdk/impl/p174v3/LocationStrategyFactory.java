package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationStrategyFactory */
public class LocationStrategyFactory {
    private LocationStrategyFactory() {
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationStrategyFactory$SingletonHolder */
    private static class SingletonHolder {
        static LocationStrategyFactory INSTANCE = new LocationStrategyFactory();

        private SingletonHolder() {
        }
    }

    public static LocationStrategyFactory getIntance() {
        return SingletonHolder.INSTANCE;
    }

    public C15136c createLocationStrategy(Context context, int i) {
        if (i == 0) {
            DLog.m32737d("loc type wgs84");
            return new C15135b(context);
        }
        DLog.m32737d("loc type gcj02");
        return new C15135b(context);
    }
}

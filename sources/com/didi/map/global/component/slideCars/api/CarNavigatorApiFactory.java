package com.didi.map.global.component.slideCars.api;

import android.content.Context;

public class CarNavigatorApiFactory {

    /* renamed from: com.didi.map.global.component.slideCars.api.CarNavigatorApiFactory$1 */
    static /* synthetic */ class C95941 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$global$component$slideCars$api$ApiType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.map.global.component.slideCars.api.ApiType[] r0 = com.didi.map.global.component.slideCars.api.ApiType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$global$component$slideCars$api$ApiType = r0
                com.didi.map.global.component.slideCars.api.ApiType r1 = com.didi.map.global.component.slideCars.api.ApiType.MULTI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$global$component$slideCars$api$ApiType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.slideCars.api.ApiType r1 = com.didi.map.global.component.slideCars.api.ApiType.SINGLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.slideCars.api.CarNavigatorApiFactory.C95941.<clinit>():void");
        }
    }

    public static ICarNavigatorApi createCarNavigator(Context context, ApiType apiType) {
        if (context == null) {
            throw new RuntimeException("context is null");
        } else if (C95941.$SwitchMap$com$didi$map$global$component$slideCars$api$ApiType[apiType.ordinal()] != 1) {
            return new SingleCarNavigatorImpl(context);
        } else {
            return new MultiCarNavigatorImpl(context);
        }
    }
}

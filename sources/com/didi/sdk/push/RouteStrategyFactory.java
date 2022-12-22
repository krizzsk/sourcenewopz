package com.didi.sdk.push;

class RouteStrategyFactory {
    RouteStrategyFactory() {
    }

    /* renamed from: com.didi.sdk.push.RouteStrategyFactory$1 */
    static /* synthetic */ class C129561 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$push$RouteType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.sdk.push.RouteType[] r0 = com.didi.sdk.push.RouteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$push$RouteType = r0
                com.didi.sdk.push.RouteType r1 = com.didi.sdk.push.RouteType.RANDOM_ADDRESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$push$RouteType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.push.RouteType r1 = com.didi.sdk.push.RouteType.MULTI_ADDRESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$push$RouteType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.push.RouteType r1 = com.didi.sdk.push.RouteType.FIRST_ADDRESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.push.RouteStrategyFactory.C129561.<clinit>():void");
        }
    }

    static IRouteStrategy create(RouteType routeType) {
        int i = C129561.$SwitchMap$com$didi$sdk$push$RouteType[routeType.ordinal()];
        if (i == 1) {
            return new RandomRouteStrategy();
        }
        if (i == 2) {
            return new MultiRouteStrategy();
        }
        if (i != 3) {
            return null;
        }
        return new FirstRouteStrategy();
    }
}

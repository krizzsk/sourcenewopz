package com.didi.common.map;

import com.didi.common.map.internal.IMapAvailabilityDelegate;
import com.didi.common.map.util.DLog;
import com.didi.map.constant.StringConstant;

public class MapApiDelegateFactory {

    /* renamed from: com.didi.common.map.MapApiDelegateFactory$1 */
    static /* synthetic */ class C44511 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.common.map.MapVendor[] r0 = com.didi.common.map.MapVendor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$MapVendor = r0
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.HUAWEI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.common.map.MapApiDelegateFactory.C44511.<clinit>():void");
        }
    }

    public static IMapAvailabilityDelegate create(MapVendor mapVendor) {
        int i = C44511.$SwitchMap$com$didi$common$map$MapVendor[mapVendor.ordinal()];
        if (i == 1) {
            try {
                Object invoke = Class.forName("com.didi.common.map.adapter.googlemapadapter.util.GoogleApiAvailability").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
                if (invoke instanceof IMapAvailabilityDelegate) {
                    return (IMapAvailabilityDelegate) invoke;
                }
            } catch (Exception e) {
                DLog.m7384d(StringConstant.META_NAME, e.toString(), new Object[0]);
                return null;
            }
        } else if (i == 2) {
            try {
                Object invoke2 = Class.forName("com.didi.common.map.adapter.hmsadapter.HmsApiAvailability").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
                if (invoke2 instanceof IMapAvailabilityDelegate) {
                    return (IMapAvailabilityDelegate) invoke2;
                }
            } catch (Exception e2) {
                DLog.m7384d(StringConstant.META_NAME, e2.toString(), new Object[0]);
                return null;
            }
        }
        return null;
    }
}
